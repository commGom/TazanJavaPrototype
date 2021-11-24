package ksa.tazan.domain;

import java.util.ArrayList;

public class MemberList {
    private static ArrayList<Member> memberList=new ArrayList<>();


    public static void addMember(Member member){
        memberList.add(member);
    }

    public static ArrayList<Member> getMemberList(){
        return memberList;
    }


}
