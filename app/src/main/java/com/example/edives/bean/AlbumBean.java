package com.example.edives.bean;

import java.util.List;

public class AlbumBean {
    /**
     * code : 200
     * message : 操作成功
     * data : {"total":1,"list":[{"userId":32,"pictureNum":5,"picture":"http://47.107.50.253:8080/webapps/uploadFile/image/1575796517222_22785450.jpg,http://47.107.50.253:8080/webapps/uploadFile/image/1575800647768_35963793.jpg,http://47.107.50.253:8080/webapps/uploadFile/image/1575800647707_39108486.jpg,http://47.107.50.253:8080/webapps/uploadFile/image/1575860442486_67274163.jpg,http://47.107.50.253:8080/webapps/uploadFile/image/1575860444931_27947434.jpg","months":"201912"}],"pageNum":1,"pageSize":5,"size":1,"startRow":1,"endRow":1,"pages":1,"prePage":0,"nextPage":0,"isFirstPage":true,"isLastPage":true,"hasPreviousPage":false,"hasNextPage":false,"navigatePages":8,"navigatepageNums":[1],"navigateFirstPage":1,"navigateLastPage":1,"firstPage":1,"lastPage":1}
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
         * total : 1
         * list : [{"userId":32,"pictureNum":5,"picture":"http://47.107.50.253:8080/webapps/uploadFile/image/1575796517222_22785450.jpg,http://47.107.50.253:8080/webapps/uploadFile/image/1575800647768_35963793.jpg,http://47.107.50.253:8080/webapps/uploadFile/image/1575800647707_39108486.jpg,http://47.107.50.253:8080/webapps/uploadFile/image/1575860442486_67274163.jpg,http://47.107.50.253:8080/webapps/uploadFile/image/1575860444931_27947434.jpg","months":"201912"}]
         * pageNum : 1
         * pageSize : 5
         * size : 1
         * startRow : 1
         * endRow : 1
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
             * userId : 32
             * pictureNum : 5
             * picture : http://47.107.50.253:8080/webapps/uploadFile/image/1575796517222_22785450.jpg,http://47.107.50.253:8080/webapps/uploadFile/image/1575800647768_35963793.jpg,http://47.107.50.253:8080/webapps/uploadFile/image/1575800647707_39108486.jpg,http://47.107.50.253:8080/webapps/uploadFile/image/1575860442486_67274163.jpg,http://47.107.50.253:8080/webapps/uploadFile/image/1575860444931_27947434.jpg
             * months : 201912
             */

            private int userId;
            private int pictureNum;
            private String picture;
            private String months;

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public int getPictureNum() {
                return pictureNum;
            }

            public void setPictureNum(int pictureNum) {
                this.pictureNum = pictureNum;
            }

            public String getPicture() {
                return picture;
            }

            public void setPicture(String picture) {
                this.picture = picture;
            }

            public String getMonths() {
                return months;
            }

            public void setMonths(String months) {
                this.months = months;
            }
        }
    }
}
