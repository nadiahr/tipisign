package org.side.service;

import java.util.List;

import org.side.dao.CompanyRepository;
import org.side.entites.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

// TODO: Auto-generated Javadoc
/**
 * The Class CompanyService.
 */
@RestController
@CrossOrigin(origins = "**")
public class CompanyService {
	
	/** The company repository. */
	@Autowired
	private CompanyRepository companyRepository;

	/**
	 * Save company.
	 *
	 * @param c the c
	 * @return the company
	 */
	@RequestMapping(value = "/Company", method = RequestMethod.POST)
	public Company saveCompany(@RequestBody Company c) {
		return companyRepository.save(c);
	}

	/**
	 * List company.
	 *
	 * @return the list
	 */
	@RequestMapping(value = "/Company", method = RequestMethod.GET)
	public List<Company> listCompany() {
		return companyRepository.findAll();
	}

}
