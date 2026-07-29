package com.flydigi.cyberfox.ui.connect;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import com.blankj.utilcode.util.PermissionUtils;
import com.blankj.utilcode.util.n0;
import com.blankj.utilcode.util.o;
import com.flydigi.base.common.FZFragment;
import com.flydigi.base.widget.FZDialog;
import com.flydigi.cyberfox.R;
import com.flydigi.cyberfox.ui.connect.ConnectHelpDialog;
import com.flydigi.data.DataConstant;
import com.flydigi.sdk.bluetooth.data.BleDevice;
import com.flydigi.sdk.bluetooth.e0;
import com.flydigi.sdk.bluetooth.t;
import i9.a;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.jvm.internal.u;
import kotlin.z1;
import rx_activity_result2.RxActivityResult;
import xi.z;

/* JADX INFO: loaded from: classes7.dex */
@t0({"SMAP\nConnectFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConnectFragment.kt\ncom/flydigi/cyberfox/ui/connect/ConnectFragment\n+ 2 Handler.kt\nandroidx/core/os/HandlerKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,300:1\n33#2,12:301\n288#3,2:313\n288#3,2:315\n*S KotlinDebug\n*F\n+ 1 ConnectFragment.kt\ncom/flydigi/cyberfox/ui/connect/ConnectFragment\n*L\n169#1:301,12\n261#1:313,2\n272#1:315,2\n*E\n"})
public final class ConnectFragment extends FZFragment implements t, e0 {

    /* JADX INFO: renamed from: q8, reason: collision with root package name */
    @yt.k
    public static final a f14215q8 = new a(null);

    /* JADX INFO: renamed from: o8, reason: collision with root package name */
    public h6.i f14216o8;

    /* JADX INFO: renamed from: p8, reason: collision with root package name */
    @yt.k
    public String f14217p8 = "all";

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @yt.k
        public final ConnectFragment a(@yt.k String deviceCode) {
            f0.p(deviceCode, "deviceCode");
            ConnectFragment connectFragment = new ConnectFragment();
            Bundle bundle = new Bundle();
            bundle.putString("key_device_code", deviceCode);
            connectFragment.c5(bundle);
            return connectFragment;
        }
    }

    @t0({"SMAP\nHandler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Handler.kt\nandroidx/core/os/HandlerKt$postDelayed$runnable$1\n+ 2 ConnectFragment.kt\ncom/flydigi/cyberfox/ui/connect/ConnectFragment\n*L\n1#1,69:1\n170#2,2:70\n*E\n"})
    public static final class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ConnectFragment.this.y6();
        }
    }

    public static final void n6(ConnectFragment this$0) {
        f0.p(this$0, "this$0");
        this$0.m6();
    }

    public static final void o6(int i10, final ConnectFragment this$0) {
        f0.p(this$0, "this$0");
        if (i10 == 8) {
            o5.a.t0(this$0.L2(), new FZDialog.a().t(this$0.c3(R.string.cf_msg_location_permission_on_10_title)).j(this$0.c3(R.string.cf_msg_location_permission_on_10)).d(this$0.c3(R.string.cancel)).g(this$0.c3(R.string.cf_setting_now)).b(Boolean.FALSE).f(new FZDialog.c() { // from class: com.flydigi.cyberfox.ui.connect.d
                @Override // com.flydigi.base.widget.FZDialog.c
                public final void a(DialogFragment dialogFragment) {
                    ConnectFragment.s6(this.f14222a, dialogFragment);
                }
            }).c(new FZDialog.c() { // from class: com.flydigi.cyberfox.ui.connect.h
                @Override // com.flydigi.base.widget.FZDialog.c
                public final void a(DialogFragment dialogFragment) {
                    ConnectFragment.u6(dialogFragment);
                }
            }).a());
        } else if (i10 != 9) {
            this$0.m6();
        } else {
            o5.a.t0(this$0.L2(), new FZDialog.a().t(this$0.c3(R.string.cf_need_find_location_permission)).j(this$0.c3(R.string.cf_need_find_location_permission_msg)).d(this$0.c3(R.string.cancel)).g(this$0.c3(R.string.cf_setting_now)).b(Boolean.FALSE).f(new FZDialog.c() { // from class: com.flydigi.cyberfox.ui.connect.e
                @Override // com.flydigi.base.widget.FZDialog.c
                public final void a(DialogFragment dialogFragment) {
                    ConnectFragment.p6(this.f14223a, dialogFragment);
                }
            }).c(new FZDialog.c() { // from class: com.flydigi.cyberfox.ui.connect.g
                @Override // com.flydigi.base.widget.FZDialog.c
                public final void a(DialogFragment dialogFragment) {
                    ConnectFragment.r6(dialogFragment);
                }
            }).a());
        }
    }

    public static final void p6(final ConnectFragment this$0, DialogFragment dialogFragment) {
        f0.p(this$0, "this$0");
        f0.p(dialogFragment, "dialogFragment");
        dialogFragment.I5();
        Intent intent = new Intent();
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        Context contextX1 = this$0.X1();
        intent.setData(Uri.fromParts("package", contextX1 != null ? contextX1.getPackageName() : null, null));
        z zVarE = RxActivityResult.b(this$0).e(intent);
        final ik.l<rx_activity_result2.f<ConnectFragment>, z1> lVar = new ik.l<rx_activity_result2.f<ConnectFragment>, z1>() { // from class: com.flydigi.cyberfox.ui.connect.ConnectFragment$onScanFailed$1$dialog$3$1
            {
                super(1);
            }

            public final void b(rx_activity_result2.f<ConnectFragment> fVar) {
                this.this$0.m6();
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(rx_activity_result2.f<ConnectFragment> fVar) {
                b(fVar);
                return z1.f38230a;
            }
        };
        zVarE.E5(new dj.g() { // from class: com.flydigi.cyberfox.ui.connect.j
            @Override // dj.g
            public final void accept(Object obj) {
                ConnectFragment.q6(lVar, obj);
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

    public static final void s6(final ConnectFragment this$0, DialogFragment dialogFragment) {
        f0.p(this$0, "this$0");
        f0.p(dialogFragment, "dialogFragment");
        dialogFragment.I5();
        Intent intent = new Intent();
        intent.setAction("android.settings.LOCATION_SOURCE_SETTINGS");
        z zVarE = RxActivityResult.b(this$0).e(intent);
        final ik.l<rx_activity_result2.f<ConnectFragment>, z1> lVar = new ik.l<rx_activity_result2.f<ConnectFragment>, z1>() { // from class: com.flydigi.cyberfox.ui.connect.ConnectFragment$onScanFailed$1$dialog$1$1
            {
                super(1);
            }

            public final void b(rx_activity_result2.f<ConnectFragment> fVar) {
                this.this$0.m6();
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(rx_activity_result2.f<ConnectFragment> fVar) {
                b(fVar);
                return z1.f38230a;
            }
        };
        zVarE.E5(new dj.g() { // from class: com.flydigi.cyberfox.ui.connect.i
            @Override // dj.g
            public final void accept(Object obj) {
                ConnectFragment.t6(lVar, obj);
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

    public static final void v6(ConnectFragment this$0, View view) {
        f0.p(this$0, "this$0");
        o5.f.e(this$0.X1());
    }

    public static final void w6(ConnectFragment this$0, View view) {
        f0.p(this$0, "this$0");
        this$0.x6();
    }

    public static final void z6(ConnectFragment this$0, DialogFragment dialogFragment) {
        f0.p(this$0, "this$0");
        q9.f.F(this$0, 1);
        dialogFragment.I5();
    }

    @Override // com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void K3(@yt.l Bundle bundle) {
        androidx.fragment.app.g gVarW1;
        super.K3(bundle);
        Bundle bundleT1 = T1();
        if (bundleT1 != null) {
            String string = bundleT1.getString("key_device_code");
            if (string == null) {
                string = "all";
            } else {
                f0.o(string, "it.getString(DataConstan…eviceCode.DEVICE_CODE_ALL");
            }
            this.f14217p8 = string;
        }
        if (!(this.f14217p8.length() == 0) || (gVarW1 = w1()) == null) {
            return;
        }
        gVarW1.finish();
    }

    @Override // com.flydigi.base.common.FZFragment
    public int L5() {
        return R.layout.cf_fragment_connect;
    }

    @Override // com.flydigi.sdk.bluetooth.t
    public void N(@yt.l BluetoothDevice bluetoothDevice) {
        t.a.b(this, bluetoothDevice);
    }

    @Override // com.flydigi.base.common.FZFragment, com.flydigi.base.common.BaseFragment, androidx.fragment.app.Fragment
    @yt.k
    public View O3(@yt.k LayoutInflater inflater, @yt.l ViewGroup viewGroup, @yt.l Bundle bundle) {
        f0.p(inflater, "inflater");
        h6.i iVarD = h6.i.d(inflater, viewGroup, false);
        f0.o(iVarD, "inflate(inflater, container, false)");
        this.f14216o8 = iVarD;
        if (iVarD == null) {
            f0.S("viewBinding");
            iVarD = null;
        }
        LinearLayout root = iVarD.getRoot();
        f0.o(root, "viewBinding.root");
        return root;
    }

    @Override // com.flydigi.sdk.bluetooth.t
    public void e0(@yt.l BluetoothDevice bluetoothDevice) {
        t.a.a(this, bluetoothDevice);
        H5().f(new Runnable() { // from class: com.flydigi.cyberfox.ui.connect.b
            @Override // java.lang.Runnable
            public final void run() {
                ConnectFragment.n6(this.f14220a);
            }
        }, 1000L);
    }

    @Override // com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void h4() {
        super.h4();
        q9.f.u(this);
        m6();
    }

    @Override // com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void i4() {
        super.i4();
        q9.f.H();
        q9.f.I(this);
    }

    @Override // com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void j4(@yt.k View view, @yt.l Bundle bundle) {
        f0.p(view, "view");
        super.j4(view, bundle);
        h6.i iVar = this.f14216o8;
        if (iVar == null) {
            f0.S("viewBinding");
            iVar = null;
        }
        iVar.f30607h.setText(n0.b(this.f14217p8, q9.c.f47166c) ? R.string.cf_label_connect_power_on_cyberfox : R.string.cf_label_connect_power_on_cyberfox_t1);
        h6.i iVar2 = this.f14216o8;
        if (iVar2 == null) {
            f0.S("viewBinding");
            iVar2 = null;
        }
        iVar2.f30606g.setText(n0.b(this.f14217p8, q9.c.f47166c) ? R.string.cf_label_connect_power_on_desc_cyberfox : R.string.cf_label_connect_power_on_desc_cyberfox_t1);
        h6.i iVar3 = this.f14216o8;
        if (iVar3 == null) {
            f0.S("viewBinding");
            iVar3 = null;
        }
        iVar3.f30603d.setImageResource(n0.b(this.f14217p8, q9.c.f47167d) ? R.drawable.cf_pic_power_on_t1 : n0.b(this.f14217p8, q9.c.f47168e) ? R.drawable.cf_pic_power_on_x1 : R.drawable.cf_pic_power_on_h1);
        h6.i iVar4 = this.f14216o8;
        if (iVar4 == null) {
            f0.S("viewBinding");
            iVar4 = null;
        }
        iVar4.f30604e.setImageResource(n0.b(this.f14217p8, q9.c.f47167d) ? R.drawable.cf_pic_bluetooth_t1 : n0.b(this.f14217p8, q9.c.f47168e) ? R.drawable.cf_pic_bluetooth_x1 : R.drawable.cf_pic_bluetooth_h1);
        h6.i iVar5 = this.f14216o8;
        if (iVar5 == null) {
            f0.S("viewBinding");
            iVar5 = null;
        }
        iVar5.f30605f.setText(d3(R.string.cf_label_connect_bluetooth_desc, q9.g.f47181a.b(this.f14217p8)));
        h6.i iVar6 = this.f14216o8;
        if (iVar6 == null) {
            f0.S("viewBinding");
            iVar6 = null;
        }
        o.r(iVar6.f30601b, new View.OnClickListener() { // from class: com.flydigi.cyberfox.ui.connect.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ConnectFragment.v6(this.f14219a, view2);
            }
        });
        if (n0.b(this.f14217p8, q9.c.f47167d) || n0.b(this.f14217p8, q9.c.f47168e)) {
            h6.i iVar7 = this.f14216o8;
            if (iVar7 == null) {
                f0.S("viewBinding");
                iVar7 = null;
            }
            TextView it2 = iVar7.f30602c;
            f0.o(it2, "it");
            o5.c.b(it2, Boolean.TRUE, false, 2, null);
            o.r(it2, new View.OnClickListener() { // from class: com.flydigi.cyberfox.ui.connect.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ConnectFragment.w6(this.f14221a, view2);
                }
            });
        }
    }

    public final void m6() {
        List<BluetoothDevice> listH = q9.f.h();
        if (!(!listH.isEmpty())) {
            Handler handler = G5();
            f0.o(handler, "handler");
            handler.postDelayed(new b(), 500L);
            return;
        }
        q9.g gVar = q9.g.f47181a;
        String name = listH.get(0).getName();
        f0.o(name, "devices[0].name");
        if (n0.b(this.f14217p8, gVar.a(name))) {
            androidx.fragment.app.g gVarW1 = w1();
            if (gVarW1 != null) {
                gVarW1.finish();
            }
            h3.a.j().d(a.d.f31949e).withString("key_device_code", this.f14217p8).withInt(DataConstant.DEVICE_KEY_DEVICE_TYPE, 2).navigation(w1());
        }
    }

    @Override // com.flydigi.sdk.bluetooth.e0
    public void q1(@yt.k List<BleDevice> devices) {
        Object obj;
        Object next;
        f0.p(devices, "devices");
        e0.a.a(this, devices);
        Iterator<T> it2 = devices.iterator();
        while (true) {
            obj = null;
            if (!it2.hasNext()) {
                next = null;
                break;
            }
            next = it2.next();
            String str = this.f14217p8;
            q9.g gVar = q9.g.f47181a;
            String strM = ((BleDevice) next).M();
            if (strM == null) {
                strM = "";
            }
            if (androidx.core.util.j.a(str, gVar.a(strM))) {
                break;
            }
        }
        BleDevice bleDevice = (BleDevice) next;
        if (bleDevice != null) {
            q9.f.H();
            bleDevice.F().createBond();
        }
        Iterator<T> it3 = devices.iterator();
        while (true) {
            if (!it3.hasNext()) {
                break;
            }
            Object next2 = it3.next();
            String strM2 = ((BleDevice) next2).M();
            boolean z10 = false;
            if (strM2 != null) {
                if (kotlin.text.u.t2(strM2, this.f14217p8 + "_ota_", true)) {
                    z10 = true;
                }
            }
            if (z10) {
                obj = next2;
                break;
            }
        }
        if (((BleDevice) obj) != null) {
            q9.f.H();
            o5.a.t0(U1(), ConnectHelpDialog.H8.a(this.f14217p8, 2));
        }
    }

    @Override // com.flydigi.sdk.bluetooth.e0
    public void s2() {
        e0.a.d(this);
    }

    @Override // com.flydigi.sdk.bluetooth.e0
    public void t0() {
        e0.a.c(this);
    }

    @Override // com.flydigi.sdk.bluetooth.e0
    public void x0(final int i10) {
        e0.a.b(this, i10);
        H5().e(new Runnable() { // from class: com.flydigi.cyberfox.ui.connect.k
            @Override // java.lang.Runnable
            public final void run() {
                ConnectFragment.o6(i10, this);
            }
        });
    }

    public final void x6() {
        o5.a.t0(U1(), ConnectHelpDialog.a.b(ConnectHelpDialog.H8, this.f14217p8, null, 2, null));
    }

    public final void y6() {
        if (Build.VERSION.SDK_INT >= 31 || PermissionUtils.z(w3.c.f53848d)) {
            q9.f.F(this, 1);
        } else {
            new FZDialog.a().t(d3(R.string.base_request_permission, c3(R.string.cf_location_permission))).j(c3(R.string.cf_location_permission_reason)).q(c3(R.string.next)).p(new FZDialog.c() { // from class: com.flydigi.cyberfox.ui.connect.f
                @Override // com.flydigi.base.widget.FZDialog.c
                public final void a(DialogFragment dialogFragment) {
                    ConnectFragment.z6(this.f14224a, dialogFragment);
                }
            }).a().Z5(U1(), "explainDialog");
        }
    }
}
