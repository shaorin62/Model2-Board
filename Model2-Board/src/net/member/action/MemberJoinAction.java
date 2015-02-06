package net.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.member.action.ActionForward;
import net.board.db.MemberBean;
import net.board.db.MemberDAO;


public class MemberJoinAction implements Action{
	public ActionForward execute(HttpServletRequest request ,HttpServletResponse response)throws Exception{
		request.setCharacterEncoding("euc-kr");
		
		
		ActionForward forward = new ActionForward();
		
		MemberDAO memberdao = new MemberDAO();
		MemberBean member = new MemberBean();
		
		boolean result = false;
		
		
		member.setID(request.getParameter("ID"));
		member.setPASSWORD(request.getParameter("PASSWORD"));
		member.setNAME(request.getParameter("NAME"));
		member.setAGE(Integer.parseInt(request.getParameter("AGE")));
		member.setGENDER(request.getParameter("GENDER"));
		member.setEMAIL(request.getParameter("EMAIL"));
		
		
		result = memberdao.joinMember(member);
		
		if(result==false){
			System.out.println(" 회원가입 실패 ");
			return null;
		}
		
		//회원가입 성공
		forward.setRedirect(true);
		forward.setPath("./MemberLogin.me");
		return forward;

	}
}
