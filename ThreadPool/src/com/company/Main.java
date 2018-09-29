package com.company;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        Field field = new Field();
        Runnable t1 = new GamersThread(0, field);
        Runnable t2 = new GamersThread(1, field);

        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        service.scheduleAtFixedRate(t1, 0, 1, TimeUnit.SECONDS);
        service.scheduleAtFixedRate(t2, 0, 1, TimeUnit.SECONDS);
    }
}
