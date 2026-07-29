package com.flydigi.qiji.ui.account;

import com.fdg.flashplay.farsef.R;
import com.flydigi.api.download.DownloadHelper;
import com.flydigi.base.common.y;
import com.flydigi.data.bean.UpdateInfoBean;
import com.flydigi.qiji.ui.account.MainAccountFragment;
import com.tencent.connect.common.Constants;
import java.io.File;
import kotlin.jvm.internal.f0;
import kotlin.z1;
import xi.z;

/* JADX INFO: loaded from: classes3.dex */
public final class MainAccountFragment extends AccountFragment {

    public static final class a implements com.flydigi.api.download.d {
        public a() {
        }

        public static final void c(MainAccountFragment this$0, int i10) {
            f0.p(this$0, "this$0");
            this$0.x(this$0.d3(R.string.app_download_, String.valueOf(i10)), false);
        }

        @Override // com.flydigi.api.download.d
        public void a(long j10, long j11, boolean z10) {
            final int i10 = (int) ((j10 * ((long) 100)) / j11);
            y yVarH5 = MainAccountFragment.this.H5();
            final MainAccountFragment mainAccountFragment = MainAccountFragment.this;
            yVarH5.e(new Runnable() { // from class: com.flydigi.qiji.ui.account.w
                @Override // java.lang.Runnable
                public final void run() {
                    MainAccountFragment.a.c(mainAccountFragment, i10);
                }
            });
        }
    }

    public static final void b7(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void c7(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    @Override // com.flydigi.qiji.ui.account.AccountFragment
    public void X6() {
        if (this.f16049q8 != null) {
            x(c3(R.string.downloading), false);
            DownloadHelper downloadHelper = new DownloadHelper("https://api.flydigi.com/", new a());
            UpdateInfoBean updateInfoBean = this.f16049q8;
            f0.m(updateInfoBean);
            String str = updateInfoBean.apk_url;
            f0.o(str, "mUpdateInfoBean!!.apk_url");
            z<R> zVarS0 = downloadHelper.c(Constants.JumpUrlConstants.SRC_TYPE_APP, str, null).s0(o5.l.d());
            final ik.l<File, z1> lVar = new ik.l<File, z1>() { // from class: com.flydigi.qiji.ui.account.MainAccountFragment$update$2
                {
                    super(1);
                }

                public final void b(@yt.l File file) {
                    com.blankj.utilcode.util.d.H(file);
                    this.this$0.E0();
                }

                @Override // ik.l
                public /* bridge */ /* synthetic */ z1 i(File file) {
                    b(file);
                    return z1.f38230a;
                }
            };
            dj.g gVar = new dj.g() { // from class: com.flydigi.qiji.ui.account.v
                @Override // dj.g
                public final void accept(Object obj) {
                    MainAccountFragment.b7(lVar, obj);
                }
            };
            final ik.l<Throwable, z1> lVar2 = new ik.l<Throwable, z1>() { // from class: com.flydigi.qiji.ui.account.MainAccountFragment$update$3
                {
                    super(1);
                }

                public final void b(Throwable th2) {
                    this.this$0.E0();
                }

                @Override // ik.l
                public /* bridge */ /* synthetic */ z1 i(Throwable th2) {
                    b(th2);
                    return z1.f38230a;
                }
            };
            zVarS0.F5(gVar, new dj.g() { // from class: com.flydigi.qiji.ui.account.u
                @Override // dj.g
                public final void accept(Object obj) {
                    MainAccountFragment.c7(lVar2, obj);
                }
            });
        }
    }
}
