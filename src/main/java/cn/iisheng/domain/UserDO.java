package cn.iisheng.domain;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * @author iisheng
 * @date 2018/03/20 20:41:46
 */
@Data
@Builder
@ToString
public class UserDO {
    private String id;
    private String name;
}
