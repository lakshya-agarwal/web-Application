package com.lakshya.shortener.controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.lakshya.shortener.LogExecutionTime;
import com.lakshya.shortener.serviceImpl.ShortenerServiceImpl;

@RestController
@RequestMapping("/shortener")
public class ShortenerController {
    private Map<String, String> urlMap = new HashMap<>();
    private Random random = new Random();

    @Autowired
    private ShortenerServiceImpl shortenerService;

    @LogExecutionTime
    @PostMapping("/shorten")
    public ResponseEntity<String> shortenUrl(@RequestBody String url) {
        String shortUrl = shortenerService.generateShortUrl(url);
        return new ResponseEntity<>(shortUrl, HttpStatus.OK);
    }

    @PostMapping("/{shortUrl}")
    public RedirectView redirectToUrl(@PathVariable String shortUrl) {
        String longUrl = shortenerService.getUrl(shortUrl);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(longUrl);
        return redirectView;
    }
    
    
    @GetMapping("/abc/{url}")
    public ResponseEntity<String> url(@PathVariable String shortUrl) {
    	return new ResponseEntity<>(shortUrl, HttpStatus.OK);

    }


}

