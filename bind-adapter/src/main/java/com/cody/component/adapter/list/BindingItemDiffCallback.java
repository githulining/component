/*
 * ************************************************************
 * 文件：BindingItemDiffCallback.java  模块：bind-adapter  项目：component
 * 当前修改时间：2019年04月04日 14:43:21
 * 上次修改时间：2019年04月04日 14:32:15
 * 作者：Cody.yi   https://github.com/codyer
 *
 * Copyright (c) 2019
 * ************************************************************
 */

package com.cody.component.adapter.list;

import com.cody.component.lib.data.ItemViewData;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

/**
 * Created by xu.yi. on 2019/4/4.
 * component
 */
public class BindingItemDiffCallback <Item extends ItemViewData> extends DiffUtil.ItemCallback<Item> {
    @Override
    public boolean areItemsTheSame(@NonNull Item oldItem, @NonNull Item newItem) {
        return oldItem.areItemsTheSame(newItem);
    }

    @Override
    public boolean areContentsTheSame(@NonNull Item oldItem, @NonNull Item newItem) {
        return oldItem.areContentsTheSame(newItem);
    }
}