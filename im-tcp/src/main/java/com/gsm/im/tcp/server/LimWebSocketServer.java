package com.gsm.im.tcp.server;


import com.gsm.im.codec.config.BootstrapConfig;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class LimWebSocketServer {

    EventLoopGroup bossGroup;
    EventLoopGroup workerGroup;
    ServerBootstrap server;
    BootstrapConfig.TcpConfig config;

    public LimWebSocketServer(BootstrapConfig.TcpConfig config) {
        bossGroup = new NioEventLoopGroup();
        workerGroup = new NioEventLoopGroup();
        server = new ServerBootstrap();
        server.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class).option(ChannelOption.SO_BACKLOG, 10240) //服务端的可连接队列
                .option(ChannelOption.SO_REUSEADDR, true) //参数表示是否支持重新链接
                .childOption(ChannelOption.TCP_NODELAY, true) //参数表示是否开启Nagle算法
                .childOption(ChannelOption.SO_KEEPALIVE, true) //参数表示是否开启TCP底层心跳机制
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ChannelPipeline pipeline = ch.pipeline();
                        // websocket 基于http协议，所以要有http编解码器
                        pipeline.addLast("http-codec", new HttpServerCodec());
                        // 对写大数据流的支持
                        pipeline.addLast("http-chunked", new ChunkedWriteHandler());
                        // 几乎在netty中的编程，都会使用到此hanler
                        pipeline.addLast("aggregator", new HttpObjectAggregator(65535));
                        /**
                         * websocket 服务器处理的协议，用于指定给客户端连接访问的路由 : /ws
                         * 本handler会帮你处理一些繁重的复杂的事
                         * 会帮你处理握手动作： handshaking（close, ping, pong） ping + pong = 心跳
                         * 对于websocket来讲，都是以frames进行传输的，不同的数据类型对应的frames也不同
                         */
                        pipeline.addLast(new WebSocketServerProtocolHandler("/ws"));
                    }
                });
    }

    public void start() {
        int port = this.config.getWebSocketPort();
        this.server.bind(port);
        log.info("netty websocket server start success,port = {}", port);
    }
}
