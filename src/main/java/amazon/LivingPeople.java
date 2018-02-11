package amazon;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Dauren Mussa
 * @since 1/28/18
 */
public class LivingPeople {

    public static void main(String[] args) {
        List<Person> personList = new LinkedList<>();
        personList.add(new Person(1908, 1960));
        personList.add(new Person(1900, 1950));
        personList.add(new Person(1901, 1920));
        personList.add(new Person(1923, 1960));
        personList.add(new Person(1933, 1980));
        personList.add(new Person(1912, 1990));
        personList.add(new Person(1909, 1969));
        personList.add(new Person(1913, 1953));
        personList.add(new Person(1927, 1945));
        personList.add(new Person(1933, 1962));
        System.out.println(calculateYear(personList));
    }

    private static int calculateYear(List<Person> personList) {
        //
        return 0;
    }

    static class Person {
        Person(int birth, int death){
            this.birth = birth;
            this.death = death;
        }
        int birth;
        int death;
    }

}
