package neau.cekong.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Data {

    Date time;
    Object data;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
