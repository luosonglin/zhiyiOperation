package com.medmeeting.domain;

import java.util.Date;
import java.util.List;

/**
 * Created by luosonglin on 07/01/2017.
 */
public class UserAndCase {

    private Integer id;
    private Integer userId;
    private String title;
    private String tagId;
    private String chiefComplain;
    private String chiefComplainImage;
    private String bodyCheck;
    private String bodyCheckImage;
    private String medicalDiagnosis;//medical_diagnosis
    private String medicalDiagnosisImage;//medical_diagnosis_image
    private String followUp;
    private String followUpImage;
    private Integer commentCount;
    private Integer likeCount;
    private Date createdAt;
    private Date deletedAt;
    private Integer isHot;

    private String name;
    private String nickName;
    private String company;
    private String userPic;
    private String authenStatus;

    private List<String> chiefComplainImages;
    private List<String> bodyCheckImages;
    private List<String> medicalDiagnosisImages;
    private List<String> followUpImages;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTagId() {
        return tagId;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId;
    }

    public String getChiefComplain() {
        return chiefComplain;
    }

    public void setChiefComplain(String chiefComplain) {
        this.chiefComplain = chiefComplain;
    }

    public String getChiefComplainImage() {
        return chiefComplainImage;
    }

    public void setChiefComplainImage(String chiefComplainImage) {
        this.chiefComplainImage = chiefComplainImage;
    }

    public String getBodyCheck() {
        return bodyCheck;
    }

    public void setBodyCheck(String bodyCheck) {
        this.bodyCheck = bodyCheck;
    }

    public String getBodyCheckImage() {
        return bodyCheckImage;
    }

    public void setBodyCheckImage(String bodyCheckImage) {
        this.bodyCheckImage = bodyCheckImage;
    }

    public String getMedicalDiagnosis() {
        return medicalDiagnosis;
    }

    public void setMedicalDiagnosis(String medicalDiagnosis) {
        this.medicalDiagnosis = medicalDiagnosis;
    }

    public String getMedicalDiagnosisImage() {
        return medicalDiagnosisImage;
    }

    public void setMedicalDiagnosisImage(String medicalDiagnosisImage) {
        this.medicalDiagnosisImage = medicalDiagnosisImage;
    }

    public String getFollowUp() {
        return followUp;
    }

    public void setFollowUp(String followUp) {
        this.followUp = followUp;
    }

    public String getFollowUpImage() {
        return followUpImage;
    }

    public void setFollowUpImage(String followUpImage) {
        this.followUpImage = followUpImage;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }

    public Integer getIsHot() {
        return isHot;
    }

    public void setIsHot(Integer isHot) {
        this.isHot = isHot;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getUserPic() {
        return userPic;
    }

    public void setUserPic(String userPic) {
        this.userPic = userPic;
    }

    public String getAuthenStatus() {
        return authenStatus;
    }

    public void setAuthenStatus(String authenStatus) {
        this.authenStatus = authenStatus;
    }


    public List<String> getChiefComplainImages() {
        return chiefComplainImages;
    }

    public void setChiefComplainImages(List<String> chiefComplainImages) {
        this.chiefComplainImages = chiefComplainImages;
    }

    public List<String> getBodyCheckImages() {
        return bodyCheckImages;
    }

    public void setBodyCheckImages(List<String> bodyCheckImages) {
        this.bodyCheckImages = bodyCheckImages;
    }

    public List<String> getMedicalDiagnosisImages() {
        return medicalDiagnosisImages;
    }

    public void setMedicalDiagnosisImages(List<String> medicalDiagnosisImages) {
        this.medicalDiagnosisImages = medicalDiagnosisImages;
    }

    public List<String> getFollowUpImages() {
        return followUpImages;
    }

    public void setFollowUpImages(List<String> followUpImages) {
        this.followUpImages = followUpImages;
    }
}
