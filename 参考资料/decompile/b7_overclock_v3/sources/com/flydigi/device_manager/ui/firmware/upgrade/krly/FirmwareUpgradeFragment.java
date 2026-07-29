package com.flydigi.device_manager.ui.firmware.upgrade.krly;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.ArrayMap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;
import c7.p0;
import com.blankj.utilcode.util.ThreadUtils;
import com.blankj.utilcode.util.a0;
import com.blankj.utilcode.util.b0;
import com.blankj.utilcode.util.n0;
import com.blankj.utilcode.util.p1;
import com.flydigi.base.common.FZFragment;
import com.flydigi.base.widget.FZDialog;
import com.flydigi.device_manager.R;
import com.flydigi.sdk.bluetooth.data.BleDevice;
import com.flydigi.sdk.bluetooth.e0;
import com.flydigi.sdk.bluetooth.ota.OtaStatus;
import com.flydigi.sdk.bluetooth.v;
import com.flydigi.sdk.gamepad.GamepadInfo;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.jvm.internal.u;
import kotlin.z1;
import m9.r;
import m9.s;
import rx_activity_result2.RxActivityResult;
import xi.z;

/* JADX INFO: loaded from: classes7.dex */
@t0({"SMAP\nFirmwareUpgradeFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FirmwareUpgradeFragment.kt\ncom/flydigi/device_manager/ui/firmware/upgrade/krly/FirmwareUpgradeFragment\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,376:1\n288#2,2:377\n*S KotlinDebug\n*F\n+ 1 FirmwareUpgradeFragment.kt\ncom/flydigi/device_manager/ui/firmware/upgrade/krly/FirmwareUpgradeFragment\n*L\n187#1:377,2\n*E\n"})
public final class FirmwareUpgradeFragment extends FZFragment implements e0, r, k9.b {

    /* JADX INFO: renamed from: v8, reason: collision with root package name */
    @yt.k
    public static final a f15063v8 = new a(null);

    /* JADX INFO: renamed from: w8, reason: collision with root package name */
    @yt.k
    public static final String f15064w8 = "key_firmware_file";

    /* JADX INFO: renamed from: x8, reason: collision with root package name */
    @yt.k
    public static final String f15065x8 = "key_address";

    /* JADX INFO: renamed from: y8, reason: collision with root package name */
    @yt.k
    public static final String f15066y8 = "key_device_code";

    /* JADX INFO: renamed from: o8, reason: collision with root package name */
    public p0 f15067o8;

    /* JADX INFO: renamed from: p8, reason: collision with root package name */
    public b f15068p8;

    /* JADX INFO: renamed from: q8, reason: collision with root package name */
    public String f15069q8;

    /* JADX INFO: renamed from: r8, reason: collision with root package name */
    @yt.l
    public String f15070r8;

    /* JADX INFO: renamed from: s8, reason: collision with root package name */
    @yt.l
    public String f15071s8;

    /* JADX INFO: renamed from: t8, reason: collision with root package name */
    public boolean f15072t8;

    /* JADX INFO: renamed from: u8, reason: collision with root package name */
    @yt.k
    public final Runnable f15073u8 = new Runnable() { // from class: com.flydigi.device_manager.ui.firmware.upgrade.krly.f
        @Override // java.lang.Runnable
        public final void run() {
            FirmwareUpgradeFragment.F6(this.f15082a);
        }
    };

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        public static /* synthetic */ FirmwareUpgradeFragment b(a aVar, String str, String str2, String str3, int i10, Object obj) {
            if ((i10 & 4) != 0) {
                str3 = null;
            }
            return aVar.a(str, str2, str3);
        }

        @hk.m
        @yt.k
        public final FirmwareUpgradeFragment a(@yt.k String file, @yt.k String deviceCode, @yt.l String str) {
            f0.p(file, "file");
            f0.p(deviceCode, "deviceCode");
            FirmwareUpgradeFragment firmwareUpgradeFragment = new FirmwareUpgradeFragment();
            firmwareUpgradeFragment.c5(androidx.core.os.e.b(new Pair("key_firmware_file", file), new Pair("key_device_code", deviceCode), new Pair("key_address", str)));
            return firmwareUpgradeFragment;
        }
    }

    public interface b {
        void a(boolean z10, @yt.k String str, int i10, @yt.l String str2);
    }

    public static final void A6(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void B6(DialogFragment dialogFragment) {
        dialogFragment.H5();
    }

    public static final void C6(final FirmwareUpgradeFragment this$0, DialogFragment dialogFragment) {
        f0.p(this$0, "this$0");
        f0.p(dialogFragment, "dialogFragment");
        dialogFragment.I5();
        Intent intent = new Intent();
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        Context contextX1 = this$0.X1();
        intent.setData(Uri.fromParts("package", contextX1 != null ? contextX1.getPackageName() : null, null));
        z zVarE = RxActivityResult.b(this$0).e(intent);
        final ik.l<rx_activity_result2.f<FirmwareUpgradeFragment>, z1> lVar = new ik.l<rx_activity_result2.f<FirmwareUpgradeFragment>, z1>() { // from class: com.flydigi.device_manager.ui.firmware.upgrade.krly.FirmwareUpgradeFragment$onScanFailed$1$dialog$3$1
            {
                super(1);
            }

            public final void b(rx_activity_result2.f<FirmwareUpgradeFragment> fVar) {
                this.this$0.I6();
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(rx_activity_result2.f<FirmwareUpgradeFragment> fVar) {
                b(fVar);
                return z1.f38230a;
            }
        };
        zVarE.E5(new dj.g() { // from class: com.flydigi.device_manager.ui.firmware.upgrade.krly.k
            @Override // dj.g
            public final void accept(Object obj) {
                FirmwareUpgradeFragment.D6(lVar, obj);
            }
        });
    }

    public static final void D6(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void E6(DialogFragment dialogFragment) {
        dialogFragment.H5();
    }

    public static final void F6(FirmwareUpgradeFragment this$0) {
        f0.p(this$0, "this$0");
        if (n0.m(this$0.f15070r8)) {
            s.e0();
            b bVar = this$0.f15068p8;
            if (bVar == null) {
                f0.S("listener");
                bVar = null;
            }
            String strC3 = this$0.c3(R.string.device_firmware_upgrade_failed_krly_not_found);
            f0.o(strC3, "getString(R.string.devic…de_failed_krly_not_found)");
            bVar.a(false, strC3, 2, this$0.f15071s8);
        }
    }

    public static final void H6(FirmwareUpgradeFragment this$0) {
        f0.p(this$0, "this$0");
        p0 p0Var = this$0.f15067o8;
        p0 p0Var2 = null;
        if (p0Var == null) {
            f0.S("viewBinding");
            p0Var = null;
        }
        int progress = p0Var.f10327c.getProgress() + 1;
        p0 p0Var3 = this$0.f15067o8;
        if (p0Var3 == null) {
            f0.S("viewBinding");
            p0Var3 = null;
        }
        p0Var3.f10327c.setProgress(progress);
        p0 p0Var4 = this$0.f15067o8;
        if (p0Var4 == null) {
            f0.S("viewBinding");
            p0Var4 = null;
        }
        TextView textView = p0Var4.f10329e;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(progress);
        sb2.append('%');
        textView.setText(sb2.toString());
        p0 p0Var5 = this$0.f15067o8;
        if (p0Var5 == null) {
            f0.S("viewBinding");
        } else {
            p0Var2 = p0Var5;
        }
        if (p0Var2.f10327c.getProgress() < 99) {
            this$0.G6();
        }
    }

    public static final File r6(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        return (File) tmp0.i(obj);
    }

    public static final void s6(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void t6(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    @hk.m
    @yt.k
    public static final FirmwareUpgradeFragment u6(@yt.k String str, @yt.k String str2, @yt.l String str3) {
        return f15063v8.a(str, str2, str3);
    }

    public static final void v6(FirmwareUpgradeFragment this$0) {
        f0.p(this$0, "this$0");
        String str = this$0.f15069q8;
        if (str == null) {
            f0.S("firmwareFilePath");
            str = null;
        }
        this$0.q6(str);
    }

    public static final void w6(FirmwareUpgradeFragment this$0, float f10) {
        f0.p(this$0, "this$0");
        if (this$0.s3()) {
            p0 p0Var = this$0.f15067o8;
            if (p0Var == null) {
                f0.S("viewBinding");
                p0Var = null;
            }
            p0Var.f10328d.setText(this$0.d3(R.string.device_firmware_upgrade_message, this$0.c3(R.string.device_firmware_upgrade_message_uploading), this$0.c3(a5.b.f(this$0.f15071s8))));
            float f11 = f10 * 100;
            p0 p0Var2 = this$0.f15067o8;
            if (p0Var2 == null) {
                f0.S("viewBinding");
                p0Var2 = null;
            }
            if (f11 >= p0Var2.f10327c.getProgress()) {
                p0 p0Var3 = this$0.f15067o8;
                if (p0Var3 == null) {
                    f0.S("viewBinding");
                    p0Var3 = null;
                }
                p0Var3.f10327c.setProgress((int) f11);
                p0 p0Var4 = this$0.f15067o8;
                if (p0Var4 == null) {
                    f0.S("viewBinding");
                    p0Var4 = null;
                }
                TextView textView = p0Var4.f10329e;
                StringBuilder sb2 = new StringBuilder();
                p0 p0Var5 = this$0.f15067o8;
                if (p0Var5 == null) {
                    f0.S("viewBinding");
                    p0Var5 = null;
                }
                sb2.append(p0Var5.f10327c.getProgress());
                sb2.append('%');
                textView.setText(sb2.toString());
                this$0.H5().h(null);
            }
        }
    }

    public static final void x6(FirmwareUpgradeFragment this$0) {
        f0.p(this$0, "this$0");
        b bVar = this$0.f15068p8;
        if (bVar == null) {
            f0.S("listener");
            bVar = null;
        }
        bVar.a(true, "Success", 2, this$0.f15071s8);
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("upgradeType", this$0.f15072t8 ? "Dfu升级" : "一键升级");
        u9.h.d(this$0.X1(), "Module_Upgrade_Success", "外设管理_固件升级_升级成功", arrayMap);
    }

    public static final void y6(int i10, final FirmwareUpgradeFragment this$0) {
        f0.p(this$0, "this$0");
        if (i10 == 8) {
            o5.a.t0(this$0.L2(), new FZDialog.a().t(this$0.c3(R.string.device_msg_location_permission_on_10_title)).j(this$0.c3(R.string.device_msg_location_permission_on_10)).d(this$0.c3(R.string.cancel)).g(this$0.c3(R.string.device_setting_now)).b(Boolean.FALSE).f(new FZDialog.c() { // from class: com.flydigi.device_manager.ui.firmware.upgrade.krly.h
                @Override // com.flydigi.base.widget.FZDialog.c
                public final void a(DialogFragment dialogFragment) {
                    FirmwareUpgradeFragment.z6(this.f15085a, dialogFragment);
                }
            }).c(new FZDialog.c() { // from class: com.flydigi.device_manager.ui.firmware.upgrade.krly.j
                @Override // com.flydigi.base.widget.FZDialog.c
                public final void a(DialogFragment dialogFragment) {
                    FirmwareUpgradeFragment.B6(dialogFragment);
                }
            }).a());
        } else {
            if (i10 != 9) {
                return;
            }
            o5.a.t0(this$0.L2(), new FZDialog.a().t(this$0.c3(R.string.device_need_find_location_permission)).j(this$0.c3(R.string.device_need_find_location_permission_msg)).d(this$0.c3(R.string.cancel)).g(this$0.c3(R.string.device_setting_now)).b(Boolean.FALSE).f(new FZDialog.c() { // from class: com.flydigi.device_manager.ui.firmware.upgrade.krly.a
                @Override // com.flydigi.base.widget.FZDialog.c
                public final void a(DialogFragment dialogFragment) {
                    FirmwareUpgradeFragment.C6(this.f15077a, dialogFragment);
                }
            }).c(new FZDialog.c() { // from class: com.flydigi.device_manager.ui.firmware.upgrade.krly.i
                @Override // com.flydigi.base.widget.FZDialog.c
                public final void a(DialogFragment dialogFragment) {
                    FirmwareUpgradeFragment.E6(dialogFragment);
                }
            }).a());
        }
    }

    public static final void z6(final FirmwareUpgradeFragment this$0, DialogFragment dialogFragment) {
        f0.p(this$0, "this$0");
        f0.p(dialogFragment, "dialogFragment");
        dialogFragment.I5();
        Intent intent = new Intent();
        intent.setAction("android.settings.LOCATION_SOURCE_SETTINGS");
        z zVarE = RxActivityResult.b(this$0).e(intent);
        final ik.l<rx_activity_result2.f<FirmwareUpgradeFragment>, z1> lVar = new ik.l<rx_activity_result2.f<FirmwareUpgradeFragment>, z1>() { // from class: com.flydigi.device_manager.ui.firmware.upgrade.krly.FirmwareUpgradeFragment$onScanFailed$1$dialog$1$1
            {
                super(1);
            }

            public final void b(rx_activity_result2.f<FirmwareUpgradeFragment> fVar) {
                this.this$0.I6();
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(rx_activity_result2.f<FirmwareUpgradeFragment> fVar) {
                b(fVar);
                return z1.f38230a;
            }
        };
        zVarE.E5(new dj.g() { // from class: com.flydigi.device_manager.ui.firmware.upgrade.krly.n
            @Override // dj.g
            public final void accept(Object obj) {
                FirmwareUpgradeFragment.A6(lVar, obj);
            }
        });
    }

    @Override // com.flydigi.sdk.bluetooth.w
    public void A(@yt.k BluetoothDevice bluetoothDevice) {
        r.a.f(this, bluetoothDevice);
    }

    @Override // m9.r
    public void B0(boolean z10, @yt.k Pair<Float, Float> pair) {
        r.a.k(this, z10, pair);
    }

    @Override // m9.r
    public void B1(@yt.k byte[] bArr, @yt.k byte[] bArr2) {
        r.a.t(this, bArr, bArr2);
    }

    @Override // k9.b
    public void C() {
        ThreadUtils.s0(new Runnable() { // from class: com.flydigi.device_manager.ui.firmware.upgrade.krly.e
            @Override // java.lang.Runnable
            public final void run() {
                FirmwareUpgradeFragment.x6(this.f15081a);
            }
        });
    }

    @SuppressLint({"SetTextI18n"})
    public final void G6() {
        H5().f(new Runnable() { // from class: com.flydigi.device_manager.ui.firmware.upgrade.krly.d
            @Override // java.lang.Runnable
            public final void run() {
                FirmwareUpgradeFragment.H6(this.f15080a);
            }
        }, 1000L);
    }

    @Override // m9.r
    public void H(@yt.k byte[] bArr) {
        r.a.a(this, bArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.flydigi.base.common.BaseFragment, androidx.fragment.app.Fragment
    public void H3(@yt.k Context context) {
        f0.p(context, "context");
        super.H3(context);
        if (context instanceof b) {
            this.f15068p8 = (b) context;
        }
    }

    @Override // m9.r
    public void I2(@yt.k GamepadInfo gamepadInfo) {
        r.a.c(this, gamepadInfo);
    }

    @Override // com.flydigi.base.common.BaseFragment
    public boolean I5() {
        return true;
    }

    public final void I6() {
        s.c0(this, 2);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0057  */
    @Override // com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void K3(@yt.l android.os.Bundle r3) {
        /*
            r2 = this;
            super.K3(r3)
            android.os.Bundle r3 = r2.T1()
            r0 = 0
            if (r3 == 0) goto L11
            java.lang.String r1 = "key_firmware_file"
            java.lang.String r3 = r3.getString(r1)
            goto L12
        L11:
            r3 = r0
        L12:
            if (r3 != 0) goto L16
            java.lang.String r3 = ""
        L16:
            r2.f15069q8 = r3
            android.os.Bundle r3 = r2.T1()
            if (r3 == 0) goto L25
            java.lang.String r1 = "key_address"
            java.lang.String r3 = r3.getString(r1)
            goto L26
        L25:
            r3 = r0
        L26:
            r2.f15070r8 = r3
            android.os.Bundle r3 = r2.T1()
            if (r3 == 0) goto L35
            java.lang.String r1 = "key_device_code"
            java.lang.String r3 = r3.getString(r1)
            goto L36
        L35:
            r3 = r0
        L36:
            r2.f15071s8 = r3
            java.lang.String r3 = r2.f15069q8
            java.lang.String r1 = "firmwareFilePath"
            if (r3 != 0) goto L42
            kotlin.jvm.internal.f0.S(r1)
            r3 = r0
        L42:
            boolean r3 = com.blankj.utilcode.util.n0.m(r3)
            if (r3 != 0) goto L57
            java.lang.String r3 = r2.f15069q8
            if (r3 != 0) goto L50
            kotlin.jvm.internal.f0.S(r1)
            goto L51
        L50:
            r0 = r3
        L51:
            boolean r3 = com.blankj.utilcode.util.b0.h0(r0)
            if (r3 != 0) goto L60
        L57:
            androidx.fragment.app.g r3 = r2.w1()
            if (r3 == 0) goto L60
            r3.finishAffinity()
        L60:
            m9.s.A(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.flydigi.device_manager.ui.firmware.upgrade.krly.FirmwareUpgradeFragment.K3(android.os.Bundle):void");
    }

    @Override // com.flydigi.base.common.FZFragment
    public int L5() {
        return R.layout.device_fragment_firmware_upgrade;
    }

    @Override // m9.r
    public void M0(boolean z10, @yt.k Pair<Float, Float> pair) {
        r.a.m(this, z10, pair);
    }

    @Override // com.flydigi.sdk.bluetooth.w
    public void O2(@yt.k BluetoothGatt gatt) {
        f0.p(gatt, "gatt");
        r.a.j(this, gatt);
        G5().post(new c(this));
    }

    @Override // com.flydigi.base.common.FZFragment, com.flydigi.base.common.BaseFragment, androidx.fragment.app.Fragment
    @yt.k
    public View O3(@yt.k LayoutInflater inflater, @yt.l ViewGroup viewGroup, @yt.l Bundle bundle) {
        f0.p(inflater, "inflater");
        p0 p0VarD = p0.d(inflater, viewGroup, false);
        f0.o(p0VarD, "inflate(inflater, container, false)");
        this.f15067o8 = p0VarD;
        if (p0VarD == null) {
            f0.S("viewBinding");
            p0VarD = null;
        }
        ConstraintLayout constraintLayoutB = p0VarD.getRoot();
        f0.o(constraintLayoutB, "viewBinding.root");
        return constraintLayoutB;
    }

    @Override // com.flydigi.base.common.FZFragment, com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void P3() {
        super.P3();
        s.i0(this);
    }

    @Override // m9.r
    public void R2(@yt.l Pair<Integer, Integer> pair) {
        r.a.p(this, pair);
    }

    @Override // k9.b
    public void S0(@yt.k OtaStatus code, @yt.l Integer num) {
        f0.p(code, "code");
        b bVar = this.f15068p8;
        if (bVar == null) {
            f0.S("listener");
            bVar = null;
        }
        bVar.a(false, "failed", 2, this.f15071s8);
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("upgradeType", this.f15072t8 ? "Dfu升级" : "一键升级");
        arrayMap.put("message", "");
        u9.g.a().e(X1(), "Module_Upgrade_Fail", arrayMap);
        com.flydigi.userBehavior.a.a().b(X1(), "固件升级失败");
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
    public void V0(@yt.k BluetoothDevice bluetoothDevice) {
        r.a.i(this, bluetoothDevice);
    }

    @Override // m9.r
    public void Z1(boolean z10, @yt.k Pair<Float, Float> pair) {
        r.a.l(this, z10, pair);
    }

    @Override // m9.r
    public void a2(@yt.k byte[] bArr) {
        r.a.s(this, bArr);
    }

    @Override // k9.b
    public void b1(final float f10) {
        ThreadUtils.s0(new Runnable() { // from class: com.flydigi.device_manager.ui.firmware.upgrade.krly.g
            @Override // java.lang.Runnable
            public final void run() {
                FirmwareUpgradeFragment.w6(this.f15083a, f10);
            }
        });
    }

    @Override // com.flydigi.sdk.bluetooth.w
    public void e2(@yt.k BluetoothDevice device) {
        f0.p(device, "device");
        r.a.g(this, device);
        G5().postDelayed(new Runnable() { // from class: com.flydigi.device_manager.ui.firmware.upgrade.krly.b
            @Override // java.lang.Runnable
            public final void run() {
                FirmwareUpgradeFragment.v6(this.f15078a);
            }
        }, 2000L);
    }

    @Override // k9.b
    public void g0() {
    }

    @Override // com.flydigi.sdk.bluetooth.w
    public void g2(@yt.k BluetoothDevice bluetoothDevice) {
        r.a.e(this, bluetoothDevice);
    }

    @Override // com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void i4() {
        super.i4();
        s.e0();
        H5().h(null);
        G5().removeCallbacksAndMessages(null);
    }

    @Override // com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void j4(@yt.k View view, @yt.l Bundle bundle) {
        f0.p(view, "view");
        super.j4(view, bundle);
        com.bumptech.glide.h hVarC0 = com.bumptech.glide.b.F(view).p(Integer.valueOf(R.drawable.device_firmware_upgrade_progress)).C0(Integer.MIN_VALUE);
        p0 p0Var = this.f15067o8;
        p0 p0Var2 = null;
        if (p0Var == null) {
            f0.S("viewBinding");
            p0Var = null;
        }
        hVarC0.s1(p0Var.f10326b);
        String strC3 = c3(a5.b.f(this.f15071s8));
        f0.o(strC3, "getString(DeviceManager.…ByDeviceCode(deviceCode))");
        p0 p0Var3 = this.f15067o8;
        if (p0Var3 == null) {
            f0.S("viewBinding");
        } else {
            p0Var2 = p0Var3;
        }
        p0Var2.f10328d.setText(d3(R.string.device_firmware_upgrade_message, d3(R.string.device_firmware_upgrade_message_connecting, strC3), strC3));
        G5().post(new c(this));
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
    public void n0(@yt.k List<Integer> list) {
        r.a.n(this, list);
    }

    @Override // com.flydigi.sdk.bluetooth.e0
    public void q1(@yt.k List<BleDevice> devices) {
        Object next;
        f0.p(devices, "devices");
        e0.a.a(this, devices);
        Iterator<T> it2 = devices.iterator();
        while (true) {
            if (!it2.hasNext()) {
                next = null;
                break;
            }
            next = it2.next();
            BleDevice bleDevice = (BleDevice) next;
            String name = bleDevice.F().getName();
            f0.o(name, "it.device.name");
            boolean z10 = true;
            if (!kotlin.text.u.t2(name, v.f16330f, true)) {
                String name2 = bleDevice.F().getName();
                f0.o(name2, "it.device.name");
                if (!kotlin.text.u.t2(name2, v.f16329e, true)) {
                    z10 = false;
                }
            }
            if (z10) {
                break;
            }
        }
        BleDevice bleDevice2 = (BleDevice) next;
        if (bleDevice2 != null) {
            this.f15072t8 = false;
            s.e0();
            this.f15070r8 = bleDevice2.F().getAddress();
            s.d(bleDevice2.F());
        }
    }

    public final void q6(String str) {
        try {
            String strG = b0.G(str);
            if (f0.g(strG, "bin")) {
                s.f40882a.a(2, a0.d(str));
            } else if (f0.g(strG, "zip")) {
                z zVarM3 = z.m3(str);
                final FirmwareUpgradeFragment$doUpgrade$1 firmwareUpgradeFragment$doUpgrade$1 = new ik.l<String, File>() { // from class: com.flydigi.device_manager.ui.firmware.upgrade.krly.FirmwareUpgradeFragment$doUpgrade$1
                    @Override // ik.l
                    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                    public final File i(@yt.k String it2) throws IOException {
                        f0.p(it2, "it");
                        List<File> listG = p1.g(it2, b0.A(it2));
                        f0.o(listG, "unzipFile(it, FileUtils.getDirName(it))");
                        for (File file : listG) {
                            if (b0.F(file).equals("bin")) {
                                return file;
                            }
                        }
                        throw new IOException();
                    }
                };
                z zVarB4 = zVarM3.A3(new dj.o() { // from class: com.flydigi.device_manager.ui.firmware.upgrade.krly.o
                    @Override // dj.o
                    public final Object apply(Object obj) {
                        return FirmwareUpgradeFragment.r6(firmwareUpgradeFragment$doUpgrade$1, obj);
                    }
                }).J5(lj.b.d()).b4(lj.b.d());
                final FirmwareUpgradeFragment$doUpgrade$2 firmwareUpgradeFragment$doUpgrade$2 = new ik.l<File, z1>() { // from class: com.flydigi.device_manager.ui.firmware.upgrade.krly.FirmwareUpgradeFragment$doUpgrade$2
                    public final void b(File file) {
                        s.f40882a.a(2, a0.c(file));
                    }

                    @Override // ik.l
                    public /* bridge */ /* synthetic */ z1 i(File file) {
                        b(file);
                        return z1.f38230a;
                    }
                };
                dj.g gVar = new dj.g() { // from class: com.flydigi.device_manager.ui.firmware.upgrade.krly.l
                    @Override // dj.g
                    public final void accept(Object obj) {
                        FirmwareUpgradeFragment.s6(firmwareUpgradeFragment$doUpgrade$2, obj);
                    }
                };
                final FirmwareUpgradeFragment$doUpgrade$3 firmwareUpgradeFragment$doUpgrade$3 = new ik.l<Throwable, z1>() { // from class: com.flydigi.device_manager.ui.firmware.upgrade.krly.FirmwareUpgradeFragment$doUpgrade$3
                    public final void b(Throwable th2) {
                    }

                    @Override // ik.l
                    public /* bridge */ /* synthetic */ z1 i(Throwable th2) {
                        b(th2);
                        return z1.f38230a;
                    }
                };
                zVarB4.F5(gVar, new dj.g() { // from class: com.flydigi.device_manager.ui.firmware.upgrade.krly.m
                    @Override // dj.g
                    public final void accept(Object obj) {
                        FirmwareUpgradeFragment.t6(firmwareUpgradeFragment$doUpgrade$3, obj);
                    }
                });
            }
            u9.h.c(X1(), "Module_Upgrade_Preparing", "外设管理_固件升级_准备升级");
        } catch (Exception unused) {
            b bVar = this.f15068p8;
            if (bVar == null) {
                f0.S("listener");
                bVar = null;
            }
            bVar.a(false, "Unknown Device", 2, this.f15071s8);
        }
    }

    @Override // k9.b
    public void r0() {
    }

    @Override // com.flydigi.sdk.bluetooth.e0
    public void s2() {
        e0.a.d(this);
    }

    @Override // com.flydigi.sdk.bluetooth.e0
    public void t0() {
        e0.a.c(this);
        G5().postDelayed(this.f15073u8, 10000L);
    }

    @Override // m9.r
    public void u0(@yt.l BluetoothDevice bluetoothDevice, @yt.k GamepadInfo gamepadInfo) {
        r.a.h(this, bluetoothDevice, gamepadInfo);
    }

    @Override // com.flydigi.sdk.bluetooth.e0
    public void x0(final int i10) {
        e0.a.b(this, i10);
        G5().removeCallbacks(this.f15073u8);
        H5().e(new Runnable() { // from class: com.flydigi.device_manager.ui.firmware.upgrade.krly.p
            @Override // java.lang.Runnable
            public final void run() {
                FirmwareUpgradeFragment.y6(i10, this);
            }
        });
    }

    @Override // m9.r
    public void z0(int i10, int i11) {
        r.a.o(this, i10, i11);
    }
}
