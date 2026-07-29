package ij;

import bj.c;
import bj.e;
import dj.g;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.operators.observable.ObservablePublishAlt;
import io.reactivex.internal.operators.observable.ObservableRefCount;
import io.reactivex.internal.operators.observable.d1;
import io.reactivex.internal.operators.observable.i;
import java.util.concurrent.TimeUnit;
import xi.h0;
import xi.z;

/* JADX INFO: loaded from: classes5.dex */
public abstract class a<T> extends z<T> {
    @e
    public z<T> i8() {
        return j8(1);
    }

    @e
    public z<T> j8(int i10) {
        return k8(i10, Functions.h());
    }

    @e
    public z<T> k8(int i10, @e g<? super io.reactivex.disposables.b> gVar) {
        if (i10 > 0) {
            return kj.a.U(new i(this, i10, gVar));
        }
        m8(gVar);
        return kj.a.P(this);
    }

    public final io.reactivex.disposables.b l8() {
        io.reactivex.internal.util.e eVar = new io.reactivex.internal.util.e();
        m8(eVar);
        return eVar.f35256a;
    }

    public abstract void m8(@e g<? super io.reactivex.disposables.b> gVar);

    /* JADX WARN: Multi-variable type inference failed */
    public final a<T> n8() {
        return this instanceof d1 ? kj.a.P(new ObservablePublishAlt(((d1) this).b())) : this;
    }

    @c
    @bj.g("none")
    @e
    public z<T> o8() {
        return kj.a.U(new ObservableRefCount(n8()));
    }

    @c
    @bj.g("none")
    public final z<T> p8(int i10) {
        return r8(i10, 0L, TimeUnit.NANOSECONDS, lj.b.i());
    }

    @c
    @bj.g(bj.g.B)
    public final z<T> q8(int i10, long j10, TimeUnit timeUnit) {
        return r8(i10, j10, timeUnit, lj.b.a());
    }

    @c
    @bj.g(bj.g.A)
    public final z<T> r8(int i10, long j10, TimeUnit timeUnit, h0 h0Var) {
        io.reactivex.internal.functions.a.h(i10, "subscriberCount");
        io.reactivex.internal.functions.a.g(timeUnit, "unit is null");
        io.reactivex.internal.functions.a.g(h0Var, "scheduler is null");
        return kj.a.U(new ObservableRefCount(n8(), i10, j10, timeUnit, h0Var));
    }

    @c
    @bj.g(bj.g.B)
    public final z<T> s8(long j10, TimeUnit timeUnit) {
        return r8(1, j10, timeUnit, lj.b.a());
    }

    @c
    @bj.g(bj.g.A)
    public final z<T> t8(long j10, TimeUnit timeUnit, h0 h0Var) {
        return r8(1, j10, timeUnit, h0Var);
    }
}
