package com.sickness.advice;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

/**
 * 用户session管理类
 *
 * @author pineapple
 * @create 2019/3/5
 */
@Service("userSessionManager")
public class UserSessionManager {

    private ConcurrentHashMap<String, String> userSessionMap = new ConcurrentHashMap<String, String>();

    private ConcurrentHashMap<String, HttpSession> sessionMap = new ConcurrentHashMap<String, HttpSession>();

    public void putSession(String userId, String sessionId) {
        userSessionMap.put(userId, sessionId);
    }

    public void deleteSession(String sessionId) {
        String key = null;
        for (Map.Entry<String, String> entre : userSessionMap.entrySet()) {
            String val = entre.getValue();
            if (sessionId.equals(val)) {
                key = entre.getKey();
                break;
            }

        }
        if (key != null) {
            userSessionMap.remove(key);
        }
    }

    public String getUserIdBySessionId(String sessionId) {
        String key = null;
        for (Map.Entry<String, String> entre : userSessionMap.entrySet()) {
            String val = entre.getValue();
            if (sessionId.equals(val)) {
                key = entre.getKey();
                break;
            }

        }
        return key;
    }

    public String getSessionIdByUserId(String userId) {
        return userSessionMap.get(userId);
    }

    public void addSession(HttpSession session) {
        sessionMap.put(session.getId(), session);
    }

    public void destorySession(String sessionId) {
        HttpSession sess = sessionMap.get(sessionId);
        if (sess != null) {
            try {
                sess.invalidate();
            } catch (Exception e) {

            }
        }
    }

    public void handleMorePeopleLogin(String currrentSessionId, String userId) {
        String sessionId = this.getSessionIdByUserId(userId);
        // 上次用戶登陸的sessionid
        if (sessionId != null && !sessionId.equals(currrentSessionId)) {
            this.destorySession(sessionId);
        }
        this.putSession(userId, currrentSessionId);
    }

}
