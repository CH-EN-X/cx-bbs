package com.cx.utils.thread;


import com.cx.model.user.User;

/*
 ThreadLocalUtil 工具类，
 利用 Java 的 ThreadLocal 机制来管理每个线程中的 User 对象。
 ThreadLocal 是 Java 中的一个类，它提供了一种线程局部变量的功能，
 即每个线程都可以访问自己独立的变量副本，而不会与其他线程的变量副本相互干扰。
 用于处理多线程环境下的用户会话管理、事务管理等场景中
 */
public class ThreadLocalUtil {

    private final static ThreadLocal<User> WM_USER_THREAD_LOCAL = new ThreadLocal<>();

    //存入线程中
    public static void setUser(User user){
        WM_USER_THREAD_LOCAL.set(user);
    }

    //从线程中获取
    public static User getUser(){
        return WM_USER_THREAD_LOCAL.get();
    }

    //清理
    public static void clear(){
        WM_USER_THREAD_LOCAL.remove();
    }

}
