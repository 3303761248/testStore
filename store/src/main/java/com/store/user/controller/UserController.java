package com.store.user.controller;

import com.store.user.entity.UserInfo;
import com.store.user.service.UserService;
import com.store.util.AppResponse;
import com.store.util.AuthUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description增删改查
 * @Author huangzewei
 * @Date 2020-03-26
 */
@RestController
@RequestMapping("/user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Resource
    private UserService userService;

    /**
     * user 新增用户
     *
     * @param userInfo
     * @return AppResponse
     * @author huangzewei
     * @Date 2020-03-26
     */
    @PostMapping("/addUser")
    public AppResponse addUser(UserInfo userInfo) {
        try {
            //获取用户id
            String userId = AuthUtils.getCurrentUserId();
            userInfo.setCreateUser(userId);
            AppResponse appResponse = userService.addUser(userInfo);
            return appResponse;
        } catch (Exception e) {
            logger.error("用户新增失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * user 用户列表(分页)
     *
     * @param userInfo
     * @return AppResponse
     * @author huangzewei
     * @Date 2020-03-26
     */
    @RequestMapping(value = "listUsers")
    public AppResponse listUsers(UserInfo userInfo) {
        try {
            return userService.listUsers(userInfo);
        } catch (Exception e) {
            logger.error("查询用户列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * user 删除用户
     *
     * @param userCode
     * @return AppResponse
     * @author huangzewei
     * @Date 2020-03-26
     */
    @PostMapping("deleteUser")
    public AppResponse deleteUser(String userCode) {
        try {
            //获取用户id
            String userId = AuthUtils.getCurrentUserId();
            return userService.deleteUser(userCode, userId);
        } catch (Exception e) {
            logger.error("用户删除错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * good 修改用户
     *
     * @param userInfo
     * @return AppResponse
     * @author huangzewei
     * @Date 2020-03-26
     */
    @PostMapping("updateUser")
    public AppResponse updateUser(UserInfo userInfo) {
        try {
            //获取用户id
            String userId = AuthUtils.getCurrentUserId();
            userInfo.setUpdateUser(userId);
            return userService.updateUser(userInfo);
        } catch (Exception e) {
            logger.error("修改用户信息错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * good查询用户详情
     *
     * @param userCode
     * @return AppResponse
     * @author huangzewei
     * @Date 2020-03-26
     */
    @RequestMapping(value = "findUserDetail")
    public AppResponse findUserDetail(String userCode) {
        try {
            return userService.findUserDetail(userCode);
        } catch (Exception e) {
            logger.error("用户查询错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
