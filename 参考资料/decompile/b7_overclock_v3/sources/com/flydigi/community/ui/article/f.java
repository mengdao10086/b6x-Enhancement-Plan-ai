package com.flydigi.community.ui.article;

import com.flydigi.data.bean.CfgInfoBean;
import com.flydigi.data.bean.community.ArticleBean;
import com.flydigi.sdk.gamepad.extension.config.data.CFGEntity;

/* JADX INFO: loaded from: classes2.dex */
public interface f {

    public interface a extends com.flydigi.base.common.k {
        void F(@yt.k CfgInfoBean cfgInfoBean);

        void J(int i10, int i11);

        void a(int i10, int i11);

        void b0(int i10);
    }

    public interface b extends com.flydigi.base.common.m {
        void B2(@yt.k CfgInfoBean cfgInfoBean, @yt.k CFGEntity cFGEntity);

        void E(@yt.l Throwable th2);

        void K2(@yt.k Throwable th2);

        void X();

        void c0();

        void c1(@yt.k ArticleBean articleBean);

        void r2();

        void z1();
    }
}
