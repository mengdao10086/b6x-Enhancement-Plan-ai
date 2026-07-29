package androidx.lifecycle;

import java.util.ArrayDeque;
import java.util.Queue;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.m2;

/* JADX INFO: loaded from: classes2.dex */
public final class l {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f6212b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f6213c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f6211a = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.k
    public final Queue<Runnable> f6214d = new ArrayDeque();

    public static final void d(l this$0, Runnable runnable) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        kotlin.jvm.internal.f0.p(runnable, "$runnable");
        this$0.f(runnable);
    }

    @g.k0
    public final boolean b() {
        return this.f6212b || !this.f6211a;
    }

    @g.d
    public final void c(@yt.k CoroutineContext context, @yt.k final Runnable runnable) {
        kotlin.jvm.internal.f0.p(context, "context");
        kotlin.jvm.internal.f0.p(runnable, "runnable");
        m2 m2VarM2 = kotlinx.coroutines.d1.e().m2();
        if (m2VarM2.j2(context) || b()) {
            m2VarM2.h2(context, new Runnable() { // from class: androidx.lifecycle.k
                @Override // java.lang.Runnable
                public final void run() {
                    l.d(this.f6209a, runnable);
                }
            });
        } else {
            f(runnable);
        }
    }

    @g.k0
    public final void e() {
        if (this.f6213c) {
            return;
        }
        try {
            this.f6213c = true;
            while ((!this.f6214d.isEmpty()) && b()) {
                Runnable runnablePoll = this.f6214d.poll();
                if (runnablePoll != null) {
                    runnablePoll.run();
                }
            }
        } finally {
            this.f6213c = false;
        }
    }

    @g.k0
    public final void f(Runnable runnable) {
        if (!this.f6214d.offer(runnable)) {
            throw new IllegalStateException("cannot enqueue any more runnables".toString());
        }
        e();
    }

    @g.k0
    public final void g() {
        this.f6212b = true;
        e();
    }

    @g.k0
    public final void h() {
        this.f6211a = true;
    }

    @g.k0
    public final void i() {
        if (this.f6211a) {
            if (!(!this.f6212b)) {
                throw new IllegalStateException("Cannot resume a finished dispatcher".toString());
            }
            this.f6211a = false;
            e();
        }
    }
}
