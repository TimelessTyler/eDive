package com.example.edive.bean;

import java.util.List;

public class TopicByIdBean {
    /**
     * code : 200
     * message : 操作成功
     * data : [{"id":1,"topicName":"克罗索尔岛","topicDescribes":"克罗索尔岛(île du Corossol)，位于加拿大魁北克省，位于50°05\u203226\u2033N 66°23\u203218\u2033W，圣劳伦斯海湾北岸，七岛港七岛群岛（Sept Iles）中，长1.7公里，面积0.936平方公里，是鸟类保护区，岛上有一个废弃的灯塔。\n克罗索尔岛处在生态保护当中，是鸟类的家园。目前无人居住。","topicNum":6,"createTime":"2019-10-24 13:55:44","topicPicture":"https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1064979474,1752696085&fm=26&gp=0.jpg","identification":1}]
     */

    private int code;
    private String message;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 1
         * topicName : 克罗索尔岛
         * topicDescribes : 克罗索尔岛(île du Corossol)，位于加拿大魁北克省，位于50°05′26″N 66°23′18″W，圣劳伦斯海湾北岸，七岛港七岛群岛（Sept Iles）中，长1.7公里，面积0.936平方公里，是鸟类保护区，岛上有一个废弃的灯塔。
         克罗索尔岛处在生态保护当中，是鸟类的家园。目前无人居住。
         * topicNum : 6
         * createTime : 2019-10-24 13:55:44
         * topicPicture : https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1064979474,1752696085&fm=26&gp=0.jpg
         * identification : 1
         */

        private int id;
        private String topicName;
        private String topicDescribes;
        private int topicNum;
        private String createTime;
        private String topicPicture;
        private int identification;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTopicName() {
            return topicName;
        }

        public void setTopicName(String topicName) {
            this.topicName = topicName;
        }

        public String getTopicDescribes() {
            return topicDescribes;
        }

        public void setTopicDescribes(String topicDescribes) {
            this.topicDescribes = topicDescribes;
        }

        public int getTopicNum() {
            return topicNum;
        }

        public void setTopicNum(int topicNum) {
            this.topicNum = topicNum;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getTopicPicture() {
            return topicPicture;
        }

        public void setTopicPicture(String topicPicture) {
            this.topicPicture = topicPicture;
        }

        public int getIdentification() {
            return identification;
        }

        public void setIdentification(int identification) {
            this.identification = identification;
        }
    }
}
