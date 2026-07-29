package i4;

import com.bumptech.glide.load.data.j;
import g.n0;
import g.p0;
import h4.m;
import h4.n;
import h4.o;
import h4.r;
import java.io.InputStream;
import ya.k;

/* JADX INFO: loaded from: classes2.dex */
public class b implements n<h4.g, InputStream> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c4.d<Integer> f31824b = c4.d.g("com.bumptech.glide.load.model.stream.HttpGlideUrlLoader.Timeout", Integer.valueOf(k.f56856n));

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @p0
    public final m<h4.g, h4.g> f31825a;

    public static class a implements o<h4.g, InputStream> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final m<h4.g, h4.g> f31826a = new m<>(500);

        @Override // h4.o
        public void a() {
        }

        @Override // h4.o
        @n0
        public n<h4.g, InputStream> c(r rVar) {
            return new b(this.f31826a);
        }
    }

    public b() {
        this(null);
    }

    @Override // h4.n
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public n.a<InputStream> a(@n0 h4.g gVar, int i10, int i11, @n0 c4.e eVar) {
        m<h4.g, h4.g> mVar = this.f31825a;
        if (mVar != null) {
            h4.g gVarB = mVar.b(gVar, 0, 0);
            if (gVarB == null) {
                this.f31825a.c(gVar, 0, 0, gVar);
            } else {
                gVar = gVarB;
            }
        }
        return new n.a<>(gVar, new j(gVar, ((Integer) eVar.c(f31824b)).intValue()));
    }

    @Override // h4.n
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean b(@n0 h4.g gVar) {
        return true;
    }

    public b(@p0 m<h4.g, h4.g> mVar) {
        this.f31825a = mVar;
    }
}
