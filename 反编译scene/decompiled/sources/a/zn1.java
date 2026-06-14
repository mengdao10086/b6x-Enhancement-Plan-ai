package a;

import android.content.pm.PackageManager;
import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class zn1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ jo1 f8084a;

    public zn1(jo1 jo1Var) {
        this.f8084a = jo1Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws PackageManager.NameNotFoundException {
        this.f8084a.i("alipay", new yn1(this));
    }
}
