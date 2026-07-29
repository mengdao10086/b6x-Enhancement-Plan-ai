package com.flydigi.device_manager.ui.driver_active;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.activity.result.ActivityResult;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.blankj.utilcode.util.PermissionUtils;
import com.blankj.utilcode.util.n0;
import com.flydigi.base.ui.StoragePermissionRequestActivity;
import com.flydigi.base.widget.FZDialog;
import com.flydigi.base.widget.LoadingDialogFragment;
import com.flydigi.data.DataConstant;
import com.flydigi.device_manager.R;
import com.flydigi.device_manager.ui.driver_active.ChangeModeFragment;
import com.flydigi.device_manager.ui.driver_active.CommonActiveFragment;
import com.flydigi.device_manager.ui.driver_active.DriverActiveTypeFragment;
import com.flydigi.device_manager.ui.driver_active.UsbDebugGuideDialog;
import com.flydigi.device_manager.ui.driver_active.WadbActiveFragment;
import com.flydigi.device_manager.ui.driver_active.permission.PermissionFragment;
import com.flydigi.sdk.gamepad.GamepadInfo;
import f.b;
import i9.a;

/* JADX INFO: loaded from: classes7.dex */
@Route(path = a.d.f31950f)
public final class DriverActivationActivity extends com.flydigi.device_manager.d implements DriverActiveTypeFragment.a, PermissionFragment.b, CommonActiveFragment.c, WadbActiveFragment.c, ChangeModeFragment.a {

    @yt.k
    public static final a N7 = new a(null);

    @yt.k
    public static final String O7 = "utool";

    @yt.k
    public static final String P7 = "pc";

    @yt.k
    public static final String Q7 = "wadb";
    public boolean J7;

    @hk.e
    @Autowired(name = DataConstant.DEVICE_KEY_DRIVER_ACTIVE_FROM_PERMISSION_CHECK)
    public boolean K7;

    @hk.e
    @Autowired(name = DataConstant.DEVICE_KEY_ACTIVATION_FAILED)
    public boolean L7;

    @yt.k
    public final androidx.activity.result.g<Intent> M7;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }
    }

    public static final class b implements UsbDebugGuideDialog.b {
        public b() {
        }

        @Override // com.flydigi.device_manager.ui.driver_active.UsbDebugGuideDialog.b
        public void open() {
            DriverActivationActivity.this.H4();
        }
    }

    public DriverActivationActivity() {
        androidx.activity.result.g<Intent> gVarP1 = P1(new b.m(), new androidx.activity.result.a() { // from class: com.flydigi.device_manager.ui.driver_active.j
            @Override // androidx.activity.result.a
            public final void a(Object obj) {
                DriverActivationActivity.K4(this.f14889a, (ActivityResult) obj);
            }
        });
        kotlin.jvm.internal.f0.o(gVarP1, "registerForActivityResul…)\n            }\n        }");
        this.M7 = gVarP1;
    }

    public static final void E4(DriverActivationActivity this$0) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        if (this$0.J7) {
            i9.b.a(this$0, DataConstant.FLOAT_WINDOW_ACTION_ENABLE_USB_DEBUG_CHECK_HIDE);
            this$0.Q4();
        }
    }

    public static final void F4(GamepadInfo deviceInfo, final DriverActivationActivity this$0) {
        kotlin.jvm.internal.f0.p(deviceInfo, "$deviceInfo");
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        if (!deviceInfo.isDriverConnected()) {
            u9.h.g(this$0, "连接激活_开启映射_激活失败");
            return;
        }
        new FZDialog.a().t(this$0.getString(R.string.device_driver_active_success)).j(this$0.getString(R.string.device_driver_active_success_content)).b(Boolean.FALSE).q(this$0.getString(R.string.confirm)).p(new FZDialog.c() { // from class: com.flydigi.device_manager.ui.driver_active.k
            @Override // com.flydigi.base.widget.FZDialog.c
            public final void a(DialogFragment dialogFragment) {
                DriverActivationActivity.G4(this.f14890a, dialogFragment);
            }
        }).u(this$0.n3(), LoadingDialogFragment.E8);
        u9.h.g(this$0, "激活成功");
        com.flydigi.userBehavior.a.a().b(this$0, "连接激活_开启映射_激活成功");
    }

    public static final void G4(DriverActivationActivity this$0, DialogFragment dialogFragment) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        this$0.finish();
        dialogFragment.I5();
    }

    public static final void I4(DriverActivationActivity this$0) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        if (this$0.J7) {
            i9.b.a(this$0, DataConstant.FLOAT_WINDOW_ACTION_ENABLE_USB_DEBUG_HIDE);
            this$0.Q4();
        }
    }

    public static final void K4(DriverActivationActivity this$0, ActivityResult activityResult) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        if (activityResult.b() == -1) {
            this$0.J4();
        } else if (activityResult.b() == 0) {
            this$0.R4();
        }
    }

    public static final void M4(DialogFragment dialogFragment) {
        dialogFragment.I5();
    }

    public static final void S4(DialogFragment dialogFragment) {
        dialogFragment.I5();
        PermissionUtils.C();
    }

    public final void H4() {
        i9.b.a(this, DataConstant.FLOAT_WINDOW_ACTION_ENABLE_USB_DEBUG_SHOW);
        o5.f.g(this);
        c4().f(new Runnable() { // from class: com.flydigi.device_manager.ui.driver_active.o
            @Override // java.lang.Runnable
            public final void run() {
                DriverActivationActivity.I4(this.f14894a);
            }
        }, 300L);
    }

    public final void J4() {
        if (n5.c.b(this)) {
            return;
        }
        this.M7.b(StoragePermissionRequestActivity.f13377k0.a(this, 1));
    }

    public final void L4() {
        o5.a.t0(n3(), new FZDialog.a().b(Boolean.FALSE).p(new FZDialog.c() { // from class: com.flydigi.device_manager.ui.driver_active.l
            @Override // com.flydigi.base.widget.FZDialog.c
            public final void a(DialogFragment dialogFragment) {
                DriverActivationActivity.M4(dialogFragment);
            }
        }).t(getString(R.string.device_driver_active_by_wadb_failed_with_connect_port_not_found)).j(getString(R.string.device_driver_active_by_wadb_failed_with_connect_port_not_found_content)).q(getString(R.string.device_just_know)).a());
    }

    public final void N4() {
        UsbDebugGuideDialog usbDebugGuideDialogA = UsbDebugGuideDialog.J8.a(true);
        usbDebugGuideDialogA.s6(new b());
        o5.a.t0(n3(), usbDebugGuideDialogA);
    }

    @Override // com.flydigi.device_manager.ui.driver_active.permission.PermissionFragment.b
    public void O1() {
        J4();
    }

    public final void O4() {
        com.blankj.utilcode.util.d0.v0(n3(), DriverActiveTypeFragment.C8.a(), R.id.fl_container);
    }

    public final void P4() {
        if (this.K7) {
            if (o5.b.m(this)) {
                f1(Q7);
            } else {
                n();
            }
            this.K7 = false;
            return;
        }
        if (!n5.c.b(this) || !o5.b.a(this)) {
            n();
            return;
        }
        FragmentManager fragmentManagerN3 = n3();
        int i10 = R.id.fl_container;
        if ((fragmentManagerN3.r0(i10) instanceof CommonActiveFragment) || (n3().r0(i10) instanceof WadbActiveFragment)) {
            return;
        }
        O4();
    }

    public final void Q4() {
        if (o5.h.d() || o5.h.l()) {
            o5.f.h(this);
        } else {
            o5.f.c(this);
        }
        i9.b.a(this, DataConstant.FLOAT_WINDOW_ACTION_SHOW_DEVELOPER_OPTION);
    }

    public final void R4() {
        new FZDialog.a().t(getString(R.string.notice)).j(getString(R.string.base_storage_permission_content)).q(getString(R.string.device_setting_now)).b(Boolean.FALSE).p(new FZDialog.c() { // from class: com.flydigi.device_manager.ui.driver_active.m
            @Override // com.flydigi.base.widget.FZDialog.c
            public final void a(DialogFragment dialogFragment) {
                DriverActivationActivity.S4(dialogFragment);
            }
        }).u(n3(), "storage_permission_denied");
    }

    @Override // com.flydigi.device_manager.ui.driver_active.ChangeModeFragment.a
    public void X0(int i10, @yt.k String deviceName, @yt.k String deviceAddress) {
        kotlin.jvm.internal.f0.p(deviceName, "deviceName");
        kotlin.jvm.internal.f0.p(deviceAddress, "deviceAddress");
        com.blankj.utilcode.util.d0.v0(n3(), DeviceChangeModeResultFragment.F6(i10, deviceName, deviceAddress), R.id.fl_container);
    }

    @Override // com.flydigi.device_manager.ui.driver_active.permission.PermissionFragment.b
    public void Y0() {
        if (o5.b.d(this)) {
            H4();
        } else {
            Q4();
        }
    }

    @Override // com.flydigi.device_manager.ui.driver_active.DriverActiveTypeFragment.a
    public void b1() {
        com.blankj.utilcode.util.d0.p(n3(), ChangeModeFragment.F6(), R.id.fl_container, false, true);
    }

    @Override // com.flydigi.device_manager.ui.driver_active.permission.PermissionFragment.b
    public void e0() {
        O4();
    }

    @Override // com.flydigi.device_manager.ui.driver_active.DriverActiveTypeFragment.a
    public void f1(@yt.k String activeType) {
        Fragment fragmentA;
        kotlin.jvm.internal.f0.p(activeType, "activeType");
        if (!o5.b.a(this)) {
            n();
            return;
        }
        if (n0.b(activeType, Q7)) {
            WadbActiveFragment.b bVar = WadbActiveFragment.f14864t8;
            GamepadInfo gamepadInfoO4 = o4();
            fragmentA = bVar.a(activeType, gamepadInfoO4 != null ? gamepadInfoO4.getDeviceCode() : null);
        } else {
            CommonActiveFragment.b bVar2 = CommonActiveFragment.f14853t8;
            GamepadInfo gamepadInfoO42 = o4();
            fragmentA = bVar2.a(activeType, gamepadInfoO42 != null ? gamepadInfoO42.getDeviceCode() : null);
        }
        if (com.blankj.utilcode.util.d0.A(n3(), fragmentA.getClass()) != null) {
            com.blankj.utilcode.util.d0.c0(com.blankj.utilcode.util.d0.A(n3(), fragmentA.getClass()));
        }
        u9.h.c(this, "Device_Driver_Show_Guide_Page", "连接激活_开启映射_小游激活");
        com.blankj.utilcode.util.d0.p(n3(), fragmentA, R.id.fl_container, false, true);
    }

    @Override // com.flydigi.base.common.p
    public int f4() {
        return R.layout.activity_fragment_with_toolbar;
    }

    @Override // com.flydigi.device_manager.ui.driver_active.CommonActiveFragment.c, com.flydigi.device_manager.ui.driver_active.WadbActiveFragment.c
    public void n() {
        com.blankj.utilcode.util.d0.v0(n3(), PermissionFragment.f14897t8.a(), R.id.fl_container);
    }

    @Override // com.flydigi.base.common.p, com.flydigi.base.common.c, ch.a, androidx.fragment.app.g, androidx.activity.ComponentActivity, f0.l, android.app.Activity
    public void onCreate(@yt.l Bundle bundle) {
        super.onCreate(bundle);
        h3.a.j().l(this);
        e4();
        this.C1.setText(R.string.device_title_enable_keymapping_driver);
        u9.h.g(this, "开始引导");
        com.flydigi.userBehavior.a.a().b(this, "连接激活_开启映射_进入激活");
        P4();
        if (this.L7) {
            u4();
        }
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(@yt.k Menu menu) {
        kotlin.jvm.internal.f0.p(menu, "menu");
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.device_menu_driver_active, menu);
        return true;
    }

    @Override // com.flydigi.base.common.c, androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(@yt.l Intent intent) {
        super.onNewIntent(intent);
        this.K7 = intent != null ? intent.getBooleanExtra(DataConstant.DEVICE_KEY_DRIVER_ACTIVE_FROM_PERMISSION_CHECK, false) : false;
        P4();
    }

    @Override // com.flydigi.base.common.p, android.app.Activity
    public boolean onOptionsItemSelected(@yt.k MenuItem item) {
        kotlin.jvm.internal.f0.p(item, "item");
        if (item.getItemId() == R.id.menu_question) {
            u9.b.p(2, "激活引导", "");
            return true;
        }
        if (item.getItemId() != 16908332) {
            return false;
        }
        d4();
        return true;
    }

    @Override // com.flydigi.base.common.c, ch.a, androidx.fragment.app.g, android.app.Activity
    public void onPause() {
        this.J7 = false;
        super.onPause();
    }

    @Override // com.flydigi.base.common.c, ch.a, androidx.fragment.app.g, android.app.Activity
    public void onResume() {
        super.onResume();
        this.J7 = true;
    }

    @Override // com.flydigi.device_manager.d
    public void s4(@yt.k final GamepadInfo deviceInfo) {
        kotlin.jvm.internal.f0.p(deviceInfo, "deviceInfo");
        super.s4(deviceInfo);
        runOnUiThread(new Runnable() { // from class: com.flydigi.device_manager.ui.driver_active.p
            @Override // java.lang.Runnable
            public final void run() {
                DriverActivationActivity.F4(deviceInfo, this);
            }
        });
    }

    @Override // com.flydigi.device_manager.d
    public void t4() {
        super.t4();
        L4();
    }

    @Override // com.flydigi.device_manager.d
    public void u4() {
        n();
        N4();
    }

    @Override // com.flydigi.device_manager.ui.driver_active.permission.PermissionFragment.b
    public void w1() {
        i9.b.a(this, DataConstant.FLOAT_WINDOW_ACTION_ENABLE_USB_DEBUG_CHECK_SHOW);
        o5.f.g(this);
        c4().f(new Runnable() { // from class: com.flydigi.device_manager.ui.driver_active.n
            @Override // java.lang.Runnable
            public final void run() {
                DriverActivationActivity.E4(this.f14893a);
            }
        }, 300L);
    }
}
