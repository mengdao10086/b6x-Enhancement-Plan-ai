package cj;

import bj.c;
import bj.e;
import dj.g;
import io.reactivex.annotations.BackpressureKind;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.operators.flowable.FlowablePublishAlt;
import io.reactivex.internal.operators.flowable.FlowableRefCount;
import io.reactivex.internal.operators.flowable.s0;
import java.util.concurrent.TimeUnit;
import xi.h0;
import xi.j;

/* JADX INFO: loaded from: classes5.dex */
public abstract class a<T> extends j<T> {
    @e
    public j<T> M8() {
        return N8(1);
    }

    @e
    public j<T> N8(int i10) {
        return O8(i10, Functions.h());
    }

    @e
    public j<T> O8(int i10, @e g<? super io.reactivex.disposables.b> gVar) {
        if (i10 > 0) {
            return kj.a.S(new io.reactivex.internal.operators.flowable.g(this, i10, gVar));
        }
        Q8(gVar);
        return kj.a.O(this);
    }

    public final io.reactivex.disposables.b P8() {
        io.reactivex.internal.util.e eVar = new io.reactivex.internal.util.e();
        Q8(eVar);
        return eVar.f35256a;
    }

    public abstract void Q8(@e g<? super io.reactivex.disposables.b> gVar);

    /* JADX WARN: Multi-variable type inference failed */
    public final a<T> R8() {
        if (!(this instanceof s0)) {
            return this;
        }
        s0 s0Var = (s0) this;
        return kj.a.O(new FlowablePublishAlt(s0Var.b(), s0Var.c()));
    }

    @bj.g("none")
    @bj.a(BackpressureKind.PASS_THROUGH)
    @c
    @e
    public j<T> S8() {
        return kj.a.S(new FlowableRefCount(R8()));
    }

    @c
    @bj.g("none")
    @bj.a(BackpressureKind.PASS_THROUGH)
    public final j<T> T8(int i10) {
        return V8(i10, 0L, TimeUnit.NANOSECONDS, lj.b.i());
    }

    @c
    @bj.g(bj.g.B)
    @bj.a(BackpressureKind.PASS_THROUGH)
    public final j<T> U8(int i10, long j10, TimeUnit timeUnit) {
        return V8(i10, j10, timeUnit, lj.b.a());
    }

    @c
    @bj.g(bj.g.A)
    @bj.a(BackpressureKind.PASS_THROUGH)
    public final j<T> V8(int i10, long j10, TimeUnit timeUnit, h0 h0Var) {
        io.reactivex.internal.functions.a.h(i10, "subscriberCount");
        io.reactivex.internal.functions.a.g(timeUnit, "unit is null");
        io.reactivex.internal.functions.a.g(h0Var, "scheduler is null");
        return kj.a.S(new FlowableRefCount(R8(), i10, j10, timeUnit, h0Var));
    }

    @c
    @bj.g(bj.g.B)
    @bj.a(BackpressureKind.PASS_THROUGH)
    public final j<T> W8(long j10, TimeUnit timeUnit) {
        return V8(1, j10, timeUnit, lj.b.a());
    }

    @c
    @bj.g(bj.g.A)
    @bj.a(BackpressureKind.PASS_THROUGH)
    public final j<T> X8(long j10, TimeUnit timeUnit, h0 h0Var) {
        return V8(1, j10, timeUnit, h0Var);
    }
}
