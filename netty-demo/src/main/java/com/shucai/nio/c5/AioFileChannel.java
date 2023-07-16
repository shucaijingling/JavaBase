package com.shucai.nio.c5;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import static com.shucai.nio.c1.ByteBufferUtil.debugAll;

@Slf4j
public class AioFileChannel {
    public static void main(String[] args) throws IOException, InterruptedException {

        try (AsynchronousFileChannel channel = AsynchronousFileChannel.open(Paths.get("mynew.txt"), StandardOpenOption.READ)) {

            ByteBuffer buffer = ByteBuffer.allocate(16);
            log.debug("read begin ...");
            channel.read(buffer, 0, buffer, new CompletionHandler<Integer, ByteBuffer>() {

                @Override
                public void completed(Integer result, ByteBuffer attachment) {
                    log.debug("read completed ...");
                    attachment.flip();
                    debugAll(attachment);
                }

                @Override
                public void failed(Throwable exc, ByteBuffer attachment) {
                    exc.printStackTrace();
                }
            });
            log.debug("read end ...");
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
