package androidx.activity.result;

import android.annotation.SuppressLint;
import g.k0;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
public abstract class g<I> {
    @n0
    public abstract f.a<I, ?> a();

    public void b(@SuppressLint({"UnknownNullness"}) I i10) {
        c(i10, null);
    }

    public abstract void c(@SuppressLint({"UnknownNullness"}) I i10, @p0 f0.e eVar);

    @k0
    public abstract void d();
}
