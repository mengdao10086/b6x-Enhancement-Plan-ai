package com.bumptech.glide;

import android.content.Context;
import android.os.Build;
import com.bumptech.glide.b;
import com.bumptech.glide.e;
import com.bumptech.glide.load.engine.bitmap_recycle.k;
import e4.a;
import e4.l;
import g.n0;
import g.p0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import p4.p;
import v4.m;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.bumptech.glide.load.engine.i f12093c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.bumptech.glide.load.engine.bitmap_recycle.e f12094d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.bumptech.glide.load.engine.bitmap_recycle.b f12095e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public e4.j f12096f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public f4.a f12097g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public f4.a f12098h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public a.InterfaceC0306a f12099i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public l f12100j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public p4.d f12101k;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @p0
    public p.b f12104n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public f4.a f12105o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f12106p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @p0
    public List<com.bumptech.glide.request.g<Object>> f12107q;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Class<?>, j<?, ?>> f12091a = new androidx.collection.a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e.a f12092b = new e.a();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f12102l = 4;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public b.a f12103m = new a();

    public class a implements b.a {
        public a() {
        }

        @Override // com.bumptech.glide.b.a
        @n0
        public com.bumptech.glide.request.h a() {
            return new com.bumptech.glide.request.h();
        }
    }

    public class b implements b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.bumptech.glide.request.h f12109a;

        public b(com.bumptech.glide.request.h hVar) {
            this.f12109a = hVar;
        }

        @Override // com.bumptech.glide.b.a
        @n0
        public com.bumptech.glide.request.h a() {
            com.bumptech.glide.request.h hVar = this.f12109a;
            return hVar != null ? hVar : new com.bumptech.glide.request.h();
        }
    }

    /* JADX INFO: renamed from: com.bumptech.glide.c$c, reason: collision with other inner class name */
    public static final class C0118c implements e.b {
    }

    public static final class d implements e.b {
    }

    public static final class e implements e.b {
    }

    public static final class f implements e.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f12111a;

        public f(int i10) {
            this.f12111a = i10;
        }
    }

    public static final class g implements e.b {
    }

    @n0
    public c a(@n0 com.bumptech.glide.request.g<Object> gVar) {
        if (this.f12107q == null) {
            this.f12107q = new ArrayList();
        }
        this.f12107q.add(gVar);
        return this;
    }

    @n0
    public com.bumptech.glide.b b(@n0 Context context) {
        if (this.f12097g == null) {
            this.f12097g = f4.a.j();
        }
        if (this.f12098h == null) {
            this.f12098h = f4.a.f();
        }
        if (this.f12105o == null) {
            this.f12105o = f4.a.c();
        }
        if (this.f12100j == null) {
            this.f12100j = new l.a(context).a();
        }
        if (this.f12101k == null) {
            this.f12101k = new p4.f();
        }
        if (this.f12094d == null) {
            int iB = this.f12100j.b();
            if (iB > 0) {
                this.f12094d = new k(iB);
            } else {
                this.f12094d = new com.bumptech.glide.load.engine.bitmap_recycle.f();
            }
        }
        if (this.f12095e == null) {
            this.f12095e = new com.bumptech.glide.load.engine.bitmap_recycle.j(this.f12100j.a());
        }
        if (this.f12096f == null) {
            this.f12096f = new e4.i(this.f12100j.d());
        }
        if (this.f12099i == null) {
            this.f12099i = new e4.h(context);
        }
        if (this.f12093c == null) {
            this.f12093c = new com.bumptech.glide.load.engine.i(this.f12096f, this.f12099i, this.f12098h, this.f12097g, f4.a.m(), this.f12105o, this.f12106p);
        }
        List<com.bumptech.glide.request.g<Object>> list = this.f12107q;
        if (list == null) {
            this.f12107q = Collections.emptyList();
        } else {
            this.f12107q = Collections.unmodifiableList(list);
        }
        com.bumptech.glide.e eVarC = this.f12092b.c();
        return new com.bumptech.glide.b(context, this.f12093c, this.f12096f, this.f12094d, this.f12095e, new p(this.f12104n, eVarC), this.f12101k, this.f12102l, this.f12103m, this.f12091a, this.f12107q, eVarC);
    }

    @n0
    public c c(@p0 f4.a aVar) {
        this.f12105o = aVar;
        return this;
    }

    @n0
    public c d(@p0 com.bumptech.glide.load.engine.bitmap_recycle.b bVar) {
        this.f12095e = bVar;
        return this;
    }

    @n0
    public c e(@p0 com.bumptech.glide.load.engine.bitmap_recycle.e eVar) {
        this.f12094d = eVar;
        return this;
    }

    @n0
    public c f(@p0 p4.d dVar) {
        this.f12101k = dVar;
        return this;
    }

    @n0
    public c g(@n0 b.a aVar) {
        this.f12103m = (b.a) m.d(aVar);
        return this;
    }

    @n0
    public c h(@p0 com.bumptech.glide.request.h hVar) {
        return g(new b(hVar));
    }

    @n0
    public <T> c i(@n0 Class<T> cls, @p0 j<?, T> jVar) {
        this.f12091a.put(cls, jVar);
        return this;
    }

    @n0
    public c j(@p0 a.InterfaceC0306a interfaceC0306a) {
        this.f12099i = interfaceC0306a;
        return this;
    }

    @n0
    public c k(@p0 f4.a aVar) {
        this.f12098h = aVar;
        return this;
    }

    public c l(boolean z10) {
        this.f12092b.d(new C0118c(), z10);
        return this;
    }

    public c m(com.bumptech.glide.load.engine.i iVar) {
        this.f12093c = iVar;
        return this;
    }

    public c n(boolean z10) {
        this.f12092b.d(new d(), z10 && Build.VERSION.SDK_INT >= 29);
        return this;
    }

    @n0
    public c o(boolean z10) {
        this.f12106p = z10;
        return this;
    }

    @n0
    public c p(int i10) {
        if (i10 < 2 || i10 > 6) {
            throw new IllegalArgumentException("Log level must be one of Log.VERBOSE, Log.DEBUG, Log.INFO, Log.WARN, or Log.ERROR");
        }
        this.f12102l = i10;
        return this;
    }

    public c q(boolean z10) {
        this.f12092b.d(new e(), z10);
        return this;
    }

    @n0
    public c r(@p0 e4.j jVar) {
        this.f12096f = jVar;
        return this;
    }

    @n0
    public c s(@n0 l.a aVar) {
        return t(aVar.a());
    }

    @n0
    public c t(@p0 l lVar) {
        this.f12100j = lVar;
        return this;
    }

    public void u(@p0 p.b bVar) {
        this.f12104n = bVar;
    }

    @Deprecated
    public c v(@p0 f4.a aVar) {
        return w(aVar);
    }

    @n0
    public c w(@p0 f4.a aVar) {
        this.f12097g = aVar;
        return this;
    }
}
