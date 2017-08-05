package io.springbootquickstart.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {

	private List<Topic> topicList = new ArrayList<>(Arrays.asList(

			new Topic("Spring Boot", "Spring Framework", "Spring Framework Description"),
			new Topic("Java", "Core Java", "Java Description"),
			new Topic("JavaScript", "JavaScript", "JavaScript Description")
			));
	
	public List<Topic> getAllTopics(){
		return topicList; 
	}
	
	public Topic getTopic(String id){
		return topicList.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}

	public void addTopic(Topic topic) {
		topicList.add(topic);
		
	}

	public void updateTopic(Topic topic, String id) {
		Topic retrievedTopic = topicList.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		topicList.remove(retrievedTopic);
		topic.setId(id);
		topicList.add(topic);
	}

	public void deleteTopic(String id) {
		topicList.removeIf(t -> t.getId().equals(id));
	}
}
