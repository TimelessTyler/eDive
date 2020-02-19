package com.example.edives.bean;

import java.util.List;

public class SearchDataBean {
    /**
     * code : 200
     * message : 操作成功
     * data : [{"id":63,"name":"海","createTime":1573107070000,"searchType":3,"userid":15609563858},{"id":61,"name":"海峡","createTime":1573107000000,"searchType":1,"userid":15609563858}]
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
         * id : 63
         * name : 海
         * createTime : 1573107070000
         * searchType : 3
         * userid : 15609563858
         */

        private int id;
        private String name;
        private String createTime;
        private int searchType;
        private long userid;

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

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public int getSearchType() {
            return searchType;
        }

        public void setSearchType(int searchType) {
            this.searchType = searchType;
        }

        public long getUserid() {
            return userid;
        }

        public void setUserid(long userid) {
            this.userid = userid;
        }
    }
}
