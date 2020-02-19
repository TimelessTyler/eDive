package com.example.edives.bean;

import java.util.List;

public class MytraineeBean {
    /**
     * code : 200
     * message : 操作成功
     * result : {"total":22,"list":[{"userId":32,"userIcon":"http://47.107.50.253:8080/webapps/uploadFile/image/1577180349131_76849674.jpg","userNickName":"今天明天后","createTime":"2019-12-06 18:34:40"},{"userId":33,"userIcon":"http://47.107.50.253:8080/webapps/uploadFile/image/1575793587544_19318556.jpg","userNickName":"多多","createTime":"2019-12-07 14:09:13"},{"userId":34,"userIcon":"http://47.107.50.253:8080/webapps/uploadFile/image/1577757869048_93780008.jpg","userNickName":"礼貌的下巴","createTime":"2019-12-08 18:54:03"},{"userId":35,"userIcon":"http://47.107.50.253:8080/webapps/uploadFile/compent/20191208145645.png","userNickName":"公办的水果","createTime":"2019-12-09 10:58:36"},{"userId":36,"userIcon":"http://47.107.50.253:8080/webapps/uploadFile/compent/20191208145645.png","userNickName":"合格的手工","createTime":"2019-12-09 10:59:01"},{"userId":37,"userIcon":"http://47.107.50.253:8080/webapps/uploadFile/compent/20191208145645.png","userNickName":"过时的水珠","createTime":"2019-12-09 10:59:15"},{"userId":38,"userIcon":"http://47.107.50.253:8080/webapps/uploadFile/compent/20191208145645.png","userNickName":"日用的摇篮","createTime":"2019-12-09 11:03:39"},{"userId":39,"userIcon":"http://47.107.50.253:8080/webapps/uploadFile/compent/20191208145645.png","userNickName":"一定的居民","createTime":"2019-12-09 11:03:59"},{"userId":40,"userIcon":"http://47.107.50.253:8080/webapps/uploadFile/compent/20191208145645.png","userNickName":"听话的早晨","createTime":"2019-12-09 11:24:48"},{"userId":41,"userIcon":"http://47.107.50.253:8080/webapps/uploadFile/compent/20191208145645.png","userNickName":"精彩的雨伞","createTime":"2019-12-10 15:03:02"}],"pageNum":1,"pageSize":10,"size":10,"startRow":1,"endRow":10,"pages":3,"prePage":0,"nextPage":2,"isFirstPage":true,"isLastPage":false,"hasPreviousPage":false,"hasNextPage":true,"navigatePages":8,"navigatepageNums":[1,2,3],"navigateFirstPage":1,"navigateLastPage":3,"firstPage":1,"lastPage":3}
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
         * total : 22
         * list : [{"userId":32,"userIcon":"http://47.107.50.253:8080/webapps/uploadFile/image/1577180349131_76849674.jpg","userNickName":"今天明天后","createTime":"2019-12-06 18:34:40"},{"userId":33,"userIcon":"http://47.107.50.253:8080/webapps/uploadFile/image/1575793587544_19318556.jpg","userNickName":"多多","createTime":"2019-12-07 14:09:13"},{"userId":34,"userIcon":"http://47.107.50.253:8080/webapps/uploadFile/image/1577757869048_93780008.jpg","userNickName":"礼貌的下巴","createTime":"2019-12-08 18:54:03"},{"userId":35,"userIcon":"http://47.107.50.253:8080/webapps/uploadFile/compent/20191208145645.png","userNickName":"公办的水果","createTime":"2019-12-09 10:58:36"},{"userId":36,"userIcon":"http://47.107.50.253:8080/webapps/uploadFile/compent/20191208145645.png","userNickName":"合格的手工","createTime":"2019-12-09 10:59:01"},{"userId":37,"userIcon":"http://47.107.50.253:8080/webapps/uploadFile/compent/20191208145645.png","userNickName":"过时的水珠","createTime":"2019-12-09 10:59:15"},{"userId":38,"userIcon":"http://47.107.50.253:8080/webapps/uploadFile/compent/20191208145645.png","userNickName":"日用的摇篮","createTime":"2019-12-09 11:03:39"},{"userId":39,"userIcon":"http://47.107.50.253:8080/webapps/uploadFile/compent/20191208145645.png","userNickName":"一定的居民","createTime":"2019-12-09 11:03:59"},{"userId":40,"userIcon":"http://47.107.50.253:8080/webapps/uploadFile/compent/20191208145645.png","userNickName":"听话的早晨","createTime":"2019-12-09 11:24:48"},{"userId":41,"userIcon":"http://47.107.50.253:8080/webapps/uploadFile/compent/20191208145645.png","userNickName":"精彩的雨伞","createTime":"2019-12-10 15:03:02"}]
         * pageNum : 1
         * pageSize : 10
         * size : 10
         * startRow : 1
         * endRow : 10
         * pages : 3
         * prePage : 0
         * nextPage : 2
         * isFirstPage : true
         * isLastPage : false
         * hasPreviousPage : false
         * hasNextPage : true
         * navigatePages : 8
         * navigatepageNums : [1,2,3]
         * navigateFirstPage : 1
         * navigateLastPage : 3
         * firstPage : 1
         * lastPage : 3
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
             * userId : 32
             * userIcon : http://47.107.50.253:8080/webapps/uploadFile/image/1577180349131_76849674.jpg
             * userNickName : 今天明天后
             * createTime : 2019-12-06 18:34:40
             */

            private int userId;
            private String userIcon;
            private String userNickName;
            private String createTime;

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public String getUserIcon() {
                return userIcon;
            }

            public void setUserIcon(String userIcon) {
                this.userIcon = userIcon;
            }

            public String getUserNickName() {
                return userNickName;
            }

            public void setUserNickName(String userNickName) {
                this.userNickName = userNickName;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }
        }
    }
}
