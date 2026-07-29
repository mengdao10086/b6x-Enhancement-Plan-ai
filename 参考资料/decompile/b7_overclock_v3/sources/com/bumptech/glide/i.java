package com.bumptech.glide;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import g.b0;
import g.n0;
import g.p0;
import g.u0;
import g.v;
import java.io.File;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import p4.c;
import p4.l;
import p4.m;
import p4.q;
import p4.r;
import p4.t;
import s4.p;
import v4.o;

/* JADX INFO: loaded from: classes2.dex */
public class i implements ComponentCallbacks2, m, g<h<Drawable>> {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final com.bumptech.glide.request.h f12142l = com.bumptech.glide.request.h.e1(Bitmap.class).s0();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final com.bumptech.glide.request.h f12143m = com.bumptech.glide.request.h.e1(n4.c.class).s0();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final com.bumptech.glide.request.h f12144n = com.bumptech.glide.request.h.f1(com.bumptech.glide.load.engine.h.f12380c).G0(Priority.LOW).O0(true);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bumptech.glide.b f12145a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f12146b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final l f12147c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @b0("this")
    public final r f12148d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @b0("this")
    public final q f12149e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @b0("this")
    public final t f12150f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Runnable f12151g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final p4.c f12152h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final CopyOnWriteArrayList<com.bumptech.glide.request.g<Object>> f12153i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @b0("this")
    public com.bumptech.glide.request.h f12154j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f12155k;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            i iVar = i.this;
            iVar.f12147c.a(iVar);
        }
    }

    public static class b extends s4.f<View, Object> {
        public b(@n0 View view) {
            super(view);
        }

        @Override // s4.p
        public void g(@n0 Object obj, @p0 t4.f<? super Object> fVar) {
        }

        @Override // s4.f
        public void k(@p0 Drawable drawable) {
        }

        @Override // s4.p
        public void n(@p0 Drawable drawable) {
        }
    }

    public class c implements c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @b0("RequestManager.this")
        public final r f12157a;

        public c(@n0 r rVar) {
            this.f12157a = rVar;
        }

        @Override // p4.c.a
        public void a(boolean z10) {
            if (z10) {
                synchronized (i.this) {
                    this.f12157a.g();
                }
            }
        }
    }

    public i(@n0 com.bumptech.glide.b bVar, @n0 l lVar, @n0 q qVar, @n0 Context context) {
        this(bVar, lVar, qVar, new r(), bVar.i(), context);
    }

    @g.j
    @n0
    public h<n4.c> A() {
        return w(n4.c.class).a(f12143m);
    }

    public void B(@n0 View view) {
        C(new b(view));
    }

    public void C(@p0 p<?> pVar) {
        if (pVar == null) {
            return;
        }
        d0(pVar);
    }

    @g.j
    @n0
    public h<File> D(@p0 Object obj) {
        return E().o(obj);
    }

    @g.j
    @n0
    public h<File> E() {
        return w(File.class).a(f12144n);
    }

    public List<com.bumptech.glide.request.g<Object>> F() {
        return this.f12153i;
    }

    public synchronized com.bumptech.glide.request.h G() {
        return this.f12154j;
    }

    @n0
    public <T> j<?, T> H(Class<T> cls) {
        return this.f12145a.k().e(cls);
    }

    public synchronized boolean I() {
        return this.f12148d.d();
    }

    @Override // com.bumptech.glide.g
    @g.j
    @n0
    /* JADX INFO: renamed from: J, reason: merged with bridge method [inline-methods] */
    public h<Drawable> k(@p0 Bitmap bitmap) {
        return y().k(bitmap);
    }

    @Override // com.bumptech.glide.g
    @g.j
    @n0
    /* JADX INFO: renamed from: K, reason: merged with bridge method [inline-methods] */
    public h<Drawable> j(@p0 Drawable drawable) {
        return y().j(drawable);
    }

    @Override // com.bumptech.glide.g
    @g.j
    @n0
    /* JADX INFO: renamed from: L, reason: merged with bridge method [inline-methods] */
    public h<Drawable> e(@p0 Uri uri) {
        return y().e(uri);
    }

    @Override // com.bumptech.glide.g
    @g.j
    @n0
    /* JADX INFO: renamed from: M, reason: merged with bridge method [inline-methods] */
    public h<Drawable> i(@p0 File file) {
        return y().i(file);
    }

    @Override // com.bumptech.glide.g
    @g.j
    @n0
    /* JADX INFO: renamed from: N, reason: merged with bridge method [inline-methods] */
    public h<Drawable> p(@p0 @u0 @v Integer num) {
        return y().p(num);
    }

    @Override // com.bumptech.glide.g
    @g.j
    @n0
    /* JADX INFO: renamed from: O, reason: merged with bridge method [inline-methods] */
    public h<Drawable> o(@p0 Object obj) {
        return y().o(obj);
    }

    @Override // com.bumptech.glide.g
    @g.j
    @n0
    /* JADX INFO: renamed from: P, reason: merged with bridge method [inline-methods] */
    public h<Drawable> t(@p0 String str) {
        return y().t(str);
    }

    @Override // com.bumptech.glide.g
    @g.j
    @Deprecated
    /* JADX INFO: renamed from: Q, reason: merged with bridge method [inline-methods] */
    public h<Drawable> d(@p0 URL url) {
        return y().d(url);
    }

    @Override // com.bumptech.glide.g
    @g.j
    @n0
    /* JADX INFO: renamed from: R, reason: merged with bridge method [inline-methods] */
    public h<Drawable> h(@p0 byte[] bArr) {
        return y().h(bArr);
    }

    public synchronized void S() {
        this.f12148d.e();
    }

    public synchronized void T() {
        S();
        Iterator<i> it2 = this.f12149e.a().iterator();
        while (it2.hasNext()) {
            it2.next().S();
        }
    }

    public synchronized void U() {
        this.f12148d.f();
    }

    public synchronized void V() {
        U();
        Iterator<i> it2 = this.f12149e.a().iterator();
        while (it2.hasNext()) {
            it2.next().U();
        }
    }

    public synchronized void W() {
        this.f12148d.h();
    }

    public synchronized void X() {
        o.b();
        W();
        Iterator<i> it2 = this.f12149e.a().iterator();
        while (it2.hasNext()) {
            it2.next().W();
        }
    }

    @n0
    public synchronized i Y(@n0 com.bumptech.glide.request.h hVar) {
        a0(hVar);
        return this;
    }

    public void Z(boolean z10) {
        this.f12155k = z10;
    }

    @Override // p4.m
    public synchronized void a() {
        this.f12150f.a();
        Iterator<p<?>> it2 = this.f12150f.e().iterator();
        while (it2.hasNext()) {
            C(it2.next());
        }
        this.f12150f.d();
        this.f12148d.c();
        this.f12147c.b(this);
        this.f12147c.b(this.f12152h);
        o.y(this.f12151g);
        this.f12145a.B(this);
    }

    public synchronized void a0(@n0 com.bumptech.glide.request.h hVar) {
        this.f12154j = hVar.l().b();
    }

    @Override // p4.m
    public synchronized void b() {
        W();
        this.f12150f.b();
    }

    public synchronized void b0(@n0 p<?> pVar, @n0 com.bumptech.glide.request.e eVar) {
        this.f12150f.h(pVar);
        this.f12148d.i(eVar);
    }

    @Override // p4.m
    public synchronized void c() {
        U();
        this.f12150f.c();
    }

    public synchronized boolean c0(@n0 p<?> pVar) {
        com.bumptech.glide.request.e eVarR = pVar.r();
        if (eVarR == null) {
            return true;
        }
        if (!this.f12148d.b(eVarR)) {
            return false;
        }
        this.f12150f.i(pVar);
        pVar.l(null);
        return true;
    }

    public final void d0(@n0 p<?> pVar) {
        boolean zC0 = c0(pVar);
        com.bumptech.glide.request.e eVarR = pVar.r();
        if (zC0 || this.f12145a.w(pVar) || eVarR == null) {
            return;
        }
        pVar.l(null);
        eVarR.clear();
    }

    public final synchronized void e0(@n0 com.bumptech.glide.request.h hVar) {
        this.f12154j = this.f12154j.a(hVar);
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i10) {
        if (i10 == 60 && this.f12155k) {
            T();
        }
    }

    public synchronized String toString() {
        return super.toString() + "{tracker=" + this.f12148d + ", treeNode=" + this.f12149e + zc.a.f58317e;
    }

    public i u(com.bumptech.glide.request.g<Object> gVar) {
        this.f12153i.add(gVar);
        return this;
    }

    @n0
    public synchronized i v(@n0 com.bumptech.glide.request.h hVar) {
        e0(hVar);
        return this;
    }

    @g.j
    @n0
    public <ResourceType> h<ResourceType> w(@n0 Class<ResourceType> cls) {
        return new h<>(this.f12145a, this, cls, this.f12146b);
    }

    @g.j
    @n0
    public h<Bitmap> x() {
        return w(Bitmap.class).a(f12142l);
    }

    @g.j
    @n0
    public h<Drawable> y() {
        return w(Drawable.class);
    }

    @g.j
    @n0
    public h<File> z() {
        return w(File.class).a(com.bumptech.glide.request.h.y1(true));
    }

    public i(com.bumptech.glide.b bVar, l lVar, q qVar, r rVar, p4.d dVar, Context context) {
        this.f12150f = new t();
        a aVar = new a();
        this.f12151g = aVar;
        this.f12145a = bVar;
        this.f12147c = lVar;
        this.f12149e = qVar;
        this.f12148d = rVar;
        this.f12146b = context;
        p4.c cVarA = dVar.a(context.getApplicationContext(), new c(rVar));
        this.f12152h = cVarA;
        if (o.t()) {
            o.x(aVar);
        } else {
            lVar.a(this);
        }
        lVar.a(cVarA);
        this.f12153i = new CopyOnWriteArrayList<>(bVar.k().c());
        a0(bVar.k().d());
        bVar.v(this);
    }
}
