package neau.cekong.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * rec_record
 *
 * @author
 */
public class RecRecord implements Serializable {
    private Integer rec_id;

    /**
     * 记录名
     */
    private String rec_name;

    /**
     * 预计起始时间
     */
    private LocalDateTime rec_time_start;

    /**
     * 预计结束时间
     */
    private LocalDateTime rec_time_end;

    /**
     * 使用者 姓名
     */
    private String rec_character_name;

    private static final long serialVersionUID = 1L;

    public Integer getRec_id() {
        return rec_id;
    }

    public void setRec_id(Integer rec_id) {
        this.rec_id = rec_id;
    }

    public String getRec_name() {
        return rec_name;
    }

    public void setRec_name(String rec_name) {
        this.rec_name = rec_name;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public LocalDateTime getRec_time_start() {
        return rec_time_start;
    }

    public void setRec_time_start(LocalDateTime rec_time_start) {
        this.rec_time_start = rec_time_start;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public LocalDateTime getRec_time_end() {
        return rec_time_end;
    }

    public void setRec_time_end(LocalDateTime rec_time_end) {
        this.rec_time_end = rec_time_end;
    }

    public String getRec_character_name() {
        return rec_character_name;
    }

    public void setRec_character_name(String rec_character_name) {
        this.rec_character_name = rec_character_name;
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
        RecRecord other = (RecRecord) that;
        return (this.getRec_id() == null ? other.getRec_id() == null : this.getRec_id().equals(other.getRec_id()))
                && (this.getRec_name() == null ? other.getRec_name() == null : this.getRec_name().equals(other.getRec_name()))
                && (this.getRec_time_start() == null ? other.getRec_time_start() == null : this.getRec_time_start().equals(other.getRec_time_start()))
                && (this.getRec_time_end() == null ? other.getRec_time_end() == null : this.getRec_time_end().equals(other.getRec_time_end()))
                && (this.getRec_character_name() == null ? other.getRec_character_name() == null : this.getRec_character_name().equals(other.getRec_character_name()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRec_id() == null) ? 0 : getRec_id().hashCode());
        result = prime * result + ((getRec_name() == null) ? 0 : getRec_name().hashCode());
        result = prime * result + ((getRec_time_start() == null) ? 0 : getRec_time_start().hashCode());
        result = prime * result + ((getRec_time_end() == null) ? 0 : getRec_time_end().hashCode());
        result = prime * result + ((getRec_character_name() == null) ? 0 : getRec_character_name().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", rec_id=").append(rec_id);
        sb.append(", rec_name=").append(rec_name);
        sb.append(", rec_time_start=").append(rec_time_start);
        sb.append(", rec_time_end=").append(rec_time_end);
        sb.append(", rec_character_name=").append(rec_character_name);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}