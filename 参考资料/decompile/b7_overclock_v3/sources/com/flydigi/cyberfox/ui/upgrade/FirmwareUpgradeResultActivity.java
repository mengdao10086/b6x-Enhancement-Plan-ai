package com.flydigi.cyberfox.ui.upgrade;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.flydigi.cyberfox.R;
import i9.a;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import top.androidman.SuperButton;

/* JADX INFO: loaded from: classes7.dex */
public final class FirmwareUpgradeResultActivity extends com.flydigi.base.common.p {

    @yt.k
    public static final a G7 = new a(null);

    @yt.k
    public static final String H7 = "key_upgrade_result";

    @yt.k
    public static final String I7 = "key_device_code";
    public boolean E7;

    @yt.l
    public String F7;
    public h6.f K2;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @hk.m
        public final void a(@yt.k Context context, @yt.k String deviceCode, boolean z10) {
            f0.p(context, "context");
            f0.p(deviceCode, "deviceCode");
            context.startActivity(new Intent(context, (Class<?>) FirmwareUpgradeResultActivity.class).putExtra("key_upgrade_result", z10).putExtra("key_device_code", deviceCode));
        }
    }

    @hk.m
    public static final void l4(@yt.k Context context, @yt.k String str, boolean z10) {
        G7.a(context, str, z10);
    }

    public static final void n4(FirmwareUpgradeResultActivity this$0, View view) {
        f0.p(this$0, "this$0");
        this$0.finishAffinity();
    }

    public static final void o4(FirmwareUpgradeResultActivity this$0, View view) {
        f0.p(this$0, "this$0");
        this$0.finishAffinity();
        h3.a.j().d(a.c.f31943b).withString("key_device_code", this$0.F7).navigation();
    }

    @Override // com.flydigi.base.common.p
    public int f4() {
        return R.layout.cf_activity_firmware_upgrade_result;
    }

    public final void m4() {
        h6.f fVar = null;
        if (!this.E7) {
            h6.f fVar2 = this.K2;
            if (fVar2 == null) {
                f0.S("viewBinding");
                fVar2 = null;
            }
            SuperButton superButton = fVar2.f30581c;
            h6.f fVar3 = this.K2;
            if (fVar3 == null) {
                f0.S("viewBinding");
                fVar3 = null;
            }
            superButton.setIcon(h0.d.i(fVar3.f30581c.getContext(), R.drawable.cf_ic_update_fail));
            h6.f fVar4 = this.K2;
            if (fVar4 == null) {
                f0.S("viewBinding");
                fVar4 = null;
            }
            SuperButton superButton2 = fVar4.f30581c;
            h6.f fVar5 = this.K2;
            if (fVar5 == null) {
                f0.S("viewBinding");
                fVar5 = null;
            }
            superButton2.setIconColor(h0.d.f(fVar5.f30581c.getContext(), R.color.colorAccentRed));
            h6.f fVar6 = this.K2;
            if (fVar6 == null) {
                f0.S("viewBinding");
                fVar6 = null;
            }
            fVar6.f30583e.setText(R.string.cf_firmware_upgrade_failed);
            h6.f fVar7 = this.K2;
            if (fVar7 == null) {
                f0.S("viewBinding");
                fVar7 = null;
            }
            TextView textView = fVar7.f30582d;
            h6.f fVar8 = this.K2;
            if (fVar8 == null) {
                f0.S("viewBinding");
                fVar8 = null;
            }
            textView.setTextColor(h0.d.f(fVar8.f30582d.getContext(), R.color.color_000000_a30));
            h6.f fVar9 = this.K2;
            if (fVar9 == null) {
                f0.S("viewBinding");
                fVar9 = null;
            }
            fVar9.f30580b.setText(R.string.retry);
            h6.f fVar10 = this.K2;
            if (fVar10 == null) {
                f0.S("viewBinding");
            } else {
                fVar = fVar10;
            }
            com.blankj.utilcode.util.o.r(fVar.f30580b, new View.OnClickListener() { // from class: com.flydigi.cyberfox.ui.upgrade.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FirmwareUpgradeResultActivity.o4(this.f14279a, view);
                }
            });
            return;
        }
        h6.f fVar11 = this.K2;
        if (fVar11 == null) {
            f0.S("viewBinding");
            fVar11 = null;
        }
        SuperButton superButton3 = fVar11.f30581c;
        h6.f fVar12 = this.K2;
        if (fVar12 == null) {
            f0.S("viewBinding");
            fVar12 = null;
        }
        superButton3.setIcon(h0.d.i(fVar12.f30581c.getContext(), R.drawable.cf_ic_update_success));
        h6.f fVar13 = this.K2;
        if (fVar13 == null) {
            f0.S("viewBinding");
            fVar13 = null;
        }
        SuperButton superButton4 = fVar13.f30581c;
        h6.f fVar14 = this.K2;
        if (fVar14 == null) {
            f0.S("viewBinding");
            fVar14 = null;
        }
        superButton4.setIconColor(h0.d.f(fVar14.f30581c.getContext(), R.color.colorPrimary));
        h6.f fVar15 = this.K2;
        if (fVar15 == null) {
            f0.S("viewBinding");
            fVar15 = null;
        }
        fVar15.f30583e.setText(R.string.cf_firmware_upgrade_success);
        h6.f fVar16 = this.K2;
        if (fVar16 == null) {
            f0.S("viewBinding");
            fVar16 = null;
        }
        TextView textView2 = fVar16.f30582d;
        h6.f fVar17 = this.K2;
        if (fVar17 == null) {
            f0.S("viewBinding");
            fVar17 = null;
        }
        textView2.setTextColor(h0.d.f(fVar17.f30582d.getContext(), R.color.colorAccentRed));
        h6.f fVar18 = this.K2;
        if (fVar18 == null) {
            f0.S("viewBinding");
            fVar18 = null;
        }
        fVar18.f30582d.setText(R.string.cf_firmware_upgrade_success_notice);
        h6.f fVar19 = this.K2;
        if (fVar19 == null) {
            f0.S("viewBinding");
            fVar19 = null;
        }
        fVar19.f30580b.setText(R.string.confirm);
        h6.f fVar20 = this.K2;
        if (fVar20 == null) {
            f0.S("viewBinding");
        } else {
            fVar = fVar20;
        }
        com.blankj.utilcode.util.o.r(fVar.f30580b, new View.OnClickListener() { // from class: com.flydigi.cyberfox.ui.upgrade.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FirmwareUpgradeResultActivity.n4(this.f14280a, view);
            }
        });
    }

    @Override // com.flydigi.base.common.p, com.flydigi.base.common.c, ch.a, androidx.fragment.app.g, androidx.activity.ComponentActivity, f0.l, android.app.Activity
    public void onCreate(@yt.l Bundle bundle) {
        super.onCreate(bundle);
        this.E7 = getIntent().getBooleanExtra("key_upgrade_result", false);
        this.F7 = getIntent().getStringExtra("key_device_code");
        e4();
        androidx.appcompat.app.a aVarI3 = I3();
        if (aVarI3 != null) {
            aVarI3.Y(false);
        }
        androidx.appcompat.app.a aVarI32 = I3();
        if (aVarI32 != null) {
            aVarI32.d0(false);
        }
        this.C1.setText(R.string.cf_fragment_detail_headset_firmware_upgrade);
        m4();
    }

    @Override // androidx.appcompat.app.f, androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(int i10) {
        h6.f fVarC = h6.f.c(getLayoutInflater());
        f0.o(fVarC, "inflate(layoutInflater)");
        this.K2 = fVarC;
        if (fVarC == null) {
            f0.S("viewBinding");
            fVarC = null;
        }
        setContentView(fVarC.getRoot());
    }
}
