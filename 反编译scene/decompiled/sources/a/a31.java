package a;

import android.view.View;
import com.omarea.model.AppInfo;
import com.omarea.ui.Games;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class a31 implements yz0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c31 f5565a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ zz0 f29a;

    public a31(c31 c31Var, zz0 zz0Var) {
        this.f5565a = c31Var;
        this.f29a = zz0Var;
    }

    @Override // a.yz0
    public void a(View view, int i) {
        f92.d(view, "view");
        AppInfo appInfoC = this.f29a.C(i);
        if (f92.a(appInfoC.getPackageName(), "plus")) {
            Games.this.k();
        } else {
            try {
                Games.this.t(appInfoC);
            } catch (Exception unused) {
            }
        }
    }
}
