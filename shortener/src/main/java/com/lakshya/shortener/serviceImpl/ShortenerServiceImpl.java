package com.lakshya.shortener.serviceImpl;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lakshya.shortener.entity.MyEntity;
import com.lakshya.shortener.repository.MyRepository;

@Service
public class ShortenerServiceImpl {

	@Autowired
	private MyRepository myRepository;

    public String generateShortUrl(String url) {
    	 List<MyEntity> myEntities = myRepository.findByUrl(url);
    	 String shortUrl="";
         if (myEntities.isEmpty()) {
        	 shortUrl = generateShortUrl();
             MyEntity myEntity = new MyEntity();
             myEntity.setShortUrl(shortUrl);
             myEntity.setUrl(url);
             myRepository.save(myEntity);
             }
         else {
        	 shortUrl=myEntities.get(0).getShortUrl();
         }
       
        return "https://"+shortUrl;
    }

    public String getUrl(String shortUrl) {
        List<MyEntity> myEntities = myRepository.findByShortUrl(shortUrl);
        if (myEntities.isEmpty()) {
            return null;
        }
        return myEntities.get(0).getUrl();
    }

    private String generateShortUrl() {
        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            sb.append(alphabet.charAt(new Random().nextInt(alphabet.length())));
        }
        return sb.toString();
    }


    
}

