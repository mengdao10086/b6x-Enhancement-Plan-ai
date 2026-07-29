package com.google.android.exoplayer2.drm;

import android.annotation.SuppressLint;
import android.media.ResourceBusyException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DefaultDrmSession;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.b;
import com.google.android.exoplayer2.drm.f;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import com.google.common.collect.UnmodifiableIterator;
import g.p0;
import g.v0;
import gb.s;
import gb.y;
import hd.t;
import hd.u0;
import hd.w;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/* JADX INFO: loaded from: classes3.dex */
@v0(18)
public class DefaultDrmSessionManager implements com.google.android.exoplayer2.drm.c {
    public static final int A = 0;
    public static final int B = 1;
    public static final int C = 2;
    public static final int D = 3;
    public static final int E = 3;
    public static final long F = 300000;
    public static final String G = "DefaultDrmSessionMgr";

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final String f16995z = "PRCustomData";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final UUID f16996c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final f.g f16997d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final j f16998e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final HashMap<String, String> f16999f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f17000g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int[] f17001h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f17002i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final f f17003j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final com.google.android.exoplayer2.upstream.j f17004k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final g f17005l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final long f17006m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final List<DefaultDrmSession> f17007n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final List<DefaultDrmSession> f17008o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Set<DefaultDrmSession> f17009p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f17010q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @p0
    public com.google.android.exoplayer2.drm.f f17011r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @p0
    public DefaultDrmSession f17012s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @p0
    public DefaultDrmSession f17013t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @p0
    public Looper f17014u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Handler f17015v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f17016w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @p0
    public byte[] f17017x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @p0
    public volatile d f17018y;

    public static final class MissingSchemeDataException extends Exception {
        public MissingSchemeDataException(UUID uuid) {
            super("Media does not support uuid: " + uuid);
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f17022d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f17024f;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final HashMap<String, String> f17019a = new HashMap<>();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public UUID f17020b = ya.g.K1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public f.g f17021c = com.google.android.exoplayer2.drm.g.f17081k;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public com.google.android.exoplayer2.upstream.j f17025g = new com.google.android.exoplayer2.upstream.g();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int[] f17023e = new int[0];

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public long f17026h = 300000;

        public DefaultDrmSessionManager a(j jVar) {
            return new DefaultDrmSessionManager(this.f17020b, this.f17021c, jVar, this.f17019a, this.f17022d, this.f17023e, this.f17024f, this.f17025g, this.f17026h);
        }

        public b b(@p0 Map<String, String> map) {
            this.f17019a.clear();
            if (map != null) {
                this.f17019a.putAll(map);
            }
            return this;
        }

        public b c(com.google.android.exoplayer2.upstream.j jVar) {
            this.f17025g = (com.google.android.exoplayer2.upstream.j) hd.a.g(jVar);
            return this;
        }

        public b d(boolean z10) {
            this.f17022d = z10;
            return this;
        }

        public b e(boolean z10) {
            this.f17024f = z10;
            return this;
        }

        public b f(long j10) {
            hd.a.a(j10 > 0 || j10 == ya.g.f56663b);
            this.f17026h = j10;
            return this;
        }

        public b g(int... iArr) {
            for (int i10 : iArr) {
                boolean z10 = true;
                if (i10 != 2 && i10 != 1) {
                    z10 = false;
                }
                hd.a.a(z10);
            }
            this.f17023e = (int[]) iArr.clone();
            return this;
        }

        public b h(UUID uuid, f.g gVar) {
            this.f17020b = (UUID) hd.a.g(uuid);
            this.f17021c = (f.g) hd.a.g(gVar);
            return this;
        }
    }

    public class c implements f.d {
        public c() {
        }

        @Override // com.google.android.exoplayer2.drm.f.d
        public void a(com.google.android.exoplayer2.drm.f fVar, @p0 byte[] bArr, int i10, int i11, @p0 byte[] bArr2) {
            ((d) hd.a.g(DefaultDrmSessionManager.this.f17018y)).obtainMessage(i10, bArr).sendToTarget();
        }
    }

    @SuppressLint({"HandlerLeak"})
    public class d extends Handler {
        public d(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            byte[] bArr = (byte[]) message.obj;
            if (bArr == null) {
                return;
            }
            for (DefaultDrmSession defaultDrmSession : DefaultDrmSessionManager.this.f17007n) {
                if (defaultDrmSession.p(bArr)) {
                    defaultDrmSession.w(message.what);
                    return;
                }
            }
        }
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface e {
    }

    public class f implements DefaultDrmSession.a {
        public f() {
        }

        @Override // com.google.android.exoplayer2.drm.DefaultDrmSession.a
        public void a(DefaultDrmSession defaultDrmSession) {
            if (DefaultDrmSessionManager.this.f17008o.contains(defaultDrmSession)) {
                return;
            }
            DefaultDrmSessionManager.this.f17008o.add(defaultDrmSession);
            if (DefaultDrmSessionManager.this.f17008o.size() == 1) {
                defaultDrmSession.C();
            }
        }

        @Override // com.google.android.exoplayer2.drm.DefaultDrmSession.a
        public void b(Exception exc) {
            Iterator it2 = DefaultDrmSessionManager.this.f17008o.iterator();
            while (it2.hasNext()) {
                ((DefaultDrmSession) it2.next()).y(exc);
            }
            DefaultDrmSessionManager.this.f17008o.clear();
        }

        @Override // com.google.android.exoplayer2.drm.DefaultDrmSession.a
        public void c() {
            Iterator it2 = DefaultDrmSessionManager.this.f17008o.iterator();
            while (it2.hasNext()) {
                ((DefaultDrmSession) it2.next()).x();
            }
            DefaultDrmSessionManager.this.f17008o.clear();
        }
    }

    public class g implements DefaultDrmSession.b {
        public g() {
        }

        @Override // com.google.android.exoplayer2.drm.DefaultDrmSession.b
        public void a(DefaultDrmSession defaultDrmSession, int i10) {
            if (DefaultDrmSessionManager.this.f17006m != ya.g.f56663b) {
                DefaultDrmSessionManager.this.f17009p.remove(defaultDrmSession);
                ((Handler) hd.a.g(DefaultDrmSessionManager.this.f17015v)).removeCallbacksAndMessages(defaultDrmSession);
            }
        }

        @Override // com.google.android.exoplayer2.drm.DefaultDrmSession.b
        public void b(final DefaultDrmSession defaultDrmSession, int i10) {
            if (i10 == 1 && DefaultDrmSessionManager.this.f17006m != ya.g.f56663b) {
                DefaultDrmSessionManager.this.f17009p.add(defaultDrmSession);
                ((Handler) hd.a.g(DefaultDrmSessionManager.this.f17015v)).postAtTime(new Runnable() { // from class: gb.h
                    @Override // java.lang.Runnable
                    public final void run() {
                        defaultDrmSession.f(null);
                    }
                }, defaultDrmSession, SystemClock.uptimeMillis() + DefaultDrmSessionManager.this.f17006m);
                return;
            }
            if (i10 == 0) {
                DefaultDrmSessionManager.this.f17007n.remove(defaultDrmSession);
                if (DefaultDrmSessionManager.this.f17012s == defaultDrmSession) {
                    DefaultDrmSessionManager.this.f17012s = null;
                }
                if (DefaultDrmSessionManager.this.f17013t == defaultDrmSession) {
                    DefaultDrmSessionManager.this.f17013t = null;
                }
                if (DefaultDrmSessionManager.this.f17008o.size() > 1 && DefaultDrmSessionManager.this.f17008o.get(0) == defaultDrmSession) {
                    ((DefaultDrmSession) DefaultDrmSessionManager.this.f17008o.get(1)).C();
                }
                DefaultDrmSessionManager.this.f17008o.remove(defaultDrmSession);
                if (DefaultDrmSessionManager.this.f17006m != ya.g.f56663b) {
                    ((Handler) hd.a.g(DefaultDrmSessionManager.this.f17015v)).removeCallbacksAndMessages(defaultDrmSession);
                    DefaultDrmSessionManager.this.f17009p.remove(defaultDrmSession);
                }
            }
        }
    }

    public static List<DrmInitData.SchemeData> p(DrmInitData drmInitData, UUID uuid, boolean z10) {
        ArrayList arrayList = new ArrayList(drmInitData.f17034d);
        for (int i10 = 0; i10 < drmInitData.f17034d; i10++) {
            DrmInitData.SchemeData schemeDataJ = drmInitData.j(i10);
            if ((schemeDataJ.g(uuid) || (ya.g.J1.equals(uuid) && schemeDataJ.g(ya.g.I1))) && (schemeDataJ.f17039e != null || z10)) {
                arrayList.add(schemeDataJ);
            }
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.google.android.exoplayer2.drm.c
    @p0
    public DrmSession a(Looper looper, @p0 b.a aVar, Format format) {
        List<DrmInitData.SchemeData> listP;
        q(looper);
        s(looper);
        DrmInitData drmInitData = format.f16702o;
        if (drmInitData == null) {
            return r(w.l(format.f16699l));
        }
        DefaultDrmSession defaultDrmSessionO = null;
        Object[] objArr = 0;
        if (this.f17017x == null) {
            listP = p((DrmInitData) hd.a.g(drmInitData), this.f16996c, false);
            if (listP.isEmpty()) {
                MissingSchemeDataException missingSchemeDataException = new MissingSchemeDataException(this.f16996c);
                if (aVar != null) {
                    aVar.l(missingSchemeDataException);
                }
                return new com.google.android.exoplayer2.drm.e(new DrmSession.DrmSessionException(missingSchemeDataException));
            }
        } else {
            listP = null;
        }
        if (this.f17000g) {
            Iterator<DefaultDrmSession> it2 = this.f17007n.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                DefaultDrmSession next = it2.next();
                if (u0.c(next.f16966f, listP)) {
                    defaultDrmSessionO = next;
                    break;
                }
            }
        } else {
            defaultDrmSessionO = this.f17013t;
        }
        if (defaultDrmSessionO == null) {
            defaultDrmSessionO = o(listP, false, aVar);
            if (!this.f17000g) {
                this.f17013t = defaultDrmSessionO;
            }
            this.f17007n.add(defaultDrmSessionO);
        } else {
            defaultDrmSessionO.e(aVar);
        }
        return defaultDrmSessionO;
    }

    @Override // com.google.android.exoplayer2.drm.c
    @p0
    public Class<? extends s> b(Format format) {
        Class<? extends s> clsB = ((com.google.android.exoplayer2.drm.f) hd.a.g(this.f17011r)).b();
        DrmInitData drmInitData = format.f16702o;
        if (drmInitData != null) {
            return m(drmInitData) ? clsB : y.class;
        }
        if (u0.K0(this.f17001h, w.l(format.f16699l)) != -1) {
            return clsB;
        }
        return null;
    }

    @Override // com.google.android.exoplayer2.drm.c
    public final void f() {
        int i10 = this.f17010q;
        this.f17010q = i10 + 1;
        if (i10 != 0) {
            return;
        }
        hd.a.i(this.f17011r == null);
        com.google.android.exoplayer2.drm.f fVarA = this.f16997d.a(this.f16996c);
        this.f17011r = fVarA;
        fVarA.n(new c());
    }

    public final boolean m(DrmInitData drmInitData) {
        if (this.f17017x != null) {
            return true;
        }
        if (p(drmInitData, this.f16996c, true).isEmpty()) {
            if (drmInitData.f17034d != 1 || !drmInitData.j(0).g(ya.g.I1)) {
                return false;
            }
            t.n(G, "DrmInitData only contains common PSSH SchemeData. Assuming support for: " + this.f16996c);
        }
        String str = drmInitData.f17033c;
        if (str == null || "cenc".equals(str)) {
            return true;
        }
        return ya.g.G1.equals(str) ? u0.f31154a >= 25 : (ya.g.E1.equals(str) || ya.g.F1.equals(str)) ? false : true;
    }

    public final DefaultDrmSession n(@p0 List<DrmInitData.SchemeData> list, boolean z10, @p0 b.a aVar) {
        hd.a.g(this.f17011r);
        DefaultDrmSession defaultDrmSession = new DefaultDrmSession(this.f16996c, this.f17011r, this.f17003j, this.f17005l, list, this.f17016w, this.f17002i | z10, z10, this.f17017x, this.f16999f, this.f16998e, (Looper) hd.a.g(this.f17014u), this.f17004k);
        defaultDrmSession.e(aVar);
        if (this.f17006m != ya.g.f56663b) {
            defaultDrmSession.e(null);
        }
        return defaultDrmSession;
    }

    public final DefaultDrmSession o(@p0 List<DrmInitData.SchemeData> list, boolean z10, @p0 b.a aVar) {
        DefaultDrmSession defaultDrmSessionN = n(list, z10, aVar);
        if (defaultDrmSessionN.getState() != 1) {
            return defaultDrmSessionN;
        }
        if ((u0.f31154a >= 19 && !(((DrmSession.DrmSessionException) hd.a.g(defaultDrmSessionN.d())).getCause() instanceof ResourceBusyException)) || this.f17009p.isEmpty()) {
            return defaultDrmSessionN;
        }
        UnmodifiableIterator it2 = ImmutableSet.copyOf((Collection) this.f17009p).iterator();
        while (it2.hasNext()) {
            ((DrmSession) it2.next()).f(null);
        }
        defaultDrmSessionN.f(aVar);
        if (this.f17006m != ya.g.f56663b) {
            defaultDrmSessionN.f(null);
        }
        return n(list, z10, aVar);
    }

    public final void q(Looper looper) {
        Looper looper2 = this.f17014u;
        if (looper2 != null) {
            hd.a.i(looper2 == looper);
        } else {
            this.f17014u = looper;
            this.f17015v = new Handler(looper);
        }
    }

    @p0
    public final DrmSession r(int i10) {
        com.google.android.exoplayer2.drm.f fVar = (com.google.android.exoplayer2.drm.f) hd.a.g(this.f17011r);
        if ((gb.t.class.equals(fVar.b()) && gb.t.f29123d) || u0.K0(this.f17001h, i10) == -1 || y.class.equals(fVar.b())) {
            return null;
        }
        DefaultDrmSession defaultDrmSession = this.f17012s;
        if (defaultDrmSession == null) {
            DefaultDrmSession defaultDrmSessionO = o(ImmutableList.of(), true, null);
            this.f17007n.add(defaultDrmSessionO);
            this.f17012s = defaultDrmSessionO;
        } else {
            defaultDrmSession.e(null);
        }
        return this.f17012s;
    }

    @Override // com.google.android.exoplayer2.drm.c
    public final void release() {
        int i10 = this.f17010q - 1;
        this.f17010q = i10;
        if (i10 != 0) {
            return;
        }
        if (this.f17006m != ya.g.f56663b) {
            ArrayList arrayList = new ArrayList(this.f17007n);
            for (int i11 = 0; i11 < arrayList.size(); i11++) {
                ((DefaultDrmSession) arrayList.get(i11)).f(null);
            }
        }
        ((com.google.android.exoplayer2.drm.f) hd.a.g(this.f17011r)).release();
        this.f17011r = null;
    }

    public final void s(Looper looper) {
        if (this.f17018y == null) {
            this.f17018y = new d(looper);
        }
    }

    public void t(int i10, @p0 byte[] bArr) {
        hd.a.i(this.f17007n.isEmpty());
        if (i10 == 1 || i10 == 3) {
            hd.a.g(bArr);
        }
        this.f17016w = i10;
        this.f17017x = bArr;
    }

    @Deprecated
    public DefaultDrmSessionManager(UUID uuid, com.google.android.exoplayer2.drm.f fVar, j jVar, @p0 HashMap<String, String> map) {
        this(uuid, fVar, jVar, map == null ? new HashMap<>() : map, false, 3);
    }

    @Deprecated
    public DefaultDrmSessionManager(UUID uuid, com.google.android.exoplayer2.drm.f fVar, j jVar, @p0 HashMap<String, String> map, boolean z10) {
        this(uuid, fVar, jVar, map == null ? new HashMap<>() : map, z10, 3);
    }

    @Deprecated
    public DefaultDrmSessionManager(UUID uuid, com.google.android.exoplayer2.drm.f fVar, j jVar, @p0 HashMap<String, String> map, boolean z10, int i10) {
        this(uuid, new f.a(fVar), jVar, map == null ? new HashMap<>() : map, z10, new int[0], false, new com.google.android.exoplayer2.upstream.g(i10), 300000L);
    }

    public DefaultDrmSessionManager(UUID uuid, f.g gVar, j jVar, HashMap<String, String> map, boolean z10, int[] iArr, boolean z11, com.google.android.exoplayer2.upstream.j jVar2, long j10) {
        hd.a.g(uuid);
        hd.a.b(!ya.g.I1.equals(uuid), "Use C.CLEARKEY_UUID instead");
        this.f16996c = uuid;
        this.f16997d = gVar;
        this.f16998e = jVar;
        this.f16999f = map;
        this.f17000g = z10;
        this.f17001h = iArr;
        this.f17002i = z11;
        this.f17004k = jVar2;
        this.f17003j = new f();
        this.f17005l = new g();
        this.f17016w = 0;
        this.f17007n = new ArrayList();
        this.f17008o = new ArrayList();
        this.f17009p = Sets.newIdentityHashSet();
        this.f17006m = j10;
    }
}
