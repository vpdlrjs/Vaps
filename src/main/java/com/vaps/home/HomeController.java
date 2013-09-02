package com.vaps.home;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.vaps.userclass.EncryptionEncoding;
import com.vaps.dao.MembersDAO;
import com.vaps.bean.Members;
import com.vaps.action.BoardListAction;
import com.vaps.action.MembersAction;


/**
 * Handles requests for the application home page.
 */
@Controller
@SessionAttributes("members") // members라는 세션영역에 저장
							  // jsp에서 ${members.id} 이런식으로 세션영역의 변수를 호출할 수 있다. sessionScope.members.id 대신함
public class HomeController {
	private HttpSession session;
	
	// mybatis-context.xml 에서 연결되었다.
	@Resource(name="membersDao") //@Autowired 도 왼쪽과  같은 자동주입이나 권장하지 않는 방법이다. 가능하면 @Resource를 쓰라
	private MembersDAO membersDao;

	
	// 암호화, 자동주입 등록(mybatis-context.xml에서)
	//private EncryptionEncoding ee = new EncryptionEncoding();
	@Resource(name="EncryptionEncoding")
	//@Resource(name="EE") //네임으로 설정으로 가능하다.
	
	private EncryptionEncoding ee;
	
	
// URL
// 기능별로 폴더를 나누어 작업할 것이니 리턴 경로를 확인하자!
//--------------------------------------------------------------
// 메뉴 관리
	@RequestMapping(value="/")
	public String home(){
		return "home";
	}
	@RequestMapping(value="/join")
	public String join(){
		//join 파일 위치가 /WEB-INF/views/login/join.jsp 이다.
		return "login/join";
	}
	
	@RequestMapping(value="/login")
	public String login(){
		return "login/login";
	}

	@RequestMapping(value="/what")
	public String what(){
		return "about/what";
	}
	
	@RequestMapping(value="/developer")
	public String developer(){
		return "about/developer";
	}
	
//--------------------------------------------------------------
// 회원 관리
	//회원가입
	@RequestMapping(value="/memJoin") 
	public String memJoin(HttpServletRequest request,Model model){
		String result="join";
		Members mb=new Members();
		
		try{
			request.setCharacterEncoding("UTF-8");
			mb.setM_id(request.getParameter("id"));
			mb.setM_nick(request.getParameter("nick"));
			mb.setM_pwd(ee.TripleDesEncoding(request.getParameter("pwd"))); // 패스워드 인코딩
			mb.setM_phone(request.getParameter("phone"));
			mb.setM_addr(request.getParameter("addr"));

			MembersAction ma=new MembersAction(membersDao);
			result = ma.memInsert(mb);
			model.addAttribute("check", 1);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	
	// login 성공
	@RequestMapping(value="access")
	public String mInfo(HttpServletRequest request, Model model) throws Exception{
		String result="home";
		
		Members members=new Members();
		
		Map<String,String> map=new HashMap<String, String>();
		map.put("id", request.getParameter("id"));
		//DB에 저장된 패스워드가 암호화가 되어 있어 로그인할때 똑같이 암호화한뒤 저장된 패스워드랑 비교해야한다.
		map.put("pwd", ee.TripleDesEncoding(request.getParameter("pwd")));
		try{
			MembersAction ma=new MembersAction(membersDao);
			members=ma.accessMembers(map);
			
			if(members!=null){
				session=request.getSession();
				session.setAttribute("uid", members.getM_id());
				model.addAttribute("members",members);
				boardList(request,model); // 로그인 뒤에 게시판으로 직행하지 않게함
			}else{
				if(session != null){ session=null;}
			}
		} catch(Exception e){
			e.printStackTrace();
		}

		return result;
	}

//--------------------------------------------------------------
// 게시판 작업
	//게시판(질답용도)
	@RequestMapping(value="/board")
	public String boardList(HttpServletRequest request, Model model){
		String result="home";
		
		try{
			BoardListAction ba=new BoardListAction(membersDao);
			
			if(session!=null && session.getAttribute("uid")!=""){
				session=request.getSession();
				
				int pageNum=(request.getParameter("pageNum")!=null)? Integer.parseInt(request.getParameter("pageNum")):1;
				
				// paging 관련 로직
				model.addAttribute("pageNum", pageNum);
				model.addAttribute("blist",ba.getBoardList(pageNum)); //게시글
				model.addAttribute("paging",ba.getPaging(pageNum)); //[1][2]...<- paging
				result="board/boardlist";
			}
		} catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	//게시글 보기
	@RequestMapping(value="/contents")
	public String listContents(HttpServletRequest request, Model model){
		String result="contents";
		BoardListAction ba=new BoardListAction(membersDao);
		try{
			if(session!=null && session.getAttribute("uid")!=""){
				int bnum= Integer.parseInt(request.getParameter("idx"));
				model.addAttribute("blist", ba.getContents(bnum)); //원글 보기
				result="board/boardContents";
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}

}
