package me.lorinlee.handler;

import me.lorinlee.network.RequestSocket;
import me.lorinlee.request.SystRequest;

/**
 * Created by lorin on 17-5-22.
 */
public class HandlerDispatcher {

    public static HandlerDispatcher getInstance() {
        return HandlerDispatcherHolder.HANDLER_DISPATCHER;
    }

    private static class HandlerDispatcherHolder {
        public static final HandlerDispatcher HANDLER_DISPATCHER = new HandlerDispatcher();
    }

    public void dispatch(String result) {
        Handler handler = null;
        if (result.startsWith("227")) {
            HandlerManager.getInstance().asyncHandle(new PasvHandler(result));
        } else if (result.startsWith("230")) {
            handler = new OutputHandler(result);
            HandlerManager.getInstance().asyncHandle(new LoginedHandler(result));
        } else if (result.startsWith("331")) {
            handler = new OutputHandler(result);
            handler.setNext(new PasswordHandler(result));
        } else {
            handler = new OutputHandler(result);
        }
        if (handler != null) HandlerManager.getInstance().syncHandle(handler);
    }

}
