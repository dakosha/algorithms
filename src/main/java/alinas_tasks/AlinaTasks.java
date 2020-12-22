package alinas_tasks;

public class AlinaTasks {

    public static void main(String[] args) {

        int n = 550;
        System.out.println(test1(n));
    }

    public static boolean test1(int n) {
        int first = n / 1000;
        int second = (n - first*1000) / 100;
        int third = (n - first*1000 - second*100) / 10;
        int fourth = (n % 10);

        return (first == fourth && second == third);
    }

}
