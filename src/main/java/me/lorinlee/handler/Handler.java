package me.lorinlee.handler;

/**
 * Created by lorin on 17-5-22.
 */
public abstract class Handler {

    protected String info;
    protected Handler next = null;

    public void setInfo(String info) {
        this.info = info;
    }

    public Handler(String info) {
        this.info = info;
    }

    public Handler getNext() {
        return next;
    }

    public void setNext(Handler next) {
        this.next = next;
    }

    protected abstract void execute();

    public void handle() {
        this.execute();
        if (next != null) next.handle();
    }

}
