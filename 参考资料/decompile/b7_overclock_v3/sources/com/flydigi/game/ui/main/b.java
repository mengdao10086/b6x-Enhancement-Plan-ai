package com.flydigi.game.ui.main;

import com.flydigi.base.common.k;
import com.flydigi.base.common.m;
import com.flydigi.base.net.BaseResponse;
import com.flydigi.data.bean.BannerBean;
import com.flydigi.game.data.bean.GameDetailBean;
import com.flydigi.game.data.bean.RecoGameBean;
import java.util.List;
import xi.z;

/* JADX INFO: loaded from: classes7.dex */
public class b {

    public interface a extends k {
        void G();

        void O(boolean z10);

        void r();
    }

    /* JADX INFO: renamed from: com.flydigi.game.ui.main.b$b, reason: collision with other inner class name */
    public interface InterfaceC0163b extends m {
        void L0(List<GameDetailBean> list);

        void M1(z<BaseResponse<RecoGameBean>> zVar, boolean z10);

        void W();

        void Y(z<BaseResponse<RecoGameBean>> zVar);

        void s1(z<BaseResponse<List<BannerBean>>> zVar, boolean z10);
    }
}
