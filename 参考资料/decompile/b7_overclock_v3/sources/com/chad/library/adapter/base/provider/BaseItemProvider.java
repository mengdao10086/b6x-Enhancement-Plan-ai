package com.chad.library.adapter.base.provider;

import android.content.Context;
import com.chad.library.adapter.base.BaseViewHolder;
import g.n0;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseItemProvider<T, V extends BaseViewHolder> {
    public Context mContext;
    public List<T> mData;

    public abstract void convert(@n0 V v10, T t10, int i10);

    public void convertPayloads(@n0 V v10, T t10, int i10, @n0 List<Object> list) {
    }

    public abstract int layout();

    public void onClick(V v10, T t10, int i10) {
    }

    public boolean onLongClick(V v10, T t10, int i10) {
        return false;
    }

    public abstract int viewType();
}
