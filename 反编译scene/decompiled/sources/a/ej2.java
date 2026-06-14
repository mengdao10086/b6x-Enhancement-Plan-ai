package a;

import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class ej2 extends gf2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6013a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final long f754a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public cj2 f755a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f756a;
    public final int b;

    public ej2(int i, int i2, long j, String str) {
        this.f6013a = i;
        this.b = i2;
        this.f754a = j;
        this.f756a = str;
        this.f755a = p();
    }

    public ej2(int i, int i2, String str) {
        this(i, i2, mj2.f1942b, str);
    }

    public /* synthetic */ ej2(int i, int i2, String str, int i3, b92 b92Var) {
        this((i3 & 1) != 0 ? mj2.f6816a : i, (i3 & 2) != 0 ? mj2.b : i2, (i3 & 4) != 0 ? "DefaultDispatcher" : str);
    }

    @Override // a.od2
    public void l(l62 l62Var, Runnable runnable) {
        try {
            cj2.g(this.f755a, runnable, null, false, 6, null);
        } catch (RejectedExecutionException unused) {
            de2.f5890a.l(l62Var, runnable);
        }
    }

    public final cj2 p() {
        return new cj2(this.f6013a, this.b, this.f754a, this.f756a);
    }

    public final void t(Runnable runnable, kj2 kj2Var, boolean z) {
        try {
            this.f755a.f(runnable, kj2Var, z);
        } catch (RejectedExecutionException unused) {
            de2.f5890a.O(this.f755a.d(runnable, kj2Var));
        }
    }
}
