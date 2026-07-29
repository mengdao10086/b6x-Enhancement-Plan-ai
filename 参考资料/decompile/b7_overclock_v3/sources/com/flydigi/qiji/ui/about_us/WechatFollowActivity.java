package com.flydigi.qiji.ui.about_us;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.fdg.flashplay.farsef.R;
import com.flydigi.base.common.o;
import com.flydigi.base.common.p;
import i9.a;
import kotlin.jvm.internal.f0;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes3.dex */
@Route(path = a.f.f31973b)
public final class WechatFollowActivity extends p {
    public final void doFollow(@k View view) {
        f0.p(view, "view");
        if (o5.p.a(this, getString(R.string.app_name))) {
            Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage("com.tencent.mm");
            if (launchIntentForPackage == null) {
                o.E(getString(R.string.account_third_wechat_error));
            } else {
                launchIntentForPackage.setFlags(268435456);
                com.blankj.utilcode.util.a.O0(launchIntentForPackage);
            }
        }
    }

    @Override // com.flydigi.base.common.p
    public int f4() {
        return R.layout.main_activity_wechat_follow;
    }

    @Override // com.flydigi.base.common.p, com.flydigi.base.common.c, ch.a, androidx.fragment.app.g, androidx.activity.ComponentActivity, f0.l, android.app.Activity
    public void onCreate(@l Bundle bundle) {
        super.onCreate(bundle);
        e4();
        this.C1.setText("关注公众号");
    }
}
