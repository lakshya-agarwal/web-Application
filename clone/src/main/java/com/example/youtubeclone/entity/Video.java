package com.example.youtubeclone.entity;

import java.util.List;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Document(value="Video")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Video {

	
	@Id
	private String id;
	private String title;
	private String desription;
	private String userId;
	private int viewCount;
	private int likesCount;
	private int dislikesCount;
	private Set<String> tags;
	private String VideoUrl;
	private VideoStatus videoState;
	private String thumbnailUrl;
	private List<Comment> comments;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDesription() {
		return desription;
	}
	public void setDesription(String desription) {
		this.desription = desription;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getViewCount() {
		return viewCount;
	}
	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}
	public int getLikesCount() {
		return likesCount;
	}
	public void setLikesCount(int likesCount) {
		this.likesCount = likesCount;
	}
	public int getDislikesCount() {
		return dislikesCount;
	}
	public void setDislikesCount(int dislikesCount) {
		this.dislikesCount = dislikesCount;
	}
	public Set<String> getTags() {
		return tags;
	}
	public void setTags(Set<String> tags) {
		this.tags = tags;
	}
	public String getVideoUrl() {
		return VideoUrl;
	}
	public void setVideoUrl(String videoUrl) {
		VideoUrl = videoUrl;
	}
	public VideoStatus getVideoState() {
		return videoState;
	}
	public void setVideoState(VideoStatus videoState) {
		this.videoState = videoState;
	}
	public String getThumbnailUrl() {
		return thumbnailUrl;
	}
	public void setThumbnailUrl(String thumbnailUrl) {
		this.thumbnailUrl = thumbnailUrl;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
	
	
}
