package org.dante.ccb.training.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.dante.ccb.training.service.BootstrapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class APIController {
	
	@Autowired
	private BootstrapService bootstrapService;

	@GetMapping("/svc1_ip")
	public String svc1IP() {
		String svc1IP = bootstrapService.svc1IP();
		return "业务1 [".concat(svc1IP).concat(" ].");
	}
	
	@GetMapping("/ip")
	public String ip() throws UnknownHostException {
		return InetAddress.getLocalHost().getHostName() + " / " + InetAddress.getLocalHost().getHostAddress();
	}

}
