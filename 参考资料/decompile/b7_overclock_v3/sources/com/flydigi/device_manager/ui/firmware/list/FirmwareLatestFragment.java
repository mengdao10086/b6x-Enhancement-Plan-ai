package com.flydigi.device_manager.ui.firmware.list;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.os.e;
import c7.o0;
import com.blankj.utilcode.util.n0;
import com.blankj.utilcode.util.o;
import com.flydigi.base.common.FZFragment;
import com.flydigi.data.bean.FirmwareInfoBean;
import com.flydigi.device_manager.R;
import com.flydigi.device_manager.ui.firmware.FirmwarePresenter;
import com.flydigi.device_manager.ui.firmware.a;
import com.flydigi.device_manager.ui.firmware.list.FirmwareLatestFragment;
import hk.m;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.jvm.internal.u;
import o5.c;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes7.dex */
@t0({"SMAP\nFirmwareLatestFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FirmwareLatestFragment.kt\ncom/flydigi/device_manager/ui/firmware/list/FirmwareLatestFragment\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,215:1\n1#2:216\n*E\n"})
public final class FirmwareLatestFragment extends FZFragment implements a.b {

    @k
    public static final String A8 = "key_firmware_device_code";

    @k
    public static final String B8 = "key_device_address";

    @k
    public static final String C8 = "key_force_latest";

    @k
    public static final String D8 = "key_current_version";

    @k
    public static final String E8 = "key_chip_type";

    /* JADX INFO: renamed from: y8, reason: collision with root package name */
    @k
    public static final a f15008y8 = new a(null);

    /* JADX INFO: renamed from: z8, reason: collision with root package name */
    @k
    public static final String f15009z8 = "key_device_code";

    /* JADX INFO: renamed from: o8, reason: collision with root package name */
    public a.InterfaceC0156a f15010o8;

    /* JADX INFO: renamed from: p8, reason: collision with root package name */
    public o0 f15011p8;

    /* JADX INFO: renamed from: q8, reason: collision with root package name */
    public b f15012q8;

    /* JADX INFO: renamed from: r8, reason: collision with root package name */
    @l
    public FirmwareInfoBean f15013r8;

    /* JADX INFO: renamed from: s8, reason: collision with root package name */
    @l
    public String f15014s8;

    /* JADX INFO: renamed from: t8, reason: collision with root package name */
    @l
    public String f15015t8;

    /* JADX INFO: renamed from: u8, reason: collision with root package name */
    @l
    public String f15016u8;

    /* JADX INFO: renamed from: w8, reason: collision with root package name */
    @l
    public String f15018w8;

    /* JADX INFO: renamed from: v8, reason: collision with root package name */
    @l
    public Boolean f15017v8 = Boolean.FALSE;

    /* JADX INFO: renamed from: x8, reason: collision with root package name */
    public int f15019x8 = -1;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @m
        @k
        public final FirmwareLatestFragment a(@k String deviceCode, @k String firmwareDeviceCode, @l String str, @l Boolean bool, @l String str2, int i10) {
            f0.p(deviceCode, "deviceCode");
            f0.p(firmwareDeviceCode, "firmwareDeviceCode");
            FirmwareLatestFragment firmwareLatestFragment = new FirmwareLatestFragment();
            firmwareLatestFragment.c5(e.b(new Pair("key_device_code", deviceCode), new Pair(FirmwareLatestFragment.A8, firmwareDeviceCode), new Pair("key_device_address", str), new Pair(FirmwareLatestFragment.D8, str2), new Pair(FirmwareLatestFragment.C8, bool), new Pair("key_chip_type", Integer.valueOf(i10))));
            return firmwareLatestFragment;
        }
    }

    public interface b {
        void d();

        void l(@k FirmwareInfoBean firmwareInfoBean, @l String str, int i10);

        void y0(@l String str, int i10);
    }

    @m
    @k
    public static final FirmwareLatestFragment c6(@k String str, @k String str2, @l String str3, @l Boolean bool, @l String str4, int i10) {
        return f15008y8.a(str, str2, str3, bool, str4, i10);
    }

    public static final void d6(FirmwareLatestFragment this$0, View view) {
        f0.p(this$0, "this$0");
        b bVar = this$0.f15012q8;
        if (bVar == null) {
            f0.S("listener");
            bVar = null;
        }
        bVar.y0(this$0.f15015t8, this$0.f15019x8);
    }

    public static final void e6(FirmwareLatestFragment this$0, View view) {
        f0.p(this$0, "this$0");
        String str = this$0.f15015t8;
        if (str != null) {
            a.InterfaceC0156a interfaceC0156a = this$0.f15010o8;
            if (interfaceC0156a == null) {
                f0.S("mPresenter");
                interfaceC0156a = null;
            }
            interfaceC0156a.b(str, this$0.f15018w8);
        }
    }

    public static final void f6(FirmwareLatestFragment this$0, View view) {
        f0.p(this$0, "this$0");
        FirmwareInfoBean firmwareInfoBean = this$0.f15013r8;
        if (firmwareInfoBean != null) {
            b bVar = this$0.f15012q8;
            if (bVar == null) {
                f0.S("listener");
                bVar = null;
            }
            bVar.l(firmwareInfoBean, this$0.f15016u8, this$0.f15019x8);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.flydigi.base.common.BaseFragment, androidx.fragment.app.Fragment
    public void H3(@k Context context) {
        f0.p(context, "context");
        super.H3(context);
        this.f15012q8 = (b) context;
    }

    @Override // com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void K3(@l Bundle bundle) {
        super.K3(bundle);
        Bundle bundleT1 = T1();
        b bVar = null;
        this.f15014s8 = bundleT1 != null ? bundleT1.getString("key_device_code") : null;
        Bundle bundleT12 = T1();
        this.f15015t8 = bundleT12 != null ? bundleT12.getString(A8) : null;
        Bundle bundleT13 = T1();
        this.f15016u8 = bundleT13 != null ? bundleT13.getString("key_device_address") : null;
        Bundle bundleT14 = T1();
        this.f15018w8 = bundleT14 != null ? bundleT14.getString(D8) : null;
        Bundle bundleT15 = T1();
        this.f15017v8 = bundleT15 != null ? Boolean.valueOf(bundleT15.getBoolean(C8)) : null;
        Bundle bundleT16 = T1();
        this.f15019x8 = bundleT16 != null ? bundleT16.getInt("key_chip_type") : -1;
        String str = this.f15015t8;
        if (str == null || n0.b(str, "all")) {
            b bVar2 = this.f15012q8;
            if (bVar2 == null) {
                f0.S("listener");
            } else {
                bVar = bVar2;
            }
            bVar.d();
        }
        this.f15010o8 = new FirmwarePresenter(this);
    }

    @Override // com.flydigi.base.common.FZFragment
    public int L5() {
        return R.layout.device_fragment_firmware_latest;
    }

    @Override // com.flydigi.base.common.FZFragment, com.flydigi.base.common.BaseFragment, androidx.fragment.app.Fragment
    @k
    public View O3(@k LayoutInflater inflater, @l ViewGroup viewGroup, @l Bundle bundle) {
        f0.p(inflater, "inflater");
        o0 o0VarD = o0.d(inflater, viewGroup, false);
        f0.o(o0VarD, "inflate(inflater, container, false)");
        this.f15011p8 = o0VarD;
        if (o0VarD == null) {
            f0.S("mViewBinding");
            o0VarD = null;
        }
        LinearLayout root = o0VarD.getRoot();
        f0.o(root, "mViewBinding.root");
        return root;
    }

    @Override // com.flydigi.device_manager.ui.firmware.a.b
    public void T0() {
        o0 o0Var = this.f15011p8;
        o0 o0Var2 = null;
        if (o0Var == null) {
            f0.S("mViewBinding");
            o0Var = null;
        }
        TextView textView = o0Var.f10303k;
        f0.o(textView, "mViewBinding.tvLoading");
        Boolean bool = Boolean.FALSE;
        c.b(textView, bool, false, 2, null);
        o0 o0Var3 = this.f15011p8;
        if (o0Var3 == null) {
            f0.S("mViewBinding");
            o0Var3 = null;
        }
        ConstraintLayout constraintLayout = o0Var3.f10294b;
        f0.o(constraintLayout, "mViewBinding.areaFirmwareInfo");
        Boolean bool2 = Boolean.TRUE;
        c.b(constraintLayout, bool2, false, 2, null);
        o0 o0Var4 = this.f15011p8;
        if (o0Var4 == null) {
            f0.S("mViewBinding");
            o0Var4 = null;
        }
        TextView textView2 = o0Var4.f10302j;
        f0.o(textView2, "mViewBinding.tvFirmwareUpToDate");
        c.b(textView2, bool2, false, 2, null);
        o0 o0Var5 = this.f15011p8;
        if (o0Var5 == null) {
            f0.S("mViewBinding");
            o0Var5 = null;
        }
        o0Var5.f10302j.setText(R.string.net_state_error_clickable);
        o0 o0Var6 = this.f15011p8;
        if (o0Var6 == null) {
            f0.S("mViewBinding");
            o0Var6 = null;
        }
        o0Var6.f10297e.setEnabled(false);
        o0 o0Var7 = this.f15011p8;
        if (o0Var7 == null) {
            f0.S("mViewBinding");
            o0Var7 = null;
        }
        Button button = o0Var7.f10297e;
        f0.o(button, "mViewBinding.btnUpgrade");
        c.b(button, bool, false, 2, null);
        o0 o0Var8 = this.f15011p8;
        if (o0Var8 == null) {
            f0.S("mViewBinding");
            o0Var8 = null;
        }
        Button button2 = o0Var8.f10296d;
        f0.o(button2, "mViewBinding.btnList");
        c.b(button2, bool, false, 2, null);
        o0 o0Var9 = this.f15011p8;
        if (o0Var9 == null) {
            f0.S("mViewBinding");
        } else {
            o0Var2 = o0Var9;
        }
        o.r(o0Var2.f10302j, new View.OnClickListener() { // from class: l7.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FirmwareLatestFragment.e6(this.f39469a, view);
            }
        });
    }

    @Override // com.flydigi.device_manager.ui.firmware.a.b
    public void W0() {
        o0 o0Var = this.f15011p8;
        if (o0Var == null) {
            f0.S("mViewBinding");
            o0Var = null;
        }
        TextView textView = o0Var.f10303k;
        f0.o(textView, "mViewBinding.tvLoading");
        c.b(textView, Boolean.FALSE, false, 2, null);
        o0 o0Var2 = this.f15011p8;
        if (o0Var2 == null) {
            f0.S("mViewBinding");
            o0Var2 = null;
        }
        ConstraintLayout constraintLayout = o0Var2.f10294b;
        f0.o(constraintLayout, "mViewBinding.areaFirmwareInfo");
        Boolean bool = Boolean.TRUE;
        c.b(constraintLayout, bool, false, 2, null);
        o0 o0Var3 = this.f15011p8;
        if (o0Var3 == null) {
            f0.S("mViewBinding");
            o0Var3 = null;
        }
        TextView textView2 = o0Var3.f10302j;
        f0.o(textView2, "mViewBinding.tvFirmwareUpToDate");
        c.b(textView2, bool, false, 2, null);
        o0 o0Var4 = this.f15011p8;
        if (o0Var4 == null) {
            f0.S("mViewBinding");
            o0Var4 = null;
        }
        o0Var4.f10302j.setText(R.string.device_firmware_upgrade_firmware_is_latest);
        o0 o0Var5 = this.f15011p8;
        if (o0Var5 == null) {
            f0.S("mViewBinding");
            o0Var5 = null;
        }
        o0Var5.f10297e.setEnabled(false);
        o0 o0Var6 = this.f15011p8;
        if (o0Var6 == null) {
            f0.S("mViewBinding");
            o0Var6 = null;
        }
        Button button = o0Var6.f10297e;
        f0.o(button, "mViewBinding.btnUpgrade");
        c.b(button, bool, false, 2, null);
        o0 o0Var7 = this.f15011p8;
        if (o0Var7 == null) {
            f0.S("mViewBinding");
            o0Var7 = null;
        }
        o0Var7.f10296d.setVisibility(f0.g(this.f15017v8, bool) ? 8 : 0);
        o0 o0Var8 = this.f15011p8;
        if (o0Var8 == null) {
            f0.S("mViewBinding");
            o0Var8 = null;
        }
        o.r(o0Var8.f10302j, null);
    }

    @Override // com.flydigi.device_manager.ui.firmware.a.b
    public void Y0(@k List<? extends FirmwareInfoBean> data) {
        f0.p(data, "data");
    }

    @Override // com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void h4() {
        super.h4();
        String str = this.f15015t8;
        if (str != null) {
            a.InterfaceC0156a interfaceC0156a = this.f15010o8;
            if (interfaceC0156a == null) {
                f0.S("mPresenter");
                interfaceC0156a = null;
            }
            interfaceC0156a.b(str, this.f15018w8);
        }
    }

    @Override // com.flydigi.device_manager.ui.firmware.a.b
    public void i(@k FirmwareInfoBean data) {
        f0.p(data, "data");
        this.f15013r8 = data;
        o0 o0Var = this.f15011p8;
        o0 o0Var2 = null;
        if (o0Var == null) {
            f0.S("mViewBinding");
            o0Var = null;
        }
        o0Var.f10305m.setText(data.title);
        o0 o0Var3 = this.f15011p8;
        if (o0Var3 == null) {
            f0.S("mViewBinding");
            o0Var3 = null;
        }
        TextView textView = o0Var3.f10305m;
        f0.o(textView, "mViewBinding.tvTitle");
        Boolean bool = Boolean.TRUE;
        c.b(textView, bool, false, 2, null);
        o0 o0Var4 = this.f15011p8;
        if (o0Var4 == null) {
            f0.S("mViewBinding");
            o0Var4 = null;
        }
        TextView textView2 = o0Var4.f10303k;
        f0.o(textView2, "mViewBinding.tvLoading");
        Boolean bool2 = Boolean.FALSE;
        c.b(textView2, bool2, false, 2, null);
        o0 o0Var5 = this.f15011p8;
        if (o0Var5 == null) {
            f0.S("mViewBinding");
            o0Var5 = null;
        }
        ConstraintLayout constraintLayout = o0Var5.f10294b;
        f0.o(constraintLayout, "mViewBinding.areaFirmwareInfo");
        c.b(constraintLayout, bool, false, 2, null);
        o0 o0Var6 = this.f15011p8;
        if (o0Var6 == null) {
            f0.S("mViewBinding");
            o0Var6 = null;
        }
        LinearLayout linearLayout = o0Var6.f10295c;
        f0.o(linearLayout, "mViewBinding.areaNewFirmwareInfo");
        c.b(linearLayout, bool, false, 2, null);
        o0 o0Var7 = this.f15011p8;
        if (o0Var7 == null) {
            f0.S("mViewBinding");
            o0Var7 = null;
        }
        Button button = o0Var7.f10297e;
        f0.o(button, "mViewBinding.btnUpgrade");
        c.b(button, bool, false, 2, null);
        o0 o0Var8 = this.f15011p8;
        if (o0Var8 == null) {
            f0.S("mViewBinding");
            o0Var8 = null;
        }
        o0Var8.f10296d.setVisibility(f0.g(this.f15017v8, bool) ? 8 : 0);
        o0 o0Var9 = this.f15011p8;
        if (o0Var9 == null) {
            f0.S("mViewBinding");
            o0Var9 = null;
        }
        o0Var9.f10301i.setText(data.desc);
        o0 o0Var10 = this.f15011p8;
        if (o0Var10 == null) {
            f0.S("mViewBinding");
            o0Var10 = null;
        }
        TextView textView3 = o0Var10.f10302j;
        f0.o(textView3, "mViewBinding.tvFirmwareUpToDate");
        c.b(textView3, bool2, false, 2, null);
        o0 o0Var11 = this.f15011p8;
        if (o0Var11 == null) {
            f0.S("mViewBinding");
            o0Var11 = null;
        }
        o0Var11.f10297e.setEnabled(true);
        o0 o0Var12 = this.f15011p8;
        if (o0Var12 == null) {
            f0.S("mViewBinding");
            o0Var12 = null;
        }
        o.r(o0Var12.f10302j, null);
        o0 o0Var13 = this.f15011p8;
        if (o0Var13 == null) {
            f0.S("mViewBinding");
        } else {
            o0Var2 = o0Var13;
        }
        o.r(o0Var2.f10297e, new View.OnClickListener() { // from class: l7.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FirmwareLatestFragment.f6(this.f39467a, view);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0157  */
    @Override // com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void j4(@yt.k android.view.View r7, @yt.l android.os.Bundle r8) {
        /*
            Method dump skipped, instruction units count: 352
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.flydigi.device_manager.ui.firmware.list.FirmwareLatestFragment.j4(android.view.View, android.os.Bundle):void");
    }

    @Override // com.flydigi.device_manager.ui.firmware.a.b
    public void o0() {
        o0 o0Var = this.f15011p8;
        if (o0Var == null) {
            f0.S("mViewBinding");
            o0Var = null;
        }
        TextView textView = o0Var.f10303k;
        f0.o(textView, "mViewBinding.tvLoading");
        c.b(textView, Boolean.TRUE, false, 2, null);
        o0 o0Var2 = this.f15011p8;
        if (o0Var2 == null) {
            f0.S("mViewBinding");
            o0Var2 = null;
        }
        ConstraintLayout constraintLayout = o0Var2.f10294b;
        f0.o(constraintLayout, "mViewBinding.areaFirmwareInfo");
        Boolean bool = Boolean.FALSE;
        c.b(constraintLayout, bool, false, 2, null);
        o0 o0Var3 = this.f15011p8;
        if (o0Var3 == null) {
            f0.S("mViewBinding");
            o0Var3 = null;
        }
        LinearLayout linearLayout = o0Var3.f10295c;
        f0.o(linearLayout, "mViewBinding.areaNewFirmwareInfo");
        c.b(linearLayout, bool, false, 2, null);
    }
}
