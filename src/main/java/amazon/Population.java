package amazon;

import java.util.Arrays;
import java.util.List;

/**
 * @author Dauren Mussa
 * @since 2/5/18
 */
public class Population {

    public static void main(String[] args) {
        Person[] persons = {
                new Person(1901, 1910),
                new Person(1902, 1940),
                new Person(1909, 1960),
                new Person(1920, 1980),
                new Person(1921, 1990),
                new Person(1930, 1945)
        };

        System.out.println(calculateYear(persons));
    }

    static class Person {
        public int birth, death;

        public Person(int birth, int death) {
            this.birth = birth;
            this.death = death;
        }
    }

    public static int calculateWithSort(Person[] persons) {
        int[] birthYears = sort(persons, true);
        int[] deathYears = sort(persons, false);

        int indexBirth = 0;
        int indexDeath = 0;
        int maxAlive = 0;
        int maxAliveYear = 0;

        int currentAlive = 0;

        while (indexBirth < birthYears.length) {
            if (birthYears[indexBirth] <= deathYears[indexDeath]) {
                currentAlive++;
                if (currentAlive>maxAlive) {
                    maxAlive  = currentAlive;
                    maxAliveYear = birthYears[indexBirth];
                }
                indexBirth++;
            } else {
                currentAlive--;
                indexDeath++;
            }
        }

        return maxAliveYear;
    }

    private static int[] sort(Person[] persons, boolean b) {
        int[] result = new int[persons.length];
        for (int i=0; i<result.length; i++) {
            result[i] = b ? persons[i].birth : persons[i].death;
        }
        Arrays.sort(result);
        return result;
    }

    public static int calculateYear(Person[] persons) {
        return calculateWithSort(persons);
    }

}
