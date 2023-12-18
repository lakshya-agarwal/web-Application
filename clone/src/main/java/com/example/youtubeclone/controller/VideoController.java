package com.example.youtubeclone.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpStatus;
import org.common.utilities.constants.CommonConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.youtubeclone.service.VideoService;

@RestController
@RequestMapping("videos")
public class VideoController {
	
	@Autowired
	private VideoService videoService;

	@PostMapping(path = "/upload")
	public ResponseEntity uploadVideo( @RequestParam("file") MultipartFile file) {
		Map<String, Object> result = new HashMap<>();
		Boolean status = videoService.uploadFile(file);
		if (Boolean.TRUE.equals(status)) {
			result.put(CommonConstants.STATUS, CommonConstants.SUCCESS);
		} else
			result.put(CommonConstants.STATUS, CommonConstants.NO_DATA_FOUND);
		return ResponseEntity.status(HttpStatus.SC_OK).body(result);
		
	}
	
	 
}
