package jbenade.camel.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class FileProcessor implements Processor {

    @Override
    public void process(Exchange msg) {
        String text = msg.getIn().getBody(String.class);
        System.out.println("Processing text: " + text);
        msg.getIn().setBody(text.trim());
    }
}
