package com.flydigi.device_manager.ui.firmware.upgrade;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.ArrayMap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;
import c7.p0;
import com.blankj.utilcode.util.n0;
import com.flydigi.base.common.FZFragment;
import com.flydigi.base.widget.FZDialog;
import com.flydigi.device_manager.R;
import com.flydigi.device_manager.ui.firmware.DfuService;
import com.flydigi.sdk.bluetooth.data.BleDevice;
import com.flydigi.sdk.bluetooth.e0;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.jvm.internal.u;
import kotlin.z1;
import m9.s;
import m9.t;
import no.nordicsemi.android.dfu.DfuProgressListenerAdapter;
import no.nordicsemi.android.dfu.DfuServiceInitiator;
import no.nordicsemi.android.dfu.DfuServiceListenerHelper;
import rx_activity_result2.RxActivityResult;
import xi.z;

/* JADX INFO: loaded from: classes7.dex */
@t0({"SMAP\nFirmwareUpgradeFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FirmwareUpgradeFragment.kt\ncom/flydigi/device_manager/ui/firmware/upgrade/FirmwareUpgradeFragment\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,422:1\n766#2:423\n857#2,2:424\n*S KotlinDebug\n*F\n+ 1 FirmwareUpgradeFragment.kt\ncom/flydigi/device_manager/ui/firmware/upgrade/FirmwareUpgradeFragment\n*L\n305#1:423\n305#1:424,2\n*E\n"})
public final class FirmwareUpgradeFragment extends FZFragment implements e0 {

    /* JADX INFO: renamed from: w8, reason: collision with root package name */
    @yt.k
    public static final a f15026w8 = new a(null);

    /* JADX INFO: renamed from: x8, reason: collision with root package name */
    @yt.k
    public static final String f15027x8 = "key_firmware_file";

    /* JADX INFO: renamed from: y8, reason: collision with root package name */
    @yt.k
    public static final String f15028y8 = "key_address";

    /* JADX INFO: renamed from: z8, reason: collision with root package name */
    @yt.k
    public static final String f15029z8 = "key_device_code";

    /* JADX INFO: renamed from: o8, reason: collision with root package name */
    public p0 f15030o8;

    /* JADX INFO: renamed from: p8, reason: collision with root package name */
    public b f15031p8;

    /* JADX INFO: renamed from: q8, reason: collision with root package name */
    public String f15032q8;

    /* JADX INFO: renamed from: r8, reason: collision with root package name */
    @yt.l
    public String f15033r8;

    /* JADX INFO: renamed from: s8, reason: collision with root package name */
    @yt.l
    public String f15034s8;

    /* JADX INFO: renamed from: t8, reason: collision with root package name */
    public boolean f15035t8;

    /* JADX INFO: renamed from: u8, reason: collision with root package name */
    @yt.k
    public final Runnable f15036u8 = new Runnable() { // from class: com.flydigi.device_manager.ui.firmware.upgrade.j
        @Override // java.lang.Runnable
        public final void run() {
            FirmwareUpgradeFragment.z6(this.f15061a);
        }
    };

    /* JADX INFO: renamed from: v8, reason: collision with root package name */
    @yt.k
    public final c f15037v8 = new c();

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

        void d();
    }

    public static final class c extends DfuProgressListenerAdapter {
        public c() {
        }

        @Override // no.nordicsemi.android.dfu.DfuProgressListenerAdapter, no.nordicsemi.android.dfu.DfuProgressListener
        public void onDeviceConnected(@yt.k String deviceAddress) {
            f0.p(deviceAddress, "deviceAddress");
            FirmwareUpgradeFragment.this.A6();
        }

        @Override // no.nordicsemi.android.dfu.DfuProgressListenerAdapter, no.nordicsemi.android.dfu.DfuProgressListener
        public void onDeviceDisconnected(@yt.k String deviceAddress) {
            f0.p(deviceAddress, "deviceAddress");
        }

        @Override // no.nordicsemi.android.dfu.DfuProgressListenerAdapter, no.nordicsemi.android.dfu.DfuProgressListener
        public void onDeviceDisconnecting(@yt.l String str) {
        }

        @Override // no.nordicsemi.android.dfu.DfuProgressListenerAdapter, no.nordicsemi.android.dfu.DfuProgressListener
        public void onDfuAborted(@yt.k String deviceAddress) {
            f0.p(deviceAddress, "deviceAddress");
            super.onDfuAborted(deviceAddress);
            b bVar = FirmwareUpgradeFragment.this.f15031p8;
            if (bVar == null) {
                f0.S("listener");
                bVar = null;
            }
            bVar.a(false, "Abort", 0, FirmwareUpgradeFragment.this.f15034s8);
            u9.h.c(FirmwareUpgradeFragment.this.X1(), "Module_Upgrade_Aborted", "外设管理_固件升级_升级取消");
        }

        @Override // no.nordicsemi.android.dfu.DfuProgressListenerAdapter, no.nordicsemi.android.dfu.DfuProgressListener
        public void onDfuCompleted(@yt.k String deviceAddress) {
            f0.p(deviceAddress, "deviceAddress");
            b bVar = FirmwareUpgradeFragment.this.f15031p8;
            if (bVar == null) {
                f0.S("listener");
                bVar = null;
            }
            bVar.a(true, "Success", 0, FirmwareUpgradeFragment.this.f15034s8);
            ArrayMap arrayMap = new ArrayMap();
            arrayMap.put("upgradeType", FirmwareUpgradeFragment.this.f15035t8 ? "Dfu升级" : "一键升级");
            u9.h.d(FirmwareUpgradeFragment.this.X1(), "Module_Upgrade_Success", "外设管理_固件升级_升级成功", arrayMap);
        }

        @Override // no.nordicsemi.android.dfu.DfuProgressListenerAdapter, no.nordicsemi.android.dfu.DfuProgressListener
        public void onDfuProcessStarted(@yt.k String deviceAddress) {
            f0.p(deviceAddress, "deviceAddress");
        }

        @Override // no.nordicsemi.android.dfu.DfuProgressListenerAdapter, no.nordicsemi.android.dfu.DfuProgressListener
        public void onDfuProcessStarting(@yt.k String deviceAddress) {
            f0.p(deviceAddress, "deviceAddress");
            p0 p0Var = FirmwareUpgradeFragment.this.f15030o8;
            if (p0Var == null) {
                f0.S("viewBinding");
                p0Var = null;
            }
            TextView textView = p0Var.f10328d;
            FirmwareUpgradeFragment firmwareUpgradeFragment = FirmwareUpgradeFragment.this;
            int i10 = R.string.device_firmware_upgrade_message;
            FirmwareUpgradeFragment firmwareUpgradeFragment2 = FirmwareUpgradeFragment.this;
            textView.setText(firmwareUpgradeFragment.d3(i10, firmwareUpgradeFragment.c3(R.string.device_firmware_upgrade_message_uploading), firmwareUpgradeFragment2.c3(a5.b.f(firmwareUpgradeFragment2.f15034s8))));
        }

        @Override // no.nordicsemi.android.dfu.DfuProgressListenerAdapter, no.nordicsemi.android.dfu.DfuProgressListener
        public void onError(@yt.k String deviceAddress, int i10, int i11, @yt.l String str) {
            f0.p(deviceAddress, "deviceAddress");
            b bVar = FirmwareUpgradeFragment.this.f15031p8;
            if (bVar == null) {
                f0.S("listener");
                bVar = null;
            }
            bVar.a(false, str == null ? "failed" : str, 0, FirmwareUpgradeFragment.this.f15034s8);
            ArrayMap arrayMap = new ArrayMap();
            arrayMap.put("upgradeType", FirmwareUpgradeFragment.this.f15035t8 ? "Dfu升级" : "一键升级");
            arrayMap.put("message", str);
            u9.g.a().e(FirmwareUpgradeFragment.this.X1(), "Module_Upgrade_Fail", arrayMap);
            com.flydigi.userBehavior.a.a().b(FirmwareUpgradeFragment.this.X1(), "固件升级失败_" + str);
        }

        @Override // no.nordicsemi.android.dfu.DfuProgressListenerAdapter, no.nordicsemi.android.dfu.DfuProgressListener
        @SuppressLint({"SetTextI18n"})
        public void onProgressChanged(@yt.k String deviceAddress, int i10, float f10, float f11, int i11, int i12) {
            f0.p(deviceAddress, "deviceAddress");
            p0 p0Var = FirmwareUpgradeFragment.this.f15030o8;
            p0 p0Var2 = null;
            if (p0Var == null) {
                f0.S("viewBinding");
                p0Var = null;
            }
            if (i10 >= p0Var.f10327c.getProgress()) {
                p0 p0Var3 = FirmwareUpgradeFragment.this.f15030o8;
                if (p0Var3 == null) {
                    f0.S("viewBinding");
                    p0Var3 = null;
                }
                p0Var3.f10327c.setProgress(i10);
                p0 p0Var4 = FirmwareUpgradeFragment.this.f15030o8;
                if (p0Var4 == null) {
                    f0.S("viewBinding");
                    p0Var4 = null;
                }
                TextView textView = p0Var4.f10329e;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(i10);
                sb2.append('%');
                textView.setText(sb2.toString());
                FirmwareUpgradeFragment.this.H5().h(null);
            }
            if (i10 >= 100) {
                FirmwareUpgradeFragment firmwareUpgradeFragment = FirmwareUpgradeFragment.this;
                String strC3 = firmwareUpgradeFragment.c3(a5.b.f(firmwareUpgradeFragment.f15034s8));
                f0.o(strC3, "getString(DeviceManager.…ByDeviceCode(deviceCode))");
                p0 p0Var5 = FirmwareUpgradeFragment.this.f15030o8;
                if (p0Var5 == null) {
                    f0.S("viewBinding");
                } else {
                    p0Var2 = p0Var5;
                }
                TextView textView2 = p0Var2.f10328d;
                FirmwareUpgradeFragment firmwareUpgradeFragment2 = FirmwareUpgradeFragment.this;
                textView2.setText(firmwareUpgradeFragment2.d3(R.string.device_firmware_upgrade_message, firmwareUpgradeFragment2.d3(R.string.device_firmware_upgrade_message_installing, strC3), strC3));
            }
        }
    }

    public static final void B6(FirmwareUpgradeFragment this$0) {
        f0.p(this$0, "this$0");
        p0 p0Var = this$0.f15030o8;
        p0 p0Var2 = null;
        if (p0Var == null) {
            f0.S("viewBinding");
            p0Var = null;
        }
        int progress = p0Var.f10327c.getProgress() + 1;
        p0 p0Var3 = this$0.f15030o8;
        if (p0Var3 == null) {
            f0.S("viewBinding");
            p0Var3 = null;
        }
        p0Var3.f10327c.setProgress(progress);
        p0 p0Var4 = this$0.f15030o8;
        if (p0Var4 == null) {
            f0.S("viewBinding");
            p0Var4 = null;
        }
        TextView textView = p0Var4.f10329e;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(progress);
        sb2.append('%');
        textView.setText(sb2.toString());
        p0 p0Var5 = this$0.f15030o8;
        if (p0Var5 == null) {
            f0.S("viewBinding");
        } else {
            p0Var2 = p0Var5;
        }
        if (p0Var2.f10327c.getProgress() < 99) {
            this$0.A6();
        }
    }

    @hk.m
    @yt.k
    public static final FirmwareUpgradeFragment r6(@yt.k String str, @yt.k String str2, @yt.l String str3) {
        return f15026w8.a(str, str2, str3);
    }

    public static final void s6(int i10, final FirmwareUpgradeFragment this$0) {
        f0.p(this$0, "this$0");
        if (i10 == 8) {
            o5.a.t0(this$0.L2(), new FZDialog.a().t(this$0.c3(R.string.device_msg_location_permission_on_10_title)).j(this$0.c3(R.string.device_msg_location_permission_on_10)).d(this$0.c3(R.string.cancel)).g(this$0.c3(R.string.device_setting_now)).b(Boolean.FALSE).f(new FZDialog.c() { // from class: com.flydigi.device_manager.ui.firmware.upgrade.b
                @Override // com.flydigi.base.widget.FZDialog.c
                public final void a(DialogFragment dialogFragment) {
                    FirmwareUpgradeFragment.t6(this.f15052a, dialogFragment);
                }
            }).c(new FZDialog.c() { // from class: com.flydigi.device_manager.ui.firmware.upgrade.d
                @Override // com.flydigi.base.widget.FZDialog.c
                public final void a(DialogFragment dialogFragment) {
                    FirmwareUpgradeFragment.v6(dialogFragment);
                }
            }).a());
        } else {
            if (i10 != 9) {
                return;
            }
            o5.a.t0(this$0.L2(), new FZDialog.a().t(this$0.c3(R.string.device_need_find_location_permission)).j(this$0.c3(R.string.device_need_find_location_permission_msg)).d(this$0.c3(R.string.cancel)).g(this$0.c3(R.string.device_setting_now)).b(Boolean.FALSE).f(new FZDialog.c() { // from class: com.flydigi.device_manager.ui.firmware.upgrade.a
                @Override // com.flydigi.base.widget.FZDialog.c
                public final void a(DialogFragment dialogFragment) {
                    FirmwareUpgradeFragment.w6(this.f15051a, dialogFragment);
                }
            }).c(new FZDialog.c() { // from class: com.flydigi.device_manager.ui.firmware.upgrade.c
                @Override // com.flydigi.base.widget.FZDialog.c
                public final void a(DialogFragment dialogFragment) {
                    FirmwareUpgradeFragment.y6(dialogFragment);
                }
            }).a());
        }
    }

    public static final void t6(final FirmwareUpgradeFragment this$0, DialogFragment dialogFragment) {
        f0.p(this$0, "this$0");
        f0.p(dialogFragment, "dialogFragment");
        dialogFragment.I5();
        Intent intent = new Intent();
        intent.setAction("android.settings.LOCATION_SOURCE_SETTINGS");
        z zVarE = RxActivityResult.b(this$0).e(intent);
        final ik.l<rx_activity_result2.f<FirmwareUpgradeFragment>, z1> lVar = new ik.l<rx_activity_result2.f<FirmwareUpgradeFragment>, z1>() { // from class: com.flydigi.device_manager.ui.firmware.upgrade.FirmwareUpgradeFragment$onScanFailed$1$dialog$1$1
            {
                super(1);
            }

            public final void b(rx_activity_result2.f<FirmwareUpgradeFragment> fVar) {
                this.this$0.C6();
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(rx_activity_result2.f<FirmwareUpgradeFragment> fVar) {
                b(fVar);
                return z1.f38230a;
            }
        };
        zVarE.E5(new dj.g() { // from class: com.flydigi.device_manager.ui.firmware.upgrade.e
            @Override // dj.g
            public final void accept(Object obj) {
                FirmwareUpgradeFragment.u6(lVar, obj);
            }
        });
    }

    public static final void u6(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void v6(DialogFragment dialogFragment) {
        dialogFragment.H5();
    }

    public static final void w6(final FirmwareUpgradeFragment this$0, DialogFragment dialogFragment) {
        f0.p(this$0, "this$0");
        f0.p(dialogFragment, "dialogFragment");
        dialogFragment.I5();
        Intent intent = new Intent();
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        Context contextX1 = this$0.X1();
        intent.setData(Uri.fromParts("package", contextX1 != null ? contextX1.getPackageName() : null, null));
        z zVarE = RxActivityResult.b(this$0).e(intent);
        final ik.l<rx_activity_result2.f<FirmwareUpgradeFragment>, z1> lVar = new ik.l<rx_activity_result2.f<FirmwareUpgradeFragment>, z1>() { // from class: com.flydigi.device_manager.ui.firmware.upgrade.FirmwareUpgradeFragment$onScanFailed$1$dialog$3$1
            {
                super(1);
            }

            public final void b(rx_activity_result2.f<FirmwareUpgradeFragment> fVar) {
                this.this$0.C6();
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(rx_activity_result2.f<FirmwareUpgradeFragment> fVar) {
                b(fVar);
                return z1.f38230a;
            }
        };
        zVarE.E5(new dj.g() { // from class: com.flydigi.device_manager.ui.firmware.upgrade.f
            @Override // dj.g
            public final void accept(Object obj) {
                FirmwareUpgradeFragment.x6(lVar, obj);
            }
        });
    }

    public static final void x6(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void y6(DialogFragment dialogFragment) {
        dialogFragment.H5();
    }

    public static final void z6(FirmwareUpgradeFragment this$0) {
        f0.p(this$0, "this$0");
        if (n0.m(this$0.f15033r8)) {
            s.e0();
            b bVar = this$0.f15031p8;
            if (bVar == null) {
                f0.S("listener");
                bVar = null;
            }
            bVar.a(false, "DFU DEVICE NOT FOUND", 0, this$0.f15034s8);
        }
    }

    @SuppressLint({"SetTextI18n"})
    public final void A6() {
        H5().f(new Runnable() { // from class: com.flydigi.device_manager.ui.firmware.upgrade.i
            @Override // java.lang.Runnable
            public final void run() {
                FirmwareUpgradeFragment.B6(this.f15060a);
            }
        }, 1000L);
    }

    public final void C6() {
        s.c0(this, 2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.flydigi.base.common.BaseFragment, androidx.fragment.app.Fragment
    public void H3(@yt.k Context context) {
        f0.p(context, "context");
        super.H3(context);
        if (context instanceof b) {
            this.f15031p8 = (b) context;
        }
    }

    @Override // com.flydigi.base.common.BaseFragment
    public boolean I5() {
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0068  */
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
            r2.f15032q8 = r3
            android.os.Bundle r3 = r2.T1()
            if (r3 == 0) goto L25
            java.lang.String r1 = "key_address"
            java.lang.String r3 = r3.getString(r1)
            goto L26
        L25:
            r3 = r0
        L26:
            r2.f15033r8 = r3
            android.os.Bundle r3 = r2.T1()
            if (r3 == 0) goto L35
            java.lang.String r1 = "key_device_code"
            java.lang.String r3 = r3.getString(r1)
            goto L36
        L35:
            r3 = r0
        L36:
            r2.f15034s8 = r3
            boolean r3 = com.blankj.utilcode.util.n0.m(r3)
            if (r3 != 0) goto L80
            java.lang.String r3 = r2.f15034s8
            java.lang.String r1 = "all"
            boolean r3 = com.blankj.utilcode.util.n0.b(r3, r1)
            if (r3 == 0) goto L49
            goto L80
        L49:
            java.lang.String r3 = r2.f15032q8
            java.lang.String r1 = "firmwareFilePath"
            if (r3 != 0) goto L53
            kotlin.jvm.internal.f0.S(r1)
            r3 = r0
        L53:
            boolean r3 = com.blankj.utilcode.util.n0.m(r3)
            if (r3 != 0) goto L68
            java.lang.String r3 = r2.f15032q8
            if (r3 != 0) goto L61
            kotlin.jvm.internal.f0.S(r1)
            goto L62
        L61:
            r0 = r3
        L62:
            boolean r3 = com.blankj.utilcode.util.b0.h0(r0)
            if (r3 != 0) goto L71
        L68:
            androidx.fragment.app.g r3 = r2.w1()
            if (r3 == 0) goto L71
            r3.finishAffinity()
        L71:
            m9.s.A(r2)
            android.content.Context r3 = r2.X1()
            if (r3 == 0) goto L7f
            com.flydigi.device_manager.ui.firmware.upgrade.FirmwareUpgradeFragment$c r0 = r2.f15037v8
            no.nordicsemi.android.dfu.DfuServiceListenerHelper.registerProgressListener(r3, r0)
        L7f:
            return
        L80:
            com.flydigi.device_manager.ui.firmware.upgrade.FirmwareUpgradeFragment$b r3 = r2.f15031p8
            if (r3 != 0) goto L8a
            java.lang.String r3 = "listener"
            kotlin.jvm.internal.f0.S(r3)
            goto L8b
        L8a:
            r0 = r3
        L8b:
            r0.d()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.flydigi.device_manager.ui.firmware.upgrade.FirmwareUpgradeFragment.K3(android.os.Bundle):void");
    }

    @Override // com.flydigi.base.common.FZFragment
    public int L5() {
        return R.layout.device_fragment_firmware_upgrade;
    }

    @Override // com.flydigi.base.common.FZFragment, com.flydigi.base.common.BaseFragment, androidx.fragment.app.Fragment
    @yt.k
    public View O3(@yt.k LayoutInflater inflater, @yt.l ViewGroup viewGroup, @yt.l Bundle bundle) {
        f0.p(inflater, "inflater");
        p0 p0VarD = p0.d(inflater, viewGroup, false);
        f0.o(p0VarD, "inflate(inflater, container, false)");
        this.f15030o8 = p0VarD;
        if (p0VarD == null) {
            f0.S("viewBinding");
            p0VarD = null;
        }
        ConstraintLayout root = p0VarD.getRoot();
        f0.o(root, "viewBinding.root");
        return root;
    }

    @Override // com.flydigi.base.common.FZFragment, com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void P3() {
        super.P3();
        s.i0(this);
        Context contextX1 = X1();
        if (contextX1 != null) {
            DfuServiceListenerHelper.unregisterProgressListener(contextX1, this.f15037v8);
        }
    }

    @Override // com.flydigi.base.common.BaseFragment, com.flydigi.base.common.t
    public boolean V() {
        return true;
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
        p0 p0Var = this.f15030o8;
        String str = null;
        if (p0Var == null) {
            f0.S("viewBinding");
            p0Var = null;
        }
        hVarC0.s1(p0Var.f10326b);
        String strC3 = c3(a5.b.f(this.f15034s8));
        f0.o(strC3, "getString(DeviceManager.…ByDeviceCode(deviceCode))");
        p0 p0Var2 = this.f15030o8;
        if (p0Var2 == null) {
            f0.S("viewBinding");
            p0Var2 = null;
        }
        p0Var2.f10328d.setText(d3(R.string.device_firmware_upgrade_message, d3(R.string.device_firmware_upgrade_message_connecting, strC3), strC3));
        String str2 = this.f15033r8;
        if (str2 == null) {
            H5().e(new Runnable() { // from class: com.flydigi.device_manager.ui.firmware.upgrade.h
                @Override // java.lang.Runnable
                public final void run() {
                    this.f15059a.C6();
                }
            });
            return;
        }
        this.f15035t8 = true;
        String str3 = this.f15032q8;
        if (str3 == null) {
            f0.S("firmwareFilePath");
        } else {
            str = str3;
        }
        q6(str2, new File(str));
    }

    @Override // com.flydigi.sdk.bluetooth.e0
    public void q1(@yt.k List<BleDevice> devices) {
        f0.p(devices, "devices");
        e0.a.a(this, devices);
        if (n0.x(this.f15033r8)) {
            s.e0();
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it2 = devices.iterator();
        while (true) {
            boolean z10 = true;
            if (!it2.hasNext()) {
                break;
            }
            Object next = it2.next();
            String strI = t.i(((BleDevice) next).F().getName());
            if (!n0.b(strI, this.f15034s8) && ((!n0.b(this.f15034s8, m9.h.f40765h) || !n0.b(strI, m9.h.f40764g)) && !n0.b(strI, this.f15034s8))) {
                z10 = false;
            }
            if (z10) {
                arrayList.add(next);
            }
        }
        if (!arrayList.isEmpty()) {
            this.f15035t8 = false;
            s.e0();
            this.f15033r8 = ((BleDevice) arrayList.get(0)).F().getAddress();
            String address = ((BleDevice) arrayList.get(0)).F().getAddress();
            f0.o(address, "it[0].device.address");
            String str = this.f15032q8;
            if (str == null) {
                f0.S("firmwareFilePath");
                str = null;
            }
            q6(address, new File(str));
        }
    }

    public final void q6(String str, File file) {
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                DfuServiceInitiator.createDfuNotificationChannel(H1());
            }
            DfuServiceInitiator packetsReceiptNotificationsEnabled = new DfuServiceInitiator(str).setKeepBond(false).setForceDfu(false).setNumberOfRetries(0).setDisableNotification(true).setPacketsReceiptNotificationsEnabled(true);
            if (com.blankj.utilcode.util.t0.n()) {
                packetsReceiptNotificationsEnabled.setPacketsReceiptNotificationsValue(6);
            } else {
                packetsReceiptNotificationsEnabled.setPacketsReceiptNotificationsValue(12);
            }
            packetsReceiptNotificationsEnabled.setZip(Uri.fromFile(file));
            packetsReceiptNotificationsEnabled.start(this.f13317d8, DfuService.class);
            u9.h.c(X1(), "Module_Upgrade_Preparing", "外设管理_固件升级_准备升级");
        } catch (Exception unused) {
            b bVar = this.f15031p8;
            if (bVar == null) {
                f0.S("listener");
                bVar = null;
            }
            bVar.a(false, "Unknown Device", 0, this.f15034s8);
        }
    }

    @Override // com.flydigi.sdk.bluetooth.e0
    public void s2() {
        e0.a.d(this);
    }

    @Override // com.flydigi.sdk.bluetooth.e0
    public void t0() {
        e0.a.c(this);
        G5().postDelayed(this.f15036u8, 5000L);
    }

    @Override // com.flydigi.sdk.bluetooth.e0
    public void x0(final int i10) {
        e0.a.b(this, i10);
        G5().removeCallbacks(this.f15036u8);
        H5().e(new Runnable() { // from class: com.flydigi.device_manager.ui.firmware.upgrade.g
            @Override // java.lang.Runnable
            public final void run() {
                FirmwareUpgradeFragment.s6(i10, this);
            }
        });
    }
}
