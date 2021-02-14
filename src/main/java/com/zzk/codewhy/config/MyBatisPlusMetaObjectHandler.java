package com.zzk.codewhy.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.zzk.codewhy.common.constant.TableConstants;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * MyBatisPlus自动填充 创建时间和更新时间
 *
 * @author zzk
 * @create 2020-10-18 21:35
 */
@Component
public class MyBatisPlusMetaObjectHandler implements MetaObjectHandler {
    // 初始化数据的创建时间和修改时间
    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName(TableConstants.GMT_CREATE, LocalDateTime.now(), metaObject);
//        this.setFieldValByName(TableConstants.GMT_MODIFIED, LocalDateTime.now(), metaObject);
    }

    // 更新数据的修改时间
    @Override
    public void updateFill(MetaObject metaObject) {
//        this.setFieldValByName(TableConstants.GMT_MODIFIED, LocalDateTime.now(), metaObject);
    }
}
