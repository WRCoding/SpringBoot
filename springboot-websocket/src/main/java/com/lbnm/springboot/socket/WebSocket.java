package com.lbnm.springboot.socket;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author LB
 * @create 2019-05-01 9:17
 */
@Slf4j
@Component
@ServerEndpoint("/websocket/{userName}")
public class WebSocket {

    /**
     * 在线人数
     */
    public static int onlineNumber = 0;

    /**
     * 以用户的姓名为key，WebSocket为对象保存起来
     */
    private static Map<String,WebSocket> clients = new ConcurrentHashMap<>();

    /**
     * 会话
     */
    private Session session;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 建立连接
     * @param userName
     * @param session
     */
    @OnOpen
    public void onOpen(@PathParam("userName")String userName,Session session){
        onlineNumber++;
        log.info("现在来连接的客户id: "+session.getId()+" 用户名: "+userName);
        this.userName = userName;
        this.session = session;
        log.info("有新连接加入！当前在线人数 "+onlineNumber);
        try {
            //告诉所有人，userName上线了
            Map<String,Object> map = new HashMap<>();
            map.put("messageType",1 );
            map.put("userName",userName );
            sendMessageAll(JSON.toJSONString(map),userName);

            //把userName的信息加入到clients中
            clients.put(userName,this );
            //告诉userName现在都有谁在线
            Map<String,Object> map2 = new HashMap<>();
            map2.put("messageType",3 );
            Set<String> set = clients.keySet();
            map2.put("onlineUsers",set );
            sendMessageTo(JSON.toJSONString(map2),userName);
        }catch (Exception e){
            log.info(userName+"上线的时候通知所有人发生了错误");
        }
    }

    /**
     * 发生错误
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session,Throwable error){
        log.info("服务端发生了错误: "+error.getMessage());
    }

    /**
     * 关闭连接
     */
    @OnClose
    public void onClose(){
        onlineNumber--;
        clients.remove(userName);
        try {
            Map<String,Object> map = new HashMap<>();
            map.put("messageType",2 );
            map.put("onlineUsers",clients.keySet() );
            map.put("userName",userName );
            sendMessageAll(JSON.toJSONString(map),userName );
        }catch (Exception e){
            log.info(userName+"下线的时候通知所有人发生了错误");
        }
        log.info("有连接关闭！当前在线人数"+onlineNumber);
    }

    /**
     * 收到客户端的消息
     * @param message
     * @param session
     */
    @OnMessage
    public void onMessage(String message,Session session){
        try {
            log.info("来自客户端的消息: "+message+"客户端的id是: "+session.getId());
            JSONObject jsonObject = JSON.parseObject(message);
            String textMessage = jsonObject.getString("message");
            String fromUserName = jsonObject.getString("userName");
            String toUserName = jsonObject.getString("to");

            Map<String,Object> map = new HashMap<>();
            map.put("messageType",4 );
            map.put("textMessage",textMessage );
            map.put("fromUserName",fromUserName );

            if(toUserName.equals("All")){
                map.put("toUserName","所有人" );
                sendMessageAll(JSON.toJSONString(map),fromUserName );
            }else{
                map.put("toUserName",toUserName );
                sendMessageTo(JSON.toJSONString(map),toUserName );
            }
        }catch (Exception e){
            log.info("发生了错误");
        }
    }

    /**
     * 发送消息给指定的userName
     * @param message
     * @param toUserName
     */
    private void sendMessageTo(String message, String toUserName) {
        for (WebSocket webSocket : clients.values()) {
            if(webSocket.userName.equals(toUserName)){
                webSocket.session.getAsyncRemote().sendText(message);
                break;
            }
        }
    }

    /**发送消息给所有人
     *
     * @param message
     * @param fromUserName
     */
    private void sendMessageAll(String message, String fromUserName) {
        for (WebSocket webSocket : clients.values()) {
            webSocket.session.getAsyncRemote().sendText(message);
        }
    }

    /**
     * 返回在线人数
     * @return
     */
    public static  synchronized  int getOnlineNumber(){
        return onlineNumber;
    }
}
