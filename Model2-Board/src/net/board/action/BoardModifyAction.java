package net.board.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;

import net.board.db.BoardDAO;
import net.board.db.BoardBean;

//수정처리 Action
public class BoardModifyAction implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("euc-kr");
		ActionForward forward = new ActionForward();
		boolean result = false;
		
		int num = Integer.parseInt(request.getParameter("BOARD_NUM"));

		BoardDAO boarddao = new BoardDAO();
		BoardBean Boarddata = new BoardBean();
		
		
		boolean usercheck = boarddao.isBoardWriter(num, request.getParameter("BOARD_PASS"));
		
		
		if(usercheck==false){
			response.setContentType("text/html;charset=euc-kr");
			PrintWriter out = response.getWriter();
			out.println("<script type='text/javascript'>");
			out.println("alert('수정할 권한이 없습니다.');");
			out.println("location.href='./BoardList.do';");
			out.println("</script>");
			out.close();
			return null;
		}
		
		try{
			Boarddata.setBOARD_NUM(num);
			Boarddata.setBOARD_SUBJECT(request.getParameter("BOARD_SUBJECT"));
			Boarddata.setBOARD_CONTENT(request.getParameter("BOARD_CONTENT"));
			result =boarddao.boardModify(Boarddata);
			
			if(result ==false){
				System.out.println("게시판 수정 실패");
				return null;
			}
			System.out.println("게시판 수정 완료");
			
			forward.setRedirect(true);
			forward.setPath("./BoardDetailAction.do?num="+Boarddata.getBOARD_NUM());

			return forward; 

		}catch(Exception ex){
			ex.printStackTrace();
		}

		return null;
	}

}
