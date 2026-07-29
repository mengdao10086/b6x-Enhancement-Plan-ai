package com.flydigi.game.adapter;

import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.MultipleItemRvAdapter;
import com.flydigi.game.data.bean.GameBean;
import g.p0;
import java.util.List;
import q8.a;
import q8.c;

/* JADX INFO: loaded from: classes7.dex */
public class GameItemAdapter extends MultipleItemRvAdapter<GameBean, BaseViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f15813a;

    public GameItemAdapter(@p0 List<GameBean> list, String str) {
        super(list);
        this.f15813a = str;
        finishInitialize();
    }

    @Override // com.chad.library.adapter.base.MultipleItemRvAdapter
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public int getViewType(GameBean gameBean) {
        return gameBean.getItemType();
    }

    @Override // com.chad.library.adapter.base.MultipleItemRvAdapter
    public void registerItemProvider() {
        this.mProviderDelegate.registerProvider(new a(this.f15813a));
        this.mProviderDelegate.registerProvider(new c());
    }
}
