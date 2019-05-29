package neau.cekong.service;

import neau.cekong.pojo.Result;
import neau.cekong.pojo.SysUserRemark;

import java.util.List;

public interface SysUserRemarkService {
    List<SysUserRemark> findRemarksByUsername(String username);
    Result addRemarkByUsername(String username, String remarkname, String remark);
    Result altRemarkByUsername(String username, String remarkname, String newMarkname, String remark);
    Result delRemarkByUsername(String username, String remarkname);
}
