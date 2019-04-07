import React, { Component } from 'react';
import { Carousel, Menu, Row, Col, List } from 'antd';
import img1 from '../../images/1.jpg';
import img2 from '../../images/2.jpg';
import img3 from '../../images/3.jpg';
import './index.css';
import Clock from '../clock/clock';

class Index extends Component {

    state = {

    }

    render() {
        let list = [1,2,3,4,5,6]
        return (
            <div className="index">
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
                    <Col span={14} className="right">
                        <div className="news">
                            <div>最新监测消息：</div>
                            <List
                                className="demo-loadmore-list"
                                itemLayout="horizontal"
                                dataSource={list}
                                renderItem={item => (
                                    <List.Item extra={<span>| content</span>}>
                                            <List.Item.Meta
                                                description="Ant Design, a design language for background applications, is refined by Ant UED Team"
                                            />
                                            
                                    </List.Item>
                                )}
                            />
                        </div>
                    </Col>
                </Row>

            </div>
        )
    }

}

export default Index;