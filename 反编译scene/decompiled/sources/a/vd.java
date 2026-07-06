package a;

import android.graphics.Typeface;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class vd implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ke f7681a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ Typeface f3269a;

    public vd(xd xdVar, ke keVar, Typeface typeface) {
        this.f7681a = keVar;
        this.f3269a = typeface;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f7681a.b(this.f3269a);
    }
}
