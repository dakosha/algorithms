package core;

/**
 * @author Dauren Mussa
 * @since 2/10/18
 */
public class AbstractTest {

    private Two abstractTest;

    public AbstractTest() {
        this.abstractTest = new Two();
        Two.OneInTwo object = this.abstractTest.new OneInTwo();
        Two.OneInTwo.TwoInTwo.ThreeInTwo obj = object.new TwoInTwo().new ThreeInTwo();

        System.out.println(obj.getNumber());
    }

    public Two getTwo() {
        return abstractTest;
    }

    static abstract class Base extends AbstractTest {
        abstract int getNumber();
    }

    static class One extends Base {

        public One() {

        }

        public static void main(String[] args) {
            One one = new One();
        }

        @Override
        int getNumber() {
            return 10;
        }

    }

    public class Two {

        public class OneInTwo {

            public class TwoInTwo {

                public class ThreeInTwo {
                    public int getNumber() {
                        return 5;
                    }
                }
            }

        }

    }

}
