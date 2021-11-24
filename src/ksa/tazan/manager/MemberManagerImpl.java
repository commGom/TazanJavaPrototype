package ksa.tazan.manager;

import ksa.tazan.domain.Member;
import ksa.tazan.domain.MemberList;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class MemberManagerImpl implements MemberManager{
    ArrayList<Member> members;

    public MemberManagerImpl() {
        members=MemberList.getMemberList();
    }

    @Override
    public ArrayList<Member> showAllMembers() {
        members.sort(new Comparator<Member>() {
            @Override
            public int compare(Member o1, Member o2) {
                return o1.getNickName().compareTo(o2.getNickName());
            }
        });
        return members;
    }

    @Override
    public boolean registerMember() {
        Scanner scan=new Scanner(System.in);
        System.out.println("회원가입 페이지 입니다.");
        System.out.print("ID 입력 : ");
        String memberId=scan.nextLine();
        System.out.print("닉네임 입력 : ");
        String nickName=scan.nextLine();
        System.out.print("비밀번호 입력 : ");
        String password=scan.nextLine();
        Member member=new Member(memberId,nickName,password);
        if (member!=null){
            MemberList.addMember(member);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Member login(String id, String password) {
        for (Member member:members) {
            if (member.getMemberId().equals(id) && member.getPassword().equals(password))
                return member;
        }
        return null;
    }

    @Override
    public void logout() {

    }

    @Override
    public void updateMemberInfo(Member member) {

    }

    @Override
    public void quitMember(String id, String password) {

    }

    @Override
    public int updatePoints(int point, Member member) {
        return 0;
    }

    @Override
    public ArrayList<Member> showMemberRank() {
        members.sort(new Comparator<Member>() {
            @Override
            public int compare(Member o1, Member o2) {
                if(o1.getPoint()<o2.getPoint()) {
                    return 1;
                }else if(o1.getPoint()>o2.getPoint()){
                    return -1;
                }else{
                    return o1.getNickName().compareTo(o2.getNickName());
                }
            }
        });
        return members;
    }
}
