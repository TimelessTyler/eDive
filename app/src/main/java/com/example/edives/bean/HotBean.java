package com.example.edives.bean;

import java.util.List;

public class HotBean {


    /**
     * code : 200
     * message : 操作成功
     * data : {"total":11,"list":[{"id":7,"dynamicAuthor":"素年未逝","dynamicHeadPortrait":"头像","dynamicContent":null,"createTime":null,"dynamicAddress":null,"dynamicPicture":"https://img.ivsky.com/img/tupian/pre/201811/04/qianshui-006.jpg,https://img.ivsky.com/img/tupian/pre/201811/04/qianshui-007.jpg,https://img.ivsky.com/img/tupian/pre/201811/04/qianshui-010.jpg","dynamicPraise":17,"dynamicSharenum":null,"dynamicCommentnum":null,"userId":null,"topicId":null,"topicName":null,"delflag":null,"identificationPraise":0,"width":null,"height":null,"identification":0},{"id":9,"dynamicAuthor":"旧梦失词","dynamicHeadPortrait":"头像","dynamicContent":null,"createTime":null,"dynamicAddress":null,"dynamicPicture":"https://img.ivsky.com/img/tupian/pre/201811/04/qianshui-005.jpg","dynamicPraise":14,"dynamicSharenum":null,"dynamicCommentnum":null,"userId":null,"topicId":null,"topicName":null,"delflag":null,"identificationPraise":0,"width":null,"height":null,"identification":0},{"id":8,"dynamicAuthor":"海天寻梦","dynamicHeadPortrait":"头像","dynamicContent":null,"createTime":null,"dynamicAddress":null,"dynamicPicture":"https://img.ivsky.com/img/tupian/pre/201811/04/qianshui-009.jpg,https://img.ivsky.com/img/tupian/pre/201811/04/qianshui-011.jpg,https://img.ivsky.com/img/tupian/pre/201811/04/qianshui-001.jpg","dynamicPraise":8,"dynamicSharenum":null,"dynamicCommentnum":null,"userId":null,"topicId":null,"topicName":null,"delflag":null,"identificationPraise":0,"width":null,"height":null,"identification":0},{"id":46,"dynamicAuthor":"小传爱游泳","dynamicHeadPortrait":null,"dynamicContent":null,"createTime":null,"dynamicAddress":null,"dynamicPicture":"http://192.168.0.246/image/1575349896789_12895592.jpg","dynamicPraise":7,"dynamicSharenum":null,"dynamicCommentnum":null,"userId":null,"topicId":null,"topicName":null,"delflag":null,"identificationPraise":0,"width":null,"height":null,"identification":0},{"id":230,"dynamicAuthor":"在爱与悲伤徘徊的女孩纸","dynamicHeadPortrait":null,"dynamicContent":null,"createTime":null,"dynamicAddress":null,"dynamicPicture":"http://192.168.0.246/image/1575472190184_45883617.jpg","dynamicPraise":1,"dynamicSharenum":null,"dynamicCommentnum":null,"userId":null,"topicId":null,"topicName":null,"delflag":null,"identificationPraise":0,"width":100,"height":195,"identification":0},{"id":226,"dynamicAuthor":"多多鱼","dynamicHeadPortrait":null,"dynamicContent":null,"createTime":null,"dynamicAddress":null,"dynamicPicture":"http://192.168.0.246/image/1575458248142_51166796.jpg,http://192.168.0.246/image/1575458248431_34644242.jpg,http://192.168.0.246/image/1575458248469_92043426.jpg,http://192.168.0.246/image/1575458248508_27412424.jpg","dynamicPraise":1,"dynamicSharenum":null,"dynamicCommentnum":null,"userId":null,"topicId":null,"topicName":null,"delflag":null,"identificationPraise":0,"width":170,"height":107,"identification":0},{"id":232,"dynamicAuthor":"多多鱼","dynamicHeadPortrait":null,"dynamicContent":null,"createTime":null,"dynamicAddress":null,"dynamicPicture":"http://192.168.0.246/image/1575511744542_01161089.jpg,http://192.168.0.246/image/1575511744589_00543242.jpg","dynamicPraise":0,"dynamicSharenum":null,"dynamicCommentnum":null,"userId":null,"topicId":null,"topicName":null,"delflag":null,"identificationPraise":0,"width":193,"height":160,"identification":0},{"id":231,"dynamicAuthor":"在爱与悲伤徘徊的女孩纸","dynamicHeadPortrait":null,"dynamicContent":null,"createTime":null,"dynamicAddress":null,"dynamicPicture":"http://192.168.0.246/image/1575472229149_03665453.jpg","dynamicPraise":0,"dynamicSharenum":null,"dynamicCommentnum":null,"userId":null,"topicId":null,"topicName":null,"delflag":null,"identificationPraise":0,"width":113,"height":138,"identification":0},{"id":228,"dynamicAuthor":"美好心情","dynamicHeadPortrait":null,"dynamicContent":null,"createTime":null,"dynamicAddress":null,"dynamicPicture":"http://192.168.0.246/image/1575469704176_01475533.jpg","dynamicPraise":0,"dynamicSharenum":null,"dynamicCommentnum":null,"userId":null,"topicId":null,"topicName":null,"delflag":null,"identificationPraise":0,"width":165,"height":142,"identification":0},{"id":229,"dynamicAuthor":"美好心情","dynamicHeadPortrait":null,"dynamicContent":null,"createTime":null,"dynamicAddress":null,"dynamicPicture":"http://192.168.0.246/image/1575469704203_63319786.jpg","dynamicPraise":0,"dynamicSharenum":null,"dynamicCommentnum":null,"userId":null,"topicId":null,"topicName":null,"delflag":null,"identificationPraise":0,"width":193,"height":124,"identification":0}],"pageNum":1,"pageSize":10,"size":10,"startRow":1,"endRow":10,"pages":2,"prePage":0,"nextPage":2,"isFirstPage":true,"isLastPage":false,"hasPreviousPage":false,"hasNextPage":true,"navigatePages":8,"navigatepageNums":[1,2],"navigateFirstPage":1,"navigateLastPage":2,"lastPage":2,"firstPage":1}
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
         * total : 11
         * list : [{"id":7,"dynamicAuthor":"素年未逝","dynamicHeadPortrait":"头像","dynamicContent":null,"createTime":null,"dynamicAddress":null,"dynamicPicture":"https://img.ivsky.com/img/tupian/pre/201811/04/qianshui-006.jpg,https://img.ivsky.com/img/tupian/pre/201811/04/qianshui-007.jpg,https://img.ivsky.com/img/tupian/pre/201811/04/qianshui-010.jpg","dynamicPraise":17,"dynamicSharenum":null,"dynamicCommentnum":null,"userId":null,"topicId":null,"topicName":null,"delflag":null,"identificationPraise":0,"width":null,"height":null,"identification":0},{"id":9,"dynamicAuthor":"旧梦失词","dynamicHeadPortrait":"头像","dynamicContent":null,"createTime":null,"dynamicAddress":null,"dynamicPicture":"https://img.ivsky.com/img/tupian/pre/201811/04/qianshui-005.jpg","dynamicPraise":14,"dynamicSharenum":null,"dynamicCommentnum":null,"userId":null,"topicId":null,"topicName":null,"delflag":null,"identificationPraise":0,"width":null,"height":null,"identification":0},{"id":8,"dynamicAuthor":"海天寻梦","dynamicHeadPortrait":"头像","dynamicContent":null,"createTime":null,"dynamicAddress":null,"dynamicPicture":"https://img.ivsky.com/img/tupian/pre/201811/04/qianshui-009.jpg,https://img.ivsky.com/img/tupian/pre/201811/04/qianshui-011.jpg,https://img.ivsky.com/img/tupian/pre/201811/04/qianshui-001.jpg","dynamicPraise":8,"dynamicSharenum":null,"dynamicCommentnum":null,"userId":null,"topicId":null,"topicName":null,"delflag":null,"identificationPraise":0,"width":null,"height":null,"identification":0},{"id":46,"dynamicAuthor":"小传爱游泳","dynamicHeadPortrait":null,"dynamicContent":null,"createTime":null,"dynamicAddress":null,"dynamicPicture":"http://192.168.0.246/image/1575349896789_12895592.jpg","dynamicPraise":7,"dynamicSharenum":null,"dynamicCommentnum":null,"userId":null,"topicId":null,"topicName":null,"delflag":null,"identificationPraise":0,"width":null,"height":null,"identification":0},{"id":230,"dynamicAuthor":"在爱与悲伤徘徊的女孩纸","dynamicHeadPortrait":null,"dynamicContent":null,"createTime":null,"dynamicAddress":null,"dynamicPicture":"http://192.168.0.246/image/1575472190184_45883617.jpg","dynamicPraise":1,"dynamicSharenum":null,"dynamicCommentnum":null,"userId":null,"topicId":null,"topicName":null,"delflag":null,"identificationPraise":0,"width":100,"height":195,"identification":0},{"id":226,"dynamicAuthor":"多多鱼","dynamicHeadPortrait":null,"dynamicContent":null,"createTime":null,"dynamicAddress":null,"dynamicPicture":"http://192.168.0.246/image/1575458248142_51166796.jpg,http://192.168.0.246/image/1575458248431_34644242.jpg,http://192.168.0.246/image/1575458248469_92043426.jpg,http://192.168.0.246/image/1575458248508_27412424.jpg","dynamicPraise":1,"dynamicSharenum":null,"dynamicCommentnum":null,"userId":null,"topicId":null,"topicName":null,"delflag":null,"identificationPraise":0,"width":170,"height":107,"identification":0},{"id":232,"dynamicAuthor":"多多鱼","dynamicHeadPortrait":null,"dynamicContent":null,"createTime":null,"dynamicAddress":null,"dynamicPicture":"http://192.168.0.246/image/1575511744542_01161089.jpg,http://192.168.0.246/image/1575511744589_00543242.jpg","dynamicPraise":0,"dynamicSharenum":null,"dynamicCommentnum":null,"userId":null,"topicId":null,"topicName":null,"delflag":null,"identificationPraise":0,"width":193,"height":160,"identification":0},{"id":231,"dynamicAuthor":"在爱与悲伤徘徊的女孩纸","dynamicHeadPortrait":null,"dynamicContent":null,"createTime":null,"dynamicAddress":null,"dynamicPicture":"http://192.168.0.246/image/1575472229149_03665453.jpg","dynamicPraise":0,"dynamicSharenum":null,"dynamicCommentnum":null,"userId":null,"topicId":null,"topicName":null,"delflag":null,"identificationPraise":0,"width":113,"height":138,"identification":0},{"id":228,"dynamicAuthor":"美好心情","dynamicHeadPortrait":null,"dynamicContent":null,"createTime":null,"dynamicAddress":null,"dynamicPicture":"http://192.168.0.246/image/1575469704176_01475533.jpg","dynamicPraise":0,"dynamicSharenum":null,"dynamicCommentnum":null,"userId":null,"topicId":null,"topicName":null,"delflag":null,"identificationPraise":0,"width":165,"height":142,"identification":0},{"id":229,"dynamicAuthor":"美好心情","dynamicHeadPortrait":null,"dynamicContent":null,"createTime":null,"dynamicAddress":null,"dynamicPicture":"http://192.168.0.246/image/1575469704203_63319786.jpg","dynamicPraise":0,"dynamicSharenum":null,"dynamicCommentnum":null,"userId":null,"topicId":null,"topicName":null,"delflag":null,"identificationPraise":0,"width":193,"height":124,"identification":0}]
         * pageNum : 1
         * pageSize : 10
         * size : 10
         * startRow : 1
         * endRow : 10
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
             * id : 7
             * dynamicAuthor : 素年未逝
             * dynamicHeadPortrait : 头像
             * dynamicContent : null
             * createTime : null
             * dynamicAddress : null
             * dynamicPicture : https://img.ivsky.com/img/tupian/pre/201811/04/qianshui-006.jpg,https://img.ivsky.com/img/tupian/pre/201811/04/qianshui-007.jpg,https://img.ivsky.com/img/tupian/pre/201811/04/qianshui-010.jpg
             * dynamicPraise : 17
             * dynamicSharenum : null
             * dynamicCommentnum : null
             * userId : null
             * topicId : null
             * topicName : null
             * delflag : null
             * identificationPraise : 0
             * width : null
             * height : null
             * identification : 0
             */

            private int id;
            private String dynamicAuthor;
            private String dynamicHeadPortrait;
            private Object dynamicContent;
            private Object createTime;
            private Object dynamicAddress;
            private String dynamicPicture;
            private int dynamicPraise;
            private Object dynamicSharenum;
            private Object dynamicCommentnum;
            private Object userId;
            private Object topicId;
            private Object topicName;
            private Object delflag;
            private int userType;
            private int identificationPraise;
            private int width;
            private int height;
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

            public Object getDynamicContent() {
                return dynamicContent;
            }

            public void setDynamicContent(Object dynamicContent) {
                this.dynamicContent = dynamicContent;
            }

            public Object getCreateTime() {
                return createTime;
            }

            public void setCreateTime(Object createTime) {
                this.createTime = createTime;
            }

            public Object getDynamicAddress() {
                return dynamicAddress;
            }

            public void setDynamicAddress(Object dynamicAddress) {
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

            public Object getDynamicSharenum() {
                return dynamicSharenum;
            }

            public void setDynamicSharenum(Object dynamicSharenum) {
                this.dynamicSharenum = dynamicSharenum;
            }

            public Object getDynamicCommentnum() {
                return dynamicCommentnum;
            }

            public void setDynamicCommentnum(Object dynamicCommentnum) {
                this.dynamicCommentnum = dynamicCommentnum;
            }

            public Object getUserId() {
                return userId;
            }

            public void setUserId(Object userId) {
                this.userId = userId;
            }

            public Object getTopicId() {
                return topicId;
            }

            public void setTopicId(Object topicId) {
                this.topicId = topicId;
            }

            public Object getTopicName() {
                return topicName;
            }

            public void setTopicName(Object topicName) {
                this.topicName = topicName;
            }

            public Object getDelflag() {
                return delflag;
            }

            public void setDelflag(Object delflag) {
                this.delflag = delflag;
            }

            public int getIdentificationPraise() {
                return identificationPraise;
            }

            public void setIdentificationPraise(int identificationPraise) {
                this.identificationPraise = identificationPraise;
            }

            public int getWidth() {
                return width;
            }

            public void setWidth(int width) {
                this.width = width;
            }

            public int getHeight() {
                return height;
            }

            public void setHeight(int height) {
                this.height = height;
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
