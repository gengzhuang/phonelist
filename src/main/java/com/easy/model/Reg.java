package com.easy.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 注册model
 * 
 * @Title: RegModel.java
 * @Package com.huazhukeji.model
 * @author 寇正
 * @date 2016年7月19日 下午3:11:50
 * @company 河北华助科技有限公司
 * @version V1.0
 */
public class Reg extends User implements Serializable {

	private static final long serialVersionUID = -4030347044209345030L;
	private Long id;

    private String loginname;

    private String name;

    private String password;

    private Integer sex;

    private Integer age;

    private Integer usertype;

    private Integer status;

    private Integer organizationId;
    
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createdate;

    private String phone;
    
	private Long userid;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date obtaintime;
	
	private String obtaintimeStr;
	
	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	public Date getObtaintime() {
		return obtaintime;
	}
	public void setObtaintime(Date obtaintime) {
		this.obtaintime = obtaintime;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Integer getUsertype() {
		return usertype;
	}
	public void setUsertype(Integer usertype) {
		this.usertype = usertype;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getOrganizationId() {
		return organizationId;
	}
	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getObtaintimeStr() {
		return obtaintimeStr;
	}
	public void setObtaintimeStr(String obtaintimeStr) {
		this.obtaintimeStr = obtaintimeStr;
	}
}