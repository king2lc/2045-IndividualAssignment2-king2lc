package com.bank;
public class CertificateOfDeposit extends Account{
    private int Term;
    public void setMaturity(int term){
        this.Term = term;
    }
    public int getMaturity(){
        return Term;
    }
}

