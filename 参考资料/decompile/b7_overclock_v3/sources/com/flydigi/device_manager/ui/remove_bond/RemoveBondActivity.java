package com.flydigi.device_manager.ui.remove_bond;

import android.content.Intent;
import android.os.Bundle;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.flydigi.base.common.p;
import com.flydigi.data.DataConstant;
import com.flydigi.device_manager.R;
import g.p0;
import i9.a;

/* JADX INFO: loaded from: classes7.dex */
@Route(path = a.d.f31951g)
public class RemoveBondActivity extends p {
    @Override // com.flydigi.base.common.p
    public int f4() {
        return R.layout.activity_fragment_with_toolbar;
    }

    @Override // com.flydigi.base.common.p, com.flydigi.base.common.c, ch.a, androidx.fragment.app.g, androidx.activity.ComponentActivity, f0.l, android.app.Activity
    public void onCreate(@p0 Bundle bundle) {
        super.onCreate(bundle);
        e4();
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("key_device_code");
        boolean booleanExtra = intent.getBooleanExtra(DataConstant.DEVICE_KEY_REMOVE_BOND_WHEN_UPGRADE_FIRMWARE, false);
        if (booleanExtra) {
            this.C1.setText(R.string.device_upgrade_ready);
        } else {
            this.C1.setText(R.string.device_go_cancel_match);
        }
        if (a4(RemoveBondFragment.class.getSimpleName()) == null) {
            o5.a.m(n3(), RemoveBondFragment.d6(stringExtra, booleanExtra), RemoveBondFragment.class.getSimpleName(), R.id.fl_container);
        }
    }
}
