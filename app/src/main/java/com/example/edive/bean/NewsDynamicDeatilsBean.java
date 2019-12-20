package com.example.edive.bean;

import java.util.List;

public class NewsDynamicDeatilsBean {


    /**
     * code : 200
     * message : 操作成功
     * data : {"total":10,"list":[{"id":29,"dynamicAuthor":"化计划","dynamicHeadPortrait":null,"dynamicContent":"#克罗索尔岛17373747558488484","createTime":"2019-11-28 11:04:23","dynamicAddress":" 恒大冰泉直销店(马甸东路)","dynamicPicture":"","dynamicPraise":0,"dynamicSharenum":0,"dynamicCommentnum":0,"userId":28,"topicId":1,"topicName":"克罗索尔岛","delflag":0,"identificationPraise":0,"identification":0},{"id":28,"dynamicAuthor":"化计划","dynamicHeadPortrait":null,"dynamicContent":"#克罗索尔岛13873744","createTime":"2019-11-28 11:03:30","dynamicAddress":" 悦容女子美容养生SPA会所(马甸店)","dynamicPicture":"","dynamicPraise":1,"dynamicSharenum":0,"dynamicCommentnum":0,"userId":28,"topicId":1,"topicName":"克罗索尔岛","delflag":0,"identificationPraise":0,"identification":0},{"id":9,"dynamicAuthor":"小D","dynamicHeadPortrait":"头像","dynamicContent":"发布动态测试4","createTime":"2019-10-10 14:53:17","dynamicAddress":"string","dynamicPicture":"https://img.ivsky.com/img/tupian/pre/201811/04/qianshui-005.jpg","dynamicPraise":17,"dynamicSharenum":0,"dynamicCommentnum":0,"userId":1,"topicId":1,"topicName":"克罗索尔岛","delflag":0,"identificationPraise":0,"identification":1},{"id":13,"dynamicAuthor":"小D","dynamicHeadPortrait":"头像","dynamicContent":"发布动态测试4","createTime":"2019-10-10 14:53:17","dynamicAddress":"string","dynamicPicture":"https://img.ivsky.com/img/tupian/pre/201811/04/qianshui-005.jpg","dynamicPraise":13,"dynamicSharenum":0,"dynamicCommentnum":0,"userId":19,"topicId":1,"topicName":"克罗索尔岛","delflag":0,"identificationPraise":0,"identification":0},{"id":8,"dynamicAuthor":"小C","dynamicHeadPortrait":"头像","dynamicContent":"发布动态测试3","createTime":"2019-10-09 14:53:17","dynamicAddress":"string","dynamicPicture":"https://img.ivsky.com/img/tupian/pre/201811/04/qianshui-009.jpg,https://img.ivsky.com/img/tupian/pre/201811/04/qianshui-011.jpg,https://img.ivsky.com/img/tupian/pre/201811/04/qianshui-001.jpg","dynamicPraise":12,"dynamicSharenum":0,"dynamicCommentnum":1,"userId":3,"topicId":1,"topicName":"克罗索尔岛","delflag":0,"identificationPraise":0,"identification":0}],"pageNum":1,"pageSize":5,"size":5,"startRow":1,"endRow":5,"pages":2,"prePage":0,"nextPage":2,"isFirstPage":true,"isLastPage":false,"hasPreviousPage":false,"hasNextPage":true,"navigatePages":8,"navigatepageNums":[1,2],"navigateFirstPage":1,"navigateLastPage":2,"lastPage":2,"firstPage":1}
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
         * total : 10
         * list : [{"id":29,"dynamicAuthor":"化计划","dynamicHeadPortrait":null,"dynamicContent":"#克罗索尔岛17373747558488484","createTime":"2019-11-28 11:04:23","dynamicAddress":" 恒大冰泉直销店(马甸东路)","dynamicPicture":"","dynamicPraise":0,"dynamicSharenum":0,"dynamicCommentnum":0,"userId":28,"topicId":1,"topicName":"克罗索尔岛","delflag":0,"identificationPraise":0,"identification":0},{"id":28,"dynamicAuthor":"化计划","dynamicHeadPortrait":null,"dynamicContent":"#克罗索尔岛13873744","createTime":"2019-11-28 11:03:30","dynamicAddress":" 悦容女子美容养生SPA会所(马甸店)","dynamicPicture":"","dynamicPraise":1,"dynamicSharenum":0,"dynamicCommentnum":0,"userId":28,"topicId":1,"topicName":"克罗索尔岛","delflag":0,"identificationPraise":0,"identification":0},{"id":9,"dynamicAuthor":"小D","dynamicHeadPortrait":"头像","dynamicContent":"发布动态测试4","createTime":"2019-10-10 14:53:17","dynamicAddress":"string","dynamicPicture":"https://img.ivsky.com/img/tupian/pre/201811/04/qianshui-005.jpg","dynamicPraise":17,"dynamicSharenum":0,"dynamicCommentnum":0,"userId":1,"topicId":1,"topicName":"克罗索尔岛","delflag":0,"identificationPraise":0,"identification":1},{"id":13,"dynamicAuthor":"小D","dynamicHeadPortrait":"头像","dynamicContent":"发布动态测试4","createTime":"2019-10-10 14:53:17","dynamicAddress":"string","dynamicPicture":"https://img.ivsky.com/img/tupian/pre/201811/04/qianshui-005.jpg","dynamicPraise":13,"dynamicSharenum":0,"dynamicCommentnum":0,"userId":19,"topicId":1,"topicName":"克罗索尔岛","delflag":0,"identificationPraise":0,"identification":0},{"id":8,"dynamicAuthor":"小C","dynamicHeadPortrait":"头像","dynamicContent":"发布动态测试3","createTime":"2019-10-09 14:53:17","dynamicAddress":"string","dynamicPicture":"https://img.ivsky.com/img/tupian/pre/201811/04/qianshui-009.jpg,https://img.ivsky.com/img/tupian/pre/201811/04/qianshui-011.jpg,https://img.ivsky.com/img/tupian/pre/201811/04/qianshui-001.jpg","dynamicPraise":12,"dynamicSharenum":0,"dynamicCommentnum":1,"userId":3,"topicId":1,"topicName":"克罗索尔岛","delflag":0,"identificationPraise":0,"identification":0}]
         * pageNum : 1
         * pageSize : 5
         * size : 5
         * startRow : 1
         * endRow : 5
         * pages : 2
         * prePage : 0
         * nextPage : 2
         * isFirstPage : true
         * isLastPage : false
         * hasPreviousPage : false
         * hasNextPage : true
         * navigatePages : 8
         * navigatepageNums : [1,2]
         * navigateFirstPage : 1
         * navigateLastPage : 2
         * lastPage : 2
         * firstPage : 1
         */

        private int total;
        private int pageNum;
        private int pageSize;
        private int size;
        private int startRow;
        private int endRow;
        private int pages;
        private int prePage;
        private int nextPage;
        private boolean isFirstPage;
        private boolean isLastPage;
        private boolean hasPreviousPage;
        private boolean hasNextPage;
        private int navigatePages;
        private int navigateFirstPage;
        private int navigateLastPage;
        private int lastPage;
        private int firstPage;
        private List<ListBean> list;
        private List<Integer> navigatepageNums;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getPageNum() {
            return pageNum;
        }

        public void setPageNum(int pageNum) {
            this.pageNum = pageNum;
        }

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int getStartRow() {
            return startRow;
        }

        public void setStartRow(int startRow) {
            this.startRow = startRow;
        }

        public int getEndRow() {
            return endRow;
        }

        public void setEndRow(int endRow) {
            this.endRow = endRow;
        }

        public int getPages() {
            return pages;
        }

        public void setPages(int pages) {
            this.pages = pages;
        }

        public int getPrePage() {
            return prePage;
        }

        public void setPrePage(int prePage) {
            this.prePage = prePage;
        }

        public int getNextPage() {
            return nextPage;
        }

        public void setNextPage(int nextPage) {
            this.nextPage = nextPage;
        }

        public boolean isIsFirstPage() {
            return isFirstPage;
        }

        public void setIsFirstPage(boolean isFirstPage) {
            this.isFirstPage = isFirstPage;
        }

        public boolean isIsLastPage() {
            return isLastPage;
        }

        public void setIsLastPage(boolean isLastPage) {
            this.isLastPage = isLastPage;
        }

        public boolean isHasPreviousPage() {
            return hasPreviousPage;
        }

        public void setHasPreviousPage(boolean hasPreviousPage) {
            this.hasPreviousPage = hasPreviousPage;
        }

        public boolean isHasNextPage() {
            return hasNextPage;
        }

        public void setHasNextPage(boolean hasNextPage) {
            this.hasNextPage = hasNextPage;
        }

        public int getNavigatePages() {
            return navigatePages;
        }

        public void setNavigatePages(int navigatePages) {
            this.navigatePages = navigatePages;
        }

        public int getNavigateFirstPage() {
            return navigateFirstPage;
        }

        public void setNavigateFirstPage(int navigateFirstPage) {
            this.navigateFirstPage = navigateFirstPage;
        }

        public int getNavigateLastPage() {
            return navigateLastPage;
        }

        public void setNavigateLastPage(int navigateLastPage) {
            this.navigateLastPage = navigateLastPage;
        }

        public int getLastPage() {
            return lastPage;
        }

        public void setLastPage(int lastPage) {
            this.lastPage = lastPage;
        }

        public int getFirstPage() {
            return firstPage;
        }

        public void setFirstPage(int firstPage) {
            this.firstPage = firstPage;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public List<Integer> getNavigatepageNums() {
            return navigatepageNums;
        }

        public void setNavigatepageNums(List<Integer> navigatepageNums) {
            this.navigatepageNums = navigatepageNums;
        }

        public static class ListBean {
            /**
             * id : 29
             * dynamicAuthor : 化计划
             * dynamicHeadPortrait : null
             * dynamicContent : #克罗索尔岛17373747558488484
             * createTime : 2019-11-28 11:04:23
             * dynamicAddress :  恒大冰泉直销店(马甸东路)
             * dynamicPicture :
             * dynamicPraise : 0
             * dynamicSharenum : 0
             * dynamicCommentnum : 0
             * userId : 28
             * topicId : 1
             * topicName : 克罗索尔岛
             * delflag : 0
             * identificationPraise : 0
             * identification : 0
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
            private int userType;
            private int delflag;
            private int identificationPraise;
            private int identification;

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

            public int getIdentificationPraise() {
                return identificationPraise;
            }

            public void setIdentificationPraise(int identificationPraise) {
                this.identificationPraise = identificationPraise;
            }

            public int getIdentification() {
                return identification;
            }

            public void setIdentification(int identification) {
                this.identification = identification;
            }

            public int getUserType() {
                return userType;
            }

            public void setUserType(int userType) {
                this.userType = userType;
            }
        }
    }
}
