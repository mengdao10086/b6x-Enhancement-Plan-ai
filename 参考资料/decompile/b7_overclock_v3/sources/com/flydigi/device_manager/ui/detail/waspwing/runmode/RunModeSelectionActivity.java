package com.flydigi.device_manager.ui.detail.waspwing.runmode;

import a5.f;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.SuperscriptSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewGroupKt;
import androidx.fragment.app.DialogFragment;
import c7.j;
import com.blankj.utilcode.util.o;
import com.flydigi.base.common.p;
import com.flydigi.base.widget.FZDialog;
import com.flydigi.data.DataConstant;
import com.flydigi.device_manager.R;
import com.flydigi.device_manager.ui.detail.waspwing.runmode.RunModeSelectionActivity;
import com.flydigi.sdk.waspwing.WaspWingInfo;
import hk.m;
import i9.a;
import java.util.Iterator;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.jvm.internal.u;
import l9.c;
import t9.i;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes7.dex */
@t0({"SMAP\nRunModeSelectionActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RunModeSelectionActivity.kt\ncom/flydigi/device_manager/ui/detail/waspwing/runmode/RunModeSelectionActivity\n+ 2 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n*L\n1#1,224:1\n1295#2,2:225\n1295#2,2:227\n1295#2,2:229\n*S KotlinDebug\n*F\n+ 1 RunModeSelectionActivity.kt\ncom/flydigi/device_manager/ui/detail/waspwing/runmode/RunModeSelectionActivity\n*L\n184#1:225,2\n189#1:227,2\n193#1:229,2\n*E\n"})
public final class RunModeSelectionActivity extends p implements i {

    @k
    public static final a J7 = new a(null);

    @k
    public static final String K7 = "key_result_data_quick_switch";
    public j E7;
    public int F7 = -1;
    public int G7 = -1;
    public int H7 = -1;
    public int I7 = -1;

    @l
    public WaspWingInfo K2;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @m
        @k
        public final Intent a(@k Context context, @k WaspWingInfo deviceInfo) {
            f0.p(context, "context");
            f0.p(deviceInfo, "deviceInfo");
            Intent intent = new Intent(context, (Class<?>) RunModeSelectionActivity.class);
            intent.putExtra("key_device_info", deviceInfo);
            return intent;
        }
    }

    public static final void A4(RunModeSelectionActivity this$0, View view) {
        f0.p(this$0, "this$0");
        this$0.C4(this$0.H7, 3);
        this$0.setResult(-1, new Intent().putExtra("key_result_data", this$0.H7).putExtra(K7, this$0.I7));
    }

    public static final void B4(RunModeSelectionActivity this$0) {
        f0.p(this$0, "this$0");
        this$0.C4(this$0.F7, this$0.G7);
    }

    @m
    @k
    public static final Intent s4(@k Context context, @k WaspWingInfo waspWingInfo) {
        return J7.a(context, waspWingInfo);
    }

    public static final void t4(RunModeSelectionActivity this$0, View view) {
        f0.p(this$0, "this$0");
        this$0.C4(0, this$0.I7);
        this$0.setResult(-1, new Intent().putExtra("key_result_data", this$0.H7).putExtra(K7, this$0.I7));
    }

    public static final void u4(final WaspWingInfo waspwing, RunModeSelectionActivity this$0, View view) {
        f0.p(waspwing, "$waspwing");
        f0.p(this$0, "this$0");
        String firmwareVersion = waspwing.getFirmwareVersion();
        if (firmwareVersion != null) {
            if (!c.b("3.2.9", firmwareVersion)) {
                o5.a.t0(this$0.n3(), new FZDialog.a().t(this$0.getString(R.string.device_firmware_upgrade)).j(this$0.getString(R.string.device_wasping_firmware_upgrade_desc)).b(Boolean.TRUE).d(this$0.getString(R.string.cancel)).g(this$0.getString(R.string.cf_firmware_upgrade_do_action)).c(new FZDialog.c() { // from class: i7.l
                    @Override // com.flydigi.base.widget.FZDialog.c
                    public final void a(DialogFragment dialogFragment) {
                        RunModeSelectionActivity.v4(dialogFragment);
                    }
                }).f(new FZDialog.c() { // from class: i7.k
                    @Override // com.flydigi.base.widget.FZDialog.c
                    public final void a(DialogFragment dialogFragment) {
                        RunModeSelectionActivity.w4(waspwing, dialogFragment);
                    }
                }).a());
            } else {
                this$0.C4((f0.g(waspwing.getDeviceCode(), t9.c.f50958g) || f0.g(waspwing.getDeviceCode(), t9.c.f50957f)) ? 2 : 1, this$0.I7);
                this$0.setResult(-1, new Intent().putExtra("key_result_data", this$0.H7).putExtra(K7, this$0.I7));
            }
        }
    }

    public static final void v4(DialogFragment dialogFragment) {
        dialogFragment.I5();
    }

    public static final void w4(WaspWingInfo waspwing, DialogFragment dialogFragment) {
        f0.p(waspwing, "$waspwing");
        dialogFragment.I5();
        h3.a.j().d(a.d.f31953i).withString("key_device_code", waspwing.getDeviceCode()).withString("key_device_address", waspwing.getAddress()).withBoolean(DataConstant.DEVICE_KEY_FIRMWARE_FORCE_LATEST, !f.i().p()).navigation();
    }

    public static final void x4(RunModeSelectionActivity this$0, View view) {
        f0.p(this$0, "this$0");
        this$0.C4(3, this$0.I7);
        this$0.setResult(-1, new Intent().putExtra("key_result_data", this$0.H7).putExtra(K7, -1));
    }

    public static final void y4(RunModeSelectionActivity this$0, View view) {
        f0.p(this$0, "this$0");
        this$0.C4(this$0.H7, 0);
        this$0.setResult(-1, new Intent().putExtra("key_result_data", this$0.H7).putExtra(K7, this$0.I7));
    }

    public static final void z4(RunModeSelectionActivity this$0, View view) {
        f0.p(this$0, "this$0");
        this$0.C4(this$0.H7, 1);
        this$0.setResult(-1, new Intent().putExtra("key_result_data", this$0.H7).putExtra(K7, this$0.I7));
    }

    @Override // com.flydigi.sdk.bluetooth.w
    public void A(@k BluetoothDevice bluetoothDevice) {
        i.a.b(this, bluetoothDevice);
    }

    public final void C4(int i10, int i11) {
        if (i10 == this.I7) {
            this.I7 = this.H7;
            this.H7 = i10;
        } else {
            this.H7 = i10;
            this.I7 = i11;
        }
        j jVar = this.E7;
        j jVar2 = null;
        if (jVar == null) {
            f0.S("binding");
            jVar = null;
        }
        ImageView imageView = jVar.f10127n;
        f0.o(imageView, "binding.btnActionSmart");
        o5.c.a(imageView, Boolean.valueOf(this.H7 == 0), false);
        j jVar3 = this.E7;
        if (jVar3 == null) {
            f0.S("binding");
            jVar3 = null;
        }
        ImageView imageView2 = jVar3.f10126m;
        f0.o(imageView2, "binding.btnActionManual");
        int i12 = this.H7;
        o5.c.a(imageView2, Boolean.valueOf(i12 == 1 || i12 == 2), false);
        j jVar4 = this.E7;
        if (jVar4 == null) {
            f0.S("binding");
            jVar4 = null;
        }
        ImageView imageView3 = jVar4.f10125l;
        f0.o(imageView3, "binding.btnActionExperimentalSmart");
        o5.c.a(imageView3, Boolean.valueOf(this.H7 == 3), false);
        j jVar5 = this.E7;
        if (jVar5 == null) {
            f0.S("binding");
            jVar5 = null;
        }
        ImageView imageView4 = jVar5.f10124k;
        f0.o(imageView4, "binding.btnActionAreaQuickSwitchSmart");
        o5.c.a(imageView4, Boolean.valueOf(this.I7 == 0), false);
        j jVar6 = this.E7;
        if (jVar6 == null) {
            f0.S("binding");
            jVar6 = null;
        }
        ImageView imageView5 = jVar6.f10123j;
        f0.o(imageView5, "binding.btnActionAreaQuickSwitchManual");
        int i13 = this.I7;
        o5.c.a(imageView5, Boolean.valueOf(i13 == 1 || i13 == 2), false);
        j jVar7 = this.E7;
        if (jVar7 == null) {
            f0.S("binding");
            jVar7 = null;
        }
        ImageView imageView6 = jVar7.f10122i;
        f0.o(imageView6, "binding.btnActionAreaQuickSwitchExperimentSmart");
        o5.c.a(imageView6, Boolean.valueOf(this.I7 == 3), false);
        j jVar8 = this.E7;
        if (jVar8 == null) {
            f0.S("binding");
            jVar8 = null;
        }
        jVar8.f10120g.setEnabled(this.H7 != 0);
        j jVar9 = this.E7;
        if (jVar9 == null) {
            f0.S("binding");
            jVar9 = null;
        }
        LinearLayout linearLayout = jVar9.f10120g;
        f0.o(linearLayout, "binding.areaQuickSwitchSmart");
        Iterator<View> it2 = ViewGroupKt.e(linearLayout).iterator();
        while (it2.hasNext()) {
            it2.next().setEnabled(this.H7 != 0);
        }
        j jVar10 = this.E7;
        if (jVar10 == null) {
            f0.S("binding");
            jVar10 = null;
        }
        LinearLayout linearLayout2 = jVar10.f10119f;
        int i14 = this.H7;
        linearLayout2.setEnabled((i14 == 1 || i14 == 2) ? false : true);
        j jVar11 = this.E7;
        if (jVar11 == null) {
            f0.S("binding");
            jVar11 = null;
        }
        LinearLayout linearLayout3 = jVar11.f10119f;
        f0.o(linearLayout3, "binding.areaQuickSwitchManual");
        for (View view : ViewGroupKt.e(linearLayout3)) {
            int i15 = this.H7;
            view.setEnabled((i15 == 1 || i15 == 2) ? false : true);
        }
        j jVar12 = this.E7;
        if (jVar12 == null) {
            f0.S("binding");
            jVar12 = null;
        }
        jVar12.f10118e.setEnabled(this.H7 != 3);
        j jVar13 = this.E7;
        if (jVar13 == null) {
            f0.S("binding");
        } else {
            jVar2 = jVar13;
        }
        LinearLayout linearLayout4 = jVar2.f10118e;
        f0.o(linearLayout4, "binding.areaQuickSwitchExperimentSmart");
        Iterator<View> it3 = ViewGroupKt.e(linearLayout4).iterator();
        while (it3.hasNext()) {
            it3.next().setEnabled(this.H7 != 3);
        }
    }

    @Override // t9.i
    public void F1(@k WaspWingInfo waspWingInfo) {
        f0.p(waspWingInfo, "waspWingInfo");
        if (this.F7 == waspWingInfo.getRunMode() && this.G7 == waspWingInfo.getQuickSwitchRunMode()) {
            return;
        }
        this.F7 = waspWingInfo.getRunMode();
        this.G7 = waspWingInfo.getQuickSwitchRunMode();
        runOnUiThread(new Runnable() { // from class: i7.m
            @Override // java.lang.Runnable
            public final void run() {
                RunModeSelectionActivity.B4(this.f31890a);
            }
        });
    }

    @Override // com.flydigi.sdk.bluetooth.w
    public void O2(@k BluetoothGatt bluetoothGatt) {
        i.a.e(this, bluetoothGatt);
    }

    @Override // com.flydigi.sdk.bluetooth.w
    public void V0(@k BluetoothDevice bluetoothDevice) {
        i.a.d(this, bluetoothDevice);
    }

    @Override // com.flydigi.sdk.bluetooth.w
    public void e2(@k BluetoothDevice bluetoothDevice) {
        i.a.c(this, bluetoothDevice);
    }

    @Override // com.flydigi.base.common.p
    public int f4() {
        return R.layout.device_activity_waspwing_run_mode;
    }

    @Override // com.flydigi.sdk.bluetooth.w
    public void g2(@k BluetoothDevice bluetoothDevice) {
        i.a.a(this, bluetoothDevice);
    }

    @Override // com.flydigi.sdk.bluetooth.w
    public void k1(int i10) {
        i.a.f(this, i10);
    }

    @Override // com.flydigi.base.common.p, com.flydigi.base.common.c, ch.a, androidx.fragment.app.g, androidx.activity.ComponentActivity, f0.l, android.app.Activity
    public void onCreate(@l Bundle bundle) {
        super.onCreate(bundle);
        e4();
        this.C1.setText(R.string.device_waspwing_run_mode_choose);
        WaspWingInfo waspWingInfo = (WaspWingInfo) getIntent().getParcelableExtra("key_device_info");
        this.K2 = waspWingInfo;
        if (waspWingInfo == null) {
            finish();
        }
        final WaspWingInfo waspWingInfo2 = this.K2;
        if (waspWingInfo2 != null) {
            this.F7 = waspWingInfo2.getRunMode();
            this.G7 = waspWingInfo2.getQuickSwitchRunMode();
            C4(waspWingInfo2.getRunMode(), waspWingInfo2.getQuickSwitchRunMode());
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(getString(R.string.device_waspwing_run_mode_quick_switch));
            boolean z10 = true;
            spannableStringBuilder.setSpan(new SuperscriptSpan(), spannableStringBuilder.length() - 1, spannableStringBuilder.length(), 33);
            j jVar = this.E7;
            j jVar2 = null;
            if (jVar == null) {
                f0.S("binding");
                jVar = null;
            }
            jVar.f10128o.setText(spannableStringBuilder);
            j jVar3 = this.E7;
            if (jVar3 == null) {
                f0.S("binding");
                jVar3 = null;
            }
            TextView textView = jVar3.f10129p;
            f0.o(textView, "binding.tvLabelQuickSwitchDesc");
            o5.c.b(textView, Boolean.valueOf(f0.g(waspWingInfo2.getDeviceCode(), t9.c.f50960i) || f0.g(waspWingInfo2.getDeviceCode(), t9.c.f50959h)), false, 2, null);
            j jVar4 = this.E7;
            if (jVar4 == null) {
                f0.S("binding");
                jVar4 = null;
            }
            ConstraintLayout constraintLayout = jVar4.f10115b;
            f0.o(constraintLayout, "binding.areaExperimentalSmart");
            o5.c.b(constraintLayout, Boolean.valueOf(f0.g(waspWingInfo2.getDeviceCode(), t9.c.f50960i) || f0.g(waspWingInfo2.getDeviceCode(), t9.c.f50959h)), false, 2, null);
            j jVar5 = this.E7;
            if (jVar5 == null) {
                f0.S("binding");
                jVar5 = null;
            }
            LinearLayout linearLayout = jVar5.f10117d;
            f0.o(linearLayout, "binding.areaQuickSwitch");
            if ((waspWingInfo2.getQuickSwitchRunMode() == -1 || !f0.g(waspWingInfo2.getDeviceCode(), t9.c.f50960i)) && !f0.g(waspWingInfo2.getDeviceCode(), t9.c.f50959h)) {
                z10 = false;
            }
            o5.c.b(linearLayout, Boolean.valueOf(z10), false, 2, null);
            j jVar6 = this.E7;
            if (jVar6 == null) {
                f0.S("binding");
                jVar6 = null;
            }
            o.r(jVar6.f10121h, new View.OnClickListener() { // from class: i7.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RunModeSelectionActivity.t4(this.f31882a, view);
                }
            });
            j jVar7 = this.E7;
            if (jVar7 == null) {
                f0.S("binding");
                jVar7 = null;
            }
            o.r(jVar7.f10116c, new View.OnClickListener() { // from class: i7.j
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RunModeSelectionActivity.u4(waspWingInfo2, this, view);
                }
            });
            j jVar8 = this.E7;
            if (jVar8 == null) {
                f0.S("binding");
                jVar8 = null;
            }
            o.r(jVar8.f10115b, new View.OnClickListener() { // from class: i7.h
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RunModeSelectionActivity.x4(this.f31884a, view);
                }
            });
            j jVar9 = this.E7;
            if (jVar9 == null) {
                f0.S("binding");
                jVar9 = null;
            }
            o.r(jVar9.f10120g, new View.OnClickListener() { // from class: i7.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RunModeSelectionActivity.y4(this.f31881a, view);
                }
            });
            j jVar10 = this.E7;
            if (jVar10 == null) {
                f0.S("binding");
                jVar10 = null;
            }
            o.r(jVar10.f10119f, new View.OnClickListener() { // from class: i7.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RunModeSelectionActivity.z4(this.f31883a, view);
                }
            });
            j jVar11 = this.E7;
            if (jVar11 == null) {
                f0.S("binding");
            } else {
                jVar2 = jVar11;
            }
            o.r(jVar2.f10118e, new View.OnClickListener() { // from class: i7.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RunModeSelectionActivity.A4(this.f31885a, view);
                }
            });
        }
        t9.j.D(this);
    }

    @Override // com.flydigi.base.common.p, com.flydigi.base.common.c, ch.a, androidx.appcompat.app.f, androidx.fragment.app.g, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        t9.j.e0(this);
    }

    @Override // t9.i
    public void q2(@k byte[] bArr) {
        i.a.g(this, bArr);
    }

    @Override // androidx.appcompat.app.f, androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(int i10) {
        j jVarC = j.c(getLayoutInflater());
        f0.o(jVarC, "inflate(layoutInflater)");
        this.E7 = jVarC;
        if (jVarC == null) {
            f0.S("binding");
            jVarC = null;
        }
        setContentView(jVarC.getRoot());
    }
}
