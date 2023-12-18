package com.example.youtubeclone.entity;

import java.util.List;
import java.util.Set;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(value="User")
public class User {

	private String id;
	private String firstName;
	private String latName;
	private String fullName;
	private String emailAdress;
	private Set<String> subscribedUser;
	private Set<String> subscribers;
	private List<String> videoHistory;
	private List<String> likedVideos;
	private List<String> dislikedVideos;
	
	
	
	
}
