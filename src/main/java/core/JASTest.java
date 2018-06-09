package core;

import edu.jas.arith.BigRational;
import edu.jas.gb.GroebnerBase;
import edu.jas.gbufd.GBFactory;
import edu.jas.poly.GenPolynomial;
import edu.jas.poly.GenPolynomialTokenizer;
import edu.jas.poly.PolynomialList;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.List;

/**
 * @author Dauren Mussa
 * @since 5/25/18
 */
public class JASTest {

    public static void main(String[] args) {

        exampleGB1();


    }

    static public void exampleGB1() {
        BigRational coeff = new BigRational();
        GroebnerBase<BigRational> gb = GBFactory.getImplementation(coeff);

        String exam = "(x1,x2,y) G " + "( " + "( x1 + x2 - 10 ), ( 2 x1 - x2 + 4 ) " + ") ";
        Reader source = new StringReader(exam);
        GenPolynomialTokenizer parser = new GenPolynomialTokenizer(source);
        PolynomialList<BigRational> F = null;

        try {
            F = (PolynomialList<BigRational>) parser.nextPolynomialSet();
        } catch (ClassCastException e) {
            e.printStackTrace();
            return;
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        System.out.println("F = " + F);

        List<GenPolynomial<BigRational>> G = gb.GB(F.list);

        PolynomialList<BigRational> trinks = new PolynomialList<BigRational>(F.ring, G);
        System.out.println("G = " + trinks);
    }

}
