package com.flydigi.device_manager.ui.home.game.adapter;

import android.view.ViewGroup;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.MultipleItemRvAdapter;
import com.flydigi.data.bean.LocalGameBean;
import g.p0;
import java.util.List;
import n7.a;
import n7.b;

/* JADX INFO: loaded from: classes7.dex */
public class LocalGameSquareAdapter extends MultipleItemRvAdapter<LocalGameBean, BaseViewHolder> {
    public LocalGameSquareAdapter(@p0 List<LocalGameBean> list) {
        super(list);
        finishInitialize();
    }

    @Override // com.chad.library.adapter.base.MultipleItemRvAdapter
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public int getViewType(LocalGameBean localGameBean) {
        int i10 = localGameBean.type;
        if (i10 == 1) {
            return 1;
        }
        return i10 == 2 ? 2 : 0;
    }

    @Override // com.chad.library.adapter.base.MultipleItemRvAdapter
    public void registerItemProvider() {
        this.mProviderDelegate.registerProvider(new a());
        this.mProviderDelegate.registerProvider(new b());
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.g
    public BaseViewHolder onCreateViewHolder(ViewGroup viewGroup, int i10) {
        return super.onCreateViewHolder(viewGroup, i10);
    }
}
