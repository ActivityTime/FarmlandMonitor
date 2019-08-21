package neau.cekong.pojo;

public class Result<T> {
    T data;
    String msg;
    int status;

    public Result() {
    }

    public Result(T data, String msg, int status) {
        this.data = data;
        this.msg = msg;
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
