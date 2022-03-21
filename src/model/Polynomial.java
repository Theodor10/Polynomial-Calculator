package model;

import java.util.List;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polynomial {


    private List<Monomial> polynomial;

    public Polynomial() {
        polynomial = new ArrayList<Monomial>();
    }

    public Polynomial(String text) {
        this();
        if(text.charAt(0) != '+' && text.charAt(0) != '-') {
            text = "+" + text;
        }
        String MonomialialFormat = "([+-](?:\\d+X\\^\\d+))";
        String MonomialialPartsFormat = "([+-]?(?:\\d+))";
        Pattern p1 = Pattern.compile(MonomialialFormat);
        Matcher m1 = p1.matcher(text);
        while (!m1.hitEnd()) {
            m1.find();
            Pattern p2 = Pattern.compile(MonomialialPartsFormat);
            Matcher m2 = p2.matcher(m1.group());
            System.out.println(m1.group());
            int coefficient = 0;
            int exponent = 0;
            if (m2.find()) {
                System.out.println(m2.group());
                coefficient = Integer.parseInt(m2.group());
            }
            if (m2.find()) {
                System.out.println(m2.group());
                exponent = Integer.parseInt(m2.group());
            }
            Monomial b = new Monomial(coefficient, exponent);
            polynomial.add(b);
        }
    }

    public static Polynomial adunare(Polynomial pol1, Polynomial pol2) {
        Monomial rezMonomial;
        Polynomial rezultatPol = new Polynomial();

        for (Monomial m1 : pol1.getPolynomial()) {                                                                                                // parcurgere pol1 si pol2
            for (Monomial m2 : pol2.getPolynomial()) {
                if (m1.getExponent() == m2.getExponent())                                                    // verificare egalitate intre exponenti
                {
                    m1.setParcurs(true);                                                                    // s-a gasit Monomial cu acelasi coeficient
                    m2.setParcurs(true);
                    rezMonomial = new Monomial(m1.getCoeficient() + m2.getCoeficient(), m1.getExponent());
                    rezultatPol.add(rezMonomial);
                }
            }
        }

        for (Monomial m1 : pol1.getPolynomial()) {
            if (m1.getParcurs() == false)                                                                    // in caz ca nu s-a gasit un Monomial cu acelasi coeficient
                rezultatPol.add(m1);                                                                        // se adauga si acel Monomial, singur
        }

        for (Monomial m2 : pol2.getPolynomial()) {
            if (m2.getParcurs() == false) {
                rezultatPol.add(m2);
            }
        }
        return rezultatPol;
    }

    public static Polynomial scadere(Polynomial pol1, Polynomial pol2) {
        Polynomial rezultatPol = new Polynomial();
        Monomial rezMonomial;

        for (Monomial m1 : pol1.getPolynomial()) {
            for (Monomial m2 : pol2.getPolynomial()) {
                if (m1.getExponent() == m2.getExponent()) {
                    m1.setParcurs(true);
                    m2.setParcurs(true);
                    rezMonomial = new Monomial(m1.getCoeficient() - m2.getCoeficient(), m1.getExponent());
                    rezultatPol.add(rezMonomial);
                }
            }
        }

        for (Monomial m1 : pol1.getPolynomial()) {
            if (m1.getParcurs() == false)
                rezultatPol.add(m1);
        }

        for (Monomial m2 : pol2.getPolynomial()) {
            if (m2.getParcurs() == false)                                                                    // daca nu s-a gasit un Monomial cu acelasi coeficient
            {
                m2.setCoeficient(0 - m2.getCoeficient());                                                    // fiind Polynomialul care se scade, il scriem cu minus
                rezultatPol.add(m2);
            }
        }
        return rezultatPol;
    }

    public static Polynomial derivare(Polynomial pol1) {

        Polynomial rezultatPol = new Polynomial();

        for (Monomial m : pol1.getPolynomial()) {
            m.setCoeficient(m.getCoeficient() * m.getExponent());
            m.setExponent(m.getExponent() - 1);

            rezultatPol.add(m);
        }
        return rezultatPol;
    }

    public static Polynomial integrare(Polynomial pol1) {

        Polynomial rezultatPol = new Polynomial();

        for (Monomial m : pol1.getPolynomial()) {
            m.setCoeficient(m.getCoeficient() / (m.getExponent() + 1));
            m.setExponent(m.getExponent() + 1);

            rezultatPol.add(m);
        }
        return rezultatPol;
    }

    public static Polynomial produs(Polynomial pol1, Polynomial pol2) {

        Polynomial rezultatPol = new Polynomial();
        Monomial rezMonomial;

        for (Monomial m : pol1.getPolynomial()) {
            for (Monomial n : pol2.getPolynomial()) {
                rezMonomial = new Monomial(m.getCoeficient() * n.getCoeficient(), m.getExponent() + n.getExponent());
                for(Monomial k: rezultatPol.getPolynomial())
                    if(k.getExponent() == rezMonomial.getExponent()) {
                        k.setCoeficient(k.getCoeficient() + rezMonomial.getCoeficient());
                        rezMonomial = null;
                        break;
                    }
                if(rezMonomial != null)
                    rezultatPol.add(rezMonomial);
            }
        }
        return rezultatPol;
    }

    public List<Monomial> getPolynomial() {
        return polynomial;
    }

    public void add(Monomial a) {
        polynomial.add(a);
    }

    public String toString() {
        StringBuilder string = new StringBuilder();
        for(Monomial m: polynomial) {
            string.append(m.toString());
        }
        return string.toString();
    }
}

