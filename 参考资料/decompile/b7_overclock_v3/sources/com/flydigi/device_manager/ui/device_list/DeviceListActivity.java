package com.flydigi.device_manager.ui.device_list;

import android.bluetooth.BluetoothDevice;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.DialogFragment;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.blankj.utilcode.util.d0;
import com.blankj.utilcode.util.n0;
import com.blankj.utilcode.util.o;
import com.flydigi.base.widget.FZDialog;
import com.flydigi.data.DataConstant;
import com.flydigi.device_manager.R;
import com.flydigi.device_manager.ui.device_list.DeviceListFragment;
import com.flydigi.sdk.gamepad.GamepadInfo;
import i9.a;
import java.util.List;
import kotlin.jvm.internal.f0;
import m9.t;
import yt.l;

/* JADX INFO: loaded from: classes7.dex */
@Route(path = a.d.f31947c)
public final class DeviceListActivity extends com.flydigi.device_manager.d implements DeviceListFragment.a {
    public c7.c J7;
    public boolean K7;

    public static final void A4(DialogFragment dialogFragment) {
        dialogFragment.I5();
    }

    public static final void B4(DialogFragment dialogFragment) {
        dialogFragment.I5();
    }

    public static /* synthetic */ void D4(DeviceListActivity deviceListActivity, int i10, String str, String str2, boolean z10, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            z10 = false;
        }
        deviceListActivity.C4(i10, str, str2, z10);
    }

    public static final void z4(DeviceListActivity this$0, View view) {
        f0.p(this$0, "this$0");
        this$0.finish();
    }

    public final void C4(int i10, String str, String str2, boolean z10) {
        h3.a.j().d(a.d.f31949e).withInt(DataConstant.DEVICE_KEY_DEVICE_TYPE, i10).withString("key_device_code", str).withString(DataConstant.DEVICE_KEY_DEVICE_NAME, str2).withBoolean(DataConstant.DEVICE_KEY_AUTO_CONNECT, z10).navigation();
        finish();
    }

    public final void E4(String str, String str2) {
        List<BluetoothDevice> listH = q9.f.h();
        boolean z10 = true;
        if ((!listH.isEmpty()) && n0.b(str, t.i(listH.get(0).getName()))) {
            h3.a.j().d(a.d.f31949e).withInt(DataConstant.DEVICE_KEY_DEVICE_TYPE, 2).withString("key_device_code", str).withString(DataConstant.DEVICE_KEY_DEVICE_NAME, str2).navigation();
        } else {
            z10 = false;
        }
        if (!z10) {
            h3.a.j().d(a.c.f31944c).withString("key_device_code", str).withString(DataConstant.DEVICE_KEY_DEVICE_NAME, str2).navigation();
        }
        finish();
    }

    @Override // com.flydigi.base.common.p
    public int f4() {
        return R.layout.device_activity_device_list;
    }

    @Override // com.flydigi.base.common.p, com.flydigi.base.common.c, ch.a, androidx.fragment.app.g, androidx.activity.ComponentActivity, f0.l, android.app.Activity
    public void onCreate(@l Bundle bundle) {
        super.onCreate(bundle);
        if (d0.A(n3(), DeviceListFragment.class) == null) {
            d0.a(n3(), DeviceListFragment.f14823u8.a(), R.id.fl_container);
        }
        c7.c cVar = this.J7;
        if (cVar == null) {
            f0.S("viewBinding");
            cVar = null;
        }
        o.r(cVar.f9867b, new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.device_list.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DeviceListActivity.z4(this.f14843a, view);
            }
        });
    }

    @Override // com.flydigi.device_manager.d
    public void s4(@yt.k GamepadInfo deviceInfo) {
        f0.p(deviceInfo, "deviceInfo");
        super.s4(deviceInfo);
        this.K7 = deviceInfo.isConnected();
    }

    @Override // androidx.appcompat.app.f, androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(int i10) {
        c7.c cVarC = c7.c.c(getLayoutInflater());
        f0.o(cVarC, "inflate(layoutInflater)");
        this.J7 = cVarC;
        if (cVarC == null) {
            f0.S("viewBinding");
            cVarC = null;
        }
        super.setContentView(cVarC.getRoot());
    }

    @Override // com.flydigi.device_manager.ui.device_list.DeviceListFragment.a
    public void u1(int i10, @yt.k String deviceCode, @yt.k String deviceName) {
        f0.p(deviceCode, "deviceCode");
        f0.p(deviceName, "deviceName");
        if (deviceCode.length() == 0) {
            com.flydigi.base.common.o.E(getString(R.string.not_support_now));
            return;
        }
        if (i10 == 1) {
            if (this.K7) {
                o5.a.t0(n3(), new FZDialog.a().t(getString(R.string.device_connected_gamepad_found_title)).j(getString(R.string.device_connected_device_found)).q(getString(R.string.confirm)).p(new FZDialog.c() { // from class: com.flydigi.device_manager.ui.device_list.e
                    @Override // com.flydigi.base.widget.FZDialog.c
                    public final void a(DialogFragment dialogFragment) {
                        DeviceListActivity.A4(dialogFragment);
                    }
                }).b(Boolean.FALSE).a());
                return;
            } else {
                C4(i10, deviceCode, deviceName, true);
                return;
            }
        }
        if (i10 == 2) {
            E4(deviceCode, deviceName);
            return;
        }
        if (i10 == 3 || i10 == 4) {
            if ((n0.b(deviceCode, t9.c.f50954c) || n0.b(deviceCode, t9.c.f50955d) || n0.b(deviceCode, t9.c.f50956e) || n0.b(deviceCode, t9.c.f50957f) || n0.b(deviceCode, t9.c.f50958g)) && t9.j.h() != null) {
                o5.a.t0(n3(), new FZDialog.a().t(getString(R.string.device_connected_gamepad_found_title)).j(getString(R.string.device_connected_device_found)).q(getString(R.string.confirm)).p(new FZDialog.c() { // from class: com.flydigi.device_manager.ui.device_list.d
                    @Override // com.flydigi.base.widget.FZDialog.c
                    public final void a(DialogFragment dialogFragment) {
                        DeviceListActivity.B4(dialogFragment);
                    }
                }).b(Boolean.FALSE).a());
            } else {
                D4(this, i10, deviceCode, deviceName, false, 8, null);
            }
        }
    }
}
