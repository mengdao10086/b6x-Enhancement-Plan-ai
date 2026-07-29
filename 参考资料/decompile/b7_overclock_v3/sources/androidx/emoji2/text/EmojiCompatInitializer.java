package androidx.emoji2.text;

import android.content.Context;
import androidx.core.os.y;
import androidx.emoji2.text.e;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ProcessLifecycleInitializer;
import g.j1;
import g.n0;
import g.p0;
import g.v0;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes2.dex */
public class EmojiCompatInitializer implements e2.a<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f5335a = 500;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f5336b = "EmojiCompatInitializer";

    @v0(19)
    public static class a extends e.d {
        public a(Context context) {
            super(new b(context));
            f(1);
        }
    }

    @v0(19)
    public static class b implements e.i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f5339a;

        public class a extends e.j {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ e.j f5340a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ThreadPoolExecutor f5341b;

            public a(e.j jVar, ThreadPoolExecutor threadPoolExecutor) {
                this.f5340a = jVar;
                this.f5341b = threadPoolExecutor;
            }

            @Override // androidx.emoji2.text.e.j
            public void a(@p0 Throwable th2) {
                try {
                    this.f5340a.a(th2);
                } finally {
                    this.f5341b.shutdown();
                }
            }

            @Override // androidx.emoji2.text.e.j
            public void b(@n0 o oVar) {
                try {
                    this.f5340a.b(oVar);
                } finally {
                    this.f5341b.shutdown();
                }
            }
        }

        public b(Context context) {
            this.f5339a = context.getApplicationContext();
        }

        @Override // androidx.emoji2.text.e.i
        public void a(@n0 final e.j jVar) {
            final ThreadPoolExecutor threadPoolExecutorC = androidx.emoji2.text.b.c(EmojiCompatInitializer.f5336b);
            threadPoolExecutorC.execute(new Runnable() { // from class: androidx.emoji2.text.f
                @Override // java.lang.Runnable
                public final void run() {
                    this.f5394a.d(jVar, threadPoolExecutorC);
                }
            });
        }

        @j1
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void d(@n0 e.j jVar, @n0 ThreadPoolExecutor threadPoolExecutor) {
            try {
                k kVarA = androidx.emoji2.text.c.a(this.f5339a);
                if (kVarA == null) {
                    throw new RuntimeException("EmojiCompat font provider not available on this device.");
                }
                kVarA.l(threadPoolExecutor);
                kVarA.a().a(new a(jVar, threadPoolExecutor));
            } catch (Throwable th2) {
                jVar.a(th2);
                threadPoolExecutor.shutdown();
            }
        }
    }

    public static class c implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            try {
                y.b("EmojiCompat.EmojiCompatInitializer.run");
                if (e.n()) {
                    e.b().q();
                }
            } finally {
                y.d();
            }
        }
    }

    @Override // e2.a
    @n0
    public List<Class<? extends e2.a<?>>> a() {
        return Collections.singletonList(ProcessLifecycleInitializer.class);
    }

    @Override // e2.a
    @n0
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public Boolean b(@n0 Context context) {
        e.m(new a(context));
        d(context);
        return Boolean.TRUE;
    }

    @v0(19)
    public void d(@n0 Context context) {
        final Lifecycle lifecycleE = ((androidx.lifecycle.y) androidx.startup.a.e(context).f(ProcessLifecycleInitializer.class)).e();
        lifecycleE.a(new androidx.lifecycle.j() { // from class: androidx.emoji2.text.EmojiCompatInitializer.1
            @Override // androidx.lifecycle.j
            public void a(@n0 androidx.lifecycle.y yVar) {
                EmojiCompatInitializer.this.e();
                lifecycleE.d(this);
            }

            @Override // androidx.lifecycle.j
            public /* synthetic */ void b(androidx.lifecycle.y yVar) {
                androidx.lifecycle.i.a(this, yVar);
            }

            @Override // androidx.lifecycle.j
            public /* synthetic */ void d(androidx.lifecycle.y yVar) {
                androidx.lifecycle.i.c(this, yVar);
            }

            @Override // androidx.lifecycle.j
            public /* synthetic */ void e(androidx.lifecycle.y yVar) {
                androidx.lifecycle.i.f(this, yVar);
            }

            @Override // androidx.lifecycle.j
            public /* synthetic */ void f(androidx.lifecycle.y yVar) {
                androidx.lifecycle.i.b(this, yVar);
            }

            @Override // androidx.lifecycle.j
            public /* synthetic */ void g(androidx.lifecycle.y yVar) {
                androidx.lifecycle.i.e(this, yVar);
            }
        });
    }

    @v0(19)
    public void e() {
        androidx.emoji2.text.b.e().postDelayed(new c(), 500L);
    }
}
