package com.example.edives.bean;

public class OrderDetailsBean {

    /**
     * code : 200
     * message : 操作成功
     * result : {"orderId":27,"orderItemId":null,"orderSn":"201911140100000001","userName":"17731271980","userIcon":"http://img1.imgtn.bdimg.com/it/u=1411728850,1869975885&fm=26&gp=0.jpg","userId":1,"coachGrade":"9999","phone":null,"totalAmount":666,"payAmount":666,"integrationAmount":0,"payType":1,"paymentTime":"2019-11-19 15:14:21","status":5,"productId":1,"productPic":"http://pic23.photophoto.cn/20120614/0008020246371439_b.jpg","productTitle":null,"productPrice":666,"productType":2,"createdTime":"2019-11-14 10:24:27","endTime":"2019-11-22 15:15:31","closeTime":null,"spec":"[{\"value\":\"2019-11-21 15:40:03\",\"key\":\"开始时间\"},{\"value\":\"2019-11-21 15:40:03\",\"key\":\"结束时间\"},{\"value\":8,\"key\":\"最大人数限制\"}]","productQuantity":1,"orderType":0,"realAmount":null,"returnStatus":1}
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
         * orderId : 27
         * orderItemId : null
         * orderSn : 201911140100000001
         * userName : 17731271980
         * userIcon : http://img1.imgtn.bdimg.com/it/u=1411728850,1869975885&fm=26&gp=0.jpg
         * userId : 1
         * coachGrade : 9999
         * phone : null
         * totalAmount : 666.0
         * payAmount : 666.0
         * integrationAmount : 0.0
         * payType : 1
         * paymentTime : 2019-11-19 15:14:21
         * status : 5
         * productId : 1
         * productPic : http://pic23.photophoto.cn/20120614/0008020246371439_b.jpg
         * productTitle : null
         * productPrice : 666.0
         * productType : 2
         * createdTime : 2019-11-14 10:24:27
         * endTime : 2019-11-22 15:15:31
         * closeTime : null
         * spec : [{"value":"2019-11-21 15:40:03","key":"开始时间"},{"value":"2019-11-21 15:40:03","key":"结束时间"},{"value":8,"key":"最大人数限制"}]
         * productQuantity : 1
         * orderType : 0
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
        private String paymentTime;
        private int status;
        private int productId;
        private String productPic;
        private Object productTitle;
        private double productPrice;
        private int productType;
        private String createdTime;
        private String endTime;
        private Object closeTime;
        private String spec;
        private int productQuantity;
        private int orderType;
        private String returnApplyTime;
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

        public void setOrderItemId(Object orderItemId) {
            this.orderItemId = orderItemId;
        }

        public String getOrderSn() {
            return orderSn;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
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

        public String getPaymentTime() {
            return paymentTime;
        }

        public void setPaymentTime(String paymentTime) {
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

        public Object getProductTitle() {
            return productTitle;
        }

        public void setProductTitle(Object productTitle) {
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

        public String getReturnApplyTime() {
            return returnApplyTime;
        }

        public void setReturnApplyTime(String returnApplyTime) {
            this.returnApplyTime = returnApplyTime;
        }
    }
}
