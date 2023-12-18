package com.example.youtubeclone.serviceImpl;

import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.example.youtubeclone.dao.VideoDao;
import com.example.youtubeclone.entity.Video;
import com.example.youtubeclone.service.VideoService;

@Service
public class VideoServiceImpl implements VideoService{

	@Autowired
	private VideoDao videoRepo;
	
	@Override
	public Boolean uploadFile(MultipartFile File) {
		
		AWSCredentials credentials = new BasicAWSCredentials(
				  "AKIA2QUYS7ENB4TWVCP6", 
				  "nMoh+HG59ICujdMpy3yF2XE86mPlGA4qx/BB79eQ"
				);
		
		AmazonS3 client = AmazonS3ClientBuilder
				  .standard()
				  .withCredentials(new AWSStaticCredentialsProvider(credentials))
				  .withRegion(Regions.US_EAST_2)
				  .build();

		
		var fileName = StringUtils.getFilenameExtension(File.getOriginalFilename());
		String key = UUID.randomUUID().toString()+fileName;
		String bucketName = "youtubeBucket-145";
		ObjectMetadata metaData = new ObjectMetadata();
		metaData.setContentLength(File.getSize());
		metaData.setContentType(File.getContentType());
		try {
			client.putObject(bucketName,key,File.getInputStream(),metaData);
		} catch (AmazonServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SdkClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		client.setObjectAcl(bucketName, key, CannedAccessControlList.PublicRead);
		String url =  client.getUrl(bucketName, key).toString();
		
		Video video  =new Video();
		video.setVideoUrl(url);
		
		videoRepo.save(video);
		return true;
	}

	
}
