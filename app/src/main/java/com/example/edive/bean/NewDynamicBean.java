package com.example.edive.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class NewDynamicBean implements Parcelable {

    /**
     * code : 200
     * message : 操作成功
     * data : {"total":4,"list":[{"id":254,"dynamicAuthor":"多多鱼","dynamicHeadPortrait":"http://192.168.0.246/image/1575511840405_74734534.jpg","dynamicContent":null,"createTime":null,"dynamicAddress":null,"dynamicPicture":"http://192.168.0.246/image/1575716296683_53357788.jpg,http://192.168.0.246/image/1575716296870_73852586.jpg,http://192.168.0.246/image/1575716296933_60510441.jpg","dynamicPraise":2,"dynamicSharenum":null,"dynamicCommentnum":null,"userId":25,"topicId":null,"topicName":null,"delflag":null,"identificationPraise":0,"width":156,"height":148,"identification":1},{"id":253,"dynamicAuthor":"美好心情","dynamicHeadPortrait":"http://192.168.0.246/image/1575524348999_78186479.jpg","dynamicContent":null,"createTime":null,"dynamicAddress":null,"dynamicPicture":"http://192.168.0.246/image/1575715871815_18472228.jpg,http://192.168.0.246/image/1575715871808_78801338.jpg","dynamicPraise":0,"dynamicSharenum":null,"dynamicCommentnum":null,"userId":23,"topicId":null,"topicName":null,"delflag":null,"identificationPraise":0,"width":185,"height":120,"identification":0},{"id":251,"dynamicAuthor":"美好心情","dynamicHeadPortrait":"http://192.168.0.246/image/1575524348999_78186479.jpg","dynamicContent":null,"createTime":null,"dynamicAddress":null,"dynamicPicture":"http://192.168.0.246/image/1575714615378_92519628.jpg,http://192.168.0.246/image/1575714615378_57483880.jpg","dynamicPraise":0,"dynamicSharenum":null,"dynamicCommentnum":null,"userId":23,"topicId":null,"topicName":null,"delflag":null,"identificationPraise":0,"width":146,"height":103,"identification":0},{"id":249,"dynamicAuthor":"多多鱼","dynamicHeadPortrait":"http://192.168.0.246/image/1575511840405_74734534.jpg","dynamicContent":null,"createTime":null,"dynamicAddress":null,"dynamicPicture":"http://192.168.0.246/image/1575711183279_10377090.jpg,http://192.168.0.246/image/1575711183358_74850535.jpg","dynamicPraise":1,"dynamicSharenum":null,"dynamicCommentnum":null,"userId":25,"topicId":null,"topicName":null,"delflag":null,"identificationPraise":1,"width":196,"height":199,"identification":1}],"pageNum":1,"pageSize":5,"size":4,"startRow":1,"endRow":4,"pages":1,"prePage":0,"nextPage":0,"isFirstPage":true,"isLastPage":true,"hasPreviousPage":false,"hasNextPage":false,"navigatePages":8,"navigatepageNums":[1],"navigateFirstPage":1,"navigateLastPage":1,"firstPage":1,"lastPage":1}
     */

    private int code;
    private String message;
    private DataBean data;

    protected NewDynamicBean(Parcel in) {
        code = in.readInt();
        message = in.readString();
    }

    public static final Creator<NewDynamicBean> CREATOR = new Creator<NewDynamicBean>() {
        @Override
        public NewDynamicBean createFromParcel(Parcel in) {
            return new NewDynamicBean(in);
        }

        @Override
        public NewDynamicBean[] newArray(int size) {
            return new NewDynamicBean[size];
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

    public static class DataBean {
        /**
         * total : 4
         * list : [{"id":254,"dynamicAuthor":"多多鱼","dynamicHeadPortrait":"http://192.168.0.246/image/1575511840405_74734534.jpg","dynamicContent":null,"createTime":null,"dynamicAddress":null,"dynamicPicture":"http://192.168.0.246/image/1575716296683_53357788.jpg,http://192.168.0.246/image/1575716296870_73852586.jpg,http://192.168.0.246/image/1575716296933_60510441.jpg","dynamicPraise":2,"dynamicSharenum":null,"dynamicCommentnum":null,"userId":25,"topicId":null,"topicName":null,"delflag":null,"identificationPraise":0,"width":156,"height":148,"identification":1},{"id":253,"dynamicAuthor":"美好心情","dynamicHeadPortrait":"http://192.168.0.246/image/1575524348999_78186479.jpg","dynamicContent":null,"createTime":null,"dynamicAddress":null,"dynamicPicture":"http://192.168.0.246/image/1575715871815_18472228.jpg,http://192.168.0.246/image/1575715871808_78801338.jpg","dynamicPraise":0,"dynamicSharenum":null,"dynamicCommentnum":null,"userId":23,"topicId":null,"topicName":null,"delflag":null,"identificationPraise":0,"width":185,"height":120,"identification":0},{"id":251,"dynamicAuthor":"美好心情","dynamicHeadPortrait":"http://192.168.0.246/image/1575524348999_78186479.jpg","dynamicContent":null,"createTime":null,"dynamicAddress":null,"dynamicPicture":"http://192.168.0.246/image/1575714615378_92519628.jpg,http://192.168.0.246/image/1575714615378_57483880.jpg","dynamicPraise":0,"dynamicSharenum":null,"dynamicCommentnum":null,"userId":23,"topicId":null,"topicName":null,"delflag":null,"identificationPraise":0,"width":146,"height":103,"identification":0},{"id":249,"dynamicAuthor":"多多鱼","dynamicHeadPortrait":"http://192.168.0.246/image/1575511840405_74734534.jpg","dynamicContent":null,"createTime":null,"dynamicAddress":null,"dynamicPicture":"http://192.168.0.246/image/1575711183279_10377090.jpg,http://192.168.0.246/image/1575711183358_74850535.jpg","dynamicPraise":1,"dynamicSharenum":null,"dynamicCommentnum":null,"userId":25,"topicId":null,"topicName":null,"delflag":null,"identificationPraise":1,"width":196,"height":199,"identification":1}]
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
             * id : 254
             * dynamicAuthor : 多多鱼
             * dynamicHeadPortrait : http://192.168.0.246/image/1575511840405_74734534.jpg
             * dynamicContent : null
             * createTime : null
             * dynamicAddress : null
             * dynamicPicture : http://192.168.0.246/image/1575716296683_53357788.jpg,http://192.168.0.246/image/1575716296870_73852586.jpg,http://192.168.0.246/image/1575716296933_60510441.jpg
             * dynamicPraise : 2
             * dynamicSharenum : null
             * dynamicCommentnum : null
             * userId : 25
             * topicId : null
             * topicName : null
             * delflag : null
             * identificationPraise : 0
             * width : 156
             * height : 148
             * identification : 1
             */

            private int id;
            private String dynamicAuthor;
            private String dynamicHeadPortrait;
            private Object dynamicContent;
            private Object createTime;
            private Object dynamicAddress;
            private String dynamicPicture;
            private int dynamicPraise;
            private Object dynamicSharenum;
            private Object dynamicCommentnum;
            private int userId;
            private Object topicId;
            private Object topicName;
            private Object delflag;
            private int identificationPraise;
            private int width;
            private int userType;
            private int height;
            private int identification;

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

            public Object getDynamicContent() {
                return dynamicContent;
            }

            public void setDynamicContent(Object dynamicContent) {
                this.dynamicContent = dynamicContent;
            }

            public Object getCreateTime() {
                return createTime;
            }

            public void setCreateTime(Object createTime) {
                this.createTime = createTime;
            }

            public Object getDynamicAddress() {
                return dynamicAddress;
            }

            public void setDynamicAddress(Object dynamicAddress) {
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

            public Object getDynamicSharenum() {
                return dynamicSharenum;
            }

            public void setDynamicSharenum(Object dynamicSharenum) {
                this.dynamicSharenum = dynamicSharenum;
            }

            public Object getDynamicCommentnum() {
                return dynamicCommentnum;
            }

            public void setDynamicCommentnum(Object dynamicCommentnum) {
                this.dynamicCommentnum = dynamicCommentnum;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public Object getTopicId() {
                return topicId;
            }

            public void setTopicId(Object topicId) {
                this.topicId = topicId;
            }

            public Object getTopicName() {
                return topicName;
            }

            public void setTopicName(Object topicName) {
                this.topicName = topicName;
            }

            public Object getDelflag() {
                return delflag;
            }

            public void setDelflag(Object delflag) {
                this.delflag = delflag;
            }

            public int getIdentificationPraise() {
                return identificationPraise;
            }

            public void setIdentificationPraise(int identificationPraise) {
                this.identificationPraise = identificationPraise;
            }

            public int getWidth() {
                return width;
            }

            public void setWidth(int width) {
                this.width = width;
            }

            public int getHeight() {
                return height;
            }

            public void setHeight(int height) {
                this.height = height;
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
        }
    }
}
