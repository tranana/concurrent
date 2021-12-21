package pres.tran.underlying.tranconfig.mq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pres.tran.underlying.common.CurrCommon;

@Configuration
public class RabbitQueue {


    @Bean
    public Queue messageQueue() {
        return new Queue(CurrCommon.CURR_QUEUE_MESSAGE);
    }



}
