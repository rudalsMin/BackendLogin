package com.example.demo;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {	
	
	@Autowired
	private MemoRepository memoDao;
	
	@Autowired
	private BookInfoRepository bookDao;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index(HttpServletRequest request) {
		return "index";
	}
	
	@RequestMapping(value="/loginok", method=RequestMethod.GET)
	public String loginok(HttpServletRequest request, HttpSession session) {
		String userId = (String)session.getAttribute("loginok");
		Optional<Memo> result = memoDao.findByUserid(userId);
		Memo resultMemo = result.get();
		
		request.setAttribute("current", userId);
		request.setAttribute("addr", resultMemo.getAddr());
		return "logged";
	}
	//회원가입 요청하는 메서드
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String joinStart(HttpServletRequest request) {
		//요청으로부터 사용자 id와 비밀번호를 가져옴
		String userId = request.getParameter("id");
		String userPassword = request.getParameter("password");
		String addr = request.getParameter("addr");
		//Memo객체를 builder 패턴을 사용하여 생성
		Memo memo = Memo.builder()
						.userid(userId)
						.password(userPassword)
						.addr(addr)
						.build();
		//Memo객체를 DB에 저장
		memoDao.save(memo);
		//회원가입 완료 페이지로 이동
		return "complete";
		
		}		
	//로그인 요청하는 메서드
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginStart(HttpServletRequest request) {
		String userId = request.getParameter("id");
		String userPassword = request.getParameter("password");
		Memo resultMemo = memoDao.findByUserid(userId);
		
		LoginClass loginClass = new LoginClass();
		if (loginClass.login(memoDao,userId, userPassword) == true) {
			request.setAttribute("current", userId);
			request.setAttribute("addr",  resultMemo.getAddr());
			return "logged";
		} else {
			return "fail";
		}		
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logoutCall(HttpServletRequest request) {
		LoginClass loginClass = new LoginClass();
		loginClass.logout();
		return "logout";
	}
	
	@RequestMapping(value="/deleteMember", method=RequestMethod.GET)
	public String deleteMember(HttpServletRequest request) {
		String userId = request.getParameter("userid");
		String userPassword = request.getParameter("password");
		
	
		Memo memo = memoDao.findByUserid(userId);
		
		if(memo != null && userPassword.equals(memo.getPassword())) {
			memoDao.deleteByUserid(userId);
			return"deleteMember";
		}else {
			request.setAttribute(userId, userPassword);
			
			System.out.println(memo.getPassword());
			return "deleteCheck";
		}
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String deletePage(HttpServletRequest request) {
		
		String userId = request.getParameter("userid");
		request.setAttribute("current", userId);
		return "deleteCheck";
		
	}
	
	
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String update(HttpServletRequest request) {
		String userId = request.getParameter("id");
		String userPassword = request.getParameter("password");
		String addr = request.getParameter("addr");
		
		Memo result = memoDao.findByUserid(userId);
		
		result.setPassword(userPassword);
		result.setAddr(addr);
		
		
		memoDao.save(result);
		return "update";
		
	}
	
	@RequestMapping(value="/insertbook", method=RequestMethod.GET)
	public String bookInsert(HttpServletRequest request) {
		String name = request.getParameter("name");
		String isbn = request.getParameter("isbn");
		String author = request.getParameter("author");
		String date = request.getParameter("publishDate");
		String info = request.getParameter("info");
		
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate publishDate = LocalDate.parse(date);
		
		bookinfo bookInfo = bookinfo.builder()
				.name(name)
				.isbn(isbn)
				.author(author)
				.publishDate(publishDate)
				.info(info)
				.build();
		bookDao.save(bookInfo);
		return"complete_book";
}
	
	@RequestMapping(value="/deleteBook", method=RequestMethod.GET)
	public String deleteBook(HttpServletRequest request) {
		String id = request.getParameter("id");
		Long delId = Long.parseLong(id);
		bookDao.deleteById(delId);
		List<bookinfo> result = bookDao.findAll(Sort.by(Sort.Direction.DESC, "id"));
		request.setAttribute("bookList", result);
		return "book_list";
	}
	
	@RequestMapping(value="/search", method=RequestMethod.GET)
	public String search(HttpServletRequest request) {
		String searchText = request.getParameter("searchText");
		List<bookinfo>result = bookDao.findByNameContainig(searchText);
		request.setAttribute("bookList", result);
		return "book_list";
	}
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String bookList(HttpServletRequest request) {
		List<bookinfo> result = bookDao.findAll(Sort.by(Sort.Direction.DESC, "id"));
		request.setAttribute("bookList", result);
		return "book_list";
	}
}
	





