package com.company;

public class Main {

    public static void main(String[] args) {
        Account a1 = new Account();
        a1.addAmount(100500);
        Account a2 = new Account();
        transaction(a1, a2, 500);
        System.out.println("Account 1: " + a1.getAmount());
        System.out.println("Account 2: " + a2.getAmount());
        transaction(a2, a1, 1000);
    }

    private static void transaction (Account from, Account to, int quantity) {
        if (from.getAmount() >= quantity) {
            from.deductAmount(quantity);
            to.addAmount(quantity);
        } else {
            System.out.println("Not enough money");
        }
    }
}
