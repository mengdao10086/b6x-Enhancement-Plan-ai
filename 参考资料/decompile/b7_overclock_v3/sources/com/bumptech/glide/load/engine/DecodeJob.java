package com.bumptech.glide.load.engine;

import android.os.Build;
import android.util.Log;
import androidx.core.util.n;
import com.bumptech.glide.Priority;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.engine.e;
import com.bumptech.glide.load.engine.g;
import g.n0;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import w4.a;

/* JADX INFO: loaded from: classes2.dex */
public class DecodeJob<R> implements e.a, Runnable, Comparable<DecodeJob<?>>, a.f {

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public static final String f12222k1 = "DecodeJob";
    public DataSource A;
    public com.bumptech.glide.load.data.d<?> B;
    public volatile com.bumptech.glide.load.engine.e C;
    public volatile boolean D;
    public boolean K0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final e f12226d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final n.a<DecodeJob<?>> f12227e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public com.bumptech.glide.d f12230h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public c4.b f12231i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Priority f12232j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public l f12233k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public volatile boolean f12234k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f12235l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f12236m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public h f12237n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public c4.e f12238o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public b<R> f12239p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f12240q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Stage f12241r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public RunReason f12242s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f12243t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f12244u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Object f12245v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Thread f12246w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public c4.b f12247x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public c4.b f12248y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Object f12249z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bumptech.glide.load.engine.f<R> f12223a = new com.bumptech.glide.load.engine.f<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Throwable> f12224b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final w4.c f12225c = w4.c.a();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final d<?> f12228f = new d<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final f f12229g = new f();

    public enum RunReason {
        INITIALIZE,
        SWITCH_TO_SOURCE_SERVICE,
        DECODE_DATA
    }

    public enum Stage {
        INITIALIZE,
        RESOURCE_CACHE,
        DATA_CACHE,
        SOURCE,
        ENCODE,
        FINISHED
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f12250a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f12251b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f12252c;

        static {
            int[] iArr = new int[EncodeStrategy.values().length];
            f12252c = iArr;
            try {
                iArr[EncodeStrategy.SOURCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f12252c[EncodeStrategy.TRANSFORMED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[Stage.values().length];
            f12251b = iArr2;
            try {
                iArr2[Stage.RESOURCE_CACHE.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f12251b[Stage.DATA_CACHE.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f12251b[Stage.SOURCE.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f12251b[Stage.FINISHED.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f12251b[Stage.INITIALIZE.ordinal()] = 5;
            } catch (NoSuchFieldError unused7) {
            }
            int[] iArr3 = new int[RunReason.values().length];
            f12250a = iArr3;
            try {
                iArr3[RunReason.INITIALIZE.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f12250a[RunReason.SWITCH_TO_SOURCE_SERVICE.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f12250a[RunReason.DECODE_DATA.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    public interface b<R> {
        void a(GlideException glideException);

        void c(s<R> sVar, DataSource dataSource, boolean z10);

        void d(DecodeJob<?> decodeJob);
    }

    public final class c<Z> implements g.a<Z> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final DataSource f12253a;

        public c(DataSource dataSource) {
            this.f12253a = dataSource;
        }

        @Override // com.bumptech.glide.load.engine.g.a
        @n0
        public s<Z> a(@n0 s<Z> sVar) {
            return DecodeJob.this.w(this.f12253a, sVar);
        }
    }

    public static class d<Z> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public c4.b f12255a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public c4.g<Z> f12256b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public r<Z> f12257c;

        public void a() {
            this.f12255a = null;
            this.f12256b = null;
            this.f12257c = null;
        }

        public void b(e eVar, c4.e eVar2) {
            w4.b.a("DecodeJob.encode");
            try {
                eVar.a().b(this.f12255a, new com.bumptech.glide.load.engine.d(this.f12256b, this.f12257c, eVar2));
            } finally {
                this.f12257c.h();
                w4.b.f();
            }
        }

        public boolean c() {
            return this.f12257c != null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public <X> void d(c4.b bVar, c4.g<X> gVar, r<X> rVar) {
            this.f12255a = bVar;
            this.f12256b = gVar;
            this.f12257c = rVar;
        }
    }

    public interface e {
        e4.a a();
    }

    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f12258a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f12259b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f12260c;

        public final boolean a(boolean z10) {
            return (this.f12260c || z10 || this.f12259b) && this.f12258a;
        }

        public synchronized boolean b() {
            this.f12259b = true;
            return a(false);
        }

        public synchronized boolean c() {
            this.f12260c = true;
            return a(false);
        }

        public synchronized boolean d(boolean z10) {
            this.f12258a = true;
            return a(z10);
        }

        public synchronized void e() {
            this.f12259b = false;
            this.f12258a = false;
            this.f12260c = false;
        }
    }

    public DecodeJob(e eVar, n.a<DecodeJob<?>> aVar) {
        this.f12226d = eVar;
        this.f12227e = aVar;
    }

    public final void A() {
        this.f12246w = Thread.currentThread();
        this.f12243t = v4.i.b();
        boolean zA = false;
        while (!this.f12234k0 && this.C != null && !(zA = this.C.a())) {
            this.f12241r = l(this.f12241r);
            this.C = k();
            if (this.f12241r == Stage.SOURCE) {
                d();
                return;
            }
        }
        if ((this.f12241r == Stage.FINISHED || this.f12234k0) && !zA) {
            t();
        }
    }

    public final <Data, ResourceType> s<R> B(Data data, DataSource dataSource, q<Data, ResourceType, R> qVar) throws GlideException {
        c4.e eVarM = m(dataSource);
        com.bumptech.glide.load.data.e<Data> eVarL = this.f12230h.i().l(data);
        try {
            return qVar.b(eVarL, eVarM, this.f12235l, this.f12236m, new c(dataSource));
        } finally {
            eVarL.b();
        }
    }

    public final void D() {
        int i10 = a.f12250a[this.f12242s.ordinal()];
        if (i10 == 1) {
            this.f12241r = l(Stage.INITIALIZE);
            this.C = k();
            A();
        } else if (i10 == 2) {
            A();
        } else {
            if (i10 == 3) {
                j();
                return;
            }
            throw new IllegalStateException("Unrecognized run reason: " + this.f12242s);
        }
    }

    public final void E() {
        Throwable th2;
        this.f12225c.c();
        if (!this.D) {
            this.D = true;
            return;
        }
        if (this.f12224b.isEmpty()) {
            th2 = null;
        } else {
            List<Throwable> list = this.f12224b;
            th2 = list.get(list.size() - 1);
        }
        throw new IllegalStateException("Already notified", th2);
    }

    public boolean F() {
        Stage stageL = l(Stage.INITIALIZE);
        return stageL == Stage.RESOURCE_CACHE || stageL == Stage.DATA_CACHE;
    }

    @Override // com.bumptech.glide.load.engine.e.a
    public void c(c4.b bVar, Exception exc, com.bumptech.glide.load.data.d<?> dVar, DataSource dataSource) {
        dVar.b();
        GlideException glideException = new GlideException("Fetching data failed", exc);
        glideException.n(bVar, dataSource, dVar.a());
        this.f12224b.add(glideException);
        if (Thread.currentThread() == this.f12246w) {
            A();
        } else {
            this.f12242s = RunReason.SWITCH_TO_SOURCE_SERVICE;
            this.f12239p.d(this);
        }
    }

    public void cancel() {
        this.f12234k0 = true;
        com.bumptech.glide.load.engine.e eVar = this.C;
        if (eVar != null) {
            eVar.cancel();
        }
    }

    @Override // com.bumptech.glide.load.engine.e.a
    public void d() {
        this.f12242s = RunReason.SWITCH_TO_SOURCE_SERVICE;
        this.f12239p.d(this);
    }

    @Override // com.bumptech.glide.load.engine.e.a
    public void e(c4.b bVar, Object obj, com.bumptech.glide.load.data.d<?> dVar, DataSource dataSource, c4.b bVar2) {
        this.f12247x = bVar;
        this.f12249z = obj;
        this.B = dVar;
        this.A = dataSource;
        this.f12248y = bVar2;
        this.K0 = bVar != this.f12223a.c().get(0);
        if (Thread.currentThread() != this.f12246w) {
            this.f12242s = RunReason.DECODE_DATA;
            this.f12239p.d(this);
        } else {
            w4.b.a("DecodeJob.decodeFromRetrievedData");
            try {
                j();
            } finally {
                w4.b.f();
            }
        }
    }

    @Override // w4.a.f
    @n0
    public w4.c f() {
        return this.f12225c;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public int compareTo(@n0 DecodeJob<?> decodeJob) {
        int iN = n() - decodeJob.n();
        return iN == 0 ? this.f12240q - decodeJob.f12240q : iN;
    }

    public final <Data> s<R> h(com.bumptech.glide.load.data.d<?> dVar, Data data, DataSource dataSource) throws GlideException {
        if (data == null) {
            return null;
        }
        try {
            long jB = v4.i.b();
            s<R> sVarI = i(data, dataSource);
            if (Log.isLoggable(f12222k1, 2)) {
                p("Decoded result " + sVarI, jB);
            }
            return sVarI;
        } finally {
            dVar.b();
        }
    }

    public final <Data> s<R> i(Data data, DataSource dataSource) throws GlideException {
        return B(data, dataSource, this.f12223a.h(data.getClass()));
    }

    public final void j() {
        if (Log.isLoggable(f12222k1, 2)) {
            q("Retrieved data", this.f12243t, "data: " + this.f12249z + ", cache key: " + this.f12247x + ", fetcher: " + this.B);
        }
        s<R> sVarH = null;
        try {
            sVarH = h(this.B, this.f12249z, this.A);
        } catch (GlideException e10) {
            e10.m(this.f12248y, this.A);
            this.f12224b.add(e10);
        }
        if (sVarH != null) {
            s(sVarH, this.A, this.K0);
        } else {
            A();
        }
    }

    public final com.bumptech.glide.load.engine.e k() {
        int i10 = a.f12251b[this.f12241r.ordinal()];
        if (i10 == 1) {
            return new t(this.f12223a, this);
        }
        if (i10 == 2) {
            return new com.bumptech.glide.load.engine.b(this.f12223a, this);
        }
        if (i10 == 3) {
            return new w(this.f12223a, this);
        }
        if (i10 == 4) {
            return null;
        }
        throw new IllegalStateException("Unrecognized stage: " + this.f12241r);
    }

    public final Stage l(Stage stage) {
        int i10 = a.f12251b[stage.ordinal()];
        if (i10 == 1) {
            return this.f12237n.a() ? Stage.DATA_CACHE : l(Stage.DATA_CACHE);
        }
        if (i10 == 2) {
            return this.f12244u ? Stage.FINISHED : Stage.SOURCE;
        }
        if (i10 == 3 || i10 == 4) {
            return Stage.FINISHED;
        }
        if (i10 == 5) {
            return this.f12237n.b() ? Stage.RESOURCE_CACHE : l(Stage.RESOURCE_CACHE);
        }
        throw new IllegalArgumentException("Unrecognized stage: " + stage);
    }

    @n0
    public final c4.e m(DataSource dataSource) {
        c4.e eVar = this.f12238o;
        if (Build.VERSION.SDK_INT < 26) {
            return eVar;
        }
        boolean z10 = dataSource == DataSource.RESOURCE_DISK_CACHE || this.f12223a.x();
        c4.d<Boolean> dVar = com.bumptech.glide.load.resource.bitmap.o.f12611k;
        Boolean bool = (Boolean) eVar.c(dVar);
        if (bool != null && (!bool.booleanValue() || z10)) {
            return eVar;
        }
        c4.e eVar2 = new c4.e();
        eVar2.d(this.f12238o);
        eVar2.e(dVar, Boolean.valueOf(z10));
        return eVar2;
    }

    public final int n() {
        return this.f12232j.ordinal();
    }

    public DecodeJob<R> o(com.bumptech.glide.d dVar, Object obj, l lVar, c4.b bVar, int i10, int i11, Class<?> cls, Class<R> cls2, Priority priority, h hVar, Map<Class<?>, c4.h<?>> map, boolean z10, boolean z11, boolean z12, c4.e eVar, b<R> bVar2, int i12) {
        this.f12223a.v(dVar, obj, bVar, i10, i11, hVar, cls, cls2, priority, eVar, map, z10, z11, this.f12226d);
        this.f12230h = dVar;
        this.f12231i = bVar;
        this.f12232j = priority;
        this.f12233k = lVar;
        this.f12235l = i10;
        this.f12236m = i11;
        this.f12237n = hVar;
        this.f12244u = z12;
        this.f12238o = eVar;
        this.f12239p = bVar2;
        this.f12240q = i12;
        this.f12242s = RunReason.INITIALIZE;
        this.f12245v = obj;
        return this;
    }

    public final void p(String str, long j10) {
        q(str, j10, null);
    }

    public final void q(String str, long j10, String str2) {
        String str3;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(" in ");
        sb2.append(v4.i.a(j10));
        sb2.append(", load key: ");
        sb2.append(this.f12233k);
        if (str2 != null) {
            str3 = ", " + str2;
        } else {
            str3 = "";
        }
        sb2.append(str3);
        sb2.append(", thread: ");
        sb2.append(Thread.currentThread().getName());
    }

    public final void r(s<R> sVar, DataSource dataSource, boolean z10) {
        E();
        this.f12239p.c(sVar, dataSource, z10);
    }

    @Override // java.lang.Runnable
    public void run() {
        w4.b.d("DecodeJob#run(reason=%s, model=%s)", this.f12242s, this.f12245v);
        com.bumptech.glide.load.data.d<?> dVar = this.B;
        try {
            try {
                try {
                    if (this.f12234k0) {
                        t();
                        if (dVar != null) {
                            dVar.b();
                        }
                        w4.b.f();
                        return;
                    }
                    D();
                    if (dVar != null) {
                        dVar.b();
                    }
                    w4.b.f();
                } catch (CallbackException e10) {
                    throw e10;
                }
            } catch (Throwable th2) {
                if (Log.isLoggable(f12222k1, 3)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("DecodeJob threw unexpectedly, isCancelled: ");
                    sb2.append(this.f12234k0);
                    sb2.append(", stage: ");
                    sb2.append(this.f12241r);
                }
                if (this.f12241r != Stage.ENCODE) {
                    this.f12224b.add(th2);
                    t();
                }
                if (!this.f12234k0) {
                    throw th2;
                }
                throw th2;
            }
        } catch (Throwable th3) {
            if (dVar != null) {
                dVar.b();
            }
            w4.b.f();
            throw th3;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void s(s<R> sVar, DataSource dataSource, boolean z10) {
        w4.b.a("DecodeJob.notifyEncodeAndRelease");
        try {
            if (sVar instanceof o) {
                ((o) sVar).b();
            }
            r rVar = 0;
            if (this.f12228f.c()) {
                sVar = r.e(sVar);
                rVar = sVar;
            }
            r(sVar, dataSource, z10);
            this.f12241r = Stage.ENCODE;
            try {
                if (this.f12228f.c()) {
                    this.f12228f.b(this.f12226d, this.f12238o);
                }
                u();
            } finally {
                if (rVar != 0) {
                    rVar.h();
                }
            }
        } finally {
            w4.b.f();
        }
    }

    public final void t() {
        E();
        this.f12239p.a(new GlideException("Failed to load resource", new ArrayList(this.f12224b)));
        v();
    }

    public final void u() {
        if (this.f12229g.b()) {
            y();
        }
    }

    public final void v() {
        if (this.f12229g.c()) {
            y();
        }
    }

    @n0
    public <Z> s<Z> w(DataSource dataSource, @n0 s<Z> sVar) {
        s<Z> sVarB;
        c4.h<Z> hVar;
        EncodeStrategy encodeStrategyB;
        c4.b cVar;
        Class<?> cls = sVar.get().getClass();
        c4.g<Z> gVarN = null;
        if (dataSource != DataSource.RESOURCE_DISK_CACHE) {
            c4.h<Z> hVarS = this.f12223a.s(cls);
            hVar = hVarS;
            sVarB = hVarS.b(this.f12230h, sVar, this.f12235l, this.f12236m);
        } else {
            sVarB = sVar;
            hVar = null;
        }
        if (!sVar.equals(sVarB)) {
            sVar.a();
        }
        if (this.f12223a.w(sVarB)) {
            gVarN = this.f12223a.n(sVarB);
            encodeStrategyB = gVarN.b(this.f12238o);
        } else {
            encodeStrategyB = EncodeStrategy.NONE;
        }
        c4.g gVar = gVarN;
        if (!this.f12237n.d(!this.f12223a.y(this.f12247x), dataSource, encodeStrategyB)) {
            return sVarB;
        }
        if (gVar == null) {
            throw new Registry.NoResultEncoderAvailableException(sVarB.get().getClass());
        }
        int i10 = a.f12252c[encodeStrategyB.ordinal()];
        if (i10 == 1) {
            cVar = new com.bumptech.glide.load.engine.c(this.f12247x, this.f12231i);
        } else {
            if (i10 != 2) {
                throw new IllegalArgumentException("Unknown strategy: " + encodeStrategyB);
            }
            cVar = new u(this.f12223a.b(), this.f12247x, this.f12231i, this.f12235l, this.f12236m, hVar, cls, this.f12238o);
        }
        r rVarE = r.e(sVarB);
        this.f12228f.d(cVar, gVar, rVarE);
        return rVarE;
    }

    public void x(boolean z10) {
        if (this.f12229g.d(z10)) {
            y();
        }
    }

    public final void y() {
        this.f12229g.e();
        this.f12228f.a();
        this.f12223a.a();
        this.D = false;
        this.f12230h = null;
        this.f12231i = null;
        this.f12238o = null;
        this.f12232j = null;
        this.f12233k = null;
        this.f12239p = null;
        this.f12241r = null;
        this.C = null;
        this.f12246w = null;
        this.f12247x = null;
        this.f12249z = null;
        this.A = null;
        this.B = null;
        this.f12243t = 0L;
        this.f12234k0 = false;
        this.f12245v = null;
        this.f12224b.clear();
        this.f12227e.b(this);
    }
}
