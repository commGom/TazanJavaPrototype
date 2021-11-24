import ksa.tazan.domain.Member;
import ksa.tazan.domain.MemberList;
import ksa.tazan.domain.Quiz;
import ksa.tazan.domain.QuizList;
import ksa.tazan.manager.MemberManager;
import ksa.tazan.manager.MemberManagerImpl;
import ksa.tazan.manager.QuizManager;
import ksa.tazan.manager.QuizManagerImpl;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        MemberManager memberManager=new MemberManagerImpl();
        QuizManager quizManager=new QuizManagerImpl();

        //로그인한 후 Member객체를 담을 변수 loginMember
        Member loginMember=null;

        ArrayList<Member> members= MemberList.getMemberList();
//        MemberList.addMember(new Member("m01","nick01","1234"));
//        MemberList.addMember(new Member("m02","nick02","1234"));
//        MemberList.addMember(new Member("m03","nick03","1234"));
//        MemberList.addMember(new Member("m04","nick04","1234"));
//        MemberList.addMember(new Member("m05","nick05","1234"));
//        for (Member member:members) {
//            System.out.println(member);
//        }
        ArrayList<Quiz> quizList= QuizList.getQuizList();
        QuizList.addQuiz(new Quiz(1,"q01","a01"));
        QuizList.addQuiz(new Quiz(2,"q02","a02"));
        QuizList.addQuiz(new Quiz(3,"q03","a03"));
        QuizList.addQuiz(new Quiz(4,"q04","a04"));
        QuizList.addQuiz(new Quiz(5,"q05","a05"));
        QuizList.addQuiz(new Quiz(6,"q06","a06"));
        QuizList.addQuiz(new Quiz(7,"q07","a07"));
        QuizList.addQuiz(new Quiz(8,"q08","a08"));
        QuizList.addQuiz(new Quiz(9,"q09","a09"));
        QuizList.addQuiz(new Quiz(10,"q10","a10"));
//        for (Quiz quiz:quizList) {
//            System.out.println(quiz);
//        }

        while (true){
            String type, memberId, nickName, password;
            //로그인을 하지 않았을 때, 회원가입 페이지와 로그인 페이지 나오도록
            if(loginMember==null){
                System.out.println("(회원가입, 로그인, 회원목록, 종료)");
                System.out.print("이용할 기능을 입력하세요 : ");
                type=scan.nextLine();
                switch (type){
                    case "회원가입":
                        if (memberManager.registerMember()){
                            System.out.println("회원가입 성공!!");
                        }else{
                            System.out.println("회원가입 실패");
                        }
                        break;
                    case "로그인":
                        System.out.println("로그인 페이지입니다.");
                        System.out.print("ID 입력 : ");
                        memberId=scan.nextLine();
                        System.out.print("비밀번호 입력 : ");
                        password=scan.nextLine();
                        loginMember=memberManager.login(memberId,password);
                        if (loginMember!=null){
                            System.out.println("로그인 성공!");
                        }else{
                            System.out.println("로그인 실패");
                        }
                        break;
                    case "회원목록":
                        System.out.println("회원 목록 페이지 (닉네임 오름차순 정렬)");
                        members=memberManager.showAllMembers();
                        for (Member member:members) {
                            System.out.println(member);
                        }
                        break;
                    case "종료":
                        System.out.println("프로그램 종료!");
                        return;
                }
            }else{
                //로그인 성공하였을 때,
                System.out.println("(로그아웃, 회원정보 수정, 회원탈퇴, 퀴즈, 랭킹, 종료)");
                System.out.print("이용할 기능을 입력하세요 : ");
                type=scan.nextLine();
                switch (type){
                    case "로그아웃":
                        System.out.print(String.format("%s 님이 로그아웃 하였습니다.",loginMember.getNickName()));
                        loginMember=null;
                        break;
                    case "회원정보 수정":
                        System.out.println("회원정보 수정 페이지입니다.");
                        System.out.println("변경할 정보를 선택하여 주세요.(숫자입력)");
                        System.out.println("1.닉네임 변경, 2.비밀번호 변경");
                        int select=Integer.parseInt(scan.nextLine());
                        switch (select){
                            case 1:
                                System.out.print("변경할 닉네임 입력 : ");
                                nickName=scan.nextLine();
                                System.out.println("변경 전 닉네임->"+loginMember.getNickName());
                                loginMember.setNickName(nickName);
                                System.out.println("변경 후 닉네임->"+loginMember.getNickName());
                                if (nickName.equals(loginMember.getNickName())){
                                    System.out.println("닉네임 변경 성공!");
                                }else{
                                    System.out.println("닉네임 변경 실패");
                                }
                                break;
                            case 2:
                                System.out.print("변경할 비밀번호 입력: ");
                                password=scan.nextLine();
                                System.out.println("변경 전 패스워드->"+loginMember.getPassword());
                                loginMember.setPassword(password);
                                System.out.println("변경 후 패스워드->"+loginMember.getPassword());
                                if (password.equals(loginMember.getPassword())){
                                    System.out.println("비밀번호 변경 성공!");
                                }else{
                                    System.out.println("비밀번호 변경 실패");
                                }
                                break;
                        }
                        break;  //회원정보 수정 switch break;
                    case "회원탈퇴":
                        System.out.println("회원 탈퇴 페이지 입니다. 본인 확인을 위한 아이디, 비밀번호 인증해주세요.");
                        System.out.print("탈퇴할 아아디 : ");
                        String checkId=scan.nextLine();
                        System.out.print("탈퇴할 비밀번호 :");
                        String checkPassword=scan.nextLine();
                        if (checkId.equals(loginMember.getMemberId())&&checkPassword.equals(loginMember.getPassword())){
                            memberManager.quitMember(checkId,checkPassword);
                            loginMember=null;
                            System.out.println("회원 탈퇴 완료!!");
                        }else{
                            System.out.println("잘못된 정보를 입력하셨습니다.");
                            System.out.println("탈퇴 실패");
                        }
                        break;
                    case "퀴즈":
                        System.out.println("퀴즈 페이지 입니다.");
                        int count=0;
                        for (int i = 0; i < quizList.size(); i++) {
                            int probNo=i+1;
                            Quiz quiz=quizList.get(i);
//                            System.out.println(String.format("%d번 문제 입니다.",probNo));
                            System.out.println(String.format("문제 %d :\n %s",probNo,quiz.getQuestion()));
                            System.out.print("답안 : ");
                            String myAnswer=scan.nextLine();
                            if (quizManager.solveQuiz(myAnswer,quiz)){
                                count++;
                            }else{
                                //틀린문제 기록
                                loginMember.getWrongProblems().add(quiz);
                            }
                        }
                        System.out.println("맞힌 갯수 : "+count);
                        loginMember.setPoint(loginMember.getPoint()+count);
                        System.out.println("현재 "+loginMember.getNickName()+"님의 누적 포인트 : "+loginMember.getPoint());
                        break;
                    case "랭킹":
                        members=memberManager.showMemberRank();
                        System.out.println("회원 랭킹 (점수 내림차순, 닉네임 오름차순 정렬)");
                        for (Member member:members) {
                            System.out.println(member);
                        }
                        break;
                    case "종료":
                        System.out.println("프로그램 종료!");
                        return;
                }
            }

        }
    }
}
