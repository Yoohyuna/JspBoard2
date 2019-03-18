package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import yoo.board.*;

import java.util.*;

// /list.do=action.ListAction 설정
public class ListAction2 implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		//1.Jsp에서 담당했던 자바의 코드를 여기에서 실행->자바코드 복사
		
		       int pageSize=5;//numPerPage->페이지당 보여주는 게시물수(=레코드수)->20개이상
		       int blockSize=3;//pagePerBlock->블럭당 보여주는 페이지수
		       
		    //페이징처리에 해당하는 환경설정을 마무리
		    //게시판을 맨 처음 실행시키면 무조건 1페이지부터 출력
		    String pageNum=request.getParameter("pageNum");
		    if(pageNum==null){
		    	pageNum="1";//default(무조건 1페이지는 선택하지 않아도 보여줘야 되기때문에)
		    }
		    int currentPage=Integer.parseInt(pageNum);//현재페이지->nowPage
		    //시작레코드번호 ->limit ?,?
		    //                  (1-1)*10+1=1,(2-1)*10+1=11,(3-1)*10+1=21
		    int startRow=(currentPage-1)*pageSize+1;		
		    int endRow=currentPage*pageSize;//1*10=10,2*10=20,3*10=30
		    int count=0;//총레코드수
		    int number=0;//beginPerPage->페이지별로 시작하는 맨 처음에 나오는 게시물 번호
		    List articleList=null;//화면에 출력할 레코드를 저장할 변수
		    
		    BoardDAO dbPro=new BoardDAO();
		    count=dbPro.getArticleCount();//select count(*) from board
		    System.out.println("현재 레코드수(count)=>"+count);
		    
		    if(count > 0){
		    	articleList=dbPro.getArticles(startRow, pageSize);//첫번째 레코드번호,불러올갯수
		    	                                                                       //endRow(X)
		    }else {
		    	articleList=Collections.EMPTY_LIST;//아무것도 없는 빈 list객체 반환
		    }
		    //            122-(1-1)*10=122,121,120,119,118,117,116,~
		    //            122-(2-1)*10=122-10=
		    number=count-(currentPage-1)*pageSize;
		    System.out.println("페이지별 number=>"+number);
	
		//2.request객체에 저장
		  request.setAttribute("currentPage", currentPage);//int->new Integer(currentPage)
		  request.setAttribute("startRow", startRow);
		  request.setAttribute("count", count);
		  request.setAttribute("pageSize", pageSize);
		  request.setAttribute("blockSize", blockSize);
		  request.setAttribute("number", number);
		  request.setAttribute("articleList", articleList); //${articleList}
		  
		//3.공유해서 이동할 수 있도록 설정
		return "/list.jsp";  // /board/list.jsp request.getAttribute("currentPage")=${currentPage}
	}
}



