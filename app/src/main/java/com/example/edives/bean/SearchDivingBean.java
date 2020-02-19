package com.example.edives.bean;

import java.util.List;

public class SearchDivingBean {
    /**
     * code : 200
     * message : 操作成功
     * data : {"total":1,"list":[{"id":1,"creator":null,"creatorId":null,"createdTime":null,"lastOperator":null,"lastOperatorId":null,"updateTime":null,"pageNum":null,"pageSize":null,"orderBy":null,"productName":null,"userId":1,"shopId":null,"shopName":null,"title":"一起愉快的潜水","price":2159,"productType":2,"location":"马来西亚","lengthPlay":null,"isTimeLimit":null,"startTime":null,"endTime":null,"numberIsLimit":null,"numberLimit":null,"stock":null,"costIncludes":null,"costNotIncludes":null,"purchaseNotes":null,"productDescription":null,"image":"","contentArrangement":null,"status":null,"approvalStatus":null,"sales":null,"sort":null,"certificateId":null,"addressId":null,"searchStartTime":null,"searchEndTime":null,"coachIcon":"http://img1.imgtn.bdimg.com/it/u=1411728850,1869975885&fm=26&gp=0.jpg","coachName":"杨安生","coachGrade":"9999"}],"pageNum":1,"pageSize":5,"size":1,"startRow":1,"endRow":1,"pages":1,"prePage":0,"nextPage":0,"isFirstPage":true,"isLastPage":true,"hasPreviousPage":false,"hasNextPage":false,"navigatePages":8,"navigatepageNums":[1],"navigateFirstPage":1,"navigateLastPage":1,"firstPage":1,"lastPage":1}
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
         * list : [{"id":1,"creator":null,"creatorId":null,"createdTime":null,"lastOperator":null,"lastOperatorId":null,"updateTime":null,"pageNum":null,"pageSize":null,"orderBy":null,"productName":null,"userId":1,"shopId":null,"shopName":null,"title":"一起愉快的潜水","price":2159,"productType":2,"location":"马来西亚","lengthPlay":null,"isTimeLimit":null,"startTime":null,"endTime":null,"numberIsLimit":null,"numberLimit":null,"stock":null,"costIncludes":null,"costNotIncludes":null,"purchaseNotes":null,"productDescription":null,"image":"","contentArrangement":null,"status":null,"approvalStatus":null,"sales":null,"sort":null,"certificateId":null,"addressId":null,"searchStartTime":null,"searchEndTime":null,"coachIcon":"http://img1.imgtn.bdimg.com/it/u=1411728850,1869975885&fm=26&gp=0.jpg","coachName":"杨安生","coachGrade":"9999"}]
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
             * id : 1
             * creator : null
             * creatorId : null
             * createdTime : null
             * lastOperator : null
             * lastOperatorId : null
             * updateTime : null
             * pageNum : null
             * pageSize : null
             * orderBy : null
             * productName : null
             * userId : 1
             * shopId : null
             * shopName : null
             * title : 一起愉快的潜水
             * price : 2159.0
             * productType : 2
             * location : 马来西亚
             * lengthPlay : null
             * isTimeLimit : null
             * startTime : null
             * endTime : null
             * numberIsLimit : null
             * numberLimit : null
             * stock : null
             * costIncludes : null
             * costNotIncludes : null
             * purchaseNotes : null
             * productDescription : null
             * image :
             * contentArrangement : null
             * status : null
             * approvalStatus : null
             * sales : null
             * sort : null
             * certificateId : null
             * addressId : null
             * searchStartTime : null
             * searchEndTime : null
             * coachIcon : http://img1.imgtn.bdimg.com/it/u=1411728850,1869975885&fm=26&gp=0.jpg
             * coachName : 杨安生
             * coachGrade : 9999
             */

            private int id;
            private Object creator;
            private Object creatorId;
            private Object createdTime;
            private Object lastOperator;
            private Object lastOperatorId;
            private Object updateTime;
            private Object pageNum;
            private Object pageSize;
            private Object orderBy;
            private Object productName;
            private int userId;
            private Object shopId;
            private Object shopName;
            private String title;
            private double price;
            private int productType;
            private String location;
            private Object lengthPlay;
            private Object isTimeLimit;
            private Object startTime;
            private Object endTime;
            private Object numberIsLimit;
            private Object numberLimit;
            private Object stock;
            private Object costIncludes;
            private Object costNotIncludes;
            private Object purchaseNotes;
            private Object productDescription;
            private String image;
            private Object contentArrangement;
            private Object status;
            private Object approvalStatus;
            private Object sales;
            private Object sort;
            private Object certificateId;
            private Object addressId;
            private Object searchStartTime;
            private Object searchEndTime;
            private String coachIcon;
            private String coachName;
            private String coachGrade;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public Object getCreator() {
                return creator;
            }

            public void setCreator(Object creator) {
                this.creator = creator;
            }

            public Object getCreatorId() {
                return creatorId;
            }

            public void setCreatorId(Object creatorId) {
                this.creatorId = creatorId;
            }

            public Object getCreatedTime() {
                return createdTime;
            }

            public void setCreatedTime(Object createdTime) {
                this.createdTime = createdTime;
            }

            public Object getLastOperator() {
                return lastOperator;
            }

            public void setLastOperator(Object lastOperator) {
                this.lastOperator = lastOperator;
            }

            public Object getLastOperatorId() {
                return lastOperatorId;
            }

            public void setLastOperatorId(Object lastOperatorId) {
                this.lastOperatorId = lastOperatorId;
            }

            public Object getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(Object updateTime) {
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

            public Object getProductName() {
                return productName;
            }

            public void setProductName(Object productName) {
                this.productName = productName;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public Object getShopId() {
                return shopId;
            }

            public void setShopId(Object shopId) {
                this.shopId = shopId;
            }

            public Object getShopName() {
                return shopName;
            }

            public void setShopName(Object shopName) {
                this.shopName = shopName;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public double getPrice() {
                return price;
            }

            public void setPrice(double price) {
                this.price = price;
            }

            public int getProductType() {
                return productType;
            }

            public void setProductType(int productType) {
                this.productType = productType;
            }

            public String getLocation() {
                return location;
            }

            public void setLocation(String location) {
                this.location = location;
            }

            public Object getLengthPlay() {
                return lengthPlay;
            }

            public void setLengthPlay(Object lengthPlay) {
                this.lengthPlay = lengthPlay;
            }

            public Object getIsTimeLimit() {
                return isTimeLimit;
            }

            public void setIsTimeLimit(Object isTimeLimit) {
                this.isTimeLimit = isTimeLimit;
            }

            public Object getStartTime() {
                return startTime;
            }

            public void setStartTime(Object startTime) {
                this.startTime = startTime;
            }

            public Object getEndTime() {
                return endTime;
            }

            public void setEndTime(Object endTime) {
                this.endTime = endTime;
            }

            public Object getNumberIsLimit() {
                return numberIsLimit;
            }

            public void setNumberIsLimit(Object numberIsLimit) {
                this.numberIsLimit = numberIsLimit;
            }

            public Object getNumberLimit() {
                return numberLimit;
            }

            public void setNumberLimit(Object numberLimit) {
                this.numberLimit = numberLimit;
            }

            public Object getStock() {
                return stock;
            }

            public void setStock(Object stock) {
                this.stock = stock;
            }

            public Object getCostIncludes() {
                return costIncludes;
            }

            public void setCostIncludes(Object costIncludes) {
                this.costIncludes = costIncludes;
            }

            public Object getCostNotIncludes() {
                return costNotIncludes;
            }

            public void setCostNotIncludes(Object costNotIncludes) {
                this.costNotIncludes = costNotIncludes;
            }

            public Object getPurchaseNotes() {
                return purchaseNotes;
            }

            public void setPurchaseNotes(Object purchaseNotes) {
                this.purchaseNotes = purchaseNotes;
            }

            public Object getProductDescription() {
                return productDescription;
            }

            public void setProductDescription(Object productDescription) {
                this.productDescription = productDescription;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public Object getContentArrangement() {
                return contentArrangement;
            }

            public void setContentArrangement(Object contentArrangement) {
                this.contentArrangement = contentArrangement;
            }

            public Object getStatus() {
                return status;
            }

            public void setStatus(Object status) {
                this.status = status;
            }

            public Object getApprovalStatus() {
                return approvalStatus;
            }

            public void setApprovalStatus(Object approvalStatus) {
                this.approvalStatus = approvalStatus;
            }

            public Object getSales() {
                return sales;
            }

            public void setSales(Object sales) {
                this.sales = sales;
            }

            public Object getSort() {
                return sort;
            }

            public void setSort(Object sort) {
                this.sort = sort;
            }

            public Object getCertificateId() {
                return certificateId;
            }

            public void setCertificateId(Object certificateId) {
                this.certificateId = certificateId;
            }

            public Object getAddressId() {
                return addressId;
            }

            public void setAddressId(Object addressId) {
                this.addressId = addressId;
            }

            public Object getSearchStartTime() {
                return searchStartTime;
            }

            public void setSearchStartTime(Object searchStartTime) {
                this.searchStartTime = searchStartTime;
            }

            public Object getSearchEndTime() {
                return searchEndTime;
            }

            public void setSearchEndTime(Object searchEndTime) {
                this.searchEndTime = searchEndTime;
            }

            public String getCoachIcon() {
                return coachIcon;
            }

            public void setCoachIcon(String coachIcon) {
                this.coachIcon = coachIcon;
            }

            public String getCoachName() {
                return coachName;
            }

            public void setCoachName(String coachName) {
                this.coachName = coachName;
            }

            public String getCoachGrade() {
                return coachGrade;
            }

            public void setCoachGrade(String coachGrade) {
                this.coachGrade = coachGrade;
            }
        }
    }
}
