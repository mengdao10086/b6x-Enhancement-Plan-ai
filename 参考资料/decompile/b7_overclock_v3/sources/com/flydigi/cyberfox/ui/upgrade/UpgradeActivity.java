package com.flydigi.cyberfox.ui.upgrade;

import android.os.Bundle;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.blankj.utilcode.util.d0;
import com.flydigi.cyberfox.R;
import com.flydigi.cyberfox.ui.upgrade.h1.UpgradeFragment;
import com.flydigi.data.DataConstant;
import com.flydigi.data.bean.FirmwareInfoBean;
import com.flydigi.sdk.headset.HeadsetInfo;
import i9.a;
import kotlin.jvm.internal.f0;

/* JADX INFO: loaded from: classes7.dex */
@Route(path = a.c.f31943b)
public final class UpgradeActivity extends com.flydigi.base.common.p {

    @hk.e
    @yt.l
    @Autowired(name = "key_device_info")
    public HeadsetInfo E7;

    @hk.e
    @yt.l
    @Autowired(name = DataConstant.DEVICE_KEY_FIRMWARE_INFO)
    public FirmwareInfoBean F7;

    @hk.e
    @Autowired(name = "key_device_code", required = true)
    @yt.k
    public String K2 = "all";

    @Override // com.flydigi.base.common.p
    public int f4() {
        return R.layout.activity_fragment_with_toolbar;
    }

    @Override // com.flydigi.base.common.p, com.flydigi.base.common.c, ch.a, androidx.fragment.app.g, androidx.activity.ComponentActivity, f0.l, android.app.Activity
    public void onCreate(@yt.l Bundle bundle) {
        super.onCreate(bundle);
        h3.a.j().l(this);
        e4();
        this.C1.setText(R.string.cf_fragment_detail_headset_firmware_upgrade);
        String str = this.K2;
        if (f0.g(str, q9.c.f47168e)) {
            d0.v0(n3(), FirmwareDetailFragment.f14261u8.a(this.K2, this.E7, this.F7), R.id.fl_container);
        } else if (f0.g(str, q9.c.f47166c)) {
            d0.v0(n3(), UpgradeFragment.E8.a(), R.id.fl_container);
        } else {
            finish();
        }
    }
}
