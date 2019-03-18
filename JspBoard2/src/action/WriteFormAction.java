package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WriteFormAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		 //1.jsp에서 처리해야할 자바코드를 대신처리해주는 역할->결과 전달->jsp전달
	      //list.jsp(글쓰기)->신규글, content.jsp(글상세보기)->글쓰기->답변글
	      int num=0,ref=1,re_step=0,re_level=0; //writePro.jsp
	      
	      //content.jsp에서 매개변수가 전달()
	      if(request.getParameter("num")!=null){//양수(음수,0은 아니다)
	    	 num=Integer.parseInt(request.getParameter("num"));//"3"->3
	    	 ref=Integer.parseInt(request.getParameter("ref"));
	    	 re_step=Integer.parseInt(request.getParameter("re_step"));
	    	 re_level=Integer.parseInt(request.getParameter("re_level"));
	    	 System.out.println("content.jsp에서 넘어온 매개변수 확인");
	    	 System.out.println("num=>"+num+",ref="+ref+
	    			                                 ",re_step="+re_step+",re_level=>"+re_level);
	      }
	      //2.실행결과(변수선언,매개변수,메서드의 실행결과물)->request영역에 저장
	      request.setAttribute("num", num);//request.getAttribute("num")->${num}
	      request.setAttribute("ref", ref);
	      request.setAttribute("re_step", re_step);
	      request.setAttribute("re_level", re_level);
	      
		return "/writeForm.jsp";
	}

}


