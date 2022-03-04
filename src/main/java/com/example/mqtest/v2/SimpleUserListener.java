package com.example.mqtest.v2;

import com.coeuy.osp.rmq.adepts.annotation.RmqConsumer;
import com.coeuy.osp.rmq.adepts.common.MessageResult;
import com.coeuy.osp.rmq.adepts.consumer.MessageProcess;
import com.coeuy.osp.rmq.adepts.producer.SimpleSender;
import com.example.mqtest.model.User;
import lombok.extern.slf4j.Slf4j;

/**
 * v2 直接砍掉 init 方法
 * 简单的注解声明消费
 */
@Slf4j
@RmqConsumer(queue = "user-simple")
public class SimpleUserListener implements MessageProcess<User> {

    /**
     * 消息在这里处理
     *
     * @param user
     * @return
     */
    @Override
    public MessageResult process(User user) {
        log.info("用户ID:{} 变更:{}", user.getId(), user);
        return MessageResult.success();
    }

}
