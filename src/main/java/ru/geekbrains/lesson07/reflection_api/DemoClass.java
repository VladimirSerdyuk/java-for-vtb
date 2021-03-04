package ru.geekbrains.lesson07.reflection_api;

public class DemoClass {
    @BeforeSuite
    public static void beforeSuite1() {
        System.out.println("Произведено выполнение теста BeforeSuite 1");
    }

//    @BeforeSuite
//    public static void beforeSuite2 (){
//        System.out.println("Произведено выполнение теста BeforeSuite 2");
//    }

    @Test(priority = 10)
    public static void test1() {
        System.out.println("Произведено выполнение теста №1");
    }

    @Test
    public static void test2() {
        System.out.println("Произведено выполнение теста №2");
    }

    @Test(priority = 3)
    public static void test3() {
        System.out.println("Произведено выполнение теста №3");
    }

    @Test
    public static void test4() {
        System.out.println("Произведено выполнение теста №4");
    }

    @Test
    public static void test5() {
        System.out.println("Произведено выполнение теста №5");
    }

    @Test(priority = 6)
    public static void test6() {
        System.out.println("Произведено выполнение теста №6");
    }

    @Test(priority = 7)
    public static void test7() {
        System.out.println("Произведено выполнение теста №7");
    }

    @Test(priority = 8)
    public static void test8() {
        System.out.println("Произведено выполнение теста №8");
    }

    @Test(priority = 9)
    public static void test9() {
        System.out.println("Произведено выполнение теста №9");
    }

    @Test(priority = 1)
    public static void test10() {
        System.out.println("Произведено выполнение теста №10");
    }

    @AfterSuite
    public static void afterSuite1() {
        System.out.println("Произведено выполнение теста AfterSuite 1");
    }

//    @AfterSuite
//    public static void afterSuite2 (){
//        System.out.println("Произведено выполнение теста AfterSuite 2");
//    }
}
