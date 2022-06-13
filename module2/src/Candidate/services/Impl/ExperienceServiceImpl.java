package Candidate.services.Impl;

import Candidate.common.CheckException;
import Candidate.model.Candidate;
import Candidate.model.Certificate;
import Candidate.model.Experience;
import Candidate.services.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ExperienceServiceImpl implements Service {
    static List<Experience> experienceList = new ArrayList<>();

    @Override
    public void display() {
//private Integer candiDateID;
//    private String fullName;
//    private String birthDay;
//    private String phone;
//    private String email;
//    private String candidateType;
//    private String canidateCount
        //private Double expInYear;
        //    private String proSkill;
        System.out.print("Nhập id ứng viên: ");
        int candiDateID = CheckException.checkparseInt();
        System.out.print("Nhập ngày sinh: ");
        String birthDay = CheckException.checkString();
        System.out.print("Nhập số điện thoại: ");
        String phone = CheckException.checkString();
        System.out.print("Nhập email: ");
        String email = CheckException.checkString();
        String candidateType = "Experience";
        int canidateCount = experienceList.size();




    }

    @Override
    public void add() {

    }

    @Override
    public void delete() {

    }

    @Override
    public void search() {

    }
}
