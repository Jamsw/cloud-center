package com.sparticles.nacosadapter.controller;

import com.sparticles.nacosadapter.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import rx.Single;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class ServiceController {

	private static final String CONSUL_IDX_HEADER = "X-Consul-Index";

	private static final String QUERY_PARAM_WAIT = "wait";
	private static final String QUERY_PARAM_INDEX = "index";

	private static final Pattern WAIT_PATTERN = Pattern.compile("(\\d*)(m|s|ms|h)");
	private static final Random RANDOM = new Random();

	@Autowired
	private RegistrationService registrationService;

	@GetMapping(value = "/v1/catalog/services", produces = MediaType.APPLICATION_JSON_VALUE)
	public Single<ResponseEntity<Map<String, String[]>>> getServiceNames(
			@RequestParam(name = QUERY_PARAM_WAIT, required = false) String wait,
			@RequestParam(name = QUERY_PARAM_INDEX, required = false) Long index) {
		return registrationService.getServiceNames(getWaitMillis(wait), index)
				.map(item -> createResponseEntity(item.getItem(), item.getChangeIndex()));
	}

	@GetMapping(value = "/v1/catalog/service/{appName}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Single<ResponseEntity<List<Map<String, Object>>>> getService(@PathVariable("appName") String appName,
																		@RequestParam(name = QUERY_PARAM_WAIT, required = false) String wait,
																		@RequestParam(name = QUERY_PARAM_INDEX, required = false) Long index) {
		Assert.isTrue(appName != null, "service name can not be null");
		return registrationService.getService(appName, getWaitMillis(wait), index).map(item -> {
			return createResponseEntity(item.getItem(), item.getChangeIndex());
		});
	}

	@GetMapping(value = "/v1/health/service/{appName}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Single<ResponseEntity<List<Map<String, Object>>>> getServiceHealth(@PathVariable("appName") String appName,
																			  @RequestParam(name = QUERY_PARAM_WAIT, required = false) String wait,
																			  @RequestParam(name = QUERY_PARAM_INDEX, required = false) Long index) {
		Assert.isTrue(appName != null, "service name can not be null");
		return registrationService.getServiceHealth(appName, getWaitMillis(wait), index).map(item -> {
			return createResponseEntity(item.getItem(), item.getChangeIndex());
		});
	}

	private MultiValueMap<String, String> createHeaders(long index) {
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
		headers.add(CONSUL_IDX_HEADER, "" + index);
		return headers;
	}

	private <T> ResponseEntity<T> createResponseEntity(T body, long index) {
		return new ResponseEntity<>(body, createHeaders(index), HttpStatus.OK);
	}

	/**
	 * Details to the wait behaviour can be found
	 * https://www.consul.io/api/index.html#blocking-queries
	 */
	private long getWaitMillis(String wait) {
		// default from consul docu
		long millis = TimeUnit.MINUTES.toMillis(5);
		if (wait != null) {
			Matcher matcher = WAIT_PATTERN.matcher(wait);
			if (matcher.matches()) {
				Long value = Long.valueOf(matcher.group(1));
				TimeUnit timeUnit = parseTimeUnit(matcher.group(2));
				millis = timeUnit.toMillis(value);
			} else {
				throw new IllegalArgumentException("Invalid wait pattern");
			}
		}
		return millis + RANDOM.nextInt(((int) millis / 16) + 1);
	}

	private TimeUnit parseTimeUnit(String unit) {
		switch (unit) {
			case "h":
				return TimeUnit.HOURS;
			case "m":
				return TimeUnit.MINUTES;
			case "s":
				return TimeUnit.SECONDS;
			case "ms":
				return TimeUnit.MILLISECONDS;
			default:
				throw new IllegalArgumentException("No valid time unit");
		}
	}
}