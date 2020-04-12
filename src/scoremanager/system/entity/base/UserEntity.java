package scoremanager.system.entity.base;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import scoremanager.common.entity.base.BaseEntity;

/**
 * 用户表
 * @author redburning
 *
 */
@Entity
@Table(name="T_S_USER")
public class UserEntity extends BaseEntity {

	private static final long serialVersionUID = -8035958629397348148L;

	/**
	 * 角色状态: 正常
	 */
	public static final int STATUS_NORMAL = 1;
	/**
	 * 角色状态: 禁用
	 */
	public static final int STATUS_FORBIDDEN = 2;
	
	private int status;
	
	/**
	 * 用户名
	 */
	@Column(nullable = false, length = 50)
	private String username;
	
	/**
	 * 密码
	 */
	@Column(nullable = false, length = 32)
	private String password;
	
	/**
	 * 真实姓名
	 */
	@Column(nullable = false, length = 20)
	private String realName;
	
	/**
	 * 电子邮件
	 */
	@Column(length = 50)
	private String email;
	
	/**
	 * 电话
	 */
	@Column(length = 20)
	private String phone;
	
	/**
	 * 职务
	 */
	@Column(length = 20)
	private String position;
	
	/**
	 * 职务说明
	 */
	@Column(length = 100)
	private String potisionDesc;

	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getPotisionDesc() {
		return potisionDesc;
	}

	public void setPotisionDesc(String potisionDesc) {
		this.potisionDesc = potisionDesc;
	}
	
	
}
