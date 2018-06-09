package core;

import java.util.Arrays;

/**
 * @author Dauren Mussa
 * @since 5/25/18
 */
public class MainTttt {

    public static void main(String[] args) {

        ClassInt classInt = new ClassInt("Daka");

        System.out.println(classInt.val);

        change(classInt);

        System.out.println(classInt.val);

        int[] x = {1, 2, 3};

        System.out.println(Arrays.toString(x));

        change(x);

        System.out.println(Arrays.toString(x));

        change1(x);

        System.out.println(Arrays.toString(x));

    }

    public static void change(int[] data) {
        data[1] = 123;
    }

    public static void change1(int[] data) {
        int[] val = {3, 2, 1};
    }

    public static void change(ClassInt classInt) {
        System.out.println(classInt.val);

        classInt = new ClassInt("Vlad");

        System.out.println(classInt.val);
    }

    static class ClassInt {

        String val;

        public ClassInt(String val) {
            this.val = val;
        }

    }

}
