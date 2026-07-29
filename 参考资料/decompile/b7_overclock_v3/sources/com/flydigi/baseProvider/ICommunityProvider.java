package com.flydigi.baseProvider;

import android.content.Context;
import com.alibaba.android.arouter.facade.template.IProvider;
import com.flydigi.base.common.FZFragment;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ICommunityProvider implements IProvider {
    @Override // com.alibaba.android.arouter.facade.template.IProvider
    public void init(Context context) {
    }

    public abstract FZFragment o();
}
