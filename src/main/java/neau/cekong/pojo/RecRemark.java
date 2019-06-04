package neau.cekong.pojo;

import java.io.Serializable;

/**
 * rec_remark
 * @author 
 */
public class RecRemark implements Serializable {
    /**
     * 物理主键
     */
    private Integer rec_remark_id;

    /**
     * 记录id
     */
    private Integer rec_id;

    /**
     * 备注名
     */
    private String rec_remark_key;

    /**
     * 备注内容
     */
    private String rec_remark_value;

    private static final long serialVersionUID = 1L;

    public Integer getRec_remark_id() {
        return rec_remark_id;
    }

    public void setRec_remark_id(Integer rec_remark_id) {
        this.rec_remark_id = rec_remark_id;
    }

    public Integer getRec_id() {
        return rec_id;
    }

    public void setRec_id(Integer rec_id) {
        this.rec_id = rec_id;
    }

    public String getRec_remark_key() {
        return rec_remark_key;
    }

    public void setRec_remark_key(String rec_remark_key) {
        this.rec_remark_key = rec_remark_key;
    }

    public String getRec_remark_value() {
        return rec_remark_value;
    }

    public void setRec_remark_value(String rec_remark_value) {
        this.rec_remark_value = rec_remark_value;
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
        RecRemark other = (RecRemark) that;
        return (this.getRec_remark_id() == null ? other.getRec_remark_id() == null : this.getRec_remark_id().equals(other.getRec_remark_id()))
            && (this.getRec_id() == null ? other.getRec_id() == null : this.getRec_id().equals(other.getRec_id()))
            && (this.getRec_remark_key() == null ? other.getRec_remark_key() == null : this.getRec_remark_key().equals(other.getRec_remark_key()))
            && (this.getRec_remark_value() == null ? other.getRec_remark_value() == null : this.getRec_remark_value().equals(other.getRec_remark_value()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRec_remark_id() == null) ? 0 : getRec_remark_id().hashCode());
        result = prime * result + ((getRec_id() == null) ? 0 : getRec_id().hashCode());
        result = prime * result + ((getRec_remark_key() == null) ? 0 : getRec_remark_key().hashCode());
        result = prime * result + ((getRec_remark_value() == null) ? 0 : getRec_remark_value().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", rec_remark_id=").append(rec_remark_id);
        sb.append(", rec_id=").append(rec_id);
        sb.append(", rec_remark_key=").append(rec_remark_key);
        sb.append(", rec_remark_value=").append(rec_remark_value);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}