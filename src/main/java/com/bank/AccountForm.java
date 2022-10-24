package com.bank;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class AccountForm {

    private JPanel mainPanel;
    private JPanel centerMainPanel;
    private JPanel innerNorthPanel;
    private JPanel innerCenterPanel;
    private JPanel buttonPanel;
    private JButton btnSave;
    private JButton computeBtn;
    private JList accountList;
    private JComboBox accountCombo;
    private JLabel accountLabel;
    private JLabel createAccountLabel;
    private JLabel accountTypeLabel;
    private JTextField interestField;
    private JTextField rateField;
    private JTextField balanceField;
    private JLabel interestBtn;
    private JLabel rateBtn;
    private JLabel balanceBtn;
    private JLabel termLabel;
    private JTextField termField;
    private JButton removeButton;
    private Vector<Account> accountVector = new Vector<>();
    public AccountForm(){
        initializeComboBox();
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                accountList.setListData(accountVector);

                double interest = Double.parseDouble(interestField.getText());
                int rate = Integer.parseInt(rateField.getText());
                double balance = Double.parseDouble(balanceField.getText());
                String type = accountCombo.getSelectedItem().toString();

                Account account = new Account();
                if(type == "Certificate of Deposit"){
                    account = AccountFactory.getInstance().createAccount(type, Integer.parseInt(termField.getText()));
                }
                else{
                    account = AccountFactory.getInstance().createAccount(type);
                }
                account.setBalance(balance);
                account.setInterest(interest);
                account.setPeriods(rate);

                accountVector.add(account);
                accountList.updateUI();
            }
        });
        computeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                accountVector.stream().forEach(account -> {account.compute();});
                accountList.updateUI();
            }
        });

        accountCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String type = (accountCombo.getSelectedItem()).toString();
                if (type == "Certificate of Deposit"){
                    termField.setVisible(true);
                    termLabel.setVisible(true);
                }
                else{
                    termField.setVisible(false);
                    termLabel.setVisible(false);
                }
            }
        });
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = accountList.getSelectedIndex();
                if(index >= 0){
                    accountVector.remove(index);
                    accountList.updateUI();
                }
            }
        });
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("AccountForm");
        frame.setContentPane(new com.bank.AccountForm().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
    private void initializeComboBox(){
        DefaultComboBoxModel<String> accountTypesModel = new DefaultComboBoxModel<>();
        accountTypesModel.addElement(AccountFactory.CertificateOfDeposit);
        accountTypesModel.addElement(AccountFactory.Savings);
        accountTypesModel.addElement(AccountFactory.Checking);
        accountCombo.setModel(accountTypesModel);
    }
}