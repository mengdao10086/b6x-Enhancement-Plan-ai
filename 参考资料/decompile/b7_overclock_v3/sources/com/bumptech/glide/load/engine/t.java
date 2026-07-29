package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.engine.e;
import g.n0;
import h4.n;
import java.io.File;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class t implements e, d.a<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e.a f12471a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f<?> f12472b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f12473c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f12474d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public c4.b f12475e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List<h4.n<File, ?>> f12476f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f12477g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile n.a<?> f12478h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public File f12479i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public u f12480j;

    public t(f<?> fVar, e.a aVar) {
        this.f12472b = fVar;
        this.f12471a = aVar;
    }

    @Override // com.bumptech.glide.load.engine.e
    public boolean a() {
        w4.b.a("ResourceCacheGenerator.startNext");
        try {
            List<c4.b> listC = this.f12472b.c();
            boolean z10 = false;
            if (listC.isEmpty()) {
                return false;
            }
            List<Class<?>> listM = this.f12472b.m();
            if (listM.isEmpty()) {
                if (File.class.equals(this.f12472b.r())) {
                    return false;
                }
                throw new IllegalStateException("Failed to find any load path from " + this.f12472b.i() + " to " + this.f12472b.r());
            }
            while (true) {
                if (this.f12476f != null && b()) {
                    this.f12478h = null;
                    while (!z10 && b()) {
                        List<h4.n<File, ?>> list = this.f12476f;
                        int i10 = this.f12477g;
                        this.f12477g = i10 + 1;
                        this.f12478h = list.get(i10).a(this.f12479i, this.f12472b.t(), this.f12472b.f(), this.f12472b.k());
                        if (this.f12478h != null && this.f12472b.u(this.f12478h.f30488c.a())) {
                            this.f12478h.f30488c.f(this.f12472b.l(), this);
                            z10 = true;
                        }
                    }
                    return z10;
                }
                int i11 = this.f12474d + 1;
                this.f12474d = i11;
                if (i11 >= listM.size()) {
                    int i12 = this.f12473c + 1;
                    this.f12473c = i12;
                    if (i12 >= listC.size()) {
                        return false;
                    }
                    this.f12474d = 0;
                }
                c4.b bVar = listC.get(this.f12473c);
                Class<?> cls = listM.get(this.f12474d);
                this.f12480j = new u(this.f12472b.b(), bVar, this.f12472b.p(), this.f12472b.t(), this.f12472b.f(), this.f12472b.s(cls), cls, this.f12472b.k());
                File fileA = this.f12472b.d().a(this.f12480j);
                this.f12479i = fileA;
                if (fileA != null) {
                    this.f12475e = bVar;
                    this.f12476f = this.f12472b.j(fileA);
                    this.f12477g = 0;
                }
            }
        } finally {
            w4.b.f();
        }
    }

    public final boolean b() {
        return this.f12477g < this.f12476f.size();
    }

    @Override // com.bumptech.glide.load.data.d.a
    public void c(@n0 Exception exc) {
        this.f12471a.c(this.f12480j, exc, this.f12478h.f30488c, DataSource.RESOURCE_DISK_CACHE);
    }

    @Override // com.bumptech.glide.load.engine.e
    public void cancel() {
        n.a<?> aVar = this.f12478h;
        if (aVar != null) {
            aVar.f30488c.cancel();
        }
    }

    @Override // com.bumptech.glide.load.data.d.a
    public void d(Object obj) {
        this.f12471a.e(this.f12475e, obj, this.f12478h.f30488c, DataSource.RESOURCE_DISK_CACHE, this.f12480j);
    }
}
