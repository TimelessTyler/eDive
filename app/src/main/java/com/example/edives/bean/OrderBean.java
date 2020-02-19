package com.example.edives.bean;

import java.util.List;

public class OrderBean {


    /**
     * code : 200
     * message : 操作成功
     * result : {"total":3,"list":[{"orderId":41,"orderItemId":null,"orderSn":"201911210100000008","userName":"17731271980","userIcon":"http://img1.imgtn.bdimg.com/it/u=1411728850,1869975885&fm=26&gp=0.jpg","userId":1,"coachGrade":"9999","phone":null,"totalAmount":666,"payAmount":666,"integrationAmount":0,"payType":0,"paymentTime":null,"status":5,"productId":1,"productPic":"http://pic23.photophoto.cn/20120614/0008020246371439_b.jpg","productTitle":"一起愉快的潜水,来玩啊","productPrice":666,"productType":2,"createdTime":"2019-11-21 14:23:07","endTime":"2019-11-22 16:48:58","closeTime":null,"spec":"[{\"value\":\"2019-11-21 15:40:03\",\"key\":\"开始时间\"},{\"value\":\"2019-11-21 15:40:03\",\"key\":\"结束时间\"},{\"value\":8,\"key\":\"最大人数限制\"}]","productQuantity":1,"orderType":1,"realAmount":null,"returnStatus":1},{"orderId":43,"orderItemId":null,"orderSn":"201911210100000010","userName":"17731271980","userIcon":"http://img1.imgtn.bdimg.com/it/u=1411728850,1869975885&fm=26&gp=0.jpg","userId":1,"coachGrade":"9999","phone":null,"totalAmount":666,"payAmount":666,"integrationAmount":0,"payType":0,"paymentTime":null,"status":5,"productId":1,"productPic":"http://pic23.photophoto.cn/20120614/0008020246371439_b.jpg","productTitle":"一起愉快的潜水,来玩啊","productPrice":666,"productType":2,"createdTime":"2019-11-21 14:36:21","endTime":"2019-11-22 15:50:34","closeTime":null,"spec":"[{\"value\":\"2019-11-21 15:40:03\",\"key\":\"开始时间\"},{\"value\":\"2019-11-21 15:40:03\",\"key\":\"结束时间\"},{\"value\":8,\"key\":\"最大人数限制\"}]","productQuantity":1,"orderType":1,"realAmount":null,"returnStatus":1},{"orderId":42,"orderItemId":null,"orderSn":"201911210100000009","userName":"17731271980","userIcon":"http://img1.imgtn.bdimg.com/it/u=1411728850,1869975885&fm=26&gp=0.jpg","userId":1,"coachGrade":"9999","phone":null,"totalAmount":666,"payAmount":666,"integrationAmount":0,"payType":0,"paymentTime":null,"status":5,"productId":1,"productPic":"http://pic23.photophoto.cn/20120614/0008020246371439_b.jpg","productTitle":"一起愉快的潜水,来玩啊","productPrice":666,"productType":2,"createdTime":"2019-11-21 14:23:49","endTime":"2019-11-22 16:42:09","closeTime":null,"spec":"[{\"value\":\"2019-11-21 15:40:03\",\"key\":\"开始时间\"},{\"value\":\"2019-11-21 15:40:03\",\"key\":\"结束时间\"},{\"value\":8,\"key\":\"最大人数限制\"}]","productQuantity":1,"orderType":1,"realAmount":null,"returnStatus":2}],"pageNum":1,"pageSize":10,"size":3,"startRow":1,"endRow":3,"pages":1,"prePage":0,"nextPage":0,"isFirstPage":true,"isLastPage":true,"hasPreviousPage":false,"hasNextPage":false,"navigatePages":8,"navigatepageNums":[1],"navigateFirstPage":1,"navigateLastPage":1,"lastPage":1,"firstPage":1}
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
         * total : 3
         * list : [{"orderId":41,"orderItemId":null,"orderSn":"201911210100000008","userName":"17731271980","userIcon":"http://img1.imgtn.bdimg.com/it/u=1411728850,1869975885&fm=26&gp=0.jpg","userId":1,"coachGrade":"9999","phone":null,"totalAmount":666,"payAmount":666,"integrationAmount":0,"payType":0,"paymentTime":null,"status":5,"productId":1,"productPic":"http://pic23.photophoto.cn/20120614/0008020246371439_b.jpg","productTitle":"一起愉快的潜水,来玩啊","productPrice":666,"productType":2,"createdTime":"2019-11-21 14:23:07","endTime":"2019-11-22 16:48:58","closeTime":null,"spec":"[{\"value\":\"2019-11-21 15:40:03\",\"key\":\"开始时间\"},{\"value\":\"2019-11-21 15:40:03\",\"key\":\"结束时间\"},{\"value\":8,\"key\":\"最大人数限制\"}]","productQuantity":1,"orderType":1,"realAmount":null,"returnStatus":1},{"orderId":43,"orderItemId":null,"orderSn":"201911210100000010","userName":"17731271980","userIcon":"http://img1.imgtn.bdimg.com/it/u=1411728850,1869975885&fm=26&gp=0.jpg","userId":1,"coachGrade":"9999","phone":null,"totalAmount":666,"payAmount":666,"integrationAmount":0,"payType":0,"paymentTime":null,"status":5,"productId":1,"productPic":"http://pic23.photophoto.cn/20120614/0008020246371439_b.jpg","productTitle":"一起愉快的潜水,来玩啊","productPrice":666,"productType":2,"createdTime":"2019-11-21 14:36:21","endTime":"2019-11-22 15:50:34","closeTime":null,"spec":"[{\"value\":\"2019-11-21 15:40:03\",\"key\":\"开始时间\"},{\"value\":\"2019-11-21 15:40:03\",\"key\":\"结束时间\"},{\"value\":8,\"key\":\"最大人数限制\"}]","productQuantity":1,"orderType":1,"realAmount":null,"returnStatus":1},{"orderId":42,"orderItemId":null,"orderSn":"201911210100000009","userName":"17731271980","userIcon":"http://img1.imgtn.bdimg.com/it/u=1411728850,1869975885&fm=26&gp=0.jpg","userId":1,"coachGrade":"9999","phone":null,"totalAmount":666,"payAmount":666,"integrationAmount":0,"payType":0,"paymentTime":null,"status":5,"productId":1,"productPic":"http://pic23.photophoto.cn/20120614/0008020246371439_b.jpg","productTitle":"一起愉快的潜水,来玩啊","productPrice":666,"productType":2,"createdTime":"2019-11-21 14:23:49","endTime":"2019-11-22 16:42:09","closeTime":null,"spec":"[{\"value\":\"2019-11-21 15:40:03\",\"key\":\"开始时间\"},{\"value\":\"2019-11-21 15:40:03\",\"key\":\"结束时间\"},{\"value\":8,\"key\":\"最大人数限制\"}]","productQuantity":1,"orderType":1,"realAmount":null,"returnStatus":2}]
         * pageNum : 1
         * pageSize : 10
         * size : 3
         * startRow : 1
         * endRow : 3
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
         * lastPage : 1
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
             * orderId : 41
             * orderItemId : null
             * orderSn : 201911210100000008
             * userName : 17731271980
             * userIcon : http://img1.imgtn.bdimg.com/it/u=1411728850,1869975885&fm=26&gp=0.jpg
             * userId : 1
             * coachGrade : 9999
             * phone : null
             * totalAmount : 666.0
             * payAmount : 666.0
             * integrationAmount : 0.0
             * payType : 0
             * paymentTime : null
             * status : 5
             * productId : 1
             * productPic : http://pic23.photophoto.cn/20120614/0008020246371439_b.jpg
             * productTitle : 一起愉快的潜水,来玩啊
             * productPrice : 666.0
             * productType : 2
             * createdTime : 2019-11-21 14:23:07
             * endTime : 2019-11-22 16:48:58
             * closeTime : null
             * spec : [{"value":"2019-11-21 15:40:03","key":"开始时间"},{"value":"2019-11-21 15:40:03","key":"结束时间"},{"value":8,"key":"最大人数限制"}]
             * productQuantity : 1
             * orderType : 1
             * realAmount : null
             * returnStatus : 1
             */

            private int orderId;
            private Object orderItemId;
            private String orderSn;
            private String userName;
            private String userIcon;
            private int userId;
            private String coachGrade;
            private Object phone;
            private double totalAmount;
            private double payAmount;
            private double integrationAmount;
            private int payType;
            private Object paymentTime;
            private int status;
            private int productId;
            private String productPic;
            private String productTitle;
            private double productPrice;
            private int productType;
            private String createdTime;
            private String endTime;
            private Object closeTime;
            private String spec;
            private int productQuantity;
            private int orderType;
            private Object realAmount;
            private int returnStatus;
            private String nickName;

            public int getOrderId() {
                return orderId;
            }

            public void setOrderId(int orderId) {
                this.orderId = orderId;
            }

            public Object getOrderItemId() {
                return orderItemId;
            }

            public String getNickname() {
                return nickName;
            }

            public void setNickname(String nickName) {
                this.nickName = nickName;
            }

            public void setOrderItemId(Object orderItemId) {
                this.orderItemId = orderItemId;
            }

            public String getOrderSn() {
                return orderSn;
            }

            public void setOrderSn(String orderSn) {
                this.orderSn = orderSn;
            }

            public String getUserName() {
                return userName;
            }

            public void setUserName(String userName) {
                this.userName = userName;
            }

            public String getUserIcon() {
                return userIcon;
            }

            public void setUserIcon(String userIcon) {
                this.userIcon = userIcon;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public String getCoachGrade() {
                return coachGrade;
            }

            public void setCoachGrade(String coachGrade) {
                this.coachGrade = coachGrade;
            }

            public Object getPhone() {
                return phone;
            }

            public void setPhone(Object phone) {
                this.phone = phone;
            }

            public double getTotalAmount() {
                return totalAmount;
            }

            public void setTotalAmount(double totalAmount) {
                this.totalAmount = totalAmount;
            }

            public double getPayAmount() {
                return payAmount;
            }

            public void setPayAmount(double payAmount) {
                this.payAmount = payAmount;
            }

            public double getIntegrationAmount() {
                return integrationAmount;
            }

            public void setIntegrationAmount(double integrationAmount) {
                this.integrationAmount = integrationAmount;
            }

            public int getPayType() {
                return payType;
            }

            public void setPayType(int payType) {
                this.payType = payType;
            }

            public Object getPaymentTime() {
                return paymentTime;
            }

            public void setPaymentTime(Object paymentTime) {
                this.paymentTime = paymentTime;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public int getProductId() {
                return productId;
            }

            public void setProductId(int productId) {
                this.productId = productId;
            }

            public String getProductPic() {
                return productPic;
            }

            public void setProductPic(String productPic) {
                this.productPic = productPic;
            }

            public String getProductTitle() {
                return productTitle;
            }

            public void setProductTitle(String productTitle) {
                this.productTitle = productTitle;
            }

            public double getProductPrice() {
                return productPrice;
            }

            public void setProductPrice(double productPrice) {
                this.productPrice = productPrice;
            }

            public int getProductType() {
                return productType;
            }

            public void setProductType(int productType) {
                this.productType = productType;
            }

            public String getCreatedTime() {
                return createdTime;
            }

            public void setCreatedTime(String createdTime) {
                this.createdTime = createdTime;
            }

            public String getEndTime() {
                return endTime;
            }

            public void setEndTime(String endTime) {
                this.endTime = endTime;
            }

            public Object getCloseTime() {
                return closeTime;
            }

            public void setCloseTime(Object closeTime) {
                this.closeTime = closeTime;
            }

            public String getSpec() {
                return spec;
            }

            public void setSpec(String spec) {
                this.spec = spec;
            }

            public int getProductQuantity() {
                return productQuantity;
            }

            public void setProductQuantity(int productQuantity) {
                this.productQuantity = productQuantity;
            }

            public int getOrderType() {
                return orderType;
            }

            public void setOrderType(int orderType) {
                this.orderType = orderType;
            }

            public Object getRealAmount() {
                return realAmount;
            }

            public void setRealAmount(Object realAmount) {
                this.realAmount = realAmount;
            }

            public int getReturnStatus() {
                return returnStatus;
            }

            public void setReturnStatus(int returnStatus) {
                this.returnStatus = returnStatus;
            }
        }
    }
}
