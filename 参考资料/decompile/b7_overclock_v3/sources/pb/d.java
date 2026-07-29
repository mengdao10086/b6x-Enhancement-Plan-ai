package pb;

import android.net.Uri;
import com.google.android.exoplayer2.ParserException;
import hb.d0;
import hb.l;
import hb.m;
import hb.p;
import hb.q;
import hb.z;
import hd.c0;
import java.io.IOException;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* JADX INFO: loaded from: classes3.dex */
public class d implements hb.k {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final q f46543g = new q() { // from class: pb.c
        @Override // hb.q
        public final hb.k[] a() {
            return d.d();
        }

        @Override // hb.q
        public /* synthetic */ hb.k[] b(Uri uri, Map map) {
            return p.a(this, uri, map);
        }
    };

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f46544h = 8;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public m f46545d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public i f46546e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f46547f;

    public static /* synthetic */ hb.k[] d() {
        return new hb.k[]{new d()};
    }

    public static c0 e(c0 c0Var) {
        c0Var.S(0);
        return c0Var;
    }

    @Override // hb.k
    public void b(long j10, long j11) {
        i iVar = this.f46546e;
        if (iVar != null) {
            iVar.m(j10, j11);
        }
    }

    @Override // hb.k
    public void c(m mVar) {
        this.f46545d = mVar;
    }

    @Override // hb.k
    public int f(l lVar, z zVar) throws IOException {
        hd.a.k(this.f46545d);
        if (this.f46546e == null) {
            if (!g(lVar)) {
                throw new ParserException("Failed to determine bitstream type");
            }
            lVar.n();
        }
        if (!this.f46547f) {
            d0 d0VarD = this.f46545d.d(0, 1);
            this.f46545d.k();
            this.f46546e.d(this.f46545d, d0VarD);
            this.f46547f = true;
        }
        return this.f46546e.g(lVar, zVar);
    }

    @EnsuresNonNullIf(expression = {"streamReader"}, result = true)
    public final boolean g(l lVar) throws IOException {
        f fVar = new f();
        if (fVar.b(lVar, true) && (fVar.f46560b & 2) == 2) {
            int iMin = Math.min(fVar.f46567i, 8);
            c0 c0Var = new c0(iMin);
            lVar.t(c0Var.d(), 0, iMin);
            if (b.p(e(c0Var))) {
                this.f46546e = new b();
            } else if (j.r(e(c0Var))) {
                this.f46546e = new j();
            } else if (h.o(e(c0Var))) {
                this.f46546e = new h();
            }
            return true;
        }
        return false;
    }

    @Override // hb.k
    public boolean i(l lVar) throws IOException {
        try {
            return g(lVar);
        } catch (ParserException unused) {
            return false;
        }
    }

    @Override // hb.k
    public void release() {
    }
}
