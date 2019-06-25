package jbenade.camel.util;

import com.ibm.mq.jms.MQQueueConnectionFactory;
import com.ibm.msg.client.wmq.WMQConstants;

public class MQConnection {

    private static final String HOST = "imhotep.momentum.co.za"; // Host name or IP address
    private static final int PORT = 1415; // Listener port for your queue manager
    private static final String CHANNEL = "TCP.CLT.CHL"; // Channel name
    private static final String QMGR = "MOMTEST.QUE.MGR"; // Queue manager name

    public static MQQueueConnectionFactory getConnection() throws Exception{

        MQQueueConnectionFactory connectionFactory = new MQQueueConnectionFactory();
        connectionFactory.setHostName(HOST);
        connectionFactory.setPort(PORT);
        connectionFactory.setChannel(CHANNEL);
        connectionFactory.setQueueManager(QMGR);
        connectionFactory.setTransportType (WMQConstants.WMQ_CM_CLIENT);
        return connectionFactory;

    }
}
