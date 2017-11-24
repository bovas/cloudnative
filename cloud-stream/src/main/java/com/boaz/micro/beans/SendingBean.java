package com.boaz.micro.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class SendingBean {

	private MessageChannel output;
	
	@Autowired
	public SendingBean(@Qualifier("directGreetings")MessageChannel output) {
		this.output = output;
	}
	
	public void sayHello(String name) {
		output.send(MessageBuilder.withPayload(name).build());
	}
}
