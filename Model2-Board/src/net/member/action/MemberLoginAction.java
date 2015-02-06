package net.member.action;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.member.action.ActionForward;
import net.board.db.MemberBean;
import net.board.db.MemberDAO;


public class MemberLoginAction implements Action{
	public ActionForward execute(HttpServletRequest request ,HttpServletResponse response)throws Exception{
		ActionForward forward = new ActionForward();
		
		HttpSession session = request.getSession();
		MemberDAO memberdao = new MemberDAO();
		MemberBean member = new MemberBean();
		
		int result = -1;
		
		member.setID(request.getParameter("ID"));
		member.setPASSWORD(request.getParameter("PASSWORD"));
		
		result = memberdao.isMember(member);
		
		//비밀번호 불일치
		if(result==0){
			response.setContentType("text/html;charset=euc-kr");
			PrintWriter out = response.getWriter();
			out.println("<script type='text/javascript'>");
			out.println("alert('비밀번호가 일치하지 않습니다..');");
			out.println("location.href='./MemberLogin.me';");
			out.println("</script>");
			out.close();
			return null;
			//아이디가 없습니다.
		}else if(result==-1){
			response.setContentType("text/html;charset=euc-kr");
			PrintWriter out = response.getWriter();
			out.println("<script type='text/javascript'>");
			out.println("alert('아이디가 존재하지 않습니다.');");
			out.println("location.href='./MemberLogin.me';");
			out.println("</script>");
			out.close();
			return null;
		}
		//로그인 성공!
		 session.setAttribute("id", member.getID());
		 
		 forward.setRedirect(true);
		 forward.setPath("./BoardList.do");
		 return forward;
	}
}
