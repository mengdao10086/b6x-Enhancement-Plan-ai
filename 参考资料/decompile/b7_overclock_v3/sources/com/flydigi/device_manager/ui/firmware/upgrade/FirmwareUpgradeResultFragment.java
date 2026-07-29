package com.flydigi.device_manager.ui.firmware.upgrade;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;
import c7.q0;
import com.flydigi.base.common.FZFragment;
import com.flydigi.base.widget.FZDialog;
import com.flydigi.data.DataConstant;
import com.flydigi.device_manager.R;
import kotlin.Pair;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;

/* JADX INFO: loaded from: classes7.dex */
public final class FirmwareUpgradeResultFragment extends FZFragment {

    @yt.k
    public static final String A8 = "key_real_device_code";

    @yt.k
    public static final String B8 = "key_message";

    @yt.k
    public static final String C8 = "key_is_dfu_mode";

    @yt.k
    public static final String D8 = "key_need_show_joystick_dialog";

    @yt.k
    public static final String E8 = "key_chip_type";

    /* JADX INFO: renamed from: x8, reason: collision with root package name */
    @yt.k
    public static final a f15039x8 = new a(null);

    /* JADX INFO: renamed from: y8, reason: collision with root package name */
    @yt.k
    public static final String f15040y8 = "key_upgrade_result";

    /* JADX INFO: renamed from: z8, reason: collision with root package name */
    @yt.k
    public static final String f15041z8 = "key_device_code";

    /* JADX INFO: renamed from: o8, reason: collision with root package name */
    public q0 f15042o8;

    /* JADX INFO: renamed from: p8, reason: collision with root package name */
    public b f15043p8;

    /* JADX INFO: renamed from: q8, reason: collision with root package name */
    public boolean f15044q8;

    /* JADX INFO: renamed from: r8, reason: collision with root package name */
    public boolean f15045r8;

    /* JADX INFO: renamed from: s8, reason: collision with root package name */
    @yt.l
    public String f15046s8 = "all";

    /* JADX INFO: renamed from: t8, reason: collision with root package name */
    @yt.l
    public String f15047t8 = "all";

    /* JADX INFO: renamed from: u8, reason: collision with root package name */
    @yt.l
    public String f15048u8;

    /* JADX INFO: renamed from: v8, reason: collision with root package name */
    public int f15049v8;

    /* JADX INFO: renamed from: w8, reason: collision with root package name */
    public boolean f15050w8;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @hk.m
        @yt.k
        public final FirmwareUpgradeResultFragment a(boolean z10, @yt.l String str, @yt.l String str2, @yt.k String message, boolean z11, @yt.l Integer num, @yt.l Boolean bool) {
            f0.p(message, "message");
            FirmwareUpgradeResultFragment firmwareUpgradeResultFragment = new FirmwareUpgradeResultFragment();
            firmwareUpgradeResultFragment.c5(androidx.core.os.e.b(new Pair("key_upgrade_result", Boolean.valueOf(z10)), new Pair("key_device_code", str), new Pair(FirmwareUpgradeResultFragment.A8, str2), new Pair(FirmwareUpgradeResultFragment.B8, message), new Pair(FirmwareUpgradeResultFragment.C8, Boolean.valueOf(z11)), new Pair("key_chip_type", num), new Pair(FirmwareUpgradeResultFragment.D8, bool)));
            return firmwareUpgradeResultFragment;
        }
    }

    public interface b {

        public static final class a {
            public static /* synthetic */ void a(b bVar, String str, String str2, int i10, Boolean bool, int i11, Object obj) {
                if (obj != null) {
                    throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showFirmwareLatestFragment");
                }
                if ((i11 & 1) != 0) {
                    str = null;
                }
                if ((i11 & 8) != 0) {
                    bool = Boolean.FALSE;
                }
                bVar.s(str, str2, i10, bool);
            }
        }

        void o0();

        void s(@yt.l String str, @yt.k String str2, int i10, @yt.l Boolean bool);

        void t2(int i10, @yt.l String str);
    }

    @hk.m
    @yt.k
    public static final FirmwareUpgradeResultFragment e6(boolean z10, @yt.l String str, @yt.l String str2, @yt.k String str3, boolean z11, @yt.l Integer num, @yt.l Boolean bool) {
        return f15039x8.a(z10, str, str2, str3, z11, num, bool);
    }

    public static final void f6(FirmwareUpgradeResultFragment this$0, View view) {
        f0.p(this$0, "this$0");
        b bVar = this$0.f15043p8;
        if (bVar == null) {
            f0.S("listener");
            bVar = null;
        }
        bVar.o0();
    }

    public static final void g6(FirmwareUpgradeResultFragment this$0, View view) {
        f0.p(this$0, "this$0");
        u9.g.a().c(view.getContext(), "Module_Upgrade_Failed_Try_Dfu", "外设管理_固件升级_升级失败_重试");
        b bVar = this$0.f15043p8;
        if (bVar == null) {
            f0.S("listener");
            bVar = null;
        }
        bVar.t2(this$0.f15049v8, this$0.f15046s8);
    }

    public static final void h6(View view) {
        u9.b.o(5, "固件升级");
    }

    public static final void j6(DialogFragment dialogFragment) {
        dialogFragment.I5();
    }

    public static final void k6(FirmwareUpgradeResultFragment this$0, DialogFragment dialogFragment) {
        f0.p(this$0, "this$0");
        h3.a.j().d(i9.a.f31902d).withString(DataConstant.WEB_URL, "https://bbs.flydigi.com/index/index/calibratCourse?lang=" + m5.f0.f40651g + "&device_type=" + this$0.f15046s8).navigation();
        dialogFragment.I5();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.flydigi.base.common.BaseFragment, androidx.fragment.app.Fragment
    public void H3(@yt.k Context context) {
        f0.p(context, "context");
        super.H3(context);
        if (context instanceof b) {
            this.f15043p8 = (b) context;
        }
    }

    @Override // com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void K3(@yt.l Bundle bundle) {
        String string;
        String string2;
        super.K3(bundle);
        Bundle bundleT1 = T1();
        this.f15044q8 = bundleT1 != null ? bundleT1.getBoolean("key_upgrade_result") : false;
        Bundle bundleT12 = T1();
        String str = "all";
        if (bundleT12 == null || (string = bundleT12.getString("key_device_code")) == null) {
            string = "all";
        }
        this.f15046s8 = string;
        Bundle bundleT13 = T1();
        if (bundleT13 != null && (string2 = bundleT13.getString(A8)) != null) {
            str = string2;
        }
        this.f15047t8 = str;
        Bundle bundleT14 = T1();
        this.f15048u8 = bundleT14 != null ? bundleT14.getString(B8) : null;
        Bundle bundleT15 = T1();
        this.f15045r8 = bundleT15 != null ? bundleT15.getBoolean(C8) : false;
        Bundle bundleT16 = T1();
        this.f15050w8 = bundleT16 != null ? bundleT16.getBoolean(D8) : false;
        Bundle bundleT17 = T1();
        this.f15049v8 = bundleT17 != null ? bundleT17.getInt("key_chip_type") : 0;
    }

    @Override // com.flydigi.base.common.FZFragment
    public int L5() {
        return R.layout.device_fragment_firmware_upgrade_result;
    }

    @Override // com.flydigi.base.common.FZFragment, com.flydigi.base.common.BaseFragment, androidx.fragment.app.Fragment
    @yt.k
    public View O3(@yt.k LayoutInflater inflater, @yt.l ViewGroup viewGroup, @yt.l Bundle bundle) {
        f0.p(inflater, "inflater");
        q0 q0VarD = q0.d(inflater, viewGroup, false);
        f0.o(q0VarD, "inflate(inflater, container, false)");
        this.f15042o8 = q0VarD;
        if (q0VarD == null) {
            f0.S("viewBinding");
            q0VarD = null;
        }
        ConstraintLayout constraintLayoutB = q0VarD.getRoot();
        f0.o(constraintLayoutB, "viewBinding.root");
        return constraintLayoutB;
    }

    public final void i6() {
        o5.a.t0(U1(), new FZDialog.a().t(c3(R.string.device_please_calibrate_joystick)).j(c3(R.string.device_please_calibrate_joystick_desc)).b(Boolean.FALSE).d(c3(R.string.device_just_know)).e(R.color.color_000000_a50).g(c3(R.string.device_please_calibrate_joystick_ok)).h(R.color.colorPrimary).c(new FZDialog.c() { // from class: com.flydigi.device_manager.ui.firmware.upgrade.o
            @Override // com.flydigi.base.widget.FZDialog.c
            public final void a(DialogFragment dialogFragment) {
                FirmwareUpgradeResultFragment.j6(dialogFragment);
            }
        }).f(new FZDialog.c() { // from class: com.flydigi.device_manager.ui.firmware.upgrade.n
            @Override // com.flydigi.base.widget.FZDialog.c
            public final void a(DialogFragment dialogFragment) {
                FirmwareUpgradeResultFragment.k6(this.f15097a, dialogFragment);
            }
        }).a());
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00fd  */
    @Override // com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void j4(@yt.k android.view.View r7, @yt.l android.os.Bundle r8) {
        /*
            Method dump skipped, instruction units count: 638
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.flydigi.device_manager.ui.firmware.upgrade.FirmwareUpgradeResultFragment.j4(android.view.View, android.os.Bundle):void");
    }
}
