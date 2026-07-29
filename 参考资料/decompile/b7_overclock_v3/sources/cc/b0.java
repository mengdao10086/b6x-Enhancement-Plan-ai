package cc;

import android.net.Uri;
import cc.w;
import com.google.android.exoplayer2.upstream.b;
import com.google.android.exoplayer2.upstream.cache.a;
import com.google.android.exoplayer2.util.PriorityTaskManager;
import fd.h;
import g.p0;
import hd.g0;
import hd.u0;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import ya.v0;

/* JADX INFO: loaded from: classes3.dex */
public final class b0 implements w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f10692a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.google.android.exoplayer2.upstream.b f10693b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.google.android.exoplayer2.upstream.cache.a f10694c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final fd.h f10695d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @p0
    public final PriorityTaskManager f10696e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @p0
    public w.a f10697f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile g0<Void, IOException> f10698g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile boolean f10699h;

    public class a extends g0<Void, IOException> {
        public a() {
        }

        @Override // hd.g0
        public void c() {
            b0.this.f10695d.b();
        }

        @Override // hd.g0
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public Void d() throws IOException {
            b0.this.f10695d.a();
            return null;
        }
    }

    @Deprecated
    public b0(Uri uri, @p0 String str, a.d dVar) {
        this(uri, str, dVar, androidx.profileinstaller.f.f6454a);
    }

    @Override // cc.w
    public void a(@p0 w.a aVar) throws InterruptedException, IOException {
        this.f10697f = aVar;
        this.f10698g = new a();
        PriorityTaskManager priorityTaskManager = this.f10696e;
        if (priorityTaskManager != null) {
            priorityTaskManager.a(-1000);
        }
        boolean z10 = false;
        while (!z10) {
            try {
                if (this.f10699h) {
                    break;
                }
                PriorityTaskManager priorityTaskManager2 = this.f10696e;
                if (priorityTaskManager2 != null) {
                    priorityTaskManager2.b(-1000);
                }
                this.f10692a.execute(this.f10698g);
                try {
                    this.f10698g.get();
                    z10 = true;
                } catch (ExecutionException e10) {
                    Throwable th2 = (Throwable) hd.a.g(e10.getCause());
                    if (!(th2 instanceof PriorityTaskManager.PriorityTooLowException)) {
                        if (th2 instanceof IOException) {
                            throw ((IOException) th2);
                        }
                        u0.l1(th2);
                    }
                }
            } finally {
                this.f10698g.a();
                PriorityTaskManager priorityTaskManager3 = this.f10696e;
                if (priorityTaskManager3 != null) {
                    priorityTaskManager3.e(-1000);
                }
            }
        }
    }

    @Override // cc.w
    public void cancel() {
        this.f10699h = true;
        g0<Void, IOException> g0Var = this.f10698g;
        if (g0Var != null) {
            g0Var.cancel(true);
        }
    }

    public final void d(long j10, long j11, long j12) {
        w.a aVar = this.f10697f;
        if (aVar == null) {
            return;
        }
        aVar.a(j10, j11, (j10 == -1 || j10 == 0) ? -1.0f : (j11 * 100.0f) / j10);
    }

    @Override // cc.w
    public void remove() {
        this.f10694c.v().k(this.f10694c.w().a(this.f10693b));
    }

    public b0(v0 v0Var, a.d dVar) {
        this(v0Var, dVar, androidx.profileinstaller.f.f6454a);
    }

    @Deprecated
    public b0(Uri uri, @p0 String str, a.d dVar, Executor executor) {
        this(new v0.c().F(uri).j(str).a(), dVar, executor);
    }

    public b0(v0 v0Var, a.d dVar, Executor executor) {
        this.f10692a = (Executor) hd.a.g(executor);
        hd.a.g(v0Var.f57132b);
        com.google.android.exoplayer2.upstream.b bVarA = new b.C0198b().j(v0Var.f57132b.f57183a).g(v0Var.f57132b.f57188f).c(4).a();
        this.f10693b = bVarA;
        com.google.android.exoplayer2.upstream.cache.a aVarE = dVar.e();
        this.f10694c = aVarE;
        this.f10695d = new fd.h(aVarE, bVarA, false, null, new h.a() { // from class: cc.a0
            @Override // fd.h.a
            public final void a(long j10, long j11, long j12) {
                this.f10688a.d(j10, j11, j12);
            }
        });
        this.f10696e = dVar.j();
    }
}
