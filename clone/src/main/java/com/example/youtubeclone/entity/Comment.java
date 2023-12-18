package com.example.youtubeclone.entity;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

	@Id
	private String id;
	private String text;
	private String authorId;
	private int likeCount;
	private int dislikeCount;
}
