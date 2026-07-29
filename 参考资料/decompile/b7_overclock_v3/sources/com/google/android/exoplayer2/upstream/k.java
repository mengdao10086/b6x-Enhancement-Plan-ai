package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.b;
import ed.x;
import g.p0;
import hd.u0;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class k<T> implements Loader.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f19268a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f19269b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f19270c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final x f19271d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a<? extends T> f19272e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @p0
    public volatile T f19273f;

    public interface a<T> {
        T a(Uri uri, InputStream inputStream) throws IOException;
    }

    public k(com.google.android.exoplayer2.upstream.a aVar, Uri uri, int i10, a<? extends T> aVar2) {
        this(aVar, new b.C0198b().j(uri).c(1).a(), i10, aVar2);
    }

    public static <T> T g(com.google.android.exoplayer2.upstream.a aVar, a<? extends T> aVar2, Uri uri, int i10) throws IOException {
        k kVar = new k(aVar, uri, i10, aVar2);
        kVar.b();
        return (T) hd.a.g(kVar.e());
    }

    public static <T> T h(com.google.android.exoplayer2.upstream.a aVar, a<? extends T> aVar2, b bVar, int i10) throws IOException {
        k kVar = new k(aVar, bVar, i10, aVar2);
        kVar.b();
        return (T) hd.a.g(kVar.e());
    }

    public long a() {
        return this.f19271d.u();
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.e
    public final void b() throws IOException {
        this.f19271d.x();
        ed.l lVar = new ed.l(this.f19271d, this.f19269b);
        try {
            lVar.d();
            this.f19273f = this.f19272e.a((Uri) hd.a.g(this.f19271d.s()), lVar);
        } finally {
            u0.q(lVar);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.e
    public final void c() {
    }

    public Map<String, List<String>> d() {
        return this.f19271d.w();
    }

    @p0
    public final T e() {
        return this.f19273f;
    }

    public Uri f() {
        return this.f19271d.v();
    }

    public k(com.google.android.exoplayer2.upstream.a aVar, b bVar, int i10, a<? extends T> aVar2) {
        this.f19271d = new x(aVar);
        this.f19269b = bVar;
        this.f19270c = i10;
        this.f19272e = aVar2;
        this.f19268a = ec.j.a();
    }
}
