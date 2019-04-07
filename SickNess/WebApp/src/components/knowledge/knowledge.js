import React, { Component } from 'react';
import img1 from '../../images/pic1.jpg';
import img2 from '../../images/pic2.jpg';
import img3 from '../../images/pic3.jpg';
import img4 from '../../images/pic4.jpg';
import img5 from '../../images/pic5.jpg';
import { List, Row, Col } from 'antd';

class knowledge extends Component {

    render() {
        const listData = [];
        listData.push({
            title: `牙齿变白`,
            avatar: img1,
            description: '刷牙时在牙膏上加上一点小苏达，刷三次后牙齿洁白如玉，牙锈自然脱落。牙痛绝招：用桃仁放在火上烧热以后放在牙痛上咬，如此几次永不牙痛。',
        });
        listData.push({
            title: `防蚊虫`,
            avatar: img2,
            description: '可以在垃圾桶的垃圾上撒点洗衣粉，这样也是可以防治滋生蚊虫的；同样，可以把茶叶渣倒在垃圾上来防蚊虫；垃圾桶底部放一层不用的纸，用来防治垃圾底部的水渍。',
        });
        listData.push({
            title: `清洁厨房`,
            avatar: img3,
            description: '厨房油烟比较多，一般清洁厨房最头疼的就是清洁油渍。可以用面包擦拭瓷砖上的油渍；可以用热盐水来疏通堵塞的下水道。',
        });
        listData.push({
            title: `清洗喷头`,
            avatar: img4,
            description: '常用洗澡喷头的朋友会发现，喷头会被水垢堵塞。可以在喷头上喷点白醋，然后用塑料袋包住喷头，隔一晚，第二天用清水冲洗即可。',
        });
        listData.push({
            title: `保鲜肉`,
            avatar: img5,
            description: '为了吃到新鲜的肉肉，可以将买回来的肉用被醋浸泡过的布子包住放在冰箱里，这样可以保鲜一夜。',
        });
        return (
            <div className="knowledge">
                <Row>
                    <Col span={18} offset={3}>
                        <List
                            itemLayout="vertical"
                            size="large"
                            dataSource={listData}
                            renderItem={item => (
                                <List.Item
                                    key={item.title}
                                    // extra={<img width={272} alt="logo" src={item.avatar} />}
                                >
                                    <List.Item.Meta
                                        title={item.title}
                                        description={item.description}
                                    />
                                    <img width={272} alt="logo" src={item.avatar}/>
                                </List.Item>
                            )}
                        />
                    </Col>
                </Row>
            </div>
        )
    }
}

export default knowledge;