package com.example.edives.bean;

public class MoAddress {
    /**
     * code : 200
     * message : 操作成功
     * result : {"id":17,"creator":"15609563855","creatorId":23,"createdTime":"2019-12-03 10:31:57","lastOperator":"15609563855","lastOperatorId":23,"updateTime":"2019-12-03 10:31:57","pageNum":null,"pageSize":null,"orderBy":null,"userId":23,"userType":"member","receiverName":"黎门","receiverPhoneNo":"","receiverMobileNo":"15609563858","provinceId":null,"provinceName":"省直辖县级行政单位","cityId":null,"cityName":"北京市","districtId":"","districtName":"海淀区","detailAddress":"金澳国际写字楼","receiverZipCode":"","defaultAddress":1}
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
         * id : 17
         * creator : 15609563855
         * creatorId : 23
         * createdTime : 2019-12-03 10:31:57
         * lastOperator : 15609563855
         * lastOperatorId : 23
         * updateTime : 2019-12-03 10:31:57
         * pageNum : null
         * pageSize : null
         * orderBy : null
         * userId : 23
         * userType : member
         * receiverName : 黎门
         * receiverPhoneNo :
         * receiverMobileNo : 15609563858
         * provinceId : null
         * provinceName : 省直辖县级行政单位
         * cityId : null
         * cityName : 北京市
         * districtId :
         * districtName : 海淀区
         * detailAddress : 金澳国际写字楼
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
