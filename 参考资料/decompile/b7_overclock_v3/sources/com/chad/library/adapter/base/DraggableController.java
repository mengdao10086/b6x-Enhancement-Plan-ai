package com.chad.library.adapter.base;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.b0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.m;
import com.chad.library.R;
import com.chad.library.adapter.base.listener.IDraggableListener;
import com.chad.library.adapter.base.listener.OnItemDragListener;
import com.chad.library.adapter.base.listener.OnItemSwipeListener;
import g.n0;
import java.util.Collections;

/* JADX INFO: loaded from: classes2.dex */
public class DraggableController implements IDraggableListener {
    private static final int NO_TOGGLE_VIEW = 0;
    private BaseQuickAdapter mAdapter;
    private m mItemTouchHelper;
    private OnItemDragListener mOnItemDragListener;
    private OnItemSwipeListener mOnItemSwipeListener;
    private View.OnLongClickListener mOnToggleViewLongClickListener;
    private View.OnTouchListener mOnToggleViewTouchListener;
    private int mToggleViewId = 0;
    private boolean itemDragEnabled = false;
    private boolean itemSwipeEnabled = false;
    private boolean mDragOnLongPress = true;

    public DraggableController(BaseQuickAdapter baseQuickAdapter) {
        this.mAdapter = baseQuickAdapter;
    }

    private boolean inRange(int i10) {
        return i10 >= 0 && i10 < this.mAdapter.getData().size();
    }

    public void disableDragItem() {
        this.itemDragEnabled = false;
        this.mItemTouchHelper = null;
    }

    public void disableSwipeItem() {
        this.itemSwipeEnabled = false;
    }

    public void enableDragItem(@n0 m mVar) {
        enableDragItem(mVar, 0, true);
    }

    public void enableSwipeItem() {
        this.itemSwipeEnabled = true;
    }

    public int getViewHolderPosition(RecyclerView.e0 e0Var) {
        return e0Var.getAdapterPosition() - this.mAdapter.getHeaderLayoutCount();
    }

    @Override // com.chad.library.adapter.base.listener.IDraggableListener
    public boolean hasToggleView() {
        return this.mToggleViewId != 0;
    }

    public void initView(BaseViewHolder baseViewHolder) {
        View view;
        int itemViewType = baseViewHolder.getItemViewType();
        if (this.mItemTouchHelper == null || !this.itemDragEnabled || itemViewType == 546 || itemViewType == 273 || itemViewType == 1365 || itemViewType == 819 || !hasToggleView() || (view = baseViewHolder.getView(this.mToggleViewId)) == null) {
            return;
        }
        view.setTag(R.id.BaseQuickAdapter_viewholder_support, baseViewHolder);
        if (this.mDragOnLongPress) {
            view.setOnLongClickListener(this.mOnToggleViewLongClickListener);
        } else {
            view.setOnTouchListener(this.mOnToggleViewTouchListener);
        }
    }

    @Override // com.chad.library.adapter.base.listener.IDraggableListener
    public boolean isItemDraggable() {
        return this.itemDragEnabled;
    }

    @Override // com.chad.library.adapter.base.listener.IDraggableListener
    public boolean isItemSwipeEnable() {
        return this.itemSwipeEnabled;
    }

    @Override // com.chad.library.adapter.base.listener.IDraggableListener
    public void onItemDragEnd(RecyclerView.e0 e0Var) {
        OnItemDragListener onItemDragListener = this.mOnItemDragListener;
        if (onItemDragListener == null || !this.itemDragEnabled) {
            return;
        }
        onItemDragListener.onItemDragEnd(e0Var, getViewHolderPosition(e0Var));
    }

    @Override // com.chad.library.adapter.base.listener.IDraggableListener
    public void onItemDragMoving(RecyclerView.e0 e0Var, RecyclerView.e0 e0Var2) {
        int viewHolderPosition = getViewHolderPosition(e0Var);
        int viewHolderPosition2 = getViewHolderPosition(e0Var2);
        if (inRange(viewHolderPosition) && inRange(viewHolderPosition2)) {
            if (viewHolderPosition < viewHolderPosition2) {
                int i10 = viewHolderPosition;
                while (i10 < viewHolderPosition2) {
                    int i11 = i10 + 1;
                    Collections.swap(this.mAdapter.getData(), i10, i11);
                    i10 = i11;
                }
            } else {
                for (int i12 = viewHolderPosition; i12 > viewHolderPosition2; i12--) {
                    Collections.swap(this.mAdapter.getData(), i12, i12 - 1);
                }
            }
            this.mAdapter.notifyItemMoved(e0Var.getAdapterPosition(), e0Var2.getAdapterPosition());
        }
        OnItemDragListener onItemDragListener = this.mOnItemDragListener;
        if (onItemDragListener == null || !this.itemDragEnabled) {
            return;
        }
        onItemDragListener.onItemDragMoving(e0Var, viewHolderPosition, e0Var2, viewHolderPosition2);
    }

    @Override // com.chad.library.adapter.base.listener.IDraggableListener
    public void onItemDragStart(RecyclerView.e0 e0Var) {
        OnItemDragListener onItemDragListener = this.mOnItemDragListener;
        if (onItemDragListener == null || !this.itemDragEnabled) {
            return;
        }
        onItemDragListener.onItemDragStart(e0Var, getViewHolderPosition(e0Var));
    }

    @Override // com.chad.library.adapter.base.listener.IDraggableListener
    public void onItemSwipeClear(RecyclerView.e0 e0Var) {
        OnItemSwipeListener onItemSwipeListener = this.mOnItemSwipeListener;
        if (onItemSwipeListener == null || !this.itemSwipeEnabled) {
            return;
        }
        onItemSwipeListener.clearView(e0Var, getViewHolderPosition(e0Var));
    }

    @Override // com.chad.library.adapter.base.listener.IDraggableListener
    public void onItemSwipeStart(RecyclerView.e0 e0Var) {
        OnItemSwipeListener onItemSwipeListener = this.mOnItemSwipeListener;
        if (onItemSwipeListener == null || !this.itemSwipeEnabled) {
            return;
        }
        onItemSwipeListener.onItemSwipeStart(e0Var, getViewHolderPosition(e0Var));
    }

    @Override // com.chad.library.adapter.base.listener.IDraggableListener
    public void onItemSwiped(RecyclerView.e0 e0Var) {
        OnItemSwipeListener onItemSwipeListener = this.mOnItemSwipeListener;
        if (onItemSwipeListener != null && this.itemSwipeEnabled) {
            onItemSwipeListener.onItemSwiped(e0Var, getViewHolderPosition(e0Var));
        }
        int viewHolderPosition = getViewHolderPosition(e0Var);
        if (inRange(viewHolderPosition)) {
            this.mAdapter.getData().remove(viewHolderPosition);
            this.mAdapter.notifyItemRemoved(e0Var.getAdapterPosition());
        }
    }

    @Override // com.chad.library.adapter.base.listener.IDraggableListener
    public void onItemSwiping(Canvas canvas, RecyclerView.e0 e0Var, float f10, float f11, boolean z10) {
        OnItemSwipeListener onItemSwipeListener = this.mOnItemSwipeListener;
        if (onItemSwipeListener == null || !this.itemSwipeEnabled) {
            return;
        }
        onItemSwipeListener.onItemSwipeMoving(canvas, e0Var, f10, f11, z10);
    }

    public void setOnItemDragListener(OnItemDragListener onItemDragListener) {
        this.mOnItemDragListener = onItemDragListener;
    }

    public void setOnItemSwipeListener(OnItemSwipeListener onItemSwipeListener) {
        this.mOnItemSwipeListener = onItemSwipeListener;
    }

    public void setToggleDragOnLongPress(boolean z10) {
        this.mDragOnLongPress = z10;
        if (z10) {
            this.mOnToggleViewTouchListener = null;
            this.mOnToggleViewLongClickListener = new View.OnLongClickListener() { // from class: com.chad.library.adapter.base.DraggableController.1
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    if (DraggableController.this.mItemTouchHelper == null || !DraggableController.this.itemDragEnabled) {
                        return true;
                    }
                    DraggableController.this.mItemTouchHelper.E((RecyclerView.e0) view.getTag(R.id.BaseQuickAdapter_viewholder_support));
                    return true;
                }
            };
        } else {
            this.mOnToggleViewTouchListener = new View.OnTouchListener() { // from class: com.chad.library.adapter.base.DraggableController.2
                @Override // android.view.View.OnTouchListener
                @SuppressLint({"ClickableViewAccessibility"})
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (b0.c(motionEvent) != 0 || DraggableController.this.mDragOnLongPress) {
                        return false;
                    }
                    if (DraggableController.this.mItemTouchHelper == null || !DraggableController.this.itemDragEnabled) {
                        return true;
                    }
                    DraggableController.this.mItemTouchHelper.E((RecyclerView.e0) view.getTag(R.id.BaseQuickAdapter_viewholder_support));
                    return true;
                }
            };
            this.mOnToggleViewLongClickListener = null;
        }
    }

    public void setToggleViewId(int i10) {
        this.mToggleViewId = i10;
    }

    public void enableDragItem(@n0 m mVar, int i10) {
        enableDragItem(mVar, i10, true);
    }

    public void enableDragItem(@n0 m mVar, int i10, boolean z10) {
        this.itemDragEnabled = true;
        this.mItemTouchHelper = mVar;
        setToggleViewId(i10);
        setToggleDragOnLongPress(z10);
    }
}
