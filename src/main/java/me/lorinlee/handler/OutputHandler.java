package me.lorinlee.handler;

import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.List;

/**
 * Created by lorin on 17-5-22.
 */
public class OutputHandler extends Handler {

    public OutputHandler(String info) {
        super(info);
    }

    public void execute() {
        System.out.println(info);
    }

}
