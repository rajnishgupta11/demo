package com.example.demo.controller;

import java.util.concurrent.atomic.AtomicLong;

import com.example.demo.model.Greeting;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DemoController {

	private static final String template = "Hi, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/counter")
	@ResponseBody
	public Greeting getCounter(@RequestParam(name="name", required=false, defaultValue="Rajnish") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

	@GetMapping("/word-count")
	@ResponseBody
	public Greeting getWordCount(@RequestParam(name="name", required=false, defaultValue="Rajnish") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
}
