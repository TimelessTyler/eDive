package com.example.edives.bean;

import java.util.List;

public class VerificationLgoinBean {

    /**
     * code : 200
     * data : {"expiresIn":89999,"additionalInformation":{"nickName":"花花","icon":"www.baidu.com","id":21,"personalizedSignature":"我是多蒙德一个普通员工","jti":"141a697a-78dc-44b4-bfd0-f1ff00a4b92b","username":"15609563858"},"expired":false,"scope":["all"],"expiration":1574404246444,"tokenType":"bearer","value":"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiIxNTYwOTU2Mzg1OCIsIm5pY2tOYW1lIjoi6Iqx6IqxIiwic2NvcGUiOlsiYWxsIl0sImljb24iOiJ3d3cuYmFpZHUuY29tIiwiaWQiOjIxLCJleHAiOjE1NzQ0MDQyNDYsImp0aSI6IjE0MWE2OTdhLTc4ZGMtNDRiNC1iZmQwLWYxZmYwMGE0YjkyYiIsInBlcnNvbmFsaXplZFNpZ25hdHVyZSI6IuaIkeaYr-WkmuiSmeW-t-S4gOS4quaZrumAmuWRmOW3pSIsImNsaWVudF9pZCI6ImRtZCIsInVzZXJuYW1lIjoiMTU2MDk1NjM4NTgifQ.L6a-zIwtLObgQOVYsk5jlhrPJGQfVi_kMLYDYIQ-Bg0","refreshToken":{"expiration":2574314245444,"value":"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiIxNTYwOTU2Mzg1OCIsIm5pY2tOYW1lIjoi6Iqx6IqxIiwic2NvcGUiOlsiYWxsIl0sImF0aSI6IjE0MWE2OTdhLTc4ZGMtNDRiNC1iZmQwLWYxZmYwMGE0YjkyYiIsImljb24iOiJ3d3cuYmFpZHUuY29tIiwiaWQiOjIxLCJleHAiOjI1NzQzMTQyNDUsImp0aSI6IjA4NmJlNTZhLTAxMzktNDU0MC1iMmU5LWI0MDc3OTAzZjJiNyIsInBlcnNvbmFsaXplZFNpZ25hdHVyZSI6IuaIkeaYr-WkmuiSmeW-t-S4gOS4quaZrumAmuWRmOW3pSIsImNsaWVudF9pZCI6ImRtZCIsInVzZXJuYW1lIjoiMTU2MDk1NjM4NTgifQ.0ksosiNMNBv1bVGkvtk_Lsxg7ZaJcdAacgNWtkHt4Zg"}}
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
         * expiresIn : 89999
         * additionalInformation : {"nickName":"花花","icon":"www.baidu.com","id":21,"personalizedSignature":"我是多蒙德一个普通员工","jti":"141a697a-78dc-44b4-bfd0-f1ff00a4b92b","username":"15609563858"}
         * expired : false
         * scope : ["all"]
         * expiration : 1574404246444
         * tokenType : bearer
         * value : eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiIxNTYwOTU2Mzg1OCIsIm5pY2tOYW1lIjoi6Iqx6IqxIiwic2NvcGUiOlsiYWxsIl0sImljb24iOiJ3d3cuYmFpZHUuY29tIiwiaWQiOjIxLCJleHAiOjE1NzQ0MDQyNDYsImp0aSI6IjE0MWE2OTdhLTc4ZGMtNDRiNC1iZmQwLWYxZmYwMGE0YjkyYiIsInBlcnNvbmFsaXplZFNpZ25hdHVyZSI6IuaIkeaYr-WkmuiSmeW-t-S4gOS4quaZrumAmuWRmOW3pSIsImNsaWVudF9pZCI6ImRtZCIsInVzZXJuYW1lIjoiMTU2MDk1NjM4NTgifQ.L6a-zIwtLObgQOVYsk5jlhrPJGQfVi_kMLYDYIQ-Bg0
         * refreshToken : {"expiration":2574314245444,"value":"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiIxNTYwOTU2Mzg1OCIsIm5pY2tOYW1lIjoi6Iqx6IqxIiwic2NvcGUiOlsiYWxsIl0sImF0aSI6IjE0MWE2OTdhLTc4ZGMtNDRiNC1iZmQwLWYxZmYwMGE0YjkyYiIsImljb24iOiJ3d3cuYmFpZHUuY29tIiwiaWQiOjIxLCJleHAiOjI1NzQzMTQyNDUsImp0aSI6IjA4NmJlNTZhLTAxMzktNDU0MC1iMmU5LWI0MDc3OTAzZjJiNyIsInBlcnNvbmFsaXplZFNpZ25hdHVyZSI6IuaIkeaYr-WkmuiSmeW-t-S4gOS4quaZrumAmuWRmOW3pSIsImNsaWVudF9pZCI6ImRtZCIsInVzZXJuYW1lIjoiMTU2MDk1NjM4NTgifQ.0ksosiNMNBv1bVGkvtk_Lsxg7ZaJcdAacgNWtkHt4Zg"}
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
             * nickName : 花花
             * icon : www.baidu.com
             * id : 21
             * personalizedSignature : 我是多蒙德一个普通员工
             * jti : 141a697a-78dc-44b4-bfd0-f1ff00a4b92b
             * username : 15609563858
             */

            private String nickName;
            private String icon;
            private int id;
            private String personalizedSignature;
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

            public String getPersonalizedSignature() {
                return personalizedSignature;
            }

            public void setPersonalizedSignature(String personalizedSignature) {
                this.personalizedSignature = personalizedSignature;
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
             * expiration : 2574314245444
             * value : eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiIxNTYwOTU2Mzg1OCIsIm5pY2tOYW1lIjoi6Iqx6IqxIiwic2NvcGUiOlsiYWxsIl0sImF0aSI6IjE0MWE2OTdhLTc4ZGMtNDRiNC1iZmQwLWYxZmYwMGE0YjkyYiIsImljb24iOiJ3d3cuYmFpZHUuY29tIiwiaWQiOjIxLCJleHAiOjI1NzQzMTQyNDUsImp0aSI6IjA4NmJlNTZhLTAxMzktNDU0MC1iMmU5LWI0MDc3OTAzZjJiNyIsInBlcnNvbmFsaXplZFNpZ25hdHVyZSI6IuaIkeaYr-WkmuiSmeW-t-S4gOS4quaZrumAmuWRmOW3pSIsImNsaWVudF9pZCI6ImRtZCIsInVzZXJuYW1lIjoiMTU2MDk1NjM4NTgifQ.0ksosiNMNBv1bVGkvtk_Lsxg7ZaJcdAacgNWtkHt4Zg
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
