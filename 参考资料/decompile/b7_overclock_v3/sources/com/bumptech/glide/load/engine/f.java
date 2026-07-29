package com.bumptech.glide.load.engine;

import com.bumptech.glide.Priority;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.engine.DecodeJob;
import h4.n;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class f<Transcode> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<n.a<?>> f12354a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<c4.b> f12355b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.bumptech.glide.d f12356c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f12357d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f12358e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f12359f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Class<?> f12360g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public DecodeJob.e f12361h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public c4.e f12362i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Map<Class<?>, c4.h<?>> f12363j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Class<Transcode> f12364k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f12365l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f12366m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public c4.b f12367n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Priority f12368o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public h f12369p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f12370q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f12371r;

    public void a() {
        this.f12356c = null;
        this.f12357d = null;
        this.f12367n = null;
        this.f12360g = null;
        this.f12364k = null;
        this.f12362i = null;
        this.f12368o = null;
        this.f12363j = null;
        this.f12369p = null;
        this.f12354a.clear();
        this.f12365l = false;
        this.f12355b.clear();
        this.f12366m = false;
    }

    public com.bumptech.glide.load.engine.bitmap_recycle.b b() {
        return this.f12356c.b();
    }

    public List<c4.b> c() {
        if (!this.f12366m) {
            this.f12366m = true;
            this.f12355b.clear();
            List<n.a<?>> listG = g();
            int size = listG.size();
            for (int i10 = 0; i10 < size; i10++) {
                n.a<?> aVar = listG.get(i10);
                if (!this.f12355b.contains(aVar.f30486a)) {
                    this.f12355b.add(aVar.f30486a);
                }
                for (int i11 = 0; i11 < aVar.f30487b.size(); i11++) {
                    if (!this.f12355b.contains(aVar.f30487b.get(i11))) {
                        this.f12355b.add(aVar.f30487b.get(i11));
                    }
                }
            }
        }
        return this.f12355b;
    }

    public e4.a d() {
        return this.f12361h.a();
    }

    public h e() {
        return this.f12369p;
    }

    public int f() {
        return this.f12359f;
    }

    public List<n.a<?>> g() {
        if (!this.f12365l) {
            this.f12365l = true;
            this.f12354a.clear();
            List listI = this.f12356c.i().i(this.f12357d);
            int size = listI.size();
            for (int i10 = 0; i10 < size; i10++) {
                n.a<?> aVarA = ((h4.n) listI.get(i10)).a(this.f12357d, this.f12358e, this.f12359f, this.f12362i);
                if (aVarA != null) {
                    this.f12354a.add(aVarA);
                }
            }
        }
        return this.f12354a;
    }

    public <Data> q<Data, ?, Transcode> h(Class<Data> cls) {
        return this.f12356c.i().h(cls, this.f12360g, this.f12364k);
    }

    public Class<?> i() {
        return this.f12357d.getClass();
    }

    public List<h4.n<File, ?>> j(File file) throws Registry.NoModelLoaderAvailableException {
        return this.f12356c.i().i(file);
    }

    public c4.e k() {
        return this.f12362i;
    }

    public Priority l() {
        return this.f12368o;
    }

    public List<Class<?>> m() {
        return this.f12356c.i().j(this.f12357d.getClass(), this.f12360g, this.f12364k);
    }

    public <Z> c4.g<Z> n(s<Z> sVar) {
        return this.f12356c.i().k(sVar);
    }

    public <T> com.bumptech.glide.load.data.e<T> o(T t10) {
        return this.f12356c.i().l(t10);
    }

    public c4.b p() {
        return this.f12367n;
    }

    public <X> c4.a<X> q(X x10) throws Registry.NoSourceEncoderAvailableException {
        return this.f12356c.i().m(x10);
    }

    public Class<?> r() {
        return this.f12364k;
    }

    public <Z> c4.h<Z> s(Class<Z> cls) {
        c4.h<Z> hVar = (c4.h) this.f12363j.get(cls);
        if (hVar == null) {
            Iterator<Map.Entry<Class<?>, c4.h<?>>> it2 = this.f12363j.entrySet().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Map.Entry<Class<?>, c4.h<?>> next = it2.next();
                if (next.getKey().isAssignableFrom(cls)) {
                    hVar = (c4.h) next.getValue();
                    break;
                }
            }
        }
        if (hVar != null) {
            return hVar;
        }
        if (!this.f12363j.isEmpty() || !this.f12370q) {
            return j4.c.c();
        }
        throw new IllegalArgumentException("Missing transformation for " + cls + ". If you wish to ignore unknown resource types, use the optional transformation methods.");
    }

    public int t() {
        return this.f12358e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean u(Class<?> cls) {
        return h(cls) != null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <R> void v(com.bumptech.glide.d dVar, Object obj, c4.b bVar, int i10, int i11, h hVar, Class<?> cls, Class<R> cls2, Priority priority, c4.e eVar, Map<Class<?>, c4.h<?>> map, boolean z10, boolean z11, DecodeJob.e eVar2) {
        this.f12356c = dVar;
        this.f12357d = obj;
        this.f12367n = bVar;
        this.f12358e = i10;
        this.f12359f = i11;
        this.f12369p = hVar;
        this.f12360g = cls;
        this.f12361h = eVar2;
        this.f12364k = cls2;
        this.f12368o = priority;
        this.f12362i = eVar;
        this.f12363j = map;
        this.f12370q = z10;
        this.f12371r = z11;
    }

    public boolean w(s<?> sVar) {
        return this.f12356c.i().n(sVar);
    }

    public boolean x() {
        return this.f12371r;
    }

    public boolean y(c4.b bVar) {
        List<n.a<?>> listG = g();
        int size = listG.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (listG.get(i10).f30486a.equals(bVar)) {
                return true;
            }
        }
        return false;
    }
}
