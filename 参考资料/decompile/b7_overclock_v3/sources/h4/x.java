package h4;

import android.net.Uri;
import g.n0;
import h4.n;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class x<Data> implements n<Uri, Data> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set<String> f30529b = Collections.unmodifiableSet(new HashSet(Arrays.asList("http", "https")));

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n<g, Data> f30530a;

    public static class a implements o<Uri, InputStream> {
        @Override // h4.o
        public void a() {
        }

        @Override // h4.o
        @n0
        public n<Uri, InputStream> c(r rVar) {
            return new x(rVar.d(g.class, InputStream.class));
        }
    }

    public x(n<g, Data> nVar) {
        this.f30530a = nVar;
    }

    @Override // h4.n
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public n.a<Data> a(@n0 Uri uri, int i10, int i11, @n0 c4.e eVar) {
        return this.f30530a.a(new g(uri.toString()), i10, i11, eVar);
    }

    @Override // h4.n
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean b(@n0 Uri uri) {
        return f30529b.contains(uri.getScheme());
    }
}
