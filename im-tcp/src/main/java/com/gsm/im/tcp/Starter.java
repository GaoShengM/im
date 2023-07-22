package com.gsm.im.tcp;

import com.gsm.im.codec.config.BootstrapConfig;
import com.gsm.im.tcp.server.LimServer;
import com.gsm.im.tcp.server.LimWebSocketServer;
import org.yaml.snakeyaml.Yaml;

import java.io.*;

/**
 * @author MSI-PC
 * @version 1.0
 * @description: TODO
 * @date 2023/7/8 18:01
 */
public class Starter {
    public static void main(String[] args) throws FileNotFoundException {
        if (args.length > 0) {
            start(args[0]);
        }
        // "I:\\TempCodeSpace\\im\\im-tcp\\src\\main\\resources\\config.yml"
    }

    private static void start(String path) throws FileNotFoundException {
        try {
            Yaml yaml = new Yaml();
            InputStream inputStream = new FileInputStream(path);
            BootstrapConfig bootstrapConfig = yaml.loadAs(inputStream, BootstrapConfig.class);
            new LimServer(bootstrapConfig.getLim()).start();
            new LimWebSocketServer(bootstrapConfig.getLim()).start();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(500);
        }

    }
}
