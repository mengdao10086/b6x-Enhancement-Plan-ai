package com.flydigi.device_manager.ui;

import android.app.Activity;
import android.app.Dialog;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.Window;
import android.view.WindowManager;
import androidx.fragment.app.DialogFragment;
import com.android.motionelf.FloatingWindow;
import com.blankj.utilcode.util.PermissionUtils;
import com.flydigi.base.common.BaseDialogFragment;
import com.flydigi.base.common.y;
import com.flydigi.base.widget.FZDialog;
import com.flydigi.base.widget.LoadingDialogFragment;
import com.flydigi.data.DataConstant;
import com.flydigi.device_manager.R;
import com.flydigi.device_manager.ui.BleDialogFragment;
import com.flydigi.remote.DeviceInfo;
import com.flydigi.sdk.bluetooth.data.BleDevice;
import com.flydigi.sdk.bluetooth.e0;
import com.flydigi.sdk.bluetooth.m;
import com.flydigi.sdk.bluetooth.n;
import com.flydigi.sdk.gamepad.GamepadInfo;
import h9.b;
import i9.a;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.text.u;
import kotlin.z1;
import m9.r;
import m9.t;
import rx_activity_result2.RxActivityResult;
import xi.z;

/* JADX INFO: loaded from: classes7.dex */
@t0({"SMAP\nBleDialogFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BleDialogFragment.kt\ncom/flydigi/device_manager/ui/BleDialogFragment\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,533:1\n1#2:534\n1855#3,2:535\n*S KotlinDebug\n*F\n+ 1 BleDialogFragment.kt\ncom/flydigi/device_manager/ui/BleDialogFragment\n*L\n320#1:535,2\n*E\n"})
public abstract class BleDialogFragment extends BaseDialogFragment implements e0, com.flydigi.sdk.bluetooth.m, com.flydigi.sdk.bluetooth.n, m9.r {
    public boolean H8;
    public boolean I8;
    public boolean J8;
    public boolean K8;

    @yt.l
    public DialogFragment L8;

    @yt.l
    public GamepadInfo N8;

    @yt.l
    public h9.b O8;
    public boolean P8;

    @yt.k
    public final Handler E8 = new Handler();

    @yt.k
    public final y F8 = new y();

    @yt.k
    public String G8 = "all";

    @yt.k
    public final Runnable M8 = new Runnable() { // from class: com.flydigi.device_manager.ui.c
        @Override // java.lang.Runnable
        public final void run() {
            BleDialogFragment.a7(this.f14519a);
        }
    };

    @yt.k
    public final ServiceConnection Q8 = new b();

    @yt.k
    public final h9.c R8 = new a();

    public static final class a extends h9.e {
        public a() {
        }

        public static final void U0(BleDialogFragment this$0) {
            f0.p(this$0, "this$0");
            GamepadInfo gamepadInfoB6 = this$0.B6();
            if (gamepadInfoB6 != null) {
                this$0.L6(gamepadInfoB6);
            }
        }

        @Override // h9.e, h9.c
        public void H0(@yt.k DeviceInfo deviceInfo) {
            f0.p(deviceInfo, "deviceInfo");
            BleDialogFragment.this.d7(DeviceInfo.b(deviceInfo));
            y yVarI6 = BleDialogFragment.this.I6();
            final BleDialogFragment bleDialogFragment = BleDialogFragment.this;
            yVarI6.e(new Runnable() { // from class: com.flydigi.device_manager.ui.n
                @Override // java.lang.Runnable
                public final void run() {
                    BleDialogFragment.a.U0(bleDialogFragment);
                }
            });
        }
    }

    public static final class b implements ServiceConnection {
        public b() {
        }

        public static final void b(BleDialogFragment this$0) {
            f0.p(this$0, "this$0");
            GamepadInfo gamepadInfoB6 = this$0.B6();
            if (gamepadInfoB6 != null) {
                this$0.L6(gamepadInfoB6);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(@yt.l ComponentName componentName, @yt.l IBinder iBinder) {
            BleDialogFragment.this.O8 = b.AbstractBinderC0365b.Q0(iBinder);
            try {
                h9.b bVar = BleDialogFragment.this.O8;
                if (bVar != null) {
                    final BleDialogFragment bleDialogFragment = BleDialogFragment.this;
                    bVar.O(bleDialogFragment.R8);
                    bleDialogFragment.d7(DeviceInfo.b(bVar.E0()));
                    bleDialogFragment.I6().e(new Runnable() { // from class: com.flydigi.device_manager.ui.o
                        @Override // java.lang.Runnable
                        public final void run() {
                            BleDialogFragment.b.b(bleDialogFragment);
                        }
                    });
                }
            } catch (RemoteException unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(@yt.l ComponentName componentName) {
            BleDialogFragment.this.O8 = null;
        }
    }

    public static final void N6(DialogFragment dialogFragment) {
        dialogFragment.I5();
    }

    public static final void O6(DialogFragment dialogFragment) {
        dialogFragment.I5();
        h3.a.j().d(i9.a.f31902d).withString(DataConstant.WEB_URL, o5.p.d() ? com.flydigi.device_manager.o.f14476t : com.flydigi.device_manager.o.f14477u).navigation();
    }

    public static final void P6(DialogFragment dialogFragment) {
        dialogFragment.I5();
    }

    public static final void Q6(BluetoothDevice bluetoothDevice, GamepadInfo gamepadInfo, BleDialogFragment this$0) {
        f0.p(gamepadInfo, "$gamepadInfo");
        f0.p(this$0, "this$0");
        if (bluetoothDevice != null) {
            if (!(Build.VERSION.SDK_INT >= 30 && com.blankj.utilcode.util.t0.B() && gamepadInfo.getDeviceType() == 16) && this$0.x6(gamepadInfo)) {
                this$0.R6(bluetoothDevice, gamepadInfo);
            }
        }
    }

    public static final void T6(final BleDialogFragment this$0, int i10) {
        f0.p(this$0, "this$0");
        this$0.z6();
        if (i10 == 8) {
            o5.a.t0(this$0.L2(), new FZDialog.a().t(this$0.c3(R.string.device_msg_location_permission_on_10_title)).j(this$0.c3(R.string.device_msg_location_permission_on_10)).d(this$0.c3(R.string.cancel)).g(this$0.c3(R.string.device_setting_now)).b(Boolean.FALSE).f(new FZDialog.c() { // from class: com.flydigi.device_manager.ui.a
                @Override // com.flydigi.base.widget.FZDialog.c
                public final void a(DialogFragment dialogFragment) {
                    BleDialogFragment.U6(this.f14489a, dialogFragment);
                }
            }).c(new FZDialog.c() { // from class: com.flydigi.device_manager.ui.e
                @Override // com.flydigi.base.widget.FZDialog.c
                public final void a(DialogFragment dialogFragment) {
                    BleDialogFragment.W6(this.f14948a, dialogFragment);
                }
            }).a());
        } else {
            if (i10 != 9) {
                return;
            }
            o5.a.t0(this$0.L2(), new FZDialog.a().t(this$0.c3(R.string.device_need_find_location_permission)).j(this$0.c3(R.string.device_need_find_location_permission_msg)).d(this$0.c3(R.string.cancel)).g(this$0.c3(R.string.device_setting_now)).b(Boolean.FALSE).f(new FZDialog.c() { // from class: com.flydigi.device_manager.ui.g
                @Override // com.flydigi.base.widget.FZDialog.c
                public final void a(DialogFragment dialogFragment) {
                    BleDialogFragment.X6(this.f15118a, dialogFragment);
                }
            }).c(new FZDialog.c() { // from class: com.flydigi.device_manager.ui.f
                @Override // com.flydigi.base.widget.FZDialog.c
                public final void a(DialogFragment dialogFragment) {
                    BleDialogFragment.Z6(this.f14949a, dialogFragment);
                }
            }).a());
        }
    }

    public static final void U6(final BleDialogFragment this$0, DialogFragment dialogFragment) {
        f0.p(this$0, "this$0");
        f0.p(dialogFragment, "dialogFragment");
        this$0.e6();
        dialogFragment.I5();
        Intent intent = new Intent();
        intent.setAction("android.settings.LOCATION_SOURCE_SETTINGS");
        z zVarE = RxActivityResult.b(this$0).e(intent);
        final ik.l<rx_activity_result2.f<BleDialogFragment>, z1> lVar = new ik.l<rx_activity_result2.f<BleDialogFragment>, z1>() { // from class: com.flydigi.device_manager.ui.BleDialogFragment$onScanFailed$1$dialog$1$1
            {
                super(1);
            }

            public final void b(rx_activity_result2.f<BleDialogFragment> fVar) {
                this.this$0.k7();
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(rx_activity_result2.f<BleDialogFragment> fVar) {
                b(fVar);
                return z1.f38230a;
            }
        };
        zVarE.E5(new dj.g() { // from class: com.flydigi.device_manager.ui.l
            @Override // dj.g
            public final void accept(Object obj) {
                BleDialogFragment.V6(lVar, obj);
            }
        });
    }

    public static final void V6(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void W6(BleDialogFragment bleDialogFragment, DialogFragment dialogFragment) {
        bleDialogFragment.e6();
        dialogFragment.H5();
    }

    public static final void X6(final BleDialogFragment this$0, DialogFragment dialogFragment) {
        f0.p(this$0, "this$0");
        f0.p(dialogFragment, "dialogFragment");
        dialogFragment.I5();
        Intent intent = new Intent();
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        Context contextX1 = this$0.X1();
        intent.setData(Uri.fromParts("package", contextX1 != null ? contextX1.getPackageName() : null, null));
        z zVarE = RxActivityResult.b(this$0).e(intent);
        final ik.l<rx_activity_result2.f<BleDialogFragment>, z1> lVar = new ik.l<rx_activity_result2.f<BleDialogFragment>, z1>() { // from class: com.flydigi.device_manager.ui.BleDialogFragment$onScanFailed$1$dialog$3$1
            {
                super(1);
            }

            public final void b(rx_activity_result2.f<BleDialogFragment> fVar) {
                this.this$0.k7();
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(rx_activity_result2.f<BleDialogFragment> fVar) {
                b(fVar);
                return z1.f38230a;
            }
        };
        zVarE.E5(new dj.g() { // from class: com.flydigi.device_manager.ui.m
            @Override // dj.g
            public final void accept(Object obj) {
                BleDialogFragment.Y6(lVar, obj);
            }
        });
        this$0.e6();
    }

    public static final void Y6(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void Z6(BleDialogFragment bleDialogFragment, DialogFragment dialogFragment) {
        bleDialogFragment.e6();
        dialogFragment.H5();
    }

    public static final void a7(BleDialogFragment this$0) {
        f0.p(this$0, "this$0");
        this$0.M6();
    }

    public static final void l7(DialogFragment dialogFragment) {
        Activity activityP = com.blankj.utilcode.util.a.P();
        f0.n(activityP, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        m9.s.d0((androidx.fragment.app.g) activityP, 2);
        dialogFragment.I5();
    }

    @Override // com.flydigi.sdk.bluetooth.w
    public void A(@yt.k BluetoothDevice bluetoothDevice) {
        r.a.f(this, bluetoothDevice);
    }

    public final void A6(BluetoothDevice bluetoothDevice) {
        this.I8 = true;
        m9.s.d(bluetoothDevice);
    }

    @Override // m9.r
    public void B0(boolean z10, @yt.k Pair<Float, Float> pair) {
        r.a.k(this, z10, pair);
    }

    @Override // m9.r
    public void B1(@yt.k byte[] bArr, @yt.k byte[] bArr2) {
        r.a.t(this, bArr, bArr2);
    }

    @yt.l
    public final GamepadInfo B6() {
        return this.N8;
    }

    @yt.k
    public final Handler C6() {
        return this.E8;
    }

    public final boolean D6() {
        return this.I8;
    }

    public final boolean E6() {
        return this.H8;
    }

    public final boolean F6() {
        return this.J8;
    }

    @Override // com.flydigi.sdk.bluetooth.n
    public void G0(@yt.l BluetoothDevice bluetoothDevice, boolean z10) {
        n.a.d(this, bluetoothDevice, z10);
        if (!z10) {
            z6();
            e6();
            h3.a.j().d(a.d.f31951g).withString("key_device_code", t.i(bluetoothDevice != null ? bluetoothDevice.getName() : null)).navigation();
            return;
        }
        if (this.J8) {
            boolean zW6 = bluetoothDevice != null ? w6(t.i(bluetoothDevice.getName())) : false;
            this.J8 = zW6;
            if (!zW6) {
                J6();
            }
        }
        if (this.H8 && !this.J8) {
            m9.s.c();
        } else if (this.K8) {
            this.K8 = false;
            k7();
        }
    }

    public final boolean G6() {
        return this.K8;
    }

    @Override // m9.r
    public void H(@yt.k byte[] bArr) {
        r.a.a(this, bArr);
    }

    @yt.k
    public final String H6() {
        return this.G8;
    }

    @Override // m9.r
    public void I2(@yt.k GamepadInfo gamepadInfo) {
        r.a.c(this, gamepadInfo);
    }

    @yt.k
    public final y I6() {
        return this.F8;
    }

    public void J6() {
        com.flydigi.base.common.o.E(c3(R.string.device_device_remove_bond_success));
    }

    @Override // com.flydigi.base.common.BaseDialogFragment, com.trello.rxlifecycle3.components.support.RxDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void K3(@yt.l Bundle bundle) {
        super.K3(bundle);
        W5(1, 0);
    }

    public void K6(@yt.l String str, @yt.k BluetoothDevice device) {
        f0.p(device, "device");
        if (str == null) {
            str = "all";
        }
        this.G8 = str;
        m9.s.e0();
        String address = device.getAddress();
        f0.o(address, "device.address");
        BluetoothDevice bluetoothDeviceM = m9.s.m(address);
        boolean z10 = false;
        if (bluetoothDeviceM != null && bluetoothDeviceM.getBondState() == 12) {
            z10 = true;
        }
        if (z10) {
            this.K8 = true;
            m9.s.B(device);
        } else if (this.H8) {
            y6(device);
        } else {
            A6(device);
        }
    }

    public abstract void L6(@yt.k GamepadInfo gamepadInfo);

    @Override // m9.r
    public void M0(boolean z10, @yt.k Pair<Float, Float> pair) {
        r.a.m(this, z10, pair);
    }

    public void M6() {
        m9.s.f();
        FZDialog.a aVarB = new FZDialog.a().t(c3(R.string.notice)).j(c3(R.string.device_firmware_not_correct)).b(Boolean.FALSE);
        int i10 = R.string.cancel;
        o5.a.t0(L2(), aVarB.d(c3(i10)).c(new FZDialog.c() { // from class: com.flydigi.device_manager.ui.j
            @Override // com.flydigi.base.widget.FZDialog.c
            public final void a(DialogFragment dialogFragment) {
                BleDialogFragment.N6(dialogFragment);
            }
        }).g(c3(R.string.device_show_fix_troubleshoot_article)).f(new FZDialog.c() { // from class: com.flydigi.device_manager.ui.k
            @Override // com.flydigi.base.widget.FZDialog.c
            public final void a(DialogFragment dialogFragment) {
                BleDialogFragment.O6(dialogFragment);
            }
        }).d(c3(i10)).c(new FZDialog.c() { // from class: com.flydigi.device_manager.ui.i
            @Override // com.flydigi.base.widget.FZDialog.c
            public final void a(DialogFragment dialogFragment) {
                BleDialogFragment.P6(dialogFragment);
            }
        }).a());
        e6();
    }

    @Override // com.flydigi.sdk.bluetooth.w
    public void O2(@yt.k BluetoothGatt gatt) {
        f0.p(gatt, "gatt");
        BluetoothDevice device = gatt.getDevice();
        if (device != null && device.getBondState() == 12) {
            return;
        }
        this.I8 = false;
        r.a.j(this, gatt);
        m9.s.z(gatt);
        this.E8.removeCallbacks(this.M8);
        k7();
    }

    @Override // com.flydigi.sdk.bluetooth.m
    public void P(boolean z10) {
        m.a.e(this, z10);
        if (!this.H8 || z10) {
            return;
        }
        k7();
    }

    @Override // com.flydigi.sdk.bluetooth.m
    public void R0() {
        m.a.a(this);
    }

    @Override // com.flydigi.sdk.bluetooth.n
    public void R1(@yt.l BluetoothDevice bluetoothDevice) {
        n.a.b(this, bluetoothDevice);
        m9.s.e0();
    }

    @Override // m9.r
    public void R2(@yt.l Pair<Integer, Integer> pair) {
        r.a.p(this, pair);
    }

    @Override // com.flydigi.base.common.BaseDialogFragment, com.trello.rxlifecycle3.components.support.RxDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void R3() {
        m9.s.e0();
        m9.s.i0(this);
        this.E8.removeCallbacksAndMessages(null);
        this.F8.h(null);
        super.R3();
    }

    public void R6(@yt.k BluetoothDevice device, @yt.k GamepadInfo deviceInfo) {
        f0.p(device, "device");
        f0.p(deviceInfo, "deviceInfo");
        y6(device);
    }

    public void S6(@yt.k GamepadInfo deviceInfo) {
        f0.p(deviceInfo, "deviceInfo");
    }

    @Override // m9.r
    public void U() {
        r.a.b(this);
    }

    @Override // com.flydigi.sdk.bluetooth.w
    public void V0(@yt.k BluetoothDevice device) {
        f0.p(device, "device");
        r.a.i(this, device);
        this.E8.postDelayed(this.M8, 15000L);
    }

    @Override // com.flydigi.sdk.bluetooth.n
    public void V1(@yt.l BluetoothDevice bluetoothDevice) {
        n.a.e(this, bluetoothDevice);
    }

    @Override // m9.r
    public void Z1(boolean z10, @yt.k Pair<Float, Float> pair) {
        r.a.l(this, z10, pair);
    }

    @Override // m9.r
    public void a2(@yt.k byte[] bArr) {
        r.a.s(this, bArr);
    }

    @Override // com.flydigi.sdk.bluetooth.m
    public void b0() {
        m.a.b(this);
    }

    public final void b7(@yt.k String deviceCode) {
        f0.p(deviceCode, "deviceCode");
        this.J8 = true;
        for (BluetoothDevice bluetoothDevice : m9.s.g()) {
            String strI = t.i(bluetoothDevice.getName());
            if (f0.g(deviceCode, "all") || f0.g(deviceCode, strI) || ((f0.g(deviceCode, m9.h.f40761d) && f0.g(strI, m9.h.f40762e)) || f0.g(strI, m9.h.f40763f))) {
                m9.s.B(bluetoothDevice);
            }
        }
    }

    public final void c7(@yt.k String deviceMac) {
        f0.p(deviceMac, "deviceMac");
        m9.s.C(deviceMac);
    }

    public final void d7(@yt.l GamepadInfo gamepadInfo) {
        this.N8 = gamepadInfo;
    }

    @Override // com.flydigi.sdk.bluetooth.w
    public void e2(@yt.k BluetoothDevice bluetoothDevice) {
        r.a.g(this, bluetoothDevice);
    }

    public final void e7(boolean z10) {
        this.I8 = z10;
    }

    @Override // com.flydigi.base.common.BaseDialogFragment, com.trello.rxlifecycle3.components.support.RxDialogFragment, androidx.fragment.app.Fragment
    public void f4() {
        Window window;
        super.f4();
        Dialog dialogL5 = L5();
        if (dialogL5 == null || (window = dialogL5.getWindow()) == null) {
            return;
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        f0.o(attributes, "it.attributes");
        attributes.width = -1;
        attributes.height = -2;
        attributes.gravity = 80;
        window.setAttributes(attributes);
    }

    public final void f7(boolean z10) {
        this.H8 = z10;
    }

    @Override // com.flydigi.sdk.bluetooth.w
    public void g2(@yt.k BluetoothDevice bluetoothDevice) {
        r.a.e(this, bluetoothDevice);
    }

    public final void g7(boolean z10) {
        this.J8 = z10;
    }

    @Override // com.flydigi.base.common.BaseDialogFragment, com.trello.rxlifecycle3.components.support.RxDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void h4() {
        Window window;
        super.h4();
        if (L5() == null) {
            return;
        }
        Dialog dialogL5 = L5();
        if (dialogL5 != null && (window = dialogL5.getWindow()) != null) {
            window.setWindowAnimations(R.style.dialog_anim_enter_bottom);
        }
        Intent intent = new Intent(X1(), (Class<?>) FloatingWindow.class);
        intent.setAction(h9.b.class.getName());
        Context contextX1 = X1();
        this.P8 = contextX1 != null ? contextX1.bindService(intent, this.Q8, 65) : false;
        m9.s.A(this);
    }

    public final void h7(boolean z10) {
        this.K8 = z10;
    }

    @Override // com.flydigi.sdk.bluetooth.n
    public void i0(@yt.l BluetoothDevice bluetoothDevice) {
        n.a.c(this, bluetoothDevice);
        this.H8 = false;
        z6();
    }

    @Override // com.flydigi.base.common.BaseDialogFragment, com.trello.rxlifecycle3.components.support.RxDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void i4() {
        Context contextX1;
        super.i4();
        if (this.P8 && (contextX1 = X1()) != null) {
            contextX1.unbindService(this.Q8);
        }
        m9.s.e0();
        m9.s.i0(this);
    }

    public final void i7(@yt.k String str) {
        f0.p(str, "<set-?>");
        this.G8 = str;
    }

    public final void j7(@yt.k String msg) {
        f0.p(msg, "msg");
        if (this.L8 == null) {
            this.L8 = LoadingDialogFragment.c6(msg, false);
        }
        DialogFragment dialogFragment = this.L8;
        if (dialogFragment != null) {
            ((LoadingDialogFragment) dialogFragment).d6(msg);
            o5.a.t0(U1(), dialogFragment);
        }
    }

    @Override // m9.r
    public void k0() {
        r.a.q(this);
    }

    @Override // com.flydigi.sdk.bluetooth.w
    public void k1(int i10) {
        r.a.r(this, i10);
    }

    @g.i
    public void k7() {
        if (Build.VERSION.SDK_INT < 31 && !PermissionUtils.z(w3.c.f53848d)) {
            new FZDialog.a().t(d3(R.string.base_request_permission, c3(R.string.device_location_permission))).j(c3(R.string.device_location_permission_reason)).q(c3(R.string.next)).b(Boolean.FALSE).p(new FZDialog.c() { // from class: com.flydigi.device_manager.ui.h
                @Override // com.flydigi.base.widget.FZDialog.c
                public final void a(DialogFragment dialogFragment) {
                    BleDialogFragment.l7(dialogFragment);
                }
            }).a().Z5(U1(), "explainDialog");
            return;
        }
        Activity activityP = com.blankj.utilcode.util.a.P();
        f0.n(activityP, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        m9.s.d0((androidx.fragment.app.g) activityP, 2);
    }

    @Override // com.flydigi.sdk.bluetooth.m
    public void l() {
        m.a.c(this);
    }

    @Override // m9.r
    public void m2(int i10) {
        r.a.d(this, i10);
    }

    @Override // m9.r
    public void n0(@yt.k List<Integer> list) {
        r.a.n(this, list);
    }

    @Override // com.flydigi.sdk.bluetooth.n
    public void p2(@yt.l BluetoothDevice bluetoothDevice, boolean z10) {
        n.a.a(this, bluetoothDevice, z10);
        if (z10) {
            this.I8 = false;
        } else {
            this.H8 = false;
            z6();
        }
    }

    @Override // com.flydigi.sdk.bluetooth.m
    public void q(int i10) {
        m.a.d(this, i10);
    }

    @Override // com.flydigi.sdk.bluetooth.e0
    public void q1(@yt.k List<BleDevice> devices) {
        f0.p(devices, "devices");
        e0.a.a(this, devices);
        if (devices.isEmpty()) {
            return;
        }
        for (BleDevice bleDevice : devices) {
            if (bleDevice.S() >= -70) {
                String name = bleDevice.F().getName();
                f0.o(name, "it.device.name");
                if (!u.t2(name, "dfu", true)) {
                    K6(t.i(bleDevice.M()), bleDevice.F());
                }
            }
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

    @Override // m9.r
    public void u0(@yt.l final BluetoothDevice bluetoothDevice, @yt.k final GamepadInfo gamepadInfo) {
        f0.p(gamepadInfo, "gamepadInfo");
        r.a.h(this, bluetoothDevice, gamepadInfo);
        this.E8.removeCallbacks(this.M8);
        if (this.H8 || !this.I8) {
            return;
        }
        boolean z10 = false;
        if (bluetoothDevice != null && bluetoothDevice.getBondState() == 12) {
            z10 = true;
        }
        if (z10) {
            return;
        }
        this.F8.f(new Runnable() { // from class: com.flydigi.device_manager.ui.b
            @Override // java.lang.Runnable
            public final void run() {
                BleDialogFragment.Q6(bluetoothDevice, gamepadInfo, this);
            }
        }, 250L);
    }

    public final boolean w6(@yt.k String deviceCode) {
        f0.p(deviceCode, "deviceCode");
        Iterator<BluetoothDevice> it2 = m9.s.g().iterator();
        while (it2.hasNext()) {
            String strI = t.i(it2.next().getName());
            if (f0.g(deviceCode, "all") || f0.g(deviceCode, strI)) {
                return true;
            }
            if ((f0.g(deviceCode, m9.h.f40761d) && f0.g(strI, m9.h.f40762e)) || f0.g(strI, m9.h.f40763f)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.flydigi.sdk.bluetooth.e0
    public void x0(final int i10) {
        e0.a.b(this, i10);
        this.F8.e(new Runnable() { // from class: com.flydigi.device_manager.ui.d
            @Override // java.lang.Runnable
            public final void run() {
                BleDialogFragment.T6(this.f14578a, i10);
            }
        });
    }

    public final boolean x6(GamepadInfo gamepadInfo) {
        int iB = p.b(gamepadInfo);
        if (gamepadInfo.getMappingMode() == iB) {
            return true;
        }
        m9.s.a0(iB);
        S6(gamepadInfo);
        return false;
    }

    @Override // com.flydigi.sdk.bluetooth.n
    public void y(@yt.l BluetoothDevice bluetoothDevice) {
        n.a.f(this, bluetoothDevice);
        h3.a.j().d(a.d.f31951g).withString("key_device_code", t.i(bluetoothDevice != null ? bluetoothDevice.getName() : null)).navigation();
        z6();
        e6();
    }

    public void y6(@yt.k BluetoothDevice device) {
        f0.p(device, "device");
        m9.s.e(device);
    }

    @Override // m9.r
    public void z0(int i10, int i11) {
        r.a.o(this, i10, i11);
    }

    public final void z6() {
        DialogFragment dialogFragment = this.L8;
        if (dialogFragment != null) {
            o5.a.o(U1(), dialogFragment);
        }
    }
}
