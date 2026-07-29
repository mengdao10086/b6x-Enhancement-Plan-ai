package com.chad.library.adapter.base;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.util.MultiTypeDelegate;
import com.chad.library.adapter.base.util.ProviderDelegate;
import g.n0;
import g.p0;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class MultipleItemRvAdapter<T, V extends BaseViewHolder> extends BaseQuickAdapter<T, V> {
    private SparseArray<BaseItemProvider> mItemProviders;
    private MultiTypeDelegate<T> mMultiTypeDelegate;
    public ProviderDelegate mProviderDelegate;

    public MultipleItemRvAdapter(@p0 List<T> list) {
        super(list);
    }

    private void bindClick(final V v10) {
        BaseQuickAdapter.OnItemClickListener onItemClickListener = getOnItemClickListener();
        BaseQuickAdapter.OnItemLongClickListener onItemLongClickListener = getOnItemLongClickListener();
        if (onItemClickListener == null || onItemLongClickListener == null) {
            if (onItemClickListener == null) {
                v10.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.chad.library.adapter.base.MultipleItemRvAdapter.2
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        int adapterPosition = v10.getAdapterPosition();
                        if (adapterPosition == -1) {
                            return;
                        }
                        int headerLayoutCount = adapterPosition - MultipleItemRvAdapter.this.getHeaderLayoutCount();
                        ((BaseItemProvider) MultipleItemRvAdapter.this.mItemProviders.get(v10.getItemViewType())).onClick(v10, MultipleItemRvAdapter.this.mData.get(headerLayoutCount), headerLayoutCount);
                    }
                });
            }
            if (onItemLongClickListener == null) {
                v10.itemView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.chad.library.adapter.base.MultipleItemRvAdapter.3
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // android.view.View.OnLongClickListener
                    public boolean onLongClick(View view) {
                        int adapterPosition = v10.getAdapterPosition();
                        if (adapterPosition == -1) {
                            return false;
                        }
                        int headerLayoutCount = adapterPosition - MultipleItemRvAdapter.this.getHeaderLayoutCount();
                        return ((BaseItemProvider) MultipleItemRvAdapter.this.mItemProviders.get(v10.getItemViewType())).onLongClick(v10, MultipleItemRvAdapter.this.mData.get(headerLayoutCount), headerLayoutCount);
                    }
                });
            }
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void bindViewClickListener(V v10) {
        if (v10 == null) {
            return;
        }
        bindClick(v10);
        super.bindViewClickListener(v10);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@n0 V v10, T t10) {
        BaseItemProvider baseItemProvider = this.mItemProviders.get(v10.getItemViewType());
        baseItemProvider.mContext = v10.itemView.getContext();
        baseItemProvider.convert(v10, t10, v10.getLayoutPosition() - getHeaderLayoutCount());
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convertPayloads(@n0 V v10, T t10, @n0 List<Object> list) {
        this.mItemProviders.get(v10.getItemViewType()).convertPayloads(v10, t10, v10.getLayoutPosition() - getHeaderLayoutCount(), list);
    }

    public void finishInitialize() {
        this.mProviderDelegate = new ProviderDelegate();
        setMultiTypeDelegate(new MultiTypeDelegate<T>() { // from class: com.chad.library.adapter.base.MultipleItemRvAdapter.1
            @Override // com.chad.library.adapter.base.util.MultiTypeDelegate
            public int getItemType(T t10) {
                return MultipleItemRvAdapter.this.getViewType(t10);
            }
        });
        registerItemProvider();
        this.mItemProviders = this.mProviderDelegate.getItemProviders();
        for (int i10 = 0; i10 < this.mItemProviders.size(); i10++) {
            int iKeyAt = this.mItemProviders.keyAt(i10);
            BaseItemProvider baseItemProvider = this.mItemProviders.get(iKeyAt);
            baseItemProvider.mData = this.mData;
            getMultiTypeDelegate().registerItemType(iKeyAt, baseItemProvider.layout());
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public int getDefItemViewType(int i10) {
        if (getMultiTypeDelegate() != null) {
            return getMultiTypeDelegate().getDefItemViewType(this.mData, i10);
        }
        throw new IllegalStateException("please use setMultiTypeDelegate first!");
    }

    public MultiTypeDelegate<T> getMultiTypeDelegate() {
        return this.mMultiTypeDelegate;
    }

    public abstract int getViewType(T t10);

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public V onCreateDefViewHolder(ViewGroup viewGroup, int i10) {
        if (getMultiTypeDelegate() != null) {
            return createBaseViewHolder(viewGroup, getMultiTypeDelegate().getLayoutId(i10));
        }
        throw new IllegalStateException("please use setMultiTypeDelegate first!");
    }

    public abstract void registerItemProvider();

    public void setMultiTypeDelegate(MultiTypeDelegate<T> multiTypeDelegate) {
        this.mMultiTypeDelegate = multiTypeDelegate;
    }
}
