package com.flydigi.qiji.ui.contact_us;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.blankj.utilcode.util.d0;
import com.fdg.flashplay.farsef.R;
import com.flydigi.base.common.p;
import i9.a;
import yt.l;

/* JADX INFO: loaded from: classes3.dex */
@Route(path = a.i.f31988c)
public final class ContactUsActivity extends p {
    @Override // com.flydigi.base.common.p
    public int f4() {
        return R.layout.activity_fragment_with_toolbar;
    }

    @Override // com.flydigi.base.common.p, com.flydigi.base.common.c, ch.a, androidx.fragment.app.g, androidx.activity.ComponentActivity, f0.l, android.app.Activity
    public void onCreate(@l Bundle bundle) {
        super.onCreate(bundle);
        e4();
        this.C1.setText(R.string.app_action_title_contact_us);
        Fragment fragmentA = d0.A(n3(), ContactUsFragment.class);
        if (fragmentA == null) {
            fragmentA = ContactUsFragment.f16099o8.a();
        }
        d0.v0(n3(), fragmentA, R.id.fl_container);
    }
}
