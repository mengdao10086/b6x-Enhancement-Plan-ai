package com.flydigi.baseProvider;

import android.content.Context;
import com.alibaba.android.arouter.facade.template.IProvider;
import com.flydigi.base.common.FZFragment;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes2.dex */
public abstract class IMallProvider implements IProvider {
    @Override // com.alibaba.android.arouter.facade.template.IProvider
    public void init(@l Context context) {
    }

    @k
    public abstract FZFragment o();
}
