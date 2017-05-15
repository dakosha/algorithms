package codewar;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Dauren Mussa
 * @since 12/19/16
 */
public class Slope {

    public String slope(int[] points) {

        if (Math.abs(points[2] - points[0]) == 0) {
            return "undefined";
        }
        int k = (points[3] - points[1]) / (points[2] - points[0]);
        return String.valueOf(k);
    }

    @Test
    public void test1()
    {
        int[] test1={19,3,20,3};
        Slope s=new Slope();
        assertEquals("0",s.slope(test1));

        assertEquals("undefined",s.slope(new int[]{-7, 2, -7, 4}));
        assertEquals("5",s.slope(new int[]{10,50,30,150}));
        assertEquals("-5",s.slope(new int[]{15,45,12,60}));
        assertEquals("6",s.slope(new int[]{10,20,20,80}));
        assertEquals("undefined",s.slope(new int[]{-10,6,-10,3}));
    }

}
