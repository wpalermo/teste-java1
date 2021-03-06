package com.wpalermo.campanha.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.wpalermo.campanha.entities.Campanha;
import com.wpalermo.campanha.exception.CampanhaException;
import com.wpalermo.campanha.request.CampanhaRequest;
import com.wpalermo.campanha.response.CampanhaResponse;
import com.wpalermo.campanha.service.ICampanhaService;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping("/campanha")
public class CampanhaRestController  {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ICampanhaService campanhaService;



	@RequestMapping(method = RequestMethod.GET, produces= {"application/json"})
	@ResponseStatus(value = HttpStatus.OK)
	public @ResponseBody ResponseEntity<List<Campanha>> get() {

		CampanhaResponse campanha = new CampanhaResponse();
		campanha.setCampanhas(campanhaService.getAll());

		return new ResponseEntity<>(campanha.getCampanhas(), HttpStatus.OK);

	}

	@RequestMapping(method = RequestMethod.PUT, path = "/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public ResponseEntity<CampanhaResponse> put(@PathVariable Integer id, RequestEntity<CampanhaRequest> request) {

		Campanha c = request.getBody().getCampanha();
		c.setIdCampanha(id);

		
		campanhaService.createCampanha(c);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED)
	@ResponseBody
	public ResponseEntity<CampanhaResponse> post(RequestEntity<CampanhaRequest> request) {

		CampanhaRequest resource = request.getBody();

		if (resource.getCampanha() != null) {
			campanhaService.createCampanha(resource.getCampanha());

		} else {

			if (resource.getCampanhas() == null || resource.getCampanhas().size() == 0)
				return new ResponseEntity<>(HttpStatus.LENGTH_REQUIRED);

			if (resource.getCampanhas().size() < 1)
				throw new CampanhaException("Nenhum registro encontrado");
			else if (resource.getCampanhas().size() == 1)
				campanhaService.createCampanha(resource.getCampanhas().get(0));
			else
				campanhaService.createCampanha(resource.getCampanhas());
		}

		return new ResponseEntity<>(HttpStatus.CREATED);

	}

	@RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public void delete(@PathVariable String id) {
		campanhaService.deleteCampanha(id);
	}

}
