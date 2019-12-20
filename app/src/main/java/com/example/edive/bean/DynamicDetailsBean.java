package com.example.edive.bean;

import java.util.List;

public class DynamicDetailsBean {

    /**
     * code : 200
     * message : 操作成功
     * data : [{"id":6,"dynamicAuthor":"小A","dynamicHeadPortrait":"头像","dynamicContent":"发布动态测试1","createTime":"2019-10-07 14:39:55","dynamicAddress":"string","dynamicPicture":"http://b-ssl.duitang.com/uploads/blog/201404/08/20140408232416_wkxaj.jpeg","dynamicPraise":45,"dynamicSharenum":0,"dynamicCommentnum":3,"userId":1,"topicId":1,"topicName":"克罗群岛","delflag":0,"identification":1}]
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
         * id : 6
         * dynamicAuthor : 小A
         * dynamicHeadPortrait : 头像
         * dynamicContent : 发布动态测试1
         * createTime : 2019-10-07 14:39:55
         * dynamicAddress : string
         * dynamicPicture : http://b-ssl.duitang.com/uploads/blog/201404/08/20140408232416_wkxaj.jpeg
         * dynamicPraise : 45
         * dynamicSharenum : 0
         * dynamicCommentnum : 3
         * userId : 1
         * topicId : 1
         * topicName : 克罗群岛
         * delflag : 0
         * identification : 1
         */

        private int id;
        private String dynamicAuthor;
        private String dynamicHeadPortrait;
        private String dynamicContent;
        private String createTime;
        private String dynamicAddress;
        private String dynamicPicture;
        private int dynamicPraise;
        private int dynamicSharenum;
        private int dynamicCommentnum;
        private int userId;
        private int topicId;
        private String topicName;
        private int delflag;
        private int identification;
        private int identificationPraise;

        public int getIdentificationPraise() {
            return identificationPraise;
        }

        public void setIdentificationPraise(int identificationPraise) {
            this.identificationPraise = identificationPraise;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getDynamicAuthor() {
            return dynamicAuthor;
        }

        public void setDynamicAuthor(String dynamicAuthor) {
            this.dynamicAuthor = dynamicAuthor;
        }

        public String getDynamicHeadPortrait() {
            return dynamicHeadPortrait;
        }

        public void setDynamicHeadPortrait(String dynamicHeadPortrait) {
            this.dynamicHeadPortrait = dynamicHeadPortrait;
        }

        public String getDynamicContent() {
            return dynamicContent;
        }

        public void setDynamicContent(String dynamicContent) {
            this.dynamicContent = dynamicContent;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getDynamicAddress() {
            return dynamicAddress;
        }

        public void setDynamicAddress(String dynamicAddress) {
            this.dynamicAddress = dynamicAddress;
        }

        public String getDynamicPicture() {
            return dynamicPicture;
        }

        public void setDynamicPicture(String dynamicPicture) {
            this.dynamicPicture = dynamicPicture;
        }

        public int getDynamicPraise() {
            return dynamicPraise;
        }

        public void setDynamicPraise(int dynamicPraise) {
            this.dynamicPraise = dynamicPraise;
        }

        public int getDynamicSharenum() {
            return dynamicSharenum;
        }

        public void setDynamicSharenum(int dynamicSharenum) {
            this.dynamicSharenum = dynamicSharenum;
        }

        public int getDynamicCommentnum() {
            return dynamicCommentnum;
        }

        public void setDynamicCommentnum(int dynamicCommentnum) {
            this.dynamicCommentnum = dynamicCommentnum;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public int getTopicId() {
            return topicId;
        }

        public void setTopicId(int topicId) {
            this.topicId = topicId;
        }

        public String getTopicName() {
            return topicName;
        }

        public void setTopicName(String topicName) {
            this.topicName = topicName;
        }

        public int getDelflag() {
            return delflag;
        }

        public void setDelflag(int delflag) {
            this.delflag = delflag;
        }

        public int getIdentification() {
            return identification;
        }

        public void setIdentification(int identification) {
            this.identification = identification;
        }
    }
}
