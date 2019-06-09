package neau.cekong.pojo;

import java.io.Serializable;

/**
 * rec_col_val
 * @author 
 */
public class RecColVal implements Serializable {
    private Integer id;

    /**
     * 记录（record）id
     */
    private Integer rec_id;

    /**
     * 列名
     */
    private Integer key_id;

    /**
     * 列值
     */
    private String value;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRec_id() {
        return rec_id;
    }

    public void setRec_id(Integer rec_id) {
        this.rec_id = rec_id;
    }

    public Integer getKey_id() {
        return key_id;
    }

    public void setKey_id(Integer key_id) {
        this.key_id = key_id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
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
        RecColVal other = (RecColVal) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getRec_id() == null ? other.getRec_id() == null : this.getRec_id().equals(other.getRec_id()))
            && (this.getKey_id() == null ? other.getKey_id() == null : this.getKey_id().equals(other.getKey_id()))
            && (this.getValue() == null ? other.getValue() == null : this.getValue().equals(other.getValue()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getRec_id() == null) ? 0 : getRec_id().hashCode());
        result = prime * result + ((getKey_id() == null) ? 0 : getKey_id().hashCode());
        result = prime * result + ((getValue() == null) ? 0 : getValue().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", rec_id=").append(rec_id);
        sb.append(", key_id=").append(key_id);
        sb.append(", value=").append(value);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}