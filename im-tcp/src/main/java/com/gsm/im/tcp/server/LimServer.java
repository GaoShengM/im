package com.gsm.im.tcp.server;


import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class LimServer {

    private int port;

    public LimServer(int port) {
        NioEventLoopGroup bossGroup = new NioEventLoopGroup();
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();
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
                })
                .bind(port);
        log.info("netty server start success,port = {}", port);
    }

}
