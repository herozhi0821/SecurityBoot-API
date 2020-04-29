package net.cnki.usermanage.bean;

import java.util.Date;

public class SysUser {
    private Integer userId;
    private String username;

    private String password;

    private String parentName;

    private String company;
    private String cpyBranch;

    private String userIp;
    private Integer uploadAmount;
    private Integer uploadResidue;//上传剩余篇数
    
    private Integer status;

    private Integer role;

    private Integer pwdRole;
    private Date createtime;

    private Date startTime;

    private Date endTime;

    private String phoneNumber;

    private String mail;

    private String remark;


	public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName == null ? null : parentName.trim();
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    public String getCpyBranch() {
        return cpyBranch;
    }

    public void setCpyBranch(String cpyBranch) {
        this.cpyBranch = cpyBranch == null ? null : cpyBranch.trim();
    }

    public String getUserIp() {
		return userIp;
	}

	public void setUserIp(String userIp) {
		this.userIp = userIp;
	}

	public Integer getUploadAmount() {
        return uploadAmount;
    }

    public void setUploadAmount(Integer uploadAmount) {
        this.uploadAmount = uploadAmount;
    }

    public Integer getUploadResidue() {
        return uploadResidue;
    }

    public void setUploadResidue(Integer uploadResidue) {
        this.uploadResidue = uploadResidue;
    }
    
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public Integer getPwdRole() {
        return pwdRole;
    }

    public void setPwdRole(Integer pwdRole) {
        this.pwdRole = pwdRole;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber == null ? null : phoneNumber.trim();
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail == null ? null : mail.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
    
    public SysUser() {
		super();
		// TODO Auto-generated constructor stub
	}
    
  //添加用户时使用
  	public SysUser(String username, String password, String parentName, String company,String cpyBranch,String userIp,Integer uploadAmount, Integer uploadResidue,Integer status,Integer role, Integer pwdRole) {
  		super();
  		this.username = username;
  		this.password = password;
  		this.parentName = parentName;
  		this.company = company;
  		this.cpyBranch = cpyBranch;
  		this.userIp = userIp;
  		this.uploadAmount = uploadAmount;
		this.uploadResidue = uploadResidue;
  		this.status = status;
  		this.role = role;
  		this.pwdRole = pwdRole;
  	}

  	

	public SysUser(Integer userId, String username, String password, String parentName, String company,
			String cpyBranch, String userIp, Integer uploadAmount, Integer uploadResidue, Integer status, Integer role,
			Integer pwdRole, Date createtime, Date startTime, Date endTime, String phoneNumber, String mail,
			String remark) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.parentName = parentName;
		this.company = company;
		this.cpyBranch = cpyBranch;
		this.userIp = userIp;
		this.uploadAmount = uploadAmount;
		this.uploadResidue = uploadResidue;
		this.status = status;
		this.role = role;
		this.pwdRole = pwdRole;
		this.createtime = createtime;
		this.startTime = startTime;
		this.endTime = endTime;
		this.phoneNumber = phoneNumber;
		this.mail = mail;
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "SysUser [userId=" + userId + ", username=" + username + ", password=" + password + ", parentName="
				+ parentName + ", company=" + company + ", cpyBranch=" + cpyBranch + ", uploadAmount=" + uploadAmount
				+ ", uploadResidue=" + uploadResidue + ", status=" + status + ", role=" + role + ", pwdRole=" + pwdRole
				+ ", createtime=" + createtime + ", startTime=" + startTime + ", endTime=" + endTime + ", phoneNumber="
				+ phoneNumber + ", mail=" + mail + ", remark=" + remark + "]";
	}
  	
}