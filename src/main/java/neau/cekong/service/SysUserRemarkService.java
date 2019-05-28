package neau.cekong.service;

import neau.cekong.pojo.SysUserRemark;

import java.util.List;

public interface SysUserRemarkService {
    List<SysUserRemark> findRemarksByUsername(String username);
}
