package com.adder.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author adder
 * @since 2021-01-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("user_log")
@ApiModel(value="UserLog对象", description="")
public class UserLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer userid;

    private String username;

    private Integer lastloginip;

    private LocalDateTime lastlogintime;


}
