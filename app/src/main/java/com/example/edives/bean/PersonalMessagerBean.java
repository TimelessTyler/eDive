package com.example.edives.bean;

public class PersonalMessagerBean {
    /**
     * code : 200
     * message : 操作成功
     * result : {"id":23,"coachName":"15609563858","nickName":"今天明天后天","icon":"http://192.168.0.246/image/1576752042578_77917411.jpg","phone":"15609563858","coachGrade":"1","personalProfile":"完美教练太棒了吧唧吧唧吧唧吧唧吧唧吧唧吧唧吧唧吧唧吧唧吧唧吧唧吧唧吧唧吧唧","personalAlbum":"http://192.168.0.246/image/1576745967426_83833684.jpg,http://192.168.0.246/image/1576745967755_21349784.jpg,http://192.168.0.246/image/1576745970387_51121226.jpg","invitationCode":"7ENPA8U","certificatePic":null,"totalInvitations":0,"totalFollow":1,"totalProduct":0}
     */

    private int code;
    private String message;
    private ResultBean result;

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

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * id : 23
         * coachName : 15609563858
         * nickName : 今天明天后天
         * icon : http://192.168.0.246/image/1576752042578_77917411.jpg
         * phone : 15609563858
         * coachGrade : 1
         * personalProfile : 完美教练太棒了吧唧吧唧吧唧吧唧吧唧吧唧吧唧吧唧吧唧吧唧吧唧吧唧吧唧吧唧吧唧
         * personalAlbum : http://192.168.0.246/image/1576745967426_83833684.jpg,http://192.168.0.246/image/1576745967755_21349784.jpg,http://192.168.0.246/image/1576745970387_51121226.jpg
         * invitationCode : 7ENPA8U
         * certificatePic : null
         * totalInvitations : 0
         * totalFollow : 1
         * totalProduct : 0
         */

        private int id;
        private String coachName;
        private String nickName;
        private String icon;
        private String phone;
        private String coachGrade;
        private String personalProfile;
        private String personalAlbum;
        private String invitationCode;
        private Object certificatePic;
        private int totalInvitations;
        private int totalFollow;
        private int totalProduct;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getCoachName() {
            return coachName;
        }

        public void setCoachName(String coachName) {
            this.coachName = coachName;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getCoachGrade() {
            return coachGrade;
        }

        public void setCoachGrade(String coachGrade) {
            this.coachGrade = coachGrade;
        }

        public String getPersonalProfile() {
            return personalProfile;
        }

        public void setPersonalProfile(String personalProfile) {
            this.personalProfile = personalProfile;
        }

        public String getPersonalAlbum() {
            return personalAlbum;
        }

        public void setPersonalAlbum(String personalAlbum) {
            this.personalAlbum = personalAlbum;
        }

        public String getInvitationCode() {
            return invitationCode;
        }

        public void setInvitationCode(String invitationCode) {
            this.invitationCode = invitationCode;
        }

        public Object getCertificatePic() {
            return certificatePic;
        }

        public void setCertificatePic(Object certificatePic) {
            this.certificatePic = certificatePic;
        }

        public int getTotalInvitations() {
            return totalInvitations;
        }

        public void setTotalInvitations(int totalInvitations) {
            this.totalInvitations = totalInvitations;
        }

        public int getTotalFollow() {
            return totalFollow;
        }

        public void setTotalFollow(int totalFollow) {
            this.totalFollow = totalFollow;
        }

        public int getTotalProduct() {
            return totalProduct;
        }

        public void setTotalProduct(int totalProduct) {
            this.totalProduct = totalProduct;
        }
    }
}
