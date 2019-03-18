package action;

//기능은 다르지만 요청을 받아서 처리해주는 메서드를 공통의 메서드로 작성
//하기위해서 인터페이스를 작성
import javax.servlet.http.*;//HttpServletRequest,HttpServletResponse

public interface CommandAction {
    //이동할 페이지의 경로와 페이지명이 필요(요청에 따라서)->반환값->ModelAndView(스프링)
	public String requestPro(HttpServletRequest request,HttpServletResponse response)
	                                        throws Throwable;
}
