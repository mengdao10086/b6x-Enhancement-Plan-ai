package com.flydigi.device_manager.ui.detail.waspwing.b6.more;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.blankj.utilcode.util.d0;
import com.flydigi.base.common.p;
import com.flydigi.device_manager.R;
import com.flydigi.device_manager.ui.detail.waspwing.b6.more.AppearanceSettingFragment;
import com.flydigi.device_manager.ui.detail.waspwing.b6.more.MoreSettingFragment;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes7.dex */
public final class MoreSettingActivity extends p implements MoreSettingFragment.b {

    @k
    public static final String E7 = "key_device_id";

    @k
    public static final a K2 = new a(null);

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @k
        public final Intent a(@k Context context, int i10) {
            f0.p(context, "context");
            Intent intent = new Intent(context, (Class<?>) MoreSettingActivity.class);
            intent.putExtra(MoreSettingActivity.E7, i10);
            return intent;
        }
    }

    @Override // com.flydigi.base.common.p
    public int f4() {
        return R.layout.activity_fragment_with_toolbar;
    }

    @Override // com.flydigi.base.common.p, com.flydigi.base.common.c, ch.a, androidx.fragment.app.g, androidx.activity.ComponentActivity, f0.l, android.app.Activity
    public void onCreate(@l Bundle bundle) {
        super.onCreate(bundle);
        e4();
        FragmentManager fragmentManagerN3 = n3();
        int i10 = R.id.fl_container;
        Fragment fragmentR0 = fragmentManagerN3.r0(i10);
        if (fragmentR0 == null) {
            fragmentR0 = MoreSettingFragment.f14693q8.a();
        }
        d0.v0(n3(), fragmentR0, i10);
    }

    @Override // com.flydigi.device_manager.ui.detail.waspwing.b6.more.MoreSettingFragment.b
    public void w0() {
        FragmentManager fragmentManagerN3 = n3();
        AppearanceSettingFragment.a aVar = AppearanceSettingFragment.f14689q8;
        Intent intent = getIntent();
        d0.v0(fragmentManagerN3, aVar.a(intent != null ? intent.getIntExtra(E7, -1) : -1), R.id.fl_container);
    }

    @Override // com.flydigi.base.common.c, androidx.fragment.app.g
    public void w3(@k Fragment fragment) {
        f0.p(fragment, "fragment");
        super.w3(fragment);
        if (fragment instanceof MoreSettingFragment) {
            this.C1.setText(R.string.device_title_more_setting);
        } else if (fragment instanceof AppearanceSettingFragment) {
            this.C1.setText(R.string.device_title_setting_appearance);
        }
    }
}
