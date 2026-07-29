package n4;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import g.i1;
import g.n0;
import g.p0;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import v4.m;
import v4.o;

/* JADX INFO: loaded from: classes2.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a4.a f41847a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f41848b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<b> f41849c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.bumptech.glide.i f41850d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.bumptech.glide.load.engine.bitmap_recycle.e f41851e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f41852f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f41853g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f41854h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public com.bumptech.glide.h<Bitmap> f41855i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public a f41856j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f41857k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public a f41858l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Bitmap f41859m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public c4.h<Bitmap> f41860n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public a f41861o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @p0
    public d f41862p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f41863q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f41864r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f41865s;

    @i1
    public static class a extends s4.e<Bitmap> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Handler f41866d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f41867e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final long f41868f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Bitmap f41869g;

        public a(Handler handler, int i10, long j10) {
            this.f41866d = handler;
            this.f41867e = i10;
            this.f41868f = j10;
        }

        public Bitmap d() {
            return this.f41869g;
        }

        @Override // s4.p
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void g(@n0 Bitmap bitmap, @p0 t4.f<? super Bitmap> fVar) {
            this.f41869g = bitmap;
            this.f41866d.sendMessageAtTime(this.f41866d.obtainMessage(1, this), this.f41868f);
        }

        @Override // s4.p
        public void s(@p0 Drawable drawable) {
            this.f41869g = null;
        }
    }

    public interface b {
        void a();
    }

    public class c implements Handler.Callback {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f41870b = 1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f41871c = 2;

        public c() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == 1) {
                g.this.o((a) message.obj);
                return true;
            }
            if (i10 != 2) {
                return false;
            }
            g.this.f41850d.C((a) message.obj);
            return false;
        }
    }

    @i1
    public interface d {
        void a();
    }

    public g(com.bumptech.glide.b bVar, a4.a aVar, int i10, int i11, c4.h<Bitmap> hVar, Bitmap bitmap) {
        this(bVar.h(), com.bumptech.glide.b.E(bVar.j()), aVar, null, k(com.bumptech.glide.b.E(bVar.j()), i10, i11), hVar, bitmap);
    }

    public static c4.b g() {
        return new u4.e(Double.valueOf(Math.random()));
    }

    public static com.bumptech.glide.h<Bitmap> k(com.bumptech.glide.i iVar, int i10, int i11) {
        return iVar.x().a(com.bumptech.glide.request.h.f1(com.bumptech.glide.load.engine.h.f12379b).Y0(true).O0(true).D0(i10, i11));
    }

    public void a() {
        this.f41849c.clear();
        p();
        u();
        a aVar = this.f41856j;
        if (aVar != null) {
            this.f41850d.C(aVar);
            this.f41856j = null;
        }
        a aVar2 = this.f41858l;
        if (aVar2 != null) {
            this.f41850d.C(aVar2);
            this.f41858l = null;
        }
        a aVar3 = this.f41861o;
        if (aVar3 != null) {
            this.f41850d.C(aVar3);
            this.f41861o = null;
        }
        this.f41847a.clear();
        this.f41857k = true;
    }

    public ByteBuffer b() {
        return this.f41847a.getData().asReadOnlyBuffer();
    }

    public Bitmap c() {
        a aVar = this.f41856j;
        return aVar != null ? aVar.d() : this.f41859m;
    }

    public int d() {
        a aVar = this.f41856j;
        if (aVar != null) {
            return aVar.f41867e;
        }
        return -1;
    }

    public Bitmap e() {
        return this.f41859m;
    }

    public int f() {
        return this.f41847a.c();
    }

    public c4.h<Bitmap> h() {
        return this.f41860n;
    }

    public int i() {
        return this.f41865s;
    }

    public int j() {
        return this.f41847a.o();
    }

    public int l() {
        return this.f41847a.n() + this.f41863q;
    }

    public int m() {
        return this.f41864r;
    }

    public final void n() {
        if (!this.f41852f || this.f41853g) {
            return;
        }
        if (this.f41854h) {
            m.a(this.f41861o == null, "Pending target must be null when starting from the first frame");
            this.f41847a.h();
            this.f41854h = false;
        }
        a aVar = this.f41861o;
        if (aVar != null) {
            this.f41861o = null;
            o(aVar);
            return;
        }
        this.f41853g = true;
        long jUptimeMillis = SystemClock.uptimeMillis() + ((long) this.f41847a.d());
        this.f41847a.b();
        this.f41858l = new a(this.f41848b, this.f41847a.i(), jUptimeMillis);
        this.f41855i.a(com.bumptech.glide.request.h.w1(g())).o(this.f41847a).p1(this.f41858l);
    }

    @i1
    public void o(a aVar) {
        d dVar = this.f41862p;
        if (dVar != null) {
            dVar.a();
        }
        this.f41853g = false;
        if (this.f41857k) {
            this.f41848b.obtainMessage(2, aVar).sendToTarget();
            return;
        }
        if (!this.f41852f) {
            if (this.f41854h) {
                this.f41848b.obtainMessage(2, aVar).sendToTarget();
                return;
            } else {
                this.f41861o = aVar;
                return;
            }
        }
        if (aVar.d() != null) {
            p();
            a aVar2 = this.f41856j;
            this.f41856j = aVar;
            for (int size = this.f41849c.size() - 1; size >= 0; size--) {
                this.f41849c.get(size).a();
            }
            if (aVar2 != null) {
                this.f41848b.obtainMessage(2, aVar2).sendToTarget();
            }
        }
        n();
    }

    public final void p() {
        Bitmap bitmap = this.f41859m;
        if (bitmap != null) {
            this.f41851e.e(bitmap);
            this.f41859m = null;
        }
    }

    public void q(c4.h<Bitmap> hVar, Bitmap bitmap) {
        this.f41860n = (c4.h) m.d(hVar);
        this.f41859m = (Bitmap) m.d(bitmap);
        this.f41855i = this.f41855i.a(new com.bumptech.glide.request.h().R0(hVar));
        this.f41863q = o.h(bitmap);
        this.f41864r = bitmap.getWidth();
        this.f41865s = bitmap.getHeight();
    }

    public void r() {
        m.a(!this.f41852f, "Can't restart a running animation");
        this.f41854h = true;
        a aVar = this.f41861o;
        if (aVar != null) {
            this.f41850d.C(aVar);
            this.f41861o = null;
        }
    }

    @i1
    public void s(@p0 d dVar) {
        this.f41862p = dVar;
    }

    public final void t() {
        if (this.f41852f) {
            return;
        }
        this.f41852f = true;
        this.f41857k = false;
        n();
    }

    public final void u() {
        this.f41852f = false;
    }

    public void v(b bVar) {
        if (this.f41857k) {
            throw new IllegalStateException("Cannot subscribe to a cleared frame loader");
        }
        if (this.f41849c.contains(bVar)) {
            throw new IllegalStateException("Cannot subscribe twice in a row");
        }
        boolean zIsEmpty = this.f41849c.isEmpty();
        this.f41849c.add(bVar);
        if (zIsEmpty) {
            t();
        }
    }

    public void w(b bVar) {
        this.f41849c.remove(bVar);
        if (this.f41849c.isEmpty()) {
            u();
        }
    }

    public g(com.bumptech.glide.load.engine.bitmap_recycle.e eVar, com.bumptech.glide.i iVar, a4.a aVar, Handler handler, com.bumptech.glide.h<Bitmap> hVar, c4.h<Bitmap> hVar2, Bitmap bitmap) {
        this.f41849c = new ArrayList();
        this.f41850d = iVar;
        handler = handler == null ? new Handler(Looper.getMainLooper(), new c()) : handler;
        this.f41851e = eVar;
        this.f41848b = handler;
        this.f41855i = hVar;
        this.f41847a = aVar;
        q(hVar2, bitmap);
    }
}
