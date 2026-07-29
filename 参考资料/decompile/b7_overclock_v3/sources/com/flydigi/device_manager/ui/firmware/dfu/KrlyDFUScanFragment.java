package com.flydigi.device_manager.ui.firmware.dfu;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;
import c7.m0;
import com.blankj.utilcode.util.n0;
import com.blankj.utilcode.util.s0;
import com.flydigi.base.common.FZFragment;
import com.flydigi.base.widget.FZDialog;
import com.flydigi.data.DataConstant;
import com.flydigi.device_manager.R;
import com.flydigi.sdk.bluetooth.data.BleDevice;
import com.flydigi.sdk.bluetooth.e0;
import com.flydigi.sdk.bluetooth.m;
import com.flydigi.sdk.bluetooth.v;
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
@t0({"SMAP\nKrlyDFUScanFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 KrlyDFUScanFragment.kt\ncom/flydigi/device_manager/ui/firmware/dfu/KrlyDFUScanFragment\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,254:1\n288#2,2:255\n*S KotlinDebug\n*F\n+ 1 KrlyDFUScanFragment.kt\ncom/flydigi/device_manager/ui/firmware/dfu/KrlyDFUScanFragment\n*L\n222#1:255,2\n*E\n"})
public final class KrlyDFUScanFragment extends FZFragment implements com.flydigi.sdk.bluetooth.m, e0 {

    /* JADX INFO: renamed from: s8, reason: collision with root package name */
    @yt.k
    public static final a f14968s8 = new a(null);

    /* JADX INFO: renamed from: o8, reason: collision with root package name */
    @yt.k
    public String f14969o8 = "all";

    /* JADX INFO: renamed from: p8, reason: collision with root package name */
    public boolean f14970p8;

    /* JADX INFO: renamed from: q8, reason: collision with root package name */
    public m0 f14971q8;

    /* JADX INFO: renamed from: r8, reason: collision with root package name */
    public b f14972r8;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }

        @hk.m
        @yt.k
        public final KrlyDFUScanFragment a(@yt.k String deviceCode, boolean z10) {
            f0.p(deviceCode, "deviceCode");
            KrlyDFUScanFragment krlyDFUScanFragment = new KrlyDFUScanFragment();
            krlyDFUScanFragment.c5(androidx.core.os.e.b(new Pair("key_device_code", deviceCode), new Pair(DataConstant.DEVICE_KEY_FIRMWARE_FORCE_LATEST, Boolean.valueOf(z10))));
            return krlyDFUScanFragment;
        }
    }

    public interface b {
        void i(@yt.k String str, @yt.k String str2, int i10);
    }

    public static final class c extends m5.a<Long> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f14974b;

        public c(int i10) {
            this.f14974b = i10;
        }

        public void a(long j10) {
            m0 m0Var = KrlyDFUScanFragment.this.f14971q8;
            if (m0Var == null) {
                f0.S("viewBinding");
                m0Var = null;
            }
            TextView textView = m0Var.f10214c;
            v0 v0Var = v0.f37964a;
            String str = String.format("%ss", Arrays.copyOf(new Object[]{String.valueOf(j10 - 1)}, 1));
            f0.o(str, "format(format, *args)");
            textView.setText(str);
        }

        @Override // m5.a, xi.g0
        public void onComplete() {
            m9.s.e0();
            m0 m0Var = KrlyDFUScanFragment.this.f14971q8;
            if (m0Var == null) {
                f0.S("viewBinding");
                m0Var = null;
            }
            Button button = m0Var.f10213b;
            f0.o(button, "viewBinding.btnScan");
            o5.c.b(button, Boolean.TRUE, false, 2, null);
            m0 m0Var2 = KrlyDFUScanFragment.this.f14971q8;
            if (m0Var2 == null) {
                f0.S("viewBinding");
                m0Var2 = null;
            }
            LinearLayout linearLayout = m0Var2.f10217f;
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
            m0 m0Var = KrlyDFUScanFragment.this.f14971q8;
            m0 m0Var2 = null;
            if (m0Var == null) {
                f0.S("viewBinding");
                m0Var = null;
            }
            Button button = m0Var.f10213b;
            f0.o(button, "viewBinding.btnScan");
            o5.c.b(button, Boolean.FALSE, false, 2, null);
            m0 m0Var3 = KrlyDFUScanFragment.this.f14971q8;
            if (m0Var3 == null) {
                f0.S("viewBinding");
                m0Var3 = null;
            }
            LinearLayout linearLayout = m0Var3.f10217f;
            f0.o(linearLayout, "viewBinding.llScanning");
            o5.c.b(linearLayout, Boolean.TRUE, false, 2, null);
            m0 m0Var4 = KrlyDFUScanFragment.this.f14971q8;
            if (m0Var4 == null) {
                f0.S("viewBinding");
            } else {
                m0Var2 = m0Var4;
            }
            TextView textView = m0Var2.f10214c;
            v0 v0Var = v0.f37964a;
            String str = String.format("%ss", Arrays.copyOf(new Object[]{String.valueOf(this.f14974b)}, 1));
            f0.o(str, "format(format, *args)");
            textView.setText(str);
        }
    }

    @hk.m
    @yt.k
    public static final KrlyDFUScanFragment l6(@yt.k String str, boolean z10) {
        return f14968s8.a(str, z10);
    }

    public static final void m6(int i10, final KrlyDFUScanFragment this$0) {
        f0.p(this$0, "this$0");
        if (i10 == 8) {
            o5.a.t0(this$0.L2(), new FZDialog.a().t(this$0.c3(R.string.device_msg_location_permission_on_10_title)).j(this$0.c3(R.string.device_msg_location_permission_on_10)).d(this$0.c3(R.string.cancel)).g(this$0.c3(R.string.device_setting_now)).b(Boolean.FALSE).f(new FZDialog.c() { // from class: com.flydigi.device_manager.ui.firmware.dfu.m
                @Override // com.flydigi.base.widget.FZDialog.c
                public final void a(DialogFragment dialogFragment) {
                    KrlyDFUScanFragment.n6(this.f14988a, dialogFragment);
                }
            }).c(new FZDialog.c() { // from class: com.flydigi.device_manager.ui.firmware.dfu.p
                @Override // com.flydigi.base.widget.FZDialog.c
                public final void a(DialogFragment dialogFragment) {
                    KrlyDFUScanFragment.p6(dialogFragment);
                }
            }).a());
        } else if (i10 == 9) {
            o5.a.t0(this$0.L2(), new FZDialog.a().t(this$0.c3(R.string.device_need_find_location_permission)).j(this$0.c3(R.string.device_need_find_location_permission_msg)).d(this$0.c3(R.string.cancel)).g(this$0.c3(R.string.device_setting_now)).b(Boolean.FALSE).f(new FZDialog.c() { // from class: com.flydigi.device_manager.ui.firmware.dfu.n
                @Override // com.flydigi.base.widget.FZDialog.c
                public final void a(DialogFragment dialogFragment) {
                    KrlyDFUScanFragment.q6(this.f14989a, dialogFragment);
                }
            }).c(new FZDialog.c() { // from class: com.flydigi.device_manager.ui.firmware.dfu.o
                @Override // com.flydigi.base.widget.FZDialog.c
                public final void a(DialogFragment dialogFragment) {
                    KrlyDFUScanFragment.s6(dialogFragment);
                }
            }).a());
        }
        m0 m0Var = this$0.f14971q8;
        if (m0Var == null) {
            f0.S("viewBinding");
            m0Var = null;
        }
        Button button = m0Var.f10213b;
        f0.o(button, "viewBinding.btnScan");
        o5.c.b(button, Boolean.TRUE, false, 2, null);
        m0 m0Var2 = this$0.f14971q8;
        if (m0Var2 == null) {
            f0.S("viewBinding");
            m0Var2 = null;
        }
        LinearLayout linearLayout = m0Var2.f10217f;
        f0.o(linearLayout, "viewBinding.llScanning");
        o5.c.b(linearLayout, Boolean.FALSE, false, 2, null);
    }

    public static final void n6(final KrlyDFUScanFragment this$0, DialogFragment dialogFragment) {
        f0.p(this$0, "this$0");
        f0.p(dialogFragment, "dialogFragment");
        dialogFragment.I5();
        Intent intent = new Intent();
        intent.setAction("android.settings.LOCATION_SOURCE_SETTINGS");
        z zVarE = RxActivityResult.b(this$0).e(intent);
        final ik.l<rx_activity_result2.f<KrlyDFUScanFragment>, z1> lVar = new ik.l<rx_activity_result2.f<KrlyDFUScanFragment>, z1>() { // from class: com.flydigi.device_manager.ui.firmware.dfu.KrlyDFUScanFragment$onScanFailed$1$dialog$1$1
            {
                super(1);
            }

            public final void b(rx_activity_result2.f<KrlyDFUScanFragment> fVar) {
                this.this$0.w6();
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(rx_activity_result2.f<KrlyDFUScanFragment> fVar) {
                b(fVar);
                return z1.f38230a;
            }
        };
        zVarE.E5(new dj.g() { // from class: com.flydigi.device_manager.ui.firmware.dfu.q
            @Override // dj.g
            public final void accept(Object obj) {
                KrlyDFUScanFragment.o6(lVar, obj);
            }
        });
    }

    public static final void o6(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void p6(DialogFragment dialogFragment) {
        dialogFragment.H5();
    }

    public static final void q6(final KrlyDFUScanFragment this$0, DialogFragment dialogFragment) {
        f0.p(this$0, "this$0");
        f0.p(dialogFragment, "dialogFragment");
        dialogFragment.I5();
        Intent intent = new Intent();
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        Context contextX1 = this$0.X1();
        intent.setData(Uri.fromParts("package", contextX1 != null ? contextX1.getPackageName() : null, null));
        z zVarE = RxActivityResult.b(this$0).e(intent);
        final ik.l<rx_activity_result2.f<KrlyDFUScanFragment>, z1> lVar = new ik.l<rx_activity_result2.f<KrlyDFUScanFragment>, z1>() { // from class: com.flydigi.device_manager.ui.firmware.dfu.KrlyDFUScanFragment$onScanFailed$1$dialog$3$1
            {
                super(1);
            }

            public final void b(rx_activity_result2.f<KrlyDFUScanFragment> fVar) {
                this.this$0.w6();
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(rx_activity_result2.f<KrlyDFUScanFragment> fVar) {
                b(fVar);
                return z1.f38230a;
            }
        };
        zVarE.E5(new dj.g() { // from class: com.flydigi.device_manager.ui.firmware.dfu.r
            @Override // dj.g
            public final void accept(Object obj) {
                KrlyDFUScanFragment.r6(lVar, obj);
            }
        });
    }

    public static final void r6(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void s6(DialogFragment dialogFragment) {
        dialogFragment.H5();
    }

    public static final void t6(KrlyDFUScanFragment this$0) {
        f0.p(this$0, "this$0");
        this$0.v6();
    }

    public static final void u6(KrlyDFUScanFragment this$0, View view) {
        f0.p(this$0, "this$0");
        this$0.w6();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.flydigi.base.common.BaseFragment, androidx.fragment.app.Fragment
    public void H3(@yt.k Context context) {
        f0.p(context, "context");
        super.H3(context);
        if (context instanceof b) {
            this.f14972r8 = (b) context;
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
            this.f14969o8 = string;
            this.f14970p8 = bundleT1.getBoolean(DataConstant.DEVICE_KEY_FIRMWARE_FORCE_LATEST, false);
        }
    }

    @Override // com.flydigi.base.common.FZFragment
    public int L5() {
        return R.layout.device_fragment_dfu_scan_krly;
    }

    @Override // com.flydigi.base.common.FZFragment, com.flydigi.base.common.BaseFragment, androidx.fragment.app.Fragment
    @yt.k
    public View O3(@yt.k LayoutInflater inflater, @yt.l ViewGroup viewGroup, @yt.l Bundle bundle) {
        f0.p(inflater, "inflater");
        m0 m0VarD = m0.d(inflater, viewGroup, false);
        f0.o(m0VarD, "inflate(inflater, container, false)");
        this.f14971q8 = m0VarD;
        if (m0VarD == null) {
            f0.S("viewBinding");
            m0VarD = null;
        }
        ConstraintLayout root = m0VarD.getRoot();
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
        H5().f(new Runnable() { // from class: com.flydigi.device_manager.ui.firmware.dfu.t
            @Override // java.lang.Runnable
            public final void run() {
                this.f14996a.w6();
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
        int iL = s0.l("device_firmware_upgrade_scan_prepare_step_1_" + this.f14969o8);
        m0 m0Var = null;
        if (iL > 0) {
            m0 m0Var2 = this.f14971q8;
            if (m0Var2 == null) {
                f0.S("viewBinding");
                m0Var2 = null;
            }
            m0Var2.f10218g.setText(iL);
            m0 m0Var3 = this.f14971q8;
            if (m0Var3 == null) {
                f0.S("viewBinding");
                m0Var3 = null;
            }
            TextView textView = m0Var3.f10218g;
            f0.o(textView, "viewBinding.tvStep1");
            o5.c.b(textView, Boolean.TRUE, false, 2, null);
        } else {
            m0 m0Var4 = this.f14971q8;
            if (m0Var4 == null) {
                f0.S("viewBinding");
                m0Var4 = null;
            }
            TextView textView2 = m0Var4.f10218g;
            f0.o(textView2, "viewBinding.tvStep1");
            o5.c.b(textView2, Boolean.FALSE, false, 2, null);
        }
        int iL2 = s0.l("device_firmware_upgrade_scan_prepare_step_2_" + this.f14969o8);
        if (iL2 > 0) {
            m0 m0Var5 = this.f14971q8;
            if (m0Var5 == null) {
                f0.S("viewBinding");
                m0Var5 = null;
            }
            m0Var5.f10219h.setText(iL2);
            m0 m0Var6 = this.f14971q8;
            if (m0Var6 == null) {
                f0.S("viewBinding");
                m0Var6 = null;
            }
            TextView textView3 = m0Var6.f10219h;
            f0.o(textView3, "viewBinding.tvStep2");
            o5.c.b(textView3, Boolean.TRUE, false, 2, null);
        } else {
            m0 m0Var7 = this.f14971q8;
            if (m0Var7 == null) {
                f0.S("viewBinding");
                m0Var7 = null;
            }
            TextView textView4 = m0Var7.f10219h;
            f0.o(textView4, "viewBinding.tvStep2");
            o5.c.b(textView4, Boolean.FALSE, false, 2, null);
        }
        m0 m0Var8 = this.f14971q8;
        if (m0Var8 == null) {
            f0.S("viewBinding");
            m0Var8 = null;
        }
        m0Var8.f10215d.setImageResource(s0.g("device_firmware_upgrade_scan_prepare_step_1_" + this.f14969o8));
        m0 m0Var9 = this.f14971q8;
        if (m0Var9 == null) {
            f0.S("viewBinding");
            m0Var9 = null;
        }
        m0Var9.f10216e.setImageResource(s0.g("device_firmware_upgrade_scan_prepare_step_2_" + this.f14969o8));
        m0 m0Var10 = this.f14971q8;
        if (m0Var10 == null) {
            f0.S("viewBinding");
            m0Var10 = null;
        }
        TextView textView5 = m0Var10.f10220i;
        f0.o(textView5, "viewBinding.tvStep2Hint");
        o5.c.b(textView5, Boolean.valueOf(n0.b(this.f14969o8, m9.h.D) || n0.b(this.f14969o8, m9.h.F) || n0.b(this.f14969o8, m9.h.E)), false, 2, null);
        m0 m0Var11 = this.f14971q8;
        if (m0Var11 == null) {
            f0.S("viewBinding");
        } else {
            m0Var = m0Var11;
        }
        com.blankj.utilcode.util.o.r(m0Var.f10213b, new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.firmware.dfu.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                KrlyDFUScanFragment.u6(this.f14987a, view2);
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
            if (kotlin.text.u.t2(name, v.f16330f, true)) {
                break;
            }
        }
        BleDevice bleDevice = (BleDevice) next;
        if (bleDevice == null || (bluetoothDeviceF = bleDevice.F()) == null) {
            return;
        }
        String strI = m9.t.i(bluetoothDeviceF.getName());
        if (n0.b(strI, m9.h.D) || n0.b(strI, m9.h.F)) {
            this.f14969o8 = strI;
        }
        b bVar2 = this.f14972r8;
        if (bVar2 == null) {
            f0.S("listener");
        } else {
            bVar = bVar2;
        }
        String str = this.f14969o8;
        String address = bluetoothDeviceF.getAddress();
        f0.o(address, "it.address");
        bVar.i(str, address, 2);
    }

    @Override // com.flydigi.sdk.bluetooth.e0
    public void s2() {
        e0.a.d(this);
    }

    @Override // com.flydigi.sdk.bluetooth.e0
    public void t0() {
        e0.a.c(this);
        H5().e(new Runnable() { // from class: com.flydigi.device_manager.ui.firmware.dfu.u
            @Override // java.lang.Runnable
            public final void run() {
                KrlyDFUScanFragment.t6(this.f14997a);
            }
        });
    }

    public final void v6() {
        o5.l.f(10).s0(o5.l.d()).s0(y1()).c(new c(10));
    }

    public final void w6() {
        m9.s.c0(this, 2);
    }

    @Override // com.flydigi.sdk.bluetooth.e0
    public void x0(final int i10) {
        e0.a.b(this, i10);
        H5().e(new Runnable() { // from class: com.flydigi.device_manager.ui.firmware.dfu.s
            @Override // java.lang.Runnable
            public final void run() {
                KrlyDFUScanFragment.m6(i10, this);
            }
        });
    }
}
