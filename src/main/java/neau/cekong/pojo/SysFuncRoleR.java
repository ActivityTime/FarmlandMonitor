package neau.cekong.pojo;

import java.io.Serializable;

/**
 * sys_func_role_r
 * @author 
 */
public class SysFuncRoleR implements Serializable {
    private Integer rf_id;

    private Integer role_id;

    private Integer func_id;

    private static final long serialVersionUID = 1L;

    public Integer getRf_id() {
        return rf_id;
    }

    public void setRf_id(Integer rf_id) {
        this.rf_id = rf_id;
    }

    public Integer getRole_id() {
        return role_id;
    }

    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }

    public Integer getFunc_id() {
        return func_id;
    }

    public void setFunc_id(Integer func_id) {
        this.func_id = func_id;
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
        SysFuncRoleR other = (SysFuncRoleR) that;
        return (this.getRf_id() == null ? other.getRf_id() == null : this.getRf_id().equals(other.getRf_id()))
            && (this.getRole_id() == null ? other.getRole_id() == null : this.getRole_id().equals(other.getRole_id()))
            && (this.getFunc_id() == null ? other.getFunc_id() == null : this.getFunc_id().equals(other.getFunc_id()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRf_id() == null) ? 0 : getRf_id().hashCode());
        result = prime * result + ((getRole_id() == null) ? 0 : getRole_id().hashCode());
        result = prime * result + ((getFunc_id() == null) ? 0 : getFunc_id().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", rf_id=").append(rf_id);
        sb.append(", role_id=").append(role_id);
        sb.append(", func_id=").append(func_id);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}