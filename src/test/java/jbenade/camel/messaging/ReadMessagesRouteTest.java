package jbenade.camel.messaging;

import java.io.File;



import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import com.ibm.mq.jms.MQQueueConnectionFactory;
import com.ibm.msg.client.wmq.WMQConstants;

public class ReadMessagesRouteTest extends CamelTestSupport {

	private static final String HOST = "imhotep.momentum.co.za"; // Host name or IP address
	private static final int PORT = 1415; // Listener port for your queue manager
	private static final String CHANNEL = "TCP.CLT.CHL"; // Channel name
	private static final String QMGR = "MOMTEST.QUE.MGR"; // Queue manager name
	
	@Override
	public RoutesBuilder createRouteBuilder() throws Exception {
		
		MQQueueConnectionFactory connectionFactory = new MQQueueConnectionFactory();
		connectionFactory.setHostName(HOST);
		connectionFactory.setPort(PORT);
		connectionFactory.setChannel(CHANNEL);
		connectionFactory.setQueueManager(QMGR);
		connectionFactory.setTransportType (WMQConstants.WMQ_CM_CLIENT);
		
		context.addComponent("webspheremq", JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));
		return new ReadMessagesRoute();
	}

	@Test
	public void checkFileExistsInOutputDirectory() throws InterruptedException {

		Thread.sleep(5000);

		File file = new File("data/output");
		assertTrue(file.isDirectory());
		System.out.println("Total no of files in the output directory : " + file.listFiles().length);

	}

}
