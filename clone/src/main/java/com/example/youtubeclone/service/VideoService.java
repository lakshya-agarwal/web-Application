package com.example.youtubeclone.service;

import org.springframework.web.multipart.MultipartFile;


public interface VideoService {

	 Boolean uploadFile(MultipartFile File) ;
	
}
