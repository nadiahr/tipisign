package org.side.service;

import java.util.List;

import org.side.controller.TipiSignRequest;
import org.side.dao.RequestRepository;
import org.side.dto.RequestDto;
import org.side.entites.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

// TODO: Auto-generated Javadoc
/**
 * The Class RequestService.
 */
@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "**")
public class RequestService {
	
	/** The request repository. */
	@Autowired
	private RequestRepository requestRepository;

	/** The tipi sign request. */
	@Autowired
	TipiSignRequest tipiSignRequest;

	/**
	 * Save request.
	 *
	 * @param r the r
	 * @return the request
	 */
	@RequestMapping(value = "/Request", method = RequestMethod.POST)
	public Request saveRequest(@RequestBody Request r) {
		return requestRepository.save(r);
	}
	
	/**
	 * Save.
	 *
	 * @param id the id
	 * @param c the c
	 * @return the request
	 */
	@RequestMapping(value = "/Requests/{id}", method = RequestMethod.PUT)
	public Request save(@PathVariable int id, @RequestBody Request c) {
		c.getIdRequest();

		return requestRepository.save(c);

	}
	
	/**
	 * Adds the request.
	 *
	 * @param dto the dto
	 */
	@RequestMapping(value = "/Requests", method = RequestMethod.POST)
	public void addRequest(@RequestBody RequestDto dto) {
		tipiSignRequest.saveRequestAndUser(dto.getRequest(), dto.getUserFrom(), dto.getUserTo());
	}
	
	/**
	 * Pass request.
	 *
	 * @param dto the dto
	 */
	@RequestMapping(value = "/passRequests", method = RequestMethod.POST)
	public void passRequest(@RequestBody RequestDto dto) {
		tipiSignRequest.passRequestAndUser(dto.getRequest(), dto.getUserFrom(), dto.getUserTo(),dto.getOldIdRequest());
	}

	/**
	 * List request.
	 *
	 * @return the list
	 */
	@RequestMapping(value = "/getRequest", method = RequestMethod.GET)
	public List<Request> listRequest() {
		return requestRepository.findAll();
	}
	
	
	
	

	/**
	 * Gets the request.
	 *
	 * @param id the id
	 * @return the request
	 */
	@RequestMapping(value = "/request/{id}", method = RequestMethod.GET)
	public Request getRequest(@PathVariable int id) {
		return requestRepository.findOne(id);
	}

	/**
	 * Delete.
	 *
	 * @param id the id
	 * @return true, if successful
	 */
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public boolean delete(@PathVariable int id) {
		requestRepository.delete(id);
		return true;
	}


}