package com.basic.person.model;

import java.io.Serializable;
import java.util.Date;

import com.basic.common.base.model.BaseQueryParam;

public class User extends BaseQueryParam implements Serializable{

	private static final long serialVersionUID = 1L;

	/**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TOPIC_USER_INFO.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TOPIC_USER_INFO.name
     *
     * @mbggenerated
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TOPIC_USER_INFO.phone
     *
     * @mbggenerated
     */
    private String phone;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TOPIC_USER_INFO.mail
     *
     * @mbggenerated
     */
    private String mail;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TOPIC_USER_INFO.password
     *
     * @mbggenerated
     */
    private String password;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TOPIC_USER_INFO.status
     *
     * @mbggenerated
     */
    private Integer status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TOPIC_USER_INFO.headImg
     *
     * @mbggenerated
     */
    private String headimg;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TOPIC_USER_INFO.sex
     *
     * @mbggenerated
     */
    private String sex;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TOPIC_USER_INFO.description
     *
     * @mbggenerated
     */
    private String description;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TOPIC_USER_INFO.createTime
     *
     * @mbggenerated
     */
    private Date createtime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TOPIC_USER_INFO.updateTime
     *
     * @mbggenerated
     */
    private Date updatetime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TOPIC_USER_INFO.uploadFlag
     *
     * @mbggenerated
     */
    private Integer uploadflag;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TOPIC_USER_INFO.account
     *
     * @mbggenerated
     */
    private String account;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TOPIC_USER_INFO.category
     *
     * @mbggenerated
     */
    private Integer category;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TOPIC_USER_INFO.autoName
     *
     * @mbggenerated
     */
    private String autoname;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TOPIC_USER_INFO.id
     *
     * @return the value of TOPIC_USER_INFO.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TOPIC_USER_INFO.id
     *
     * @param id the value for TOPIC_USER_INFO.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TOPIC_USER_INFO.name
     *
     * @return the value of TOPIC_USER_INFO.name
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TOPIC_USER_INFO.name
     *
     * @param name the value for TOPIC_USER_INFO.name
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TOPIC_USER_INFO.phone
     *
     * @return the value of TOPIC_USER_INFO.phone
     *
     * @mbggenerated
     */
    public String getPhone() {
        return phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TOPIC_USER_INFO.phone
     *
     * @param phone the value for TOPIC_USER_INFO.phone
     *
     * @mbggenerated
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TOPIC_USER_INFO.mail
     *
     * @return the value of TOPIC_USER_INFO.mail
     *
     * @mbggenerated
     */
    public String getMail() {
        return mail;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TOPIC_USER_INFO.mail
     *
     * @param mail the value for TOPIC_USER_INFO.mail
     *
     * @mbggenerated
     */
    public void setMail(String mail) {
        this.mail = mail == null ? null : mail.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TOPIC_USER_INFO.password
     *
     * @return the value of TOPIC_USER_INFO.password
     *
     * @mbggenerated
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TOPIC_USER_INFO.password
     *
     * @param password the value for TOPIC_USER_INFO.password
     *
     * @mbggenerated
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TOPIC_USER_INFO.status
     *
     * @return the value of TOPIC_USER_INFO.status
     *
     * @mbggenerated
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TOPIC_USER_INFO.status
     *
     * @param status the value for TOPIC_USER_INFO.status
     *
     * @mbggenerated
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TOPIC_USER_INFO.headImg
     *
     * @return the value of TOPIC_USER_INFO.headImg
     *
     * @mbggenerated
     */
    public String getHeadimg() {
        return headimg;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TOPIC_USER_INFO.headImg
     *
     * @param headimg the value for TOPIC_USER_INFO.headImg
     *
     * @mbggenerated
     */
    public void setHeadimg(String headimg) {
        this.headimg = headimg == null ? null : headimg.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TOPIC_USER_INFO.sex
     *
     * @return the value of TOPIC_USER_INFO.sex
     *
     * @mbggenerated
     */
    public String getSex() {
        return sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TOPIC_USER_INFO.sex
     *
     * @param sex the value for TOPIC_USER_INFO.sex
     *
     * @mbggenerated
     */
    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TOPIC_USER_INFO.description
     *
     * @return the value of TOPIC_USER_INFO.description
     *
     * @mbggenerated
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TOPIC_USER_INFO.description
     *
     * @param description the value for TOPIC_USER_INFO.description
     *
     * @mbggenerated
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TOPIC_USER_INFO.createTime
     *
     * @return the value of TOPIC_USER_INFO.createTime
     *
     * @mbggenerated
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TOPIC_USER_INFO.createTime
     *
     * @param createtime the value for TOPIC_USER_INFO.createTime
     *
     * @mbggenerated
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TOPIC_USER_INFO.updateTime
     *
     * @return the value of TOPIC_USER_INFO.updateTime
     *
     * @mbggenerated
     */
    public Date getUpdatetime() {
        return updatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TOPIC_USER_INFO.updateTime
     *
     * @param updatetime the value for TOPIC_USER_INFO.updateTime
     *
     * @mbggenerated
     */
    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TOPIC_USER_INFO.uploadFlag
     *
     * @return the value of TOPIC_USER_INFO.uploadFlag
     *
     * @mbggenerated
     */
    public Integer getUploadflag() {
        return uploadflag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TOPIC_USER_INFO.uploadFlag
     *
     * @param uploadflag the value for TOPIC_USER_INFO.uploadFlag
     *
     * @mbggenerated
     */
    public void setUploadflag(Integer uploadflag) {
        this.uploadflag = uploadflag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TOPIC_USER_INFO.account
     *
     * @return the value of TOPIC_USER_INFO.account
     *
     * @mbggenerated
     */
    public String getAccount() {
        return account;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TOPIC_USER_INFO.account
     *
     * @param account the value for TOPIC_USER_INFO.account
     *
     * @mbggenerated
     */
    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TOPIC_USER_INFO.category
     *
     * @return the value of TOPIC_USER_INFO.category
     *
     * @mbggenerated
     */
    public Integer getCategory() {
        return category;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TOPIC_USER_INFO.category
     *
     * @param category the value for TOPIC_USER_INFO.category
     *
     * @mbggenerated
     */
    public void setCategory(Integer category) {
        this.category = category;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TOPIC_USER_INFO.autoName
     *
     * @return the value of TOPIC_USER_INFO.autoName
     *
     * @mbggenerated
     */
    public String getAutoname() {
        return autoname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TOPIC_USER_INFO.autoName
     *
     * @param autoname the value for TOPIC_USER_INFO.autoName
     *
     * @mbggenerated
     */
    public void setAutoname(String autoname) {
        this.autoname = autoname == null ? null : autoname.trim();
    }
}