package com.example.edives.bean;

import java.util.List;

public class ApplyDeatilsBean {


    /**
     * code : 200
     * message : 操作成功
     * result : {"returnApplyId":59,"orderSn":"1202782774167719936","reason":"质量问题","description":"好想回家","proofPics":"http://192.168.0.246/image/1576826114853_92643051.jpg,http://192.168.0.246/image/1576826115834_53247767.jpg,http://192.168.0.246/image/1576826115924_92089818.jpg","picList":["http://192.168.0.246/image/1576826114853_92643051.jpg","http://192.168.0.246/image/1576826115834_53247767.jpg","http://192.168.0.246/image/1576826115924_92089818.jpg"],"status":0,"createdTime":"2020-01-10 15:15:16","returnAmount":4710,"failureReason":null}
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
         * returnApplyId : 59
         * orderSn : 1202782774167719936
         * reason : 质量问题
         * description : 好想回家
         * proofPics : http://192.168.0.246/image/1576826114853_92643051.jpg,http://192.168.0.246/image/1576826115834_53247767.jpg,http://192.168.0.246/image/1576826115924_92089818.jpg
         * picList : ["http://192.168.0.246/image/1576826114853_92643051.jpg","http://192.168.0.246/image/1576826115834_53247767.jpg","http://192.168.0.246/image/1576826115924_92089818.jpg"]
         * status : 0
         * createdTime : 2020-01-10 15:15:16
         * returnAmount : 4710.0
         * failureReason : null
         */

        private int returnApplyId;
        private String orderSn;
        private String reason;
        private String description;
        private String proofPics;
        private int status;
        private String createdTime;
        private double returnAmount;
        private String failureReason;
        private List<String> picList;

        public int getReturnApplyId() {
            return returnApplyId;
        }

        public void setReturnApplyId(int returnApplyId) {
            this.returnApplyId = returnApplyId;
        }

        public String getOrderSn() {
            return orderSn;
        }

        public void setOrderSn(String orderSn) {
            this.orderSn = orderSn;
        }

        public String getReason() {
            return reason;
        }

        public void setReason(String reason) {
            this.reason = reason;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getProofPics() {
            return proofPics;
        }

        public void setProofPics(String proofPics) {
            this.proofPics = proofPics;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getCreatedTime() {
            return createdTime;
        }

        public void setCreatedTime(String createdTime) {
            this.createdTime = createdTime;
        }

        public double getReturnAmount() {
            return returnAmount;
        }

        public void setReturnAmount(double returnAmount) {
            this.returnAmount = returnAmount;
        }

        public String getFailureReason() {
            return failureReason;
        }

        public void setFailureReason(String failureReason) {
            this.failureReason = failureReason;
        }

        public List<String> getPicList() {
            return picList;
        }

        public void setPicList(List<String> picList) {
            this.picList = picList;
        }
    }
}
