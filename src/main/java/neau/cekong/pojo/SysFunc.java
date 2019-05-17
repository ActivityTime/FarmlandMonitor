package neau.cekong.pojo;

import java.io.Serializable;

/**
 * sys_func
 * @author 
 */
public class SysFunc implements Serializable {
    private Integer func_id;

    /**
     * 功能名
     */
    private String func_name;

    /**
     * 功能url
     */
    private String func_url;

    /**
     * 功能父id
     */
    private Integer pid;

    /**
     * 功能类别(系统、模块、菜单、操作)
     */
    private String func_type;

    private String func_code;

    private static final long serialVersionUID = 1L;

    public Integer getFunc_id() {
        return func_id;
    }

    public void setFunc_id(Integer func_id) {
        this.func_id = func_id;
    }

    public String getFunc_name() {
        return func_name;
    }

    public void setFunc_name(String func_name) {
        this.func_name = func_name;
    }

    public String getFunc_url() {
        return func_url;
    }

    public void setFunc_url(String func_url) {
        this.func_url = func_url;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getFunc_type() {
        return func_type;
    }

    public void setFunc_type(String func_type) {
        this.func_type = func_type;
    }

    public String getFunc_code() {
        return func_code;
    }

    public void setFunc_code(String func_code) {
        this.func_code = func_code;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        SysFunc other = (SysFunc) that;
        return (this.getFunc_id() == null ? other.getFunc_id() == null : this.getFunc_id().equals(other.getFunc_id()))
            && (this.getFunc_name() == null ? other.getFunc_name() == null : this.getFunc_name().equals(other.getFunc_name()))
            && (this.getFunc_url() == null ? other.getFunc_url() == null : this.getFunc_url().equals(other.getFunc_url()))
            && (this.getPid() == null ? other.getPid() == null : this.getPid().equals(other.getPid()))
            && (this.getFunc_type() == null ? other.getFunc_type() == null : this.getFunc_type().equals(other.getFunc_type()))
            && (this.getFunc_code() == null ? other.getFunc_code() == null : this.getFunc_code().equals(other.getFunc_code()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getFunc_id() == null) ? 0 : getFunc_id().hashCode());
        result = prime * result + ((getFunc_name() == null) ? 0 : getFunc_name().hashCode());
        result = prime * result + ((getFunc_url() == null) ? 0 : getFunc_url().hashCode());
        result = prime * result + ((getPid() == null) ? 0 : getPid().hashCode());
        result = prime * result + ((getFunc_type() == null) ? 0 : getFunc_type().hashCode());
        result = prime * result + ((getFunc_code() == null) ? 0 : getFunc_code().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", func_id=").append(func_id);
        sb.append(", func_name=").append(func_name);
        sb.append(", func_url=").append(func_url);
        sb.append(", pid=").append(pid);
        sb.append(", func_type=").append(func_type);
        sb.append(", func_code=").append(func_code);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}