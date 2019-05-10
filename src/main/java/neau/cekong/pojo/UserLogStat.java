package neau.cekong.pojo;

import java.util.Date;

public class UserLogStat extends TbUser {

    public UserLogStat(TbUser user) {
        super.setId(user.getId());
        super.setUsername(user.getUsername());
        super.setPassword(user.getPassword());
        this.lastTime = new Date();
    }

    public Date getLastTime() {
        return lastTime;
    }

    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }

    Date lastTime;
}
