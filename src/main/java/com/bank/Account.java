package com.bank;

public class Account {

    public double Balance;

    public double Rate;

    public int Period;

    public void compute() {
        for(int i = 0; i < Period; i++)
        {
            double addInterest = (Balance * Rate) / 100;
            Balance += addInterest;
        }
    }

    public void setInterest(double rate){
        this.Rate = rate;
    }
    public void setPeriods(int period){
        this.Period = period;
    }
    public void setBalance(double balance){
        this.Balance = balance;
    }
    public double getBalance(){
        return Balance;
    }
    @Override
    public String toString(){
       return "Balance: " + getBalance() + " Rate: " + Rate + " Interest: " + Period;
    }
}
