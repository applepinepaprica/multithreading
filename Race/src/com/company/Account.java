package com.company;

public class Account {
    private int Amount;

    public int getAmount() {
        return Amount;
    }

    public void addAmount(int amount) {
        this.Amount += amount;
    }

    public void deductAmount(int amount) {
        this.Amount -= amount;
    }
}
