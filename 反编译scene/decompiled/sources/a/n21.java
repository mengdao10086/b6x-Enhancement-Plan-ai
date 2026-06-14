package a;

import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class n21 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o21 f6867a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ Drawable f1992a;

    public n21(o21 o21Var, Drawable drawable) {
        this.f6867a = o21Var;
        this.f1992a = drawable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f6867a.f2190a.setImageDrawable(this.f1992a);
    }
}
