package com.mvc.friends.service;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.friends.dao.FriendsDAO;
import com.mvc.friends.dto.FriendsDTO;
import com.mvc.friends.dto.TourStyleDTO;
import com.mvc.msg.dao.MsgDAO;

public class FriendsService {

	private HttpServletRequest req = null;
	private HttpServletResponse resp = null;
	
	public FriendsService(HttpServletRequest req, HttpServletResponse resp) {
		this.req = req;
		this.resp = resp;
	}
	
	public boolean friendsAddOverlay(String loginemail, String friends_email) {
		boolean overlay = false;
		System.out.println("로그인 이메일: " + loginemail + " / " + "중복검사할 이메일: " + friends_email);
		if (friends_email.equals("") || friends_email.equals(loginemail)) {
			System.out.println("경고!! 추가할 친구의 이메일을 확인해 주세요!!");
			overlay = true;
		}else {
		FriendsDAO dao = new FriendsDAO();
		overlay = dao.friendsAddOverlay(loginemail, friends_email);
		dao.resClose();
		System.out.println("자원반납 했다!");
		}
		return overlay;
	}
	
	public int friendsAdd(String loginemail, String friends_email) {
		int success = 0;
		System.out.println("로그인 이메일: " + loginemail + " / " + "친구 추가할 이메일: " + friends_email);
		if (friends_email.equals("") || friends_email.equals(loginemail)) {
			System.out.println("경고!! 추가할 친구의 이메일을 확인해 주세요!!");
			success=0;
		}else {
		FriendsDAO dao = new FriendsDAO();
		success = dao.friendsAdd(loginemail, friends_email);
		dao.resClose();
		System.out.println("자원반납 했다!");
		}
		return success;
	}

	public int friendsDel(String loginemail, String friends_email) {
		int success = 0;
		System.out.println("로그인 이메일: " + loginemail + " / " + "친구 추가할 이메일: " + friends_email);
		if (friends_email.equals("") || friends_email.equals(loginemail)) {
			System.out.println("경고!! 삭제할 친구의 이메일을 확인해 주세요!!");
			success=0;
		}else {
		FriendsDAO dao = new FriendsDAO();
		success = dao.friendsDel(loginemail, friends_email);
		dao.resClose();
		System.out.println("자원반납 했다!");
		}
		return success;
	}

	public int friendsBlock(String loginemail, String friends_email) {
		int success = 0;
		System.out.println("로그인 이메일: " + loginemail + " / " + "차단할 친구 이메일: " + friends_email);
		if (friends_email.equals("") || friends_email.equals(loginemail)) {
			System.out.println("경고!! 차단할 친구의 이메일을 확인해 주세요!!");
			success=0;
		}else {
		FriendsDAO dao = new FriendsDAO();
		success = dao.friendsBlock(loginemail, friends_email);
		dao.resClose();
		System.out.println("자원반납 했다!");
		}
		return success;
	}

	public int friendsBlockCancle(String loginemail, String friends_email) {
		int success = 0;
		System.out.println("로그인 이메일: " + loginemail + " / " + "차단 해제할 친구 이메일: " + friends_email);
		if (friends_email.equals("") || friends_email.equals(loginemail)) {
			System.out.println("경고!! 차단 해제할 친구의 이메일을 확인해 주세요!!");
			success=0;
		}else {
		FriendsDAO dao = new FriendsDAO();
		success = dao.friendsBlockCancle(loginemail, friends_email);
		dao.resClose();
		System.out.println("자원반납 했다!");
		}
		return success;
	}

	public ArrayList<TourStyleDTO> friendsRecomend(String loginemail) {
		System.out.println("로그인 이메일: "+ loginemail);
		FriendsDAO dao = new FriendsDAO();
		ArrayList<TourStyleDTO> recomendList = dao.friendsRecomend(loginemail);
		dao.resClose();
		System.out.println("자원반납 했다!");
		return recomendList;
	}

	public HashMap<String, Object> friendsBlockList(String loginemail) {
		System.out.println("로그인 이메일: "+loginemail);
		
		String page = req.getParameter("page");
		FriendsDAO dao = new FriendsDAO();
		if(page==null) {
			page= "1";
		}
		System.out.println("현재 page: " + page);
		
		HashMap<String, Object> map = dao.friendsBlockList(Integer.parseInt(page), loginemail);
		dao.resClose();
		System.out.println("자원반납 했다!");
		return map;
	}
	
	public HashMap<String, Object> friendsList(String loginemail) {
		System.out.println("로그인 이메일: "+loginemail);
		
		String page = req.getParameter("page");
		FriendsDAO dao = new FriendsDAO();
		if(page==null) {
			page= "1";
		}
		System.out.println("현재 page: " + page);
		
		HashMap<String, Object> map = dao.friendsList(Integer.parseInt(page), loginemail);
		dao.resClose();
		System.out.println("자원반납 했다!");
		return map;
	}
	
	
	
	
	
	
	
} //class end