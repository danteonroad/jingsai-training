package org.dante.ccb.training.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BootstrapService {

	@Value("${training.svc1.url}")
	private String remoteUrl;
	@Autowired
	private RestTemplate restTemplate;
	
	@PostConstruct
	public void init() {
		String svc1 = restTemplate.getForObject(remoteUrl + "/health", String.class);
		System.out.println("================> training svc1 response: " + svc1);
	}
	
	public String svc1IP() {
		String svc1IP = restTemplate.getForObject(remoteUrl + "/api/ip", String.class);
		return svc1IP;
	}

}
