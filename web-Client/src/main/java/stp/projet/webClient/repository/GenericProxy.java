package stp.projet.webClient.repository;

import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class GenericProxy {

	protected RestTemplate restTemplate;
}
