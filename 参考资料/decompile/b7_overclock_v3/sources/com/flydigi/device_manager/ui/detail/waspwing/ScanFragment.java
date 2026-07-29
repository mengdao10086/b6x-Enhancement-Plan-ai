package com.flydigi.device_manager.ui.detail.waspwing;

import android.app.Activity;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.RecyclerView;
import c7.m1;
import com.blankj.utilcode.util.PermissionUtils;
import com.blankj.utilcode.util.n0;
import com.flydigi.base.common.BaseDialogFragment;
import com.flydigi.base.widget.FZDialog;
import com.flydigi.device_manager.R;
import com.flydigi.sdk.bluetooth.data.BleDevice;
import com.flydigi.sdk.bluetooth.e0;
import com.flydigi.sdk.bluetooth.m;
import com.flydigi.sdk.waspwing.WaspWingInfo;
import com.google.android.material.tabs.TabLayout;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.s0;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.z1;
import rx_activity_result2.RxActivityResult;
import t9.i;

/* JADX INFO: loaded from: classes7.dex */
@t0({"SMAP\nScanFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ScanFragment.kt\ncom/flydigi/device_manager/ui/detail/waspwing/ScanFragment\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,404:1\n288#2,2:405\n*S KotlinDebug\n*F\n+ 1 ScanFragment.kt\ncom/flydigi/device_manager/ui/detail/waspwing/ScanFragment\n*L\n293#1:405,2\n*E\n"})
public final class ScanFragment extends BaseDialogFragment implements com.flydigi.sdk.bluetooth.m, e0, t9.i {

    @yt.k
    public static final a K8 = new a(null);

    @yt.k
    public static final String L8 = "key_device_code";

    @yt.k
    public final Handler E8 = new Handler();

    @yt.k
    public final com.flydigi.base.common.y F8 = new com.flydigi.base.common.y();

    @yt.k
    public String G8 = "all";
    public m1 H8;
    public eu.davidea.flexibleadapter.b<com.flydigi.device_manager.ui.connection.h> I8;
    public long J8;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }

        @hk.m
        @yt.k
        public final ScanFragment a(@yt.k String deviceCode) {
            f0.p(deviceCode, "deviceCode");
            ScanFragment scanFragment = new ScanFragment();
            scanFragment.c5(androidx.core.os.e.b(new Pair("key_device_code", deviceCode)));
            return scanFragment;
        }
    }

    public static final void A6(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void B6(ScanFragment this$0, DialogFragment dialogFragment) {
        f0.p(this$0, "this$0");
        this$0.e6();
        dialogFragment.H5();
    }

    public static final void C6(ScanFragment this$0) {
        f0.p(this$0, "this$0");
        u9.g.a().d(this$0.X1(), "Connect_B3_Scan_Started", "连接流程_扫描开始", this$0.s6());
        m1 m1Var = this$0.H8;
        if (m1Var == null) {
            f0.S("viewBinding");
            m1Var = null;
        }
        m1Var.f10230i.setText(this$0.c3(R.string.device_connect_scanning));
    }

    public static final void D6(ScanFragment this$0, View view) {
        f0.p(this$0, "this$0");
        this$0.e6();
    }

    public static final void F6(DialogFragment dialogFragment) {
        Activity activityP = com.blankj.utilcode.util.a.P();
        f0.n(activityP, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        t9.j.c0((androidx.fragment.app.g) activityP, 2);
        dialogFragment.I5();
    }

    @hk.m
    @yt.k
    public static final ScanFragment t6(@yt.k String str) {
        return K8.a(str);
    }

    public static final void u6(ScanFragment this$0) {
        f0.p(this$0, "this$0");
        m1 m1Var = this$0.H8;
        if (m1Var == null) {
            f0.S("viewBinding");
            m1Var = null;
        }
        m1Var.f10230i.setText(this$0.c3(R.string.device_connect_scanning_failure_connect_failed));
    }

    public static final void v6(int i10, final ScanFragment this$0) {
        f0.p(this$0, "this$0");
        if (i10 == 8) {
            o5.a.t0(this$0.U1(), new FZDialog.a().t(this$0.c3(R.string.device_msg_location_permission_on_10_title)).j(this$0.c3(R.string.device_msg_location_permission_on_10)).d(this$0.c3(R.string.cancel)).g(this$0.c3(R.string.device_setting_now)).b(Boolean.FALSE).f(new FZDialog.c() { // from class: com.flydigi.device_manager.ui.detail.waspwing.n
                @Override // com.flydigi.base.widget.FZDialog.c
                public final void a(DialogFragment dialogFragment) {
                    ScanFragment.w6(this.f14802a, dialogFragment);
                }
            }).c(new FZDialog.c() { // from class: com.flydigi.device_manager.ui.detail.waspwing.k
                @Override // com.flydigi.base.widget.FZDialog.c
                public final void a(DialogFragment dialogFragment) {
                    ScanFragment.y6(this.f14756a, dialogFragment);
                }
            }).a());
            return;
        }
        if (i10 == 9) {
            o5.a.t0(this$0.U1(), new FZDialog.a().t(this$0.c3(R.string.device_need_find_location_permission)).j(this$0.c3(R.string.device_need_find_location_permission_msg)).d(this$0.c3(R.string.cancel)).g(this$0.c3(R.string.device_setting_now)).b(Boolean.FALSE).f(new FZDialog.c() { // from class: com.flydigi.device_manager.ui.detail.waspwing.m
                @Override // com.flydigi.base.widget.FZDialog.c
                public final void a(DialogFragment dialogFragment) {
                    ScanFragment.z6(this.f14801a, dialogFragment);
                }
            }).c(new FZDialog.c() { // from class: com.flydigi.device_manager.ui.detail.waspwing.l
                @Override // com.flydigi.base.widget.FZDialog.c
                public final void a(DialogFragment dialogFragment) {
                    ScanFragment.B6(this.f14757a, dialogFragment);
                }
            }).a());
            return;
        }
        u9.g.a().d(this$0.X1(), "Connect_B3_Scan_Failed", "连接流程_扫描失败", this$0.s6());
        com.flydigi.userBehavior.a.a().b(this$0.X1(), "蜂翼 2 Pro_外设连接弹窗_扫描失败,errorCode:" + i10);
    }

    public static final void w6(final ScanFragment this$0, DialogFragment dialogFragment) {
        f0.p(this$0, "this$0");
        f0.p(dialogFragment, "dialogFragment");
        this$0.e6();
        dialogFragment.I5();
        Intent intent = new Intent();
        intent.setAction("android.settings.LOCATION_SOURCE_SETTINGS");
        xi.z zVarE = RxActivityResult.b(this$0).e(intent);
        final ik.l<rx_activity_result2.f<ScanFragment>, z1> lVar = new ik.l<rx_activity_result2.f<ScanFragment>, z1>() { // from class: com.flydigi.device_manager.ui.detail.waspwing.ScanFragment$onScanFailed$1$dialog$1$1
            {
                super(1);
            }

            public final void b(rx_activity_result2.f<ScanFragment> fVar) {
                this.this$0.E6();
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(rx_activity_result2.f<ScanFragment> fVar) {
                b(fVar);
                return z1.f38230a;
            }
        };
        zVarE.E5(new dj.g() { // from class: com.flydigi.device_manager.ui.detail.waspwing.q
            @Override // dj.g
            public final void accept(Object obj) {
                ScanFragment.x6(lVar, obj);
            }
        });
    }

    public static final void x6(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void y6(ScanFragment this$0, DialogFragment dialogFragment) {
        f0.p(this$0, "this$0");
        this$0.e6();
        dialogFragment.H5();
    }

    public static final void z6(final ScanFragment this$0, DialogFragment dialogFragment) {
        f0.p(this$0, "this$0");
        f0.p(dialogFragment, "dialogFragment");
        this$0.e6();
        dialogFragment.I5();
        Intent intent = new Intent();
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        Context contextX1 = this$0.X1();
        intent.setData(Uri.fromParts("package", contextX1 != null ? contextX1.getPackageName() : null, null));
        xi.z zVarE = RxActivityResult.b(this$0).e(intent);
        final ik.l<rx_activity_result2.f<ScanFragment>, z1> lVar = new ik.l<rx_activity_result2.f<ScanFragment>, z1>() { // from class: com.flydigi.device_manager.ui.detail.waspwing.ScanFragment$onScanFailed$1$dialog$3$1
            {
                super(1);
            }

            public final void b(rx_activity_result2.f<ScanFragment> fVar) {
                this.this$0.E6();
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(rx_activity_result2.f<ScanFragment> fVar) {
                b(fVar);
                return z1.f38230a;
            }
        };
        zVarE.E5(new dj.g() { // from class: com.flydigi.device_manager.ui.detail.waspwing.p
            @Override // dj.g
            public final void accept(Object obj) {
                ScanFragment.A6(lVar, obj);
            }
        });
    }

    @Override // com.flydigi.sdk.bluetooth.w
    public void A(@yt.k BluetoothDevice device) {
        f0.p(device, "device");
        i.a.b(this, device);
        com.flydigi.userBehavior.a.a().b(X1(), "蜂翼 2 Pro_外设连接弹窗_私有连接超时");
        u9.g.a().d(X1(), "Connect_B3_Private_Gatt_Connection_Timeout", "连接流程_私有连接超时", s6());
        this.F8.e(new Runnable() { // from class: com.flydigi.device_manager.ui.detail.waspwing.j
            @Override // java.lang.Runnable
            public final void run() {
                ScanFragment.u6(this.f14755a);
            }
        });
    }

    public final void E6() {
        if (Build.VERSION.SDK_INT < 31 && !PermissionUtils.z(w3.c.f53848d)) {
            new FZDialog.a().t(d3(R.string.base_request_permission, c3(R.string.device_location_permission))).j(c3(R.string.device_location_permission_reason)).q(c3(R.string.next)).b(Boolean.FALSE).p(new FZDialog.c() { // from class: com.flydigi.device_manager.ui.detail.waspwing.o
                @Override // com.flydigi.base.widget.FZDialog.c
                public final void a(DialogFragment dialogFragment) {
                    ScanFragment.F6(dialogFragment);
                }
            }).a().Z5(U1(), "explainDialog");
            return;
        }
        Activity activityP = com.blankj.utilcode.util.a.P();
        f0.n(activityP, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        t9.j.c0((androidx.fragment.app.g) activityP, 2);
    }

    @Override // t9.i
    public void F1(@yt.k WaspWingInfo waspWingInfo) {
        f0.p(waspWingInfo, "waspWingInfo");
        e6();
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x012c A[PHI: r6 r7
  0x012c: PHI (r6v7 java.lang.Object) = 
  (r6v3 java.lang.Object)
  (r6v8 java.lang.Object)
  (r6v9 java.lang.Object)
  (r6v10 java.lang.Object)
  (r6v11 java.lang.Object)
  (r6v12 java.lang.Object)
 binds: [B:60:0x012a, B:56:0x011c, B:53:0x010f, B:49:0x0101, B:46:0x00f0, B:43:0x00e3] A[DONT_GENERATE, DONT_INLINE]
  0x012c: PHI (r7v6 java.lang.Object) = 
  (r7v2 java.lang.Object)
  (r7v7 java.lang.Object)
  (r7v8 java.lang.Object)
  (r7v10 java.lang.Object)
  (r7v13 java.lang.Object)
  (r7v14 java.lang.Object)
 binds: [B:60:0x012a, B:56:0x011c, B:53:0x010f, B:49:0x0101, B:46:0x00f0, B:43:0x00e3] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.flydigi.base.common.BaseDialogFragment, com.trello.rxlifecycle3.components.support.RxDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void K3(@yt.l android.os.Bundle r22) {
        /*
            Method dump skipped, instruction units count: 376
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.flydigi.device_manager.ui.detail.waspwing.ScanFragment.K3(android.os.Bundle):void");
    }

    @Override // com.flydigi.sdk.bluetooth.w
    public void O2(@yt.k BluetoothGatt gatt) {
        f0.p(gatt, "gatt");
        u9.g.a().d(X1(), "Connect_B3_Private_Gatt_Connection_Disconnected", "连接流程_私有连接断开", s6());
        com.flydigi.userBehavior.a.a().b(X1(), "蜂翼 2 Pro_外设连接弹窗_私有连接断开");
        E6();
        i.a.e(this, gatt);
    }

    @Override // com.flydigi.base.common.BaseDialogFragment, androidx.fragment.app.Fragment
    @yt.k
    public View O3(@yt.k LayoutInflater inflater, @yt.l ViewGroup viewGroup, @yt.l Bundle bundle) {
        f0.p(inflater, "inflater");
        m1 m1VarD = m1.d(inflater, viewGroup, false);
        f0.o(m1VarD, "inflate(inflater, container, false)");
        this.H8 = m1VarD;
        if (m1VarD == null) {
            f0.S("viewBinding");
            m1VarD = null;
        }
        FrameLayout root = m1VarD.getRoot();
        f0.o(root, "viewBinding.root");
        return root;
    }

    @Override // com.flydigi.sdk.bluetooth.m
    public void P(boolean z10) {
        m.a.e(this, z10);
        if (z10) {
            return;
        }
        E6();
    }

    @Override // com.flydigi.sdk.bluetooth.m
    public void R0() {
        m.a.a(this);
    }

    @Override // com.flydigi.base.common.BaseDialogFragment, com.trello.rxlifecycle3.components.support.RxDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void R3() {
        this.J8 = 0L;
        t9.j.d0();
        t9.j.e0(this);
        this.E8.removeCallbacksAndMessages(null);
        this.F8.h(null);
        super.R3();
    }

    @Override // com.flydigi.sdk.bluetooth.w
    public void V0(@yt.k BluetoothDevice device) {
        f0.p(device, "device");
        i.a.d(this, device);
        com.flydigi.userBehavior.a.a().b(X1(), "蜂翼 2 Pro_外设连接弹窗_私有连接开始");
        u9.g.a().d(X1(), "Connect_B3_Private_Gatt_Connection_start", "连接流程_私有连接开始", s6());
    }

    @Override // com.flydigi.base.common.BaseDialogFragment, com.trello.rxlifecycle3.components.support.RxDialogFragment, androidx.fragment.app.Fragment
    public void a4() {
        super.a4();
        t9.j.d0();
        t9.j.e0(this);
    }

    @Override // com.flydigi.sdk.bluetooth.m
    public void b0() {
        m.a.b(this);
    }

    @Override // com.flydigi.base.common.BaseDialogFragment
    public int c6() {
        return R.layout.device_fragment_scan;
    }

    @Override // com.flydigi.sdk.bluetooth.w
    public void e2(@yt.k BluetoothDevice device) {
        f0.p(device, "device");
        i.a.c(this, device);
        com.flydigi.userBehavior.a.a().b(X1(), "蜂翼 2 Pro_外设连接弹窗_私有连接成功");
        u9.g.a().d(X1(), "Connect_B3_Private_Gatt_Connection_Connected", "连接流程_私有连接建立成功", s6());
    }

    @Override // com.flydigi.base.common.BaseDialogFragment, com.trello.rxlifecycle3.components.support.RxDialogFragment, androidx.fragment.app.Fragment
    public void f4() {
        super.f4();
        t9.j.D(this);
        E6();
    }

    @Override // com.flydigi.sdk.bluetooth.w
    public void g2(@yt.k BluetoothDevice bluetoothDevice) {
        i.a.a(this, bluetoothDevice);
    }

    @Override // com.flydigi.base.common.BaseDialogFragment, com.trello.rxlifecycle3.components.support.RxDialogFragment, androidx.fragment.app.Fragment
    public void j4(@yt.k View view, @yt.l Bundle bundle) {
        f0.p(view, "view");
        super.j4(view, bundle);
        m1 m1Var = this.H8;
        m1 m1Var2 = null;
        if (m1Var == null) {
            f0.S("viewBinding");
            m1Var = null;
        }
        TabLayout tabLayout = m1Var.f10229h;
        f0.o(tabLayout, "viewBinding.tabLayout");
        o5.c.b(tabLayout, Boolean.FALSE, false, 2, null);
        m1 m1Var3 = this.H8;
        if (m1Var3 == null) {
            f0.S("viewBinding");
            m1Var3 = null;
        }
        RecyclerView recyclerView = m1Var3.f10228g;
        eu.davidea.flexibleadapter.b<com.flydigi.device_manager.ui.connection.h> bVar = this.I8;
        if (bVar == null) {
            f0.S("mAdapter");
            bVar = null;
        }
        recyclerView.setAdapter(bVar);
        androidx.recyclerview.widget.j jVar = new androidx.recyclerview.widget.j(X1(), 1);
        Drawable drawableI = h0.d.i(view.getContext(), R.drawable.device_view_divider_shape_h16);
        if (drawableI == null) {
            drawableI = new ShapeDrawable();
        }
        jVar.l(drawableI);
        m1 m1Var4 = this.H8;
        if (m1Var4 == null) {
            f0.S("viewBinding");
            m1Var4 = null;
        }
        m1Var4.f10228g.n(jVar);
        m1 m1Var5 = this.H8;
        if (m1Var5 == null) {
            f0.S("viewBinding");
        } else {
            m1Var2 = m1Var5;
        }
        com.blankj.utilcode.util.o.r(m1Var2.f10225d, new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.detail.waspwing.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ScanFragment.D6(this.f14754a, view2);
            }
        });
        this.J8 = 0L;
    }

    @Override // com.flydigi.sdk.bluetooth.w
    public void k1(int i10) {
        i.a.f(this, i10);
    }

    @Override // com.flydigi.sdk.bluetooth.m
    public void l() {
        m.a.c(this);
    }

    @Override // com.flydigi.sdk.bluetooth.m
    public void q(int i10) {
        m.a.d(this, i10);
    }

    @Override // com.flydigi.sdk.bluetooth.e0
    public void q1(@yt.k List<BleDevice> devices) {
        Object next;
        f0.p(devices, "devices");
        e0.a.a(this, devices);
        if (n0.z(devices)) {
            Iterator<T> it2 = devices.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    next = null;
                    break;
                } else {
                    next = it2.next();
                    if (n0.b(t9.c.f50952a.a(((BleDevice) next).M()), this.G8)) {
                        break;
                    }
                }
            }
            BleDevice bleDevice = (BleDevice) next;
            if (bleDevice != null) {
                t9.j.d0();
                this.J8 = System.currentTimeMillis();
                u9.g.a().d(X1(), "Connect_B3_Scan_Device_Found", "连接流程_发现设备", s6());
                m1 m1Var = this.H8;
                if (m1Var == null) {
                    f0.S("viewBinding");
                    m1Var = null;
                }
                m1Var.f10230i.setText(c3(R.string.device_preparing));
                m1 m1Var2 = this.H8;
                if (m1Var2 == null) {
                    f0.S("viewBinding");
                    m1Var2 = null;
                }
                m1Var2.f10230i.setTextColor(V2().getColor(R.color.colorPrimary));
                m1 m1Var3 = this.H8;
                if (m1Var3 == null) {
                    f0.S("viewBinding");
                    m1Var3 = null;
                }
                ProgressBar progressBar = m1Var3.f10227f;
                f0.o(progressBar, "viewBinding.progress");
                o5.c.b(progressBar, Boolean.TRUE, false, 2, null);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("命中");
                sb2.append(bleDevice.M());
                t9.j.c(bleDevice.F());
            }
        }
    }

    @Override // t9.i
    public void q2(@yt.k byte[] bArr) {
        i.a.g(this, bArr);
    }

    @Override // com.flydigi.sdk.bluetooth.e0
    public void s2() {
        e0.a.d(this);
    }

    public final Map<String, String> s6() {
        return s0.W(new Pair("manufacturer", com.blankj.utilcode.util.x.j()), new Pair("model", com.blankj.utilcode.util.x.k()), new Pair("system", String.valueOf(Build.VERSION.SDK_INT)), new Pair("device_code", this.G8));
    }

    @Override // com.flydigi.sdk.bluetooth.e0
    public void t0() {
        e0.a.c(this);
        this.F8.e(new Runnable() { // from class: com.flydigi.device_manager.ui.detail.waspwing.s
            @Override // java.lang.Runnable
            public final void run() {
                ScanFragment.C6(this.f14808a);
            }
        });
    }

    @Override // com.flydigi.sdk.bluetooth.e0
    public void x0(final int i10) {
        e0.a.b(this, i10);
        this.F8.e(new Runnable() { // from class: com.flydigi.device_manager.ui.detail.waspwing.r
            @Override // java.lang.Runnable
            public final void run() {
                ScanFragment.v6(i10, this);
            }
        });
    }
}
