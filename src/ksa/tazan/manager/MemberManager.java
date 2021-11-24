package ksa.tazan.manager;

import ksa.tazan.domain.Member;

import java.util.ArrayList;

public interface MemberManager {
    ArrayList<Member> showAllMembers();
    boolean registerMember();
    Member login(String id, String password);
    void logout();
    void updateMemberInfo(Member member);
    void quitMember(String id, String password);
    int updatePoints(int point, Member member);
    ArrayList<Member> showMemberRank(); //Rank 점수 내림차순, 아이디 오름차순으로 보여주기
}
