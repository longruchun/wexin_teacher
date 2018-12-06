package com.test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Date;

import org.junit.Test;

import com.entity.TestMessage;
import com.util.CheckUtil;
import com.util.Message;

public class mytest {

	//@Test
	public static void main(String[] args) {
		/*String[] arr=new String[3];
		
		arr[0]="hello";
		arr[1]="20170813204812";	
		arr[2]="123456";
		
		Arrays.sort(arr);
		
	   StringBuffer sb=new StringBuffer();
 	   for(String s:arr){
 		   sb.append(s);
 	   }
 	   //4.使用sha1加密
 	   String temp=CheckUtil.getSha1(sb.toString());
 	   
 	   System.out.println(temp);*/
		
	  TestMessage message=new TestMessage();
	  
	  message.setContent("ilovejava");
	  message.setCreateTime(new Date().getTime());
	  message.setFromUserName("obCpIv1q05A_-_FDB0coo1ljaw0s");
	  message.setToUserName("gh_dd519d296bd4");
	  message.setMsgId("1234567890");
	  message.setMsgType("text");
	  
	  try {
		String str=Message.objectToXml(message);
		  System.out.println(str);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
				
				
	}

}
