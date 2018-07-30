package org.side.service;

import java.util.List;

import org.side.dao.LineProgressRepository;
import org.side.entites.LineProgress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

// TODO: Auto-generated Javadoc
/**
 * The Class LineProgressService.
 */
@RestController
public class LineProgressService {

	/** The line progress repository. */
	@Autowired
	LineProgressRepository lineProgressRepository;

	/**
	 * Save line progress.
	 *
	 * @param L the l
	 * @return the line progress
	 */
	@RequestMapping(value = "/LineProgress", method = RequestMethod.POST)
	public LineProgress saveLineProgress(LineProgress L) {
		return lineProgressRepository.save(L);
	}

	/**
	 * List line progress.
	 *
	 * @return the list
	 */
	@RequestMapping(value = "/getLineProgress", method = RequestMethod.GET)
	public List<LineProgress> listLineProgress() {
		return lineProgressRepository.findAll();
	}

}