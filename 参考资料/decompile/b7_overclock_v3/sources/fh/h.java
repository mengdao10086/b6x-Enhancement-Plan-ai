package fh;

import java.io.IOException;
import okhttp3.c0;
import okhttp3.w;
import okio.f0;
import okio.r0;
import okio.t;

/* JADX INFO: loaded from: classes5.dex */
public class h extends c0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c0 f28473b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final gh.c f28474c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public okio.k f28475d;

    public class a extends t {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f28476b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f28477c;

        public a(r0 r0Var) {
            super(r0Var);
            this.f28476b = 0L;
            this.f28477c = 0L;
        }

        @Override // okio.t, okio.r0
        public void V0(okio.j jVar, long j10) throws IOException {
            super.V0(jVar, j10);
            if (this.f28477c == 0) {
                this.f28477c = h.this.a();
            }
            this.f28476b += j10;
            h.this.f28474c.a(this.f28476b, this.f28477c);
        }
    }

    public h(c0 c0Var, gh.c cVar) {
        this.f28473b = c0Var;
        this.f28474c = cVar;
    }

    @Override // okhttp3.c0
    public long a() throws IOException {
        return this.f28473b.a();
    }

    @Override // okhttp3.c0
    public w b() {
        return this.f28473b.b();
    }

    @Override // okhttp3.c0
    public void r(okio.k kVar) throws IOException {
        try {
            if (this.f28475d == null) {
                this.f28475d = f0.d(t(kVar));
            }
            this.f28473b.r(this.f28475d);
            this.f28475d.flush();
        } catch (IllegalStateException unused) {
        }
    }

    public final r0 t(r0 r0Var) {
        return new a(r0Var);
    }
}
