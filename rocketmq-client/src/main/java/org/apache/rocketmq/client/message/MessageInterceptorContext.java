package org.apache.rocketmq.client.message;

import java.util.concurrent.TimeUnit;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MessageInterceptorContext {
    @Builder.Default
    private final MessageHookPoint.PointStatus status = MessageHookPoint.PointStatus.UNSET;
    @Builder.Default
    private final int messageBatchSize = 1;
    @Builder.Default
    private final int messageIndex = 0;
    @Builder.Default
    private final int attempt = 1;
    @Builder.Default
    private final long duration = 0;
    @Builder.Default
    private final TimeUnit timeUnit = TimeUnit.MILLISECONDS;
    @Builder.Default
    private final Throwable throwable = null;
}
