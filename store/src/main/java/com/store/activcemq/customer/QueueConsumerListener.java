/*
package com.store.activcemq.customer;

import com.alibaba.fastjson.JSONObject;
import com.store.activcemq.dao.ConsumerDao;
import com.store.activcemq.entity.QueueInfo;
import com.store.util.JsonUtils;
import com.store.util.StringUtil;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Component
public class QueueConsumerListener {
    @Resource
    private ConsumerDao consumerDao;
    //queue模式的消费者
    @JmsListener(destination="${spring.jms.queue-name}", containerFactory="queueListener")
    public void readActiveQueue(String message) {
JSONObject jsonObject = JSONObject.parseObject(message);

        QueueInfo queueInfo;
queueInfo = JSONObject.toJavaObject(jsonObject,QueueInfo.class);

        queueInfo = JsonUtils.fromJson(message,QueueInfo.class);
        queueInfo.setCode(StringUtil.getCommonCode(2));
        queueInfo.setContext(message);
        int count = consumerDao.addMessage(queueInfo);
        if(count > 0){
            System.out.println("queue接受到："+ message);
        }
    }
}
*/
