package net.member.action;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.member.action.ActionForward;
import net.board.db.MemberBean;
import net.board.db.MemberDAO;

public class MemberDeleteAction implements Action{
	public ActionForward execute(HttpServletRequest request ,HttpServletResponse response)throws Exception{
	
		ActionForward forward = new ActionForward();
		HttpSession session = request.getSession();
		MemberDAO memberdao = new MemberDAO();
		
		boolean result = false;
		
		String id = (String)session.getAttribute("id");
		if(id==null){
			forward.setRedirect(true);
			forward.setPath("./MemberLogin.me");
			return forward;
		}else if(!id.equals("admin")){
			PrintWriter out = response.getWriter();
			out.println("<script type='text/javascript'>");
			out.println("alert('관리자가 아닙니다.');");
			out.println("location.href='./BoardList.do';");
			out.println("</script>");
			out.close();
			return null;
		}
		String deleteid = request.getParameter("id");
		result = memberdao.deleteMember(deleteid);
		
		if(result==false){
			System.out.println("회원삭제 실패");
			return null;
		}
		
		forward.setRedirect(true);
		forward.setPath("./MemberListAction.me");
		return forward;
	}
}
