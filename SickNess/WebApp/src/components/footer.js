import React, { Component } from 'react';
import "./footer.css"

class Footer extends Component{

    render() {
        return (
            <div className="footer">
                <p> 请勿IE浏览器或者IE内核浏览器，推荐使用谷歌Chrome浏览器或者火狐FireFox浏览器 </p>
                <p>©2019 区域疾病监控管理有限公司 <a href="http://www.miitbeian.gov.cn">蜀ICP备 18022685号-1</a></p>
            </div>
        );
    }

}
export default Footer;