package androidx.emoji2.text;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import androidx.annotation.RestrictTo;
import androidx.core.os.y;
import androidx.emoji2.text.e;
import g.b0;
import g.j1;
import g.n0;
import g.p0;
import g.v0;
import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import m0.d0;
import v0.h;

/* JADX INFO: loaded from: classes2.dex */
public class k extends e.d {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final b f5547j = new b();

    public static class a extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f5548a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f5549b;

        public a(long j10) {
            this.f5548a = j10;
        }

        @Override // androidx.emoji2.text.k.d
        public long a() {
            if (this.f5549b == 0) {
                this.f5549b = SystemClock.uptimeMillis();
                return 0L;
            }
            long jUptimeMillis = SystemClock.uptimeMillis() - this.f5549b;
            if (jUptimeMillis > this.f5548a) {
                return -1L;
            }
            return Math.min(Math.max(jUptimeMillis, 1000L), this.f5548a - jUptimeMillis);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static class b {
        @p0
        public Typeface a(@n0 Context context, @n0 h.c cVar) throws PackageManager.NameNotFoundException {
            return v0.h.a(context, null, new h.c[]{cVar});
        }

        @n0
        public h.b b(@n0 Context context, @n0 v0.f fVar) throws PackageManager.NameNotFoundException {
            return v0.h.b(context, null, fVar);
        }

        public void c(@n0 Context context, @n0 Uri uri, @n0 ContentObserver contentObserver) {
            context.getContentResolver().registerContentObserver(uri, false, contentObserver);
        }

        public void d(@n0 Context context, @n0 ContentObserver contentObserver) {
            context.getContentResolver().unregisterContentObserver(contentObserver);
        }
    }

    public static class c implements e.i {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final String f5550l = "EmojiCompat.FontRequestEmojiCompatConfig.buildTypeface";

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @n0
        public final Context f5551a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @n0
        public final v0.f f5552b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @n0
        public final b f5553c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @n0
        public final Object f5554d = new Object();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @p0
        @b0("mLock")
        public Handler f5555e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @p0
        @b0("mLock")
        public Executor f5556f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @p0
        @b0("mLock")
        public ThreadPoolExecutor f5557g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @p0
        @b0("mLock")
        public d f5558h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @p0
        @b0("mLock")
        public e.j f5559i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        @p0
        @b0("mLock")
        public ContentObserver f5560j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        @p0
        @b0("mLock")
        public Runnable f5561k;

        public class a extends ContentObserver {
            public a(Handler handler) {
                super(handler);
            }

            @Override // android.database.ContentObserver
            public void onChange(boolean z10, Uri uri) {
                c.this.d();
            }
        }

        public c(@n0 Context context, @n0 v0.f fVar, @n0 b bVar) {
            androidx.core.util.o.m(context, "Context cannot be null");
            androidx.core.util.o.m(fVar, "FontRequest cannot be null");
            this.f5551a = context.getApplicationContext();
            this.f5552b = fVar;
            this.f5553c = bVar;
        }

        @Override // androidx.emoji2.text.e.i
        @v0(19)
        public void a(@n0 e.j jVar) {
            androidx.core.util.o.m(jVar, "LoaderCallback cannot be null");
            synchronized (this.f5554d) {
                this.f5559i = jVar;
            }
            d();
        }

        public final void b() {
            synchronized (this.f5554d) {
                this.f5559i = null;
                ContentObserver contentObserver = this.f5560j;
                if (contentObserver != null) {
                    this.f5553c.d(this.f5551a, contentObserver);
                    this.f5560j = null;
                }
                Handler handler = this.f5555e;
                if (handler != null) {
                    handler.removeCallbacks(this.f5561k);
                }
                this.f5555e = null;
                ThreadPoolExecutor threadPoolExecutor = this.f5557g;
                if (threadPoolExecutor != null) {
                    threadPoolExecutor.shutdown();
                }
                this.f5556f = null;
                this.f5557g = null;
            }
        }

        @j1
        @v0(19)
        public void c() {
            synchronized (this.f5554d) {
                if (this.f5559i == null) {
                    return;
                }
                try {
                    h.c cVarE = e();
                    int iB = cVarE.b();
                    if (iB == 2) {
                        synchronized (this.f5554d) {
                            d dVar = this.f5558h;
                            if (dVar != null) {
                                long jA = dVar.a();
                                if (jA >= 0) {
                                    f(cVarE.d(), jA);
                                    return;
                                }
                            }
                        }
                    }
                    if (iB != 0) {
                        throw new RuntimeException("fetchFonts result is not OK. (" + iB + ee.a.f26979d);
                    }
                    try {
                        y.b(f5550l);
                        Typeface typefaceA = this.f5553c.a(this.f5551a, cVarE);
                        ByteBuffer byteBufferF = d0.f(this.f5551a, null, cVarE.d());
                        if (byteBufferF == null || typefaceA == null) {
                            throw new RuntimeException("Unable to open file.");
                        }
                        o oVarE = o.e(typefaceA, byteBufferF);
                        y.d();
                        synchronized (this.f5554d) {
                            e.j jVar = this.f5559i;
                            if (jVar != null) {
                                jVar.b(oVarE);
                            }
                        }
                        b();
                    } catch (Throwable th2) {
                        y.d();
                        throw th2;
                    }
                } catch (Throwable th3) {
                    synchronized (this.f5554d) {
                        e.j jVar2 = this.f5559i;
                        if (jVar2 != null) {
                            jVar2.a(th3);
                        }
                        b();
                    }
                }
            }
        }

        @v0(19)
        public void d() {
            synchronized (this.f5554d) {
                if (this.f5559i == null) {
                    return;
                }
                if (this.f5556f == null) {
                    ThreadPoolExecutor threadPoolExecutorC = androidx.emoji2.text.b.c("emojiCompat");
                    this.f5557g = threadPoolExecutorC;
                    this.f5556f = threadPoolExecutorC;
                }
                this.f5556f.execute(new Runnable() { // from class: androidx.emoji2.text.l
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f5563a.c();
                    }
                });
            }
        }

        @j1
        public final h.c e() {
            try {
                h.b bVarB = this.f5553c.b(this.f5551a, this.f5552b);
                if (bVarB.c() == 0) {
                    h.c[] cVarArrB = bVarB.b();
                    if (cVarArrB == null || cVarArrB.length == 0) {
                        throw new RuntimeException("fetchFonts failed (empty result)");
                    }
                    return cVarArrB[0];
                }
                throw new RuntimeException("fetchFonts failed (" + bVarB.c() + ee.a.f26979d);
            } catch (PackageManager.NameNotFoundException e10) {
                throw new RuntimeException("provider not found", e10);
            }
        }

        @j1
        @v0(19)
        public final void f(Uri uri, long j10) {
            synchronized (this.f5554d) {
                Handler handlerE = this.f5555e;
                if (handlerE == null) {
                    handlerE = androidx.emoji2.text.b.e();
                    this.f5555e = handlerE;
                }
                if (this.f5560j == null) {
                    a aVar = new a(handlerE);
                    this.f5560j = aVar;
                    this.f5553c.c(this.f5551a, uri, aVar);
                }
                if (this.f5561k == null) {
                    this.f5561k = new Runnable() { // from class: androidx.emoji2.text.m
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f5564a.d();
                        }
                    };
                }
                handlerE.postDelayed(this.f5561k, j10);
            }
        }

        public void g(@n0 Executor executor) {
            synchronized (this.f5554d) {
                this.f5556f = executor;
            }
        }

        public void h(@p0 d dVar) {
            synchronized (this.f5554d) {
                this.f5558h = dVar;
            }
        }
    }

    public static abstract class d {
        public abstract long a();
    }

    public k(@n0 Context context, @n0 v0.f fVar) {
        super(new c(context, fVar, f5547j));
    }

    @n0
    @Deprecated
    public k k(@p0 Handler handler) {
        if (handler == null) {
            return this;
        }
        l(androidx.emoji2.text.b.b(handler));
        return this;
    }

    @n0
    public k l(@n0 Executor executor) {
        ((c) a()).g(executor);
        return this;
    }

    @n0
    public k m(@p0 d dVar) {
        ((c) a()).h(dVar);
        return this;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public k(@n0 Context context, @n0 v0.f fVar, @n0 b bVar) {
        super(new c(context, fVar, bVar));
    }
}
