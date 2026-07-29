package com.flydigi.device_manager.ui.firmware;

import android.bluetooth.BluetoothDevice;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import androidx.core.view.a0;
import androidx.core.view.z;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.blankj.utilcode.util.b0;
import com.blankj.utilcode.util.d0;
import com.blankj.utilcode.util.n0;
import com.bumptech.glide.manager.SupportRequestManagerFragment;
import com.flydigi.api.download.DownloadHelper;
import com.flydigi.base.widget.LoadingDialogFragment;
import com.flydigi.data.DataConstant;
import com.flydigi.data.bean.FirmwareInfoBean;
import com.flydigi.device_manager.R;
import com.flydigi.device_manager.ui.firmware.dfu.DFUScanFragment;
import com.flydigi.device_manager.ui.firmware.dfu.KrlyDFUScanFragment;
import com.flydigi.device_manager.ui.firmware.list.FirmwareLatestFragment;
import com.flydigi.device_manager.ui.firmware.list.FirmwareListFragment;
import com.flydigi.device_manager.ui.firmware.upgrade.FirmwareUpgradeFragment;
import com.flydigi.device_manager.ui.firmware.upgrade.FirmwareUpgradeResultFragment;
import com.flydigi.device_manager.ui.firmware.upgrade.krly.FirmwareUpgradeFragment;
import com.flydigi.device_manager.ui.firmware.upgrade.telink.FirmwareUpgradeFragment;
import com.flydigi.device_manager.ui.firmware.upgrade.wch.FirmwareUpgradeFragment;
import com.flydigi.device_manager.ui.remove_bond.RemoveBondFragment;
import com.flydigi.sdk.bluetooth.n;
import com.flydigi.sdk.gamepad.GamepadInfo;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import dj.o;
import i9.a;
import java.io.File;
import kotlin.jvm.internal.f0;
import m5.c0;
import m9.s;
import m9.t;

/* JADX INFO: loaded from: classes7.dex */
@Route(path = a.d.f31952h)
public final class FirmwareUpgradeActivity extends com.flydigi.device_manager.d implements RemoveBondFragment.a, DFUScanFragment.b, KrlyDFUScanFragment.b, FirmwareLatestFragment.b, FirmwareListFragment.b, FirmwareUpgradeFragment.b, FirmwareUpgradeFragment.c, FirmwareUpgradeFragment.b, FirmwareUpgradeFragment.b, FirmwareUpgradeResultFragment.b, n {

    @hk.e
    @Autowired(name = DataConstant.DEVICE_KEY_FIRMWARE_FORCE_LATEST)
    public boolean L7;

    @yt.l
    public FirmwareInfoBean N7;

    @yt.l
    public String O7;
    public boolean P7;
    public boolean Q7;
    public boolean R7;

    @hk.e
    @Autowired(name = "key_device_code")
    @yt.k
    public String J7 = "all";

    @yt.k
    public String K7 = "all";
    public boolean M7 = true;

    @yt.k
    public final b S7 = new b();

    public static final class a implements com.flydigi.api.download.d {
        @Override // com.flydigi.api.download.d
        public void a(long j10, long j11, boolean z10) {
        }
    }

    public static final class b implements a0 {
        public b() {
        }

        @Override // androidx.core.view.a0
        public boolean a(@yt.k MenuItem menuItem) {
            f0.p(menuItem, "menuItem");
            if (menuItem.getItemId() != R.id.si_update) {
                return false;
            }
            GamepadInfo gamepadInfoO4 = FirmwareUpgradeActivity.this.o4();
            if (gamepadInfoO4 != null) {
                FirmwareUpgradeActivity.this.s(gamepadInfoO4.getSwitchChipVersion(), gamepadInfoO4.getKrlyDeviceCode(), 2, Boolean.TRUE);
            }
            return true;
        }

        @Override // androidx.core.view.a0
        public /* synthetic */ void b(Menu menu) {
            z.a(this, menu);
        }

        @Override // androidx.core.view.a0
        public void c(@yt.k Menu menu, @yt.k MenuInflater menuInflater) {
            f0.p(menu, "menu");
            f0.p(menuInflater, "menuInflater");
            menuInflater.inflate(R.menu.device_menu_firmware_update, menu);
        }

        @Override // androidx.core.view.a0
        public /* synthetic */ void d(Menu menu) {
            z.b(this, menu);
        }
    }

    public static final File D4(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        return (File) tmp0.i(obj);
    }

    public static final void F4(FirmwareUpgradeActivity this$0) {
        f0.p(this$0, "this$0");
        L4(this$0, null, 1, null);
    }

    public static final void G4(FirmwareUpgradeActivity this$0, boolean z10) {
        File file;
        f0.p(this$0, "this$0");
        this$0.E0();
        if (!z10) {
            this$0.I4();
            this$0.N7 = null;
            return;
        }
        FirmwareInfoBean firmwareInfoBean = this$0.N7;
        if (firmwareInfoBean == null || (file = firmwareInfoBean.file) == null || !b0.g0(file)) {
            return;
        }
        this$0.J4(file, 0);
    }

    public static /* synthetic */ void L4(FirmwareUpgradeActivity firmwareUpgradeActivity, Fragment fragment, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            fragment = null;
        }
        firmwareUpgradeActivity.K4(fragment);
    }

    public final boolean E4() {
        return this.M7;
    }

    @Override // com.flydigi.sdk.bluetooth.n
    public void G0(@yt.l BluetoothDevice bluetoothDevice, final boolean z10) {
        n.a.d(this, bluetoothDevice, z10);
        c4().e(new Runnable() { // from class: com.flydigi.device_manager.ui.firmware.i
            @Override // java.lang.Runnable
            public final void run() {
                FirmwareUpgradeActivity.G4(this.f15002a, z10);
            }
        });
    }

    public final void H4(boolean z10) {
        this.M7 = z10;
    }

    public final void I4() {
        Fragment fragmentA = d0.A(n3(), RemoveBondFragment.class);
        if (fragmentA == null) {
            fragmentA = RemoveBondFragment.d6(this.J7, true);
        }
        d0.v0(n3(), fragmentA, R.id.fl_container);
    }

    public final void J4(File file, int i10) {
        Fragment fragmentA;
        String krlyDeviceCode;
        if (i10 == 1) {
            fragmentA = d0.A(n3(), com.flydigi.device_manager.ui.firmware.upgrade.wch.FirmwareUpgradeFragment.class);
            if (fragmentA == null) {
                String str = this.O7;
                f0.m(str);
                fragmentA = com.flydigi.device_manager.ui.firmware.upgrade.wch.FirmwareUpgradeFragment.m6(str, file.getAbsolutePath(), this.J7);
            }
        } else if (i10 == 2) {
            fragmentA = d0.A(n3(), com.flydigi.device_manager.ui.firmware.upgrade.krly.FirmwareUpgradeFragment.class);
            if (fragmentA == null) {
                FirmwareUpgradeFragment.a aVar = com.flydigi.device_manager.ui.firmware.upgrade.krly.FirmwareUpgradeFragment.f15063v8;
                String absolutePath = file.getAbsolutePath();
                f0.o(absolutePath, "file.absolutePath");
                GamepadInfo gamepadInfoO4 = o4();
                if (gamepadInfoO4 == null || (krlyDeviceCode = gamepadInfoO4.getKrlyDeviceCode()) == null) {
                    krlyDeviceCode = this.J7;
                }
                fragmentA = FirmwareUpgradeFragment.a.b(aVar, absolutePath, krlyDeviceCode, null, 4, null);
            }
        } else if (i10 != 3) {
            fragmentA = d0.A(n3(), com.flydigi.device_manager.ui.firmware.upgrade.FirmwareUpgradeFragment.class);
            if (fragmentA == null) {
                FirmwareUpgradeFragment.a aVar2 = com.flydigi.device_manager.ui.firmware.upgrade.FirmwareUpgradeFragment.f15026w8;
                String absolutePath2 = file.getAbsolutePath();
                f0.o(absolutePath2, "file.absolutePath");
                fragmentA = aVar2.a(absolutePath2, this.K7, this.O7);
            }
        } else {
            fragmentA = d0.A(n3(), com.flydigi.device_manager.ui.firmware.upgrade.telink.FirmwareUpgradeFragment.class);
            if (fragmentA == null) {
                FirmwareUpgradeFragment.a aVar3 = com.flydigi.device_manager.ui.firmware.upgrade.telink.FirmwareUpgradeFragment.H8;
                String str2 = this.O7;
                f0.m(str2);
                String absolutePath3 = file.getAbsolutePath();
                f0.o(absolutePath3, "file.absolutePath");
                fragmentA = aVar3.a(str2, absolutePath3, this.J7);
            }
        }
        d0.v0(n3(), fragmentA, R.id.fl_container);
    }

    public final void K4(Fragment fragment) {
        if (fragment == null) {
            fragment = n3().r0(R.id.fl_container);
        }
        if (fragment == null || (fragment instanceof SupportRequestManagerFragment) || (fragment instanceof LoadingDialogFragment)) {
            return;
        }
        TextView textView = this.C1;
        if (textView != null) {
            if (fragment instanceof FirmwareListFragment) {
                textView.setText(R.string.device_firmware_upgrade_version_history);
            } else {
                textView.setText(R.string.device_gamepad_firmware_upgrade);
            }
        }
        if ((fragment instanceof FirmwareLatestFragment) && d0.I(n3()).isEmpty() && this.Q7 && !this.R7) {
            n2(this.S7);
        } else {
            F(this.S7);
        }
        if ((fragment instanceof com.flydigi.device_manager.ui.firmware.upgrade.FirmwareUpgradeFragment) || (fragment instanceof com.flydigi.device_manager.ui.firmware.upgrade.wch.FirmwareUpgradeFragment) || (fragment instanceof com.flydigi.device_manager.ui.firmware.upgrade.krly.FirmwareUpgradeFragment) || (fragment instanceof com.flydigi.device_manager.ui.firmware.upgrade.telink.FirmwareUpgradeFragment) || (fragment instanceof FirmwareUpgradeResultFragment)) {
            androidx.appcompat.app.a aVarI3 = I3();
            if (aVarI3 != null) {
                aVarI3.Y(false);
                return;
            }
            return;
        }
        androidx.appcompat.app.a aVarI32 = I3();
        if (aVarI32 != null) {
            aVarI32.Y(true);
        }
    }

    @Override // com.flydigi.sdk.bluetooth.n
    public void R1(@yt.l BluetoothDevice bluetoothDevice) {
        n.a.b(this, bluetoothDevice);
    }

    @Override // com.flydigi.sdk.bluetooth.n
    public void V1(@yt.l BluetoothDevice bluetoothDevice) {
        n.a.e(this, bluetoothDevice);
    }

    @Override // com.flydigi.device_manager.ui.firmware.upgrade.FirmwareUpgradeFragment.b, com.flydigi.device_manager.ui.firmware.upgrade.wch.FirmwareUpgradeFragment.c
    public void a(boolean z10, @yt.k String message, int i10, @yt.l String str) {
        GamepadInfo gamepadInfoO4;
        f0.p(message, "message");
        boolean z11 = false;
        if (z10 && (gamepadInfoO4 = o4()) != null && !t.a(gamepadInfoO4)) {
            FirmwareInfoBean firmwareInfoBean = this.N7;
            if (t.a(gamepadInfoO4.copy((536866815 & 1) != 0 ? gamepadInfoO4.address : null, (536866815 & 2) != 0 ? gamepadInfoO4.deviceName : null, (536866815 & 4) != 0 ? gamepadInfoO4.deviceCode : null, (536866815 & 8) != 0 ? gamepadInfoO4.chipType : 0, (536866815 & 16) != 0 ? gamepadInfoO4.motionChipType : 0, (536866815 & 32) != 0 ? gamepadInfoO4.deviceType : 0, (536866815 & 64) != 0 ? gamepadInfoO4.deviceMode : 0, (536866815 & 128) != 0 ? gamepadInfoO4.connectMode : 0, (536866815 & 256) != 0 ? gamepadInfoO4.connectState : 0, (536866815 & 512) != 0 ? gamepadInfoO4.mappingMode : 0, (536866815 & 1024) != 0 ? gamepadInfoO4.usb0Device : 0, (536866815 & 2048) != 0 ? gamepadInfoO4.usb1Device : 0, (536866815 & 4096) != 0 ? gamepadInfoO4.firmwareVersion : firmwareInfoBean != null ? firmwareInfoBean.version : null, (536866815 & 8192) != 0 ? gamepadInfoO4.isSupportFlashplay : false, (536866815 & 16384) != 0 ? gamepadInfoO4.isDriverConnected : false, (536866815 & 32768) != 0 ? gamepadInfoO4.driverVersion : null, (536866815 & 65536) != 0 ? gamepadInfoO4.battery : 0, (536866815 & 131072) != 0 ? gamepadInfoO4.isSupportLinearButton : false, (536866815 & 262144) != 0 ? gamepadInfoO4.isSupportMotion : false, (536866815 & 524288) != 0 ? gamepadInfoO4.isSupportLunpan : false, (536866815 & 1048576) != 0 ? gamepadInfoO4.isSupportLed : false, (536866815 & 2097152) != 0 ? gamepadInfoO4.isSupportMotor : false, (536866815 & 4194304) != 0 ? gamepadInfoO4.supportKeys : null, (536866815 & 8388608) != 0 ? gamepadInfoO4.batteryLevelGap : null, (536866815 & 16777216) != 0 ? gamepadInfoO4.ipType : false, (536866815 & CommonNetImpl.FLAG_SHARE_JUMP) != 0 ? gamepadInfoO4.isSupportSwitch : false, (536866815 & 67108864) != 0 ? gamepadInfoO4.switchChipVersion : null, (536866815 & 134217728) != 0 ? gamepadInfoO4.isSupportTrigger : false, (536866815 & 268435456) != 0 ? gamepadInfoO4.uuid : null))) {
                z11 = true;
            }
        }
        this.P7 = z11;
        Fragment fragmentA = d0.A(n3(), FirmwareUpgradeResultFragment.class);
        if (fragmentA == null) {
            fragmentA = FirmwareUpgradeResultFragment.f15039x8.a(z10, str, this.J7, message, n0.x(this.O7), Integer.valueOf(i10), Boolean.valueOf(this.P7));
        }
        d0.v0(n3(), fragmentA, R.id.fl_container);
    }

    @Override // com.flydigi.device_manager.ui.remove_bond.RemoveBondFragment.a, com.flydigi.device_manager.ui.firmware.list.FirmwareLatestFragment.b
    public void d() {
        if (androidx.core.util.j.a(this.J7, m9.h.D) || androidx.core.util.j.a(this.J7, m9.h.F) || androidx.core.util.j.a(this.J7, m9.h.E)) {
            Fragment fragmentA = d0.A(n3(), KrlyDFUScanFragment.class);
            if (fragmentA == null) {
                fragmentA = KrlyDFUScanFragment.f14968s8.a(this.J7, this.L7);
            }
            d0.v0(n3(), fragmentA, R.id.fl_container);
            return;
        }
        Fragment fragmentA2 = d0.A(n3(), DFUScanFragment.class);
        if (fragmentA2 == null) {
            fragmentA2 = DFUScanFragment.f14961s8.a(this.J7, this.L7);
        }
        d0.v0(n3(), fragmentA2, R.id.fl_container);
    }

    @Override // com.flydigi.base.common.p
    public int f4() {
        return R.layout.activity_fragment_with_toolbar;
    }

    @Override // com.flydigi.device_manager.ui.firmware.dfu.DFUScanFragment.b, com.flydigi.device_manager.ui.firmware.dfu.KrlyDFUScanFragment.b
    public void i(@yt.k String deviceCode, @yt.k String address, int i10) {
        f0.p(deviceCode, "deviceCode");
        f0.p(address, "address");
        this.J7 = deviceCode;
        this.K7 = t.n(deviceCode, -1, i10);
        this.O7 = address;
        v4(null);
        if (i10 == 2) {
            this.L7 = true;
        }
        FirmwareUpgradeResultFragment.b.a.a(this, null, this.K7, i10, null, 9, null);
    }

    @Override // com.flydigi.sdk.bluetooth.n
    public void i0(@yt.l BluetoothDevice bluetoothDevice) {
        n.a.c(this, bluetoothDevice);
    }

    @Override // com.flydigi.device_manager.ui.firmware.list.FirmwareLatestFragment.b, com.flydigi.device_manager.ui.firmware.list.FirmwareListFragment.b
    public void l(@yt.k final FirmwareInfoBean firmware, @yt.l String str, int i10) {
        f0.p(firmware, "firmware");
        this.N7 = firmware;
        this.O7 = str;
        u9.h.c(this, "Module_Upgrade_ClickUpgrade", "外设管理_固件升级_点击升级");
        if (n0.m(firmware.url)) {
            return;
        }
        DownloadHelper downloadHelper = new DownloadHelper("https://api.flydigi.com/", new a());
        String str2 = firmware.url;
        f0.o(str2, "firmware.url");
        xi.z zVarD = DownloadHelper.d(downloadHelper, "firmware", str2, null, 4, null);
        final ik.l<File, File> lVar = new ik.l<File, File>() { // from class: com.flydigi.device_manager.ui.firmware.FirmwareUpgradeActivity$install$2
            {
                super(1);
            }

            @Override // ik.l
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final File i(@yt.k File it2) {
                f0.p(it2, "it");
                File file = new File(it2.getParent(), b0.R(it2) + '.' + b0.G(firmware.url));
                b0.a(it2, file);
                return file;
            }
        };
        zVarD.A3(new o() { // from class: com.flydigi.device_manager.ui.firmware.h
            @Override // dj.o
            public final Object apply(Object obj) {
                return FirmwareUpgradeActivity.D4(lVar, obj);
            }
        }).s0(c0.t()).b4(aj.a.c()).c(new FirmwareUpgradeActivity$install$3(this, firmware, i10));
    }

    @Override // com.flydigi.device_manager.ui.firmware.upgrade.FirmwareUpgradeResultFragment.b
    public void o0() {
        h3.a.j().d(a.d.f31949e).withString("key_device_code", this.J7).withInt(DataConstant.DEVICE_KEY_DEVICE_TYPE, (n0.b(this.J7, m9.h.f40783z) || n0.b(this.J7, m9.h.D) || n0.b(this.J7, m9.h.E)) ? 4 : 1).withBoolean(DataConstant.DEVICE_KEY_AUTO_CONNECT, (n0.b(this.J7, m9.h.f40783z) || n0.b(this.J7, m9.h.D) || n0.b(this.J7, m9.h.E)) ? false : true).navigation();
        finishAffinity();
    }

    @Override // com.flydigi.base.common.p, com.flydigi.base.common.c, ch.a, androidx.fragment.app.g, androidx.activity.ComponentActivity, f0.l, android.app.Activity
    public void onCreate(@yt.l Bundle bundle) {
        getWindow().addFlags(128);
        super.onCreate(bundle);
        h3.a.j().l(this);
        e4();
        this.C1.setText(R.string.device_gamepad_firmware_upgrade);
        s.A(this);
        u9.h.c(this, "Module_Upgrade_Init", "外设管理_固件升级_进入界面");
        n3().p(new FragmentManager.o() { // from class: com.flydigi.device_manager.ui.firmware.g
            @Override // androidx.fragment.app.FragmentManager.o
            public final void a() {
                FirmwareUpgradeActivity.F4(this.f15000a);
            }
        });
    }

    @Override // com.flydigi.base.common.p, com.flydigi.base.common.c, ch.a, androidx.appcompat.app.f, androidx.fragment.app.g, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        s.i0(this);
    }

    @Override // com.flydigi.sdk.bluetooth.n
    public void p2(@yt.l BluetoothDevice bluetoothDevice, boolean z10) {
        n.a.a(this, bluetoothDevice, z10);
    }

    @Override // com.flydigi.device_manager.ui.firmware.upgrade.FirmwareUpgradeResultFragment.b
    public void s(@yt.l String str, @yt.k String deviceCode, int i10, @yt.l Boolean bool) {
        f0.p(deviceCode, "deviceCode");
        d0.G0(n3(), FirmwareLatestFragment.f15008y8.a(this.J7, deviceCode, this.O7, Boolean.valueOf(this.L7), str, i10), R.id.fl_container, bool != null ? bool.booleanValue() : false);
    }

    @Override // com.flydigi.device_manager.d
    public void s4(@yt.k GamepadInfo deviceInfo) {
        f0.p(deviceInfo, "deviceInfo");
        super.s4(deviceInfo);
        if (!this.M7 || this.R7) {
            return;
        }
        this.M7 = false;
        if (!deviceInfo.isConnected()) {
            d();
            return;
        }
        if (deviceInfo.getChipType() != 0) {
            this.O7 = deviceInfo.getAddress();
        }
        this.J7 = deviceInfo.getDeviceCode();
        this.K7 = t.m(deviceInfo);
        this.Q7 = t.f(deviceInfo);
        FirmwareUpgradeResultFragment.b.a.a(this, deviceInfo.getFirmwareVersion(), this.K7, deviceInfo.getChipType(), null, 8, null);
    }

    @Override // com.flydigi.device_manager.ui.firmware.upgrade.FirmwareUpgradeResultFragment.b
    public void t2(int i10, @yt.l String str) {
        if (i10 != 1) {
            if (i10 == 2) {
                d0.W(n3());
                if (n0.b(str, m9.h.D) || n0.b(str, m9.h.F) || n0.b(str, m9.h.E)) {
                    d();
                    return;
                }
                if (str == null) {
                    str = "";
                }
                FirmwareUpgradeResultFragment.b.a.a(this, null, str, i10, Boolean.FALSE, 1, null);
                return;
            }
            if (i10 != 3) {
                d();
                return;
            }
        }
        Postcard postcardD = h3.a.j().d(a.d.f31949e);
        GamepadInfo gamepadInfoO4 = o4();
        postcardD.withString("key_device_code", gamepadInfoO4 != null ? gamepadInfoO4.getDeviceCode() : null).withInt(DataConstant.DEVICE_KEY_DEVICE_TYPE, 1).navigation();
        finishAffinity();
    }

    @Override // com.flydigi.base.common.c, androidx.fragment.app.g
    public void w3(@yt.k Fragment fragment) {
        f0.p(fragment, "fragment");
        super.w3(fragment);
        K4(fragment);
    }

    @Override // com.flydigi.base.common.c, androidx.fragment.app.g
    public void x3() {
        super.x3();
        L4(this, null, 1, null);
    }

    @Override // com.flydigi.sdk.bluetooth.n
    public void y(@yt.l BluetoothDevice bluetoothDevice) {
        n.a.f(this, bluetoothDevice);
    }

    @Override // com.flydigi.device_manager.ui.firmware.list.FirmwareLatestFragment.b
    public void y0(@yt.l String str, int i10) {
        Fragment fragmentA = d0.A(n3(), FirmwareListFragment.class);
        if (fragmentA == null) {
            FirmwareListFragment.a aVar = FirmwareListFragment.A8;
            if (str == null) {
                str = this.K7;
            }
            fragmentA = aVar.a(str, this.O7, i10);
        }
        d0.p(n3(), fragmentA, R.id.fl_container, false, true);
    }
}
