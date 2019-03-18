package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteFormAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		
	     //content.jsp->삭제->/deleteForm.do?num=2&pageNum=1=>deletePro.jsp(deleteArticle)
	     int num=Integer.parseInt(request.getParameter("num"));
	     String pageNum=request.getParameter("pageNum");
	     System.out.println("deleteForm.do의 num="+num+",pageNum="+pageNum);
	
	     request.setAttribute("num", num);//삭제할 게시물번호
	     request.setAttribute("pageNum", pageNum);//삭제할 게시물이 있는 페이지정보
	     
		return "/deleteForm.jsp";
	}
}



