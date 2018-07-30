package org.side.service;

import java.util.List;

import org.side.controller.TipiSignRequest;
import org.side.dao.RequestRepository;
import org.side.dao.UserToUserRequestRepository;
import org.side.dto.RequestDto;
import org.side.entites.LogRequest;
import org.side.entites.Request;
import org.side.entites.UserInformation;
import org.side.entites.UserToUserRequest;
import org.side.entites.UserToUserRequestPK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// TODO: Auto-generated Javadoc
/**
 * The Class UserToUserRequestService.
 */
@RestController
@CrossOrigin(origins = "**")
public class UserToUserRequestService {
	
	/** The user to user request repository. */
	@Autowired
	UserToUserRequestRepository userToUserRequestRepository;
	
	/** The Request repository. */
	@Autowired
	RequestRepository RequestRepository;
	
	/** The tipi sign request. */
	@Autowired
	TipiSignRequest tipiSignRequest;

	/**
	 * Save user to user request.
	 *
	 * @param u the u
	 * @return the user to user request
	 */
	@RequestMapping(value = "/UserToUser", method = RequestMethod.POST)
	public UserToUserRequest saveUserToUserRequest(@RequestBody UserToUserRequest u) {
		return userToUserRequestRepository.save(u);
	}

	/**
	 * Save.
	 *
	 * @param id the id
	 * @param dto the dto
	 */
	@RequestMapping(value = "/requests/{id}", method = RequestMethod.PUT)
	public void save(@PathVariable int id, @RequestBody RequestDto dto) {
		System.out.println(dto);
		UserToUserRequest r = userToUserRequestRepository.findRequest(id);
		userToUserRequestRepository.delete(r);

		tipiSignRequest.saveRequestAndUser(dto.getRequest(), dto.getUserFrom(), dto.getUserTo());
		// userToUserRequestRepository.save(r);

	}
	
	/**
	 * Request pending.
	 *
	 * @param idUser the id user
	 * @return the int
	 */
	@RequestMapping(value = "/getRequestsPending/{idUser}", method = RequestMethod.GET)
    public int requestPending(@PathVariable String idUser) {
        return userToUserRequestRepository.requestPending(idUser).size();
    }
    
	/**
	 * Request approved.
	 *
	 * @param idUser the id user
	 * @return the int
	 */
	@RequestMapping(value = "/getRequestsApproved/{idUser}", method = RequestMethod.GET)
    public int requestApproved (@PathVariable String idUser) {
        return userToUserRequestRepository.requestApproved(idUser).size();
    }
    
    /**
     * Request disapproved.
     *
     * @param idUser the id user
     * @return the int
     */
    @RequestMapping(value = "/getRequestsDisapproved/{idUser}", method = RequestMethod.GET)
    public int requestDisapproved(@PathVariable String idUser) {
        return userToUserRequestRepository.requestDisapproved(idUser).size();
    }
	
	/**
	 * Save.
	 *
	 * @param id the id
	 * @param R the r
	 * @return the user to user request
	 */
	@RequestMapping(value = "/request/{id}", method = RequestMethod.PUT)
	public UserToUserRequest save(@PathVariable int id, @RequestBody UserToUserRequest R) {
		System.out.println(R);
		UserToUserRequest r = userToUserRequestRepository.findRequest(id);
		r.setUserToUserRequestPK(R.getUserToUserRequestPK());
		r.setUserTo(R.getUserTo());
		r.getUserToUserRequestPK().setIdUserTo(R.getUserToUserRequestPK().getIdUserTo());
		
		return userToUserRequestRepository.saveAndFlush(r);

	}

	/**
	 * List user to user request.
	 *
	 * @return the list
	 */
	@RequestMapping(value = "/getUserToUser", method = RequestMethod.GET)
	public List<UserToUserRequest> listUserToUserRequest() {
		return userToUserRequestRepository.findAll();
	}

	/**
	 * Gets the user.
	 *
	 * @param id the id
	 * @return the user
	 */
	@RequestMapping(value = "/selectedRequest/{id}", method = RequestMethod.GET)

	public UserToUserRequest getUser(@PathVariable long id) {
		return userToUserRequestRepository.findRequest(id);

	}

	/**
	 * Find all user to user request.
	 *
	 * @param num the num
	 * @param size the size
	 * @return the page
	 */
	public Page<UserToUserRequest> findAllUserToUserRequest(@RequestParam(name = "num", defaultValue = "0") int num,
			@RequestParam(name = "size", defaultValue = "10") int size) {
		return userToUserRequestRepository.findAll(new PageRequest(num, size));
	}

	/**
	 * Chercher disavpoved.
	 *
	 * @param motcle the motcle
	 * @param numPage the num page
	 * @param size the size
	 * @return the page
	 */
	@RequestMapping(value = "/chercherDisavpoved", method = RequestMethod.GET)
	public Page<UserToUserRequest> chercherDisavpoved(@RequestParam(name = "motcle") String motcle, 
		
			@RequestParam(name = "numPage", defaultValue = "0") int numPage,
			@RequestParam(name = "size", defaultValue = "5") int size) {
		System.out.println("motcle = " + motcle);
		System.out.println("numpage = " + numPage);
		System.out.println("size = " + size);
		return userToUserRequestRepository.chercherDisavpoved("%" + motcle + "%",  new PageRequest(numPage, size));

	}
	
	/**
	 * Chercher.
	 *
	 * @param motcle the motcle
	 * @param userId the user id
	 * @param userToId the user to id
	 * @param numPage the num page
	 * @param size the size
	 * @return the page
	 */
	@RequestMapping(value = "/chercher", method = RequestMethod.GET)
	public Page<UserToUserRequest> chercher(@RequestParam(name = "motcle") long motcle, 
			@RequestParam(name = "userId") String userId ,
			@RequestParam(name = "userToId") String userToId , 
			@RequestParam(name = "numPage", defaultValue = "0") int numPage,
			@RequestParam(name = "size", defaultValue = "5") int size) {
		System.out.println("motcle = " + motcle);
		System.out.println("numpage = " + numPage);
		System.out.println("size = " + size);
		return userToUserRequestRepository.chercher(motcle, userId, userToId, new PageRequest(numPage, size));

	}
	
	/**
	 * Find requestby user.
	 *
	 * @param motcle the motcle
	 * @param status the status
	 * @param numPage the num page
	 * @param size the size
	 * @return the page
	 */
	@RequestMapping(value = "/requestByUser", method = RequestMethod.GET)
	public Page<UserToUserRequest> findRequestbyUser(@RequestParam(name = "motcle") String motcle,
			@RequestParam(name = "status") String status,
			@RequestParam(name = "numPage", defaultValue = "0") int numPage,
			@RequestParam(name = "size", defaultValue = "5") int size) {
		System.out.println("motcle = " + motcle);
		System.out.println("numpage = " + numPage);
		System.out.println("size = " + size);
		return userToUserRequestRepository.findRequestbyUser(motcle, status , new PageRequest(numPage, size));

	}
	
	/**
	 * Find all requestby user.
	 *
	 * @param motcle the motcle
	 * @param numPage the num page
	 * @param size the size
	 * @return the page
	 */
	@RequestMapping(value = "/allrequestByUser", method = RequestMethod.GET)
	public Page<UserToUserRequest> findAllRequestbyUser(@RequestParam(name = "motcle") String motcle,
			
			@RequestParam(name = "numPage", defaultValue = "0") int numPage,
			@RequestParam(name = "size", defaultValue = "5") int size) {
		System.out.println("motcle = " + motcle);
		System.out.println("numpage = " + numPage);
		System.out.println("size = " + size);
		return userToUserRequestRepository.findAllRequestbyUser(motcle,  new PageRequest(numPage, size));

	}
	// @RequestMapping(value = "/UserToUserRequests/{id}", method =
	// RequestMethod.PUT)
	// public UserToUserRequest save(@PathVariable int id, @RequestBody
	// UserToUserRequest c) {
	// UserToUserRequest r = userToUserRequestRepository.findRequest(id);
	//
	// return userToUserRequestRepository.save(c);
	//
	// }

	/**
	 * Delete.
	 *
	 * @param id the id
	 * @return true, if successful
	 */
	@RequestMapping(value = "/supprimer/{id}", method = RequestMethod.DELETE)
	public boolean delete(@PathVariable long id) {

		UserToUserRequest r = userToUserRequestRepository.findRequest(id);
		Request request = RequestRepository.findOne(id);
		userToUserRequestRepository.delete(r);
		RequestRepository.delete(request);

		return true;
	}

}