package com.example.edives.bean;

import java.util.List;

public class BannerInfo {

    /**
     * code : 200
     * message : 操作成功
     * data : [{"id":3,"creator":null,"creatorId":null,"createdTime":null,"lastOperator":null,"lastOperatorId":null,"updateTime":null,"pageNum":null,"pageSize":null,"orderBy":null,"name":"学证商品","type":1,"pic":"https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=2587132259,2971267909&fm=26&gp=0.jpg","startTime":"2019-11-25 16:34:38","endTime":"2020-11-25 16:34:38","status":1,"clickCount":0,"orderCount":0,"url":"2","note":"走起来","sort":0,"linkType":1},{"id":4,"creator":null,"creatorId":null,"createdTime":null,"lastOperator":null,"lastOperatorId":null,"updateTime":null,"pageNum":null,"pageSize":null,"orderBy":null,"name":"话题广告","type":1,"pic":"https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=318196247,2332366804&fm=26&gp=0.jpg","startTime":"2019-11-25 16:34:38","endTime":"2020-11-25 16:34:38","status":1,"clickCount":0,"orderCount":0,"url":"20","note":"走起来","sort":0,"linkType":2},{"id":10,"creator":null,"creatorId":null,"createdTime":null,"lastOperator":null,"lastOperatorId":null,"updateTime":null,"pageNum":null,"pageSize":null,"orderBy":null,"name":"学证商品","type":1,"pic":"https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2133214724,994750000&fm=26&gp=0.jpg","startTime":"2019-11-26 15:29:01","endTime":"2020-11-26 15:29:01","status":1,"clickCount":0,"orderCount":0,"url":"1","note":"阿道夫","sort":0,"linkType":1}]
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
         * id : 3
         * creator : null
         * creatorId : null
         * createdTime : null
         * lastOperator : null
         * lastOperatorId : null
         * updateTime : null
         * pageNum : null
         * pageSize : null
         * orderBy : null
         * name : 学证商品
         * type : 1
         * pic : https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=2587132259,2971267909&fm=26&gp=0.jpg
         * startTime : 2019-11-25 16:34:38
         * endTime : 2020-11-25 16:34:38
         * status : 1
         * clickCount : 0
         * orderCount : 0
         * url : 2
         * note : 走起来
         * sort : 0
         * linkType : 1
         */

        private int id;
        private Object creator;
        private Object creatorId;
        private Object createdTime;
        private Object lastOperator;
        private Object lastOperatorId;
        private Object updateTime;
        private Object pageNum;
        private Object pageSize;
        private Object orderBy;
        private String name;
        private int type;
        private String pic;
        private String startTime;
        private String endTime;
        private int status;
        private int clickCount;
        private int orderCount;
        private String url;
        private String note;
        private int sort;
        private int linkType;
        private int isJump;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Object getCreator() {
            return creator;
        }

        public void setCreator(Object creator) {
            this.creator = creator;
        }

        public Object getCreatorId() {
            return creatorId;
        }

        public void setCreatorId(Object creatorId) {
            this.creatorId = creatorId;
        }

        public Object getCreatedTime() {
            return createdTime;
        }

        public void setCreatedTime(Object createdTime) {
            this.createdTime = createdTime;
        }

        public Object getLastOperator() {
            return lastOperator;
        }

        public void setLastOperator(Object lastOperator) {
            this.lastOperator = lastOperator;
        }

        public Object getLastOperatorId() {
            return lastOperatorId;
        }

        public void setLastOperatorId(Object lastOperatorId) {
            this.lastOperatorId = lastOperatorId;
        }

        public Object getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(Object updateTime) {
            this.updateTime = updateTime;
        }

        public Object getPageNum() {
            return pageNum;
        }

        public void setPageNum(Object pageNum) {
            this.pageNum = pageNum;
        }

        public Object getPageSize() {
            return pageSize;
        }

        public void setPageSize(Object pageSize) {
            this.pageSize = pageSize;
        }

        public Object getOrderBy() {
            return orderBy;
        }

        public void setOrderBy(Object orderBy) {
            this.orderBy = orderBy;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public String getStartTime() {
            return startTime;
        }

        public void setStartTime(String startTime) {
            this.startTime = startTime;
        }

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getClickCount() {
            return clickCount;
        }

        public void setClickCount(int clickCount) {
            this.clickCount = clickCount;
        }

        public int getOrderCount() {
            return orderCount;
        }

        public void setOrderCount(int orderCount) {
            this.orderCount = orderCount;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getNote() {
            return note;
        }

        public void setNote(String note) {
            this.note = note;
        }

        public int getSort() {
            return sort;
        }

        public void setSort(int sort) {
            this.sort = sort;
        }

        public int getLinkType() {
            return linkType;
        }

        public void setLinkType(int linkType) {
            this.linkType = linkType;
        }

        public int getIsJump() {
            return isJump;
        }

        public void setIsJump(int isJump) {
            this.isJump = isJump;
        }
    }
}
