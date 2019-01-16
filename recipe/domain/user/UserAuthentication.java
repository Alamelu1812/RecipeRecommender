package recipe.domain.user;

public class UserAuthentication {

	private String userName;
	
	private String password;
	
	private String sessionId;

	public UserAuthentication() {
	}

	public UserAuthentication(String userName, String password, String sessionId) {
		this.userName = userName;
		this.password = password;
		this.sessionId = sessionId;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((sessionId == null) ? 0 : sessionId.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof UserAuthentication)) {
			return false;
		}
		UserAuthentication other = (UserAuthentication) obj;
		if (password == null) {
			if (other.password != null) {
				return false;
			}
		} else if (!password.equals(other.password)) {
			return false;
		}
		if (sessionId == null) {
			if (other.sessionId != null) {
				return false;
			}
		} else if (!sessionId.equals(other.sessionId)) {
			return false;
		}
		if (userName == null) {
			if (other.userName != null) {
				return false;
			}
		} else if (!userName.equals(other.userName)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserAuthentication [userName=").append(userName).append(", password=").append(password)
				.append(", sessionId=").append(sessionId).append("]");
		return builder.toString();
	}
}
