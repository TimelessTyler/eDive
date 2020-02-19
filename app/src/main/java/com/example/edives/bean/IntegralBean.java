package com.example.edives.bean;

import java.util.List;

public class IntegralBean {

    /**
     * code : 200
     * message : 操作成功
     * data : {"total":4,"list":[{"id":4,"name":"手机防水袋潜水触屏通用","picture":"http://47.107.50.253:8080/webapps/uploadFile/image/1576137062069_24251896.jpg,http://47.107.50.253:8080/webapps/uploadFile/image/1576137062120_59256438.jpg,http://47.107.50.253:8080/webapps/uploadFile/image/1576137062162_62898651.jpg","integral":3000,"introduce":"http://47.107.50.253:8080/webapps/uploadFile/dmd/1576137266170_85440357.jpg","createtime":"2019-12-12 15:54:34","updatetime":"2019-12-12 15:54:57","status":0},{"id":3,"name":"男女潜水面镜近视眼镜呼吸管器套装","picture":"http://47.107.50.253:8080/webapps/uploadFile/image/1576136171235_23462231.jpg,http://47.107.50.253:8080/webapps/uploadFile/image/1576136171278_17874644.jpg,http://47.107.50.253:8080/webapps/uploadFile/image/1576136171342_66757656.jpg","integral":10000,"introduce":"http://47.107.50.253:8080/webapps/uploadFile/dmd/1576136529015_06542581.jpg","createtime":"2019-12-12 15:19:20","updatetime":"2019-12-12 15:45:22","status":0},{"id":2,"name":"台湾威带夫vdive碳纤维长脚蹼","picture":"https://gd3.alicdn.com/imgextra/i3/2150512261/O1CN018881JB1SZa0YX1Din_!!2150512261.jpg,https://gd4.alicdn.com/imgextra/i4/2150512261/O1CN01vc7jTl1SZa1pdPOXv_!!2150512261.jpg","integral":16000,"introduce":"https://img.alicdn.com/imgextra/i4/2150512261/O1CN01dpQCVr1SZa0gFZUej_!!2150512261.jpg","createtime":"2019-12-06 20:15:21","updatetime":null,"status":0},{"id":1,"name":"赛事级Oceaner 1.5mm 自由潜水湿衣","picture":"https://gd4.alicdn.com/imgextra/i3/677205254/O1CN01wYO1OW1ogNVM8ocAi_!!677205254.jpg,https://gd1.alicdn.com/imgextra/i1/677205254/O1CN01Rfy7Yd1ogNVIzs2c3_!!677205254.jpg","integral":15000,"introduce":"https://img.alicdn.com/imgextra/i4/677205254/O1CN01SqblCV1ogNSCeOaT4_!!677205254.jpg","createtime":"2019-12-06 20:13:03","updatetime":null,"status":0}],"pageNum":1,"pageSize":5,"size":4,"startRow":1,"endRow":4,"pages":1,"prePage":0,"nextPage":0,"isFirstPage":true,"isLastPage":true,"hasPreviousPage":false,"hasNextPage":false,"navigatePages":8,"navigatepageNums":[1],"navigateFirstPage":1,"navigateLastPage":1,"firstPage":1,"lastPage":1}
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
         * total : 4
         * list : [{"id":4,"name":"手机防水袋潜水触屏通用","picture":"http://47.107.50.253:8080/webapps/uploadFile/image/1576137062069_24251896.jpg,http://47.107.50.253:8080/webapps/uploadFile/image/1576137062120_59256438.jpg,http://47.107.50.253:8080/webapps/uploadFile/image/1576137062162_62898651.jpg","integral":3000,"introduce":"http://47.107.50.253:8080/webapps/uploadFile/dmd/1576137266170_85440357.jpg","createtime":"2019-12-12 15:54:34","updatetime":"2019-12-12 15:54:57","status":0},{"id":3,"name":"男女潜水面镜近视眼镜呼吸管器套装","picture":"http://47.107.50.253:8080/webapps/uploadFile/image/1576136171235_23462231.jpg,http://47.107.50.253:8080/webapps/uploadFile/image/1576136171278_17874644.jpg,http://47.107.50.253:8080/webapps/uploadFile/image/1576136171342_66757656.jpg","integral":10000,"introduce":"http://47.107.50.253:8080/webapps/uploadFile/dmd/1576136529015_06542581.jpg","createtime":"2019-12-12 15:19:20","updatetime":"2019-12-12 15:45:22","status":0},{"id":2,"name":"台湾威带夫vdive碳纤维长脚蹼","picture":"https://gd3.alicdn.com/imgextra/i3/2150512261/O1CN018881JB1SZa0YX1Din_!!2150512261.jpg,https://gd4.alicdn.com/imgextra/i4/2150512261/O1CN01vc7jTl1SZa1pdPOXv_!!2150512261.jpg","integral":16000,"introduce":"https://img.alicdn.com/imgextra/i4/2150512261/O1CN01dpQCVr1SZa0gFZUej_!!2150512261.jpg","createtime":"2019-12-06 20:15:21","updatetime":null,"status":0},{"id":1,"name":"赛事级Oceaner 1.5mm 自由潜水湿衣","picture":"https://gd4.alicdn.com/imgextra/i3/677205254/O1CN01wYO1OW1ogNVM8ocAi_!!677205254.jpg,https://gd1.alicdn.com/imgextra/i1/677205254/O1CN01Rfy7Yd1ogNVIzs2c3_!!677205254.jpg","integral":15000,"introduce":"https://img.alicdn.com/imgextra/i4/677205254/O1CN01SqblCV1ogNSCeOaT4_!!677205254.jpg","createtime":"2019-12-06 20:13:03","updatetime":null,"status":0}]
         * pageNum : 1
         * pageSize : 5
         * size : 4
         * startRow : 1
         * endRow : 4
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
             * id : 4
             * name : 手机防水袋潜水触屏通用
             * picture : http://47.107.50.253:8080/webapps/uploadFile/image/1576137062069_24251896.jpg,http://47.107.50.253:8080/webapps/uploadFile/image/1576137062120_59256438.jpg,http://47.107.50.253:8080/webapps/uploadFile/image/1576137062162_62898651.jpg
             * integral : 3000
             * introduce : http://47.107.50.253:8080/webapps/uploadFile/dmd/1576137266170_85440357.jpg
             * createtime : 2019-12-12 15:54:34
             * updatetime : 2019-12-12 15:54:57
             * status : 0
             */

            private int id;
            private String name;
            private String picture;
            private int integral;
            private String introduce;
            private String createtime;
            private String updatetime;
            private int status;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getPicture() {
                return picture;
            }

            public void setPicture(String picture) {
                this.picture = picture;
            }

            public int getIntegral() {
                return integral;
            }

            public void setIntegral(int integral) {
                this.integral = integral;
            }

            public String getIntroduce() {
                return introduce;
            }

            public void setIntroduce(String introduce) {
                this.introduce = introduce;
            }

            public String getCreatetime() {
                return createtime;
            }

            public void setCreatetime(String createtime) {
                this.createtime = createtime;
            }

            public String getUpdatetime() {
                return updatetime;
            }

            public void setUpdatetime(String updatetime) {
                this.updatetime = updatetime;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }
        }
    }
}
