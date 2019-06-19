/*
 * ************************************************************
 * 文件：ScopeInactiveException.java  模块：bus-lib  项目：component
 * 当前修改时间：2019年04月23日 18:23:19
 * 上次修改时间：2019年04月13日 08:43:55
 * 作者：Cody.yi   https://github.com/codyer
 *
 * 描述：bus-lib
 * Copyright (c) 2019
 * ************************************************************
 */

package com.cody.component.bus.lib.exception;

import com.cody.component.lib.exception.BaseException;

/**
 * Created by xu.yi. on 2019/3/31.
 * scope未激活
 */
public class ScopeInactiveException extends BaseException {
    private static final long serialVersionUID = -9041702601234976446L;

    public ScopeInactiveException() {
        super("使用的scope未激活，事件无法监听和发送");
    }
}
