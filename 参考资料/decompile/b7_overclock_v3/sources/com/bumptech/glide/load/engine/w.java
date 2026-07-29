package com.bumptech.glide.load.engine;

import android.util.Log;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.engine.e;
import g.n0;
import g.p0;
import h4.n;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class w implements e, e.a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f12493h = "SourceGenerator";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f<?> f12494a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e.a f12495b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile int f12496c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile b f12497d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile Object f12498e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile n.a<?> f12499f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile c f12500g;

    public class a implements d.a<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ n.a f12501a;

        public a(n.a aVar) {
            this.f12501a = aVar;
        }

        @Override // com.bumptech.glide.load.data.d.a
        public void c(@n0 Exception exc) {
            if (w.this.g(this.f12501a)) {
                w.this.i(this.f12501a, exc);
            }
        }

        @Override // com.bumptech.glide.load.data.d.a
        public void d(@p0 Object obj) {
            if (w.this.g(this.f12501a)) {
                w.this.h(this.f12501a, obj);
            }
        }
    }

    public w(f<?> fVar, e.a aVar) {
        this.f12494a = fVar;
        this.f12495b = aVar;
    }

    @Override // com.bumptech.glide.load.engine.e
    public boolean a() {
        if (this.f12498e != null) {
            Object obj = this.f12498e;
            this.f12498e = null;
            try {
                if (!b(obj)) {
                    return true;
                }
            } catch (IOException unused) {
            }
        }
        if (this.f12497d != null && this.f12497d.a()) {
            return true;
        }
        this.f12497d = null;
        this.f12499f = null;
        boolean z10 = false;
        while (!z10 && f()) {
            List<n.a<?>> listG = this.f12494a.g();
            int i10 = this.f12496c;
            this.f12496c = i10 + 1;
            this.f12499f = listG.get(i10);
            if (this.f12499f != null && (this.f12494a.e().c(this.f12499f.f30488c.e()) || this.f12494a.u(this.f12499f.f30488c.a()))) {
                j(this.f12499f);
                z10 = true;
            }
        }
        return z10;
    }

    public final boolean b(Object obj) throws Throwable {
        long jB = v4.i.b();
        boolean z10 = true;
        try {
            com.bumptech.glide.load.data.e<T> eVarO = this.f12494a.o(obj);
            Object objA = eVarO.a();
            c4.a<X> aVarQ = this.f12494a.q(objA);
            d dVar = new d(aVarQ, objA, this.f12494a.k());
            c cVar = new c(this.f12499f.f30486a, this.f12494a.p());
            e4.a aVarD = this.f12494a.d();
            aVarD.b(cVar, dVar);
            if (Log.isLoggable(f12493h, 2)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Finished encoding source to cache, key: ");
                sb2.append(cVar);
                sb2.append(", data: ");
                sb2.append(obj);
                sb2.append(", encoder: ");
                sb2.append(aVarQ);
                sb2.append(", duration: ");
                sb2.append(v4.i.a(jB));
            }
            if (aVarD.a(cVar) != null) {
                this.f12500g = cVar;
                this.f12497d = new b(Collections.singletonList(this.f12499f.f30486a), this.f12494a, this);
                this.f12499f.f30488c.b();
                return true;
            }
            if (Log.isLoggable(f12493h, 3)) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Attempt to write: ");
                sb3.append(this.f12500g);
                sb3.append(", data: ");
                sb3.append(obj);
                sb3.append(" to the disk cache failed, maybe the disk cache is disabled? Trying to decode the data directly...");
            }
            try {
                this.f12495b.e(this.f12499f.f30486a, eVarO.a(), this.f12499f.f30488c, this.f12499f.f30488c.e(), this.f12499f.f30486a);
                return false;
            } catch (Throwable th2) {
                th = th2;
                if (!z10) {
                    this.f12499f.f30488c.b();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            z10 = false;
        }
    }

    @Override // com.bumptech.glide.load.engine.e.a
    public void c(c4.b bVar, Exception exc, com.bumptech.glide.load.data.d<?> dVar, DataSource dataSource) {
        this.f12495b.c(bVar, exc, dVar, this.f12499f.f30488c.e());
    }

    @Override // com.bumptech.glide.load.engine.e
    public void cancel() {
        n.a<?> aVar = this.f12499f;
        if (aVar != null) {
            aVar.f30488c.cancel();
        }
    }

    @Override // com.bumptech.glide.load.engine.e.a
    public void d() {
        throw new UnsupportedOperationException();
    }

    @Override // com.bumptech.glide.load.engine.e.a
    public void e(c4.b bVar, Object obj, com.bumptech.glide.load.data.d<?> dVar, DataSource dataSource, c4.b bVar2) {
        this.f12495b.e(bVar, obj, dVar, this.f12499f.f30488c.e(), bVar);
    }

    public final boolean f() {
        return this.f12496c < this.f12494a.g().size();
    }

    public boolean g(n.a<?> aVar) {
        n.a<?> aVar2 = this.f12499f;
        return aVar2 != null && aVar2 == aVar;
    }

    public void h(n.a<?> aVar, Object obj) {
        h hVarE = this.f12494a.e();
        if (obj != null && hVarE.c(aVar.f30488c.e())) {
            this.f12498e = obj;
            this.f12495b.d();
        } else {
            e.a aVar2 = this.f12495b;
            c4.b bVar = aVar.f30486a;
            com.bumptech.glide.load.data.d<?> dVar = aVar.f30488c;
            aVar2.e(bVar, obj, dVar, dVar.e(), this.f12500g);
        }
    }

    public void i(n.a<?> aVar, @n0 Exception exc) {
        e.a aVar2 = this.f12495b;
        c cVar = this.f12500g;
        com.bumptech.glide.load.data.d<?> dVar = aVar.f30488c;
        aVar2.c(cVar, exc, dVar, dVar.e());
    }

    public final void j(n.a<?> aVar) {
        this.f12499f.f30488c.f(this.f12494a.l(), new a(aVar));
    }
}
