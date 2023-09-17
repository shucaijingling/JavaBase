package com.xuyi.springframework.test.beans;

public class UserService {

    private String uId;

    private UserDao userDao;

    public UserService() {
    }

    public UserService(String uId, UserDao userDao) {
        this.uId = uId;
        this.userDao = userDao;
    }

    public void queryUserInfo() {
        System.out.println("userService info  : " + userDao.queryUserName(uId));
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
