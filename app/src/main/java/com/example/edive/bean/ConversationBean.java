package com.example.edive.bean;

import java.util.List;

public class ConversationBean {

    /**
     * code : 200
     * message : 操作成功
     * data : {"total":12,"list":[{"id":2,"topicName":"马尔代夫海峡","topicDescribes":null,"topicNum":null,"createTime":null,"topicPicture":"http://pic23.photophoto.cn/20120614/0008020246371439_b.jpg"},{"id":1,"topicName":"克罗群岛","topicDescribes":null,"topicNum":null,"createTime":null,"topicPicture":"\u202aC:\\fileUpload\\picture20191016113455_1564384598(1).jpg"},{"id":4,"topicName":"天天向上","topicDescribes":null,"topicNum":null,"createTime":null,"topicPicture":"http://pic23.photophoto.cn/20120614/0008020246371439_b.jpg"},{"id":10,"topicName":"天","topicDescribes":null,"topicNum":null,"createTime":null,"topicPicture":"http://pic23.photophoto.cn/20120614/0008020246371439_b.jpg"},{"id":12,"topicName":"1","topicDescribes":null,"topicNum":null,"createTime":null,"topicPicture":"http://127.0.0.1/dmd/1571990037211_51093452.jpg"}],"pageNum":1,"pageSize":5,"size":5,"startRow":1,"endRow":5,"pages":3,"prePage":0,"nextPage":2,"isFirstPage":true,"isLastPage":false,"hasPreviousPage":false,"hasNextPage":true,"navigatePages":8,"navigatepageNums":[1,2,3],"navigateFirstPage":1,"navigateLastPage":3,"firstPage":1,"lastPage":3}
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
         * total : 12
         * list : [{"id":2,"topicName":"马尔代夫海峡","topicDescribes":null,"topicNum":null,"createTime":null,"topicPicture":"http://pic23.photophoto.cn/20120614/0008020246371439_b.jpg"},{"id":1,"topicName":"克罗群岛","topicDescribes":null,"topicNum":null,"createTime":null,"topicPicture":"\u202aC:\\fileUpload\\picture20191016113455_1564384598(1).jpg"},{"id":4,"topicName":"天天向上","topicDescribes":null,"topicNum":null,"createTime":null,"topicPicture":"http://pic23.photophoto.cn/20120614/0008020246371439_b.jpg"},{"id":10,"topicName":"天","topicDescribes":null,"topicNum":null,"createTime":null,"topicPicture":"http://pic23.photophoto.cn/20120614/0008020246371439_b.jpg"},{"id":12,"topicName":"1","topicDescribes":null,"topicNum":null,"createTime":null,"topicPicture":"http://127.0.0.1/dmd/1571990037211_51093452.jpg"}]
         * pageNum : 1
         * pageSize : 5
         * size : 5
         * startRow : 1
         * endRow : 5
         * pages : 3
         * prePage : 0
         * nextPage : 2
         * isFirstPage : true
         * isLastPage : false
         * hasPreviousPage : false
         * hasNextPage : true
         * navigatePages : 8
         * navigatepageNums : [1,2,3]
         * navigateFirstPage : 1
         * navigateLastPage : 3
         * firstPage : 1
         * lastPage : 3
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
             * topicName : 马尔代夫海峡
             * topicDescribes : null
             * topicNum : null
             * createTime : null
             * topicPicture : http://pic23.photophoto.cn/20120614/0008020246371439_b.jpg
             */

            private int id;
            private String topicName;
            private Object topicDescribes;
            private int topicNum;
            private Object createTime;
            private String topicPicture;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getTopicName() {
                return topicName;
            }

            public void setTopicName(String topicName) {
                this.topicName = topicName;
            }

            public Object getTopicDescribes() {
                return topicDescribes;
            }

            public void setTopicDescribes(Object topicDescribes) {
                this.topicDescribes = topicDescribes;
            }

            public int getTopicNum() {
                return topicNum;
            }

            public void setTopicNum(int topicNum) {
                this.topicNum = topicNum;
            }

            public Object getCreateTime() {
                return createTime;
            }

            public void setCreateTime(Object createTime) {
                this.createTime = createTime;
            }

            public String getTopicPicture() {
                return topicPicture;
            }

            public void setTopicPicture(String topicPicture) {
                this.topicPicture = topicPicture;
            }
        }
    }
}
