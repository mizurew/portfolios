package com.spring.mvc;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.mvc.board.BoardDao;
import com.spring.mvc.board.BoardDto;
import com.spring.mvc.business_doc.Business_doc_Dao;
import com.spring.mvc.business_doc.Business_doc_Dto;
import com.spring.mvc.drafting_doc.Drafting_Dao;
import com.spring.mvc.drafting_doc.Drafting_Dto;
import com.spring.mvc.email.DateFormatter;
import com.spring.mvc.email.DtoEmail;
import com.spring.mvc.email.IDaoEmail;
import com.spring.mvc.events.Events_Dao;
import com.spring.mvc.events.Events_Dto;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private SqlSession sqlSession;
	private HttpSession session;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "redirect:/login";
	}
	
	@RequestMapping("/index")
	public String main(Model model, HttpServletRequest request) throws SQLException, ParseException {
		session = request.getSession();
		
		Events_Dao eventdao = sqlSession.getMapper(Events_Dao.class);
		List<Events_Dto> events_list = eventdao.selectTodayEvent();
		model.addAttribute("events_list", events_list);
		
		
		BoardDao boardDao = sqlSession.getMapper(BoardDao.class);
		ArrayList<BoardDto> dto = boardDao.board_list_notice();
		model.addAttribute("board_list_notice", dto);
		
		
		Drafting_Dao draftingDao = sqlSession.getMapper(Drafting_Dao.class);
		String id = (String)session.getAttribute("member_id");
		int group_num = (Integer)session.getAttribute("group_num");
		int position_num = (Integer)session.getAttribute("position_num");
		List<Drafting_Dto> drafting_list = draftingDao.mainList(id, group_num, position_num);
		model.addAttribute("drafting_list", drafting_list);
		
		IDaoEmail dao = sqlSession.getMapper(IDaoEmail.class);
		
		Date day = new Date();
		SimpleDateFormat date1 = new SimpleDateFormat("yyyy,DDD,HH,mm,ss");
		String member_id = (String) session.getAttribute("member_id");
		List<DtoEmail> email_dto = dao.listRecentMail(member_id);
		String diffday ="";
		//최신메일 지난 시간 알려주는 포문
		for(int j=0;j<email_dto.size();j++) {
		String day1 = date1.format(day);
		String day2 = date1.format(email_dto.get(j).getMail_senddate());
		DateFormatter df = new DateFormatter();
		diffday = df.dateformats(day1, day2);
		email_dto.get(j).setLefted(diffday);
	}
		model.addAttribute("listRecentMail",email_dto);
		
		Business_doc_Dao business_dao = sqlSession.getMapper(Business_doc_Dao.class);
		List<Business_doc_Dto> business_list = business_dao.business_main_list(id, group_num, position_num);
		
		model.addAttribute("business_list",business_list);
		
		return "index";
	}
	
	@RequestMapping("/logout")
	public String member_logout(Model model, HttpServletRequest request) {
		session = request.getSession();
		if(session != null) {		
			session.invalidate();
		}
		return "redirect:/login";
	}
}
