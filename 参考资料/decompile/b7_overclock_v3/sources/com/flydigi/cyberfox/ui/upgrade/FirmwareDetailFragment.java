package com.flydigi.cyberfox.ui.upgrade;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.blankj.utilcode.util.b0;
import com.blankj.utilcode.util.d1;
import com.blankj.utilcode.util.p1;
import com.flydigi.api.download.DownloadHelper;
import com.flydigi.base.common.FZFragment;
import com.flydigi.cyberfox.R;
import com.flydigi.cyberfox.ui.upgrade.a;
import com.flydigi.data.DataConstant;
import com.flydigi.data.bean.FirmwareInfoBean;
import com.flydigi.sdk.bluetooth.m;
import com.flydigi.sdk.headset.HeadsetInfo;
import com.iir_eq.ui.activity.LeOtaActivity;
import java.io.File;
import java.io.IOException;
import java.net.NoRouteToHostException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import javax.net.ssl.SSLException;
import kotlin.Pair;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.jvm.internal.u;
import kotlin.z1;
import m5.c0;
import xi.z;

/* JADX INFO: loaded from: classes7.dex */
@t0({"SMAP\nFirmwareDetailFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FirmwareDetailFragment.kt\ncom/flydigi/cyberfox/ui/upgrade/FirmwareDetailFragment\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,199:1\n223#2,2:200\n1#3:202\n*S KotlinDebug\n*F\n+ 1 FirmwareDetailFragment.kt\ncom/flydigi/cyberfox/ui/upgrade/FirmwareDetailFragment\n*L\n161#1:200,2\n*E\n"})
public final class FirmwareDetailFragment extends FZFragment implements a.b, com.flydigi.sdk.bluetooth.m {

    /* JADX INFO: renamed from: u8, reason: collision with root package name */
    @yt.k
    public static final a f14261u8 = new a(null);

    /* JADX INFO: renamed from: o8, reason: collision with root package name */
    public boolean f14262o8;

    /* JADX INFO: renamed from: p8, reason: collision with root package name */
    @yt.k
    public String f14263p8 = "all";

    /* JADX INFO: renamed from: q8, reason: collision with root package name */
    @yt.k
    public final FirmwarePresenter f14264q8 = new FirmwarePresenter(this);

    /* JADX INFO: renamed from: r8, reason: collision with root package name */
    @yt.l
    public HeadsetInfo f14265r8;

    /* JADX INFO: renamed from: s8, reason: collision with root package name */
    @yt.l
    public FirmwareInfoBean f14266s8;

    /* JADX INFO: renamed from: t8, reason: collision with root package name */
    public h6.m f14267t8;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @hk.m
        @yt.k
        public final FirmwareDetailFragment a(@yt.k String deviceCode, @yt.l HeadsetInfo headsetInfo, @yt.l FirmwareInfoBean firmwareInfoBean) {
            f0.p(deviceCode, "deviceCode");
            FirmwareDetailFragment firmwareDetailFragment = new FirmwareDetailFragment();
            firmwareDetailFragment.c5(androidx.core.os.e.b(new Pair("key_device_code", deviceCode), new Pair("key_device_info", headsetInfo), new Pair(DataConstant.DEVICE_KEY_FIRMWARE_INFO, firmwareInfoBean)));
            return firmwareDetailFragment;
        }
    }

    public static final class b implements com.flydigi.api.download.d {
        @Override // com.flydigi.api.download.d
        public void a(long j10, long j11, boolean z10) {
        }
    }

    public static final void g6(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void h6(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void i6(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    @hk.m
    @yt.k
    public static final FirmwareDetailFragment j6(@yt.k String str, @yt.l HeadsetInfo headsetInfo, @yt.l FirmwareInfoBean firmwareInfoBean) {
        return f14261u8.a(str, headsetInfo, firmwareInfoBean);
    }

    public static final void m6(FirmwareDetailFragment this$0, File file) {
        f0.p(this$0, "this$0");
        this$0.E0();
        LeOtaActivity.y7(this$0.R4(), this$0.f14263p8, file.getAbsolutePath());
    }

    public static final void o6(FirmwareDetailFragment this$0, View view) {
        f0.p(this$0, "this$0");
        FirmwareInfoBean firmwareInfoBean = this$0.f14266s8;
        if (firmwareInfoBean != null) {
            String str = firmwareInfoBean.url;
            f0.o(str, "it.url");
            this$0.k6(str);
        }
    }

    @Override // com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void K3(@yt.l Bundle bundle) {
        super.K3(bundle);
        Bundle bundleT1 = T1();
        this.f14265r8 = bundleT1 != null ? (HeadsetInfo) bundleT1.getParcelable("key_device_info") : null;
        Bundle bundleT12 = T1();
        FirmwareInfoBean firmwareInfoBean = bundleT12 != null ? (FirmwareInfoBean) bundleT12.getParcelable(DataConstant.DEVICE_KEY_FIRMWARE_INFO) : null;
        this.f14266s8 = firmwareInfoBean;
        if (firmwareInfoBean != null && d1.g(firmwareInfoBean.url)) {
            this.f14266s8 = null;
        }
        Bundle bundleT13 = T1();
        String string = bundleT13 != null ? bundleT13.getString("key_device_code") : null;
        if (string == null) {
            string = "all";
        }
        this.f14263p8 = string;
    }

    @Override // com.flydigi.base.common.FZFragment
    public int L5() {
        return R.layout.cf_fragment_upgrade_x1;
    }

    @Override // com.flydigi.base.common.FZFragment, com.flydigi.base.common.BaseFragment, androidx.fragment.app.Fragment
    @yt.k
    public View O3(@yt.k LayoutInflater inflater, @yt.l ViewGroup viewGroup, @yt.l Bundle bundle) {
        f0.p(inflater, "inflater");
        h6.m mVarD = h6.m.d(inflater, viewGroup, false);
        f0.o(mVarD, "inflate(inflater, container, false)");
        this.f14267t8 = mVarD;
        if (mVarD == null) {
            f0.S("viewBinding");
            mVarD = null;
        }
        LinearLayout root = mVarD.getRoot();
        f0.o(root, "viewBinding.root");
        return root;
    }

    @Override // com.flydigi.sdk.bluetooth.m
    public void P(boolean z10) {
        FirmwareInfoBean firmwareInfoBean;
        String str;
        m.a.e(this, z10);
        if (!z10 || !this.f14262o8 || (firmwareInfoBean = this.f14266s8) == null || (str = firmwareInfoBean.url) == null) {
            return;
        }
        f6(str);
    }

    @Override // com.flydigi.sdk.bluetooth.m
    public void R0() {
        m.a.a(this);
    }

    @Override // com.flydigi.sdk.bluetooth.m
    public void b0() {
        m.a.b(this);
    }

    public final void f6(String str) {
        z zVarB4 = DownloadHelper.d(new DownloadHelper("https://api.flydigi.com/", new b()), "firmware", str, null, 4, null).s0(c0.t()).b4(aj.a.c());
        final ik.l<io.reactivex.disposables.b, z1> lVar = new ik.l<io.reactivex.disposables.b, z1>() { // from class: com.flydigi.cyberfox.ui.upgrade.FirmwareDetailFragment$downloadFirmware$2
            {
                super(1);
            }

            public final void b(io.reactivex.disposables.b bVar) {
                FirmwareDetailFragment firmwareDetailFragment = this.this$0;
                firmwareDetailFragment.x(firmwareDetailFragment.c3(R.string.downloading), false);
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(io.reactivex.disposables.b bVar) {
                b(bVar);
                return z1.f38230a;
            }
        };
        z zVarZ1 = zVarB4.Z1(new dj.g() { // from class: com.flydigi.cyberfox.ui.upgrade.d
            @Override // dj.g
            public final void accept(Object obj) {
                FirmwareDetailFragment.g6(lVar, obj);
            }
        });
        final ik.l<File, z1> lVar2 = new ik.l<File, z1>() { // from class: com.flydigi.cyberfox.ui.upgrade.FirmwareDetailFragment$downloadFirmware$3
            {
                super(1);
            }

            public final void b(File it2) throws IOException {
                FirmwareDetailFragment firmwareDetailFragment = this.this$0;
                f0.o(it2, "it");
                firmwareDetailFragment.l6(it2);
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(File file) throws IOException {
                b(file);
                return z1.f38230a;
            }
        };
        dj.g gVar = new dj.g() { // from class: com.flydigi.cyberfox.ui.upgrade.c
            @Override // dj.g
            public final void accept(Object obj) {
                FirmwareDetailFragment.h6(lVar2, obj);
            }
        };
        final ik.l<Throwable, z1> lVar3 = new ik.l<Throwable, z1>() { // from class: com.flydigi.cyberfox.ui.upgrade.FirmwareDetailFragment$downloadFirmware$4
            {
                super(1);
            }

            public final void b(Throwable th2) {
                String strC3;
                if ((th2 instanceof NoRouteToHostException) || (th2 instanceof UnknownHostException) || (th2 instanceof SocketTimeoutException) || (th2 instanceof SSLException)) {
                    strC3 = this.this$0.c3(R.string.net_state_error);
                } else {
                    strC3 = th2.getMessage();
                    if (strC3 == null) {
                        strC3 = this.this$0.c3(R.string.net_state_error);
                        f0.o(strC3, "getString(R.string.net_state_error)");
                    }
                }
                f0.o(strC3, "if (it is NoRouteToHostE…_error)\n                }");
                com.flydigi.base.common.o.E(strC3);
                this.this$0.E0();
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(Throwable th2) {
                b(th2);
                return z1.f38230a;
            }
        };
        zVarZ1.F5(gVar, new dj.g() { // from class: com.flydigi.cyberfox.ui.upgrade.e
            @Override // dj.g
            public final void accept(Object obj) {
                FirmwareDetailFragment.i6(lVar3, obj);
            }
        });
    }

    @Override // com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void h4() {
        super.h4();
        q9.f.u(this);
    }

    @Override // com.flydigi.cyberfox.ui.upgrade.a.b
    public void i(@yt.l FirmwareInfoBean firmwareInfoBean) {
        this.f14266s8 = firmwareInfoBean;
        n6();
    }

    @Override // com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void i4() {
        super.i4();
        q9.f.I(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00a1  */
    @Override // com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void j4(@yt.k android.view.View r8, @yt.l android.os.Bundle r9) {
        /*
            r7 = this;
            java.lang.String r0 = "view"
            kotlin.jvm.internal.f0.p(r8, r0)
            super.j4(r8, r9)
            com.flydigi.sdk.headset.HeadsetInfo r8 = r7.f14265r8
            r9 = 118(0x76, float:1.65E-43)
            java.lang.String r0 = ""
            java.lang.String r1 = "viewBinding"
            r2 = 1
            r3 = 0
            r4 = 0
            if (r8 == 0) goto L54
            if (r8 == 0) goto L2a
            java.lang.String r8 = r8.getFirmwareLeft()
            if (r8 == 0) goto L2a
            int r8 = r8.length()
            if (r8 <= 0) goto L25
            r8 = 1
            goto L26
        L25:
            r8 = 0
        L26:
            if (r8 != r2) goto L2a
            r8 = 1
            goto L2b
        L2a:
            r8 = 0
        L2b:
            if (r8 == 0) goto L54
            h6.m r8 = r7.f14267t8
            if (r8 != 0) goto L35
            kotlin.jvm.internal.f0.S(r1)
            r8 = r4
        L35:
            android.widget.TextView r8 = r8.f30661c
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r9)
            com.flydigi.sdk.headset.HeadsetInfo r6 = r7.f14265r8
            if (r6 == 0) goto L48
            java.lang.String r6 = r6.getFirmwareLeft()
            goto L49
        L48:
            r6 = r4
        L49:
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            r8.setText(r5)
            goto L61
        L54:
            h6.m r8 = r7.f14267t8
            if (r8 != 0) goto L5c
            kotlin.jvm.internal.f0.S(r1)
            r8 = r4
        L5c:
            android.widget.TextView r8 = r8.f30661c
            r8.setText(r0)
        L61:
            com.flydigi.sdk.headset.HeadsetInfo r8 = r7.f14265r8
            if (r8 == 0) goto La1
            if (r8 == 0) goto L79
            java.lang.String r8 = r8.getFirmwareRight()
            if (r8 == 0) goto L79
            int r8 = r8.length()
            if (r8 <= 0) goto L75
            r8 = 1
            goto L76
        L75:
            r8 = 0
        L76:
            if (r8 != r2) goto L79
            goto L7a
        L79:
            r2 = 0
        L7a:
            if (r2 == 0) goto La1
            h6.m r8 = r7.f14267t8
            if (r8 != 0) goto L84
            kotlin.jvm.internal.f0.S(r1)
            r8 = r4
        L84:
            android.widget.TextView r8 = r8.f30662d
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r9)
            com.flydigi.sdk.headset.HeadsetInfo r9 = r7.f14265r8
            if (r9 == 0) goto L96
            java.lang.String r4 = r9.getFirmwareRight()
        L96:
            r0.append(r4)
            java.lang.String r9 = r0.toString()
            r8.setText(r9)
            goto Laf
        La1:
            h6.m r8 = r7.f14267t8
            if (r8 != 0) goto La9
            kotlin.jvm.internal.f0.S(r1)
            goto Laa
        La9:
            r4 = r8
        Laa:
            android.widget.TextView r8 = r4.f30662d
            r8.setText(r0)
        Laf:
            r7.n6()
            com.flydigi.data.bean.FirmwareInfoBean r8 = r7.f14266s8
            if (r8 != 0) goto Lbd
            com.flydigi.cyberfox.ui.upgrade.FirmwarePresenter r8 = r7.f14264q8
            java.lang.String r9 = r7.f14263p8
            r8.b(r9)
        Lbd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.flydigi.cyberfox.ui.upgrade.FirmwareDetailFragment.j4(android.view.View, android.os.Bundle):void");
    }

    public final void k6(String str) {
        if (!f0.g(q9.f.n(), Boolean.FALSE)) {
            f6(str);
        } else {
            this.f14262o8 = true;
            q9.f.r(this);
        }
    }

    @Override // com.flydigi.sdk.bluetooth.m
    public void l() {
        m.a.c(this);
    }

    public final void l6(File file) throws IOException {
        List<File> listF = p1.f(file, file.getParentFile());
        f0.o(listF, "unzipFile(file, file.parentFile)");
        for (final File file2 : listF) {
            if (Objects.equals(b0.F(file2), "bin")) {
                HeadsetInfo headsetInfo = this.f14265r8;
                if (headsetInfo != null && headsetInfo.getConnected()) {
                    q9.f.f47178a.C();
                }
                H5().f(new Runnable() { // from class: com.flydigi.cyberfox.ui.upgrade.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        FirmwareDetailFragment.m6(this.f14275a, file2);
                    }
                }, 3000L);
                return;
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x003b, code lost:
    
        if (java.util.Objects.equals(r0, r7 != null ? r7.version : null) != false) goto L47;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void n6() {
        /*
            Method dump skipped, instruction units count: 204
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.flydigi.cyberfox.ui.upgrade.FirmwareDetailFragment.n6():void");
    }

    @Override // com.flydigi.sdk.bluetooth.m
    public void q(int i10) {
        m.a.d(this, i10);
    }
}
