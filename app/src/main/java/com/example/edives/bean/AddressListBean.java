package com.example.edives.bean;

import java.util.List;

public class AddressListBean {
    /**
     * code : 200
     * message : 操作成功
     * result : {"total":2,"list":[{"id":11,"creator":"15609563858","creatorId":21,"createdTime":"2019-12-02 13:45:00","lastOperator":"15609563858","lastOperatorId":21,"updateTime":"2019-12-02 13:45:00","pageNum":null,"pageSize":null,"orderBy":null,"userId":21,"userType":"member","receiverName":"黎门","receiverPhoneNo":"","receiverMobileNo":"15609563858","provinceId":null,"provinceName":"","cityId":null,"cityName":"北京市","districtId":"","districtName":"昌平区","detailAddress":"天通苑西一区","receiverZipCode":"","defaultAddress":1},{"id":12,"creator":"15609563858","creatorId":21,"createdTime":"2019-12-02 13:49:14","lastOperator":"15609563858","lastOperatorId":21,"updateTime":"2019-12-02 13:49:14","pageNum":null,"pageSize":null,"orderBy":null,"userId":21,"userType":"member","receiverName":"黎门","receiverPhoneNo":"","receiverMobileNo":"15609563858","provinceId":null,"provinceName":"","cityId":null,"cityName":"北京市","districtId":"","districtName":"昌平区","detailAddress":"天通苑西一区","receiverZipCode":"","defaultAddress":0}],"pageNum":1,"pageSize":5,"size":2,"startRow":1,"endRow":2,"pages":1,"prePage":0,"nextPage":0,"isFirstPage":true,"isLastPage":true,"hasPreviousPage":false,"hasNextPage":false,"navigatePages":8,"navigatepageNums":[1],"navigateFirstPage":1,"navigateLastPage":1,"firstPage":1,"lastPage":1}
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
         * list : [{"id":11,"creator":"15609563858","creatorId":21,"createdTime":"2019-12-02 13:45:00","lastOperator":"15609563858","lastOperatorId":21,"updateTime":"2019-12-02 13:45:00","pageNum":null,"pageSize":null,"orderBy":null,"userId":21,"userType":"member","receiverName":"黎门","receiverPhoneNo":"","receiverMobileNo":"15609563858","provinceId":null,"provinceName":"","cityId":null,"cityName":"北京市","districtId":"","districtName":"昌平区","detailAddress":"天通苑西一区","receiverZipCode":"","defaultAddress":1},{"id":12,"creator":"15609563858","creatorId":21,"createdTime":"2019-12-02 13:49:14","lastOperator":"15609563858","lastOperatorId":21,"updateTime":"2019-12-02 13:49:14","pageNum":null,"pageSize":null,"orderBy":null,"userId":21,"userType":"member","receiverName":"黎门","receiverPhoneNo":"","receiverMobileNo":"15609563858","provinceId":null,"provinceName":"","cityId":null,"cityName":"北京市","districtId":"","districtName":"昌平区","detailAddress":"天通苑西一区","receiverZipCode":"","defaultAddress":0}]
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
             * id : 11
             * creator : 15609563858
             * creatorId : 21
             * createdTime : 2019-12-02 13:45:00
             * lastOperator : 15609563858
             * lastOperatorId : 21
             * updateTime : 2019-12-02 13:45:00
             * pageNum : null
             * pageSize : null
             * orderBy : null
             * userId : 21
             * userType : member
             * receiverName : 黎门
             * receiverPhoneNo :
             * receiverMobileNo : 15609563858
             * provinceId : null
             * provinceName :
             * cityId : null
             * cityName : 北京市
             * districtId :
             * districtName : 昌平区
             * detailAddress : 天通苑西一区
             * receiverZipCode :
             * defaultAddress : 1
             */

            private int id;
            private String creator;
            private int creatorId;
            private String createdTime;
            private String lastOperator;
            private int lastOperatorId;
            private String updateTime;
            private Object pageNum;
            private Object pageSize;
            private Object orderBy;
            private int userId;
            private String userType;
            private String receiverName;
            private String receiverPhoneNo;
            private String receiverMobileNo;
            private Object provinceId;
            private String provinceName;
            private Object cityId;
            private String cityName;
            private String districtId;
            private String districtName;
            private String detailAddress;
            private String receiverZipCode;
            private int defaultAddress;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getCreator() {
                return creator;
            }

            public void setCreator(String creator) {
                this.creator = creator;
            }

            public int getCreatorId() {
                return creatorId;
            }

            public void setCreatorId(int creatorId) {
                this.creatorId = creatorId;
            }

            public String getCreatedTime() {
                return createdTime;
            }

            public void setCreatedTime(String createdTime) {
                this.createdTime = createdTime;
            }

            public String getLastOperator() {
                return lastOperator;
            }

            public void setLastOperator(String lastOperator) {
                this.lastOperator = lastOperator;
            }

            public int getLastOperatorId() {
                return lastOperatorId;
            }

            public void setLastOperatorId(int lastOperatorId) {
                this.lastOperatorId = lastOperatorId;
            }

            public String getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(String updateTime) {
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

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public String getUserType() {
                return userType;
            }

            public void setUserType(String userType) {
                this.userType = userType;
            }

            public String getReceiverName() {
                return receiverName;
            }

            public void setReceiverName(String receiverName) {
                this.receiverName = receiverName;
            }

            public String getReceiverPhoneNo() {
                return receiverPhoneNo;
            }

            public void setReceiverPhoneNo(String receiverPhoneNo) {
                this.receiverPhoneNo = receiverPhoneNo;
            }

            public String getReceiverMobileNo() {
                return receiverMobileNo;
            }

            public void setReceiverMobileNo(String receiverMobileNo) {
                this.receiverMobileNo = receiverMobileNo;
            }

            public Object getProvinceId() {
                return provinceId;
            }

            public void setProvinceId(Object provinceId) {
                this.provinceId = provinceId;
            }

            public String getProvinceName() {
                return provinceName;
            }

            public void setProvinceName(String provinceName) {
                this.provinceName = provinceName;
            }

            public Object getCityId() {
                return cityId;
            }

            public void setCityId(Object cityId) {
                this.cityId = cityId;
            }

            public String getCityName() {
                return cityName;
            }

            public void setCityName(String cityName) {
                this.cityName = cityName;
            }

            public String getDistrictId() {
                return districtId;
            }

            public void setDistrictId(String districtId) {
                this.districtId = districtId;
            }

            public String getDistrictName() {
                return districtName;
            }

            public void setDistrictName(String districtName) {
                this.districtName = districtName;
            }

            public String getDetailAddress() {
                return detailAddress;
            }

            public void setDetailAddress(String detailAddress) {
                this.detailAddress = detailAddress;
            }

            public String getReceiverZipCode() {
                return receiverZipCode;
            }

            public void setReceiverZipCode(String receiverZipCode) {
                this.receiverZipCode = receiverZipCode;
            }

            public int getDefaultAddress() {
                return defaultAddress;
            }

            public void setDefaultAddress(int defaultAddress) {
                this.defaultAddress = defaultAddress;
            }
        }
    }
}
