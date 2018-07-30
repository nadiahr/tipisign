package org.side.service;

import org.side.dao.LogRequestRepository;

import org.side.entites.LogRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// TODO: Auto-generated Javadoc
/**
 * The Class LogRequestService.
 */
@RestController
@CrossOrigin(origins = "**")
public class LogRequestService {
	
	/** The log request repository. */
	@Autowired
	private LogRequestRepository logRequestRepository;

	/**
	 * Save user role.
	 *
	 * @param a the a
	 * @return the log request
	 */
	@RequestMapping(value = "/LogRequest", method = RequestMethod.POST)
	public LogRequest saveUserRole(@RequestBody LogRequest a) {
		return logRequestRepository.save(a);
	}


	/**
	 * Find all log request.
	 *
	 * @param num the num
	 * @param size the size
	 * @return the page
	 */
	public Page<LogRequest> findAllLogRequest(@RequestParam(name = "num", defaultValue = "0") int num,
			@RequestParam(name = "size", defaultValue = "3") int size) {
		return logRequestRepository.findAll(new PageRequest(num, size));
	}
	
	/**
	 * Find log request.
	 *
	 * @param motclee the motclee
	 * @param numPage the num page
	 * @param size the size
	 * @return the page
	 */
	@RequestMapping(value = "/getLogRequest", method = RequestMethod.GET)
	public Page<LogRequest> findLogRequest(@RequestParam(name = "motclee") long motclee,
			@RequestParam(name = "numPage", defaultValue = "0") int numPage,
			@RequestParam(name = "size", defaultValue = "5") int size) {
		return  logRequestRepository.findRequest(motclee, new PageRequest(numPage, size));

	}

	
}
