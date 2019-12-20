package com.example.edive.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.List;

public class SearchDynamicBean implements Serializable, Parcelable {
    /**
     * code : 200
     * message : 操作成功
     * data : [{"id":2,"topicName":"马尔代夫海峡","topicDescribes":null,"topicNum":null,"createTime":null,"topicPicture":null}]
     */

    private int code;
    private String message;
    private List<DataBean> data;

    protected SearchDynamicBean(Parcel in) {
        code = in.readInt();
        message = in.readString();
    }

    public static final Creator<SearchDynamicBean> CREATOR = new Creator<SearchDynamicBean>() {
        @Override
        public SearchDynamicBean createFromParcel(Parcel in) {
            return new SearchDynamicBean(in);
        }

        @Override
        public SearchDynamicBean[] newArray(int size) {
            return new SearchDynamicBean[size];
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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
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
         * id : 2
         * topicName : 马尔代夫海峡
         * topicDescribes : null
         * topicNum : null
         * createTime : null
         * topicPicture : null
         */

        private int id;
        private String topicName;
        private Object topicDescribes;
        private int topicNum;
        private Object createTime;
        private String topicPicture;

        protected DataBean(Parcel in) {
            id = in.readInt();
            topicName = in.readString();
            topicNum = in.readInt();
            topicPicture = in.readString();
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
