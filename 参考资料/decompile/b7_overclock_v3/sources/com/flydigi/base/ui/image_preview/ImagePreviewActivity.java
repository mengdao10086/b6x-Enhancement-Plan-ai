package com.flydigi.base.ui.image_preview;

import android.os.Build;
import android.os.Bundle;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.flydigi.base.R;
import com.flydigi.base.common.p;
import g.p0;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
@Route(path = i9.a.f31901c)
public class ImagePreviewActivity extends p {
    public static final String F7 = "main_image_urls";
    public static final String G7 = "main_image_current_position";

    @Autowired(name = "main_image_current_position")
    public int E7;

    @Autowired(name = "main_image_urls")
    public ArrayList<PreviewBean> K2;

    @Override // com.flydigi.base.common.p
    public int f4() {
        return R.layout.activity_fragment;
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.activity_scale_fade_in, R.anim.activity_scale_fade_out);
    }

    @Override // com.flydigi.base.common.p
    public void h4() {
        ku.b.g(this);
    }

    @Override // com.flydigi.base.common.p, com.flydigi.base.common.c, ch.a, androidx.fragment.app.g, androidx.activity.ComponentActivity, f0.l, android.app.Activity
    public void onCreate(@p0 Bundle bundle) {
        if (Build.VERSION.SDK_INT != 26) {
            setRequestedOrientation(1);
        }
        com.blankj.utilcode.util.f.D(this, 0);
        super.onCreate(bundle);
        h3.a.j().l(this);
        if (getIntent() != null) {
            this.K2 = (ArrayList) getIntent().getSerializableExtra("main_image_urls");
            this.E7 = getIntent().getIntExtra("main_image_current_position", 0);
            ArrayList<PreviewBean> arrayList = this.K2;
            if (arrayList == null || arrayList.size() <= 0) {
                d4();
            }
        } else {
            d4();
        }
        if (a4(ImagePreviewFragment.class.getSimpleName()) == null) {
            o5.a.m(n3(), ImagePreviewFragment.f6(this.K2, this.E7), ImagePreviewFragment.class.getSimpleName(), R.id.fl_container);
        }
    }
}
