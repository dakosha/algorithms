package leetcode;

/**
 * @author Dauren Mussa
 * @since 11/30/17
 */
public class Bricks {

    public static void main(String[] args) {
        Bricks bricks = new Bricks();

        System.out.println(bricks.makeBricksRecursive(3, 1, 7));

    }

    public boolean makeBricks(int small, int big, int goal) {
        int bigAmount = goal/5;
        if (bigAmount == big && (goal % 5 ==0 || goal % 5 <= small)) return true;

        if (bigAmount > big) {
            if (goal - (big*5) <= small) {
                return true;
            }
        } else if (bigAmount < big) {
            int left = goal - (bigAmount * 5);
            if (left <= small) {
                return true;
            }
        }

        return false;
    }

    public boolean makeBricksRecursive(int small, int big, int goal) {
        if (goal == 0) return true;
        else {
            boolean result = false;
            if (goal>=5 && big>0) {
                int newGoal = goal;
                int newBig = big;
                while (newGoal>=5 && newBig>0) {
                    newGoal-=5;
                    newBig-=1;
                }
                result = makeBricksRecursive(small, newBig, newGoal);
            }
            if (goal>0 && small>0) {
                int newGoal = goal;
                int newSmall = small;
                while (newGoal>0 && newSmall>0) {
                    newGoal-=1;
                    newSmall-=1;
                }
                result = result || makeBricksRecursive(newSmall, big, newGoal);
            }
            return result;
        }
    }

    public int loneSum(int a, int b, int c) {
        if (a==b && a==c) return 0;
        if (a==b) return c;
        if (a==c) return b;
        if (b==c) return a;
        return a+b+c;
    }

}
