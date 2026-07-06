package a;

import android.content.pm.PackageManager;
import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class do1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ jo1 f5922a;

    public do1(jo1 jo1Var) {
        this.f5922a = jo1Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws PackageManager.NameNotFoundException {
        this.f5922a.i("wechat", new co1(this));
    }
}
