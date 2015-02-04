package net.board.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;

import net.board.db.*;

//글삭제 관련 Action 
public class BoardDeleteAction implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		ActionForward forward = new ActionForward();
		request.setCharacterEncoding("euc-kr");
		
		boolean result = false;
		boolean usercheck = false;
		int num = Integer.parseInt(request.getParameter("num"));
		
		BoardDAO boarddao = new BoardDAO();
		usercheck=boarddao.isBoardWriter(num, request.getParameter("BOARD_PASS"));
		
		if(usercheck==false){
			response.setContentType("text/html;charset=euc-kr");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('삭제할 권한이 없습니다.');");
			out.println("location.href='./BoardList.do';");
			out.println("</script>");
			out.close();
			return null;
			
		}
		
		result = boarddao.boardDelete(num);
		if(result ==false){
			System.out.println("게시판 삭제 실패");
			return null;
		}
		System.out.println("게시판 삭제 성공");
		forward.setRedirect(true);
		forward.setPath("./BoardList.do");
		return forward;
	}

}
