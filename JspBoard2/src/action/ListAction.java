package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import yoo.board.*;

import java.util.*;

// /list.do=action.ListAction 설정
public class ListAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		    String pageNum=request.getParameter("pageNum");
		    //추가(검색분야,검색어)
		    String search=request.getParameter("search");
		    String searchtext=request.getParameter("searchtext");
		    
		    int count=0;//총레코드수
		    List articleList=null;//화면에 출력할 레코드를 저장할 변수
		    
		    BoardDAO dbPro=new BoardDAO();
		    count=dbPro.getArticleSearchCount(search, searchtext);//sql구문에 따라서 달라진다.
		    System.out.println("현재 검색된 레코드수(count)=>"+count);
		    
		    Hashtable<String,Integer> pgList=dbPro.pageList(pageNum, count);
		    
		    if(count > 0){
		    	System.out.println(pgList.get("startRow")+","+pgList.get("endRow"));
		    	articleList=dbPro.getBoardArticles(pgList.get("startRow"),
		    			                                          pgList.get("pageSize"),
		    			                                          search,searchtext);
		    }else {
		    	articleList=Collections.EMPTY_LIST;//아무것도 없는 빈 list객체 반환
		    }
		  
		//2.request객체에 저장
		  request.setAttribute("search", search);//검색분야
		  request.setAttribute("searchtext", searchtext);//검색어
		  request.setAttribute("pgList", pgList);//페이징처리 10개정보
		  request.setAttribute("articleList", articleList); //${articleList}
		  
		//3.공유해서 이동할 수 있도록 설정
		return "/list.jsp";  // /board/list.jsp request.getAttribute("currentPage")=${currentPage}
	}
}



