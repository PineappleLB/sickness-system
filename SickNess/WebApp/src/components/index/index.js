import React, { Component } from 'react';
import { Carousel, Menu, Row, Col } from 'antd';
import img1 from '../../images/1.jpg';
import img2 from '../../images/2.jpg';
import img3 from '../../images/3.jpg';
import './index.css';
import Clock from '../clock/clock';

class Index extends Component {

    state = {

    }

    render() {

        return (
            <div>
                <Row>
                    <Col span={6} className="left">
                        <div className="clock">
                            <Clock />
                        </div>
                        <Carousel autoplay>
                            <div><img src={img1} /></div>
                            <div><img src={img2} /></div>
                            <div><img src={img3} /></div>
                        </Carousel>
                    </Col>
                    <Col span={18} className="right">
                        <div className="news">
                            <div>最新监测消息：</div>
                            <div className="news-list">
                                <div>
                                    <p>123123123123123</p>
                                </div>
                                <div>
                                    <p>123123123123123</p>
                                </div>
                                <div>
                                    <p>123123123123123</p>
                                </div>
                            </div>
                        </div>
                    </Col>
                </Row>

            </div>
        )
    }

}

export default Index;