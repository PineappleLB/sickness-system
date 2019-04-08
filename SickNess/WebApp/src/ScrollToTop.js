import React from 'react';
import { withRouter } from 'react-router-dom';
import PropTypes from "proptypes";
import { message } from 'antd';
class ScrollToTop extends React.Component{

    componentWillUpdate(prevProps){
        let history = this.context.router.history;
        let userInfo = JSON.parse(sessionStorage.getItem("userInfo")) || {};
        let manager = JSON.parse(sessionStorage.getItem("managerInfo")) || {};
        let superManager = JSON.parse(sessionStorage.getItem("superManagerInfo")) || {};
        let logined = (!userInfo || JSON.stringify(userInfo)==='{}') ? false : true;
        logined = logined || !(!manager || JSON.stringify(manager)==='{}');
        logined = logined || !(!superManager || JSON.stringify(superManager)==='{}');
        // 如果不是前往登录页面，并且没有登录的状态，就跳转到登录的路由
        if(prevProps.location.pathname != "/login" && !logined){
            message.info("请先登录！");
            history.push("/login");
        }
    }

    componentDidUpdate(prevProps){
        if(this.props.location.pathname !== prevProps.location.pathname){
            window.scrollTo(0, 0);
        }
    }
    render(){
        return this.props.children;
    }
}
ScrollToTop.contextTypes = {
    router: PropTypes.object.isRequired
};
export default withRouter(ScrollToTop);