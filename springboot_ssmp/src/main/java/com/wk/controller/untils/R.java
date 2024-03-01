package com.wk.controller.untils;

import org.springframework.stereotype.Component;

/**
 * @author： 魏凯
 * @version: 1.0
 * @desc： TODO
 */
@Component
public class R {
    private boolean flag;
    private Object data;
    private String msg;

    public String getMsg() {
        return msg;
    }

    public R(boolean flag, String msg) {
        this.flag = flag;
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "R{" +
                "flag=" + flag +
                ", data=" + data +
                ", msg='" + msg + '\'' +
                '}';
    }

    public R(boolean flag, Object data, String msg) {
        this.flag = flag;
        this.data = data;
        this.msg = msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isFlag() {
        return flag;
    }

    public R() {
    }

    /**
     * !!!
     * @param flag
     */
    public R(Boolean flag) {
        this.flag=flag;
    }

    /**
     * !!!
     * @param flag
     * @param data
     */
    public R(boolean flag, Object data) {
        this.flag = flag;
        this.data = data;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
