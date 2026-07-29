package com.flydigi.device_manager.ui.detail;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.flydigi.data.DataConstant;
import com.flydigi.device_manager.R;
import com.flydigi.sdk.gamepad.GamepadInfo;
import i9.a;

/* JADX INFO: loaded from: classes7.dex */
@Route(path = a.d.f31949e)
public final class DetailActivity extends com.flydigi.base.common.p {

    @hk.e
    @Autowired(name = DataConstant.DEVICE_KEY_AUTO_CONNECT)
    public boolean F7;

    @hk.e
    @Autowired(name = DataConstant.DEVICE_KEY_AUTO_SWITCH_MODE)
    public boolean G7;

    @hk.e
    @yt.l
    @Autowired(name = "key_device_info")
    public GamepadInfo H7;

    @hk.e
    @Autowired(name = "ip_type")
    public int I7;
    public c7.b J7;

    @hk.e
    @Autowired(name = DataConstant.DEVICE_KEY_DEVICE_TYPE)
    public int K2 = 1;

    @hk.e
    @Autowired(name = "key_device_code", required = true)
    @yt.k
    public String E7 = "all";

    public static final void l4(DetailActivity this$0, View view) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        this$0.finish();
    }

    public static final void m4(View view) {
        u9.b.o(1, "外设管理");
    }

    @Override // com.flydigi.base.common.p
    public int f4() {
        return R.layout.device_activity_device_detail;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void n4() {
        /*
            Method dump skipped, instruction units count: 267
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.flydigi.device_manager.ui.detail.DetailActivity.n4():void");
    }

    @Override // com.flydigi.base.common.p, com.flydigi.base.common.c, ch.a, androidx.fragment.app.g, androidx.activity.ComponentActivity, f0.l, android.app.Activity
    public void onCreate(@yt.l Bundle bundle) {
        super.onCreate(bundle);
        h3.a.j().l(this);
        c7.b bVar = this.J7;
        if (bVar == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            bVar = null;
        }
        ImageView imageView = bVar.f9822b;
        Drawable drawable = imageView.getDrawable();
        n0.c.n(drawable, -16777216);
        imageView.setImageDrawable(drawable);
        com.blankj.utilcode.util.o.r(imageView, new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.detail.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DetailActivity.l4(this.f14599a, view);
            }
        });
        c7.b bVar2 = this.J7;
        if (bVar2 == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            bVar2 = null;
        }
        TextView it2 = bVar2.f9823c;
        kotlin.jvm.internal.f0.o(it2, "it");
        o5.c.b(it2, Boolean.valueOf(!kotlin.jvm.internal.f0.g(this.E7, q9.c.f47167d)), false, 2, null);
        com.blankj.utilcode.util.o.r(it2, new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.detail.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DetailActivity.m4(view);
            }
        });
        n4();
    }

    @Override // com.flydigi.base.common.c, androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(@yt.k Intent intent) {
        kotlin.jvm.internal.f0.p(intent, "intent");
        super.onNewIntent(intent);
        this.K2 = intent.getIntExtra(DataConstant.DEVICE_KEY_DEVICE_TYPE, 1);
        String stringExtra = intent.getStringExtra("key_device_code");
        if (stringExtra == null) {
            stringExtra = "all";
        }
        this.E7 = stringExtra;
        this.F7 = intent.getBooleanExtra(DataConstant.DEVICE_KEY_AUTO_CONNECT, false);
        this.G7 = intent.getBooleanExtra(DataConstant.DEVICE_KEY_AUTO_SWITCH_MODE, false);
        this.H7 = (GamepadInfo) intent.getParcelableExtra("key_device_info");
        n4();
    }

    @Override // androidx.appcompat.app.f, androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(int i10) {
        c7.b bVarC = c7.b.c(getLayoutInflater());
        kotlin.jvm.internal.f0.o(bVarC, "inflate(layoutInflater)");
        this.J7 = bVarC;
        if (bVarC == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            bVarC = null;
        }
        setContentView(bVarC.getRoot());
    }
}
