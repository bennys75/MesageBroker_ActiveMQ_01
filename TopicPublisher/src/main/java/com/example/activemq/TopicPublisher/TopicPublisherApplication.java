package com.example.activemq.TopicPublisher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/*Local*/
import com.example.activemq.TopicPublisher.model.publisherModel;
import com.example.activemq.TopicPublisher.jms.publisherJms;


@SpringBootApplication
public class TopicPublisherApplication {
	@Autowired
	publisherJms publisherJms;
	
	@Value("${activemq.destination.topic}")
	String destinationTopic;
	
	public static void main(String[] args) {
		SpringApplication.run(TopicPublisherApplication.class, args);
		System.out.println("Application is running!!");
	}
	
	@RestController
	public class PublisherController {

		@PostMapping("/")
		public ResponseEntity<String> publishMessage(@RequestBody publisherModel message){
			try {
				publisherJms.send(destinationTopic, message);
				return new ResponseEntity<>("Success.", HttpStatus.OK);
			}catch(Exception e) {
				return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
		//Without status code and exception error
		/*public String sendMessage(@RequestBody publisherModel message) {
			publisherJms.send(destinationTopic, message);
			return "success";
		}*/
	}
	

}
