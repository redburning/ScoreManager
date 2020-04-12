package scoremanager.system.vo;

import java.io.Serializable;
import java.util.Date;

import scoremanager.system.entity.base.UserEntity;

public class Client implements Serializable {

	private static final long serialVersionUID = -4158396693181487218L;

	private UserEntity user;
	
	/**
	 * 用户ip
	 */
	private String ip;
	
	/**
	 * 登录时间
	 */
	private Date logindatetime;
	
	public UserEntity getUser() {
		return user;
	}
	
	public void setUser(UserEntity user) {
		this.user = user;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Date getLogindatetime() {
		return logindatetime;
	}

	public void setLogindatetime(Date logindatetime) {
		this.logindatetime = logindatetime;
	}
	
}
