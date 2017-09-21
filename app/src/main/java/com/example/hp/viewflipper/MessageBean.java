package com.example.hp.viewflipper;

/**
 * 作者：mapeng on 2017/9/21 10:43
 * 类描述：
 */

class MessageBean {
    String title;
    String time;

    public MessageBean(String title, String time) {
        this.title = title;
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
