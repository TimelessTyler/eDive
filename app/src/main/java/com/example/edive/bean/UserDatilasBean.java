package com.example.edive.bean;

public class UserDatilasBean {
    /**
     * code : 200
     * message : 操作成功
     * data : {"id":33,"memberLevelId":null,"nickname":"多多","icon":"http://47.107.50.253:8080/webapps/uploadFile/image/1575793587544_19318556.jpg","pics":"http://47.107.50.253:8080/webapps/uploadFile/image/1575856758135_39381232.jpg,http://47.107.50.253:8080/webapps/uploadFile/image/1575856946236_76963439.jpg","personalizedSignature":"我是一个非常厉害的潜水教练","identification":1}
     */

    private int code;
    private String message;
    private DataBean data;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 33
         * memberLevelId : null
         * nickname : 多多
         * icon : http://47.107.50.253:8080/webapps/uploadFile/image/1575793587544_19318556.jpg
         * pics : http://47.107.50.253:8080/webapps/uploadFile/image/1575856758135_39381232.jpg,http://47.107.50.253:8080/webapps/uploadFile/image/1575856946236_76963439.jpg
         * personalizedSignature : 我是一个非常厉害的潜水教练
         * identification : 1
         */

        private int id;
        private Object memberLevelId;
        private String nickname;
        private String icon;
        private String pics;
        private String personalizedSignature;
        private int identification;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Object getMemberLevelId() {
            return memberLevelId;
        }

        public void setMemberLevelId(Object memberLevelId) {
            this.memberLevelId = memberLevelId;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getPics() {
            return pics;
        }

        public void setPics(String pics) {
            this.pics = pics;
        }

        public String getPersonalizedSignature() {
            return personalizedSignature;
        }

        public void setPersonalizedSignature(String personalizedSignature) {
            this.personalizedSignature = personalizedSignature;
        }

        public int getIdentification() {
            return identification;
        }

        public void setIdentification(int identification) {
            this.identification = identification;
        }
    }
}
