package com.wpalermo.socioTorcedor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.wpalermo.socioTorcedor.entities.SocioTorcedor;
import com.wpalermo.socioTorcedor.exception.PersistenceException;
import com.wpalermo.socioTorcedor.exception.SocioTorcedorException;
import com.wpalermo.socioTorcedor.response.CadastrarSocioTorcedorResponse;
import com.wpalermo.socioTorcedor.service.ISocioTorcedorService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/socioTorcedor")
public class SocioTorcedorController {

	
	@Autowired
	private ISocioTorcedorService socioTorcedorService;
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public ResponseEntity<CadastrarSocioTorcedorResponse> post(RequestEntity<SocioTorcedor> request) throws SocioTorcedorException, PersistenceException {
		return new ResponseEntity<>(socioTorcedorService.cadastrarSocioTorcedor(request.getBody()), HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public ResponseEntity<SocioTorcedor> get(String email) throws SocioTorcedorException, PersistenceException {
		return new ResponseEntity<>(socioTorcedorService.buscarSocioTorcedor(email), HttpStatus.OK);
	}
	
	
}
