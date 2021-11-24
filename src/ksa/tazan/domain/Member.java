package ksa.tazan.domain;

import java.util.ArrayList;

public class Member {
    private String memberId;
    private String nickName;
    private String password;
    private int point;
    private ArrayList<Quiz> wrongProblems=new ArrayList<>();

    public Member() {
    }

    public Member(String memberId, String nickName, String password) {
        this.memberId = memberId;
        this.nickName = nickName;
        this.password = password;
    }



    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public ArrayList<Quiz> getWrongProblems() {
        return wrongProblems;
    }

    public void setWrongProblems(ArrayList<Quiz> wrongProblems) {
        this.wrongProblems = wrongProblems;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberId='" + memberId + '\'' +
                ", nickName='" + nickName + '\'' +
                ", password='" + password + '\'' +
                ", point=" + point +
                ", wrongProblems=" + wrongProblems +
                '}';
    }
}
