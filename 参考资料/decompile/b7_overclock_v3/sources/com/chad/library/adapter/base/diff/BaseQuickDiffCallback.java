package com.chad.library.adapter.base.diff;

import androidx.recyclerview.widget.i;
import g.n0;
import g.p0;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseQuickDiffCallback<T> extends i.b {
    private List<T> newList;
    private List<T> oldList;

    public BaseQuickDiffCallback(@p0 List<T> list) {
        this.newList = list == null ? new ArrayList<>() : list;
    }

    @Override // androidx.recyclerview.widget.i.b
    public boolean areContentsTheSame(int i10, int i11) {
        return areContentsTheSame(this.oldList.get(i10), this.newList.get(i11));
    }

    public abstract boolean areContentsTheSame(@n0 T t10, @n0 T t11);

    @Override // androidx.recyclerview.widget.i.b
    public boolean areItemsTheSame(int i10, int i11) {
        return areItemsTheSame(this.oldList.get(i10), this.newList.get(i11));
    }

    public abstract boolean areItemsTheSame(@n0 T t10, @n0 T t11);

    @Override // androidx.recyclerview.widget.i.b
    @p0
    public Object getChangePayload(int i10, int i11) {
        return getChangePayload(this.oldList.get(i10), this.newList.get(i11));
    }

    @p0
    public Object getChangePayload(@n0 T t10, @n0 T t11) {
        return null;
    }

    public List<T> getNewList() {
        return this.newList;
    }

    @Override // androidx.recyclerview.widget.i.b
    public int getNewListSize() {
        return this.newList.size();
    }

    public List<T> getOldList() {
        return this.oldList;
    }

    @Override // androidx.recyclerview.widget.i.b
    public int getOldListSize() {
        return this.oldList.size();
    }

    public void setOldList(@p0 List<T> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        this.oldList = list;
    }
}
