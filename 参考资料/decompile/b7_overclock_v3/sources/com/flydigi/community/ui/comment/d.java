package com.flydigi.community.ui.comment;

import com.flydigi.data.bean.community.CommentBean;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface d {

    public interface a extends com.flydigi.base.common.k {
        void C(int i10, int i11);

        void I(int i10, int i11, int i12, int i13, int i14, int i15, @yt.k String str, int i16);

        void L(int i10, int i11);

        void N(int i10, int i11);

        void Y(int i10, @yt.k String str, int i11, int i12);
    }

    public interface b extends com.flydigi.base.common.m {
        void B(@yt.l String str);

        void E2(@yt.l String str);

        void K(@yt.l String str);

        void K1(@yt.l String str);

        void N2(@yt.k CommentBean commentBean, int i10);

        void S1(int i10);

        void b(boolean z10, @yt.k Throwable th2);

        void d0(int i10);

        void d1(int i10);

        void e1(int i10, @yt.k String str);

        void s0(int i10, int i11, @yt.k String str);

        void w(boolean z10, @yt.k List<CommentBean> list);
    }
}
