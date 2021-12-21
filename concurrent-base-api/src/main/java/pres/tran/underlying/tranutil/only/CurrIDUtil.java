package pres.tran.underlying.tranutil.only;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CurrIDUtil {

    /**
     * 雪花算法生成唯一ID
     */
    private static final Snowflake snowflake = new Snowflake(1000000,1000000);


    public static Long getSnowflake(){
        return snowflake.nextId();
    }


}
