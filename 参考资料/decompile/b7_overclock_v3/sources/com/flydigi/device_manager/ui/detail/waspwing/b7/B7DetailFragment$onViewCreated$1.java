package com.flydigi.device_manager.ui.detail.waspwing.b7;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.fragment.app.DialogFragment;
import c7.e0;
import com.blankj.utilcode.util.n0;
import com.flydigi.base.widget.action_item.ActionItemNormal;
import com.flydigi.device_manager.R;
import com.flydigi.device_manager.ui.detail.waspwing.IntroductionDialogFragment;
import com.flydigi.device_manager.ui.detail.waspwing.b6.ProtectionAlertDialogFragment;
import com.flydigi.sdk.waspwing.WaspWingInfo;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import kotlin.z1;

/* JADX INFO: loaded from: classes7.dex */
public final class B7DetailFragment$onViewCreated$1 extends Lambda implements ik.l<WaspWingInfo, z1> {
    public final /* synthetic */ B7DetailFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public B7DetailFragment$onViewCreated$1(B7DetailFragment b7DetailFragment) {
        super(1);
        this.this$0 = b7DetailFragment;
    }

    public static final void f(B7DetailFragment this$0, View view) {
        f0.p(this$0, "this$0");
        IntroductionDialogFragment.a aVar = IntroductionDialogFragment.I8;
        String strC3 = this$0.c3(R.string.device_overclock_function);
        f0.o(strC3, "getString(R.string.device_overclock_function)");
        String strC32 = this$0.c3(R.string.device_overclock_function_title);
        String strC33 = this$0.c3(R.string.device_overclock_function_content);
        f0.o(strC33, "getString(R.string.devic…erclock_function_content)");
        aVar.a(strC3, CollectionsKt__CollectionsKt.r(new IntroductionDialogFragment.Introduction(strC32, strC33))).Z5(this$0.U1(), "introduction");
    }

    public final void d(WaspWingInfo it2) {
        int ipType = it2.getIpType();
        if (!n0.b(this.this$0.f14707o8, it2.getDeviceCode()) || this.this$0.f14708p8 != ipType) {
            this.this$0.f14708p8 = ipType;
            this.this$0.f14707o8 = it2.getDeviceCode();
            this.this$0.C6();
        }
        boolean z10 = false;
        e0 e0Var = null;
        if (!it2.isConnected()) {
            e0 e0Var2 = this.this$0.f14711s8;
            if (e0Var2 == null) {
                f0.S("viewBinding");
                e0Var2 = null;
            }
            LinearLayout linearLayout = e0Var2.f9958j;
            f0.o(linearLayout, "viewBinding.areaFunction");
            o5.c.b(linearLayout, Boolean.FALSE, false, 2, null);
            this.this$0.G6();
            return;
        }
        this.this$0.E6();
        e0 e0Var3 = this.this$0.f14711s8;
        if (e0Var3 == null) {
            f0.S("viewBinding");
            e0Var3 = null;
        }
        ActionItemNormal actionItemNormal = e0Var3.f9953e;
        Drawable drawableG = j0.i.g(this.this$0.V2(), R.drawable.ic_help, null);
        if (drawableG != null) {
            drawableG.setTint(Color.parseColor("#9a9a9a"));
        } else {
            drawableG = null;
        }
        final B7DetailFragment b7DetailFragment = this.this$0;
        actionItemNormal.P(drawableG, new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.detail.waspwing.b7.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                B7DetailFragment$onViewCreated$1.f(b7DetailFragment, view);
            }
        });
        e0 e0Var4 = this.this$0.f14711s8;
        if (e0Var4 == null) {
            f0.S("viewBinding");
            e0Var4 = null;
        }
        RunModeItem runModeItem = e0Var4.f9955g;
        f0.o(it2, "it");
        runModeItem.setDeviceInfo(it2);
        e0 e0Var5 = this.this$0.f14711s8;
        if (e0Var5 == null) {
            f0.S("viewBinding");
            e0Var5 = null;
        }
        e0Var5.f9952d.Q(n.a(it2));
        e0 e0Var6 = this.this$0.f14711s8;
        if (e0Var6 == null) {
            f0.S("viewBinding");
            e0Var6 = null;
        }
        e0Var6.f9956h.Q(it2.getTemperature() + " ℃");
        if (it2.getOverClockUsable()) {
            e0 e0Var7 = this.this$0.f14711s8;
            if (e0Var7 == null) {
                f0.S("viewBinding");
                e0Var7 = null;
            }
            e0Var7.f9953e.S(this.this$0.c3(R.string.wasping_overclock_useable), 0, h0.d.f(this.this$0.R4(), R.color.colorAccentGreen));
        } else {
            e0 e0Var8 = this.this$0.f14711s8;
            if (e0Var8 == null) {
                f0.S("viewBinding");
                e0Var8 = null;
            }
            e0Var8.f9953e.S(this.this$0.c3(R.string.device_wasping_overclock_unuseable), 0, h0.d.f(this.this$0.R4(), R.color.colorAccentRed));
        }
        e0 e0Var9 = this.this$0.f14711s8;
        if (e0Var9 == null) {
            f0.S("viewBinding");
        } else {
            e0Var = e0Var9;
        }
        ImageView imageView = e0Var.f9962n;
        f0.o(imageView, "viewBinding.ivDeviceBg");
        o5.c.a(imageView, Boolean.valueOf(this.this$0.f14708p8 != 0), false);
        if (!it2.getHotProtectionEnabled() && !it2.getColdProtectionEnabled()) {
            DialogFragment dialogFragment = this.this$0.f14714v8;
            if (dialogFragment != null) {
                dialogFragment.H5();
                return;
            }
            return;
        }
        DialogFragment dialogFragment2 = this.this$0.f14714v8;
        if (dialogFragment2 != null && dialogFragment2.C3()) {
            z10 = true;
        }
        if (z10) {
            return;
        }
        DialogFragment dialogFragmentA = ProtectionAlertDialogFragment.F8.a(this.this$0.f14707o8, it2.getColdProtectionEnabled() ? 1 : 2);
        B7DetailFragment b7DetailFragment2 = this.this$0;
        b7DetailFragment2.f14714v8 = dialogFragmentA;
        o5.a.t0(b7DetailFragment2.L2(), dialogFragmentA);
    }

    @Override // ik.l
    public /* bridge */ /* synthetic */ z1 i(WaspWingInfo waspWingInfo) {
        d(waspWingInfo);
        return z1.f38230a;
    }
}
