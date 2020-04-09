package com.store.user.dao;

import com.store.user.entity.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName UserDao
 * @Description User
 * @Author huangzewei
 * @Date 2020-03-26
 */
public interface UserDao {
    /**
     * 统计用户账号数量
     * @param userInfo 用户信息
     * @return
     */
    int countUserAccount(UserInfo userInfo);
    /**
     * 新增用户
     * @param userInfo 用户信息
     * @return
     */
    int addUser(UserInfo userInfo);
    /**
     * 获取所有用户信息
     * @param userInfo 用户信息
     * @return 所有用户信息
     */
    List<UserInfo> listUsers(UserInfo userInfo);
    /**
     * 删除用户信息
     * @param listCode 选中的用户编号集合
     * @param userId 更新人
     * @return
     */
    int deleteUser(@Param("listCode") List<String> listCode, @Param("userId") String userId);
    /**
     * 修改用户信息
     * @param userInfo 用户信息
     * @return 修改结果
     */
    int updateUser(UserInfo userInfo);
    /**
     * 查询用户信息
     * @param userCode 用户编号
     * @return 修改结果
     */
    UserInfo findUserDetail(@Param("userCode") String userCode);
}
