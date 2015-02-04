package net.board.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;;

public class BoardFrontController 
	extends javax.servlet.http.HttpServlet
	implements javax.servlet.Servlet{
	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		String RequestURI = request.getRequestURI();
		String contextPath=request.getContextPath();
		String command=RequestURI.substring(contextPath.length());
		ActionForward forward = null;
		Action action = null;
		
		if(command.equals("/BoardWrite.do")){
			forward=new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./board/qna_board_write.jsp");
			
		}else if(command.equals("/BoardReplyAction.do")){
			action = new BoardReplyAction();
			try{
				forward =action.execute(request, response);
			}catch(Exception ex){
				ex.printStackTrace();
			}

		}else if(command.equals("/BoardDelete.do")){
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./board/qna_board_delete.jsp");

		}else if(command.equals("/BoardModify.do")){
			action = new BoardModifyView();
			try{
				forward =action.execute(request, response);
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}else if(command.equals("/BoardAddAction.do")){
			action = new BoardAddAction();
			try{
				forward = action.execute(request, response);
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}else if(command.equals("/BoardReplyView.do")){
			action = new BoardReplyView();
			try{
				forward = action.execute(request, response);
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}else if(command.equals("/BoardModifyAction.do")){
			action = new BoardModifyAction();
			try{
				forward = action.execute(request, response);
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}else if(command.equals("/BoardDeleteAction.do")){
			action = new BoardDeleteAction();
			try{
				forward = action.execute(request, response);
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}else if(command.equals("/BoardList.do")){
			action = new BoardListAction();
			try{
				forward = action.execute(request, response);
			}catch(Exception ex){
				ex.printStackTrace();
			}

		}else if(command.equals("/BoardDetailAction.do")){
			action = new BoardDetailAction();
			try{
				forward = action.execute(request, response);
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		if(forward != null){
			if(forward.isRedirect()){
				response.sendRedirect(forward.getPath());
			}else{
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		doProcess(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		doProcess(request,response);
	}
}


