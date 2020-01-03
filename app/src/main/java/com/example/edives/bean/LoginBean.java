package com.example.edives.bean;

import java.util.List;

public class LoginBean {
    /**
     * code : 200
     * data : {"expiresIn":999999997,"additionalInformation":{"nickName":"害怕的专业","icon":"http://47.107.50.253:8080/webapps/uploadFile/compent/20191208145645.png","id":23,"jti":"5f769a2e-61ae-4685-a028-67f05f172202","username":"15609563858"},"expired":false,"scope":["all"],"expiration":2576639031265,"tokenType":"bearer","value":"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiIxNTYwOTU2Mzg1OCIsIm5pY2tOYW1lIjoi5a6z5oCV55qE5LiT5LiaIiwic2NvcGUiOlsiYWxsIl0sImljb24iOiJodHRwOi8vNDcuMTA3LjUwLjI1Mzo4MDgwL3dlYmFwcHMvdXBsb2FkRmlsZS9jb21wZW50LzIwMTkxMjA4MTQ1NjQ1LnBuZyIsImlkIjoyMywiZXhwIjoyNTc2NjM5MDMxLCJqdGkiOiI1Zjc2OWEyZS02MWFlLTQ2ODUtYTAyOC02N2YwNWYxNzIyMDIiLCJwZXJzb25hbGl6ZWRTaWduYXR1cmUiOm51bGwsImNsaWVudF9pZCI6ImRtZCIsInVzZXJuYW1lIjoiMTU2MDk1NjM4NTgifQ.odRMj7W1qZqZx0m-GGOp1W40Rc8TfvD5c7vRxXUZ3Mw","refreshToken":{"expiration":2576639031265,"value":"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiIxNTYwOTU2Mzg1OCIsIm5pY2tOYW1lIjoi5a6z5oCV55qE5LiT5LiaIiwic2NvcGUiOlsiYWxsIl0sImF0aSI6IjVmNzY5YTJlLTYxYWUtNDY4NS1hMDI4LTY3ZjA1ZjE3MjIwMiIsImljb24iOiJodHRwOi8vNDcuMTA3LjUwLjI1Mzo4MDgwL3dlYmFwcHMvdXBsb2FkRmlsZS9jb21wZW50LzIwMTkxMjA4MTQ1NjQ1LnBuZyIsImlkIjoyMywiZXhwIjoyNTc2NjM5MDMxLCJqdGkiOiIxMmY5MjJhMi02Yzk1LTRlNzYtYTYyOS00ZGJkYjM3ODIxZGUiLCJwZXJzb25hbGl6ZWRTaWduYXR1cmUiOm51bGwsImNsaWVudF9pZCI6ImRtZCIsInVzZXJuYW1lIjoiMTU2MDk1NjM4NTgifQ.NA_YWitwjO9sFsThcCpXAMws884EJcGFjW70A98tNU0"}}
     * message : 登录成功
     */

    private int code;
    private DataBean data;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class DataBean {
        /**
         * expiresIn : 999999997
         * additionalInformation : {"nickName":"害怕的专业","icon":"http://47.107.50.253:8080/webapps/uploadFile/compent/20191208145645.png","id":23,"jti":"5f769a2e-61ae-4685-a028-67f05f172202","username":"15609563858"}
         * expired : false
         * scope : ["all"]
         * expiration : 2576639031265
         * tokenType : bearer
         * value : eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiIxNTYwOTU2Mzg1OCIsIm5pY2tOYW1lIjoi5a6z5oCV55qE5LiT5LiaIiwic2NvcGUiOlsiYWxsIl0sImljb24iOiJodHRwOi8vNDcuMTA3LjUwLjI1Mzo4MDgwL3dlYmFwcHMvdXBsb2FkRmlsZS9jb21wZW50LzIwMTkxMjA4MTQ1NjQ1LnBuZyIsImlkIjoyMywiZXhwIjoyNTc2NjM5MDMxLCJqdGkiOiI1Zjc2OWEyZS02MWFlLTQ2ODUtYTAyOC02N2YwNWYxNzIyMDIiLCJwZXJzb25hbGl6ZWRTaWduYXR1cmUiOm51bGwsImNsaWVudF9pZCI6ImRtZCIsInVzZXJuYW1lIjoiMTU2MDk1NjM4NTgifQ.odRMj7W1qZqZx0m-GGOp1W40Rc8TfvD5c7vRxXUZ3Mw
         * refreshToken : {"expiration":2576639031265,"value":"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiIxNTYwOTU2Mzg1OCIsIm5pY2tOYW1lIjoi5a6z5oCV55qE5LiT5LiaIiwic2NvcGUiOlsiYWxsIl0sImF0aSI6IjVmNzY5YTJlLTYxYWUtNDY4NS1hMDI4LTY3ZjA1ZjE3MjIwMiIsImljb24iOiJodHRwOi8vNDcuMTA3LjUwLjI1Mzo4MDgwL3dlYmFwcHMvdXBsb2FkRmlsZS9jb21wZW50LzIwMTkxMjA4MTQ1NjQ1LnBuZyIsImlkIjoyMywiZXhwIjoyNTc2NjM5MDMxLCJqdGkiOiIxMmY5MjJhMi02Yzk1LTRlNzYtYTYyOS00ZGJkYjM3ODIxZGUiLCJwZXJzb25hbGl6ZWRTaWduYXR1cmUiOm51bGwsImNsaWVudF9pZCI6ImRtZCIsInVzZXJuYW1lIjoiMTU2MDk1NjM4NTgifQ.NA_YWitwjO9sFsThcCpXAMws884EJcGFjW70A98tNU0"}
         */

        private int expiresIn;
        private AdditionalInformationBean additionalInformation;
        private boolean expired;
        private long expiration;
        private String tokenType;
        private String value;
        private RefreshTokenBean refreshToken;
        private List<String> scope;

        public int getExpiresIn() {
            return expiresIn;
        }

        public void setExpiresIn(int expiresIn) {
            this.expiresIn = expiresIn;
        }

        public AdditionalInformationBean getAdditionalInformation() {
            return additionalInformation;
        }

        public void setAdditionalInformation(AdditionalInformationBean additionalInformation) {
            this.additionalInformation = additionalInformation;
        }

        public boolean isExpired() {
            return expired;
        }

        public void setExpired(boolean expired) {
            this.expired = expired;
        }

        public long getExpiration() {
            return expiration;
        }

        public void setExpiration(long expiration) {
            this.expiration = expiration;
        }

        public String getTokenType() {
            return tokenType;
        }

        public void setTokenType(String tokenType) {
            this.tokenType = tokenType;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public RefreshTokenBean getRefreshToken() {
            return refreshToken;
        }

        public void setRefreshToken(RefreshTokenBean refreshToken) {
            this.refreshToken = refreshToken;
        }

        public List<String> getScope() {
            return scope;
        }

        public void setScope(List<String> scope) {
            this.scope = scope;
        }

        public static class AdditionalInformationBean {
            /**
             * nickName : 害怕的专业
             * icon : http://47.107.50.253:8080/webapps/uploadFile/compent/20191208145645.png
             * id : 23
             * jti : 5f769a2e-61ae-4685-a028-67f05f172202
             * username : 15609563858
             */

            private String nickName;
            private String icon;
            private int id;
            private String jti;
            private String username;

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

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getJti() {
                return jti;
            }

            public void setJti(String jti) {
                this.jti = jti;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }
        }

        public static class RefreshTokenBean {
            /**
             * expiration : 2576639031265
             * value : eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiIxNTYwOTU2Mzg1OCIsIm5pY2tOYW1lIjoi5a6z5oCV55qE5LiT5LiaIiwic2NvcGUiOlsiYWxsIl0sImF0aSI6IjVmNzY5YTJlLTYxYWUtNDY4NS1hMDI4LTY3ZjA1ZjE3MjIwMiIsImljb24iOiJodHRwOi8vNDcuMTA3LjUwLjI1Mzo4MDgwL3dlYmFwcHMvdXBsb2FkRmlsZS9jb21wZW50LzIwMTkxMjA4MTQ1NjQ1LnBuZyIsImlkIjoyMywiZXhwIjoyNTc2NjM5MDMxLCJqdGkiOiIxMmY5MjJhMi02Yzk1LTRlNzYtYTYyOS00ZGJkYjM3ODIxZGUiLCJwZXJzb25hbGl6ZWRTaWduYXR1cmUiOm51bGwsImNsaWVudF9pZCI6ImRtZCIsInVzZXJuYW1lIjoiMTU2MDk1NjM4NTgifQ.NA_YWitwjO9sFsThcCpXAMws884EJcGFjW70A98tNU0
             */

            private long expiration;
            private String value;

            public long getExpiration() {
                return expiration;
            }

            public void setExpiration(long expiration) {
                this.expiration = expiration;
            }

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }
        }
    }
}
