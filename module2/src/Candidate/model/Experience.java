package Candidate.model;

public class Experience extends Candidate {
    private Double expInYear;
    private String proSkill;

    public Experience() {
    }

    public Experience(Double expInYear, String proSkill) {
        this.expInYear = expInYear;
        this.proSkill = proSkill;
    }

    public Double getExpInYear() {
        return expInYear;
    }

    public void setExpInYear(Double expInYear) {
        this.expInYear = expInYear;
    }

    public String getProSkill() {
        return proSkill;
    }

    public void setProSkill(String proSkill) {
        this.proSkill = proSkill;
    }

    @Override
    public String toString() {
        return "Experience-" + super.toString() +
                ", expInYear: " + expInYear +
                ", proSkill: " + proSkill;
    }
}
