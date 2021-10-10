package com.account.controller;

import java.util.Collections;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.account.model.NotificationResponse;
import com.account.model.StockResponse;
import com.account.model.User;
import com.account.service.CallNotificationService;
import com.account.service.UserService;
import com.fasterxml.jackson.databind.JsonNode;

@RestController
@PropertySource("classpath:Configurations.properties")
public class UserController {
	@Autowired
	UserService userService;

	@Resource(name = "call")
	CallNotificationService notificationService;
	@Autowired
	RestTemplate restClient;
	@Value("${nse.Gainers}")
	String url;

	@GetMapping("${UserController.GetNotificationsByUserId}")
	public NotificationResponse notifications(@PathVariable String userId) {
		return notificationService.getNotifications(userId);
	}

	@GetMapping("/quote/{symbol}")
	public Double getAllUser(@PathVariable String symbol) {
//		JsonNode response = restClient.getForObject(url, JsonNode.class);
		HttpHeaders headers = new HttpHeaders();
		
		String url = this.url.replace("symbol", symbol);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		ResponseEntity<JsonNode> response = restClient.exchange(url, HttpMethod.GET, new HttpEntity<>("body", headers),
				JsonNode.class);

		JsonNode result = response.getBody().get("chart").get("result").get(0).get("meta").get("regularMarketPrice");
		return (Double) result.asDouble();
	}

	@GetMapping("${UserController.GetUsersById}")
	public User getUser(@PathVariable(required = false) String id) {
		return userService.getUser(id);
	}

	@PostMapping("${UserController.CreateUsers}")
	public User createUser(@RequestBody User user) {
		return userService.createUser(user);
	}

}
