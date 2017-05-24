package me.lorinlee.handler;

import me.lorinlee.network.RequestSocket;
import me.lorinlee.request.SystRequest;

/**
 * Created by lorin on 17-5-22.
 */
public class HandlerDispatcher {

    public static Handler getHandler(String result) {
        Handler handler;
        if (result.startsWith("227")) {
            handler = new PasvHandler(result);
        } else if (result.startsWith("230")) {
            handler = new LoginedHandler(result);
            handler.setNext(new OutputHandler(result));
        } else {
            handler = new OutputHandler(result);
        }
        return handler;
    }

}
