package com.example.edive.bean;

import java.util.List;

public class DivingBean {

    /**
     * code : 200
     * message : 操作成功
     * result : {"total":2,"list":[{"id":2,"productName":"潜水商品2","location":"巴厘岛","title":"我们都是时间旅行者","image":"http://47.107.50.253:8080/webapps/uploadFile/dmd/343434.jpg","price":3800,"coachName":"王海成","coachIcon":"http://img1.imgtn.bdimg.com/it/u=1411728850,1869975885&fm=26&gp=0.jpg","coachId":2,"coachGrade":"8888","startTime":"2019-12-08 13:17:00","endTime":"2020-01-01 11:05:13","availableIntegral":null},{"id":3,"productName":"潜水商品3","location":"马来西亚","title":"为了寻找生命中的光 ","image":"http://47.107.50.253:8080/webapps/uploadFile/dmd/898989.jpg","price":5000,"coachName":"陈衍兵","coachIcon":"http://img1.imgtn.bdimg.com/it/u=1411728850,1869975885&fm=26&gp=0.jpg","coachId":3,"coachGrade":"8888","startTime":"2019-12-08 13:17:00","endTime":"2020-01-01 11:05:13","availableIntegral":null}],"pageNum":1,"pageSize":5,"size":2,"startRow":1,"endRow":2,"pages":1,"prePage":0,"nextPage":0,"isFirstPage":true,"isLastPage":true,"hasPreviousPage":false,"hasNextPage":false,"navigatePages":8,"navigatepageNums":[1],"navigateFirstPage":1,"navigateLastPage":1,"firstPage":1,"lastPage":1}
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
         * list : [{"id":2,"productName":"潜水商品2","location":"巴厘岛","title":"我们都是时间旅行者","image":"http://47.107.50.253:8080/webapps/uploadFile/dmd/343434.jpg","price":3800,"coachName":"王海成","coachIcon":"http://img1.imgtn.bdimg.com/it/u=1411728850,1869975885&fm=26&gp=0.jpg","coachId":2,"coachGrade":"8888","startTime":"2019-12-08 13:17:00","endTime":"2020-01-01 11:05:13","availableIntegral":null},{"id":3,"productName":"潜水商品3","location":"马来西亚","title":"为了寻找生命中的光 ","image":"http://47.107.50.253:8080/webapps/uploadFile/dmd/898989.jpg","price":5000,"coachName":"陈衍兵","coachIcon":"http://img1.imgtn.bdimg.com/it/u=1411728850,1869975885&fm=26&gp=0.jpg","coachId":3,"coachGrade":"8888","startTime":"2019-12-08 13:17:00","endTime":"2020-01-01 11:05:13","availableIntegral":null}]
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
             * id : 2
             * productName : 潜水商品2
             * location : 巴厘岛
             * title : 我们都是时间旅行者
             * image : http://47.107.50.253:8080/webapps/uploadFile/dmd/343434.jpg
             * price : 3800.0
             * coachName : 王海成
             * coachIcon : http://img1.imgtn.bdimg.com/it/u=1411728850,1869975885&fm=26&gp=0.jpg
             * coachId : 2
             * coachGrade : 8888
             * startTime : 2019-12-08 13:17:00
             * endTime : 2020-01-01 11:05:13
             * availableIntegral : null
             */

            private int id;
            private String productName;
            private String location;
            private String title;
            private String image;
            private double price;
            private String coachName;
            private String coachIcon;
            private int coachId;
            private String coachGrade;
            private String startTime;
            private String endTime;
            private Object availableIntegral;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getProductName() {
                return productName;
            }

            public void setProductName(String productName) {
                this.productName = productName;
            }

            public String getLocation() {
                return location;
            }

            public void setLocation(String location) {
                this.location = location;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public double getPrice() {
                return price;
            }

            public void setPrice(double price) {
                this.price = price;
            }

            public String getCoachName() {
                return coachName;
            }

            public void setCoachName(String coachName) {
                this.coachName = coachName;
            }

            public String getCoachIcon() {
                return coachIcon;
            }

            public void setCoachIcon(String coachIcon) {
                this.coachIcon = coachIcon;
            }

            public int getCoachId() {
                return coachId;
            }

            public void setCoachId(int coachId) {
                this.coachId = coachId;
            }

            public String getCoachGrade() {
                return coachGrade;
            }

            public void setCoachGrade(String coachGrade) {
                this.coachGrade = coachGrade;
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

            public Object getAvailableIntegral() {
                return availableIntegral;
            }

            public void setAvailableIntegral(Object availableIntegral) {
                this.availableIntegral = availableIntegral;
            }
        }
    }
}
