package com.flydigi.device_manager.ui.detail.waspwing;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.os.Bundle;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
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
import com.flydigi.device_manager.ui.firmware.list.FirmwareLatestFragment;
import com.flydigi.device_manager.ui.firmware.list.FirmwareListFragment;
import com.flydigi.device_manager.ui.firmware.upgrade.FirmwareUpgradeResultFragment;
import com.flydigi.device_manager.ui.firmware.upgrade.wch.FirmwareUpgradeFragment;
import com.flydigi.sdk.waspwing.WaspWingInfo;
import i9.a;
import java.io.File;
import java.net.NoRouteToHostException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLException;
import kotlin.jvm.internal.f0;
import m5.c0;
import t9.i;
import xi.g0;

/* JADX INFO: loaded from: classes7.dex */
@Route(path = a.d.f31953i)
public final class WaspwingUpgradeActivity extends com.flydigi.base.common.p implements FirmwareLatestFragment.b, FirmwareListFragment.b, FirmwareUpgradeFragment.c, FirmwareUpgradeResultFragment.b, t9.i {

    @hk.e
    @yt.l
    @Autowired(name = "key_device_address")
    public String F7;

    @yt.l
    public FirmwareInfoBean G7;

    @hk.e
    @Autowired(name = "key_device_code")
    @yt.k
    public String K2 = "all";

    @hk.e
    @Autowired(name = DataConstant.DEVICE_KEY_FIRMWARE_FORCE_LATEST)
    public boolean E7 = true;
    public boolean H7 = true;

    public static final class a implements com.flydigi.api.download.d {
        @Override // com.flydigi.api.download.d
        public void a(long j10, long j11, boolean z10) {
        }
    }

    public static final class b implements g0<File> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ FirmwareInfoBean f14655b;

        public b(FirmwareInfoBean firmwareInfoBean) {
            this.f14655b = firmwareInfoBean;
        }

        @Override // xi.g0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(@yt.k File file) {
            f0.p(file, "file");
            this.f14655b.file = file;
            WaspwingUpgradeActivity.this.E0();
            WaspwingUpgradeActivity.this.o4(file);
        }

        @Override // xi.g0
        public void onComplete() {
        }

        @Override // xi.g0
        public void onError(@yt.k Throwable throwable1) {
            String string;
            f0.p(throwable1, "throwable1");
            if ((throwable1 instanceof NoRouteToHostException) || (throwable1 instanceof UnknownHostException) || (throwable1 instanceof SocketTimeoutException) || (throwable1 instanceof SSLException)) {
                string = WaspwingUpgradeActivity.this.getString(R.string.net_state_error);
            } else {
                string = throwable1.getMessage();
                if (string == null) {
                    string = WaspwingUpgradeActivity.this.getString(R.string.net_state_error);
                    f0.o(string, "getString(R.string.net_state_error)");
                }
            }
            f0.o(string, "if (throwable1 is NoRout…or)\n                    }");
            com.flydigi.base.common.o.E(string);
            WaspwingUpgradeActivity.this.E0();
        }

        @Override // xi.g0
        public void onSubscribe(@yt.k io.reactivex.disposables.b d10) {
            f0.p(d10, "d");
            WaspwingUpgradeActivity waspwingUpgradeActivity = WaspwingUpgradeActivity.this;
            waspwingUpgradeActivity.x(waspwingUpgradeActivity.getString(R.string.device_firmware_upgrade_firmware_downloading), false);
        }
    }

    public static final File m4(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        return (File) tmp0.i(obj);
    }

    public static final void n4(WaspwingUpgradeActivity this$0) {
        f0.p(this$0, "this$0");
        q4(this$0, null, 1, null);
    }

    public static /* synthetic */ void q4(WaspwingUpgradeActivity waspwingUpgradeActivity, Fragment fragment, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            fragment = null;
        }
        waspwingUpgradeActivity.p4(fragment);
    }

    @Override // com.flydigi.sdk.bluetooth.w
    public void A(@yt.k BluetoothDevice bluetoothDevice) {
        i.a.b(this, bluetoothDevice);
    }

    @Override // t9.i
    public void F1(@yt.k WaspWingInfo waspWingInfo) {
        f0.p(waspWingInfo, "waspWingInfo");
        if (waspWingInfo.isConnected() && this.H7) {
            this.F7 = waspWingInfo.getAddress();
            this.K2 = waspWingInfo.getDeviceCode();
            FirmwareUpgradeResultFragment.b.a.a(this, waspWingInfo.getFirmwareVersion(), this.K2, 1, null, 8, null);
            this.H7 = false;
        }
    }

    @Override // com.flydigi.sdk.bluetooth.w
    public void O2(@yt.k BluetoothGatt bluetoothGatt) {
        i.a.e(this, bluetoothGatt);
    }

    @Override // com.flydigi.sdk.bluetooth.w
    public void V0(@yt.k BluetoothDevice bluetoothDevice) {
        i.a.d(this, bluetoothDevice);
    }

    @Override // com.flydigi.device_manager.ui.firmware.upgrade.wch.FirmwareUpgradeFragment.c
    public void a(boolean z10, @yt.k String message, int i10, @yt.l String str) {
        f0.p(message, "message");
        Fragment fragmentA = d0.A(n3(), FirmwareUpgradeResultFragment.class);
        if (fragmentA == null) {
            fragmentA = FirmwareUpgradeResultFragment.f15039x8.a(z10, str, this.K2, message, n0.x(this.F7), Integer.valueOf(i10), Boolean.FALSE);
        }
        d0.v0(n3(), fragmentA, R.id.fl_container);
    }

    @Override // com.flydigi.device_manager.ui.firmware.list.FirmwareLatestFragment.b
    public void d() {
    }

    @Override // com.flydigi.sdk.bluetooth.w
    public void e2(@yt.k BluetoothDevice bluetoothDevice) {
        i.a.c(this, bluetoothDevice);
    }

    @Override // com.flydigi.base.common.p
    public int f4() {
        return R.layout.activity_fragment_with_toolbar;
    }

    @Override // com.flydigi.sdk.bluetooth.w
    public void g2(@yt.k BluetoothDevice bluetoothDevice) {
        i.a.a(this, bluetoothDevice);
    }

    @Override // com.flydigi.sdk.bluetooth.w
    public void k1(int i10) {
        i.a.f(this, i10);
    }

    @Override // com.flydigi.device_manager.ui.firmware.list.FirmwareLatestFragment.b, com.flydigi.device_manager.ui.firmware.list.FirmwareListFragment.b
    public void l(@yt.k final FirmwareInfoBean firmware, @yt.l String str, int i10) {
        f0.p(firmware, "firmware");
        this.G7 = firmware;
        this.F7 = str;
        u9.h.c(this, "Module_Upgrade_ClickUpgrade", "外设管理_固件升级_点击升级");
        if (n0.m(firmware.url)) {
            return;
        }
        DownloadHelper downloadHelper = new DownloadHelper("https://api.flydigi.com/", new a());
        String str2 = firmware.url;
        f0.o(str2, "firmware.url");
        xi.z zVarD = DownloadHelper.d(downloadHelper, "firmware", str2, null, 4, null);
        final ik.l<File, File> lVar = new ik.l<File, File>() { // from class: com.flydigi.device_manager.ui.detail.waspwing.WaspwingUpgradeActivity$install$2
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
        zVarD.A3(new dj.o() { // from class: com.flydigi.device_manager.ui.detail.waspwing.u
            @Override // dj.o
            public final Object apply(Object obj) {
                return WaspwingUpgradeActivity.m4(lVar, obj);
            }
        }).s0(c0.t()).b4(aj.a.c()).c(new b(firmware));
    }

    @Override // com.flydigi.device_manager.ui.firmware.upgrade.FirmwareUpgradeResultFragment.b
    public void o0() {
        h3.a.j().d(a.d.f31949e).withString("key_device_code", this.K2).withInt(DataConstant.DEVICE_KEY_DEVICE_TYPE, 3).withBoolean(DataConstant.DEVICE_KEY_AUTO_CONNECT, true).navigation();
        finish();
    }

    public final void o4(File file) {
        Fragment fragmentA = d0.A(n3(), FirmwareUpgradeFragment.class);
        if (fragmentA == null) {
            String str = this.F7;
            f0.m(str);
            fragmentA = FirmwareUpgradeFragment.m6(str, file.getAbsolutePath(), this.K2);
        }
        d0.v0(n3(), fragmentA, R.id.fl_container);
    }

    @Override // com.flydigi.base.common.p, com.flydigi.base.common.c, ch.a, androidx.fragment.app.g, androidx.activity.ComponentActivity, f0.l, android.app.Activity
    public void onCreate(@yt.l Bundle bundle) {
        getWindow().addFlags(128);
        super.onCreate(bundle);
        h3.a.j().l(this);
        e4();
        this.C1.setText(R.string.device_gamepad_firmware_upgrade);
        t9.j.D(this);
        u9.h.c(this, "Module_Upgrade_Init", "外设管理_固件升级_进入界面");
        n3().p(new FragmentManager.o() { // from class: com.flydigi.device_manager.ui.detail.waspwing.t
            @Override // androidx.fragment.app.FragmentManager.o
            public final void a() {
                WaspwingUpgradeActivity.n4(this.f14809a);
            }
        });
    }

    public final void p4(Fragment fragment) {
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
                textView.setText(R.string.device_firmware_upgrade);
            }
        }
        if ((fragment instanceof FirmwareUpgradeFragment) || (fragment instanceof FirmwareUpgradeResultFragment)) {
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

    @Override // t9.i
    public void q2(@yt.k byte[] bArr) {
        i.a.g(this, bArr);
    }

    @Override // com.flydigi.device_manager.ui.firmware.upgrade.FirmwareUpgradeResultFragment.b
    public void s(@yt.l String str, @yt.k String deviceCode, int i10, @yt.l Boolean bool) {
        f0.p(deviceCode, "deviceCode");
        Fragment fragmentA = d0.A(n3(), FirmwareLatestFragment.class);
        if (fragmentA == null) {
            fragmentA = FirmwareLatestFragment.f15008y8.a(this.K2, deviceCode, this.F7, Boolean.valueOf(this.E7), str, i10);
        }
        d0.v0(n3(), fragmentA, R.id.fl_container);
    }

    @Override // com.flydigi.device_manager.ui.firmware.upgrade.FirmwareUpgradeResultFragment.b
    public void t2(int i10, @yt.l String str) {
        h3.a.j().d(a.d.f31949e).withString("key_device_code", str).withInt(DataConstant.DEVICE_KEY_DEVICE_TYPE, 3).withBoolean(DataConstant.DEVICE_KEY_AUTO_CONNECT, true).navigation();
        finish();
    }

    @Override // com.flydigi.base.common.c, androidx.fragment.app.g
    public void w3(@yt.k Fragment fragment) {
        f0.p(fragment, "fragment");
        super.w3(fragment);
        p4(fragment);
    }

    @Override // com.flydigi.base.common.c, androidx.fragment.app.g
    public void x3() {
        super.x3();
        q4(this, null, 1, null);
    }

    @Override // com.flydigi.device_manager.ui.firmware.list.FirmwareLatestFragment.b
    public void y0(@yt.l String str, int i10) {
        Fragment fragmentA = d0.A(n3(), FirmwareListFragment.class);
        if (fragmentA == null) {
            FirmwareListFragment.a aVar = FirmwareListFragment.A8;
            if (str == null) {
                str = this.K2;
            }
            fragmentA = aVar.a(str, this.F7, i10);
        }
        d0.p(n3(), fragmentA, R.id.fl_container, false, true);
    }
}
