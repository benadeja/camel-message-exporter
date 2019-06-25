package jbenade.camel.messaging;

import jbenade.camel.util.MQConnection;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;

public class ReadTextFileToMQRouteTest extends CamelTestSupport {

	@Override
	public RoutesBuilder createRouteBuilder() throws Exception {
		
		context.addComponent("webspheremq", JmsComponent.jmsComponentAutoAcknowledge(new MQConnection().getConnection()));
		return new ReadTextFileToMQRoute();
	}

	@Test
	public void checkFileExistsInOutputDirectory() throws InterruptedException {

		Thread.sleep(30000);

		File file = new File("C:\\opt\\git\\camel-message-exporter\\data\\output1");
		assertTrue(file.isDirectory());
		System.out.println("Total no of files in the output directory : " + file.listFiles().length);

	}

}
