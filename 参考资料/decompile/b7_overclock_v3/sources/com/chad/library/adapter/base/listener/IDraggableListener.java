package com.chad.library.adapter.base.listener;

import android.graphics.Canvas;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes2.dex */
public interface IDraggableListener {
    boolean hasToggleView();

    boolean isItemDraggable();

    boolean isItemSwipeEnable();

    void onItemDragEnd(RecyclerView.e0 e0Var);

    void onItemDragMoving(RecyclerView.e0 e0Var, RecyclerView.e0 e0Var2);

    void onItemDragStart(RecyclerView.e0 e0Var);

    void onItemSwipeClear(RecyclerView.e0 e0Var);

    void onItemSwipeStart(RecyclerView.e0 e0Var);

    void onItemSwiped(RecyclerView.e0 e0Var);

    void onItemSwiping(Canvas canvas, RecyclerView.e0 e0Var, float f10, float f11, boolean z10);
}
