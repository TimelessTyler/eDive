package com.example.edive.bean;

import java.util.List;

public class TopicBean {
    /**
     * code : 200
     * message : 操作成功
     * data : [{"id":1,"topicName":"克罗群岛的一天","topicNum":72,"topicPicture":"\u202aC:\\fileUpload\\picture20191016113455_1564384598(1).jpg"},{"id":2,"topicName":"马尔代夫的海峡1","topicNum":69,"topicPicture":"http://pic23.photophoto.cn/20120614/0008020246371439_b.jpg"},{"id":4,"topicName":"天天向上","topicNum":1,"topicPicture":"http://pic23.photophoto.cn/20120614/0008020246371439_b.jpg"},{"id":10,"topicName":"string","topicNum":0,"topicPicture":"http://pic23.photophoto.cn/20120614/0008020246371439_b.jpg"},{"id":12,"topicName":"1","topicNum":0,"topicPicture":"http://127.0.0.1/dmd/1571990037211_51093452.jpg"},{"id":13,"topicName":"1","topicNum":0},{"id":14,"topicName":"22222222","topicNum":0},{"id":15,"topicName":"3","topicNum":0,"topicPicture":"http://127.0.0.1/dmd/1571996818561_72673454.jpg"},{"id":16,"topicName":"1","topicNum":0},{"id":17,"topicName":"c","topicNum":0,"topicPicture":"http://127.0.0.1/dmd/1572244919217_94459025.jpg"},{"id":18,"topicName":"1","topicNum":0}]
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
         * topicName : 克罗群岛的一天
         * topicNum : 72
         * topicPicture : ‪C:\fileUpload\picture20191016113455_1564384598(1).jpg
         */

        private int id;
        private String topicName;
        private int topicNum;
        private String topicPicture;

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

        public int getTopicNum() {
            return topicNum;
        }

        public void setTopicNum(int topicNum) {
            this.topicNum = topicNum;
        }

        public String getTopicPicture() {
            return topicPicture;
        }

        public void setTopicPicture(String topicPicture) {
            this.topicPicture = topicPicture;
        }
    }
}
