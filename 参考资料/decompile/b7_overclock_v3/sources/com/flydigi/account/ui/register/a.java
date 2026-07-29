package com.flydigi.account.ui.register;

import com.flydigi.base.common.k;
import com.flydigi.base.common.m;
import com.flydigi.data.LoginBaseResponse;

/* JADX INFO: loaded from: classes2.dex */
public interface a {

    /* JADX INFO: renamed from: com.flydigi.account.ui.register.a$a, reason: collision with other inner class name */
    public interface InterfaceC0129a extends k {
        void c(@yt.k String str);

        void h(@yt.k String str, @yt.k String str2, @yt.k String str3);
    }

    public interface b extends m {

        /* JADX INFO: renamed from: com.flydigi.account.ui.register.a$b$a, reason: collision with other inner class name */
        public static final class C0130a {
            public static /* synthetic */ void a(b bVar, String str, boolean z10, int i10, Object obj) {
                if (obj != null) {
                    throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showErrorMessage");
                }
                if ((i10 & 2) != 0) {
                    z10 = false;
                }
                bVar.f(str, z10);
            }
        }

        void I(@yt.k LoginBaseResponse<?> loginBaseResponse);

        void f(@yt.k String str, boolean z10);

        void k();
    }
}
