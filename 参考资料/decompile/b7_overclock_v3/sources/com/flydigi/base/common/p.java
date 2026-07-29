package com.flydigi.base.common;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.flydigi.base.R;
import com.flydigi.base.widget.LoadingDialogFragment;
import com.google.android.material.appbar.AppBarLayout;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.socialize.UMShareAPI;
import g.i0;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
public abstract class p extends c implements u {
    public static final String C2 = "key_result_data";
    public TextView C1;
    public AppBarLayout K1;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public Toolbar f13365v1;

    /* JADX INFO: renamed from: v2, reason: collision with root package name */
    public LoadingDialogFragment f13366v2;

    @Override // com.flydigi.base.common.u
    public void E0() {
        if (this.f13366v2 != null) {
            o5.a.o(n3(), this.f13366v2);
            this.f13366v2 = null;
        }
    }

    public void e4() {
        this.K1 = (AppBarLayout) findViewById(R.id.app_bar_layout);
        this.f13365v1 = (Toolbar) findViewById(R.id.toolbar);
        this.C1 = (TextView) findViewById(R.id.tv_title_toolbar);
        Drawable navigationIcon = this.f13365v1.getNavigationIcon();
        if (navigationIcon != null) {
            n0.c.n(navigationIcon, h0.d.f(this, R.color.color_black));
        }
        Q3(this.f13365v1);
        if (I3() != null) {
            I3().Y(true);
            I3().d0(false);
        }
    }

    @i0
    public abstract int f4();

    public void g4() {
        if (tt.c.f().o(this)) {
            return;
        }
        tt.c.f().v(this);
    }

    public void h4() {
        ku.b.d(this, h0.d.f(this, R.color.white));
        ku.b.c(this);
    }

    public void i4() {
        if (tt.c.f().o(this)) {
            tt.c.f().A(this);
        }
    }

    @Override // com.flydigi.base.common.c, androidx.fragment.app.g, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, @p0 @yt.l Intent intent) {
        super.onActivityResult(i10, i11, intent);
        try {
            if (UMConfigure.getInitStatus()) {
                UMShareAPI.get(this).onActivityResult(i10, i11, intent);
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.flydigi.base.common.c, ch.a, androidx.fragment.app.g, androidx.activity.ComponentActivity, f0.l, android.app.Activity
    public void onCreate(@p0 Bundle bundle) {
        super.onCreate(bundle);
        if (f4() != 0) {
            setContentView(f4());
        }
        h4();
    }

    @Override // com.flydigi.base.common.c, ch.a, androidx.appcompat.app.f, androidx.fragment.app.g, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        i4();
        E0();
        try {
            if (UMConfigure.getInitStatus()) {
                UMShareAPI.get(this).release();
            }
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        d4();
        return true;
    }

    @Override // com.flydigi.base.common.u
    public void x(String str, boolean z10) {
        LoadingDialogFragment loadingDialogFragment = this.f13366v2;
        if (loadingDialogFragment == null) {
            this.f13366v2 = LoadingDialogFragment.b6(str);
        } else {
            loadingDialogFragment.d6(str);
        }
        this.f13366v2.U5(z10);
        if (this.f13366v2.s3()) {
            return;
        }
        o5.a.t0(n3(), this.f13366v2);
    }
}
