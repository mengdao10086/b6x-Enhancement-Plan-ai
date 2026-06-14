package a;

import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class l01 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m01 f6660a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ Drawable f1701a;

    public l01(m01 m01Var, Drawable drawable) {
        this.f6660a = m01Var;
        this.f1701a = drawable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f6660a.f1877a.setImageDrawable(this.f1701a);
    }
}
