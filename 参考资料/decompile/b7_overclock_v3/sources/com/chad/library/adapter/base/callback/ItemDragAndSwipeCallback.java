package com.chad.library.adapter.base.callback;

import android.graphics.Canvas;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.m;
import com.chad.library.R;
import com.chad.library.adapter.base.BaseItemDraggableAdapter;
import com.chad.library.adapter.base.DraggableController;
import com.chad.library.adapter.base.listener.IDraggableListener;
import g.n0;

/* JADX INFO: loaded from: classes2.dex */
public class ItemDragAndSwipeCallback extends m.f {
    private BaseItemDraggableAdapter mBaseItemDraggableAdapter;
    private IDraggableListener mDraggableListener;
    private float mMoveThreshold = 0.1f;
    private float mSwipeThreshold = 0.7f;
    private int mDragMoveFlags = 15;
    private int mSwipeMoveFlags = 32;

    public ItemDragAndSwipeCallback(BaseItemDraggableAdapter baseItemDraggableAdapter) {
        this.mBaseItemDraggableAdapter = baseItemDraggableAdapter;
    }

    private boolean isViewCreateByAdapter(@n0 RecyclerView.e0 e0Var) {
        int itemViewType = e0Var.getItemViewType();
        return itemViewType == 273 || itemViewType == 546 || itemViewType == 819 || itemViewType == 1365;
    }

    @Override // androidx.recyclerview.widget.m.f
    public void clearView(@n0 RecyclerView recyclerView, @n0 RecyclerView.e0 e0Var) {
        super.clearView(recyclerView, e0Var);
        if (isViewCreateByAdapter(e0Var)) {
            return;
        }
        View view = e0Var.itemView;
        int i10 = R.id.BaseQuickAdapter_dragging_support;
        if (view.getTag(i10) != null && ((Boolean) e0Var.itemView.getTag(i10)).booleanValue()) {
            BaseItemDraggableAdapter baseItemDraggableAdapter = this.mBaseItemDraggableAdapter;
            if (baseItemDraggableAdapter != null) {
                baseItemDraggableAdapter.onItemDragEnd(e0Var);
            } else {
                IDraggableListener iDraggableListener = this.mDraggableListener;
                if (iDraggableListener != null) {
                    iDraggableListener.onItemDragEnd(e0Var);
                }
            }
            e0Var.itemView.setTag(i10, Boolean.FALSE);
        }
        View view2 = e0Var.itemView;
        int i11 = R.id.BaseQuickAdapter_swiping_support;
        if (view2.getTag(i11) == null || !((Boolean) e0Var.itemView.getTag(i11)).booleanValue()) {
            return;
        }
        BaseItemDraggableAdapter baseItemDraggableAdapter2 = this.mBaseItemDraggableAdapter;
        if (baseItemDraggableAdapter2 != null) {
            baseItemDraggableAdapter2.onItemSwipeClear(e0Var);
        } else {
            IDraggableListener iDraggableListener2 = this.mDraggableListener;
            if (iDraggableListener2 != null) {
                iDraggableListener2.onItemSwipeClear(e0Var);
            }
        }
        e0Var.itemView.setTag(i11, Boolean.FALSE);
    }

    @Override // androidx.recyclerview.widget.m.f
    public float getMoveThreshold(@n0 RecyclerView.e0 e0Var) {
        return this.mMoveThreshold;
    }

    @Override // androidx.recyclerview.widget.m.f
    public int getMovementFlags(@n0 RecyclerView recyclerView, @n0 RecyclerView.e0 e0Var) {
        return isViewCreateByAdapter(e0Var) ? m.f.makeMovementFlags(0, 0) : m.f.makeMovementFlags(this.mDragMoveFlags, this.mSwipeMoveFlags);
    }

    @Override // androidx.recyclerview.widget.m.f
    public float getSwipeThreshold(@n0 RecyclerView.e0 e0Var) {
        return this.mSwipeThreshold;
    }

    @Override // androidx.recyclerview.widget.m.f
    public boolean isItemViewSwipeEnabled() {
        BaseItemDraggableAdapter baseItemDraggableAdapter = this.mBaseItemDraggableAdapter;
        if (baseItemDraggableAdapter != null) {
            return baseItemDraggableAdapter.isItemSwipeEnable();
        }
        IDraggableListener iDraggableListener = this.mDraggableListener;
        if (iDraggableListener != null) {
            return iDraggableListener.isItemSwipeEnable();
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.m.f
    public boolean isLongPressDragEnabled() {
        BaseItemDraggableAdapter baseItemDraggableAdapter = this.mBaseItemDraggableAdapter;
        if (baseItemDraggableAdapter != null) {
            return baseItemDraggableAdapter.isItemDraggable() && !this.mBaseItemDraggableAdapter.hasToggleView();
        }
        IDraggableListener iDraggableListener = this.mDraggableListener;
        return (iDraggableListener == null || !iDraggableListener.isItemDraggable() || this.mDraggableListener.hasToggleView()) ? false : true;
    }

    @Override // androidx.recyclerview.widget.m.f
    public void onChildDrawOver(@n0 Canvas canvas, @n0 RecyclerView recyclerView, @n0 RecyclerView.e0 e0Var, float f10, float f11, int i10, boolean z10) {
        super.onChildDrawOver(canvas, recyclerView, e0Var, f10, f11, i10, z10);
        if (i10 != 1 || isViewCreateByAdapter(e0Var)) {
            return;
        }
        View view = e0Var.itemView;
        canvas.save();
        if (f10 > 0.0f) {
            canvas.clipRect(view.getLeft(), view.getTop(), view.getLeft() + f10, view.getBottom());
            canvas.translate(view.getLeft(), view.getTop());
        } else {
            canvas.clipRect(view.getRight() + f10, view.getTop(), view.getRight(), view.getBottom());
            canvas.translate(view.getRight() + f10, view.getTop());
        }
        BaseItemDraggableAdapter baseItemDraggableAdapter = this.mBaseItemDraggableAdapter;
        if (baseItemDraggableAdapter != null) {
            baseItemDraggableAdapter.onItemSwiping(canvas, e0Var, f10, f11, z10);
        } else {
            IDraggableListener iDraggableListener = this.mDraggableListener;
            if (iDraggableListener != null) {
                iDraggableListener.onItemSwiping(canvas, e0Var, f10, f11, z10);
            }
        }
        canvas.restore();
    }

    @Override // androidx.recyclerview.widget.m.f
    public boolean onMove(@n0 RecyclerView recyclerView, @n0 RecyclerView.e0 e0Var, @n0 RecyclerView.e0 e0Var2) {
        return e0Var.getItemViewType() == e0Var2.getItemViewType();
    }

    @Override // androidx.recyclerview.widget.m.f
    public void onMoved(@n0 RecyclerView recyclerView, @n0 RecyclerView.e0 e0Var, int i10, @n0 RecyclerView.e0 e0Var2, int i11, int i12, int i13) {
        super.onMoved(recyclerView, e0Var, i10, e0Var2, i11, i12, i13);
        BaseItemDraggableAdapter baseItemDraggableAdapter = this.mBaseItemDraggableAdapter;
        if (baseItemDraggableAdapter != null) {
            baseItemDraggableAdapter.onItemDragMoving(e0Var, e0Var2);
            return;
        }
        IDraggableListener iDraggableListener = this.mDraggableListener;
        if (iDraggableListener != null) {
            iDraggableListener.onItemDragMoving(e0Var, e0Var2);
        }
    }

    @Override // androidx.recyclerview.widget.m.f
    public void onSelectedChanged(RecyclerView.e0 e0Var, int i10) {
        if (i10 == 2 && !isViewCreateByAdapter(e0Var)) {
            BaseItemDraggableAdapter baseItemDraggableAdapter = this.mBaseItemDraggableAdapter;
            if (baseItemDraggableAdapter != null) {
                baseItemDraggableAdapter.onItemDragStart(e0Var);
            } else {
                IDraggableListener iDraggableListener = this.mDraggableListener;
                if (iDraggableListener != null) {
                    iDraggableListener.onItemDragStart(e0Var);
                }
            }
            e0Var.itemView.setTag(R.id.BaseQuickAdapter_dragging_support, Boolean.TRUE);
        } else if (i10 == 1 && !isViewCreateByAdapter(e0Var)) {
            BaseItemDraggableAdapter baseItemDraggableAdapter2 = this.mBaseItemDraggableAdapter;
            if (baseItemDraggableAdapter2 != null) {
                baseItemDraggableAdapter2.onItemSwipeStart(e0Var);
            } else {
                IDraggableListener iDraggableListener2 = this.mDraggableListener;
                if (iDraggableListener2 != null) {
                    iDraggableListener2.onItemSwipeStart(e0Var);
                }
            }
            e0Var.itemView.setTag(R.id.BaseQuickAdapter_swiping_support, Boolean.TRUE);
        }
        super.onSelectedChanged(e0Var, i10);
    }

    @Override // androidx.recyclerview.widget.m.f
    public void onSwiped(@n0 RecyclerView.e0 e0Var, int i10) {
        if (isViewCreateByAdapter(e0Var)) {
            return;
        }
        BaseItemDraggableAdapter baseItemDraggableAdapter = this.mBaseItemDraggableAdapter;
        if (baseItemDraggableAdapter != null) {
            baseItemDraggableAdapter.onItemSwiped(e0Var);
            return;
        }
        IDraggableListener iDraggableListener = this.mDraggableListener;
        if (iDraggableListener != null) {
            iDraggableListener.onItemSwiped(e0Var);
        }
    }

    public void setDragMoveFlags(int i10) {
        this.mDragMoveFlags = i10;
    }

    public void setMoveThreshold(float f10) {
        this.mMoveThreshold = f10;
    }

    public void setSwipeMoveFlags(int i10) {
        this.mSwipeMoveFlags = i10;
    }

    public void setSwipeThreshold(float f10) {
        this.mSwipeThreshold = f10;
    }

    public ItemDragAndSwipeCallback(DraggableController draggableController) {
        this.mDraggableListener = draggableController;
    }
}
