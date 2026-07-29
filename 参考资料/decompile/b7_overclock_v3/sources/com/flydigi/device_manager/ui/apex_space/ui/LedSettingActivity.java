package com.flydigi.device_manager.ui.apex_space.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import c7.e;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.blankj.utilcode.util.d0;
import com.blankj.utilcode.util.f;
import com.blankj.utilcode.util.o;
import com.flydigi.base.common.p;
import com.flydigi.device_manager.R;
import com.flydigi.device_manager.ui.apex_space.ui.LedSettingActivity;
import h0.d;
import i9.a;
import kotlin.jvm.internal.f0;
import ku.b;
import top.androidman.SuperButton;
import yt.l;

/* JADX INFO: loaded from: classes7.dex */
@Route(path = a.d.f31956l)
public final class LedSettingActivity extends p {

    @l
    public LedSettingFragment E7;
    public e K2;

    public static final void m4(LedSettingActivity this$0, View view) {
        f0.p(this$0, "this$0");
        this$0.finish();
    }

    public static final void n4(LedSettingActivity this$0, View view) {
        f0.p(this$0, "this$0");
        LedSettingFragment ledSettingFragment = this$0.E7;
        if (ledSettingFragment != null) {
            ledSettingFragment.E7(true);
        }
    }

    public static final void o4(LedSettingActivity this$0) {
        f0.p(this$0, "this$0");
        b.h(this$0, true);
    }

    @Override // com.flydigi.base.common.p
    public int f4() {
        return R.layout.device_activity_led_setting;
    }

    @Override // com.flydigi.base.common.p
    public void h4() {
        c4().e(new Runnable() { // from class: e7.c
            @Override // java.lang.Runnable
            public final void run() {
                LedSettingActivity.o4(this.f26697a);
            }
        });
    }

    @Override // com.flydigi.base.common.p, com.flydigi.base.common.c, ch.a, androidx.fragment.app.g, androidx.activity.ComponentActivity, f0.l, android.app.Activity
    public void onCreate(@l Bundle bundle) {
        super.onCreate(bundle);
        e eVar = this.K2;
        e eVar2 = null;
        if (eVar == null) {
            f0.S("viewBinding");
            eVar = null;
        }
        eVar.getRoot().setPadding(0, f.k(), 0, 0);
        e eVar3 = this.K2;
        if (eVar3 == null) {
            f0.S("viewBinding");
            eVar3 = null;
        }
        SuperButton superButton = eVar3.f9947c;
        int i10 = R.color.color_white;
        superButton.setIconColor(d.f(this, i10));
        e eVar4 = this.K2;
        if (eVar4 == null) {
            f0.S("viewBinding");
            eVar4 = null;
        }
        o.r(eVar4.f9947c, new View.OnClickListener() { // from class: e7.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LedSettingActivity.m4(this.f26696a, view);
            }
        });
        e eVar5 = this.K2;
        if (eVar5 == null) {
            f0.S("viewBinding");
            eVar5 = null;
        }
        eVar5.f9946b.setIconColor(d.f(this, i10));
        e eVar6 = this.K2;
        if (eVar6 == null) {
            f0.S("viewBinding");
        } else {
            eVar2 = eVar6;
        }
        o.r(eVar2.f9946b, new View.OnClickListener() { // from class: e7.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LedSettingActivity.n4(this.f26695a, view);
            }
        });
        if (d0.B(n3(), LedSettingFragment.class.getSimpleName()) == null) {
            LedSettingFragment ledSettingFragmentA = LedSettingFragment.K8.a();
            this.E7 = ledSettingFragmentA;
            d0.v0(n3(), ledSettingFragmentA, R.id.fl_container);
        }
    }

    @Override // androidx.appcompat.app.f, androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(int i10) {
        e eVarC = e.c(LayoutInflater.from(this));
        f0.o(eVarC, "inflate(LayoutInflater.from(this))");
        this.K2 = eVarC;
        if (eVarC == null) {
            f0.S("viewBinding");
            eVarC = null;
        }
        super.setContentView(eVarC.getRoot());
    }
}
