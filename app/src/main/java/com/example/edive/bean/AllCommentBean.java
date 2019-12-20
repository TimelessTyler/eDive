package com.example.edive.bean;

import java.util.List;

public class AllCommentBean {

    /**
     * code : 200
     * message : 操作成功
     * data : {"total":8,"list":[{"commentId":99,"commentName":"今天明天后天","commentHeadPortrait":"http://47.107.50.253:8080/webapps/uploadFile/image/1575796840202_41501680.jpg","createTime":"2019-12-11 17:05:49","content":"嗯哼","type":0,"ipAddress":"172.18.39.138","status":0,"delflag":0,"forUid":0,"forDynamicId":43,"forDiveLogId":null,"userId":32,"forPid":0,"children":[]},{"commentId":98,"commentName":"今天明天后天","commentHeadPortrait":"http://47.107.50.253:8080/webapps/uploadFile/image/1575796840202_41501680.jpg","createTime":"2019-12-11 16:38:33","content":"啊哈","type":0,"ipAddress":"172.18.39.138","status":0,"delflag":0,"forUid":0,"forDynamicId":43,"forDiveLogId":null,"userId":32,"forPid":0,"children":[]},{"commentId":97,"commentName":"今天明天后天","commentHeadPortrait":"http://47.107.50.253:8080/webapps/uploadFile/image/1575796840202_41501680.jpg","createTime":"2019-12-11 16:38:17","content":"嗯哼嗯哼嗯哼","type":0,"ipAddress":"172.18.39.138","status":0,"delflag":0,"forUid":0,"forDynamicId":43,"forDiveLogId":null,"userId":32,"forPid":0,"children":[]},{"commentId":96,"commentName":"今天明天后天","commentHeadPortrait":"http://47.107.50.253:8080/webapps/uploadFile/image/1575796840202_41501680.jpg","createTime":"2019-12-11 16:37:57","content":"哈哈哈哈哈","type":0,"ipAddress":"172.18.39.138","status":0,"delflag":0,"forUid":0,"forDynamicId":43,"forDiveLogId":null,"userId":32,"forPid":0,"children":[]},{"commentId":95,"commentName":"今天明天后天","commentHeadPortrait":"http://47.107.50.253:8080/webapps/uploadFile/image/1575796840202_41501680.jpg","createTime":"2019-12-11 16:24:06","content":"哈哈","type":0,"ipAddress":"172.18.39.138","status":0,"delflag":0,"forUid":0,"forDynamicId":43,"forDiveLogId":null,"userId":32,"forPid":0,"children":[]}],"pageNum":1,"pageSize":5,"size":5,"startRow":1,"endRow":5,"pages":2,"prePage":0,"nextPage":2,"isFirstPage":true,"isLastPage":false,"hasPreviousPage":false,"hasNextPage":true,"navigatePages":8,"navigatepageNums":[1,2],"navigateFirstPage":1,"navigateLastPage":2,"firstPage":1,"lastPage":2}
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
         * total : 8
         * list : [{"commentId":99,"commentName":"今天明天后天","commentHeadPortrait":"http://47.107.50.253:8080/webapps/uploadFile/image/1575796840202_41501680.jpg","createTime":"2019-12-11 17:05:49","content":"嗯哼","type":0,"ipAddress":"172.18.39.138","status":0,"delflag":0,"forUid":0,"forDynamicId":43,"forDiveLogId":null,"userId":32,"forPid":0,"children":[]},{"commentId":98,"commentName":"今天明天后天","commentHeadPortrait":"http://47.107.50.253:8080/webapps/uploadFile/image/1575796840202_41501680.jpg","createTime":"2019-12-11 16:38:33","content":"啊哈","type":0,"ipAddress":"172.18.39.138","status":0,"delflag":0,"forUid":0,"forDynamicId":43,"forDiveLogId":null,"userId":32,"forPid":0,"children":[]},{"commentId":97,"commentName":"今天明天后天","commentHeadPortrait":"http://47.107.50.253:8080/webapps/uploadFile/image/1575796840202_41501680.jpg","createTime":"2019-12-11 16:38:17","content":"嗯哼嗯哼嗯哼","type":0,"ipAddress":"172.18.39.138","status":0,"delflag":0,"forUid":0,"forDynamicId":43,"forDiveLogId":null,"userId":32,"forPid":0,"children":[]},{"commentId":96,"commentName":"今天明天后天","commentHeadPortrait":"http://47.107.50.253:8080/webapps/uploadFile/image/1575796840202_41501680.jpg","createTime":"2019-12-11 16:37:57","content":"哈哈哈哈哈","type":0,"ipAddress":"172.18.39.138","status":0,"delflag":0,"forUid":0,"forDynamicId":43,"forDiveLogId":null,"userId":32,"forPid":0,"children":[]},{"commentId":95,"commentName":"今天明天后天","commentHeadPortrait":"http://47.107.50.253:8080/webapps/uploadFile/image/1575796840202_41501680.jpg","createTime":"2019-12-11 16:24:06","content":"哈哈","type":0,"ipAddress":"172.18.39.138","status":0,"delflag":0,"forUid":0,"forDynamicId":43,"forDiveLogId":null,"userId":32,"forPid":0,"children":[]}]
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
         * firstPage : 1
         * lastPage : 2
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
             * commentId : 99
             * commentName : 今天明天后天
             * commentHeadPortrait : http://47.107.50.253:8080/webapps/uploadFile/image/1575796840202_41501680.jpg
             * createTime : 2019-12-11 17:05:49
             * content : 嗯哼
             * type : 0
             * ipAddress : 172.18.39.138
             * status : 0
             * delflag : 0
             * forUid : 0
             * forDynamicId : 43
             * forDiveLogId : null
             * userId : 32
             * forPid : 0
             * children : []
             */

            private int commentId;
            private String commentName;
            private String commentHeadPortrait;
            private String createTime;
            private String content;
            private int type;
            private String ipAddress;
            private int status;
            private int delflag;
            private int forUid;
            private int forDynamicId;
            private Object forDiveLogId;
            private int userId;
            private int forPid;
            private List<?> children;

            public int getCommentId() {
                return commentId;
            }

            public void setCommentId(int commentId) {
                this.commentId = commentId;
            }

            public String getCommentName() {
                return commentName;
            }

            public void setCommentName(String commentName) {
                this.commentName = commentName;
            }

            public String getCommentHeadPortrait() {
                return commentHeadPortrait;
            }

            public void setCommentHeadPortrait(String commentHeadPortrait) {
                this.commentHeadPortrait = commentHeadPortrait;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public String getIpAddress() {
                return ipAddress;
            }

            public void setIpAddress(String ipAddress) {
                this.ipAddress = ipAddress;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public int getDelflag() {
                return delflag;
            }

            public void setDelflag(int delflag) {
                this.delflag = delflag;
            }

            public int getForUid() {
                return forUid;
            }

            public void setForUid(int forUid) {
                this.forUid = forUid;
            }

            public int getForDynamicId() {
                return forDynamicId;
            }

            public void setForDynamicId(int forDynamicId) {
                this.forDynamicId = forDynamicId;
            }

            public Object getForDiveLogId() {
                return forDiveLogId;
            }

            public void setForDiveLogId(Object forDiveLogId) {
                this.forDiveLogId = forDiveLogId;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public int getForPid() {
                return forPid;
            }

            public void setForPid(int forPid) {
                this.forPid = forPid;
            }

            public List<?> getChildren() {
                return children;
            }

            public void setChildren(List<?> children) {
                this.children = children;
            }
        }
    }
}
