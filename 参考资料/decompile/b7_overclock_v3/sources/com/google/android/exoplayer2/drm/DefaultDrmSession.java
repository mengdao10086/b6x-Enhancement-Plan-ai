package com.google.android.exoplayer2.drm;

import android.annotation.SuppressLint;
import android.media.NotProvisionedException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.b;
import com.google.android.exoplayer2.drm.f;
import com.google.android.exoplayer2.upstream.j;
import g.b0;
import g.p0;
import g.v0;
import gb.s;
import gb.z;
import hd.t;
import hd.u0;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: loaded from: classes3.dex */
@v0(18)
public class DefaultDrmSession implements DrmSession {
    public static final String C = "DefaultDrmSession";
    public static final int D = 0;
    public static final int E = 1;
    public static final int F = 60;

    @p0
    public f.b A;

    @p0
    public f.h B;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @p0
    public final List<DrmInitData.SchemeData> f16966f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final f f16967g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final a f16968h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final b f16969i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f16970j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f16971k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f16972l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final HashMap<String, String> f16973m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final hd.h<b.a> f16974n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final com.google.android.exoplayer2.upstream.j f16975o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final j f16976p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final UUID f16977q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final e f16978r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f16979s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f16980t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @p0
    public HandlerThread f16981u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @p0
    public c f16982v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @p0
    public s f16983w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @p0
    public DrmSession.DrmSessionException f16984x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @p0
    public byte[] f16985y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public byte[] f16986z;

    public static final class UnexpectedDrmSessionException extends IOException {
        public UnexpectedDrmSessionException(@p0 Throwable th2) {
            super(th2);
        }
    }

    public interface a {
        void a(DefaultDrmSession defaultDrmSession);

        void b(Exception exc);

        void c();
    }

    public interface b {
        void a(DefaultDrmSession defaultDrmSession, int i10);

        void b(DefaultDrmSession defaultDrmSession, int i10);
    }

    @SuppressLint({"HandlerLeak"})
    public class c extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @b0("this")
        public boolean f16987a;

        public c(Looper looper) {
            super(looper);
        }

        public final boolean a(Message message, MediaDrmCallbackException mediaDrmCallbackException) {
            d dVar = (d) message.obj;
            if (!dVar.f16990b) {
                return false;
            }
            int i10 = dVar.f16993e + 1;
            dVar.f16993e = i10;
            if (i10 > DefaultDrmSession.this.f16975o.f(3)) {
                return false;
            }
            long jA = DefaultDrmSession.this.f16975o.a(new j.a(new ec.j(dVar.f16989a, mediaDrmCallbackException.dataSpec, mediaDrmCallbackException.uriAfterRedirects, mediaDrmCallbackException.responseHeaders, SystemClock.elapsedRealtime(), SystemClock.elapsedRealtime() - dVar.f16991c, mediaDrmCallbackException.bytesLoaded), new ec.k(3), mediaDrmCallbackException.getCause() instanceof IOException ? (IOException) mediaDrmCallbackException.getCause() : new UnexpectedDrmSessionException(mediaDrmCallbackException.getCause()), dVar.f16993e));
            if (jA == ya.g.f56663b) {
                return false;
            }
            synchronized (this) {
                if (this.f16987a) {
                    return false;
                }
                sendMessageDelayed(Message.obtain(message), jA);
                return true;
            }
        }

        public void b(int i10, Object obj, boolean z10) {
            obtainMessage(i10, new d(ec.j.a(), z10, SystemClock.elapsedRealtime(), obj)).sendToTarget();
        }

        public synchronized void c() {
            removeCallbacksAndMessages(null);
            this.f16987a = true;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Object objB;
            d dVar = (d) message.obj;
            try {
                int i10 = message.what;
                if (i10 == 0) {
                    DefaultDrmSession defaultDrmSession = DefaultDrmSession.this;
                    objB = defaultDrmSession.f16976p.b(defaultDrmSession.f16977q, (f.h) dVar.f16992d);
                } else {
                    if (i10 != 1) {
                        throw new RuntimeException();
                    }
                    DefaultDrmSession defaultDrmSession2 = DefaultDrmSession.this;
                    objB = defaultDrmSession2.f16976p.a(defaultDrmSession2.f16977q, (f.b) dVar.f16992d);
                }
            } catch (MediaDrmCallbackException e10) {
                boolean zA = a(message, e10);
                objB = e10;
                if (zA) {
                    return;
                }
            } catch (Exception e11) {
                t.o(DefaultDrmSession.C, "Key/provisioning request produced an unexpected exception. Not retrying.", e11);
                objB = e11;
            }
            DefaultDrmSession.this.f16975o.d(dVar.f16989a);
            synchronized (this) {
                if (!this.f16987a) {
                    DefaultDrmSession.this.f16978r.obtainMessage(message.what, Pair.create(dVar.f16992d, objB)).sendToTarget();
                }
            }
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f16989a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f16990b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f16991c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Object f16992d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f16993e;

        public d(long j10, boolean z10, long j11, Object obj) {
            this.f16989a = j10;
            this.f16990b = z10;
            this.f16991c = j11;
            this.f16992d = obj;
        }
    }

    @SuppressLint({"HandlerLeak"})
    public class e extends Handler {
        public e(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Pair pair = (Pair) message.obj;
            Object obj = pair.first;
            Object obj2 = pair.second;
            int i10 = message.what;
            if (i10 == 0) {
                DefaultDrmSession.this.z(obj, obj2);
            } else {
                if (i10 != 1) {
                    return;
                }
                DefaultDrmSession.this.t(obj, obj2);
            }
        }
    }

    public DefaultDrmSession(UUID uuid, f fVar, a aVar, b bVar, @p0 List<DrmInitData.SchemeData> list, int i10, boolean z10, boolean z11, @p0 byte[] bArr, HashMap<String, String> map, j jVar, Looper looper, com.google.android.exoplayer2.upstream.j jVar2) {
        if (i10 == 1 || i10 == 3) {
            hd.a.g(bArr);
        }
        this.f16977q = uuid;
        this.f16968h = aVar;
        this.f16969i = bVar;
        this.f16967g = fVar;
        this.f16970j = i10;
        this.f16971k = z10;
        this.f16972l = z11;
        if (bArr != null) {
            this.f16986z = bArr;
            this.f16966f = null;
        } else {
            this.f16966f = Collections.unmodifiableList((List) hd.a.g(list));
        }
        this.f16973m = map;
        this.f16976p = jVar;
        this.f16974n = new hd.h<>();
        this.f16975o = jVar2;
        this.f16979s = 2;
        this.f16978r = new e(looper);
    }

    @EnsuresNonNullIf(expression = {"sessionId"}, result = true)
    public final boolean A(boolean z10) {
        if (q()) {
            return true;
        }
        try {
            byte[] bArrI = this.f16967g.i();
            this.f16985y = bArrI;
            this.f16983w = this.f16967g.f(bArrI);
            m(new hd.g() { // from class: gb.f
                @Override // hd.g
                public final void accept(Object obj) {
                    ((b.a) obj).k();
                }
            });
            this.f16979s = 3;
            hd.a.g(this.f16985y);
            return true;
        } catch (NotProvisionedException e10) {
            if (z10) {
                this.f16968h.a(this);
                return false;
            }
            s(e10);
            return false;
        } catch (Exception e11) {
            s(e11);
            return false;
        }
    }

    public final void B(byte[] bArr, int i10, boolean z10) {
        try {
            this.A = this.f16967g.r(bArr, this.f16966f, i10, this.f16973m);
            ((c) u0.k(this.f16982v)).b(1, hd.a.g(this.A), z10);
        } catch (Exception e10) {
            u(e10);
        }
    }

    public void C() {
        this.B = this.f16967g.g();
        ((c) u0.k(this.f16982v)).b(0, hd.a.g(this.B), true);
    }

    @RequiresNonNull({"sessionId", "offlineLicenseKeySetId"})
    public final boolean D() {
        try {
            this.f16967g.j(this.f16985y, this.f16986z);
            return true;
        } catch (Exception e10) {
            t.e(C, "Error trying to restore keys.", e10);
            s(e10);
            return false;
        }
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    @p0
    public final DrmSession.DrmSessionException d() {
        if (this.f16979s == 1) {
            return this.f16984x;
        }
        return null;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public void e(@p0 b.a aVar) {
        hd.a.i(this.f16980t >= 0);
        if (aVar != null) {
            this.f16974n.a(aVar);
        }
        int i10 = this.f16980t + 1;
        this.f16980t = i10;
        if (i10 == 1) {
            hd.a.i(this.f16979s == 2);
            HandlerThread handlerThread = new HandlerThread("ExoPlayer:DrmRequestHandler");
            this.f16981u = handlerThread;
            handlerThread.start();
            this.f16982v = new c(this.f16981u.getLooper());
            if (A(true)) {
                n(true);
            }
        } else if (aVar != null && q()) {
            aVar.k();
        }
        this.f16969i.a(this, this.f16980t);
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public void f(@p0 b.a aVar) {
        hd.a.i(this.f16980t > 0);
        int i10 = this.f16980t - 1;
        this.f16980t = i10;
        if (i10 == 0) {
            this.f16979s = 0;
            ((e) u0.k(this.f16978r)).removeCallbacksAndMessages(null);
            ((c) u0.k(this.f16982v)).c();
            this.f16982v = null;
            ((HandlerThread) u0.k(this.f16981u)).quit();
            this.f16981u = null;
            this.f16983w = null;
            this.f16984x = null;
            this.A = null;
            this.B = null;
            byte[] bArr = this.f16985y;
            if (bArr != null) {
                this.f16967g.l(bArr);
                this.f16985y = null;
            }
            m(new hd.g() { // from class: gb.g
                @Override // hd.g
                public final void accept(Object obj) {
                    ((b.a) obj).m();
                }
            });
        }
        if (aVar != null) {
            if (q()) {
                aVar.m();
            }
            this.f16974n.b(aVar);
        }
        this.f16969i.b(this, this.f16980t);
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public final UUID g() {
        return this.f16977q;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public final int getState() {
        return this.f16979s;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public boolean h() {
        return this.f16971k;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    @p0
    public Map<String, String> i() {
        byte[] bArr = this.f16985y;
        if (bArr == null) {
            return null;
        }
        return this.f16967g.c(bArr);
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    @p0
    public final s j() {
        return this.f16983w;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    @p0
    public byte[] k() {
        return this.f16986z;
    }

    public final void m(hd.g<b.a> gVar) {
        Iterator<b.a> it2 = this.f16974n.elementSet().iterator();
        while (it2.hasNext()) {
            gVar.accept(it2.next());
        }
    }

    @RequiresNonNull({"sessionId"})
    public final void n(boolean z10) {
        if (this.f16972l) {
            return;
        }
        byte[] bArr = (byte[]) u0.k(this.f16985y);
        int i10 = this.f16970j;
        if (i10 != 0 && i10 != 1) {
            if (i10 == 2) {
                if (this.f16986z == null || D()) {
                    B(bArr, 2, z10);
                    return;
                }
                return;
            }
            if (i10 != 3) {
                return;
            }
            hd.a.g(this.f16986z);
            hd.a.g(this.f16985y);
            if (D()) {
                B(this.f16986z, 3, z10);
                return;
            }
            return;
        }
        if (this.f16986z == null) {
            B(bArr, 1, z10);
            return;
        }
        if (this.f16979s == 4 || D()) {
            long jO = o();
            if (this.f16970j != 0 || jO > 60) {
                if (jO <= 0) {
                    s(new KeysExpiredException());
                    return;
                } else {
                    this.f16979s = 4;
                    m(new hd.g() { // from class: gb.e
                        @Override // hd.g
                        public final void accept(Object obj) {
                            ((b.a) obj).j();
                        }
                    });
                    return;
                }
            }
            t.b(C, "Offline license has expired or will expire soon. Remaining seconds: " + jO);
            B(bArr, 2, z10);
        }
    }

    public final long o() {
        if (!ya.g.K1.equals(this.f16977q)) {
            return Long.MAX_VALUE;
        }
        Pair pair = (Pair) hd.a.g(z.b(this));
        return Math.min(((Long) pair.first).longValue(), ((Long) pair.second).longValue());
    }

    public boolean p(byte[] bArr) {
        return Arrays.equals(this.f16985y, bArr);
    }

    @EnsuresNonNullIf(expression = {"sessionId"}, result = true)
    public final boolean q() {
        int i10 = this.f16979s;
        return i10 == 3 || i10 == 4;
    }

    public final void s(final Exception exc) {
        this.f16984x = new DrmSession.DrmSessionException(exc);
        m(new hd.g() { // from class: gb.b
            @Override // hd.g
            public final void accept(Object obj) {
                ((b.a) obj).l(exc);
            }
        });
        if (this.f16979s != 4) {
            this.f16979s = 1;
        }
    }

    public final void t(Object obj, Object obj2) {
        if (obj == this.A && q()) {
            this.A = null;
            if (obj2 instanceof Exception) {
                u((Exception) obj2);
                return;
            }
            try {
                byte[] bArr = (byte[]) obj2;
                if (this.f16970j == 3) {
                    this.f16967g.o((byte[]) u0.k(this.f16986z), bArr);
                    m(new hd.g() { // from class: gb.d
                        @Override // hd.g
                        public final void accept(Object obj3) {
                            ((b.a) obj3).i();
                        }
                    });
                    return;
                }
                byte[] bArrO = this.f16967g.o(this.f16985y, bArr);
                int i10 = this.f16970j;
                if ((i10 == 2 || (i10 == 0 && this.f16986z != null)) && bArrO != null && bArrO.length != 0) {
                    this.f16986z = bArrO;
                }
                this.f16979s = 4;
                m(new hd.g() { // from class: gb.c
                    @Override // hd.g
                    public final void accept(Object obj3) {
                        ((b.a) obj3).h();
                    }
                });
            } catch (Exception e10) {
                u(e10);
            }
        }
    }

    public final void u(Exception exc) {
        if (exc instanceof NotProvisionedException) {
            this.f16968h.a(this);
        } else {
            s(exc);
        }
    }

    public final void v() {
        if (this.f16970j == 0 && this.f16979s == 4) {
            u0.k(this.f16985y);
            n(false);
        }
    }

    public void w(int i10) {
        if (i10 != 2) {
            return;
        }
        v();
    }

    public void x() {
        if (A(false)) {
            n(true);
        }
    }

    public void y(Exception exc) {
        s(exc);
    }

    public final void z(Object obj, Object obj2) {
        if (obj == this.B) {
            if (this.f16979s == 2 || q()) {
                this.B = null;
                if (obj2 instanceof Exception) {
                    this.f16968h.b((Exception) obj2);
                    return;
                }
                try {
                    this.f16967g.q((byte[]) obj2);
                    this.f16968h.c();
                } catch (Exception e10) {
                    this.f16968h.b(e10);
                }
            }
        }
    }
}
