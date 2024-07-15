package com.example.demo;

import java.util.ArrayList;
import java.util.Optional;

public class LoginClass{
	private ArrayList<MemberInfoClass>memberList = null;
	
	LoginClass(){
		memberList = new ArrayList<>();
		MemberInfoClass memberInfo = new MemberInfoClass();
		memberInfo.setId("hong");
		memberInfo.setName("홍길동");
		memberInfo.setPassword("hong1234");
		
		MemberInfoClass memberInfo2 = new MemberInfoClass();
		memberInfo2.setId("min");
		memberInfo2.setName("민경민");
		memberInfo2.setPassword("min1234");
		
		MemberInfoClass memberInfo3 = new MemberInfoClass();
		memberInfo3.setId("lee");
		memberInfo3.setName("이");
		memberInfo3.setPassword("lee1234");
		
		memberList.add(memberInfo);
		memberList.add(memberInfo2);
		memberList.add(memberInfo3);
		
	}
	public boolean login(MemoRepository memoDao, String userid, String userPassword) {
		//boolean isFinding = false;
		Long findCount = memoDao.countByUseridAndPassword(userid, userPassword);
		if(findCount <= 0) {
			return false;
		}else {
			return true;
		}
		
			}
		
	
	public boolean logout() {
		return true;
	}
}