package com.flydigi.device_manager.ui;

import android.os.Bundle;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.blankj.utilcode.util.d0;
import com.flydigi.data.DataConstant;
import com.flydigi.device_manager.R;
import i9.a;
import kotlin.jvm.internal.f0;

/* JADX INFO: loaded from: classes7.dex */
@Route(path = a.d.f31959o)
public final class OpenFloatWindowNoticeActivity extends com.flydigi.base.common.p {

    @hk.e
    @Autowired(name = DataConstant.DEVICE_KEY_CAN_JUMP)
    public boolean K2;

    @Override // com.flydigi.base.common.p
    public int f4() {
        return R.layout.activity_fragment_with_toolbar;
    }

    @Override // com.flydigi.base.common.p, com.flydigi.base.common.c, ch.a, androidx.fragment.app.g, androidx.activity.ComponentActivity, f0.l, android.app.Activity
    public void onCreate(@yt.l Bundle bundle) {
        super.onCreate(bundle);
        h3.a.j().l(this);
        e4();
        if (I3() != null) {
            androidx.appcompat.app.a aVarI3 = I3();
            f0.m(aVarI3);
            aVarI3.Y(false);
        }
        this.C1.setText(R.string.device_open_float_window);
        if (a4(OpenFloatWindowNoticeFragment.class.getName()) == null) {
            d0.v0(n3(), OpenFloatWindowNoticeFragment.f14485r8.a(this.K2), R.id.fl_container);
        }
    }
}
