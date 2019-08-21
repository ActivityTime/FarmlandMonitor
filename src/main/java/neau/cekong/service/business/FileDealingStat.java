package neau.cekong.service.business;

import java.io.File;

public class FileDealingStat {
    private Double per = 0.0;// 百分比
    private Integer num = 0;// 总数
    private Integer now = 0;//已完成条数
    private File file;// 文件

    public FileDealingStat() {
    }

    public FileDealingStat(File file) {
        this.file = file;
    }

    public Double getPer() {
        if (num != 0)
            per = now * 1.0 / num;
        else
            per = 1.0;
        return per;
    }

    public void setPer(Double per) {
        this.per = per;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getNow() {
        return now;
    }

    public void setNow(Integer now) {
        this.now = now;
    }

    public Integer addNow(Integer add) {
        this.now += add;
        if (now > num) now = num;
        return now;
    }

    // false 无法到达 100%
    public Integer addNow(Integer add, boolean flag) {
        if (flag) {
            addNow(add);
        } else {
            this.now += add;
            if (now > num) now = num - 1;
        }
        return now;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public boolean isFinish() {
        if (num <= now)
            return true;
        else
            return false;
    }

    public void finish() {
        per = 1.0;
        now = num;
    }
}
