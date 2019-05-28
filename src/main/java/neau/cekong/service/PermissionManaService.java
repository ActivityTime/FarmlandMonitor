package neau.cekong.service;

import neau.cekong.pojo.Result;
import neau.cekong.pojo.UserListItemVO;

import java.util.List;

public interface PermissionManaService {
    List<UserListItemVO> findUsersList();

    Result addRoleToUser(String roleName, String username);
    Result delRoleToUser(String roleName, String username);

    Result addFuncesToRole(String funcCode, String roleName);
    Result delFuncesToRole(String funcCode, String roleName);
}
