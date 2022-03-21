package view;

import controller.CalculatorController;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;

public class CalculatorView extends JFrame {

    //componente
    private JButton add = new JButton("+");
    private JButton sub = new JButton("-");
    private JButton mul = new JButton("*");
    private JButton integr = new JButton("Integration");
    private JButton derv = new JButton("Derivation");
    private JButton clr = new JButton("Clear");
    private JTextField tf1 = new JTextField(20);
    private JTextField tf2 = new JTextField(20);
    private JTextField tftotal = new JTextField(50);
    private JLabel lr = new JLabel("Result");
    private JLabel lp = new JLabel("P1");
    private JLabel lq = new JLabel("P2");
    //constructor
    public CalculatorView() {
        setTitle("Calculator Polinoame");

        setLocation(new Point(100, 200));
        setResizable(false);
        // intializam componente
        initComponent();
    }

    public static boolean isNumeric(String str) {
        return str.matches("[+-]*\\d*\\.?\\d+");
    }

    // initia;izam componente
    private void initComponent() {

        JPanel calcPanel = new JPanel();
        calcPanel.setLayout(new FlowLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(900, 400);
        calcPanel.add(lp);
        calcPanel.add(tf1);

        calcPanel.add(add);
        calcPanel.add(sub);
        calcPanel.add(mul);
        calcPanel.add(derv);
        calcPanel.add(integr);
        calcPanel.add(clr);
        calcPanel.add(lq);
        calcPanel.add(tf2);
        calcPanel.add(lr);
        calcPanel.add(tftotal);

        this.add(calcPanel);

    }

    public void setResult(String result) {
        tftotal.setText(result);
    }

    public void showError(String errMessage) {
        JOptionPane.showMessageDialog(this, errMessage);
    }

    public void addMultiplyListener(ActionListener mal) {
        mul.addActionListener(mal);
    }

    public void addAditionListener(ActionListener adl) {
        add.addActionListener(adl);
    }

    public void addSubstractionListener(ActionListener sbl) {
        sub.addActionListener(sbl);
    }

    public void addClearListener(ActionListener cal) {
        clr.addActionListener(cal);
    }


    public String getOperand1() {
        return tf1.getText();
    }

    public String getOperand2() {
        return tf2.getText();
    }

    public void clearListener() {
        tf1.setText("");
        tf2.setText("");
        tftotal.setText("");
    }

    public void addDerivationListener(ActionListener derivationListener) {
        derv.addActionListener(derivationListener);
    }

    public void addIntegrationListener(ActionListener integrationListener) {
        integr.addActionListener(integrationListener);
    }
}