package jbenade.camel.messaging;

import org.apache.camel.builder.RouteBuilder;

public class ReadMessagesRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {

		from("webspheremq:queue:JACO_MDI_PARKINGLOT_1?concurrentConsumers=5&disableReplyTo=true")
		.log("Starting message routing")
		.to("file:data/output?fileName=message-${id}")
		.log("Finished message routing");
		
		from("file:data/output?noop=true")
		.log("Starting message routing")
		.to("webspheremq:queue:JACO_MDI_PARKINGLOT_2")
		.log("Finished message routing");

	}

}