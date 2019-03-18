package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import yoo.board.*;

public class DeleteProAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		  String pageNum=request.getParameter("pageNum");//BoardDTO의 멤버변수가 X
		  String passwd=request.getParameter("passwd");
		  int num=Integer.parseInt(request.getParameter("num"));
		  System.out.println("num=>"+num+",passwd=>"+passwd+",pageNum=>"+pageNum);
		  
		  BoardDAO dbPro=new BoardDAO();
		  int check=dbPro.deleteArticle(num,passwd);//암호찾고->웹상의 암호체크
		  
		  //공유
		  request.setAttribute("pageNum", pageNum);
		  request.setAttribute("check", check);
		  
		return "/deletePro.jsp";//경로포함해서 이동할 페이지
	}
}

