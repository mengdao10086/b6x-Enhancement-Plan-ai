package kotlinx.coroutines.selects;

import ik.q;
import kotlin.jvm.internal.u;
import kotlin.z1;

/* JADX INFO: loaded from: classes5.dex */
public final class d implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final Object f39024a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public final q<Object, j<?>, Object, z1> f39025b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.l
    public final q<j<?>, Object, Object, ik.l<Throwable, z1>> f39026c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.k
    public final q<Object, Object, Object, Object> f39027d;

    /* JADX WARN: Multi-variable type inference failed */
    public d(@yt.k Object obj, @yt.k q<Object, ? super j<?>, Object, z1> qVar, @yt.l q<? super j<?>, Object, Object, ? extends ik.l<? super Throwable, z1>> qVar2) {
        this.f39024a = obj;
        this.f39025b = qVar;
        this.f39026c = qVar2;
        this.f39027d = SelectKt.f39012a;
    }

    @Override // kotlinx.coroutines.selects.i
    @yt.k
    public q<Object, j<?>, Object, z1> a() {
        return this.f39025b;
    }

    @Override // kotlinx.coroutines.selects.i
    @yt.k
    public Object b() {
        return this.f39024a;
    }

    @Override // kotlinx.coroutines.selects.i
    @yt.l
    public q<j<?>, Object, Object, ik.l<Throwable, z1>> c() {
        return this.f39026c;
    }

    @Override // kotlinx.coroutines.selects.i
    @yt.k
    public q<Object, Object, Object, Object> d() {
        return this.f39027d;
    }

    public /* synthetic */ d(Object obj, q qVar, q qVar2, int i10, u uVar) {
        this(obj, qVar, (i10 & 4) != 0 ? null : qVar2);
    }
}
