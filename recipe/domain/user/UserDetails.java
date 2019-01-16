package recipe.domain.user;

import java.util.Date;

public class UserDetails {

	private String userName;

	private String passWord;

	private Country country;

	private Date dateOfBirth;

	public UserDetails() {
	}

	public UserDetails(String userName, String passWord, Country country, Date dateOfBirth) {
		this.userName = userName;
		this.passWord = passWord;
		this.country = country;
		this.dateOfBirth = dateOfBirth;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
		result = prime * result + ((passWord == null) ? 0 : passWord.hashCode());
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
		if (!(obj instanceof UserDetails)) {
			return false;
		}
		UserDetails other = (UserDetails) obj;
		if (country != other.country) {
			return false;
		}
		if (dateOfBirth == null) {
			if (other.dateOfBirth != null) {
				return false;
			}
		} else if (!dateOfBirth.equals(other.dateOfBirth)) {
			return false;
		}
		if (passWord == null) {
			if (other.passWord != null) {
				return false;
			}
		} else if (!passWord.equals(other.passWord)) {
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
		builder.append("UserDetails [userName=").append(userName).append(", passWord=").append(passWord)
				.append(", country=").append(country).append(", dateOfBirth=").append(dateOfBirth).append("]");
		return builder.toString();
	}

	
}
