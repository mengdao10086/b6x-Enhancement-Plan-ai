package ed;

import android.os.Handler;
import ed.d;
import g.p0;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes3.dex */
public interface d {

    public interface a {

        /* JADX INFO: renamed from: ed.d$a$a, reason: collision with other inner class name */
        public static final class C0309a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final CopyOnWriteArrayList<C0310a> f26893a = new CopyOnWriteArrayList<>();

            /* JADX INFO: renamed from: ed.d$a$a$a, reason: collision with other inner class name */
            public static final class C0310a {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final Handler f26894a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final a f26895b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                public boolean f26896c;

                public C0310a(Handler handler, a aVar) {
                    this.f26894a = handler;
                    this.f26895b = aVar;
                }

                public void d() {
                    this.f26896c = true;
                }
            }

            public static /* synthetic */ void d(C0310a c0310a, int i10, long j10, long j11) {
                c0310a.f26895b.t(i10, j10, j11);
            }

            public void b(Handler handler, a aVar) {
                hd.a.g(handler);
                hd.a.g(aVar);
                e(aVar);
                this.f26893a.add(new C0310a(handler, aVar));
            }

            public void c(final int i10, final long j10, final long j11) {
                for (final C0310a c0310a : this.f26893a) {
                    if (!c0310a.f26896c) {
                        c0310a.f26894a.post(new Runnable() { // from class: ed.c
                            @Override // java.lang.Runnable
                            public final void run() {
                                d.a.C0309a.d(c0310a, i10, j10, j11);
                            }
                        });
                    }
                }
            }

            public void e(a aVar) {
                for (C0310a c0310a : this.f26893a) {
                    if (c0310a.f26895b == aVar) {
                        c0310a.d();
                        this.f26893a.remove(c0310a);
                    }
                }
            }
        }

        void t(int i10, long j10, long j11);
    }

    void c(Handler handler, a aVar);

    @p0
    z d();

    long e();

    void f(a aVar);
}
