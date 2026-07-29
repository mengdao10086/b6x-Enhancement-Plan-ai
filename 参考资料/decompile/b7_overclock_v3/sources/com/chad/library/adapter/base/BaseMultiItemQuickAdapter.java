package com.chad.library.adapter.base;

import android.util.SparseIntArray;
import android.view.ViewGroup;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.IExpandable;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import g.f0;
import g.i0;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseMultiItemQuickAdapter<T extends MultiItemEntity, K extends BaseViewHolder> extends BaseQuickAdapter<T, K> {
    private static final int DEFAULT_VIEW_TYPE = -255;
    public static final int TYPE_NOT_FOUND = -404;
    private SparseIntArray layouts;

    public BaseMultiItemQuickAdapter(List<T> list) {
        super(list);
    }

    private int getLayoutId(int i10) {
        return this.layouts.get(i10, -404);
    }

    public void addItemType(int i10, @i0 int i11) {
        if (this.layouts == null) {
            this.layouts = new SparseIntArray();
        }
        this.layouts.put(i10, i11);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public int getDefItemViewType(int i10) {
        T t10 = this.mData.get(i10);
        return t10 != null ? t10.getItemType() : DEFAULT_VIEW_TYPE;
    }

    public int getParentPositionInAll(int i10) {
        List<T> data = getData();
        T item = getItem(i10);
        if (!isExpandable((MultiItemEntity) item)) {
            for (int i11 = i10 - 1; i11 >= 0; i11--) {
                if (isExpandable((MultiItemEntity) data.get(i11))) {
                    return i11;
                }
            }
            return -1;
        }
        IExpandable iExpandable = (IExpandable) item;
        for (int i12 = i10 - 1; i12 >= 0; i12--) {
            T t10 = data.get(i12);
            if (isExpandable((MultiItemEntity) t10) && iExpandable.getLevel() > ((IExpandable) t10).getLevel()) {
                return i12;
            }
        }
        return -1;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public K onCreateDefViewHolder(ViewGroup viewGroup, int i10) {
        return createBaseViewHolder(viewGroup, getLayoutId(i10));
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void remove(@f0(from = 0) int i10) {
        List<T> list = this.mData;
        if (list == null || i10 < 0 || i10 >= list.size()) {
            return;
        }
        T t10 = this.mData.get(i10);
        if (t10 instanceof IExpandable) {
            removeAllChild((IExpandable) t10, i10);
        }
        removeDataFromParent(t10);
        super.remove(i10);
    }

    public void removeAllChild(IExpandable iExpandable, int i10) {
        List subItems;
        if (!iExpandable.isExpanded() || (subItems = iExpandable.getSubItems()) == null || subItems.size() == 0) {
            return;
        }
        int size = subItems.size();
        for (int i11 = 0; i11 < size; i11++) {
            remove(i10 + 1);
        }
    }

    public void removeDataFromParent(T t10) {
        IExpandable iExpandable;
        int parentPosition = getParentPosition(t10);
        if (parentPosition < 0 || (iExpandable = (IExpandable) this.mData.get(parentPosition)) == t10) {
            return;
        }
        iExpandable.getSubItems().remove(t10);
    }

    public void setDefaultViewTypeLayout(@i0 int i10) {
        addItemType(DEFAULT_VIEW_TYPE, i10);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public boolean isExpandable(MultiItemEntity multiItemEntity) {
        return multiItemEntity != null && (multiItemEntity instanceof IExpandable);
    }
}
