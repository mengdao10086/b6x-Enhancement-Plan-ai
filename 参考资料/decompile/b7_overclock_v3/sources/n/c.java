package n;

import androidx.annotation.RestrictTo;
import g.n0;
import g.p0;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class c extends e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile c f41704c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @n0
    public static final Executor f41705d = new Executor() { // from class: n.b
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            c.j(runnable);
        }
    };

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @n0
    public static final Executor f41706e = new Executor() { // from class: n.a
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            c.k(runnable);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public e f41707a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final e f41708b;

    public c() {
        d dVar = new d();
        this.f41708b = dVar;
        this.f41707a = dVar;
    }

    @n0
    public static Executor g() {
        return f41706e;
    }

    @n0
    public static c h() {
        if (f41704c != null) {
            return f41704c;
        }
        synchronized (c.class) {
            if (f41704c == null) {
                f41704c = new c();
            }
        }
        return f41704c;
    }

    @n0
    public static Executor i() {
        return f41705d;
    }

    public static /* synthetic */ void j(Runnable runnable) {
        h().d(runnable);
    }

    public static /* synthetic */ void k(Runnable runnable) {
        h().a(runnable);
    }

    @Override // n.e
    public void a(@n0 Runnable runnable) {
        this.f41707a.a(runnable);
    }

    @Override // n.e
    public boolean c() {
        return this.f41707a.c();
    }

    @Override // n.e
    public void d(@n0 Runnable runnable) {
        this.f41707a.d(runnable);
    }

    public void l(@p0 e eVar) {
        if (eVar == null) {
            eVar = this.f41708b;
        }
        this.f41707a = eVar;
    }
}
