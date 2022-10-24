package com.bank;

public class AccountFactory {
    public static final String CertificateOfDeposit = "Certificate of Deposit";
    public static final String Checking = "Checking";
    public static final String Savings = "Savings";
    private static AccountFactory singleton = null;
    public Account createAccount(String accountType){
        if (accountType == null)
            return null;
        else if(accountType == "Checking"){
            return new Checking();
        }
        else if(accountType == "Savings"){
            return new Savings();
        }
        else{
            return null;
        }
    }
    public Account createAccount(String accountType, Integer maturity) {
        if (accountType == null)
            return null;
        CertificateOfDeposit cod = new CertificateOfDeposit();
        cod.setMaturity(maturity);
        return cod;
    }
    public static AccountFactory getInstance(){
        if(singleton == null){
            singleton = new AccountFactory();
        }
        return singleton;
    }
}