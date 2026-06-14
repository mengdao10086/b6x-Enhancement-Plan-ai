package a;

import android.graphics.Typeface;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class lc implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ nc f6691a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ Typeface f1783a;

    public lc(nc ncVar, Typeface typeface) {
        this.f6691a = ncVar;
        this.f1783a = typeface;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f6691a.e(this.f1783a);
    }
}
