package com.example.youtubeclone.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.youtubeclone.entity.Video;

public interface VideoDao extends MongoRepository<Video,String>{

}
