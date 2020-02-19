package com.example.edives.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.List;

public class SearchTopicBean implements Serializable, Parcelable {
    /**
     * code : 200
     * message : 操作成功
     * data : {"total":1,"list":[{"id":1,"topicName":"克罗群岛","topicDescribes":null,"topicNum":4,"createTime":null,"topicPicture":"\u202aC:\\fileUpload\\picture20191016113455_1564384598(1).jpg"}],"pageNum":1,"pageSize":1,"size":1,"startRow":0,"endRow":0,"pages":1,"prePage":0,"nextPage":0,"isFirstPage":true,"isLastPage":true,"hasPreviousPage":false,"hasNextPage":false,"navigatePages":8,"navigatepageNums":[1],"navigateFirstPage":1,"navigateLastPage":1,"firstPage":1,"lastPage":1}
     */

    private int code;
    private String message;
    private DataBean data;

    protected SearchTopicBean(Parcel in) {
        code = in.readInt();
        message = in.readString();
    }

    public static final Creator<SearchTopicBean> CREATOR = new Creator<SearchTopicBean>() {
        @Override
        public SearchTopicBean createFromParcel(Parcel in) {
            return new SearchTopicBean(in);
        }

        @Override
        public SearchTopicBean[] newArray(int size) {
            return new SearchTopicBean[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(code);
        dest.writeString(message);
    }

    public static class DataBean implements Serializable,Parcelable{
        /**
         * total : 1
         * list : [{"id":1,"topicName":"克罗群岛","topicDescribes":null,"topicNum":4,"createTime":null,"topicPicture":"\u202aC:\\fileUpload\\picture20191016113455_1564384598(1).jpg"}]
         * pageNum : 1
         * pageSize : 1
         * size : 1
         * startRow : 0
         * endRow : 0
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

        protected DataBean(Parcel in) {
            total = in.readInt();
            pageNum = in.readInt();
            pageSize = in.readInt();
            size = in.readInt();
            startRow = in.readInt();
            endRow = in.readInt();
            pages = in.readInt();
            prePage = in.readInt();
            nextPage = in.readInt();
            isFirstPage = in.readByte() != 0;
            isLastPage = in.readByte() != 0;
            hasPreviousPage = in.readByte() != 0;
            hasNextPage = in.readByte() != 0;
            navigatePages = in.readInt();
            navigateFirstPage = in.readInt();
            navigateLastPage = in.readInt();
            firstPage = in.readInt();
            lastPage = in.readInt();
        }

        public static final Creator<DataBean> CREATOR = new Creator<DataBean>() {
            @Override
            public DataBean createFromParcel(Parcel in) {
                return new DataBean(in);
            }

            @Override
            public DataBean[] newArray(int size) {
                return new DataBean[size];
            }
        };

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

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(total);
            dest.writeInt(pageNum);
            dest.writeInt(pageSize);
            dest.writeInt(size);
            dest.writeInt(startRow);
            dest.writeInt(endRow);
            dest.writeInt(pages);
            dest.writeInt(prePage);
            dest.writeInt(nextPage);
            dest.writeByte((byte) (isFirstPage ? 1 : 0));
            dest.writeByte((byte) (isLastPage ? 1 : 0));
            dest.writeByte((byte) (hasPreviousPage ? 1 : 0));
            dest.writeByte((byte) (hasNextPage ? 1 : 0));
            dest.writeInt(navigatePages);
            dest.writeInt(navigateFirstPage);
            dest.writeInt(navigateLastPage);
            dest.writeInt(firstPage);
            dest.writeInt(lastPage);
        }

        public static class ListBean implements Serializable,Parcelable{
            /**
             * id : 1
             * topicName : 克罗群岛
             * topicDescribes : null
             * topicNum : 4
             * createTime : null
             * topicPicture : ‪C:\fileUpload\picture20191016113455_1564384598(1).jpg
             */

            private int id;
            private String topicName;
            private Object topicDescribes;
            private int topicNum;
            private Object createTime;
            private String topicPicture;

            protected ListBean(Parcel in) {
                id = in.readInt();
                topicName = in.readString();
                topicNum = in.readInt();
                topicPicture = in.readString();
            }

            public static final Creator<ListBean> CREATOR = new Creator<ListBean>() {
                @Override
                public ListBean createFromParcel(Parcel in) {
                    return new ListBean(in);
                }

                @Override
                public ListBean[] newArray(int size) {
                    return new ListBean[size];
                }
            };

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

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeInt(id);
                dest.writeString(topicName);
                dest.writeInt(topicNum);
                dest.writeString(topicPicture);
            }
        }
    }
}
