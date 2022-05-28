package com.leafmaple.androidtraining.bean;

import java.util.List;

public class VideoBean {

    /**
     * id : 1
     * name : jQuery精品教程
     * img : /img/video/video_jquery_icon.png
     * intro : 本视频系统的讲解了jQuery的基本操作并配合相应案例保证学生能较大程度的接受和了解到知识的应用，该视频的起点都是针对有一定JavaScript基础的同学精心设计录制的。通过该视频的学习，相信你能够轻轻松松的掌握jQuery的应用，为学习前端开发打下坚实的基础。
     * videoDetailList : [{"video_id":"DA2D015D371417299C33DC5901307461","video_name":"01-jQuery初体验"},{"video_id":"8CE6F0EA79D28C409C33DC5901307461","video_name":"02-什么是jQuery"},{"video_id":"105420027A12F7869C33DC5901307461","video_name":"03-jQuery版本问题"},{"video_id":"2B6B824CB0FB90209C33DC5901307461","video_name":"04-jQuery入口函数的解释"},{"video_id":"FE97256B916E64779C33DC5901307461","video_name":"05-jq对象与js对象"}]
     */

    private int id;
    private String name;
    private String img;
    private String intro;
    private List<VideoDetailListBean> videoDetailList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public List<VideoDetailListBean> getVideoDetailList() {
        return videoDetailList;
    }

    public void setVideoDetailList(List<VideoDetailListBean> videoDetailList) {
        this.videoDetailList = videoDetailList;
    }

    public static class VideoDetailListBean {
        /**
         * video_id : DA2D015D371417299C33DC5901307461
         * video_name : 01-jQuery初体验
         */

        private String video_id;
        private String video_name;

        public String getVideo_id() {
            return video_id;
        }

        public void setVideo_id(String video_id) {
            this.video_id = video_id;
        }

        public String getVideo_name() {
            return video_name;
        }

        public void setVideo_name(String video_name) {
            this.video_name = video_name;
        }
    }
}
