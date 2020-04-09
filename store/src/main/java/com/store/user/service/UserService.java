package com.store.user.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.store.user.dao.UserDao;
import com.store.user.entity.UserInfo;
import com.store.util.AppResponse;
import com.store.util.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @DescriptionDemo 实现类
 * @Author huangzewei
 * @Date 2020-03-21
 */
@Service
public class UserService {
    @Resource
    private UserDao userDao;
    /**
     * user新增用户
     *
     * @param userInfo
     * @return
     * @Author huangzewei
     * @Date 2020-03-26
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addUser(UserInfo userInfo) {
        // 校验账号是否存在
        int countUserAccount = userDao.countUserAccount(userInfo);
        if (0 != countUserAccount) {
            return AppResponse.bizError("账号已存在，请重新输入！");
        }
        userInfo.setUserCode(StringUtil.getCommonCode(2));
        userInfo.setIsDeleted(0);
        // 新增用户
        int count = userDao.addUser(userInfo);
        if (0 == count) {
            return AppResponse.bizError("新增失败，请重试！");
        }
        return AppResponse.success("新增成功！");
    }
    /**
     * user 查询用户列表（分页）
     *
     * @param userInfo
     * @return
     * @Author huangzewei
     * @Date 2020-03-26
     */
    public AppResponse listUsers(UserInfo userInfo) {
        PageHelper.startPage(userInfo.getPageNum(), userInfo.getPageSize());
        List<UserInfo> userInfoList = userDao.listUsers(userInfo);
        // 包装Page对象
        PageInfo<UserInfo> pageData = new PageInfo<UserInfo>(userInfoList);
        if(pageData!=null){
            return AppResponse.success("查询成功！", pageData);
        }else{
            return AppResponse.bizError("查询失败，请重试！");
        }

    }
    /**
     * user删除用户
     *
     * @param userCode
     * @param userId
     * @return
     * @Author huangzewei
     * @Date 2020-03-26
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteUser(String userCode, String userId) {
        List<String> listCode = Arrays.asList(userCode.split(","));
        // 删除用户
        int count = userDao.deleteUser(listCode, userId);
        if (0 == count) {
            return AppResponse.bizError("删除失败，请重试！");
        }
        return AppResponse.success("删除成功！");
    }
    /**
     * user 修改用户
     *
     * @param userInfo
     * @return
     * @Author huangzewei
     * @Date 2020-03-26
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateUser(UserInfo userInfo) {
        // 校验账号是否存在
        int countUserAccount = userDao.countUserAccount(userInfo);
        if (0 != countUserAccount) {
            return AppResponse.bizError("账号已存在，请重新输入！");
        }
        // 修改用户信息
        int count = userDao.updateUser(userInfo);
        if (0 == count) {
            return AppResponse.bizError("修改失败！");
        }else{
            return AppResponse.success("修改成功");
        }
    }
    /**
     * user 查询用户详情
     *
     * @param userCode
     * @return
     * @Author huangzewei
     * @Date 2020-03-26
     */
    public AppResponse findUserDetail(String userCode) {
        UserInfo goodInfo = userDao.findUserDetail(userCode);
        if(goodInfo!=null){
            return AppResponse.success("查询成功！", goodInfo);
        }else{
            return AppResponse.bizError("查询失败！");
        }
    }
}
