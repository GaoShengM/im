package com.gsm.im.tcp;

import com.gsm.im.tcp.server.LimServer;
import com.gsm.im.tcp.server.LimWebSocketServer;

/**
 * @author MSI-PC
 * @version 1.0
 * @description: TODO
 * @date 2023/7/8 18:01
 */
public class Starter {
    public static void main(String[] args) {
         new LimServer(9000);
         new LimWebSocketServer(19000);
    }
}
