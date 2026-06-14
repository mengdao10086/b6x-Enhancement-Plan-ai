package a;

import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class a10 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5557a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final WeakReference<z00> f7a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f8a;

    public a10(int i, z00 z00Var) {
        this.f7a = new WeakReference<>(z00Var);
        this.f5557a = i;
    }

    public boolean a(z00 z00Var) {
        return z00Var != null && this.f7a.get() == z00Var;
    }
}
