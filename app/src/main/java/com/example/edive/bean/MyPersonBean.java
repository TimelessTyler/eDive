package com.example.edive.bean;

public class MyPersonBean {
    /**
     * code : 200
     * message : 操作成功
     * result : {"id":23,"coachName":"15609563858","nickName":"害怕的专业","icon":"http://47.107.50.253:8080/webapps/uploadFile/compent/20191208145645.png","phone":"15609563858","coachGrade":"1","personalProfile":null,"personalAlbum":null,"invitationCode":"7ENPA8U","certificatePic":null}
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
         * nickName : 害怕的专业
         * icon : http://47.107.50.253:8080/webapps/uploadFile/compent/20191208145645.png
         * phone : 15609563858
         * coachGrade : 1
         * personalProfile : null
         * personalAlbum : null
         * invitationCode : 7ENPA8U
         * certificatePic : null
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
        private String certificatePic;

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

        public String getCertificatePic() {
            return certificatePic;
        }

        public void setCertificatePic(String certificatePic) {
            this.certificatePic = certificatePic;
        }
    }
}
