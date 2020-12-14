package stp.projet.webClient.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class GenericProxy {

	protected RestTemplate restTemplate;
}
