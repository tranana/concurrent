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
     * 头像
     */
    @TableField("user_head")
    private String userHead;


    /**
     * 标识
     */
    @TableField("salt")
    private String salt;

    /**
     * 状态
     */
    @TableField("user_start")
    private String userStart;

    /**
     * 注册时间
     */
    @TableField("create_time")
    private String createTime;

    /**
     * 登录时间
     */
    @TableField("update_time")
    private String updateTime;

}
