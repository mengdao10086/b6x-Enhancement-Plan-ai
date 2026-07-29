package com.flydigi.web;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.blankj.utilcode.util.NetworkUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.blankj.utilcode.util.d0;
import com.blankj.utilcode.util.n0;
import com.flydigi.base.common.o;
import com.flydigi.base.common.p;
import com.flydigi.data.DataConstant;
import com.flydigi.data.R;
import com.flydigi.web.WebFragment;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import u9.f;

/* JADX INFO: loaded from: classes3.dex */
@Route(path = i9.a.f31902d)
public class WebActivity extends p implements WebFragment.d {

    @Autowired(name = DataConstant.WEB_TITLE)
    public String E7;
    public String F7;
    public Bitmap G7;

    @Autowired(name = DataConstant.WEB_URL)
    public String K2;

    public class a implements UMShareListener {
        public a() {
        }

        @Override // com.umeng.socialize.UMShareListener
        public void onCancel(SHARE_MEDIA share_media) {
        }

        @Override // com.umeng.socialize.UMShareListener
        public void onError(SHARE_MEDIA share_media, Throwable throwable) {
            ToastUtils.T(R.string.community_share_failed);
        }

        @Override // com.umeng.socialize.UMShareListener
        public void onResult(SHARE_MEDIA share_media) {
            ToastUtils.T(R.string.community_share_success);
            WebFragment webFragment = (WebFragment) WebActivity.this.a4(WebFragment.class.getSimpleName());
            if (webFragment == null) {
                d0.v0(WebActivity.this.n3(), WebFragment.f6(WebActivity.this.K2, "share"), R.id.fl_container);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString(DataConstant.WEB_URL, WebActivity.this.K2);
            bundle.putString(WebFragment.f16417w8, "share");
            webFragment.c5(bundle);
            webFragment.j6();
        }

        @Override // com.umeng.socialize.UMShareListener
        public void onStart(SHARE_MEDIA share_media) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m4(View view) {
        o4();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n4(View view) {
        onBackPressed();
    }

    @Override // com.flydigi.web.WebFragment.d
    public void C(Bitmap icon) {
        this.G7 = icon;
    }

    @Override // com.flydigi.base.common.p
    public int f4() {
        return R.layout.base_activity_web;
    }

    public final void o4() {
        if (NetworkUtils.K()) {
            f.c(this, this.K2, this.F7, "", this.G7, new a());
        } else {
            o.E(getString(R.string.net_state_error));
        }
    }

    @Override // com.flydigi.base.common.p, com.flydigi.base.common.c, ch.a, androidx.fragment.app.g, androidx.activity.ComponentActivity, f0.l, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        h3.a.j().l(this);
        getWindow().setFormat(-3);
        this.C1 = (TextView) findViewById(R.id.tv_title_toolbar);
        try {
            getWindow().setFlags(16777216, 16777216);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        if (n0.x(this.E7)) {
            this.C1.setText(this.E7);
        }
        if (a4(WebFragment.class.getSimpleName()) == null) {
            d0.v0(n3(), WebFragment.e6(this.K2), R.id.fl_container);
        }
        com.blankj.utilcode.util.o.r(findViewById(R.id.btn_share), new View.OnClickListener() { // from class: v9.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f52802a.m4(view);
            }
        });
        com.blankj.utilcode.util.o.r(findViewById(R.id.btn_close), new View.OnClickListener() { // from class: v9.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f52803a.n4(view);
            }
        });
    }

    @Override // com.flydigi.base.common.c, androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(final Intent intent) {
        super.onNewIntent(intent);
        WebFragment webFragment = (WebFragment) a4(WebFragment.class.getSimpleName());
        if (webFragment == null) {
            d0.v0(n3(), WebFragment.e6(this.K2), R.id.fl_container);
        } else {
            Bundle bundle = new Bundle();
            bundle.putAll(intent.getExtras());
            webFragment.c5(bundle);
            webFragment.j6();
        }
    }

    @Override // com.flydigi.web.WebFragment.d
    public void t1(String title) {
        this.F7 = title;
        if (n0.m(this.E7)) {
            this.C1.setText(title);
        }
    }
}
