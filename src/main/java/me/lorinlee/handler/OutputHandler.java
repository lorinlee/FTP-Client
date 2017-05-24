package me.lorinlee.handler;

import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.List;

/**
 * Created by lorin on 17-5-22.
 */
public class OutputHandler extends Handler {

    public static final BlockingQueue<String> outputQueue = new LinkedBlockingQueue<>();

    public OutputHandler(String info) {
        super(info);
    }

    public void execute() {
        outputQueue.offer(info);
    }

    public static void outputAll() throws InterruptedException {
        Thread.sleep(500);
        List<String> outputs = new LinkedList<>();
        outputQueue.drainTo(outputs);
        for (String line: outputs) {
            System.out.println(line);
        }
    }
}
