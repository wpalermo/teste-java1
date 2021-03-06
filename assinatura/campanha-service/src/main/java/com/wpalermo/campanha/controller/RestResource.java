package com.wpalermo.campanha.controller;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;

public interface RestResource<T, K> {

	
	ResponseEntity<T> get() ;
	
	ResponseEntity<T> put(Integer id, RequestEntity<K> request);
	
	ResponseEntity<T> post(RequestEntity<K> request) ;
	
	void delete(String id);
	
	
}
