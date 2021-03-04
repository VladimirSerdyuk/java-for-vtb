package ru.geekbrains.lesson09.jvm_gc_jdbc;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.*;

public class MainApp {
    private static Connection connection;
    private static Statement stmt;
    private static PreparedStatement psInsert;
    static final String DB_URL = "jdbc:postgresql://127.0.0.1:5432/postgres";
    static final String USER = "postgres";
    static final String PASS = "Password";

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, SQLException {
        Student student1 = new Student(101, "Иванов", "Иван", 30, "Male", 100, "РФ");
        try {
            connect();
            sendInsertQueryToDatabase(Student.class, student1);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
    }

    public static void sendInsertQueryToDatabase(Class cl, Object object) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, SQLException {
        connection.setAutoCommit(false);
        if (!cl.isAnnotationPresent(DbTable.class)) {
            throw new RuntimeException("Для класса " + cl.getSimpleName() + " невозможно сформировать запрос типа \"INSERT\", т.к. на нём осутствует аннотация типа \"" + DbTable.class.getSimpleName() + "\".");
        }
        StringBuilder sqlQuery = new StringBuilder();
        sqlQuery.append("INSERT INTO ");
        sqlQuery.append(((DbTable) cl.getAnnotation(DbTable.class)).title());
        sqlQuery.append(" VALUES ('");
        Field[] fields = cl.getDeclaredFields();
        int count = 0;
        for (Field f : fields) {
            if (f.isAnnotationPresent(DbId.class) && DbId.class.getSimpleName().equals("DbId")) {
                count++;
            }
        }
        if (!(count > 0)) {
            throw new RuntimeException("Для класса " + cl.getSimpleName() + " невозможно сформировать запрос типа \"INSERT\", т.к. у него отсутствует обязательное поле \"Id\".");
        }

        //System.out.println(Arrays.toString(fields));

        for (Field f : fields) {
            //System.out.println(f.getName());
            if (f.isAnnotationPresent(DbId.class) || f.isAnnotationPresent(DbColumn.class)) {
                //String methodName = "get"+f.getName().charAt(1);
                //Method method = cl.getDeclaredMethod(methodName);
                //method.invoke(object);
                Character firstLetter = f.getName().charAt(0);
                String methodName = "get" + firstLetter.toString().toUpperCase() + f.getName().substring(1, f.getName().length());
                //System.out.println(methodName);
                Method method = cl.getDeclaredMethod(methodName);
                //System.out.println(method.invoke(object));
                sqlQuery.append(method.invoke(object)).append("','");
            }
        }
        sqlQuery.setLength(sqlQuery.length() - 2);
        sqlQuery.append(");");
        int rows = stmt.executeUpdate(String.valueOf(sqlQuery));
        System.out.println("Количество успешно добавленных в БД записей: " + rows);
        connection.setAutoCommit(true);
    }

    public static void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection(DB_URL, USER, PASS);
        stmt = connection.createStatement();
    }

    public static void disconnect() {
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (psInsert != null) {
                psInsert.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}