package org.dante.ccb.training.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class APIController {

	@Value("${businessName}")
	private String teamName;

	@GetMapping("/svc")
	public String hello() {
		return teamName;
	}
	
	@GetMapping("/ip")
	public String ip() throws UnknownHostException {
		return InetAddress.getLocalHost().getHostName() + " / " + InetAddress.getLocalHost().getHostAddress();
	}


}
