package neau.cekong.pojo;

import java.time.LocalDateTime;
import java.util.Objects;

@Deprecated
public class UserLoginStatus extends SysUser{

    LocalDateTime lastCheckTime;

    public UserLoginStatus(SysUser user) {
        super.setId(user.getId());
        super.setUsername(user.getUsername());
        super.setPassword(user.getPassword());
        this.lastCheckTime = LocalDateTime.now();
    }

    public LocalDateTime getLastCheckTime() {
        return lastCheckTime;
    }

    public void setLastCheckTime(LocalDateTime lastCheckTime) {
        this.lastCheckTime = lastCheckTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserLoginStatus)) return false;
        UserLoginStatus that = (UserLoginStatus) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
