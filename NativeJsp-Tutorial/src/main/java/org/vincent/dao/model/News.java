package org.vincent.dao.model;

public class News {
    public News(Integer newsid, String newstitle, String newstime, String adminname, String newscontent) {
        this.newsid = newsid;
        this.newstitle = newstitle;
        this.newstime = newstime;
        this.adminname = adminname;
        this.newscontent = newscontent;
    }

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column news.NewsID
     *
     * @mbg.generated
     */
    private Integer newsid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column news.NewsTitle
     *
     * @mbg.generated
     */
    private String newstitle;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column news.NewsTime
     *
     * @mbg.generated
     */
    private String newstime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column news.AdminName
     *
     * @mbg.generated
     */
    private String adminname;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column news.NewsContent
     *
     * @mbg.generated
     */
    private String newscontent;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column news.NewsID
     *
     * @return the value of news.NewsID
     *
     * @mbg.generated
     */
    public Integer getNewsid() {
        return newsid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column news.NewsID
     *
     * @param newsid the value for news.NewsID
     *
     * @mbg.generated
     */
    public void setNewsid(Integer newsid) {
        this.newsid = newsid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column news.NewsTitle
     *
     * @return the value of news.NewsTitle
     *
     * @mbg.generated
     */
    public String getNewstitle() {
        return newstitle;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column news.NewsTitle
     *
     * @param newstitle the value for news.NewsTitle
     *
     * @mbg.generated
     */
    public void setNewstitle(String newstitle) {
        this.newstitle = newstitle == null ? null : newstitle.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column news.NewsTime
     *
     * @return the value of news.NewsTime
     *
     * @mbg.generated
     */
    public String getNewstime() {
        return newstime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column news.NewsTime
     *
     * @param newstime the value for news.NewsTime
     *
     * @mbg.generated
     */
    public void setNewstime(String newstime) {
        this.newstime = newstime == null ? null : newstime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column news.AdminName
     *
     * @return the value of news.AdminName
     *
     * @mbg.generated
     */
    public String getAdminname() {
        return adminname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column news.AdminName
     *
     * @param adminname the value for news.AdminName
     *
     * @mbg.generated
     */
    public void setAdminname(String adminname) {
        this.adminname = adminname == null ? null : adminname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column news.NewsContent
     *
     * @return the value of news.NewsContent
     *
     * @mbg.generated
     */
    public String getNewscontent() {
        return newscontent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column news.NewsContent
     *
     * @param newscontent the value for news.NewsContent
     *
     * @mbg.generated
     */
    public void setNewscontent(String newscontent) {
        this.newscontent = newscontent == null ? null : newscontent.trim();
    }
}