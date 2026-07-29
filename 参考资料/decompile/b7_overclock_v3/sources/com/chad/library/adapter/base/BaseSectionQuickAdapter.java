package com.chad.library.adapter.base;

import android.view.ViewGroup;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.SectionEntity;
import g.n0;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseSectionQuickAdapter<T extends SectionEntity, K extends BaseViewHolder> extends BaseQuickAdapter<T, K> {
    public static final int SECTION_HEADER_VIEW = 1092;
    public int mSectionHeadResId;

    public BaseSectionQuickAdapter(int i10, int i11, List<T> list) {
        super(i10, list);
        this.mSectionHeadResId = i11;
    }

    public abstract void convertHead(K k10, T t10);

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public int getDefItemViewType(int i10) {
        return this.mData.get(i10).isHeader ? 1092 : 0;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public boolean isFixedViewType(int i10) {
        return super.isFixedViewType(i10) || i10 == 1092;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public K onCreateDefViewHolder(ViewGroup viewGroup, int i10) {
        return i10 == 1092 ? createBaseViewHolder(getItemView(this.mSectionHeadResId, viewGroup)) : (K) super.onCreateDefViewHolder(viewGroup, i10);
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
