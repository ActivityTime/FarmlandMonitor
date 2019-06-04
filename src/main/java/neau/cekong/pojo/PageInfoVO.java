package neau.cekong.pojo;

public class PageInfoVO {
    //           "code": 0, //解析接口状态
//           "msg": "", //解析提示文本
//           "count": res.length, //解析数据长度
//           "data": res //解析数据列表
    Integer code = 0;
    String msg = "";
    Long count;
    Object data;

    public PageInfoVO(Long count, Object data) {
        this.count = count;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
