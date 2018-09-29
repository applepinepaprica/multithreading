package com.company;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

class Field {
    private AtomicInteger[][] field;
    private AtomicBoolean isEnd =  new AtomicBoolean(false);

    Field () {
        field = new AtomicInteger[3][3];
        for (int i = 0; i < field.length; i++){
            for (int j = 0; j < field[0].length; j++) {
                field[i][j] = new AtomicInteger(2);
            }
        }
        printField();
    }

    AtomicInteger[][] getField() {
        return field;
    }

    AtomicBoolean getIsEnd() {
        return isEnd;
    }

    void checkIfEnd(){
        checkWinner();
        checkDraw();
    }

    private void checkDraw(){
        boolean localIsEnd = true;

        if (!getIsEnd().get()){
            for (int i = 0; i < field.length && localIsEnd; i++) {
                for (int j = 0; j < field[0].length && localIsEnd; j++) {
                    if (field[i][j].get() == 2){
                           localIsEnd = false;
                    }
                }
            }

            if (localIsEnd) {
                getIsEnd().compareAndSet(false, localIsEnd);
                System.out.println("Even-steven");
            }
        }
    }

    private void checkWinner()
    {
        boolean localIsEnd = false;
        int winner = 2;

        for (int i = 0; i < field.length && !localIsEnd; i++){
            if (field[i][0].get() != 2 && field[i][0].get() == field[i][1].get() && field[i][1].get() == field[i][2].get()) {
                localIsEnd = true;
                winner = field[i][0].get();
            }

            if (field[0][i].get()  != 2 && field[0][i].get() == field[1][i].get() && field[1][i].get() == field[2][i].get()) {
                localIsEnd = true;
                winner = field[0][i].get();
            }
        }

        if (!localIsEnd && field[0][0].get() != 2 && field[0][0].get() == field[1][1].get() && field[1][1].get() == field[2][2].get()) {
            localIsEnd = true;
            winner = field[0][0].get();
        }

        if (!localIsEnd && field[0][2].get() != 2  && field[0][2].get() == field[1][1].get() && field[1][1].get() == field[2][0].get()) {
            localIsEnd = true;
            winner = field[0][2].get();
        }

        if (localIsEnd) {
            getIsEnd().compareAndSet(false, localIsEnd);
            System.out.println("And the winner is... " + winner);
        }
    }

    synchronized void printField(){
        for (int i = 0; i < field.length; i++){
            System.out.print("[");
            for (int j = 0; j < field[0].length; j++) {
                System.out.print(field[i][j].get());
            }
            System.out.println("]");
        }
        System.out.println();
    }
}
