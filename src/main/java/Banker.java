import com.bank.Account;
import com.bank.CertificateOfDeposit;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;
public class Banker {
    public static void main(String[] args){
        promptUser();
        displayBalance();
    }
    public static ArrayList<Account> accounts = new ArrayList<>();

    private static void promptUser(){
        boolean endLoop = false;
        do
        {
            Scanner reader = new Scanner(System.in);
            String[] options = new String[] {"Checking", "Savings", "Certificate of Deposit"};
            int response = JOptionPane.showOptionDialog(null, "What kind of account would you like to open?", "Account Open",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                    null, options, options[0]);

            if(response != 2)
            {
                createAccount();
            }
            else
            {
                createCertificateOfDeposit();
            }

            System.out.println("Would you like to add another account? y/n");
            String breakString = reader.next();
            if(breakString.equalsIgnoreCase("n"))
            {
                endLoop = true;
            }
        }
        while(endLoop == false);
    }
    public static void displayBalance(){
        for(Account account : accounts)
        {
            account.compute();
            System.out.println(account.getBalance());
        }
    }
    public static void createCertificateOfDeposit()
    {
        Scanner reader = new Scanner(System.in);
        CertificateOfDeposit certificateOfDeposit = new CertificateOfDeposit();
        System.out.println("What is your beginning balance?");
        certificateOfDeposit.setBalance(reader.nextDouble());
        System.out.println("What is your interest rate?");
        certificateOfDeposit.setInterest((reader.nextDouble()));
        System.out.println("What is your duration?");
        certificateOfDeposit.setPeriods((reader.nextInt()));
        System.out.println("What is your term?");
        certificateOfDeposit.setBalance(reader.nextDouble());
        accounts.add(certificateOfDeposit);
    }
    public static void createAccount()
    {
        Scanner reader = new Scanner(System.in);
        Account account = new Account();
        System.out.println("What is your beginning balance?");
        account.setBalance(reader.nextDouble());
        System.out.println("What is your interest rate?");
        account.setInterest((reader.nextDouble()));
        System.out.println("What is your duration?");
        account.setPeriods((reader.nextInt()));
        accounts.add(account);
    }
}
