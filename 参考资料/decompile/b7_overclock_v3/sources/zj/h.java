package zj;

import kotlin.Result;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.f0;
import kotlin.u0;
import kotlin.z1;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes5.dex */
public final class h implements kotlin.coroutines.c<z1> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public Result<z1> f58605a;

    public final void a() {
        synchronized (this) {
            while (true) {
                Result<z1> result = this.f58605a;
                if (result == null) {
                    f0.n(this, "null cannot be cast to non-null type java.lang.Object");
                    wait();
                } else {
                    u0.n(result.o());
                }
            }
        }
    }

    @Override // kotlin.coroutines.c
    @k
    public CoroutineContext b() {
        return EmptyCoroutineContext.f37755a;
    }

    @l
    public final Result<z1> c() {
        return this.f58605a;
    }

    public final void e(@l Result<z1> result) {
        this.f58605a = result;
    }

    @Override // kotlin.coroutines.c
    public void x(@k Object obj) {
        synchronized (this) {
            this.f58605a = Result.a(obj);
            f0.n(this, "null cannot be cast to non-null type java.lang.Object");
            notifyAll();
            z1 z1Var = z1.f38230a;
        }
    }
}
