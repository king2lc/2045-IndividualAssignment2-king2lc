package com.bank;

public class Checking extends Account {
    public double FEE =  5;
    public void compute() {
        for(int i = 0; i < Period; i++)
        {
            double addInterest = (Balance * Rate) / 100;
            Balance += addInterest - FEE;
        }
    }
}
