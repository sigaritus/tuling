package com.sigaritus.swu.volley_demo;

/**
 * Created by Administrator on 2015/5/22.
 */
public class ListContent {

    private String content;
    private int flag;

    public ListContent(String content) {
        this.content = content;
    }

    public ListContent(int flag, String content) {
        this.flag = flag;
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}
