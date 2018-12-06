package com.demoServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.dom4j.DocumentException;
import com.entity.TestMessage;
import com.test.Log4jTest;
import com.util.CheckUtil;
import com.util.Message;


public class wxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		//微信加密签名
		String signature=request.getParameter("signature");
		//时间戳
		String timestamp=request.getParameter("timestamp");
		//随机数
		String nonce=request.getParameter("nonce");
		//随机字符串
		String echostr=request.getParameter("echostr");
		
		Logger logger=Logger.getLogger(Log4jTest.class);
		logger.info("进入get：");
		
		logger.info("signature:" + signature + ",\n timestamp:" + timestamp + ",\n nonce:" + nonce + ", echostr:" + echostr);
		PrintWriter out=response.getWriter();
		if(CheckUtil.checkSignature(signature, timestamp, nonce)){
			//校验成功后，将得到的随机字符串原路返还
			out.print(echostr);
			logger.info("链接返回的字符："+echostr);
			logger.info("链接成功您可以使用！");
			
		}else{
			//out.print("error");
			logger.info("不是微信服务器发送的请求！！");
		}
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		        // TODO Auto-generated method stub				
			    request.setCharacterEncoding("UTF-8");
				response.setCharacterEncoding("UTF-8");
				PrintWriter out = response.getWriter();
				String str = null;
				try {
						//将request请求，传到Message工具类的转换方法中，返回接收到的Map对象
						Map<String, String> map = Message.xmlToMap(request);
						//从集合中，获取XML各个节点的内容
						String ToUserName = map.get("ToUserName");
						String FromUserName = map.get("FromUserName");
						String CreateTime = map.get("CreateTime");
						String MsgType = map.get("MsgType");
						String Content = map.get("Content");
						String MsgId = map.get("MsgId");
						
						
				
				
						if(MsgType.equals("text")){//判断消息类型是否是文本消息(text)
							
							TestMessage message = new TestMessage();
							message.setFromUserName(ToUserName);//原来【接收消息用户】变为回复时【发送消息用户】
							
							message.setToUserName(FromUserName);
							
							message.setMsgType("text");
							
							message.setCreateTime(new Date().getTime());//创建当前时间为消息时间
							
							//message.setContent("您好，"+FromUserName+"\n我是："+ToUserName+"\n您发送的消息类型为："+MsgType+"\n您发送的时间为"+CreateTime+"\n我回复的时间为："+message.getCreateTime()+"您发送的内容是"+Content);
							message.setContent("Ok.You can use it Now");
							str = Message.objectToXml(message); //调用Message工具类，将对象转为XML字符串
							
							System.out.println(str);
							
						
						}
				} catch (DocumentException e) {
				   e.printStackTrace();
				}	
				
				out.print(str); //返回转换后的XML字符串
				out.close();
				
	}

}
