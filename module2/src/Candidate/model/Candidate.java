package Candidate.model;

public abstract class Candidate {
    //CandidateID, FullName, BirthDay, Phone, Email, Candidate_type, Canidate_count
    private Integer candiDateID;
    private String fullName;
    private String birthDay;
    private String phone;
    private String email;
    private String candidateType;
    private Integer canidateCount;

    public Candidate() {
    }

    public Candidate(Integer candiDateID, String fullName, String birthDay, String phone, String email, String candidateType, Integer canidateCount) {
        this.candiDateID = candiDateID;
        this.fullName = fullName;
        this.birthDay = birthDay;
        this.phone = phone;
        this.email = email;
        this.candidateType = candidateType;
        this.canidateCount = canidateCount;
    }

    public Integer getCandiDateID() {
        return candiDateID;
    }

    public void setCandiDateID(Integer candiDateID) {
        this.candiDateID = candiDateID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCandidateType() {
        return candidateType;
    }

    public void setCandidateType(String candidateType) {
        this.candidateType = candidateType;
    }

    public Integer getCanidateCount() {
        return canidateCount;
    }

    public void setCanidateCount(Integer canidateCount) {
        this.canidateCount = canidateCount;
    }

    @Override
    public String toString() {
        return " candidateID: " + candiDateID +
                ", fullName: " + fullName +
                ", birthDay: " + birthDay +
                ", phone: " + phone +
                ", email: " + email +
                ", candidateType: " + candidateType +
                ", canidateCount: " + canidateCount;
    }
}
