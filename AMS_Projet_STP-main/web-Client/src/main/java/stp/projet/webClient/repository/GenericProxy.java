package stp.projet.webClient.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import stp.projet.webClient.CustomProperties;

@Repository
public class GenericProxy {

	@Autowired
	protected CustomProperties props;
	
	@Autowired
	protected RestTemplate restTemplate;
}
