package com.flydigi.device_manager.ui.mapping_test;

import android.os.Bundle;
import android.view.MotionEvent;
import androidx.fragment.app.Fragment;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.blankj.utilcode.util.d0;
import com.flydigi.base.common.p;
import com.flydigi.baseProvider.IRemoteProvider;
import com.flydigi.data.DataConstant;
import com.flydigi.device_manager.R;
import com.flydigi.sdk.gamepad.GamepadInfo;
import com.umeng.analytics.pro.an;
import g.p0;
import hk.e;
import i9.a;
import java.util.HashMap;
import nl.b;
import u9.g;

/* JADX INFO: loaded from: classes7.dex */
@Route(path = a.d.f31954j)
public class KeyMappingTestActivity extends p {

    @e
    @Autowired(name = "key_device_code")
    public String E7 = "all";

    @e
    @Autowired(name = "key_device_info")
    public GamepadInfo F7;
    public KeyMappingTestFragment K2;

    @Override // com.flydigi.base.common.p
    public int f4() {
        return R.layout.activity_fragment;
    }

    @Override // com.flydigi.base.common.p, com.flydigi.base.common.c, ch.a, androidx.fragment.app.g, androidx.activity.ComponentActivity, f0.l, android.app.Activity
    public void onCreate(@p0 Bundle bundle) {
        Fragment fragmentE6;
        b.l().i(this);
        super.onCreate(bundle);
        h3.a.j().l(this);
        ((IRemoteProvider) h3.a.j().d(a.g.f31983b).navigation()).l(H1(), DataConstant.REMOTE_ACTION_START_TEST_KEYMAPPING_UI);
        String str = this.E7;
        str.hashCode();
        Fragment fragmentA = !str.equals(a5.a.f247c) ? !str.equals(a5.a.f248d) ? d0.A(n3(), KeyMappingTestFragment.class) : d0.A(n3(), ShadowStingerTestFragment.class) : d0.A(n3(), StingerTestFragment.class);
        HashMap map = new HashMap();
        map.put(an.f23207ai, this.E7);
        g.a().e(this, "KeyMapping_Test_Visit", map);
        if (fragmentA != null) {
            if (fragmentA instanceof KeyMappingTestFragment) {
                this.K2 = (KeyMappingTestFragment) fragmentA;
                return;
            } else {
                this.K2 = null;
                return;
            }
        }
        String str2 = this.E7;
        str2.hashCode();
        if (str2.equals(a5.a.f247c)) {
            fragmentE6 = StingerTestFragment.e6();
        } else if (str2.equals(a5.a.f248d)) {
            fragmentE6 = ShadowStingerTestFragment.e6();
        } else {
            KeyMappingTestFragment keyMappingTestFragmentQ7 = KeyMappingTestFragment.q7(this.F7);
            this.K2 = keyMappingTestFragmentQ7;
            fragmentE6 = keyMappingTestFragmentQ7;
        }
        d0.v0(n3(), fragmentE6, R.id.fl_container);
    }

    @Override // com.flydigi.base.common.p, com.flydigi.base.common.c, ch.a, androidx.appcompat.app.f, androidx.fragment.app.g, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ((IRemoteProvider) h3.a.j().d(a.g.f31983b).navigation()).l(H1(), DataConstant.REMOTE_ACTION_END_TEST_KEYMAPPING);
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        KeyMappingTestFragment keyMappingTestFragment = this.K2;
        if (keyMappingTestFragment != null) {
            keyMappingTestFragment.r7(motionEvent, findViewById(R.id.fl_container));
        }
        return super.onTouchEvent(motionEvent);
    }
}
