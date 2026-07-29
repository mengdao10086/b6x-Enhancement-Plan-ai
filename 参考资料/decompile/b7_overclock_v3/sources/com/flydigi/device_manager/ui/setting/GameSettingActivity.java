package com.flydigi.device_manager.ui.setting;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.blankj.utilcode.util.d0;
import com.flydigi.base.common.p;
import com.flydigi.device_manager.R;
import g.p0;
import i9.a;

/* JADX INFO: loaded from: classes7.dex */
@Route(path = a.d.f31957m)
public class GameSettingActivity extends p {
    @Override // com.flydigi.base.common.p
    public int f4() {
        return R.layout.activity_fragment_with_toolbar;
    }

    @Override // com.flydigi.base.common.p, com.flydigi.base.common.c, ch.a, androidx.fragment.app.g, androidx.activity.ComponentActivity, f0.l, android.app.Activity
    public void onCreate(@p0 Bundle bundle) {
        super.onCreate(bundle);
        e4();
        this.C1.setText(R.string.device_action_title_setting);
        Fragment fragmentB = d0.B(n3(), GameSettingFragment.class.getSimpleName());
        if (fragmentB == null) {
            fragmentB = GameSettingFragment.u7();
        }
        d0.v0(n3(), fragmentB, R.id.fl_container);
    }
}
