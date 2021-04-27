package liveness;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Worker {

    public synchronized void work() {
        String name = Thread.currentThread().getName();
        String fileName = name + ".txt";

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            writer.write("Thread " + name + " wrote this message");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        while (true) {
            System.out.println(name + " is wroking");

//            try {
//                // 1초 동안 락을 놓는다
//                wait(1000);
//            } catch (InterruptedException ex) {
//                ex.printStackTrace();
//            }
        }
    }
}
