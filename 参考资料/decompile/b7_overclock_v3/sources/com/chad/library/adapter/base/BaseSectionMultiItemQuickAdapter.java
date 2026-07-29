package com.chad.library.adapter.base;

import android.util.SparseIntArray;
import android.view.ViewGroup;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.IExpandable;
import com.chad.library.adapter.base.entity.SectionMultiEntity;
import g.f0;
import g.i0;
import g.n0;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseSectionMultiItemQuickAdapter<T extends SectionMultiEntity, K extends BaseViewHolder> extends BaseQuickAdapter<T, K> {
    private static final int DEFAULT_VIEW_TYPE = -255;
    public static final int SECTION_HEADER_VIEW = 1092;
    public static final int TYPE_NOT_FOUND = -404;
    private SparseIntArray layouts;
    public int mSectionHeadResId;

    public BaseSectionMultiItemQuickAdapter(int i10, List<T> list) {
        super(list);
        this.mSectionHeadResId = i10;
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

    public abstract void convertHead(K k10, T t10);

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public int getDefItemViewType(int i10) {
        T t10 = this.mData.get(i10);
        if (t10 == null) {
            return DEFAULT_VIEW_TYPE;
        }
        if (t10.isHeader) {
            return 1092;
        }
        return t10.getItemType();
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public boolean isFixedViewType(int i10) {
        return super.isFixedViewType(i10) || i10 == 1092;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public K onCreateDefViewHolder(ViewGroup viewGroup, int i10) {
        return i10 == 1092 ? createBaseViewHolder(getItemView(this.mSectionHeadResId, viewGroup)) : createBaseViewHolder(viewGroup, getLayoutId(i10));
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
        int parentPosition = getParentPosition(t10);
        if (parentPosition >= 0) {
            ((IExpandable) this.mData.get(parentPosition)).getSubItems().remove(t10);
        }
    }

    public void setDefaultViewTypeLayout(@i0 int i10) {
        addItemType(DEFAULT_VIEW_TYPE, i10);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.g
    public void onBindViewHolder(@n0 K k10, int i10) {
        if (k10.getItemViewType() != 1092) {
            super.onBindViewHolder((BaseViewHolder) k10, i10);
        } else {
            setFullSpan(k10);
            convertHead(k10, getItem(i10 - getHeaderLayoutCount()));
        }
    }
}
