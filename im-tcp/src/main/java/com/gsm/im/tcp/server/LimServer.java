package com.gsm.im.tcp.server;


import com.gsm.im.codec.config.BootstrapConfig;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class LimServer {
    EventLoopGroup bossGroup;
    EventLoopGroup workerGroup;
    ServerBootstrap server;
    BootstrapConfig.TcpConfig config;

    public LimServer(BootstrapConfig.TcpConfig config) {
        bossGroup = new NioEventLoopGroup(config.getBossThreadSize());
        workerGroup = new NioEventLoopGroup(config.getWorkThreadSize());
        ServerBootstrap server = new ServerBootstrap();
        server.group(bossGroup, workerGroup)
                .channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_BACKLOG, 10240) //服务端的可连接队列
                .option(ChannelOption.SO_REUSEADDR, true) //参数表示是否支持重新链接
                .childOption(ChannelOption.TCP_NODELAY, true) //参数表示是否开启Nagle算法
                .childOption(ChannelOption.SO_KEEPALIVE, true) //参数表示是否开启TCP底层心跳机制
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {

                    }
                });

    }

    public void start(){
        Integer tcpPort = this.config.getTcpPort();
        this.server.bind(tcpPort);
        log.info("netty server start success,port = {}", tcpPort);
    }
}
