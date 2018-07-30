package org.side.service;

import java.util.List;

import org.side.dao.NotificationRepository;
import org.side.entites.Notification;
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
 * The Class NotificationService.
 */
@RestController
@CrossOrigin(origins = "**")
public class NotificationService {

	/** The notification repository. */
	@Autowired
	private NotificationRepository notificationRepository;

	/**
	 * Save user role.
	 *
	 * @param a the a
	 * @return the notification
	 */
	@RequestMapping(value = "/Notification", method = RequestMethod.POST)
	public Notification saveUserRole(@RequestBody Notification a) {
		return notificationRepository.save(a);
	}

	/**
	 * List user role.
	 *
	 * @return the list
	 */
	@RequestMapping(value = "/getNotification", method = RequestMethod.GET)
	public List<Notification> listUserRole() {
		return notificationRepository.findAll();
	}

	/**
	 * Find all notification.
	 *
	 * @param num the num
	 * @param size the size
	 * @return the page
	 */
	public Page<Notification> findAllNotification(@RequestParam(name = "num", defaultValue = "0") int num,
			@RequestParam(name = "size", defaultValue = "3") int size) {
		return notificationRepository.findAll(new PageRequest(num, size));
	}

}
