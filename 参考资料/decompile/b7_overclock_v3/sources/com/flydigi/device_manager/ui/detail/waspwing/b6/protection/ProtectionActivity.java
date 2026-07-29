package com.flydigi.device_manager.ui.detail.waspwing.b6.protection;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import c7.i;
import com.flydigi.base.common.p;
import com.flydigi.device_manager.R;
import com.flydigi.device_manager.ui.detail.waspwing.b6.protection.ProtectionActivity;
import hk.m;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import o5.c;
import t9.j;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes7.dex */
public final class ProtectionActivity extends p {

    @k
    public static final a E7 = new a(null);

    @k
    public static final String F7 = "key_device_code";

    @k
    public static final String G7 = "key_cold_protection";

    @k
    public static final String H7 = "key_cold_protection_shown";
    public i K2;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @m
        @k
        public final Intent a(@k Context context, @k String deviceCode, boolean z10, boolean z11) {
            f0.p(context, "context");
            f0.p(deviceCode, "deviceCode");
            Intent intent = new Intent(context, (Class<?>) ProtectionActivity.class);
            intent.putExtra("key_device_code", deviceCode);
            intent.putExtra(ProtectionActivity.G7, z10);
            intent.putExtra(ProtectionActivity.H7, z11);
            return intent;
        }
    }

    @m
    @k
    public static final Intent k4(@k Context context, @k String str, boolean z10, boolean z11) {
        return E7.a(context, str, z10, z11);
    }

    public static final void l4(CompoundButton compoundButton, boolean z10) {
        j.w(j.f50990a, Boolean.valueOf(z10), null, 2, null);
    }

    @Override // com.flydigi.base.common.p
    public int f4() {
        return R.layout.device_activity_waspwing_protection;
    }

    @Override // com.flydigi.base.common.p, com.flydigi.base.common.c, ch.a, androidx.fragment.app.g, androidx.activity.ComponentActivity, f0.l, android.app.Activity
    public void onCreate(@l Bundle bundle) {
        super.onCreate(bundle);
        e4();
        this.C1.setText(R.string.device_title_waspwing_protection);
        i iVar = this.K2;
        i iVar2 = null;
        if (iVar == null) {
            f0.S("binding");
            iVar = null;
        }
        iVar.f10095c.setChecked(getIntent().getBooleanExtra(G7, false));
        i iVar3 = this.K2;
        if (iVar3 == null) {
            f0.S("binding");
            iVar3 = null;
        }
        iVar3.f10095c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: h7.a
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                ProtectionActivity.l4(compoundButton, z10);
            }
        });
        if (getIntent().getBooleanExtra(H7, false)) {
            i iVar4 = this.K2;
            if (iVar4 == null) {
                f0.S("binding");
                iVar4 = null;
            }
            LinearLayout linearLayout = iVar4.f10094b;
            f0.o(linearLayout, "binding.areaColdProtection");
            c.b(linearLayout, Boolean.TRUE, false, 2, null);
        }
        i iVar5 = this.K2;
        if (iVar5 == null) {
            f0.S("binding");
        } else {
            iVar2 = iVar5;
        }
        TextView textView = iVar2.f10096d;
        int i10 = R.string.device_waspwing_protection_hot_desc;
        Object[] objArr = new Object[1];
        objArr[0] = getString((f0.g(getIntent().getStringExtra("key_device_code"), t9.c.f50958g) || f0.g(getIntent().getStringExtra("key_device_code"), t9.c.f50960i)) ? R.string.device_waspwing_protection_hot_desc_red : (f0.g(getIntent().getStringExtra("key_device_code"), t9.c.f50957f) || f0.g(getIntent().getStringExtra("key_device_code"), t9.c.f50959h)) ? R.string.device_waspwing_protection_hot_desc_blue : R.string.device_title_waspwing_led);
        textView.setText(getString(i10, objArr));
    }

    @Override // androidx.appcompat.app.f, androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(int i10) {
        i iVarC = i.c(getLayoutInflater());
        f0.o(iVarC, "inflate(layoutInflater)");
        this.K2 = iVarC;
        if (iVarC == null) {
            f0.S("binding");
            iVarC = null;
        }
        setContentView(iVarC.getRoot());
    }
}
