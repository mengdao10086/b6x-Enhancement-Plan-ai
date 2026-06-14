package a;

import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class i5 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public l5 f6377a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ n5 f1328a;

    public i5(n5 n5Var, l5 l5Var) {
        this.f1328a = n5Var;
        this.f6377a = l5Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (((x3) ((x3) this.f1328a)).f3515a != null) {
            ((x3) ((x3) this.f1328a)).f3515a.d();
        }
        View view = (View) ((x3) ((x3) this.f1328a)).f3517a;
        if (view != null && view.getWindowToken() != null && this.f6377a.m()) {
            this.f1328a.f2010a = this.f6377a;
        }
        this.f1328a.f2008a = null;
    }
}
