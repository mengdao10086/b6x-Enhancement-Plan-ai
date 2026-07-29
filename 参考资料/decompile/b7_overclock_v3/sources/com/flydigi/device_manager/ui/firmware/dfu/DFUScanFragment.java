package com.flydigi.device_manager.ui.firmware.dfu;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;
import c7.l0;
import com.blankj.utilcode.util.n0;
import com.flydigi.base.common.FZFragment;
import com.flydigi.base.widget.FZDialog;
import com.flydigi.data.DataConstant;
import com.flydigi.device_manager.R;
import com.flydigi.sdk.bluetooth.data.BleDevice;
import com.flydigi.sdk.bluetooth.e0;
import com.flydigi.sdk.bluetooth.m;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.jvm.internal.v0;
import kotlin.z1;
import rx_activity_result2.RxActivityResult;
import xi.z;

/* JADX INFO: loaded from: classes7.dex */
@t0({"SMAP\nDFUScanFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DFUScanFragment.kt\ncom/flydigi/device_manager/ui/firmware/dfu/DFUScanFragment\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,261:1\n288#2,2:262\n1#3:264\n*S KotlinDebug\n*F\n+ 1 DFUScanFragment.kt\ncom/flydigi/device_manager/ui/firmware/dfu/DFUScanFragment\n*L\n229#1:262,2\n*E\n"})
public final class DFUScanFragment extends FZFragment implements com.flydigi.sdk.bluetooth.m, e0 {

    /* JADX INFO: renamed from: s8, reason: collision with root package name */
    @yt.k
    public static final a f14961s8 = new a(null);

    /* JADX INFO: renamed from: o8, reason: collision with root package name */
    @yt.k
    public String f14962o8 = "all";

    /* JADX INFO: renamed from: p8, reason: collision with root package name */
    public boolean f14963p8;

    /* JADX INFO: renamed from: q8, reason: collision with root package name */
    public l0 f14964q8;

    /* JADX INFO: renamed from: r8, reason: collision with root package name */
    public b f14965r8;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }

        @hk.m
        @yt.k
        public final DFUScanFragment a(@yt.k String deviceCode, boolean z10) {
            f0.p(deviceCode, "deviceCode");
            DFUScanFragment dFUScanFragment = new DFUScanFragment();
            dFUScanFragment.c5(androidx.core.os.e.b(new Pair("key_device_code", deviceCode), new Pair(DataConstant.DEVICE_KEY_FIRMWARE_FORCE_LATEST, Boolean.valueOf(z10))));
            return dFUScanFragment;
        }
    }

    public interface b {
        void i(@yt.k String str, @yt.k String str2, int i10);
    }

    public static final class c extends m5.a<Long> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f14967b;

        public c(int i10) {
            this.f14967b = i10;
        }

        public void a(long j10) {
            l0 l0Var = DFUScanFragment.this.f14964q8;
            if (l0Var == null) {
                f0.S("viewBinding");
                l0Var = null;
            }
            TextView textView = l0Var.f10181c;
            v0 v0Var = v0.f37964a;
            String str = String.format("%ss", Arrays.copyOf(new Object[]{String.valueOf(j10 - 1)}, 1));
            f0.o(str, "format(format, *args)");
            textView.setText(str);
        }

        @Override // m5.a, xi.g0
        public void onComplete() {
            m9.s.e0();
            l0 l0Var = DFUScanFragment.this.f14964q8;
            if (l0Var == null) {
                f0.S("viewBinding");
                l0Var = null;
            }
            TextView textView = l0Var.f10185g;
            f0.o(textView, "viewBinding.tvMessageWarning");
            Boolean bool = Boolean.TRUE;
            o5.c.b(textView, bool, false, 2, null);
            l0 l0Var2 = DFUScanFragment.this.f14964q8;
            if (l0Var2 == null) {
                f0.S("viewBinding");
                l0Var2 = null;
            }
            Button button = l0Var2.f10180b;
            f0.o(button, "viewBinding.btnScan");
            o5.c.b(button, bool, false, 2, null);
            l0 l0Var3 = DFUScanFragment.this.f14964q8;
            if (l0Var3 == null) {
                f0.S("viewBinding");
                l0Var3 = null;
            }
            LinearLayout linearLayout = l0Var3.f10183e;
            f0.o(linearLayout, "viewBinding.llScanning");
            o5.c.b(linearLayout, Boolean.FALSE, false, 2, null);
        }

        @Override // m5.a, xi.g0
        public /* bridge */ /* synthetic */ void onNext(Object obj) {
            a(((Number) obj).longValue());
        }

        @Override // m5.a, xi.g0
        public void onSubscribe(@yt.k io.reactivex.disposables.b d10) {
            f0.p(d10, "d");
            l0 l0Var = DFUScanFragment.this.f14964q8;
            l0 l0Var2 = null;
            if (l0Var == null) {
                f0.S("viewBinding");
                l0Var = null;
            }
            Button button = l0Var.f10180b;
            f0.o(button, "viewBinding.btnScan");
            o5.c.b(button, Boolean.FALSE, false, 2, null);
            l0 l0Var3 = DFUScanFragment.this.f14964q8;
            if (l0Var3 == null) {
                f0.S("viewBinding");
                l0Var3 = null;
            }
            LinearLayout linearLayout = l0Var3.f10183e;
            f0.o(linearLayout, "viewBinding.llScanning");
            o5.c.b(linearLayout, Boolean.TRUE, false, 2, null);
            l0 l0Var4 = DFUScanFragment.this.f14964q8;
            if (l0Var4 == null) {
                f0.S("viewBinding");
            } else {
                l0Var2 = l0Var4;
            }
            TextView textView = l0Var2.f10181c;
            v0 v0Var = v0.f37964a;
            String str = String.format("%ss", Arrays.copyOf(new Object[]{String.valueOf(this.f14967b)}, 1));
            f0.o(str, "format(format, *args)");
            textView.setText(str);
        }
    }

    @hk.m
    @yt.k
    public static final DFUScanFragment m6(@yt.k String str, boolean z10) {
        return f14961s8.a(str, z10);
    }

    public static final void n6(DFUScanFragment this_run) {
        f0.p(this_run, "$this_run");
        l0 l0Var = this_run.f14964q8;
        if (l0Var == null) {
            f0.S("viewBinding");
            l0Var = null;
        }
        TextView textView = l0Var.f10185g;
        f0.o(textView, "viewBinding.tvMessageWarning");
        o5.c.b(textView, Boolean.TRUE, false, 2, null);
    }

    public static final void o6(int i10, final DFUScanFragment this$0) {
        f0.p(this$0, "this$0");
        if (i10 == 8) {
            o5.a.t0(this$0.L2(), new FZDialog.a().t(this$0.c3(R.string.device_msg_location_permission_on_10_title)).j(this$0.c3(R.string.device_msg_location_permission_on_10)).d(this$0.c3(R.string.cancel)).g(this$0.c3(R.string.device_setting_now)).b(Boolean.FALSE).f(new FZDialog.c() { // from class: com.flydigi.device_manager.ui.firmware.dfu.c
                @Override // com.flydigi.base.widget.FZDialog.c
                public final void a(DialogFragment dialogFragment) {
                    DFUScanFragment.p6(this.f14977a, dialogFragment);
                }
            }).c(new FZDialog.c() { // from class: com.flydigi.device_manager.ui.firmware.dfu.f
                @Override // com.flydigi.base.widget.FZDialog.c
                public final void a(DialogFragment dialogFragment) {
                    DFUScanFragment.r6(dialogFragment);
                }
            }).a());
        } else if (i10 == 9) {
            o5.a.t0(this$0.L2(), new FZDialog.a().t(this$0.c3(R.string.device_need_find_location_permission)).j(this$0.c3(R.string.device_need_find_location_permission_msg)).d(this$0.c3(R.string.cancel)).g(this$0.c3(R.string.device_setting_now)).b(Boolean.FALSE).f(new FZDialog.c() { // from class: com.flydigi.device_manager.ui.firmware.dfu.d
                @Override // com.flydigi.base.widget.FZDialog.c
                public final void a(DialogFragment dialogFragment) {
                    DFUScanFragment.s6(this.f14978a, dialogFragment);
                }
            }).c(new FZDialog.c() { // from class: com.flydigi.device_manager.ui.firmware.dfu.e
                @Override // com.flydigi.base.widget.FZDialog.c
                public final void a(DialogFragment dialogFragment) {
                    DFUScanFragment.u6(dialogFragment);
                }
            }).a());
        }
        l0 l0Var = this$0.f14964q8;
        if (l0Var == null) {
            f0.S("viewBinding");
            l0Var = null;
        }
        TextView textView = l0Var.f10185g;
        f0.o(textView, "viewBinding.tvMessageWarning");
        Boolean bool = Boolean.TRUE;
        o5.c.b(textView, bool, false, 2, null);
        l0 l0Var2 = this$0.f14964q8;
        if (l0Var2 == null) {
            f0.S("viewBinding");
            l0Var2 = null;
        }
        Button button = l0Var2.f10180b;
        f0.o(button, "viewBinding.btnScan");
        o5.c.b(button, bool, false, 2, null);
        l0 l0Var3 = this$0.f14964q8;
        if (l0Var3 == null) {
            f0.S("viewBinding");
            l0Var3 = null;
        }
        LinearLayout linearLayout = l0Var3.f10183e;
        f0.o(linearLayout, "viewBinding.llScanning");
        o5.c.b(linearLayout, Boolean.FALSE, false, 2, null);
    }

    public static final void p6(final DFUScanFragment this$0, DialogFragment dialogFragment) {
        f0.p(this$0, "this$0");
        f0.p(dialogFragment, "dialogFragment");
        dialogFragment.I5();
        Intent intent = new Intent();
        intent.setAction("android.settings.LOCATION_SOURCE_SETTINGS");
        z zVarE = RxActivityResult.b(this$0).e(intent);
        final ik.l<rx_activity_result2.f<DFUScanFragment>, z1> lVar = new ik.l<rx_activity_result2.f<DFUScanFragment>, z1>() { // from class: com.flydigi.device_manager.ui.firmware.dfu.DFUScanFragment$onScanFailed$1$dialog$1$1
            {
                super(1);
            }

            public final void b(rx_activity_result2.f<DFUScanFragment> fVar) {
                this.this$0.y6();
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(rx_activity_result2.f<DFUScanFragment> fVar) {
                b(fVar);
                return z1.f38230a;
            }
        };
        zVarE.E5(new dj.g() { // from class: com.flydigi.device_manager.ui.firmware.dfu.g
            @Override // dj.g
            public final void accept(Object obj) {
                DFUScanFragment.q6(lVar, obj);
            }
        });
    }

    public static final void q6(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void r6(DialogFragment dialogFragment) {
        dialogFragment.H5();
    }

    public static final void s6(final DFUScanFragment this$0, DialogFragment dialogFragment) {
        f0.p(this$0, "this$0");
        f0.p(dialogFragment, "dialogFragment");
        dialogFragment.I5();
        Intent intent = new Intent();
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        Context contextX1 = this$0.X1();
        intent.setData(Uri.fromParts("package", contextX1 != null ? contextX1.getPackageName() : null, null));
        z zVarE = RxActivityResult.b(this$0).e(intent);
        final ik.l<rx_activity_result2.f<DFUScanFragment>, z1> lVar = new ik.l<rx_activity_result2.f<DFUScanFragment>, z1>() { // from class: com.flydigi.device_manager.ui.firmware.dfu.DFUScanFragment$onScanFailed$1$dialog$3$1
            {
                super(1);
            }

            public final void b(rx_activity_result2.f<DFUScanFragment> fVar) {
                this.this$0.y6();
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(rx_activity_result2.f<DFUScanFragment> fVar) {
                b(fVar);
                return z1.f38230a;
            }
        };
        zVarE.E5(new dj.g() { // from class: com.flydigi.device_manager.ui.firmware.dfu.h
            @Override // dj.g
            public final void accept(Object obj) {
                DFUScanFragment.t6(lVar, obj);
            }
        });
    }

    public static final void t6(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void u6(DialogFragment dialogFragment) {
        dialogFragment.H5();
    }

    public static final void v6(DFUScanFragment this$0) {
        f0.p(this$0, "this$0");
        l0 l0Var = this$0.f14964q8;
        if (l0Var == null) {
            f0.S("viewBinding");
            l0Var = null;
        }
        TextView textView = l0Var.f10185g;
        f0.o(textView, "viewBinding.tvMessageWarning");
        o5.c.b(textView, Boolean.FALSE, false, 2, null);
        this$0.x6();
    }

    public static final void w6(DFUScanFragment this$0, View view) {
        f0.p(this$0, "this$0");
        this$0.y6();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.flydigi.base.common.BaseFragment, androidx.fragment.app.Fragment
    public void H3(@yt.k Context context) {
        f0.p(context, "context");
        super.H3(context);
        if (context instanceof b) {
            this.f14965r8 = (b) context;
        }
    }

    @Override // com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void K3(@yt.l Bundle bundle) {
        super.K3(bundle);
        Bundle bundleT1 = T1();
        if (bundleT1 != null) {
            String string = bundleT1.getString("key_device_code");
            if (string == null) {
                string = "all";
            } else {
                f0.o(string, "it.getString(DataConstan…eviceCode.DEVICE_CODE_ALL");
            }
            this.f14962o8 = string;
            this.f14963p8 = bundleT1.getBoolean(DataConstant.DEVICE_KEY_FIRMWARE_FORCE_LATEST, false);
        }
    }

    @Override // com.flydigi.base.common.FZFragment
    public int L5() {
        return R.layout.device_fragment_dfu_scan;
    }

    @Override // com.flydigi.base.common.FZFragment, com.flydigi.base.common.BaseFragment, androidx.fragment.app.Fragment
    @yt.k
    public View O3(@yt.k LayoutInflater inflater, @yt.l ViewGroup viewGroup, @yt.l Bundle bundle) {
        f0.p(inflater, "inflater");
        l0 l0VarD = l0.d(inflater, viewGroup, false);
        f0.o(l0VarD, "inflate(inflater, container, false)");
        this.f14964q8 = l0VarD;
        if (l0VarD == null) {
            f0.S("viewBinding");
            l0VarD = null;
        }
        ConstraintLayout root = l0VarD.getRoot();
        f0.o(root, "viewBinding.root");
        return root;
    }

    @Override // com.flydigi.sdk.bluetooth.m
    public void P(boolean z10) {
        m.a.e(this, z10);
    }

    @Override // com.flydigi.sdk.bluetooth.m
    public void R0() {
        m.a.a(this);
    }

    @Override // com.flydigi.base.common.FZFragment, com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void a4() {
        super.a4();
        m9.s.e0();
    }

    @Override // com.flydigi.sdk.bluetooth.m
    public void b0() {
        m.a.b(this);
    }

    @Override // com.flydigi.base.common.FZFragment, com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void f4() {
        super.f4();
        H5().f(new Runnable() { // from class: com.flydigi.device_manager.ui.firmware.dfu.k
            @Override // java.lang.Runnable
            public final void run() {
                this.f14986a.y6();
            }
        }, 250L);
    }

    @Override // com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void h4() {
        super.h4();
        m9.s.A(this);
    }

    @Override // com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void i4() {
        super.i4();
        m9.s.i0(this);
    }

    @Override // com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void j4(@yt.k View view, @yt.l Bundle bundle) {
        f0.p(view, "view");
        super.j4(view, bundle);
        l0 l0Var = this.f14964q8;
        l0 l0Var2 = null;
        if (l0Var == null) {
            f0.S("viewBinding");
            l0Var = null;
        }
        TextView textView = l0Var.f10186h;
        int i10 = R.string.device_firmware_upgrade_dfu_scan_title;
        Object[] objArr = new Object[1];
        String str = this.f14962o8;
        objArr[0] = f0.g(str, m9.h.f40774q) ? c3(R.string.device_name_d1) : f0.g(str, m9.h.f40773p) ? c3(R.string.device_name_q1) : c3(R.string.device_name_gamepad);
        textView.setText(d3(i10, objArr));
        l0 l0Var3 = this.f14964q8;
        if (l0Var3 == null) {
            f0.S("viewBinding");
            l0Var3 = null;
        }
        TextView textView2 = l0Var3.f10185g;
        int i11 = R.string.device_firmware_upgrade_dfu_scan_message;
        Object[] objArr2 = new Object[1];
        String str2 = this.f14962o8;
        objArr2[0] = f0.g(str2, m9.h.f40774q) ? c3(R.string.device_name_d1) : f0.g(str2, m9.h.f40773p) ? c3(R.string.device_name_q1) : c3(R.string.device_name_gamepad);
        textView2.setText(d3(i11, objArr2));
        l0 l0Var4 = this.f14964q8;
        if (l0Var4 == null) {
            f0.S("viewBinding");
            l0Var4 = null;
        }
        l0Var4.f10184f.setText(Html.fromHtml(c3(a5.b.b(this.f14962o8))));
        l5.a aVarB = l5.a.b();
        l0 l0Var5 = this.f14964q8;
        if (l0Var5 == null) {
            f0.S("viewBinding");
            l0Var5 = null;
        }
        aVarB.i(this, l0Var5.f10182d, a5.b.a(this.f14962o8));
        l0 l0Var6 = this.f14964q8;
        if (l0Var6 == null) {
            f0.S("viewBinding");
        } else {
            l0Var2 = l0Var6;
        }
        com.blankj.utilcode.util.o.r(l0Var2.f10180b, new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.firmware.dfu.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                DFUScanFragment.w6(this.f14975a, view2);
            }
        });
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
        b bVar;
        Object next;
        BluetoothDevice bluetoothDeviceF;
        f0.p(devices, "devices");
        e0.a.a(this, devices);
        Iterator<T> it2 = devices.iterator();
        while (true) {
            bVar = null;
            if (!it2.hasNext()) {
                next = null;
                break;
            }
            next = it2.next();
            String name = ((BleDevice) next).F().getName();
            f0.o(name, "it.device.name");
            if (kotlin.text.u.t2(name, "dfu", true)) {
                break;
            }
        }
        BleDevice bleDevice = (BleDevice) next;
        if (bleDevice == null || (bluetoothDeviceF = bleDevice.F()) == null) {
            H5().e(new Runnable() { // from class: com.flydigi.device_manager.ui.firmware.dfu.b
                @Override // java.lang.Runnable
                public final void run() {
                    DFUScanFragment.n6(this.f14976a);
                }
            });
            return;
        }
        String strI = m9.t.i(bluetoothDeviceF.getName());
        if (!n0.b(strI, m9.h.f40778u) || !n0.b(this.f14962o8, m9.h.f40783z)) {
            this.f14962o8 = strI;
        }
        b bVar2 = this.f14965r8;
        if (bVar2 == null) {
            f0.S("listener");
        } else {
            bVar = bVar2;
        }
        String str = this.f14962o8;
        String address = bluetoothDeviceF.getAddress();
        f0.o(address, "it.address");
        bVar.i(str, address, 0);
    }

    @Override // com.flydigi.sdk.bluetooth.e0
    public void s2() {
        e0.a.d(this);
    }

    @Override // com.flydigi.sdk.bluetooth.e0
    public void t0() {
        e0.a.c(this);
        H5().e(new Runnable() { // from class: com.flydigi.device_manager.ui.firmware.dfu.j
            @Override // java.lang.Runnable
            public final void run() {
                DFUScanFragment.v6(this.f14985a);
            }
        });
    }

    @Override // com.flydigi.sdk.bluetooth.e0
    public void x0(final int i10) {
        e0.a.b(this, i10);
        H5().e(new Runnable() { // from class: com.flydigi.device_manager.ui.firmware.dfu.i
            @Override // java.lang.Runnable
            public final void run() {
                DFUScanFragment.o6(i10, this);
            }
        });
    }

    public final void x6() {
        o5.l.f(10).s0(o5.l.d()).s0(y1()).c(new c(10));
    }

    public final void y6() {
        m9.s.c0(this, 2);
    }
}
