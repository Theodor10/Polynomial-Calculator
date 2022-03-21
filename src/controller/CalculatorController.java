package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Polynomial;
import view.CalculatorView;


public class CalculatorController {
    private CalculatorView m_view;

    public CalculatorController(CalculatorView view) {
        m_view = view;
        m_view.setVisible(true);
        m_view.addAditionListener(new AdditionListener());
        m_view.addSubstractionListener(new SubstractListener());
        m_view.addMultiplyListener(new MultiplyListener());
        m_view.addDerivationListener(new DerivationListener());
        m_view.addIntegrationListener(new IntegrationListener());
        m_view.addClearListener(new ClearListener());
    }

    private class MultiplyListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                m_view.setResult(Polynomial.produs(new Polynomial(m_view.getOperand1()), new Polynomial(m_view.getOperand2())).toString());
            } catch (Exception ex) {
                m_view.showError(ex.getMessage());
            }
        }
    }

    private class AdditionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                m_view.setResult(Polynomial.adunare(new Polynomial(m_view.getOperand1()), new Polynomial(m_view.getOperand2())).toString());
            } catch (Exception ex) {
                m_view.showError(ex.getMessage());
            }
        }
    }

    private class SubstractListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                m_view.setResult(Polynomial.scadere(new Polynomial(m_view.getOperand1()), new Polynomial(m_view.getOperand2())).toString());
            } catch (Exception ex) {
                m_view.showError(ex.getMessage());
            }
        }
    }

    private class DerivationListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                m_view.setResult(Polynomial.derivare(new Polynomial(m_view.getOperand1())).toString());
            } catch (Exception ex) {
                m_view.showError(ex.getMessage());
            }
        }
    }

    private class IntegrationListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                m_view.setResult(Polynomial.integrare(new Polynomial(m_view.getOperand1())).toString());
            } catch (Exception ex) {
                m_view.showError(ex.getMessage());
            }
        }
    }

    private class ClearListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                m_view.clearListener();
            } catch (Exception ex) {
                m_view.showError(ex.getMessage());
            }
        }
    }

}
