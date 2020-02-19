package com.example.edives.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.List;

public class SearchBean implements Serializable, Parcelable {


    /**
     * code : 200
     * message : 操作成功
     * data : {"total":3,"list":[{"id":29,"dynamicAuthor":"化计划","dynamicHeadPortrait":null,"dynamicContent":"#克罗索尔岛17373747558488484","createTime":"2019-11-28 11:04:23","dynamicAddress":" 恒大冰泉直销店(马甸东路)","dynamicPicture":"","dynamicPraise":2,"dynamicSharenum":0,"dynamicCommentnum":2,"userId":28,"topicId":1,"topicName":"克罗索尔岛","delflag":0,"identificationPraise":null,"identification":null},{"id":28,"dynamicAuthor":"化计划","dynamicHeadPortrait":null,"dynamicContent":"#克罗索尔岛13873744","createTime":"2019-11-28 11:03:30","dynamicAddress":" 悦容女子美容养生SPA会所(马甸店)","dynamicPicture":"","dynamicPraise":0,"dynamicSharenum":0,"dynamicCommentnum":0,"userId":28,"topicId":1,"topicName":"克罗索尔岛","delflag":0,"identificationPraise":null,"identification":null},{"id":6,"dynamicAuthor":"小A","dynamicHeadPortrait":"头像","dynamicContent":"发布动态测试1","createTime":"2019-10-07 14:39:55","dynamicAddress":"string","dynamicPicture":"https://img.ivsky.com/img/tupian/pre/201810/18/qianshui-015.jpg,https://img.ivsky.com/img/tupian/pre/201810/18/qianshui-018.jpg","dynamicPraise":49,"dynamicSharenum":0,"dynamicCommentnum":3,"userId":5,"topicId":1,"topicName":"克罗索尔岛","delflag":0,"identificationPraise":null,"identification":null}],"pageNum":1,"pageSize":3,"size":3,"startRow":0,"endRow":2,"pages":1,"prePage":0,"nextPage":0,"isFirstPage":true,"isLastPage":true,"hasPreviousPage":false,"hasNextPage":false,"navigatePages":8,"navigatepageNums":[1],"navigateFirstPage":1,"navigateLastPage":1,"firstPage":1,"lastPage":1}
     */

    private int code;
    private String message;
    private DataBean data;

    protected SearchBean(Parcel in) {
        code = in.readInt();
        message = in.readString();
    }

    public static final Creator<SearchBean> CREATOR = new Creator<SearchBean>() {
        @Override
        public SearchBean createFromParcel(Parcel in) {
            return new SearchBean(in);
        }

        @Override
        public SearchBean[] newArray(int size) {
            return new SearchBean[size];
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

    public static class DataBean implements Serializable, Parcelable{
        /**
         * total : 3
         * list : [{"id":29,"dynamicAuthor":"化计划","dynamicHeadPortrait":null,"dynamicContent":"#克罗索尔岛17373747558488484","createTime":"2019-11-28 11:04:23","dynamicAddress":" 恒大冰泉直销店(马甸东路)","dynamicPicture":"","dynamicPraise":2,"dynamicSharenum":0,"dynamicCommentnum":2,"userId":28,"topicId":1,"topicName":"克罗索尔岛","delflag":0,"identificationPraise":null,"identification":null},{"id":28,"dynamicAuthor":"化计划","dynamicHeadPortrait":null,"dynamicContent":"#克罗索尔岛13873744","createTime":"2019-11-28 11:03:30","dynamicAddress":" 悦容女子美容养生SPA会所(马甸店)","dynamicPicture":"","dynamicPraise":0,"dynamicSharenum":0,"dynamicCommentnum":0,"userId":28,"topicId":1,"topicName":"克罗索尔岛","delflag":0,"identificationPraise":null,"identification":null},{"id":6,"dynamicAuthor":"小A","dynamicHeadPortrait":"头像","dynamicContent":"发布动态测试1","createTime":"2019-10-07 14:39:55","dynamicAddress":"string","dynamicPicture":"https://img.ivsky.com/img/tupian/pre/201810/18/qianshui-015.jpg,https://img.ivsky.com/img/tupian/pre/201810/18/qianshui-018.jpg","dynamicPraise":49,"dynamicSharenum":0,"dynamicCommentnum":3,"userId":5,"topicId":1,"topicName":"克罗索尔岛","delflag":0,"identificationPraise":null,"identification":null}]
         * pageNum : 1
         * pageSize : 3
         * size : 3
         * startRow : 0
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

        public static class ListBean implements Serializable, Parcelable{
            /**
             * id : 29
             * dynamicAuthor : 化计划
             * dynamicHeadPortrait : null
             * dynamicContent : #克罗索尔岛17373747558488484
             * createTime : 2019-11-28 11:04:23
             * dynamicAddress :  恒大冰泉直销店(马甸东路)
             * dynamicPicture :
             * dynamicPraise : 2
             * dynamicSharenum : 0
             * dynamicCommentnum : 2
             * userId : 28
             * topicId : 1
             * topicName : 克罗索尔岛
             * delflag : 0
             * identificationPraise : null
             * identification : null
             */

            private int id;
            private String dynamicAuthor;
            private String dynamicHeadPortrait;
            private String dynamicContent;
            private String createTime;
            private String dynamicAddress;
            private String dynamicPicture;
            private int dynamicPraise;
            private int dynamicSharenum;
            private int dynamicCommentnum;
            private int userId;
            private int topicId;
            private String topicName;
            private int userType;
            private int delflag;
            private int identificationPraise;
            private int identification;

            protected ListBean(Parcel in) {
                id = in.readInt();
                dynamicAuthor = in.readString();
                dynamicContent = in.readString();
                createTime = in.readString();
                dynamicAddress = in.readString();
                dynamicPicture = in.readString();
                dynamicPraise = in.readInt();
                dynamicSharenum = in.readInt();
                dynamicCommentnum = in.readInt();
                userId = in.readInt();
                topicId = in.readInt();
                topicName = in.readString();
                delflag = in.readInt();
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

            public String getDynamicAuthor() {
                return dynamicAuthor;
            }

            public void setDynamicAuthor(String dynamicAuthor) {
                this.dynamicAuthor = dynamicAuthor;
            }

            public String getDynamicHeadPortrait() {
                return dynamicHeadPortrait;
            }

            public void setDynamicHeadPortrait(String dynamicHeadPortrait) {
                this.dynamicHeadPortrait = dynamicHeadPortrait;
            }

            public String getDynamicContent() {
                return dynamicContent;
            }

            public void setDynamicContent(String dynamicContent) {
                this.dynamicContent = dynamicContent;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public String getDynamicAddress() {
                return dynamicAddress;
            }

            public void setDynamicAddress(String dynamicAddress) {
                this.dynamicAddress = dynamicAddress;
            }

            public String getDynamicPicture() {
                return dynamicPicture;
            }

            public void setDynamicPicture(String dynamicPicture) {
                this.dynamicPicture = dynamicPicture;
            }

            public int getDynamicPraise() {
                return dynamicPraise;
            }

            public void setDynamicPraise(int dynamicPraise) {
                this.dynamicPraise = dynamicPraise;
            }

            public int getDynamicSharenum() {
                return dynamicSharenum;
            }

            public void setDynamicSharenum(int dynamicSharenum) {
                this.dynamicSharenum = dynamicSharenum;
            }

            public int getDynamicCommentnum() {
                return dynamicCommentnum;
            }

            public void setDynamicCommentnum(int dynamicCommentnum) {
                this.dynamicCommentnum = dynamicCommentnum;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public int getTopicId() {
                return topicId;
            }

            public void setTopicId(int topicId) {
                this.topicId = topicId;
            }

            public String getTopicName() {
                return topicName;
            }

            public void setTopicName(String topicName) {
                this.topicName = topicName;
            }

            public int getDelflag() {
                return delflag;
            }

            public void setDelflag(int delflag) {
                this.delflag = delflag;
            }

            public int getIdentificationPraise() {
                return identificationPraise;
            }

            public void setIdentificationPraise(int identificationPraise) {
                this.identificationPraise = identificationPraise;
            }

            public int getIdentification() {
                return identification;
            }

            public void setIdentification(int identification) {
                this.identification = identification;
            }

            public int getUserType() {
                return userType;
            }

            public void setUserType(int userType) {
                this.userType = userType;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeInt(id);
                dest.writeString(dynamicAuthor);
                dest.writeString(dynamicContent);
                dest.writeString(createTime);
                dest.writeString(dynamicAddress);
                dest.writeString(dynamicPicture);
                dest.writeInt(dynamicPraise);
                dest.writeInt(dynamicSharenum);
                dest.writeInt(dynamicCommentnum);
                dest.writeInt(userId);
                dest.writeInt(topicId);
                dest.writeString(topicName);
                dest.writeInt(delflag);
            }
        }
    }
}
