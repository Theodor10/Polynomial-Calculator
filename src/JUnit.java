import static org.junit.Assert.*;

import model.Polynomial;
import org.junit.*;


public class JUnit{

    @Test
    public void testAdunari() {
        String[] a = {
                "3X^2+1X^1+2X^0",
                "4X^1+24X^23+1X^0",
                "2X^1-2X^0+690X^344",
                "1X^1"
        };
        String[] b = {
                "3X^2+1X^1+2X^0",
                "4X^1+24X^23+1X^0",
                "2X^1-2X^0+690X^344",
                "1X^1"
        };
        String[] results = {
                "+6.0X^2+2.0X^1+4.0",
                "+8.0X^1+48.0X^23+2.0",
                "+4.0X^1-4.0+1380.0X^344",
                "+2.0X^1"
        };

        for(int i = 0; i < results.length; ++i)
            assertEquals(results[i], Polynomial.adunare(new Polynomial(a[i]), new Polynomial(b[i])).toString());
    }
    @Test
    public void testScaderi() {
        String[] a = {
                "3X^2+1X^1+2X^0",
                "4X^1+24X^23+1X^0",
                "2X^1-2X^0+690X^344",
                "2X^0"
        };
        String[] b = {
                "-3X^2+1X^1+2X^0",
                "4X^1+24X^23-1X^0",
                "2X^1+2X^0-690X^344",
                "3X^0"
        };
        String[] results = {
                "+6.0X^2",
                "+2.0",
                "-4.0+1380.0X^344",
                "-1.0"
        };

        for(int i = 0; i < results.length; ++i)
            assertEquals(results[i], Polynomial.scadere(new Polynomial(a[i]), new Polynomial(b[i])).toString());
    }
    @Test
    public void testMultiplicare() {
        String[] a = {
                "3X^2+1X^0+2X^1+1X^0",
                "4X^1+24X^23-1X^0",
                "2X^1+2X^0-690X^20",
                "-2X^1"
        };
        String[] b = {
                "3X^2+1X^0+2X^1+1X^0",
                "4X^1+24X^23-1X^0",
                "2X^1+2X^0-690X^20",
                "-2X^1"
        };
        String[] results = {
                "+9.0X^4+16.0X^2+12.0X^3+4.0+8.0X^1",
                "+16.0X^2+192.0X^24-8.0X^1+576.0X^46-48.0X^23+1.0",
                "+4.0X^2+8.0X^1-2760.0X^21+4.0-2760.0X^20+476100.0X^40",
                "+4.0X^2"
        };

        for(int i = 0; i < results.length; ++i)
            assertEquals(results[i], Polynomial.produs(new Polynomial(a[i]), new Polynomial(b[i])).toString());
    }
    @Test
    public void testIntegration() {
        String[] expressions = {
                "3X^2+1X^1+2X^0",
                "4X^1+24X^23+1X^0",
                "2X^1-2X^0+690X^344",
                "1X^0"
        };
        String[] results = {
                "+1.0X^3+0.5X^2+2.0X^1",
                "+2.0X^2+1.0X^24+X",
                "+1.0X^2-2.0X^1+2.0X^345",
                "+X"
        };

        for(int i = 0; i < expressions.length; ++i)
            assertEquals(results[i], Polynomial.integrare(new Polynomial(expressions[i])).toString());
    }

    @Test
    public void testDerivation() {
        String[] expressions = {
                "3X^2+1X^1+2X^0",
                "4X^1+24X^23+1X^0",
                "2X^1-2X^0+690X^344",
                "2X^1"
        };
        String[] results = {
                "+6.0X^1+1.0",
                "+4.0+552.0X^22",
                "+2.0+237360.0X^343",
                "+2.0",
        };

        for(int i = 0; i < expressions.length; ++i)
            assertEquals(results[i], Polynomial.derivare(new Polynomial(expressions[i])).toString());
    }

}