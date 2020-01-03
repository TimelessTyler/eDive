package com.example.edives.bean;

import java.util.List;

public class MyDynamicBean {

    /**
     * code : 200
     * message : 操作成功
     * data : {"total":2,"list":[{"id":271,"dynamicAuthor":"今天明天后天","dynamicHeadPortrait":"http://192.168.0.246/image/1576752042578_77917411.jpg","dynamicContent":"哈哈哈红红火火恍恍惚惚","createTime":"2019-12-20 11:52:32","dynamicAddress":"北京市海淀区马甸东路17号靠近中国农业银行(马甸东路支行)","dynamicPicture":"http://192.168.0.246/image/1576813951414_92681470.jpg,http://192.168.0.246/image/1576813951574_81301560.jpg","dynamicPraise":0,"dynamicSharenum":0,"dynamicCommentnum":0,"userId":23,"topicId":4,"topicName":"巴厘岛","delflag":0,"identificationPraise":0,"width":null,"height":null,"userType":2,"identification":null},{"id":270,"dynamicAuthor":"今天明天后天","dynamicHeadPortrait":"http://192.168.0.246/image/1576752042578_77917411.jpg","dynamicContent":"哈哈教练test","createTime":"2019-12-20 11:36:16","dynamicAddress":"北京市海淀区马甸东路19号靠近中国农业银行(马甸东路支行)","dynamicPicture":"http://192.168.0.246/image/1576812975570_54575624.jpg,http://192.168.0.246/image/1576812975674_15683875.jpg","dynamicPraise":0,"dynamicSharenum":0,"dynamicCommentnum":0,"userId":23,"topicId":0,"topicName":null,"delflag":0,"identificationPraise":0,"width":null,"height":null,"userType":2,"identification":null}],"pageNum":1,"pageSize":5,"size":2,"startRow":1,"endRow":2,"pages":1,"prePage":0,"nextPage":0,"isFirstPage":true,"isLastPage":true,"hasPreviousPage":false,"hasNextPage":false,"navigatePages":8,"navigatepageNums":[1],"navigateFirstPage":1,"navigateLastPage":1,"firstPage":1,"lastPage":1}
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
         * total : 2
         * list : [{"id":271,"dynamicAuthor":"今天明天后天","dynamicHeadPortrait":"http://192.168.0.246/image/1576752042578_77917411.jpg","dynamicContent":"哈哈哈红红火火恍恍惚惚","createTime":"2019-12-20 11:52:32","dynamicAddress":"北京市海淀区马甸东路17号靠近中国农业银行(马甸东路支行)","dynamicPicture":"http://192.168.0.246/image/1576813951414_92681470.jpg,http://192.168.0.246/image/1576813951574_81301560.jpg","dynamicPraise":0,"dynamicSharenum":0,"dynamicCommentnum":0,"userId":23,"topicId":4,"topicName":"巴厘岛","delflag":0,"identificationPraise":0,"width":null,"height":null,"userType":2,"identification":null},{"id":270,"dynamicAuthor":"今天明天后天","dynamicHeadPortrait":"http://192.168.0.246/image/1576752042578_77917411.jpg","dynamicContent":"哈哈教练test","createTime":"2019-12-20 11:36:16","dynamicAddress":"北京市海淀区马甸东路19号靠近中国农业银行(马甸东路支行)","dynamicPicture":"http://192.168.0.246/image/1576812975570_54575624.jpg,http://192.168.0.246/image/1576812975674_15683875.jpg","dynamicPraise":0,"dynamicSharenum":0,"dynamicCommentnum":0,"userId":23,"topicId":0,"topicName":null,"delflag":0,"identificationPraise":0,"width":null,"height":null,"userType":2,"identification":null}]
         * pageNum : 1
         * pageSize : 5
         * size : 2
         * startRow : 1
         * endRow : 2
         * pages : 1
         * prePage : 0
         * nextPage : 0
         * isFirstPage : true
         * isLastPage : true
         * hasPreviousPage : false
         * hasNextPage : false
         * navigatePages : 8
         * navigatepageNums : [1]
         * navigateFirstPage : 1
         * navigateLastPage : 1
         * firstPage : 1
         * lastPage : 1
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
        private int firstPage;
        private int lastPage;
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

        public int getFirstPage() {
            return firstPage;
        }

        public void setFirstPage(int firstPage) {
            this.firstPage = firstPage;
        }

        public int getLastPage() {
            return lastPage;
        }

        public void setLastPage(int lastPage) {
            this.lastPage = lastPage;
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
             * id : 271
             * dynamicAuthor : 今天明天后天
             * dynamicHeadPortrait : http://192.168.0.246/image/1576752042578_77917411.jpg
             * dynamicContent : 哈哈哈红红火火恍恍惚惚
             * createTime : 2019-12-20 11:52:32
             * dynamicAddress : 北京市海淀区马甸东路17号靠近中国农业银行(马甸东路支行)
             * dynamicPicture : http://192.168.0.246/image/1576813951414_92681470.jpg,http://192.168.0.246/image/1576813951574_81301560.jpg
             * dynamicPraise : 0
             * dynamicSharenum : 0
             * dynamicCommentnum : 0
             * userId : 23
             * topicId : 4
             * topicName : 巴厘岛
             * delflag : 0
             * identificationPraise : 0
             * width : null
             * height : null
             * userType : 2
             * identification : null
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
            private int identificationPraise;
            private Object width;
            private Object height;
            private int userType;
            private Object identification;

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

            public Object getWidth() {
                return width;
            }

            public void setWidth(Object width) {
                this.width = width;
            }

            public Object getHeight() {
                return height;
            }

            public void setHeight(Object height) {
                this.height = height;
            }

            public int getUserType() {
                return userType;
            }

            public void setUserType(int userType) {
                this.userType = userType;
            }

            public Object getIdentification() {
                return identification;
            }

            public void setIdentification(Object identification) {
                this.identification = identification;
            }
        }
    }
}
