package com.flydigi.device_manager.ui.firmware.upgrade.telink;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import c7.p0;
import com.blankj.utilcode.util.a0;
import com.blankj.utilcode.util.b0;
import com.blankj.utilcode.util.p1;
import com.bumptech.glide.h;
import com.flydigi.device_manager.BaseGamepadFragment;
import com.flydigi.device_manager.R;
import com.flydigi.sdk.bluetooth.ota.OtaStatus;
import com.flydigi.sdk.gamepad.GamepadInfo;
import dj.o;
import java.io.File;
import java.io.IOException;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import kotlin.z1;
import m9.r;
import m9.s;
import xi.z;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes7.dex */
public final class FirmwareUpgradeFragment extends BaseGamepadFragment implements r, k9.b {

    @k
    public static final a H8 = new a(null);

    @l
    public String A8;

    @l
    public String B8;

    @l
    public String C8;
    public p0 D8;

    @l
    public b E8;
    public boolean F8;

    @k
    public final Runnable G8 = new Runnable() { // from class: com.flydigi.device_manager.ui.firmware.upgrade.telink.d
        @Override // java.lang.Runnable
        public final void run() {
            FirmwareUpgradeFragment.S6(this.f15103a);
        }
    };

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @k
        public final FirmwareUpgradeFragment a(@k String address, @k String filePath, @l String str) {
            f0.p(address, "address");
            f0.p(filePath, "filePath");
            Bundle bundle = new Bundle();
            bundle.putString(m7.a.f40701a, address);
            bundle.putString(m7.a.f40702b, filePath);
            bundle.putString("key_device_code", str);
            FirmwareUpgradeFragment firmwareUpgradeFragment = new FirmwareUpgradeFragment();
            firmwareUpgradeFragment.c5(bundle);
            return firmwareUpgradeFragment;
        }
    }

    public interface b {
        void a(boolean z10, @k String str, int i10, @l String str2);
    }

    public static final File M6(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        return (File) tmp0.i(obj);
    }

    public static final void N6(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void O6(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void P6(FirmwareUpgradeFragment this$0) {
        f0.p(this$0, "this$0");
        b bVar = this$0.E8;
        if (bVar != null) {
            bVar.a(false, "", 3, this$0.C8);
        }
    }

    public static final void Q6(FirmwareUpgradeFragment this$0, float f10) {
        f0.p(this$0, "this$0");
        p0 p0Var = this$0.D8;
        p0 p0Var2 = null;
        if (p0Var == null) {
            f0.S("viewBinding");
            p0Var = null;
        }
        p0Var.f10327c.setProgress((int) (f10 * 100));
        p0 p0Var3 = this$0.D8;
        if (p0Var3 == null) {
            f0.S("viewBinding");
            p0Var3 = null;
        }
        TextView textView = p0Var3.f10329e;
        StringBuilder sb2 = new StringBuilder();
        p0 p0Var4 = this$0.D8;
        if (p0Var4 == null) {
            f0.S("viewBinding");
        } else {
            p0Var2 = p0Var4;
        }
        sb2.append(p0Var2.f10327c.getProgress());
        sb2.append('%');
        textView.setText(sb2.toString());
    }

    public static final void R6(FirmwareUpgradeFragment this$0) {
        f0.p(this$0, "this$0");
        b bVar = this$0.E8;
        if (bVar != null) {
            bVar.a(true, "", 3, this$0.C8);
        }
    }

    public static final void S6(FirmwareUpgradeFragment this$0) {
        f0.p(this$0, "this$0");
        this$0.L6();
    }

    @Override // com.flydigi.sdk.bluetooth.w
    public void A(@k BluetoothDevice bluetoothDevice) {
        r.a.f(this, bluetoothDevice);
    }

    @Override // m9.r
    public void B0(boolean z10, @k Pair<Float, Float> pair) {
        r.a.k(this, z10, pair);
    }

    @Override // m9.r
    public void B1(@k byte[] bArr, @k byte[] bArr2) {
        r.a.t(this, bArr, bArr2);
    }

    @Override // k9.b
    public void C() {
        H5().e(new Runnable() { // from class: com.flydigi.device_manager.ui.firmware.upgrade.telink.f
            @Override // java.lang.Runnable
            public final void run() {
                FirmwareUpgradeFragment.R6(this.f15105a);
            }
        });
    }

    @Override // m9.r
    public void H(@k byte[] bArr) {
        r.a.a(this, bArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.flydigi.base.common.BaseFragment, androidx.fragment.app.Fragment
    public void H3(@k Context context) {
        f0.p(context, "context");
        super.H3(context);
        if (context instanceof b) {
            this.E8 = (b) context;
        }
    }

    @Override // m9.r
    public void I2(@k GamepadInfo gamepadInfo) {
        r.a.c(this, gamepadInfo);
    }

    @Override // com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void K3(@l Bundle bundle) {
        super.K3(bundle);
        Bundle bundleT1 = T1();
        this.C8 = bundleT1 != null ? bundleT1.getString("key_device_code") : null;
        Bundle bundleT12 = T1();
        this.B8 = bundleT12 != null ? bundleT12.getString(m7.a.f40701a) : null;
        Bundle bundleT13 = T1();
        this.A8 = bundleT13 != null ? bundleT13.getString(m7.a.f40702b) : null;
    }

    @Override // com.flydigi.base.common.FZFragment
    public int L5() {
        return R.layout.device_fragment_firmware_upgrade;
    }

    public final void L6() {
        String strG = b0.G(this.A8);
        if (f0.g(strG, "bin")) {
            s.f40882a.a(3, a0.d(this.A8));
            return;
        }
        if (f0.g(strG, "zip")) {
            z zVarM3 = z.m3(this.A8);
            final ik.l<String, File> lVar = new ik.l<String, File>() { // from class: com.flydigi.device_manager.ui.firmware.upgrade.telink.FirmwareUpgradeFragment$doUpgrade$1
                {
                    super(1);
                }

                @Override // ik.l
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public final File i(@l String str) throws IOException {
                    for (File file : p1.g(this.this$0.A8, b0.A(this.this$0.A8))) {
                        if (f0.g(b0.F(file), "bin")) {
                            return file;
                        }
                    }
                    throw new IOException();
                }
            };
            z zVarS0 = zVarM3.A3(new o() { // from class: com.flydigi.device_manager.ui.firmware.upgrade.telink.c
                @Override // dj.o
                public final Object apply(Object obj) {
                    return FirmwareUpgradeFragment.M6(lVar, obj);
                }
            }).s0(o5.l.d());
            final ik.l<File, z1> lVar2 = new ik.l<File, z1>() { // from class: com.flydigi.device_manager.ui.firmware.upgrade.telink.FirmwareUpgradeFragment$doUpgrade$2
                {
                    super(1);
                }

                public final void b(@l File file) {
                    p0 p0Var = this.this$0.D8;
                    if (p0Var == null) {
                        f0.S("viewBinding");
                        p0Var = null;
                    }
                    TextView textView = p0Var.f10328d;
                    FirmwareUpgradeFragment firmwareUpgradeFragment = this.this$0;
                    int i10 = R.string.device_firmware_upgrade_message;
                    FirmwareUpgradeFragment firmwareUpgradeFragment2 = this.this$0;
                    textView.setText(firmwareUpgradeFragment.d3(i10, firmwareUpgradeFragment.c3(R.string.device_firmware_upgrade_message_uploading), firmwareUpgradeFragment2.c3(a5.b.f(firmwareUpgradeFragment2.C8))));
                    s.f40882a.a(3, a0.c(file));
                }

                @Override // ik.l
                public /* bridge */ /* synthetic */ z1 i(File file) {
                    b(file);
                    return z1.f38230a;
                }
            };
            dj.g gVar = new dj.g() { // from class: com.flydigi.device_manager.ui.firmware.upgrade.telink.b
                @Override // dj.g
                public final void accept(Object obj) {
                    FirmwareUpgradeFragment.N6(lVar2, obj);
                }
            };
            final FirmwareUpgradeFragment$doUpgrade$3 firmwareUpgradeFragment$doUpgrade$3 = new ik.l<Throwable, z1>() { // from class: com.flydigi.device_manager.ui.firmware.upgrade.telink.FirmwareUpgradeFragment$doUpgrade$3
                public final void b(Throwable th2) {
                }

                @Override // ik.l
                public /* bridge */ /* synthetic */ z1 i(Throwable th2) {
                    b(th2);
                    return z1.f38230a;
                }
            };
            zVarS0.F5(gVar, new dj.g() { // from class: com.flydigi.device_manager.ui.firmware.upgrade.telink.a
                @Override // dj.g
                public final void accept(Object obj) {
                    FirmwareUpgradeFragment.O6(firmwareUpgradeFragment$doUpgrade$3, obj);
                }
            });
        }
    }

    @Override // m9.r
    public void M0(boolean z10, @k Pair<Float, Float> pair) {
        r.a.m(this, z10, pair);
    }

    @Override // com.flydigi.sdk.bluetooth.w
    public void O2(@k BluetoothGatt gatt) {
        f0.p(gatt, "gatt");
        r.a.j(this, gatt);
        this.F8 = false;
    }

    @Override // com.flydigi.base.common.FZFragment, com.flydigi.base.common.BaseFragment, androidx.fragment.app.Fragment
    @k
    public View O3(@k LayoutInflater inflater, @l ViewGroup viewGroup, @l Bundle bundle) {
        f0.p(inflater, "inflater");
        p0 p0VarD = p0.d(inflater, viewGroup, false);
        f0.o(p0VarD, "inflate(inflater, container, false)");
        this.D8 = p0VarD;
        if (p0VarD == null) {
            f0.S("viewBinding");
            p0VarD = null;
        }
        ConstraintLayout root = p0VarD.getRoot();
        f0.o(root, "viewBinding.root");
        return root;
    }

    @Override // m9.r
    public void R2(@l Pair<Integer, Integer> pair) {
        r.a.p(this, pair);
    }

    @Override // k9.b
    public void S0(@k OtaStatus code, @l Integer num) {
        f0.p(code, "code");
        H5().e(new Runnable() { // from class: com.flydigi.device_manager.ui.firmware.upgrade.telink.e
            @Override // java.lang.Runnable
            public final void run() {
                FirmwareUpgradeFragment.P6(this.f15104a);
            }
        });
    }

    @Override // m9.r
    public void U() {
        r.a.b(this);
    }

    @Override // com.flydigi.base.common.BaseFragment, com.flydigi.base.common.t
    public boolean V() {
        return true;
    }

    @Override // com.flydigi.sdk.bluetooth.w
    public void V0(@k BluetoothDevice bluetoothDevice) {
        r.a.i(this, bluetoothDevice);
    }

    @Override // m9.r
    public void Z1(boolean z10, @k Pair<Float, Float> pair) {
        r.a.l(this, z10, pair);
    }

    @Override // m9.r
    public void a2(@k byte[] bArr) {
        r.a.s(this, bArr);
    }

    @Override // com.flydigi.base.common.FZFragment, com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void a4() {
        super.a4();
        s.i0(this);
    }

    @Override // k9.b
    public void b1(final float f10) {
        H5().e(new Runnable() { // from class: com.flydigi.device_manager.ui.firmware.upgrade.telink.g
            @Override // java.lang.Runnable
            public final void run() {
                FirmwareUpgradeFragment.Q6(this.f15106a, f10);
            }
        });
    }

    @Override // com.flydigi.sdk.bluetooth.w
    public void e2(@k BluetoothDevice bluetoothDevice) {
        r.a.g(this, bluetoothDevice);
    }

    @Override // com.flydigi.base.common.FZLazyFragment, com.flydigi.base.common.FZFragment, com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void f4() {
        super.f4();
        s.A(this);
    }

    @Override // k9.b
    public void g0() {
    }

    @Override // com.flydigi.sdk.bluetooth.w
    public void g2(@k BluetoothDevice bluetoothDevice) {
        r.a.e(this, bluetoothDevice);
    }

    @Override // com.flydigi.device_manager.BaseGamepadFragment, com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void j4(@k View view, @l Bundle bundle) {
        f0.p(view, "view");
        super.j4(view, bundle);
        p0 p0Var = this.D8;
        p0 p0Var2 = null;
        if (p0Var == null) {
            f0.S("viewBinding");
            p0Var = null;
        }
        h hVarC0 = com.bumptech.glide.b.F(p0Var.f10326b).p(Integer.valueOf(R.drawable.device_firmware_upgrade_progress)).C0(Integer.MIN_VALUE);
        p0 p0Var3 = this.D8;
        if (p0Var3 == null) {
            f0.S("viewBinding");
        } else {
            p0Var2 = p0Var3;
        }
        hVarC0.s1(p0Var2.f10326b);
    }

    @Override // m9.r
    public void k0() {
        r.a.q(this);
    }

    @Override // com.flydigi.sdk.bluetooth.w
    public void k1(int i10) {
        r.a.r(this, i10);
    }

    @Override // m9.r
    public void m2(int i10) {
        r.a.d(this, i10);
    }

    @Override // m9.r
    public void n0(@k List<Integer> list) {
        r.a.n(this, list);
    }

    @Override // com.flydigi.device_manager.BaseGamepadFragment
    public void q6(@k GamepadInfo deviceInfo) {
        String address;
        BluetoothDevice bluetoothDeviceM;
        f0.p(deviceInfo, "deviceInfo");
        super.q6(deviceInfo);
        if (!deviceInfo.isConnected() || (address = deviceInfo.getAddress()) == null || (bluetoothDeviceM = s.m(address)) == null) {
            return;
        }
        if (s.k() == null) {
            s.d(bluetoothDeviceM);
        } else {
            G5().removeCallbacks(this.G8);
            G5().postDelayed(this.G8, 2000L);
        }
    }

    @Override // k9.b
    public void r0() {
    }

    @Override // m9.r
    public void u0(@l BluetoothDevice bluetoothDevice, @k GamepadInfo gamepadInfo) {
        f0.p(gamepadInfo, "gamepadInfo");
        r.a.h(this, bluetoothDevice, gamepadInfo);
        if (this.F8) {
            return;
        }
        this.F8 = true;
        G5().removeCallbacks(this.G8);
        G5().postDelayed(this.G8, 2000L);
    }

    @Override // m9.r
    public void z0(int i10, int i11) {
        r.a.o(this, i10, i11);
    }
}
