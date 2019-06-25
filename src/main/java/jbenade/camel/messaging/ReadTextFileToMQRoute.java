package jbenade.camel.messaging;

import jbenade.camel.processor.FileProcessor;
import org.apache.camel.builder.RouteBuilder;

public class ReadTextFileToMQRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        from("file:C:\\opt\\git\\camel-message-exporter\\data\\output1?noop=true")
            .log("Starting message routing")
            .convertBodyTo(String.class)
            .split()
            .tokenize("\r").streaming()
            .process(new FileProcessor())
            .to("webspheremq:queue:JACO.EPS.MULTIPLY.QUEUE.OUTGOING?jmsMessageType=Text")
            .log("Finished message routing")
        .end();
    }
}
