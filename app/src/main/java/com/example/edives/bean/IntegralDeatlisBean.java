package com.example.edives.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class IntegralDeatlisBean implements Parcelable{
    /**
     * code : 200
     * message : 操作成功
     * data : [{"id":2,"name":"苹果","picture":"https://ss0.baidu.com/73F1bjeh1BF3odCf/it/u=2085187833,3115568769&fm=85&s=AAF26CCB206A3D1DCA1C1D33030090D0","integral":"611","introduce":"http://pic1.win4000.com/tj/2019-09-21/5d85c6c1353e8.jpg","createTime":1570515955000,"updateTime":1572400959000}]
     */

    private int code;
    private String message;
    private List<DataBean> data;


    protected IntegralDeatlisBean(Parcel in) {
        code = in.readInt();
        message = in.readString();
    }

    public static final Creator<IntegralDeatlisBean> CREATOR = new Creator<IntegralDeatlisBean>() {
        @Override
        public IntegralDeatlisBean createFromParcel(Parcel in) {
            return new IntegralDeatlisBean(in);
        }

        @Override
        public IntegralDeatlisBean[] newArray(int size) {
            return new IntegralDeatlisBean[size];
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


    public static class DataBean implements Parcelable{
        /**
         * id : 2
         * name : 苹果
         * picture : https://ss0.baidu.com/73F1bjeh1BF3odCf/it/u=2085187833,3115568769&fm=85&s=AAF26CCB206A3D1DCA1C1D33030090D0
         * integral : 611
         * introduce : http://pic1.win4000.com/tj/2019-09-21/5d85c6c1353e8.jpg
         * createTime : 1570515955000
         * updateTime : 1572400959000
         */

        private int id;
        private String name;
        private String picture;
        private String integral;
        private String introduce;
        private String createTime;
        private String updateTime;

        protected DataBean(Parcel in) {
            id = in.readInt();
            name = in.readString();
            picture = in.readString();
            integral = in.readString();
            introduce = in.readString();
            createTime = in.readString();
            updateTime = in.readString();
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

        public String getIntegral() {
            return integral;
        }

        public void setIntegral(String integral) {
            this.integral = integral;
        }

        public String getIntroduce() {
            return introduce;
        }

        public void setIntroduce(String introduce) {
            this.introduce = introduce;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(id);
            dest.writeString(name);
            dest.writeString(picture);
            dest.writeString(integral);
            dest.writeString(introduce);
            dest.writeString(createTime);
            dest.writeString(updateTime);
        }
    }
}
