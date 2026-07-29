package kotlinx.coroutines.selects;

import ik.q;
import kotlin.jvm.internal.u;
import kotlin.z1;

/* JADX INFO: loaded from: classes5.dex */
public final class h<P, Q> implements g<P, Q> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final Object f39032a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public final q<Object, j<?>, Object, z1> f39033b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.k
    public final q<Object, Object, Object, Object> f39034c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.l
    public final q<j<?>, Object, Object, ik.l<Throwable, z1>> f39035d;

    /* JADX WARN: Multi-variable type inference failed */
    public h(@yt.k Object obj, @yt.k q<Object, ? super j<?>, Object, z1> qVar, @yt.k q<Object, Object, Object, ? extends Object> qVar2, @yt.l q<? super j<?>, Object, Object, ? extends ik.l<? super Throwable, z1>> qVar3) {
        this.f39032a = obj;
        this.f39033b = qVar;
        this.f39034c = qVar2;
        this.f39035d = qVar3;
    }

    @Override // kotlinx.coroutines.selects.i
    @yt.k
    public q<Object, j<?>, Object, z1> a() {
        return this.f39033b;
    }

    @Override // kotlinx.coroutines.selects.i
    @yt.k
    public Object b() {
        return this.f39032a;
    }

    @Override // kotlinx.coroutines.selects.i
    @yt.l
    public q<j<?>, Object, Object, ik.l<Throwable, z1>> c() {
        return this.f39035d;
    }

    @Override // kotlinx.coroutines.selects.i
    @yt.k
    public q<Object, Object, Object, Object> d() {
        return this.f39034c;
    }

    public /* synthetic */ h(Object obj, q qVar, q qVar2, q qVar3, int i10, u uVar) {
        this(obj, qVar, qVar2, (i10 & 8) != 0 ? null : qVar3);
    }
}
