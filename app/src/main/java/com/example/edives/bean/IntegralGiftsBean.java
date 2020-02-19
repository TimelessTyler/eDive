package com.example.edives.bean;

import java.util.List;

public class IntegralGiftsBean {
    /**
     * code : 200
     * message : 操作成功
     * data : [{"id":null,"giftId":1,"specStock":123,"size":"x","color":"蓝"},{"id":null,"giftId":1,"specStock":123,"size":"s","color":"蓝"},{"id":null,"giftId":1,"specStock":15,"size":"s","color":"红"}]
     */

    private int code;
    private String message;
    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : null
         * giftId : 1
         * specStock : 123
         * size : x
         * color : 蓝
         */

        private int id;
        private int giftId;
        private int specStock;
        private String size;
        private String color;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getGiftId() {
            return giftId;
        }

        public void setGiftId(int giftId) {
            this.giftId = giftId;
        }

        public int getSpecStock() {
            return specStock;
        }

        public void setSpecStock(int specStock) {
            this.specStock = specStock;
        }

        public String getSize() {
            return size;
        }

        public void setSize(String size) {
            this.size = size;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }
    }
}
