package net.board.action;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;

import net.board.db.BoardDAO;
import net.board.db.BoardBean;

public class BoardReplyView implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("euc-kr");
		ActionForward forward = new ActionForward();
		
		BoardDAO boarddao = new BoardDAO();
		BoardBean boarddata = new BoardBean();
		
		int num = Integer.parseInt(request.getParameter("num"));
		
		boarddata = boarddao.getDetail(num);
		
		if(boarddata==null){
			System.out.println("답장페이지 이동 실패 ");
			return null;
		}
		System.out.println("답장페이지 이동 완료");
		
		request.setAttribute("boarddata", boarddata);
		
		forward.setRedirect(false);
		forward.setPath("./board/qna_board_reply.jsp");
		
		return forward;
	}
}
