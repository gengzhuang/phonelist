package com.easy.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 资源管理
 * @Title: Resource.java
 * @Package com.huazhukeji.model
 * @author 耿壮
 * @date 2016年7月18日 下午2:59:47
 * @company 河北华助科技有限公司
 * @version V1.0
 */
public class Resource implements Serializable {

    private static final long serialVersionUID = -5321613594382537470L;

    private Long id;

    private String name;

    private String url;

    private String description;

    @JsonProperty("iconCls")
    private String icon;

    private Long pid;

    private Integer seq;

    private Integer status;

    private Integer resourcetype;

    private Date createdate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getResourcetype() {
        return resourcetype;
    }

    public void setResourcetype(Integer resourcetype) {
        this.resourcetype = resourcetype;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    @Override
    public String toString() {
        return "Resource{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", description='" + description + '\'' +
                ", icon='" + icon + '\'' +
                ", pid=" + pid +
                ", seq=" + seq +
                ", status=" + status +
                ", resourcetype=" + resourcetype +
                ", createdate=" + createdate +
                '}';
    }
}