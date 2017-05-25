package me.lorinlee.handler;

import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by lorin on 17-5-25.
 */
public class HandlerManager {

    private BlockingQueue<Handler> handlerBlockingQueue = new LinkedBlockingQueue<>();

    public static HandlerManager getInstance() {
        return HandlerQueueHolder.HANDLER_QUEUE;
    }

    public static class HandlerQueueHolder {
        public static final HandlerManager HANDLER_QUEUE = new HandlerManager();
    }

    public void syncHandle(Handler handler) {
        handlerBlockingQueue.offer(handler);
    }

    public void asyncHandle(Handler handler) {
        handler.handle();
    }

    public void handle() throws InterruptedException {
        Thread.sleep(200);
        List<Handler> handlerList = new LinkedList<>();
        handlerBlockingQueue.drainTo(handlerList);
        handlerList.forEach((handler -> handler.handle()));
    }

    public Handler pollHandler() throws InterruptedException {
        return handlerBlockingQueue.poll(1, TimeUnit.SECONDS);
    }

    public void clear() {
        try {
            Thread.sleep(200);
            List<Handler> handlerList = new LinkedList<>();
            handlerBlockingQueue.drainTo(handlerList);
            handlerList.forEach((handler -> {
                if (handler instanceof OutputHandler) {
                    handler.handle();
                }
            }));
        } catch (InterruptedException e) {

        }
    }

}
