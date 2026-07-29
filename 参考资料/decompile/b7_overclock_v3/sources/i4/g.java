package i4;

import g.n0;
import h4.n;
import h4.o;
import h4.r;
import java.io.InputStream;
import java.net.URL;

/* JADX INFO: loaded from: classes2.dex */
public class g implements n<URL, InputStream> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n<h4.g, InputStream> f31848a;

    public static class a implements o<URL, InputStream> {
        @Override // h4.o
        public void a() {
        }

        @Override // h4.o
        @n0
        public n<URL, InputStream> c(r rVar) {
            return new g(rVar.d(h4.g.class, InputStream.class));
        }
    }

    public g(n<h4.g, InputStream> nVar) {
        this.f31848a = nVar;
    }

    @Override // h4.n
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public n.a<InputStream> a(@n0 URL url, int i10, int i11, @n0 c4.e eVar) {
        return this.f31848a.a(new h4.g(url), i10, i11, eVar);
    }

    @Override // h4.n
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean b(@n0 URL url) {
        return true;
    }
}
