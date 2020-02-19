package com.example.edives.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.List;

public class SearchShoppingBean implements Serializable, Parcelable {

    /**
     * code : 200
     * message : 操作成功
     * data : {"total":7,"list":[{"id":1,"englishName":"OPEN WATER DIVER","englishShorthand":"OWD","certificateLevel":"1","pic":"https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=1919205464,1223035513&fm=26&gp=0.jpg","introduction":"开放水域初级潜水员是最基本的潜水课程，受训学员可以学习到潜水技巧、与潜伴潜水时的潜水安全知识。完成本次课程即可获得OW证书！","productNum":2},{"id":2,"englishName":"ADVANCED OPEN WATER DIVER","englishShorthand":"AOWD","certificateLevel":"2","pic":"https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=1919205464,1223035513&fm=26&gp=0.jpg","introduction":"AOW的水深限度是30米，并且可以做夜潜,本课程提供参加学员不同的专长潜水训练，如深潜、船潜、水中导航及夜潜...等，其中深潜和水中导航是必须选择的专长，除此两个专长以外，还需要选三个专长，通过这五个专长的训练后，方可拿到执照","productNum":2},{"id":4,"englishName":"RESCUE DIVER","englishShorthand":"RED","certificateLevel":"4","pic":"https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=1919205464,1223035513&fm=26&gp=0.jpg","introduction":"救援潜水员课程是学习潜水中第一次要求潜水员必须将注意力集中在另一名潜水员的课程。学员在此课程中将学习如何避免危险及意外的发生，并能随时应付水中的紧急状况。","productNum":2},{"id":5,"englishName":"SPECIAL COURSES","englishShorthand":"SC","certificateLevel":"5","pic":"https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=1919205464,1223035513&fm=26&gp=0.jpg","introduction":"潜水专长课程属于短期的特殊专长课程，课程安排通常为1～2天，主要是2～4次的专长潜水训练。参加学员资格则因各专长潜水的难易程度而有所不同。","productNum":0},{"id":6,"englishName":"MASTER SCUBA DIVER","englishShorthand":"MSD","certificateLevel":"6","pic":"https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=1919205464,1223035513&fm=26&gp=0.jpg","introduction":"当潜水员完成了PADI的五项专长潜水课程并具有救援潜水员资格时，即可申请名仕潜水员执照。名仕潜水员是休闲潜水员的最高荣誉","productNum":0},{"id":7,"englishName":"DIVER MASTER","englishShorthand":"DM","certificateLevel":"7","pic":"https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=1919205464,1223035513&fm=26&gp=0.jpg","introduction":"潜水长是进入潜水教学训练的第一站，持有潜水长执照之潜水员可以从事潜水导游或协助潜水教学的训练工作。","productNum":0},{"id":9,"englishName":"Master Scuba Diver Trainer","englishShorthand":"MSDT","certificateLevel":"9","pic":"https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=1919205464,1223035513&fm=26&gp=0.jpg","introduction":"拥有超过5项专长课程教练资格的教练。包括课程：高氧空气专长，双瓶专长，深潜专长，夜潜专长，水底导航专长，沉船专长，水底数码专长等20余项专长课程","productNum":0}],"pageNum":1,"pageSize":7,"size":7,"startRow":0,"endRow":6,"pages":1,"prePage":0,"nextPage":0,"isFirstPage":true,"isLastPage":true,"hasPreviousPage":false,"hasNextPage":false,"navigatePages":8,"navigatepageNums":[1],"navigateFirstPage":1,"navigateLastPage":1,"firstPage":1,"lastPage":1}
     */

    private int code;
    private String message;
    private DataBean data;

    protected SearchShoppingBean(Parcel in) {
        code = in.readInt();
        message = in.readString();
    }

    public static final Creator<SearchShoppingBean> CREATOR = new Creator<SearchShoppingBean>() {
        @Override
        public SearchShoppingBean createFromParcel(Parcel in) {
            return new SearchShoppingBean(in);
        }

        @Override
        public SearchShoppingBean[] newArray(int size) {
            return new SearchShoppingBean[size];
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
         * total : 7
         * list : [{"id":1,"englishName":"OPEN WATER DIVER","englishShorthand":"OWD","certificateLevel":"1","pic":"https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=1919205464,1223035513&fm=26&gp=0.jpg","introduction":"开放水域初级潜水员是最基本的潜水课程，受训学员可以学习到潜水技巧、与潜伴潜水时的潜水安全知识。完成本次课程即可获得OW证书！","productNum":2},{"id":2,"englishName":"ADVANCED OPEN WATER DIVER","englishShorthand":"AOWD","certificateLevel":"2","pic":"https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=1919205464,1223035513&fm=26&gp=0.jpg","introduction":"AOW的水深限度是30米，并且可以做夜潜,本课程提供参加学员不同的专长潜水训练，如深潜、船潜、水中导航及夜潜...等，其中深潜和水中导航是必须选择的专长，除此两个专长以外，还需要选三个专长，通过这五个专长的训练后，方可拿到执照","productNum":2},{"id":4,"englishName":"RESCUE DIVER","englishShorthand":"RED","certificateLevel":"4","pic":"https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=1919205464,1223035513&fm=26&gp=0.jpg","introduction":"救援潜水员课程是学习潜水中第一次要求潜水员必须将注意力集中在另一名潜水员的课程。学员在此课程中将学习如何避免危险及意外的发生，并能随时应付水中的紧急状况。","productNum":2},{"id":5,"englishName":"SPECIAL COURSES","englishShorthand":"SC","certificateLevel":"5","pic":"https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=1919205464,1223035513&fm=26&gp=0.jpg","introduction":"潜水专长课程属于短期的特殊专长课程，课程安排通常为1～2天，主要是2～4次的专长潜水训练。参加学员资格则因各专长潜水的难易程度而有所不同。","productNum":0},{"id":6,"englishName":"MASTER SCUBA DIVER","englishShorthand":"MSD","certificateLevel":"6","pic":"https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=1919205464,1223035513&fm=26&gp=0.jpg","introduction":"当潜水员完成了PADI的五项专长潜水课程并具有救援潜水员资格时，即可申请名仕潜水员执照。名仕潜水员是休闲潜水员的最高荣誉","productNum":0},{"id":7,"englishName":"DIVER MASTER","englishShorthand":"DM","certificateLevel":"7","pic":"https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=1919205464,1223035513&fm=26&gp=0.jpg","introduction":"潜水长是进入潜水教学训练的第一站，持有潜水长执照之潜水员可以从事潜水导游或协助潜水教学的训练工作。","productNum":0},{"id":9,"englishName":"Master Scuba Diver Trainer","englishShorthand":"MSDT","certificateLevel":"9","pic":"https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=1919205464,1223035513&fm=26&gp=0.jpg","introduction":"拥有超过5项专长课程教练资格的教练。包括课程：高氧空气专长，双瓶专长，深潜专长，夜潜专长，水底导航专长，沉船专长，水底数码专长等20余项专长课程","productNum":0}]
         * pageNum : 1
         * pageSize : 7
         * size : 7
         * startRow : 0
         * endRow : 6
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
             * englishName : OPEN WATER DIVER
             * englishShorthand : OWD
             * certificateLevel : 1
             * pic : https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=1919205464,1223035513&fm=26&gp=0.jpg
             * introduction : 开放水域初级潜水员是最基本的潜水课程，受训学员可以学习到潜水技巧、与潜伴潜水时的潜水安全知识。完成本次课程即可获得OW证书！
             * productNum : 2
             */

            private int id;
            private String englishName;
            private String englishShorthand;
            private String certificateLevel;
            private String pic;
            private String introduction;
            private int productNum;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getEnglishName() {
                return englishName;
            }

            public void setEnglishName(String englishName) {
                this.englishName = englishName;
            }

            public String getEnglishShorthand() {
                return englishShorthand;
            }

            public void setEnglishShorthand(String englishShorthand) {
                this.englishShorthand = englishShorthand;
            }

            public String getCertificateLevel() {
                return certificateLevel;
            }

            public void setCertificateLevel(String certificateLevel) {
                this.certificateLevel = certificateLevel;
            }

            public String getPic() {
                return pic;
            }

            public void setPic(String pic) {
                this.pic = pic;
            }

            public String getIntroduction() {
                return introduction;
            }

            public void setIntroduction(String introduction) {
                this.introduction = introduction;
            }

            public int getProductNum() {
                return productNum;
            }

            public void setProductNum(int productNum) {
                this.productNum = productNum;
            }
        }
    }
}
