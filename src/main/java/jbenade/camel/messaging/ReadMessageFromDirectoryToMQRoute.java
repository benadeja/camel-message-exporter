package jbenade.camel.messaging;

import org.apache.camel.builder.RouteBuilder;

public class ReadMessageFromDirectoryToMQRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        from("file:C:\\opt\\git\\camel-message-exporter\\data\\output?noop=true")
            .log("Starting message routing")
            .to("webspheremq:queue:JACO.EPS.OUTGOING.QUEUE?jmsMessageType=Text")
            .log("Finished message routing")
        .end();
    }

}