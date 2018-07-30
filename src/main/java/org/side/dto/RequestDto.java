

package org.side.dto;

import org.side.entites.Request;
import org.side.entites.UserInformation;

public class RequestDto {

	private UserInformation userTo;
	private UserInformation userFrom;
	private Request request;
	private long oldIdRequest ; 

	public long getOldIdRequest() {
		return oldIdRequest;
	}

	public void setOldIdRequest(long oldIdRequest) {
		this.oldIdRequest = oldIdRequest;
	}

	public RequestDto() {

	}

	

	public RequestDto(UserInformation userTo, UserInformation userFrom, Request request, long oldIdRequest) {
		
		this.userTo = userTo;
		this.userFrom = userFrom;
		this.request = request;
		this.oldIdRequest = oldIdRequest;
	}

	public UserInformation getUserTo() {
		return userTo;
	}

	public void setUserTo(UserInformation userTo) {
		this.userTo = userTo;
	}

	public UserInformation getUserFrom() {
		return userFrom;
	}

	public void setUserFrom(UserInformation userFrom) {
		this.userFrom = userFrom;
	}

	public Request getRequest() {
		return request;
	}

	public void setRequest(Request request) {
		this.request = request;
	}

	@Override
	public String toString() {
		return "RequestDto [userTo=" + userTo + ", userFrom=" + userFrom + ", request=" + request + ", oldIdRequest="
				+ oldIdRequest + "]";
	}

	
}
