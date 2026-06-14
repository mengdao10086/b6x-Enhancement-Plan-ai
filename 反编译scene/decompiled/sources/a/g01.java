package a;

import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class g01 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h01 f6155a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ Drawable f954a;

    public g01(h01 h01Var, Drawable drawable) {
        this.f6155a = h01Var;
        this.f954a = drawable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f6155a.f1082a.setImageDrawable(this.f954a);
    }
}
