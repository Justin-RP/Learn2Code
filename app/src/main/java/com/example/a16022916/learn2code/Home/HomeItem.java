package com.example.a16022916.learn2code.Home;

public class HomeItem {

    private String name, desc;
    private int lesson;

    public HomeItem(String name, String desc, int lesson) {
        this.name = name;
        this.desc = desc;
        this.lesson = lesson;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getLesson() {
        return lesson;
    }

    public void setLesson(int lesson) {
        this.lesson = lesson;
    }
}
