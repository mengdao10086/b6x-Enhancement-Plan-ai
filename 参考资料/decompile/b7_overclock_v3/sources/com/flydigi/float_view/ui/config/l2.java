package com.flydigi.float_view.ui.config;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.flydigi.data.event.BluetoothDeviceOperateEvent;
import com.flydigi.float_view.R;
import com.flydigi.float_view.widget.FloatViewSingleCheckBoxView;
import com.flydigi.float_view.widget.FloatViewVibrateItemView;
import com.flydigi.sdk.gamepad.GamepadInfo;
import com.flydigi.sdk.gamepad.extension.config.data.CFGVibrateBean;
import com.flydigi.sdk.gamepad.extension.config.data.CFGVibrateItem;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import org.greenrobot.eventbus.ThreadMode;
import z7.j;

/* JADX INFO: loaded from: classes7.dex */
public final class l2 extends y7.b {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @yt.k
    public final CFGVibrateBean f15662p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public w7.n0 f15663q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f15664r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f15665s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final int f15666t;

    public static final class a implements FloatViewSingleCheckBoxView.a {
        public a() {
        }

        @Override // com.flydigi.float_view.widget.FloatViewSingleCheckBoxView.a
        public void a(boolean z10) {
            w7.n0 n0Var = l2.this.f15663q;
            if (n0Var == null) {
                kotlin.jvm.internal.f0.S("viewBinding");
                n0Var = null;
            }
            n0Var.f54304b.setVisibility(z10 ? 8 : 0);
        }
    }

    public static final class b implements FloatViewSingleCheckBoxView.b {
        public b() {
        }

        @Override // com.flydigi.float_view.widget.FloatViewSingleCheckBoxView.b
        public void a() {
            new z7.j(l2.this.f56478a, l2.this.f56478a.getString(R.string.floatview_introduction), l2.this.f56478a.getString(R.string.floatview_vibrate_function_intro), 1, null).y();
        }
    }

    public static final class c implements FloatViewVibrateItemView.b {
        public c() {
        }

        @Override // com.flydigi.float_view.widget.FloatViewVibrateItemView.b
        public void a() {
            l2.this.Q(0);
        }
    }

    public static final class d implements FloatViewVibrateItemView.b {
        public d() {
        }

        @Override // com.flydigi.float_view.widget.FloatViewVibrateItemView.b
        public void a() {
            l2.this.Q(1);
        }
    }

    public static final class e implements FloatViewVibrateItemView.b {
        public e() {
        }

        @Override // com.flydigi.float_view.widget.FloatViewVibrateItemView.b
        public void a() {
            l2.this.Q(2);
        }
    }

    public static final class f implements j.a {
        public f() {
        }

        @Override // z7.j.a
        public void a() {
            l2.this.q(28);
        }

        @Override // z7.j.a
        public void b(boolean z10) {
            l2.this.P();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l2(@yt.k Context context, @yt.k CFGVibrateBean vibrateConfig, @yt.k Handler handler, @yt.k GamepadInfo deviceInfo) {
        super(context, null, handler, deviceInfo);
        kotlin.jvm.internal.f0.p(context, "context");
        kotlin.jvm.internal.f0.p(vibrateConfig, "vibrateConfig");
        kotlin.jvm.internal.f0.p(handler, "handler");
        kotlin.jvm.internal.f0.p(deviceInfo, "deviceInfo");
        this.f15662p = vibrateConfig;
        this.f15665s = -1;
        this.f15666t = vibrateConfig.hashCode();
    }

    public static final void L(l2 this$0, View view) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        if (this$0.J()) {
            this$0.R();
        } else {
            this$0.q(28);
        }
    }

    public static final void N(l2 this$0, View view) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        this$0.P();
    }

    public static final void O(l2 this$0, View view) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        this$0.f15664r = false;
        w7.n0 n0Var = this$0.f15663q;
        if (n0Var == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            n0Var = null;
        }
        FrameLayout root = n0Var.f54305c.getRoot();
        kotlin.jvm.internal.f0.o(root, "viewBinding.layoutWaitClick.root");
        o5.c.b(root, Boolean.FALSE, false, 2, null);
    }

    public final boolean J() {
        int configId = this.f15662p.getConfigId();
        String configName = this.f15662p.getConfigName();
        w7.n0 n0Var = this.f15663q;
        w7.n0 n0Var2 = null;
        if (n0Var == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            n0Var = null;
        }
        boolean value = n0Var.f54307e.getValue();
        CFGVibrateItem[] cFGVibrateItemArr = new CFGVibrateItem[3];
        w7.n0 n0Var3 = this.f15663q;
        if (n0Var3 == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            n0Var3 = null;
        }
        cFGVibrateItemArr[0] = n0Var3.f54311i.getValue();
        w7.n0 n0Var4 = this.f15663q;
        if (n0Var4 == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            n0Var4 = null;
        }
        cFGVibrateItemArr[1] = n0Var4.f54312j.getValue();
        w7.n0 n0Var5 = this.f15663q;
        if (n0Var5 == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
        } else {
            n0Var2 = n0Var5;
        }
        cFGVibrateItemArr[2] = n0Var2.f54313k.getValue();
        return new CFGVibrateBean(configId, configName, value, CollectionsKt__CollectionsKt.r(cFGVibrateItemArr)).hashCode() != this.f15666t;
    }

    public final void K(@yt.k byte[] data) {
        kotlin.jvm.internal.f0.p(data, "data");
        if (this.f15664r && m9.b.M(data)) {
            GamepadInfo deviceInfo = this.f56484g;
            kotlin.jvm.internal.f0.o(deviceInfo, "deviceInfo");
            List<Integer> listV0 = m9.b.v0(data, deviceInfo);
            if (!listV0.isEmpty()) {
                int iIntValue = listV0.get(0).intValue();
                w7.n0 n0Var = this.f15663q;
                if (n0Var == null) {
                    kotlin.jvm.internal.f0.S("viewBinding");
                    n0Var = null;
                }
                if (iIntValue != n0Var.f54311i.getValue().getKeyId()) {
                    w7.n0 n0Var2 = this.f15663q;
                    if (n0Var2 == null) {
                        kotlin.jvm.internal.f0.S("viewBinding");
                        n0Var2 = null;
                    }
                    if (iIntValue != n0Var2.f54312j.getValue().getKeyId()) {
                        w7.n0 n0Var3 = this.f15663q;
                        if (n0Var3 == null) {
                            kotlin.jvm.internal.f0.S("viewBinding");
                            n0Var3 = null;
                        }
                        if (iIntValue != n0Var3.f54313k.getValue().getKeyId()) {
                            int i10 = this.f15665s;
                            if (i10 == 0) {
                                w7.n0 n0Var4 = this.f15663q;
                                if (n0Var4 == null) {
                                    kotlin.jvm.internal.f0.S("viewBinding");
                                    n0Var4 = null;
                                }
                                FloatViewVibrateItemView floatViewVibrateItemView = n0Var4.f54311i;
                                GamepadInfo deviceInfo2 = this.f56484g;
                                kotlin.jvm.internal.f0.o(deviceInfo2, "deviceInfo");
                                floatViewVibrateItemView.N(iIntValue, deviceInfo2);
                            } else if (i10 == 1) {
                                w7.n0 n0Var5 = this.f15663q;
                                if (n0Var5 == null) {
                                    kotlin.jvm.internal.f0.S("viewBinding");
                                    n0Var5 = null;
                                }
                                FloatViewVibrateItemView floatViewVibrateItemView2 = n0Var5.f54312j;
                                GamepadInfo deviceInfo3 = this.f56484g;
                                kotlin.jvm.internal.f0.o(deviceInfo3, "deviceInfo");
                                floatViewVibrateItemView2.N(iIntValue, deviceInfo3);
                            } else {
                                if (i10 != 2) {
                                    return;
                                }
                                w7.n0 n0Var6 = this.f15663q;
                                if (n0Var6 == null) {
                                    kotlin.jvm.internal.f0.S("viewBinding");
                                    n0Var6 = null;
                                }
                                FloatViewVibrateItemView floatViewVibrateItemView3 = n0Var6.f54313k;
                                GamepadInfo deviceInfo4 = this.f56484g;
                                kotlin.jvm.internal.f0.o(deviceInfo4, "deviceInfo");
                                floatViewVibrateItemView3.N(iIntValue, deviceInfo4);
                            }
                            this.f15664r = false;
                            this.f15665s = -1;
                            w7.n0 n0Var7 = this.f15663q;
                            if (n0Var7 == null) {
                                kotlin.jvm.internal.f0.S("viewBinding");
                                n0Var7 = null;
                            }
                            FrameLayout root = n0Var7.f54305c.getRoot();
                            kotlin.jvm.internal.f0.o(root, "viewBinding.layoutWaitClick.root");
                            o5.c.b(root, Boolean.FALSE, false, 2, null);
                            return;
                        }
                    }
                }
                Context context = this.f56478a;
                n8.b.m(context, context.getString(R.string.floatview_msg_vibrate_key_exit));
            }
        }
    }

    public final void P() {
        int configId = this.f15662p.getConfigId();
        String configName = this.f15662p.getConfigName();
        w7.n0 n0Var = this.f15663q;
        w7.n0 n0Var2 = null;
        if (n0Var == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            n0Var = null;
        }
        boolean value = n0Var.f54307e.getValue();
        CFGVibrateItem[] cFGVibrateItemArr = new CFGVibrateItem[3];
        w7.n0 n0Var3 = this.f15663q;
        if (n0Var3 == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            n0Var3 = null;
        }
        cFGVibrateItemArr[0] = n0Var3.f54311i.getValue();
        w7.n0 n0Var4 = this.f15663q;
        if (n0Var4 == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            n0Var4 = null;
        }
        cFGVibrateItemArr[1] = n0Var4.f54312j.getValue();
        w7.n0 n0Var5 = this.f15663q;
        if (n0Var5 == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
        } else {
            n0Var2 = n0Var5;
        }
        cFGVibrateItemArr[2] = n0Var2.f54313k.getValue();
        t(29, new CFGVibrateBean(configId, configName, value, CollectionsKt__CollectionsKt.r(cFGVibrateItemArr)));
    }

    public final void Q(int i10) {
        this.f15664r = true;
        this.f15665s = i10;
        w7.n0 n0Var = this.f15663q;
        if (n0Var == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            n0Var = null;
        }
        FrameLayout root = n0Var.f54305c.getRoot();
        kotlin.jvm.internal.f0.o(root, "viewBinding.layoutWaitClick.root");
        o5.c.b(root, Boolean.TRUE, false, 2, null);
    }

    public final void R() {
        Context context = this.f56478a;
        new z7.j(context, 2, "", context.getString(R.string.floatview_change_not_saved), this.f56478a.getString(R.string.floatview_save), this.f56478a.getString(R.string.floatview_discard_change), new f());
    }

    @Override // y7.b
    public int i() {
        return R.layout.floatview_panel_vibrate_setup;
    }

    @Override // y7.b
    public void n() {
        w7.n0 n0VarA = w7.n0.a(j());
        kotlin.jvm.internal.f0.o(n0VarA, "bind(view)");
        this.f15663q = n0VarA;
        w7.n0 n0Var = null;
        if (n0VarA == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            n0VarA = null;
        }
        com.blankj.utilcode.util.o.r(n0VarA.f54308f, new View.OnClickListener() { // from class: com.flydigi.float_view.ui.config.i2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                l2.L(this.f15648a, view);
            }
        });
        w7.n0 n0Var2 = this.f15663q;
        if (n0Var2 == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            n0Var2 = null;
        }
        com.blankj.utilcode.util.o.r(n0Var2.f54309g, new View.OnClickListener() { // from class: com.flydigi.float_view.ui.config.k2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                l2.N(this.f15658a, view);
            }
        });
        w7.n0 n0Var3 = this.f15663q;
        if (n0Var3 == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            n0Var3 = null;
        }
        n0Var3.f54305c.f54103d.setText(n8.b.l(this.f56478a, this.f56484g.getDeviceMode()));
        w7.n0 n0Var4 = this.f15663q;
        if (n0Var4 == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            n0Var4 = null;
        }
        com.blankj.utilcode.util.o.r(n0Var4.f54305c.getRoot(), new View.OnClickListener() { // from class: com.flydigi.float_view.ui.config.j2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                l2.O(this.f15653a, view);
            }
        });
        w7.n0 n0Var5 = this.f15663q;
        if (n0Var5 == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            n0Var5 = null;
        }
        n0Var5.f54307e.setOnCheckBoxClickListener$float_view_officialRelease(new a());
        w7.n0 n0Var6 = this.f15663q;
        if (n0Var6 == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            n0Var6 = null;
        }
        n0Var6.f54307e.setOnHelpClickListener$float_view_officialRelease(new b());
        w7.n0 n0Var7 = this.f15663q;
        if (n0Var7 == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            n0Var7 = null;
        }
        n0Var7.f54311i.setOnButtonAddClickedListener$float_view_officialRelease(new c());
        w7.n0 n0Var8 = this.f15663q;
        if (n0Var8 == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            n0Var8 = null;
        }
        n0Var8.f54312j.setOnButtonAddClickedListener$float_view_officialRelease(new d());
        w7.n0 n0Var9 = this.f15663q;
        if (n0Var9 == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            n0Var9 = null;
        }
        n0Var9.f54313k.setOnButtonAddClickedListener$float_view_officialRelease(new e());
        v();
        w7.n0 n0Var10 = this.f15663q;
        if (n0Var10 == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            n0Var10 = null;
        }
        n0Var10.f54304b.setVisibility(this.f15662p.getEnable() ? 8 : 0);
        w7.n0 n0Var11 = this.f15663q;
        if (n0Var11 == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            n0Var11 = null;
        }
        n0Var11.f54307e.setValue(this.f15662p.getEnable());
        int size = this.f15662p.getKeys().size();
        if (size == 0) {
            w7.n0 n0Var12 = this.f15663q;
            if (n0Var12 == null) {
                kotlin.jvm.internal.f0.S("viewBinding");
                n0Var12 = null;
            }
            FloatViewVibrateItemView floatViewVibrateItemView = n0Var12.f54311i;
            CFGVibrateItem cFGVibrateItem = new CFGVibrateItem(0, null, null, null, null, 31, null);
            GamepadInfo deviceInfo = this.f56484g;
            kotlin.jvm.internal.f0.o(deviceInfo, "deviceInfo");
            floatViewVibrateItemView.O(cFGVibrateItem, deviceInfo);
            w7.n0 n0Var13 = this.f15663q;
            if (n0Var13 == null) {
                kotlin.jvm.internal.f0.S("viewBinding");
                n0Var13 = null;
            }
            FloatViewVibrateItemView floatViewVibrateItemView2 = n0Var13.f54312j;
            CFGVibrateItem cFGVibrateItem2 = new CFGVibrateItem(0, null, null, null, null, 31, null);
            GamepadInfo deviceInfo2 = this.f56484g;
            kotlin.jvm.internal.f0.o(deviceInfo2, "deviceInfo");
            floatViewVibrateItemView2.O(cFGVibrateItem2, deviceInfo2);
            w7.n0 n0Var14 = this.f15663q;
            if (n0Var14 == null) {
                kotlin.jvm.internal.f0.S("viewBinding");
            } else {
                n0Var = n0Var14;
            }
            FloatViewVibrateItemView floatViewVibrateItemView3 = n0Var.f54313k;
            CFGVibrateItem cFGVibrateItem3 = new CFGVibrateItem(0, null, null, null, null, 31, null);
            GamepadInfo deviceInfo3 = this.f56484g;
            kotlin.jvm.internal.f0.o(deviceInfo3, "deviceInfo");
            floatViewVibrateItemView3.O(cFGVibrateItem3, deviceInfo3);
            return;
        }
        if (size == 1) {
            w7.n0 n0Var15 = this.f15663q;
            if (n0Var15 == null) {
                kotlin.jvm.internal.f0.S("viewBinding");
                n0Var15 = null;
            }
            FloatViewVibrateItemView floatViewVibrateItemView4 = n0Var15.f54311i;
            CFGVibrateItem cFGVibrateItem4 = this.f15662p.getKeys().get(0);
            kotlin.jvm.internal.f0.o(cFGVibrateItem4, "vibrateConfig.keys[0]");
            GamepadInfo deviceInfo4 = this.f56484g;
            kotlin.jvm.internal.f0.o(deviceInfo4, "deviceInfo");
            floatViewVibrateItemView4.O(cFGVibrateItem4, deviceInfo4);
            w7.n0 n0Var16 = this.f15663q;
            if (n0Var16 == null) {
                kotlin.jvm.internal.f0.S("viewBinding");
                n0Var16 = null;
            }
            FloatViewVibrateItemView floatViewVibrateItemView5 = n0Var16.f54312j;
            CFGVibrateItem cFGVibrateItem5 = new CFGVibrateItem(0, null, null, null, null, 31, null);
            GamepadInfo deviceInfo5 = this.f56484g;
            kotlin.jvm.internal.f0.o(deviceInfo5, "deviceInfo");
            floatViewVibrateItemView5.O(cFGVibrateItem5, deviceInfo5);
            w7.n0 n0Var17 = this.f15663q;
            if (n0Var17 == null) {
                kotlin.jvm.internal.f0.S("viewBinding");
            } else {
                n0Var = n0Var17;
            }
            FloatViewVibrateItemView floatViewVibrateItemView6 = n0Var.f54313k;
            CFGVibrateItem cFGVibrateItem6 = new CFGVibrateItem(0, null, null, null, null, 31, null);
            GamepadInfo deviceInfo6 = this.f56484g;
            kotlin.jvm.internal.f0.o(deviceInfo6, "deviceInfo");
            floatViewVibrateItemView6.O(cFGVibrateItem6, deviceInfo6);
            return;
        }
        if (size == 2) {
            w7.n0 n0Var18 = this.f15663q;
            if (n0Var18 == null) {
                kotlin.jvm.internal.f0.S("viewBinding");
                n0Var18 = null;
            }
            FloatViewVibrateItemView floatViewVibrateItemView7 = n0Var18.f54311i;
            CFGVibrateItem cFGVibrateItem7 = this.f15662p.getKeys().get(0);
            kotlin.jvm.internal.f0.o(cFGVibrateItem7, "vibrateConfig.keys[0]");
            GamepadInfo deviceInfo7 = this.f56484g;
            kotlin.jvm.internal.f0.o(deviceInfo7, "deviceInfo");
            floatViewVibrateItemView7.O(cFGVibrateItem7, deviceInfo7);
            w7.n0 n0Var19 = this.f15663q;
            if (n0Var19 == null) {
                kotlin.jvm.internal.f0.S("viewBinding");
                n0Var19 = null;
            }
            FloatViewVibrateItemView floatViewVibrateItemView8 = n0Var19.f54312j;
            CFGVibrateItem cFGVibrateItem8 = this.f15662p.getKeys().get(1);
            kotlin.jvm.internal.f0.o(cFGVibrateItem8, "vibrateConfig.keys[1]");
            GamepadInfo deviceInfo8 = this.f56484g;
            kotlin.jvm.internal.f0.o(deviceInfo8, "deviceInfo");
            floatViewVibrateItemView8.O(cFGVibrateItem8, deviceInfo8);
            w7.n0 n0Var20 = this.f15663q;
            if (n0Var20 == null) {
                kotlin.jvm.internal.f0.S("viewBinding");
            } else {
                n0Var = n0Var20;
            }
            FloatViewVibrateItemView floatViewVibrateItemView9 = n0Var.f54313k;
            CFGVibrateItem cFGVibrateItem9 = new CFGVibrateItem(0, null, null, null, null, 31, null);
            GamepadInfo deviceInfo9 = this.f56484g;
            kotlin.jvm.internal.f0.o(deviceInfo9, "deviceInfo");
            floatViewVibrateItemView9.O(cFGVibrateItem9, deviceInfo9);
            return;
        }
        if (size != 3) {
            return;
        }
        w7.n0 n0Var21 = this.f15663q;
        if (n0Var21 == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            n0Var21 = null;
        }
        FloatViewVibrateItemView floatViewVibrateItemView10 = n0Var21.f54311i;
        CFGVibrateItem cFGVibrateItem10 = this.f15662p.getKeys().get(0);
        kotlin.jvm.internal.f0.o(cFGVibrateItem10, "vibrateConfig.keys[0]");
        GamepadInfo deviceInfo10 = this.f56484g;
        kotlin.jvm.internal.f0.o(deviceInfo10, "deviceInfo");
        floatViewVibrateItemView10.O(cFGVibrateItem10, deviceInfo10);
        w7.n0 n0Var22 = this.f15663q;
        if (n0Var22 == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            n0Var22 = null;
        }
        FloatViewVibrateItemView floatViewVibrateItemView11 = n0Var22.f54312j;
        CFGVibrateItem cFGVibrateItem11 = this.f15662p.getKeys().get(1);
        kotlin.jvm.internal.f0.o(cFGVibrateItem11, "vibrateConfig.keys[1]");
        GamepadInfo deviceInfo11 = this.f56484g;
        kotlin.jvm.internal.f0.o(deviceInfo11, "deviceInfo");
        floatViewVibrateItemView11.O(cFGVibrateItem11, deviceInfo11);
        w7.n0 n0Var23 = this.f15663q;
        if (n0Var23 == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
        } else {
            n0Var = n0Var23;
        }
        FloatViewVibrateItemView floatViewVibrateItemView12 = n0Var.f54313k;
        CFGVibrateItem cFGVibrateItem12 = this.f15662p.getKeys().get(2);
        kotlin.jvm.internal.f0.o(cFGVibrateItem12, "vibrateConfig.keys[2]");
        GamepadInfo deviceInfo12 = this.f56484g;
        kotlin.jvm.internal.f0.o(deviceInfo12, "deviceInfo");
        floatViewVibrateItemView12.O(cFGVibrateItem12, deviceInfo12);
    }

    @tt.l(threadMode = ThreadMode.MAIN)
    public final void onEvent(@yt.k BluetoothDeviceOperateEvent event) {
        kotlin.jvm.internal.f0.p(event, "event");
        byte[] bArr = event.value;
        kotlin.jvm.internal.f0.o(bArr, "event.value");
        K(bArr);
    }

    @Override // y7.b
    @yt.l
    public WindowManager.LayoutParams p() {
        WindowManager.LayoutParams layoutParamsH = n8.b.h(1);
        layoutParamsH.gravity = 17;
        return layoutParamsH;
    }
}
