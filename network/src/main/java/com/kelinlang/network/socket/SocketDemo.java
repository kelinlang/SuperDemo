package com.kelinlang.network.socket;

/**
 * Created by Administrator on 2016/9/26 0026.
 */

public class SocketDemo {
    public native void startServer();
    public native void stopServer();

    public native void startClient();
    public native void stopClient();


    static {
        System.loadLibrary("socket-lib");
    }
}
