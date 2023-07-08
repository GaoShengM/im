package com.gsm.im.tcp;

import com.gsm.im.tcp.server.LimServer;
import com.gsm.im.tcp.server.LimWebSocketServer;
import io.netty.bootstrap.BootstrapConfig;
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
        Yaml yaml = new Yaml();
        InputStream inputStream = new FileInputStream("I:\\TempCodeSpace\\im\\im-tcp\\src\\main\\resources\\config.yml");
        BootstrapConfig bootstrapConfig = yaml.loadAs(inputStream, BootstrapConfig.class);
        new LimServer(9000);
        new LimWebSocketServer(19000);
    }
}
