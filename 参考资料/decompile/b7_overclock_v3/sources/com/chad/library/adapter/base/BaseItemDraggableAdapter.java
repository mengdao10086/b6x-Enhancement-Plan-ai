package com.chad.library.adapter.base;

import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.b0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.m;
import com.chad.library.R;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.listener.OnItemDragListener;
import com.chad.library.adapter.base.listener.OnItemSwipeListener;
import g.n0;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseItemDraggableAdapter<T, K extends BaseViewHolder> extends BaseQuickAdapter<T, K> {
    private static final String ERROR_NOT_SAME_ITEMTOUCHHELPER = "Item drag and item swipe should pass the same ItemTouchHelper";
    private static final int NO_TOGGLE_VIEW = 0;
    public boolean itemDragEnabled;
    public boolean itemSwipeEnabled;
    public boolean mDragOnLongPress;
    public m mItemTouchHelper;
    public OnItemDragListener mOnItemDragListener;
    public OnItemSwipeListener mOnItemSwipeListener;
    public View.OnLongClickListener mOnToggleViewLongClickListener;
    public View.OnTouchListener mOnToggleViewTouchListener;
    public int mToggleViewId;

    public BaseItemDraggableAdapter(List<T> list) {
        super(list);
        this.mToggleViewId = 0;
        this.itemDragEnabled = false;
        this.itemSwipeEnabled = false;
        this.mDragOnLongPress = true;
    }

    private boolean inRange(int i10) {
        return i10 >= 0 && i10 < this.mData.size();
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
        return e0Var.getAdapterPosition() - getHeaderLayoutCount();
    }

    public boolean hasToggleView() {
        return this.mToggleViewId != 0;
    }

    public boolean isItemDraggable() {
        return this.itemDragEnabled;
    }

    public boolean isItemSwipeEnable() {
        return this.itemSwipeEnabled;
    }

    public void onItemDragEnd(RecyclerView.e0 e0Var) {
        OnItemDragListener onItemDragListener = this.mOnItemDragListener;
        if (onItemDragListener == null || !this.itemDragEnabled) {
            return;
        }
        onItemDragListener.onItemDragEnd(e0Var, getViewHolderPosition(e0Var));
    }

    public void onItemDragMoving(RecyclerView.e0 e0Var, RecyclerView.e0 e0Var2) {
        int viewHolderPosition = getViewHolderPosition(e0Var);
        int viewHolderPosition2 = getViewHolderPosition(e0Var2);
        if (inRange(viewHolderPosition) && inRange(viewHolderPosition2)) {
            if (viewHolderPosition < viewHolderPosition2) {
                int i10 = viewHolderPosition;
                while (i10 < viewHolderPosition2) {
                    int i11 = i10 + 1;
                    Collections.swap(this.mData, i10, i11);
                    i10 = i11;
                }
            } else {
                for (int i12 = viewHolderPosition; i12 > viewHolderPosition2; i12--) {
                    Collections.swap(this.mData, i12, i12 - 1);
                }
            }
            notifyItemMoved(e0Var.getAdapterPosition(), e0Var2.getAdapterPosition());
        }
        OnItemDragListener onItemDragListener = this.mOnItemDragListener;
        if (onItemDragListener == null || !this.itemDragEnabled) {
            return;
        }
        onItemDragListener.onItemDragMoving(e0Var, viewHolderPosition, e0Var2, viewHolderPosition2);
    }

    public void onItemDragStart(RecyclerView.e0 e0Var) {
        OnItemDragListener onItemDragListener = this.mOnItemDragListener;
        if (onItemDragListener == null || !this.itemDragEnabled) {
            return;
        }
        onItemDragListener.onItemDragStart(e0Var, getViewHolderPosition(e0Var));
    }

    public void onItemSwipeClear(RecyclerView.e0 e0Var) {
        OnItemSwipeListener onItemSwipeListener = this.mOnItemSwipeListener;
        if (onItemSwipeListener == null || !this.itemSwipeEnabled) {
            return;
        }
        onItemSwipeListener.clearView(e0Var, getViewHolderPosition(e0Var));
    }

    public void onItemSwipeStart(RecyclerView.e0 e0Var) {
        OnItemSwipeListener onItemSwipeListener = this.mOnItemSwipeListener;
        if (onItemSwipeListener == null || !this.itemSwipeEnabled) {
            return;
        }
        onItemSwipeListener.onItemSwipeStart(e0Var, getViewHolderPosition(e0Var));
    }

    public void onItemSwiped(RecyclerView.e0 e0Var) {
        int viewHolderPosition = getViewHolderPosition(e0Var);
        if (inRange(viewHolderPosition)) {
            this.mData.remove(viewHolderPosition);
            notifyItemRemoved(e0Var.getAdapterPosition());
            OnItemSwipeListener onItemSwipeListener = this.mOnItemSwipeListener;
            if (onItemSwipeListener == null || !this.itemSwipeEnabled) {
                return;
            }
            onItemSwipeListener.onItemSwiped(e0Var, viewHolderPosition);
        }
    }

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
            this.mOnToggleViewLongClickListener = new View.OnLongClickListener() { // from class: com.chad.library.adapter.base.BaseItemDraggableAdapter.1
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    BaseItemDraggableAdapter baseItemDraggableAdapter = BaseItemDraggableAdapter.this;
                    m mVar = baseItemDraggableAdapter.mItemTouchHelper;
                    if (mVar == null || !baseItemDraggableAdapter.itemDragEnabled) {
                        return true;
                    }
                    mVar.E((RecyclerView.e0) view.getTag(R.id.BaseQuickAdapter_viewholder_support));
                    return true;
                }
            };
        } else {
            this.mOnToggleViewTouchListener = new View.OnTouchListener() { // from class: com.chad.library.adapter.base.BaseItemDraggableAdapter.2
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (b0.c(motionEvent) != 0) {
                        return false;
                    }
                    BaseItemDraggableAdapter baseItemDraggableAdapter = BaseItemDraggableAdapter.this;
                    if (baseItemDraggableAdapter.mDragOnLongPress) {
                        return false;
                    }
                    m mVar = baseItemDraggableAdapter.mItemTouchHelper;
                    if (mVar == null || !baseItemDraggableAdapter.itemDragEnabled) {
                        return true;
                    }
                    mVar.E((RecyclerView.e0) view.getTag(R.id.BaseQuickAdapter_viewholder_support));
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

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.g
    public void onBindViewHolder(@n0 K k10, int i10) {
        View view;
        super.onBindViewHolder((BaseViewHolder) k10, i10);
        int itemViewType = k10.getItemViewType();
        if (this.mItemTouchHelper == null || !this.itemDragEnabled || itemViewType == 546 || itemViewType == 273 || itemViewType == 1365 || itemViewType == 819 || !hasToggleView() || (view = k10.getView(this.mToggleViewId)) == null) {
            return;
        }
        view.setTag(R.id.BaseQuickAdapter_viewholder_support, k10);
        if (this.mDragOnLongPress) {
            view.setOnLongClickListener(this.mOnToggleViewLongClickListener);
        } else {
            view.setOnTouchListener(this.mOnToggleViewTouchListener);
        }
    }

    public void enableDragItem(@n0 m mVar, int i10, boolean z10) {
        this.itemDragEnabled = true;
        this.mItemTouchHelper = mVar;
        setToggleViewId(i10);
        setToggleDragOnLongPress(z10);
    }

    public BaseItemDraggableAdapter(int i10, List<T> list) {
        super(i10, list);
        this.mToggleViewId = 0;
        this.itemDragEnabled = false;
        this.itemSwipeEnabled = false;
        this.mDragOnLongPress = true;
    }
}
