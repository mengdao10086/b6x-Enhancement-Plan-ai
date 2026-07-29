package com.flydigi.device_manager.ui.connection;

import android.app.Application;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.RecyclerView;
import c7.m1;
import com.blankj.utilcode.util.j1;
import com.blankj.utilcode.util.n0;
import com.flydigi.base.widget.FZDialog;
import com.flydigi.data.DataConstant;
import com.flydigi.device_manager.R;
import com.flydigi.device_manager.ui.BleDialogFragment;
import com.flydigi.device_manager.ui.connection.a;
import com.flydigi.sdk.gamepad.GamepadInfo;
import com.google.android.material.divider.MaterialDivider;
import com.google.android.material.tabs.TabLayout;
import eu.davidea.flexibleadapter.b;
import i9.a;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.s0;
import kotlin.jvm.internal.f0;

/* JADX INFO: loaded from: classes7.dex */
public class ScanFragment extends BleDialogFragment implements b.z, a.b {

    /* JADX INFO: renamed from: f9, reason: collision with root package name */
    @yt.k
    public static final a f14524f9 = new a(null);

    /* JADX INFO: renamed from: g9, reason: collision with root package name */
    @yt.k
    public static final String f14525g9 = "key_device_code";

    /* JADX INFO: renamed from: h9, reason: collision with root package name */
    public static final long f14526h9 = 10000;

    /* JADX INFO: renamed from: i9, reason: collision with root package name */
    @yt.k
    public static final String f14527i9 = "key_check_mode";

    @yt.l
    public b U8;
    public m1 V8;
    public ArrayList<h> W8;
    public ArrayList<h> X8;
    public ArrayList<h> Y8;
    public eu.davidea.flexibleadapter.b<h> Z8;

    /* JADX INFO: renamed from: a9, reason: collision with root package name */
    public a.InterfaceC0154a f14528a9;

    /* JADX INFO: renamed from: c9, reason: collision with root package name */
    public boolean f14530c9;

    /* JADX INFO: renamed from: d9, reason: collision with root package name */
    public boolean f14531d9;

    /* JADX INFO: renamed from: e9, reason: collision with root package name */
    public long f14532e9;

    @yt.k
    public final Runnable S8 = new Runnable() { // from class: com.flydigi.device_manager.ui.connection.w
        @Override // java.lang.Runnable
        public final void run() {
            ScanFragment.g8(this.f14576a);
        }
    };

    @yt.k
    public final Runnable T8 = new Runnable() { // from class: com.flydigi.device_manager.ui.connection.u
        @Override // java.lang.Runnable
        public final void run() {
            ScanFragment.Y7(this.f14574a);
        }
    };

    /* JADX INFO: renamed from: b9, reason: collision with root package name */
    public boolean f14529b9 = true;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }

        public static /* synthetic */ ScanFragment b(a aVar, String str, boolean z10, int i10, Object obj) {
            if ((i10 & 2) != 0) {
                z10 = true;
            }
            return aVar.a(str, z10);
        }

        @hk.m
        @yt.k
        public final ScanFragment a(@yt.k String deviceCode, boolean z10) {
            f0.p(deviceCode, "deviceCode");
            ScanFragment scanFragment = new ScanFragment();
            scanFragment.c5(androidx.core.os.e.b(new Pair("key_device_code", deviceCode), new Pair(ScanFragment.f14527i9, Boolean.valueOf(z10))));
            return scanFragment;
        }
    }

    public interface b {
        void F();

        void O();
    }

    public static final class c implements TabLayout.f {
        public c() {
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void a(@yt.k TabLayout.i tab) {
            f0.p(tab, "tab");
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void b(@yt.k TabLayout.i tab) {
            f0.p(tab, "tab");
            ArrayList arrayList = null;
            if (tab.k() == 1) {
                m1 m1Var = ScanFragment.this.V8;
                if (m1Var == null) {
                    f0.S("viewBinding");
                    m1Var = null;
                }
                TextView textView = m1Var.f10226e;
                f0.o(textView, "viewBinding.btnHelp");
                o5.c.b(textView, Boolean.TRUE, false, 2, null);
                eu.davidea.flexibleadapter.b bVar = ScanFragment.this.Z8;
                if (bVar == null) {
                    f0.S("mAdapter");
                    bVar = null;
                }
                ArrayList arrayList2 = ScanFragment.this.X8;
                if (arrayList2 == null) {
                    f0.S("failureItems");
                } else {
                    arrayList = arrayList2;
                }
                bVar.I4(arrayList);
                return;
            }
            m1 m1Var2 = ScanFragment.this.V8;
            if (m1Var2 == null) {
                f0.S("viewBinding");
                m1Var2 = null;
            }
            TextView textView2 = m1Var2.f10226e;
            f0.o(textView2, "viewBinding.btnHelp");
            o5.c.b(textView2, Boolean.FALSE, false, 2, null);
            eu.davidea.flexibleadapter.b bVar2 = ScanFragment.this.Z8;
            if (bVar2 == null) {
                f0.S("mAdapter");
                bVar2 = null;
            }
            ArrayList arrayList3 = ScanFragment.this.W8;
            if (arrayList3 == null) {
                f0.S("normalItems");
            } else {
                arrayList = arrayList3;
            }
            bVar2.I4(arrayList);
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void c(@yt.k TabLayout.i tab) {
            f0.p(tab, "tab");
        }
    }

    public static /* synthetic */ ArrayList H7(ScanFragment scanFragment, String str, boolean z10, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: generateFailureSituation");
        }
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return scanFragment.G7(str, z10);
    }

    public static /* synthetic */ Map J7(ScanFragment scanFragment, BluetoothDevice bluetoothDevice, GamepadInfo gamepadInfo, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: generateUmInfo");
        }
        if ((i10 & 1) != 0) {
            bluetoothDevice = null;
        }
        if ((i10 & 2) != 0) {
            gamepadInfo = null;
        }
        return scanFragment.I7(bluetoothDevice, gamepadInfo);
    }

    @hk.m
    @yt.k
    public static final ScanFragment K7(@yt.k String str, boolean z10) {
        return f14524f9.a(str, z10);
    }

    public static final void M7(final ScanFragment this$0, final BluetoothDevice device, final GamepadInfo gamepadInfo) {
        f0.p(this$0, "this$0");
        f0.p(device, "$device");
        o5.a.t0(this$0.U1(), new FZDialog.a().t(this$0.c3(R.string.device_gamepad_firmware_upgrade)).j(this$0.c3(R.string.device_dialog_firmware_upgrade_force_desc)).g(this$0.c3(R.string.device_update)).b(Boolean.FALSE).f(new FZDialog.c() { // from class: com.flydigi.device_manager.ui.connection.q
            @Override // com.flydigi.base.widget.FZDialog.c
            public final void a(DialogFragment dialogFragment) {
                ScanFragment.N7(this.f14565a, device, gamepadInfo, dialogFragment);
            }
        }).d(this$0.c3(R.string.cancel)).c(new FZDialog.c() { // from class: com.flydigi.device_manager.ui.connection.r
            @Override // com.flydigi.base.widget.FZDialog.c
            public final void a(DialogFragment dialogFragment) {
                ScanFragment.O7(this.f14568a, device, gamepadInfo, dialogFragment);
            }
        }).a());
    }

    public static final void N7(ScanFragment this$0, BluetoothDevice device, GamepadInfo gamepadInfo, DialogFragment dialogFragment) {
        f0.p(this$0, "this$0");
        f0.p(device, "$device");
        m9.s.Z();
        u9.g.a().d(this$0.X1(), "Connect_Firmware_Upgrade_Start", "连接流程_跳转到固件升级", this$0.I7(device, gamepadInfo));
        com.flydigi.userBehavior.a.a().b(this$0.X1(), "连接激活_外设连接弹窗_升级外设固件");
        u9.g.a().d(this$0.X1(), "Connect_Success", "连接流程_连接成功", this$0.I7(device, gamepadInfo));
        h3.a.j().d(a.d.f31952h).withString("key_device_code", m9.t.i(device.getName())).withBoolean(DataConstant.DEVICE_KEY_FIRMWARE_FORCE_LATEST, true).navigation();
        dialogFragment.I5();
        this$0.e6();
    }

    public static final void O7(ScanFragment this$0, BluetoothDevice device, GamepadInfo gamepadInfo, DialogFragment dialogFragment) {
        f0.p(this$0, "this$0");
        f0.p(device, "$device");
        dialogFragment.I5();
        com.flydigi.userBehavior.a.a().b(this$0.X1(), "连接激活_外设连接弹窗_拒绝升级固件");
        u9.g.a().d(this$0.X1(), "Connect_Firmware_Upgrade_Cancel", "连接流程_拒绝升级固件", this$0.I7(device, gamepadInfo));
        if (gamepadInfo != null) {
            this$0.X0(device);
        }
    }

    public static final void P7(ScanFragment this$0, BluetoothDevice bluetoothDevice) {
        f0.p(this$0, "this$0");
        m1 m1Var = this$0.V8;
        if (m1Var == null) {
            f0.S("viewBinding");
            m1Var = null;
        }
        m1Var.f10230i.setText(this$0.d3(R.string.device_state_create_connect, bluetoothDevice.getName()));
        this$0.Z7();
    }

    public static final void Q7(ScanFragment this$0) {
        f0.p(this$0, "this$0");
        m1 m1Var = null;
        u9.g.a().d(this$0.X1(), "Connect_Scan_Started", "连接流程_扫描开始", J7(this$0, null, null, 3, null));
        m1 m1Var2 = this$0.V8;
        if (m1Var2 == null) {
            f0.S("viewBinding");
        } else {
            m1Var = m1Var2;
        }
        m1Var.f10230i.setText(this$0.c3(R.string.device_connect_scanning));
        this$0.h8();
        this$0.C6().postDelayed(this$0.S8, 10000L);
    }

    public static final void R7(ScanFragment this$0, View view) {
        f0.p(this$0, "this$0");
        this$0.e6();
        b bVar = this$0.U8;
        if (bVar != null) {
            bVar.F();
        }
    }

    public static final void S7(View view) {
        h3.a.j().d(i9.a.f31902d).withString(DataConstant.WEB_URL, o5.p.d() ? com.flydigi.device_manager.o.f14459c : com.flydigi.device_manager.o.f14460d).navigation();
    }

    public static final void W7(ScanFragment this$0) {
        f0.p(this$0, "this$0");
        m1 m1Var = this$0.V8;
        ArrayList<h> arrayList = null;
        if (m1Var == null) {
            f0.S("viewBinding");
            m1Var = null;
        }
        m1Var.f10230i.setText(R.string.device_connect_scanning_failure_connect_failed);
        this$0.f14531d9 = true;
        m1 m1Var2 = this$0.V8;
        if (m1Var2 == null) {
            f0.S("viewBinding");
            m1Var2 = null;
        }
        TabLayout tabLayout = m1Var2.f10229h;
        f0.o(tabLayout, "viewBinding.tabLayout");
        Boolean bool = Boolean.FALSE;
        o5.c.b(tabLayout, bool, false, 2, null);
        m1 m1Var3 = this$0.V8;
        if (m1Var3 == null) {
            f0.S("viewBinding");
            m1Var3 = null;
        }
        TextView textView = m1Var3.f10232k;
        f0.o(textView, "viewBinding.tvTitleConnection");
        Boolean bool2 = Boolean.TRUE;
        o5.c.b(textView, bool2, false, 2, null);
        m1 m1Var4 = this$0.V8;
        if (m1Var4 == null) {
            f0.S("viewBinding");
            m1Var4 = null;
        }
        TextView textView2 = m1Var4.f10226e;
        f0.o(textView2, "viewBinding.btnHelp");
        o5.c.b(textView2, bool2, false, 2, null);
        m1 m1Var5 = this$0.V8;
        if (m1Var5 == null) {
            f0.S("viewBinding");
            m1Var5 = null;
        }
        m1Var5.f10233l.setVisibility(4);
        m1 m1Var6 = this$0.V8;
        if (m1Var6 == null) {
            f0.S("viewBinding");
            m1Var6 = null;
        }
        m1Var6.f10230i.setTextColor(this$0.V2().getColor(R.color.color_fa5555));
        m1 m1Var7 = this$0.V8;
        if (m1Var7 == null) {
            f0.S("viewBinding");
            m1Var7 = null;
        }
        ProgressBar progressBar = m1Var7.f10227f;
        f0.o(progressBar, "viewBinding.progress");
        o5.c.b(progressBar, bool, false, 2, null);
        eu.davidea.flexibleadapter.b<h> bVar = this$0.Z8;
        if (bVar == null) {
            f0.S("mAdapter");
            bVar = null;
        }
        ArrayList<h> arrayList2 = this$0.Y8;
        if (arrayList2 == null) {
            f0.S("connectFailureItems");
        } else {
            arrayList = arrayList2;
        }
        bVar.I4(arrayList);
    }

    public static final void Y7(ScanFragment this$0) {
        f0.p(this$0, "this$0");
        this$0.X7();
    }

    public static final void a8(ScanFragment this$0) {
        f0.p(this$0, "this$0");
        this$0.f14531d9 = true;
        m1 m1Var = this$0.V8;
        ArrayList<h> arrayList = null;
        if (m1Var == null) {
            f0.S("viewBinding");
            m1Var = null;
        }
        TabLayout tabLayout = m1Var.f10229h;
        f0.o(tabLayout, "viewBinding.tabLayout");
        o5.c.b(tabLayout, Boolean.FALSE, false, 2, null);
        m1 m1Var2 = this$0.V8;
        if (m1Var2 == null) {
            f0.S("viewBinding");
            m1Var2 = null;
        }
        TextView textView = m1Var2.f10232k;
        f0.o(textView, "viewBinding.tvTitleConnection");
        Boolean bool = Boolean.TRUE;
        o5.c.b(textView, bool, false, 2, null);
        m1 m1Var3 = this$0.V8;
        if (m1Var3 == null) {
            f0.S("viewBinding");
            m1Var3 = null;
        }
        TextView textView2 = m1Var3.f10226e;
        f0.o(textView2, "viewBinding.btnHelp");
        o5.c.b(textView2, bool, false, 2, null);
        m1 m1Var4 = this$0.V8;
        if (m1Var4 == null) {
            f0.S("viewBinding");
            m1Var4 = null;
        }
        m1Var4.f10233l.setVisibility(4);
        m1 m1Var5 = this$0.V8;
        if (m1Var5 == null) {
            f0.S("viewBinding");
            m1Var5 = null;
        }
        m1Var5.f10230i.setTextColor(this$0.V2().getColor(R.color.colorPrimary));
        m1 m1Var6 = this$0.V8;
        if (m1Var6 == null) {
            f0.S("viewBinding");
            m1Var6 = null;
        }
        ProgressBar progressBar = m1Var6.f10227f;
        f0.o(progressBar, "viewBinding.progress");
        o5.c.b(progressBar, bool, false, 2, null);
        eu.davidea.flexibleadapter.b<h> bVar = this$0.Z8;
        if (bVar == null) {
            f0.S("mAdapter");
            bVar = null;
        }
        ArrayList<h> arrayList2 = this$0.Y8;
        if (arrayList2 == null) {
            f0.S("connectFailureItems");
        } else {
            arrayList = arrayList2;
        }
        bVar.I4(arrayList);
    }

    public static final void c8(DialogFragment dialogFragment) {
        dialogFragment.I5();
    }

    public static final void d8(boolean z10, ScanFragment this$0, DialogFragment dialogFragment) {
        f0.p(this$0, "this$0");
        dialogFragment.I5();
        if (z10) {
            this$0.T7();
        } else {
            this$0.b7(this$0.H6());
        }
    }

    public static final void f8(ScanFragment this$0) {
        f0.p(this$0, "this$0");
        m1 m1Var = this$0.V8;
        if (m1Var == null) {
            f0.S("viewBinding");
            m1Var = null;
        }
        TabLayout.i iVarY = m1Var.f10229h.y(1);
        if (iVarY != null) {
            iVarY.r();
        }
    }

    public static final void g8(ScanFragment this$0) {
        f0.p(this$0, "this$0");
        this$0.e8();
    }

    public static final void i8(ScanFragment this$0) {
        f0.p(this$0, "this$0");
        this$0.f14531d9 = false;
        m1 m1Var = this$0.V8;
        if (m1Var == null) {
            f0.S("viewBinding");
            m1Var = null;
        }
        TabLayout tabLayout = m1Var.f10229h;
        f0.o(tabLayout, "viewBinding.tabLayout");
        Boolean bool = Boolean.TRUE;
        o5.c.b(tabLayout, bool, false, 2, null);
        m1 m1Var2 = this$0.V8;
        if (m1Var2 == null) {
            f0.S("viewBinding");
            m1Var2 = null;
        }
        TextView textView = m1Var2.f10232k;
        f0.o(textView, "viewBinding.tvTitleConnection");
        Boolean bool2 = Boolean.FALSE;
        o5.c.b(textView, bool2, false, 2, null);
        m1 m1Var3 = this$0.V8;
        if (m1Var3 == null) {
            f0.S("viewBinding");
            m1Var3 = null;
        }
        TabLayout.i iVarY = m1Var3.f10229h.y(0);
        if (iVarY != null) {
            iVarY.r();
        }
        m1 m1Var4 = this$0.V8;
        if (m1Var4 == null) {
            f0.S("viewBinding");
            m1Var4 = null;
        }
        TextView textView2 = m1Var4.f10226e;
        f0.o(textView2, "viewBinding.btnHelp");
        o5.c.b(textView2, bool2, false, 2, null);
        m1 m1Var5 = this$0.V8;
        if (m1Var5 == null) {
            f0.S("viewBinding");
            m1Var5 = null;
        }
        MaterialDivider materialDivider = m1Var5.f10233l;
        f0.o(materialDivider, "viewBinding.viewDivider");
        o5.c.b(materialDivider, bool, false, 2, null);
        m1 m1Var6 = this$0.V8;
        if (m1Var6 == null) {
            f0.S("viewBinding");
            m1Var6 = null;
        }
        m1Var6.f10230i.setTextColor(this$0.V2().getColor(R.color.colorPrimary));
        eu.davidea.flexibleadapter.b<h> bVar = this$0.Z8;
        if (bVar == null) {
            f0.S("mAdapter");
            bVar = null;
        }
        ArrayList<h> arrayList = this$0.W8;
        if (arrayList == null) {
            f0.S("normalItems");
            arrayList = null;
        }
        bVar.I4(arrayList);
        m1 m1Var7 = this$0.V8;
        if (m1Var7 == null) {
            f0.S("viewBinding");
            m1Var7 = null;
        }
        ProgressBar progressBar = m1Var7.f10227f;
        f0.o(progressBar, "viewBinding.progress");
        o5.c.b(progressBar, bool, false, 2, null);
    }

    public final void F7(BluetoothDevice bluetoothDevice, GamepadInfo gamepadInfo) {
        if (bluetoothDevice != null) {
            a.InterfaceC0154a interfaceC0154a = this.f14528a9;
            if (interfaceC0154a == null) {
                f0.S("mPresenter");
                interfaceC0154a = null;
            }
            Application applicationA = j1.a();
            f0.o(applicationA, "getApp()");
            interfaceC0154a.a(applicationA, bluetoothDevice, gamepadInfo);
        }
    }

    public final ArrayList<h> G7(String str, boolean z10) {
        h[] hVarArr = new h[3];
        int iH = a5.b.h(str);
        String strC3 = c3((androidx.core.util.j.a(str, m9.h.B) || androidx.core.util.j.a(str, m9.h.C)) ? R.string.device_connect_scanning_failure_light_flash_k1 : R.string.device_connect_scanning_failure_light_flash);
        f0.o(strC3, "getString(\n             …      }\n                )");
        hVarArr[0] = new h(1, iH, strC3, c3(R.string.device_connect_scanning_failure_light_flash_desc));
        int i10 = z10 ? 5 : 3;
        int iJ = a5.b.j(str);
        String strC32 = c3((androidx.core.util.j.a(str, m9.h.B) || androidx.core.util.j.a(str, m9.h.C)) ? R.string.device_connect_scanning_failure_light_on_k1 : R.string.device_connect_scanning_failure_light_on);
        f0.o(strC32, "getString(\n             …      }\n                )");
        hVarArr[1] = new h(i10, iJ, strC32, c3(z10 ? R.string.device_connect_scanning_failure_light_on_desc_connect : R.string.device_connect_scanning_failure_light_on_desc));
        int i11 = a5.b.i(str);
        String strC33 = c3((androidx.core.util.j.a(str, m9.h.B) || androidx.core.util.j.a(str, m9.h.C)) ? R.string.device_connect_scanning_failure_light_off_k1 : R.string.device_connect_scanning_failure_light_off);
        f0.o(strC33, "getString(\n             …      }\n                )");
        hVarArr[2] = new h(0, i11, strC33, c3(z10 ? R.string.device_connect_scanning_failure_light_off_desc_1 : f0.g(str, m9.h.f40773p) ? R.string.device_connect_scanning_failure_light_off_desc_q1 : f0.g(str, m9.h.f40777t) ? R.string.device_connect_scanning_failure_light_off_desc_x9 : R.string.device_connect_scanning_failure_light_off_desc));
        return CollectionsKt__CollectionsKt.r(hVarArr);
    }

    public final Map<String, String> I7(BluetoothDevice bluetoothDevice, GamepadInfo gamepadInfo) {
        Map<String, String> mapW = s0.W(new Pair("manufacturer", com.blankj.utilcode.util.x.j()), new Pair("model", com.blankj.utilcode.util.x.k()), new Pair("system", String.valueOf(Build.VERSION.SDK_INT)));
        if (bluetoothDevice != null) {
            s0.o0(mapW, new Pair("device_name", bluetoothDevice.getName()));
        }
        if (gamepadInfo != null) {
            s0.o0(mapW, new Pair("firmware", gamepadInfo.getFirmwareVersion()));
            s0.o0(mapW, new Pair("mappingMode", gamepadInfo.getReadableMappingMode()));
        }
        return mapW;
    }

    @Override // com.flydigi.device_manager.ui.connection.a.b
    public void J0(@yt.k final BluetoothDevice device, @yt.k String minVersion, @yt.l final GamepadInfo gamepadInfo) {
        f0.p(device, "device");
        f0.p(minVersion, "minVersion");
        I6().e(new Runnable() { // from class: com.flydigi.device_manager.ui.connection.o
            @Override // java.lang.Runnable
            public final void run() {
                ScanFragment.M7(this.f14561a, device, gamepadInfo);
            }
        });
    }

    @Override // com.flydigi.device_manager.ui.BleDialogFragment
    public void J6() {
        super.J6();
        k7();
    }

    @Override // com.flydigi.device_manager.ui.BleDialogFragment, com.flydigi.base.common.BaseDialogFragment, com.trello.rxlifecycle3.components.support.RxDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void K3(@yt.l Bundle bundle) {
        super.K3(bundle);
        com.flydigi.userBehavior.a.a().b(X1(), "连接激活_设备详情页_连接扫描");
        U5(false);
        Bundle bundleT1 = T1();
        ArrayList<h> arrayList = null;
        String string = bundleT1 != null ? bundleT1.getString("key_device_code") : null;
        if (string == null) {
            string = "";
        }
        i7(string);
        Bundle bundleT12 = T1();
        this.f14529b9 = bundleT12 != null ? bundleT12.getBoolean(f14527i9) : true;
        h[] hVarArr = new h[1];
        int iP = a5.b.p(H6());
        String strC3 = c3(n0.b(H6(), m9.h.A) ? R.string.device_connect_scanning_failure_power_on_g1 : (n0.b(H6(), m9.h.f40779v) || n0.b(H6(), m9.h.f40780w) || n0.b(H6(), m9.h.f40781x)) ? R.string.device_connect_scanning_failure_power_on_f3 : R.string.device_connect_scanning_failure_power_on);
        f0.o(strC3, "getString(\n             …      }\n                )");
        hVarArr[0] = new h(0, iP, strC3, a5.b.o(H6()));
        this.W8 = CollectionsKt__CollectionsKt.r(hVarArr);
        if (androidx.core.util.j.a(H6(), m9.h.B)) {
            ArrayList<h> arrayList2 = this.W8;
            if (arrayList2 == null) {
                f0.S("normalItems");
                arrayList2 = null;
            }
            int i10 = R.drawable.device_situation_longpress_home;
            String strC32 = c3(R.string.device_situation_longpress_home_title);
            f0.o(strC32, "getString(R.string.devic…ion_longpress_home_title)");
            arrayList2.add(new h(0, i10, strC32, null, 8, null));
            ArrayList<h> arrayList3 = this.W8;
            if (arrayList3 == null) {
                f0.S("normalItems");
                arrayList3 = null;
            }
            int i11 = R.drawable.device_situation_switch_to_flashplay;
            String strC33 = c3(R.string.device_situation_switch_to_flashplay_title);
            f0.o(strC33, "getString(R.string.devic…witch_to_flashplay_title)");
            arrayList3.add(new h(0, i11, strC33, c3(R.string.device_situation_switch_to_flashplay_desc)));
        } else if (androidx.core.util.j.a(H6(), m9.h.C)) {
            ArrayList<h> arrayList4 = this.W8;
            if (arrayList4 == null) {
                f0.S("normalItems");
                arrayList4 = null;
            }
            int i12 = R.drawable.device_situation_longpress_home_k2;
            String strC34 = c3(R.string.device_situation_longpress_home_title);
            f0.o(strC34, "getString(R.string.devic…ion_longpress_home_title)");
            arrayList4.add(new h(0, i12, strC34, null, 8, null));
            ArrayList<h> arrayList5 = this.W8;
            if (arrayList5 == null) {
                f0.S("normalItems");
                arrayList5 = null;
            }
            int i13 = R.drawable.device_situation_switch_to_flashplay_k2;
            String strC35 = c3(R.string.device_situation_switch_to_flashplay_title);
            f0.o(strC35, "getString(R.string.devic…witch_to_flashplay_title)");
            arrayList5.add(new h(0, i13, strC35, c3(R.string.device_situation_switch_to_flashplay_desc)));
        } else if (n0.b(H6(), m9.h.f40779v) || n0.b(H6(), m9.h.f40780w) || n0.b(H6(), m9.h.f40781x)) {
            ArrayList<h> arrayList6 = this.W8;
            if (arrayList6 == null) {
                f0.S("normalItems");
                arrayList6 = null;
            }
            int i14 = R.drawable.device_situation_switch_to_flashplay_f3;
            String strC36 = c3(R.string.device_connect_scanning_failure_keep_flash_desc_f3);
            f0.o(strC36, "getString(R.string.devic…ilure_keep_flash_desc_f3)");
            arrayList6.add(new h(0, i14, strC36, ""));
        } else {
            ArrayList<h> arrayList7 = this.W8;
            if (arrayList7 == null) {
                f0.S("normalItems");
                arrayList7 = null;
            }
            int iH = a5.b.h(H6());
            String strC37 = c3(R.string.device_connect_scanning_failure_keep_flash);
            f0.o(strC37, "getString(R.string.devic…nning_failure_keep_flash)");
            arrayList7.add(new h(0, iH, strC37, a5.b.g(X1(), H6())));
        }
        this.X8 = G7(H6(), false);
        this.Y8 = G7(H6(), true);
        ArrayList<h> arrayList8 = this.W8;
        if (arrayList8 == null) {
            f0.S("normalItems");
        } else {
            arrayList = arrayList8;
        }
        this.Z8 = new eu.davidea.flexibleadapter.b<>(arrayList, this, true);
        this.f14528a9 = new ConnectPresenter(this);
    }

    @Override // com.flydigi.device_manager.ui.BleDialogFragment
    public void K6(@yt.l String str, @yt.k BluetoothDevice device) {
        ArrayList<h> arrayList;
        String str2;
        f0.p(device, "device");
        this.f14532e9 = System.currentTimeMillis();
        super.K6(str, device);
        ArrayList<h> arrayList2 = null;
        u9.g.a().d(X1(), "Connect_Scan_Device_Found", "连接流程_发现设备", J7(this, device, null, 2, null));
        m1 m1Var = this.V8;
        if (m1Var == null) {
            f0.S("viewBinding");
            m1Var = null;
        }
        m1Var.f10230i.setText(c3(R.string.device_preparing));
        m1 m1Var2 = this.V8;
        if (m1Var2 == null) {
            f0.S("viewBinding");
            m1Var2 = null;
        }
        m1Var2.f10230i.setTextColor(V2().getColor(R.color.colorPrimary));
        m1 m1Var3 = this.V8;
        if (m1Var3 == null) {
            f0.S("viewBinding");
            m1Var3 = null;
        }
        ProgressBar progressBar = m1Var3.f10227f;
        f0.o(progressBar, "viewBinding.progress");
        o5.c.b(progressBar, Boolean.TRUE, false, 2, null);
        eu.davidea.flexibleadapter.b<h> bVar = this.Z8;
        if (bVar == null) {
            f0.S("mAdapter");
            bVar = null;
        }
        m1 m1Var4 = this.V8;
        if (m1Var4 == null) {
            f0.S("viewBinding");
            m1Var4 = null;
        }
        if (m1Var4.f10229h.getSelectedTabPosition() == 1) {
            arrayList = this.X8;
            if (arrayList == null) {
                str2 = "failureItems";
                f0.S(str2);
            }
            arrayList2 = arrayList;
        } else {
            arrayList = this.W8;
            if (arrayList == null) {
                str2 = "normalItems";
                f0.S(str2);
            }
            arrayList2 = arrayList;
        }
        bVar.I4(arrayList2);
        C6().removeCallbacks(this.S8);
    }

    @Override // com.flydigi.device_manager.ui.BleDialogFragment
    public void L6(@yt.k GamepadInfo deviceInfo) {
        f0.p(deviceInfo, "deviceInfo");
        if (!deviceInfo.isConnected()) {
            if (!deviceInfo.isDisconnected() || this.f14532e9 <= 0) {
                return;
            }
            com.flydigi.userBehavior.a.a().b(X1(), "连接激活_外设连接弹窗_手柄连接失败");
            return;
        }
        if (this.f14532e9 > 0) {
            long jCurrentTimeMillis = System.currentTimeMillis() - this.f14532e9;
            u9.g.a().f(X1(), "Connect_Success_Period", J7(this, null, null, 3, null), (int) jCurrentTimeMillis);
            u9.g.a().d(X1(), "Connect_Success", "连接流程_连接成功", J7(this, null, null, 3, null));
            com.flydigi.userBehavior.a.a().b(X1(), "连接激活_外设连接弹窗_手柄连接成功");
            com.flydigi.userBehavior.a.a().b(X1(), "连接激活_外设连接弹窗_手柄连接时长" + (jCurrentTimeMillis / ((long) 1000)) + 's');
            this.f14532e9 = 0L;
        }
        b bVar = this.U8;
        if (bVar != null) {
            bVar.O();
        }
        e6();
    }

    @yt.l
    public final b L7() {
        return this.U8;
    }

    @Override // eu.davidea.flexibleadapter.b.z
    public boolean M(@yt.k View view, int i10) {
        f0.p(view, "view");
        if (i10 != -1) {
            eu.davidea.flexibleadapter.b<h> bVar = this.Z8;
            if (bVar == null) {
                f0.S("mAdapter");
                bVar = null;
            }
            h hVar = (h) bVar.g2(i10);
            if (hVar != null) {
                if (this.f14531d9) {
                    b8(hVar.C() == 5);
                } else {
                    int iC = hVar.C();
                    if (iC == 1) {
                        u9.h.c(X1(), "Device_Scan_Dialog_Remove_Bond", "连接激活_外设连接弹窗_取消配对");
                        if (w6(H6())) {
                            b7(H6());
                        } else {
                            com.flydigi.base.common.o.E(c3(R.string.device_no_bonded_device_found));
                        }
                    } else if (iC == 2) {
                        u9.h.c(X1(), "Device_Scan_Dialog_Upgrade_Firmware", "连接激活_外设连接弹窗_升级外设固件");
                        h3.a.j().d(a.d.f31952h).withString("key_device_code", H6()).navigation(w1());
                        e6();
                    } else if (iC == 3) {
                        u9.h.c(X1(), "Device_Scan_Dialog_Reset_Gamepad", "连接激活_外设连接弹窗_重置外设");
                        h3.a.j().d(i9.a.f31902d).withString(DataConstant.WEB_URL, o5.p.d() ? com.flydigi.device_manager.o.f14471o : com.flydigi.device_manager.o.f14472p).navigation(w1());
                    } else if (iC == 5) {
                        T7();
                    }
                }
                return true;
            }
        }
        return false;
    }

    @Override // com.flydigi.device_manager.ui.BleDialogFragment
    public void M6() {
        super.M6();
        if (D6()) {
            com.flydigi.userBehavior.a.a().b(X1(), "连接激活_外设连接弹窗_私有连接超时");
            u9.g.a().d(X1(), "Connect_Private_Gatt_Connection_Timeout", "连接流程_私有连接超时", J7(this, null, null, 3, null));
        }
    }

    @Override // com.flydigi.device_manager.ui.BleDialogFragment, com.flydigi.sdk.bluetooth.w
    public void O2(@yt.k BluetoothGatt gatt) {
        f0.p(gatt, "gatt");
        if (D6()) {
            u9.g.a().d(X1(), "Connect_Private_Gatt_Connection_Disconnected", "连接流程_私有连接断开", J7(this, gatt.getDevice(), null, 2, null));
            com.flydigi.userBehavior.a.a().b(X1(), "连接激活_外设连接弹窗_私有连接断开");
        }
        super.O2(gatt);
    }

    @Override // com.flydigi.base.common.BaseDialogFragment, androidx.fragment.app.Fragment
    @yt.k
    public View O3(@yt.k LayoutInflater inflater, @yt.l ViewGroup viewGroup, @yt.l Bundle bundle) {
        f0.p(inflater, "inflater");
        m1 m1VarD = m1.d(inflater, viewGroup, false);
        f0.o(m1VarD, "inflate(inflater, container, false)");
        this.V8 = m1VarD;
        if (m1VarD == null) {
            f0.S("viewBinding");
            m1VarD = null;
        }
        FrameLayout root = m1VarD.getRoot();
        f0.o(root, "viewBinding.root");
        return root;
    }

    @Override // com.flydigi.device_manager.ui.BleDialogFragment, com.flydigi.sdk.bluetooth.m
    public void P(boolean z10) {
        super.P(z10);
        if (z10) {
            return;
        }
        this.f14530c9 = false;
        k7();
    }

    @Override // com.flydigi.device_manager.ui.BleDialogFragment, com.flydigi.sdk.bluetooth.n
    public void R1(@yt.l final BluetoothDevice bluetoothDevice) {
        super.R1(bluetoothDevice);
        if (bluetoothDevice != null) {
            I6().e(new Runnable() { // from class: com.flydigi.device_manager.ui.connection.n
                @Override // java.lang.Runnable
                public final void run() {
                    ScanFragment.P7(this.f14559a, bluetoothDevice);
                }
            });
            u9.g.a().d(X1(), "Connect_Create_Bond", "连接流程_开始配对", J7(this, bluetoothDevice, null, 2, null));
            com.flydigi.userBehavior.a.a().b(X1(), "连接激活_外设连接弹窗_开始配对");
        }
    }

    @Override // com.flydigi.device_manager.ui.BleDialogFragment, com.flydigi.base.common.BaseDialogFragment, com.trello.rxlifecycle3.components.support.RxDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void R3() {
        BluetoothDevice device;
        this.f14532e9 = 0L;
        BluetoothGatt bluetoothGattK = m9.s.k();
        if (bluetoothGattK != null && (device = bluetoothGattK.getDevice()) != null) {
            String address = device.getAddress();
            f0.o(address, "it.address");
            BluetoothDevice bluetoothDeviceM = m9.s.m(address);
            boolean z10 = false;
            if (bluetoothDeviceM != null && bluetoothDeviceM.getBondState() == 12) {
                z10 = true;
            }
            if (!z10) {
                m9.s.f();
            }
        }
        super.R3();
    }

    @Override // com.flydigi.device_manager.ui.BleDialogFragment
    public void R6(@yt.k BluetoothDevice device, @yt.k GamepadInfo deviceInfo) {
        f0.p(device, "device");
        f0.p(deviceInfo, "deviceInfo");
        if (!this.f14529b9) {
            super.R6(device, deviceInfo);
            return;
        }
        int i10 = 1;
        if (!deviceInfo.isSupportFlashplay() || !com.flydigi.device_manager.ui.p.a() || (deviceInfo.isGamepadHalf() && !u9.b.e(true))) {
            i10 = 0;
        }
        if (deviceInfo.getMappingMode() == i10) {
            F7(device, deviceInfo);
        } else {
            m9.s.a0(i10);
            S6(deviceInfo);
        }
    }

    @Override // com.flydigi.device_manager.ui.BleDialogFragment
    public void S6(@yt.k GamepadInfo deviceInfo) {
        f0.p(deviceInfo, "deviceInfo");
        super.S6(deviceInfo);
        com.flydigi.userBehavior.a.a().b(X1(), "连接激活_外设连接弹窗_模式自动切换");
        u9.g.a().d(X1(), "Connect_Mapping_Mode_Auto_Switch", "连接流程_模式自动切换", J7(this, null, deviceInfo, 1, null));
        u9.g.a().d(X1(), "Connect_Success", "连接流程_连接成功", J7(this, null, null, 3, null));
    }

    public final void T7() {
        this.f14530c9 = true;
        m9.s.c();
    }

    public final void U7(@yt.l b bVar) {
        this.U8 = bVar;
    }

    @Override // com.flydigi.device_manager.ui.BleDialogFragment, com.flydigi.sdk.bluetooth.w
    public void V0(@yt.k BluetoothDevice device) {
        f0.p(device, "device");
        super.V0(device);
        if (D6()) {
            com.flydigi.userBehavior.a.a().b(X1(), "连接激活_外设连接弹窗_私有连接开始");
            u9.g.a().d(X1(), "Connect_Private_Gatt_Connection_start", "连接流程_私有连接开始", J7(this, null, null, 3, null));
        }
    }

    public final void V7() {
        I6().e(new Runnable() { // from class: com.flydigi.device_manager.ui.connection.k
            @Override // java.lang.Runnable
            public final void run() {
                ScanFragment.W7(this.f14556a);
            }
        });
    }

    @Override // com.flydigi.device_manager.ui.connection.a.b
    public void X0(@yt.k BluetoothDevice device) {
        f0.p(device, "device");
        y6(device);
    }

    public final void X7() {
        V7();
    }

    public final void Z7() {
        I6().e(new Runnable() { // from class: com.flydigi.device_manager.ui.connection.m
            @Override // java.lang.Runnable
            public final void run() {
                ScanFragment.a8(this.f14558a);
            }
        });
    }

    public final void b8(final boolean z10) {
        o5.a.t0(U1(), new FZDialog.a().t(c3(R.string.device_reconnect)).j(c3(z10 ? R.string.device_reopen_bluetooth_hint : R.string.device_reconnect_hint)).c(new FZDialog.c() { // from class: com.flydigi.device_manager.ui.connection.t
            @Override // com.flydigi.base.widget.FZDialog.c
            public final void a(DialogFragment dialogFragment) {
                ScanFragment.c8(dialogFragment);
            }
        }).d(c3(R.string.cancel)).g(c3(R.string.confirm)).f(new FZDialog.c() { // from class: com.flydigi.device_manager.ui.connection.s
            @Override // com.flydigi.base.widget.FZDialog.c
            public final void a(DialogFragment dialogFragment) {
                ScanFragment.d8(z10, this, dialogFragment);
            }
        }).a());
    }

    @Override // com.flydigi.base.common.BaseDialogFragment
    public int c6() {
        return R.layout.device_fragment_scan;
    }

    public final void e8() {
        I6().e(new Runnable() { // from class: com.flydigi.device_manager.ui.connection.x
            @Override // java.lang.Runnable
            public final void run() {
                ScanFragment.f8(this.f14577a);
            }
        });
    }

    public final void h8() {
        I6().e(new Runnable() { // from class: com.flydigi.device_manager.ui.connection.l
            @Override // java.lang.Runnable
            public final void run() {
                ScanFragment.i8(this.f14557a);
            }
        });
    }

    @Override // com.flydigi.device_manager.ui.BleDialogFragment, com.flydigi.sdk.bluetooth.n
    public void i0(@yt.l BluetoothDevice bluetoothDevice) {
        super.i0(bluetoothDevice);
        u9.g.a().d(X1(), "Connect_Create_Bond_Timeout", "连接流程_配对超时", J7(this, bluetoothDevice, null, 2, null));
        com.flydigi.userBehavior.a.a().b(X1(), "连接激活_外设连接弹窗_配对超时");
        V7();
    }

    @Override // com.flydigi.base.common.BaseDialogFragment, com.trello.rxlifecycle3.components.support.RxDialogFragment, androidx.fragment.app.Fragment
    public void j4(@yt.k View view, @yt.l Bundle bundle) {
        f0.p(view, "view");
        super.j4(view, bundle);
        m1 m1Var = this.V8;
        m1 m1Var2 = null;
        if (m1Var == null) {
            f0.S("viewBinding");
            m1Var = null;
        }
        RecyclerView recyclerView = m1Var.f10228g;
        eu.davidea.flexibleadapter.b<h> bVar = this.Z8;
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
        m1 m1Var3 = this.V8;
        if (m1Var3 == null) {
            f0.S("viewBinding");
            m1Var3 = null;
        }
        m1Var3.f10228g.n(jVar);
        m1 m1Var4 = this.V8;
        if (m1Var4 == null) {
            f0.S("viewBinding");
            m1Var4 = null;
        }
        com.blankj.utilcode.util.o.r(m1Var4.f10225d, new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.connection.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ScanFragment.R7(this.f14555a, view2);
            }
        });
        m1 m1Var5 = this.V8;
        if (m1Var5 == null) {
            f0.S("viewBinding");
            m1Var5 = null;
        }
        TabLayout tabLayout = m1Var5.f10229h;
        tabLayout.g(tabLayout.D().C(R.string.device_title_scan_situation_normal), true);
        tabLayout.d(tabLayout.D().C(R.string.device_title_scan_situation_failure));
        m1 m1Var6 = this.V8;
        if (m1Var6 == null) {
            f0.S("viewBinding");
            m1Var6 = null;
        }
        m1Var6.f10229h.c(new c());
        m1 m1Var7 = this.V8;
        if (m1Var7 == null) {
            f0.S("viewBinding");
        } else {
            m1Var2 = m1Var7;
        }
        com.blankj.utilcode.util.o.r(m1Var2.f10226e, new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.connection.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ScanFragment.S7(view2);
            }
        });
        this.f14532e9 = 0L;
        k7();
    }

    @Override // com.flydigi.device_manager.ui.BleDialogFragment, com.flydigi.sdk.bluetooth.n
    public void p2(@yt.l BluetoothDevice bluetoothDevice, boolean z10) {
        super.p2(bluetoothDevice, z10);
        if (z10) {
            u9.g.a().d(X1(), "Connect_Create_Bond_Success", "连接流程_配对成功", J7(this, bluetoothDevice, null, 2, null));
            C6().postDelayed(this.T8, com.google.android.exoplayer2.audio.j.f16899v);
            com.flydigi.userBehavior.a.a().b(X1(), "连接激活_外设连接弹窗_配对成功");
        } else {
            u9.g.a().d(X1(), "Connect_Create_Bond_Failure", "连接流程_配对失败", J7(this, bluetoothDevice, null, 2, null));
            com.flydigi.userBehavior.a.a().b(X1(), "连接激活_外设连接弹窗_配对失败");
            V7();
        }
    }

    @Override // com.flydigi.device_manager.ui.BleDialogFragment, com.flydigi.sdk.bluetooth.e0
    public void t0() {
        super.t0();
        I6().e(new Runnable() { // from class: com.flydigi.device_manager.ui.connection.v
            @Override // java.lang.Runnable
            public final void run() {
                ScanFragment.Q7(this.f14575a);
            }
        });
    }

    @Override // com.flydigi.device_manager.ui.BleDialogFragment, m9.r
    public void u0(@yt.l BluetoothDevice bluetoothDevice, @yt.k GamepadInfo deviceInfo) {
        f0.p(deviceInfo, "deviceInfo");
        super.u0(bluetoothDevice, deviceInfo);
        if (D6()) {
            com.flydigi.userBehavior.a.a().b(X1(), "连接激活_外设连接弹窗_私有连接成功");
            u9.g.a().d(X1(), "Connect_Private_Gatt_Connection_Connected", "连接流程_私有连接建立成功", I7(bluetoothDevice, deviceInfo));
        }
    }

    @Override // com.flydigi.device_manager.ui.BleDialogFragment, com.flydigi.sdk.bluetooth.e0
    public void x0(int i10) {
        super.x0(i10);
        if (i10 == 8 || i10 == 9) {
            return;
        }
        V7();
        u9.g.a().d(X1(), "Connect_Scan_Failed", "连接流程_扫描失败", J7(this, null, null, 3, null));
        com.flydigi.userBehavior.a.a().b(X1(), "连接激活_外设连接弹窗_扫描失败,errorCode:" + i10);
    }
}
