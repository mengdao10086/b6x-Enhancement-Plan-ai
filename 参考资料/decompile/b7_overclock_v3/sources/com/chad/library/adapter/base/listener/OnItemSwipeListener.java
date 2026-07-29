package com.chad.library.adapter.base.listener;

import android.graphics.Canvas;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes2.dex */
public interface OnItemSwipeListener {
    void clearView(RecyclerView.e0 e0Var, int i10);

    void onItemSwipeMoving(Canvas canvas, RecyclerView.e0 e0Var, float f10, float f11, boolean z10);

    void onItemSwipeStart(RecyclerView.e0 e0Var, int i10);

    void onItemSwiped(RecyclerView.e0 e0Var, int i10);
}
