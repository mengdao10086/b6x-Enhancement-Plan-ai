package ge;

import android.animation.Animator;
import g.n0;
import h2.b;

/* JADX INFO: loaded from: classes3.dex */
public abstract class k<T extends Animator> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public l f29340a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float[] f29341b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int[] f29342c;

    public k(int i10) {
        this.f29341b = new float[i10 * 2];
        this.f29342c = new int[i10];
    }

    public abstract void a();

    public float b(int i10, int i11, int i12) {
        return (i10 - i11) / i12;
    }

    public abstract void c();

    public abstract void d(@n0 b.a aVar);

    public void e(@n0 l lVar) {
        this.f29340a = lVar;
    }

    public abstract void f();

    public abstract void g();

    public abstract void h();
}
