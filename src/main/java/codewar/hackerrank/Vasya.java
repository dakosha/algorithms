package codewar.hackerrank;

import scala.Int;

import java.util.Scanner;

/**
 * @author Dauren Mussa
 * @since 4/29/17
 */
public class Vasya {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] results = new int[n];

        for (int i = 0; i < n; i++) {

            int soldiers = scanner.nextInt();
            int HEALTH = scanner.nextInt();
            int ATTACK = scanner.nextInt();

            int health[] = new int[soldiers];
            int attack[] = new int[soldiers];

            for (int j = 0; j < soldiers; j++) {
                health[j] = scanner.nextInt();
                attack[j] = scanner.nextInt();
            }

            result(soldiers, health, attack, HEALTH, ATTACK);
            results[i] = aliveCount(health);
        }

        for (int i = 0; i < n; i++) {
            System.out.println(results[i]);
        }

    }

    private static int aliveCount(int[] health) {
        int count = 0;
        for (int i = 0; i < health.length; i++) {
            if (health[i] <= 0) {
                count++;
            }
        }
        if (count == health.length)
            count = -1;
        return count;
    }

    private static int getCurrentSoldier(int[] health, int[] attack, int ATTACK) {
        int max = Integer.MIN_VALUE;
        int current = -1;
        for (int i = 0; i < health.length; i++) {
            if (max < attack[i] && health[i] > ATTACK) {
                max = attack[i];
                current = i;
            }
        }
        if (current == -1) {
            max = Integer.MIN_VALUE;
            for (int i = 0; i < health.length; i++) {
                if (max < attack[i] && health[i] > 0) {
                    max = attack[i];
                    current = i;
                }
            }
        }
        return current;
    }

    private static void result(int m, int[] health, int[] attack, int HEALTH, int ATTACK) {
        while (HEALTH > 0) {
            int current = getCurrentSoldier(health, attack, ATTACK);
            if (current < 0) {
                return;
            }
            HEALTH = HEALTH - attack[current];
            if (HEALTH <= 0) {
                return;
            }
            health[current] = health[current] - ATTACK;
        }
    }

}
