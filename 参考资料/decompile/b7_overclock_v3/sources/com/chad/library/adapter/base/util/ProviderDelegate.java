package com.chad.library.adapter.base.util;

import android.util.SparseArray;
import com.chad.library.adapter.base.provider.BaseItemProvider;

/* JADX INFO: loaded from: classes2.dex */
public class ProviderDelegate {
    private SparseArray<BaseItemProvider> mItemProviders = new SparseArray<>();

    public SparseArray<BaseItemProvider> getItemProviders() {
        return this.mItemProviders;
    }

    public void registerProvider(BaseItemProvider baseItemProvider) {
        if (baseItemProvider == null) {
            throw new ItemProviderException("ItemProvider can not be null");
        }
        int iViewType = baseItemProvider.viewType();
        if (this.mItemProviders.get(iViewType) == null) {
            this.mItemProviders.put(iViewType, baseItemProvider);
        }
    }
}
