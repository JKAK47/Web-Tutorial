package org.vincent.dao.model;

public class Admin {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin.AdminID
     *
     * @mbg.generated
     */
    private Integer adminid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin.AdminName
     *
     * @mbg.generated
     */
    private String adminname;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin.AdminPwd
     *
     * @mbg.generated
     */
    private String adminpwd;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin.AdminType
     *
     * @mbg.generated
     */
    private Short admintype;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin.LastLoginTime
     *
     * @mbg.generated
     */
    private String lastlogintime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin.AdminID
     *
     * @return the value of admin.AdminID
     *
     * @mbg.generated
     */
    public Integer getAdminid() {
        return adminid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin.AdminID
     *
     * @param adminid the value for admin.AdminID
     *
     * @mbg.generated
     */
    public void setAdminid(Integer adminid) {
        this.adminid = adminid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin.AdminName
     *
     * @return the value of admin.AdminName
     *
     * @mbg.generated
     */
    public String getAdminname() {
        return adminname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin.AdminName
     *
     * @param adminname the value for admin.AdminName
     *
     * @mbg.generated
     */
    public void setAdminname(String adminname) {
        this.adminname = adminname == null ? null : adminname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin.AdminPwd
     *
     * @return the value of admin.AdminPwd
     *
     * @mbg.generated
     */
    public String getAdminpwd() {
        return adminpwd;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin.AdminPwd
     *
     * @param adminpwd the value for admin.AdminPwd
     *
     * @mbg.generated
     */
    public void setAdminpwd(String adminpwd) {
        this.adminpwd = adminpwd == null ? null : adminpwd.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin.AdminType
     *
     * @return the value of admin.AdminType
     *
     * @mbg.generated
     */
    public Short getAdmintype() {
        return admintype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin.AdminType
     *
     * @param admintype the value for admin.AdminType
     *
     * @mbg.generated
     */
    public void setAdmintype(Short admintype) {
        this.admintype = admintype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin.LastLoginTime
     *
     * @return the value of admin.LastLoginTime
     *
     * @mbg.generated
     */
    public String getLastlogintime() {
        return lastlogintime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin.LastLoginTime
     *
     * @param lastlogintime the value for admin.LastLoginTime
     *
     * @mbg.generated
     */
    public void setLastlogintime(String lastlogintime) {
        this.lastlogintime = lastlogintime == null ? null : lastlogintime.trim();
    }
}