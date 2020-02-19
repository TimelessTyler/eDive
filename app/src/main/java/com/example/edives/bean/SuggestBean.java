package com.example.edives.bean;

import java.util.List;

public class SuggestBean {
    /**
     * code : 200
     * message : 操作成功
     * data : [{"id":1,"questionName":"下载/加载问题","status":null,"createTime":null,"updateTime":null,"operator":null},{"id":2,"questionName":"会员付费问题","status":null,"createTime":null,"updateTime":null,"operator":null},{"id":3,"questionName":"章节/图片问题","status":null,"createTime":null,"updateTime":null,"operator":null},{"id":4,"questionName":"app体验问题","status":null,"createTime":null,"updateTime":null,"operator":null}]
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
         * questionName : 下载/加载问题
         * status : null
         * createTime : null
         * updateTime : null
         * operator : null
         */

        private int id;
        private String questionName;
        private Object status;
        private Object createTime;
        private Object updateTime;
        private Object operator;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getQuestionName() {
            return questionName;
        }

        public void setQuestionName(String questionName) {
            this.questionName = questionName;
        }

        public Object getStatus() {
            return status;
        }

        public void setStatus(Object status) {
            this.status = status;
        }

        public Object getCreateTime() {
            return createTime;
        }

        public void setCreateTime(Object createTime) {
            this.createTime = createTime;
        }

        public Object getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(Object updateTime) {
            this.updateTime = updateTime;
        }

        public Object getOperator() {
            return operator;
        }

        public void setOperator(Object operator) {
            this.operator = operator;
        }
    }
}
