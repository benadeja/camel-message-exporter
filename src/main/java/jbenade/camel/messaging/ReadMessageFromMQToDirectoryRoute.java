package jbenade.camel.messaging;

import org.apache.camel.builder.RouteBuilder;

public class ReadMessageFromMQToDirectoryRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {

		from("webspheremq:queue:JACO.EPS.OUTGOING.QUEUE?concurrentConsumers=5&disableReplyTo=true")
			.log("Starting message routing")
			.to("file:C:\\opt\\git\\camel-message-exporter\\data\\output")
			.log("Finished message routing")
		.end();
	}

}