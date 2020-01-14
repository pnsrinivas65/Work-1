package hello.lambda;

public class Email {
	
	public String emailId;

	public Email(String emailId) {
		
		this.emailId = emailId;
	}
	
	/**
	 * @return the emailId
	 */
	public String getEmailId() {
		return emailId;
	}

	/**
	 * @param emailId the emailId to set
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

}
