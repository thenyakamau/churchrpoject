package model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MembersDatum {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("active_status")
    @Expose
    private Integer activeStatus;
    @SerializedName("user_id")
    @Expose
    private Integer userId;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("phone_number")
    @Expose
    private String phoneNumber;
    @SerializedName("email_verified_at")
    @Expose
    private String emailVerifiedAt;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("age")
    @Expose
    private Integer age;
    @SerializedName("marriage_status")
    @Expose
    private String marriageStatus;
    @SerializedName("committment")
    @Expose
    private String committment;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("remember_token")
    @Expose
    private String rememberToken;

    /**
     * No args constructor for use in serialization
     *
     */
    public MembersDatum() {
    }

    /**
     *
     * @param image
     * @param gender
     * @param marriageStatus
     * @param userId
     * @param createdAt
     * @param password
     * @param phoneNumber
     * @param activeStatus
     * @param emailVerifiedAt
     * @param name
     * @param committment
     * @param id
     * @param rememberToken
     * @param email
     * @param age
     * @param updatedAt
     * @param status
     */
    public MembersDatum(Integer id, Integer activeStatus, Integer userId, String createdAt, String updatedAt, String name, String email, String status, String phoneNumber, String emailVerifiedAt, String password, Integer age, String marriageStatus, String committment, String gender, String image, String rememberToken) {
        super();
        this.id = id;
        this.activeStatus = activeStatus;
        this.userId = userId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.name = name;
        this.email = email;
        this.status = status;
        this.phoneNumber = phoneNumber;
        this.emailVerifiedAt = emailVerifiedAt;
        this.password = password;
        this.age = age;
        this.marriageStatus = marriageStatus;
        this.committment = committment;
        this.gender = gender;
        this.image = image;
        this.rememberToken = rememberToken;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(Integer activeStatus) {
        this.activeStatus = activeStatus;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailVerifiedAt() {
        return emailVerifiedAt;
    }

    public void setEmailVerifiedAt(String emailVerifiedAt) {
        this.emailVerifiedAt = emailVerifiedAt;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getMarriageStatus() {
        return marriageStatus;
    }

    public void setMarriageStatus(String marriageStatus) {
        this.marriageStatus = marriageStatus;
    }

    public String getCommittment() {
        return committment;
    }

    public void setCommittment(String committment) {
        this.committment = committment;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getRememberToken() {
        return rememberToken;
    }

    public void setRememberToken(String rememberToken) {
        this.rememberToken = rememberToken;
    }

}