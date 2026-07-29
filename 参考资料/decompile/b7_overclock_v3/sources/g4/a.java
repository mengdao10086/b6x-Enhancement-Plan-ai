package g4;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import com.bumptech.glide.load.engine.bitmap_recycle.e;
import com.bumptech.glide.load.resource.bitmap.g;
import e4.j;
import g.i1;
import g.n0;
import java.security.MessageDigest;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import v4.o;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @i1
    public static final String f29005i = "PreFillRunner";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final long f29007k = 32;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final long f29008l = 40;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f29009m = 4;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f29011a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j f29012b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f29013c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final C0345a f29014d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Set<d> f29015e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Handler f29016f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f29017g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f29018h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final C0345a f29006j = new C0345a();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final long f29010n = TimeUnit.SECONDS.toMillis(1);

    /* JADX INFO: renamed from: g4.a$a, reason: collision with other inner class name */
    @i1
    public static class C0345a {
        public long a() {
            return SystemClock.currentThreadTimeMillis();
        }
    }

    public static final class b implements c4.b {
        @Override // c4.b
        public void a(@n0 MessageDigest messageDigest) {
            throw new UnsupportedOperationException();
        }
    }

    public a(e eVar, j jVar, c cVar) {
        this(eVar, jVar, cVar, f29006j, new Handler(Looper.getMainLooper()));
    }

    @i1
    public boolean a() {
        Bitmap bitmapCreateBitmap;
        long jA = this.f29014d.a();
        while (!this.f29013c.b() && !d(jA)) {
            d dVarC = this.f29013c.c();
            if (this.f29015e.contains(dVarC)) {
                bitmapCreateBitmap = Bitmap.createBitmap(dVarC.d(), dVarC.b(), dVarC.a());
            } else {
                this.f29015e.add(dVarC);
                bitmapCreateBitmap = this.f29011a.g(dVarC.d(), dVarC.b(), dVarC.a());
            }
            int iH = o.h(bitmapCreateBitmap);
            if (b() >= iH) {
                this.f29012b.g(new b(), g.f(bitmapCreateBitmap, this.f29011a));
            } else {
                this.f29011a.e(bitmapCreateBitmap);
            }
            if (Log.isLoggable(f29005i, 3)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("allocated [");
                sb2.append(dVarC.d());
                sb2.append("x");
                sb2.append(dVarC.b());
                sb2.append("] ");
                sb2.append(dVarC.a());
                sb2.append(" size: ");
                sb2.append(iH);
            }
        }
        return (this.f29018h || this.f29013c.b()) ? false : true;
    }

    public final long b() {
        return this.f29012b.a() - this.f29012b.e();
    }

    public final long c() {
        long j10 = this.f29017g;
        this.f29017g = Math.min(4 * j10, f29010n);
        return j10;
    }

    public void cancel() {
        this.f29018h = true;
    }

    public final boolean d(long j10) {
        return this.f29014d.a() - j10 >= 32;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (a()) {
            this.f29016f.postDelayed(this, c());
        }
    }

    @i1
    public a(e eVar, j jVar, c cVar, C0345a c0345a, Handler handler) {
        this.f29015e = new HashSet();
        this.f29017g = 40L;
        this.f29011a = eVar;
        this.f29012b = jVar;
        this.f29013c = cVar;
        this.f29014d = c0345a;
        this.f29016f = handler;
    }
}
