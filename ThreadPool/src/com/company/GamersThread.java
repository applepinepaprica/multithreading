package com.company;

import java.util.Random;

public class GamersThread implements Runnable {

    private int zeroOrOne;
    private Field field;

    GamersThread(int zeroOrOne, Field field){
        this.zeroOrOne = zeroOrOne;
        this.field = field;
    }

    @Override
    public void run() {

        if (!field.getIsEnd().get()) {

            Random r = new Random();
            int i, j;
            do {
                i = r.nextInt(3);
                j = r.nextInt(3);
            } while (!field.getField()[i][j].compareAndSet(2, zeroOrOne));

            field.checkIfEnd();
            field.printField();
        }
    }
}
