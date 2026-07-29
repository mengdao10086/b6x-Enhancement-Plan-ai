package com.chad.library.adapter.base.diff;

import androidx.recyclerview.widget.t;
import com.chad.library.adapter.base.BaseQuickAdapter;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
public final class BaseQuickAdapterListUpdateCallback implements t {

    @n0
    private final BaseQuickAdapter mAdapter;

    public BaseQuickAdapterListUpdateCallback(@n0 BaseQuickAdapter baseQuickAdapter) {
        this.mAdapter = baseQuickAdapter;
    }

    @Override // androidx.recyclerview.widget.t
    public void onChanged(int i10, int i11, @p0 Object obj) {
        BaseQuickAdapter baseQuickAdapter = this.mAdapter;
        baseQuickAdapter.notifyItemRangeChanged(i10 + baseQuickAdapter.getHeaderLayoutCount(), i11, obj);
    }

    @Override // androidx.recyclerview.widget.t
    public void onInserted(int i10, int i11) {
        BaseQuickAdapter baseQuickAdapter = this.mAdapter;
        baseQuickAdapter.notifyItemRangeInserted(i10 + baseQuickAdapter.getHeaderLayoutCount(), i11);
    }

    @Override // androidx.recyclerview.widget.t
    public void onMoved(int i10, int i11) {
        BaseQuickAdapter baseQuickAdapter = this.mAdapter;
        baseQuickAdapter.notifyItemMoved(i10 + baseQuickAdapter.getHeaderLayoutCount(), i11 + this.mAdapter.getHeaderLayoutCount());
    }

    @Override // androidx.recyclerview.widget.t
    public void onRemoved(int i10, int i11) {
        BaseQuickAdapter baseQuickAdapter = this.mAdapter;
        baseQuickAdapter.notifyItemRangeRemoved(i10 + baseQuickAdapter.getHeaderLayoutCount(), i11);
    }
}
