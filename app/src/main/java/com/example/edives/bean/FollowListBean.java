package com.example.edives.bean;

import java.util.List;

public class FollowListBean {

    /**
     * code : 200
     * message : 操作成功
     * result : {"total":2,"list":[{"userId":33,"nickname":"多多","icon":"http://47.107.50.253:8080/webapps/uploadFile/image/1575793587544_19318556.jpg","topicName":null,"targetId":33,"status":1,"topicNum":null,"topicPicture":null},{"userId":34,"nickname":"礼貌的下巴","icon":"http://47.107.50.253:8080/webapps/uploadFile/compent/20191208145645.png","topicName":null,"targetId":34,"status":1,"topicNum":null,"topicPicture":null}]}
     */

    private int code;
    private String message;
    private ResultBean result;

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

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * total : 2
         * list : [{"userId":33,"nickname":"多多","icon":"http://47.107.50.253:8080/webapps/uploadFile/image/1575793587544_19318556.jpg","topicName":null,"targetId":33,"status":1,"topicNum":null,"topicPicture":null},{"userId":34,"nickname":"礼貌的下巴","icon":"http://47.107.50.253:8080/webapps/uploadFile/compent/20191208145645.png","topicName":null,"targetId":34,"status":1,"topicNum":null,"topicPicture":null}]
         */

        private int total;
        private List<ListBean> list;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * userId : 33
             * nickname : 多多
             * icon : http://47.107.50.253:8080/webapps/uploadFile/image/1575793587544_19318556.jpg
             * topicName : null
             * targetId : 33
             * status : 1
             * topicNum : null
             * topicPicture : null
             */

            private int userId;
            private String nickname;
            private String icon;
            private String topicName;
            private int targetId;
            private int status;
            private int topicNum;
            private Object topicPicture;
            private int favoriteType;

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
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

            public String getTopicName() {
                return topicName;
            }

            public void setTopicName(String topicName) {
                this.topicName = topicName;
            }

            public int getTargetId() {
                return targetId;
            }

            public void setTargetId(int targetId) {
                this.targetId = targetId;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public int getTopicNum() {
                return topicNum;
            }

            public void setTopicNum(int topicNum) {
                this.topicNum = topicNum;
            }

            public Object getTopicPicture() {
                return topicPicture;
            }

            public void setTopicPicture(Object topicPicture) {
                this.topicPicture = topicPicture;
            }

            public int getFavoriteType() {
                return favoriteType;
            }

            public void setFavoriteType(int favoriteType) {
                this.favoriteType = favoriteType;
            }
        }
    }
}
