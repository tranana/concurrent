package pres.tran.underlying.seconds.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName(value = "manger_user")
@Data
public class MangerUser {

    /**
     * 主键
     */
    @TableId("user_id")
    private String userID;


    /**
     * 名称
     */
    @TableField("user_name")
    private String userName;

    /**
     * 名称
     */
    @TableField("user_phone")
    private String userPhone;

    /**
     * 名称
     */
    @TableField("user_password")
    private String userPassword;


    /**
     * 状态
     */
    @TableField("user_start")
    private String userStart;
}
