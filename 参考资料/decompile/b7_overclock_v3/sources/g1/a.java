package g1;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.Choreographer;
import androidx.collection.l;
import g.v0;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final long f28860g = 10;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ThreadLocal<a> f28861h = new ThreadLocal<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c f28865d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l<b, Long> f28862a = new l<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<b> f28863b = new ArrayList<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C0341a f28864c = new C0341a();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f28866e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f28867f = false;

    /* JADX INFO: renamed from: g1.a$a, reason: collision with other inner class name */
    public class C0341a {
        public C0341a() {
        }

        public void a() {
            a.this.f28866e = SystemClock.uptimeMillis();
            a aVar = a.this;
            aVar.c(aVar.f28866e);
            if (a.this.f28863b.size() > 0) {
                a.this.f().a();
            }
        }
    }

    public interface b {
        boolean a(long j10);
    }

    public static abstract class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final C0341a f28869a;

        public c(C0341a c0341a) {
            this.f28869a = c0341a;
        }

        public abstract void a();
    }

    public static class d extends c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Runnable f28870b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Handler f28871c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f28872d;

        /* JADX INFO: renamed from: g1.a$d$a, reason: collision with other inner class name */
        public class RunnableC0342a implements Runnable {
            public RunnableC0342a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                d.this.f28872d = SystemClock.uptimeMillis();
                d.this.f28869a.a();
            }
        }

        public d(C0341a c0341a) {
            super(c0341a);
            this.f28872d = -1L;
            this.f28870b = new RunnableC0342a();
            this.f28871c = new Handler(Looper.myLooper());
        }

        @Override // g1.a.c
        public void a() {
            this.f28871c.postDelayed(this.f28870b, Math.max(10 - (SystemClock.uptimeMillis() - this.f28872d), 0L));
        }
    }

    @v0(16)
    public static class e extends c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Choreographer f28874b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Choreographer.FrameCallback f28875c;

        /* JADX INFO: renamed from: g1.a$e$a, reason: collision with other inner class name */
        public class ChoreographerFrameCallbackC0343a implements Choreographer.FrameCallback {
            public ChoreographerFrameCallbackC0343a() {
            }

            @Override // android.view.Choreographer.FrameCallback
            public void doFrame(long j10) {
                e.this.f28869a.a();
            }
        }

        public e(C0341a c0341a) {
            super(c0341a);
            this.f28874b = Choreographer.getInstance();
            this.f28875c = new ChoreographerFrameCallbackC0343a();
        }

        @Override // g1.a.c
        public void a() {
            this.f28874b.postFrameCallback(this.f28875c);
        }
    }

    public static long d() {
        ThreadLocal<a> threadLocal = f28861h;
        if (threadLocal.get() == null) {
            return 0L;
        }
        return threadLocal.get().f28866e;
    }

    public static a e() {
        ThreadLocal<a> threadLocal = f28861h;
        if (threadLocal.get() == null) {
            threadLocal.set(new a());
        }
        return threadLocal.get();
    }

    public void a(b bVar, long j10) {
        if (this.f28863b.size() == 0) {
            f().a();
        }
        if (!this.f28863b.contains(bVar)) {
            this.f28863b.add(bVar);
        }
        if (j10 > 0) {
            this.f28862a.put(bVar, Long.valueOf(SystemClock.uptimeMillis() + j10));
        }
    }

    public final void b() {
        if (this.f28867f) {
            for (int size = this.f28863b.size() - 1; size >= 0; size--) {
                if (this.f28863b.get(size) == null) {
                    this.f28863b.remove(size);
                }
            }
            this.f28867f = false;
        }
    }

    public void c(long j10) {
        long jUptimeMillis = SystemClock.uptimeMillis();
        for (int i10 = 0; i10 < this.f28863b.size(); i10++) {
            b bVar = this.f28863b.get(i10);
            if (bVar != null && g(bVar, jUptimeMillis)) {
                bVar.a(j10);
            }
        }
        b();
    }

    public c f() {
        if (this.f28865d == null) {
            this.f28865d = new e(this.f28864c);
        }
        return this.f28865d;
    }

    public final boolean g(b bVar, long j10) {
        Long l10 = this.f28862a.get(bVar);
        if (l10 == null) {
            return true;
        }
        if (l10.longValue() >= j10) {
            return false;
        }
        this.f28862a.remove(bVar);
        return true;
    }

    public void h(b bVar) {
        this.f28862a.remove(bVar);
        int iIndexOf = this.f28863b.indexOf(bVar);
        if (iIndexOf >= 0) {
            this.f28863b.set(iIndexOf, null);
            this.f28867f = true;
        }
    }

    public void i(c cVar) {
        this.f28865d = cVar;
    }
}
