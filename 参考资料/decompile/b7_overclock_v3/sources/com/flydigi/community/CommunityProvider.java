package com.flydigi.community;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.flydigi.base.common.FZFragment;
import com.flydigi.baseProvider.ICommunityProvider;
import com.flydigi.community.ui.home.CommunityHomeFragment;
import i9.a;

/* JADX INFO: loaded from: classes2.dex */
@Route(path = a.b.f31917b)
public class CommunityProvider extends ICommunityProvider {
    @Override // com.flydigi.baseProvider.ICommunityProvider
    public FZFragment o() {
        return CommunityHomeFragment.u6();
    }
}
