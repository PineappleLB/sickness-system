package com.sickness.advice;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 用户session监听
 *
 * @author pineapple
 * @create 2019/3/5
 */
@WebListener
public class HttpSessionLoginListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        Object obj = SpringUtils.getBean("userSessionManager");
        if (obj != null) {
            UserSessionManager userSessionManager = (UserSessionManager) obj;
            userSessionManager.addSession(se.getSession());
            se.getSession().setMaxInactiveInterval(-1);
        }
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        String sessionid = se.getSession().getId();
        Object obj = SpringUtils.getBean("userSessionManager");
        if (obj != null) {
            UserSessionManager userSessionManager = (UserSessionManager) obj;
            userSessionManager.deleteSession(sessionid);
        }
    }

}
