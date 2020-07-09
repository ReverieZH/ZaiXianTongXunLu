package cn.com.bean;

public class Contracts {
    private String cid;
    private String name;
    private String sex;
    private String birth;
    private Integer age;
    private String qq;
    private String number;
    private String phone;
    private String email;
    private String workspace;
    private String address;
    private String postcode;
    private String username;
    private String role;

    public Contracts() {
    }

    public Contracts(String name, String sex, String birth, Integer age, String qq, String number, String phone, String email,String workspace, String address, String postcode, String username, String role) {
        this.name = name;
        this.sex = sex;
        this.birth = birth;
        this.age = age;
        this.qq = qq;
        this.number = number;
        this.phone = phone;
        this.email=email;
        this.workspace = workspace;
        this.address = address;
        this.postcode = postcode;
        this.username = username;
        this.role = role;
    }

    public Contracts(String cid, String name, String sex, String birth, Integer age, String qq, String number, String phone, String email, String workspace, String address, String postcode, String username, String role) {
        this.cid = cid;
        this.name = name;
        this.sex = sex;
        this.birth = birth;
        this.age = age;
        this.qq = qq;
        this.number = number;
        this.phone = phone;
        this.email=email;
        this.workspace = workspace;
        this.address = address;
        this.postcode = postcode;
        this.username = username;
        this.role = role;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWorkspace() {
        return workspace;
    }

    public void setWorkspace(String workspace) {
        this.workspace = workspace;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return cid+" "+name+" "+sex+" "+birth+" "+age+" "+qq+" "+number+" "+phone+" "+workspace+" "+address+" "+postcode+" "+username+" "+role;
    }
}
