package net.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.member.action.ActionForward;
import net.board.db.MemberBean;
import net.board.db.MemberDAO;

public class MemberidValidationAction implements Action{
	public ActionForward execute(HttpServletRequest request ,HttpServletResponse response)throws Exception{
		request.setCharacterEncoding("euc-kr");
		
		ActionForward forward = new ActionForward();
		
		MemberDAO memberdao = new MemberDAO();
		MemberBean member = new MemberBean();
		
		member.setID(request.getParameter("ID"));
		
		System.out.println("test" +request.getParameter("ID") );
		
		int result = 0;
		
		
		result = memberdao.idValidation(member);
		
		if(result==0){
			System.out.println("아이디 중복 확인 실패");
			return null;
		}
		
		forward.setRedirect(true);
		forward.setPath("./MemberJoinAction.me");
		
		return forward;
	}
}
