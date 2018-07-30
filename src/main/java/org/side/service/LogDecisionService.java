package org.side.service;

import java.util.List;

import org.side.dao.LogDecisionRepository;
import org.side.entites.LogDecision;
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
 * The Class LogDecisionService.
 */
@RestController
@CrossOrigin(origins = "**")
public class LogDecisionService {

	/** The log decision repository. */
	@Autowired
	private LogDecisionRepository logDecisionRepository;

	/**
	 * Save user role.
	 *
	 * @param a the a
	 * @return the log decision
	 */
	@RequestMapping(value = "/LogDecision", method = RequestMethod.POST)
	public LogDecision saveUserRole(@RequestBody LogDecision a) {
		return logDecisionRepository.save(a);
	}

	/**
	 * List user role.
	 *
	 * @return the list
	 */
	@RequestMapping(value = "/getLogDecision", method = RequestMethod.GET)
	public List<LogDecision> listUserRole() {
		return logDecisionRepository.findAll();
	}

	/**
	 * Find all log decision.
	 *
	 * @param num the num
	 * @param size the size
	 * @return the page
	 */
	public Page<LogDecision> findAllLogDecision(@RequestParam(name = "num", defaultValue = "0") int num,
			@RequestParam(name = "size", defaultValue = "3") int size) {
		return logDecisionRepository.findAll(new PageRequest(num, size));
	}

}
