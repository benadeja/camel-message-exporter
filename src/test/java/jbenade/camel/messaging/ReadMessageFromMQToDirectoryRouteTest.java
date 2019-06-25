package jbenade.camel.messaging;

import java.io.File;


import jbenade.camel.util.MQConnection;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class ReadMessageFromMQToDirectoryRouteTest extends CamelTestSupport {

	@Override
	public RoutesBuilder createRouteBuilder() throws Exception {

        context.addComponent("webspheremq", JmsComponent.jmsComponentAutoAcknowledge(new MQConnection().getConnection()));
		return new ReadMessageFromMQToDirectoryRoute();
	}

	@Test
	public void checkFileExistsInOutputDirectory() throws InterruptedException {

		Thread.sleep(5000);

		File file = new File("C:\\opt\\git\\camel-message-exporter\\data\\output");
		assertTrue(file.isDirectory());
		System.out.println("Total no of files in the output directory : " + file.listFiles().length);
	}

}
