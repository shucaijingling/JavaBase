package com.shucai.handle;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    /**
     * 插入时填充
     *
     * @param metaObject 元对象
     */
    @Override
    public void insertFill(MetaObject metaObject) {

        //获取注解的字段的值
        String field = "version";
        Object version = getFieldValByName(field, metaObject);
        if (null == version) {
            setFieldValByName(field, 1, metaObject  );
        }
    }

    /**
     * 更新时填充
     *
     * @param metaObject 元对象
     */
    @Override
    public void updateFill(MetaObject metaObject) {

    }
}
