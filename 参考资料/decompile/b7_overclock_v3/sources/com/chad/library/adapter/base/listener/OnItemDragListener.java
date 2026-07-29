package com.chad.library.adapter.base.listener;

import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes2.dex */
public interface OnItemDragListener {
    void onItemDragEnd(RecyclerView.e0 e0Var, int i10);

    void onItemDragMoving(RecyclerView.e0 e0Var, int i10, RecyclerView.e0 e0Var2, int i11);

    void onItemDragStart(RecyclerView.e0 e0Var, int i10);
}
