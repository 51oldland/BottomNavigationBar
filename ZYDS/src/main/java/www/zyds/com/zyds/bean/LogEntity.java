package www.zyds.com.zyds.bean;

import java.io.Serializable;

public class LogEntity implements Serializable{

    /**
     * errcode : 0
     * errmsg :
     * version : 1
     * state : 0
     * res : {"user_id":1000,"sex":"男","province":1,"city":2,"name":"新新","county":"","ident":"学生"}
     */

    private int errcode;
    private String errmsg;
    private int version;
    private int state;
    private ResEntity res;
    private static final long serialVersionUID = -205646241094405997L;
    //-4801687593563066917L

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public void setState(int state) {
        this.state = state;
    }

    public void setRes(ResEntity res) {
        this.res = res;
    }

    public int getErrcode() {
        return errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public int getVersion() {
        return version;
    }

    public int getState() {
        return state;
    }

    public ResEntity getRes() {
        return res;
    }

    public static class ResEntity implements Serializable{
        /**
         * user_id : 1000
         * sex : 男
         * province : 1
         * city : 2
         * name : 新新
         * county :
         * ident : 学生
         */

        private int user_id;
        private String sex;
        private int province;
        private int city;
        private String user_name;
        private String name;
        private String county;
        private String ident;
        private String province_name;
        private String city_name;
        private String nick_name;
        private String ident_name;
        private String token;
        private String photo;
        private String form_id;
        private String is_teacher;
        private static final long serialVersionUID =-518979254945401963L;

        public String getIs_teacher() {
            return is_teacher;
        }

        public void setIs_teacher(String is_teacher) {
            this.is_teacher = is_teacher;
        }

        public String getForm_id() {
            return form_id;
        }

        public void setForm_id(String form_id) {
            this.form_id = form_id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPhoto() {
            return photo;
        }

        public void setPhoto(String photo) {
            this.photo = photo;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public void setProvince(int province) {
            this.province = province;
        }

        public void setCity(int city) {
            this.city = city;
        }

        public void setUserName(String name) {
            this.user_name = name;
        }

        public void setCounty(String county) {
            this.county = county;
        }

        public void setIdent(String ident) {
            this.ident = ident;
        }

        public int getUser_id() {
            return user_id;
        }

        public String getSex() {
            return sex;
        }

        public int getProvince() {
            return province;
        }

        public int getCity() {
            return city;
        }

        public String getUserName() {
            return user_name;
        }

        public String getCounty() {
            return county;
        }

        public String getIdent() {
            return ident;
        }

        public String getProvince_name() {
            return province_name;
        }

        public void setProvince_name(String province_name) {
            this.province_name = province_name;
        }

        public String getCity_name() {
            return city_name;
        }

        public void setCity_name(String city_name) {
            this.city_name = city_name;
        }

        public String getNick_name() {
            return nick_name;
        }

        public void setNick_name(String nick_name) {
            this.nick_name = nick_name;
        }

        public String getIdent_name() {
            return ident_name;
        }

        public void setIdent_name(String ident_name) {
            this.ident_name = ident_name;
        }

        @Override
        public String toString() {
            return "ResEntity{" +
                    "user_id=" + user_id +
                    ", sex='" + sex + '\'' +
                    ", province=" + province +
                    ", city=" + city +
                    ", user_name='" + user_name + '\'' +
                    ", name='" + name + '\'' +
                    ", county='" + county + '\'' +
                    ", ident=" + ident +
                    ", province_name='" + province_name + '\'' +
                    ", city_name='" + city_name + '\'' +
                    ", nick_name='" + nick_name + '\'' +
                    ", ident_name='" + ident_name + '\'' +
                    ", token='" + token + '\'' +
                    ", photo='" + photo + '\'' +
                    ", form_id='" + form_id + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "LogEntity{" +
                "errcode=" + errcode +
                ", errmsg='" + errmsg + '\'' +
                ", version=" + version +
                ", state=" + state +
                ", res=" + res +
                '}';
    }
}
