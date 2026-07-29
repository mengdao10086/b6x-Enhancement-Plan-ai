package retrofit2;

import java.io.IOException;
import java.util.Objects;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import okhttp3.b0;
import okhttp3.d0;
import okhttp3.e;
import okhttp3.e0;
import okio.f0;
import okio.t0;
import okio.v0;

/* JADX INFO: loaded from: classes6.dex */
public final class l<T> implements retrofit2.b<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q f48602a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object[] f48603b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e.a f48604c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final f<e0, T> f48605d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile boolean f48606e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @GuardedBy("this")
    @Nullable
    public okhttp3.e f48607f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @GuardedBy("this")
    @Nullable
    public Throwable f48608g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @GuardedBy("this")
    public boolean f48609h;

    public class a implements okhttp3.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f48610a;

        public a(d dVar) {
            this.f48610a = dVar;
        }

        public final void a(Throwable th2) {
            try {
                this.f48610a.a(l.this, th2);
            } catch (Throwable th3) {
                w.s(th3);
                th3.printStackTrace();
            }
        }

        @Override // okhttp3.f
        public void c(okhttp3.e eVar, d0 d0Var) {
            try {
                try {
                    this.f48610a.b(l.this, l.this.d(d0Var));
                } catch (Throwable th2) {
                    w.s(th2);
                    th2.printStackTrace();
                }
            } catch (Throwable th3) {
                w.s(th3);
                a(th3);
            }
        }

        @Override // okhttp3.f
        public void d(okhttp3.e eVar, IOException iOException) {
            a(iOException);
        }
    }

    public static final class b extends e0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final e0 f48612a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final okio.l f48613b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        public IOException f48614c;

        public class a extends okio.u {
            public a(t0 t0Var) {
                super(t0Var);
            }

            @Override // okio.u, okio.t0
            public long F1(okio.j jVar, long j10) throws IOException {
                try {
                    return super.F1(jVar, j10);
                } catch (IOException e10) {
                    b.this.f48614c = e10;
                    throw e10;
                }
            }
        }

        public b(e0 e0Var) {
            this.f48612a = e0Var;
            this.f48613b = f0.e(new a(e0Var.source()));
        }

        public void a() throws IOException {
            IOException iOException = this.f48614c;
            if (iOException != null) {
                throw iOException;
            }
        }

        @Override // okhttp3.e0, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f48612a.close();
        }

        @Override // okhttp3.e0
        public long contentLength() {
            return this.f48612a.contentLength();
        }

        @Override // okhttp3.e0
        public okhttp3.w contentType() {
            return this.f48612a.contentType();
        }

        @Override // okhttp3.e0
        public okio.l source() {
            return this.f48613b;
        }
    }

    public static final class c extends e0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public final okhttp3.w f48616a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f48617b;

        public c(@Nullable okhttp3.w wVar, long j10) {
            this.f48616a = wVar;
            this.f48617b = j10;
        }

        @Override // okhttp3.e0
        public long contentLength() {
            return this.f48617b;
        }

        @Override // okhttp3.e0
        public okhttp3.w contentType() {
            return this.f48616a;
        }

        @Override // okhttp3.e0
        public okio.l source() {
            throw new IllegalStateException("Cannot read raw response body of a converted body.");
        }
    }

    public l(q qVar, Object[] objArr, e.a aVar, f<e0, T> fVar) {
        this.f48602a = qVar;
        this.f48603b = objArr;
        this.f48604c = aVar;
        this.f48605d = fVar;
    }

    @Override // retrofit2.b
    public synchronized b0 T() {
        try {
        } catch (IOException e10) {
            throw new RuntimeException("Unable to create request.", e10);
        }
        return c().T();
    }

    @Override // retrofit2.b
    public synchronized v0 U() {
        try {
        } catch (IOException e10) {
            throw new RuntimeException("Unable to create call.", e10);
        }
        return c().U();
    }

    @Override // retrofit2.b
    public boolean W() {
        boolean z10 = true;
        if (this.f48606e) {
            return true;
        }
        synchronized (this) {
            okhttp3.e eVar = this.f48607f;
            if (eVar == null || !eVar.W()) {
                z10 = false;
            }
        }
        return z10;
    }

    @Override // retrofit2.b
    public r<T> X() throws IOException {
        okhttp3.e eVarC;
        synchronized (this) {
            if (this.f48609h) {
                throw new IllegalStateException("Already executed.");
            }
            this.f48609h = true;
            eVarC = c();
        }
        if (this.f48606e) {
            eVarC.cancel();
        }
        return d(eVarC.X());
    }

    @Override // retrofit2.b
    public synchronized boolean Z() {
        return this.f48609h;
    }

    @Override // retrofit2.b
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public l<T> clone() {
        return new l<>(this.f48602a, this.f48603b, this.f48604c, this.f48605d);
    }

    public final okhttp3.e b() throws IOException {
        okhttp3.e eVarA = this.f48604c.a(this.f48602a.a(this.f48603b));
        Objects.requireNonNull(eVarA, "Call.Factory returned null.");
        return eVarA;
    }

    @GuardedBy("this")
    public final okhttp3.e c() throws IOException {
        okhttp3.e eVar = this.f48607f;
        if (eVar != null) {
            return eVar;
        }
        Throwable th2 = this.f48608g;
        if (th2 != null) {
            if (th2 instanceof IOException) {
                throw ((IOException) th2);
            }
            if (th2 instanceof RuntimeException) {
                throw ((RuntimeException) th2);
            }
            throw ((Error) th2);
        }
        try {
            okhttp3.e eVarB = b();
            this.f48607f = eVarB;
            return eVarB;
        } catch (IOException | Error | RuntimeException e10) {
            w.s(e10);
            this.f48608g = e10;
            throw e10;
        }
    }

    @Override // retrofit2.b
    public void cancel() {
        okhttp3.e eVar;
        this.f48606e = true;
        synchronized (this) {
            eVar = this.f48607f;
        }
        if (eVar != null) {
            eVar.cancel();
        }
    }

    public r<T> d(d0 d0Var) throws IOException {
        e0 e0VarL = d0Var.L();
        d0 d0VarC = d0Var.s1().b(new c(e0VarL.contentType(), e0VarL.contentLength())).c();
        int iW = d0VarC.W();
        if (iW < 200 || iW >= 300) {
            try {
                return r.d(w.a(e0VarL), d0VarC);
            } finally {
                e0VarL.close();
            }
        }
        if (iW == 204 || iW == 205) {
            e0VarL.close();
            return r.m(null, d0VarC);
        }
        b bVar = new b(e0VarL);
        try {
            return r.m(this.f48605d.a(bVar), d0VarC);
        } catch (RuntimeException e10) {
            bVar.a();
            throw e10;
        }
    }

    @Override // retrofit2.b
    public void z(d<T> dVar) {
        okhttp3.e eVar;
        Throwable th2;
        Objects.requireNonNull(dVar, "callback == null");
        synchronized (this) {
            if (this.f48609h) {
                throw new IllegalStateException("Already executed.");
            }
            this.f48609h = true;
            eVar = this.f48607f;
            th2 = this.f48608g;
            if (eVar == null && th2 == null) {
                try {
                    okhttp3.e eVarB = b();
                    this.f48607f = eVarB;
                    eVar = eVarB;
                } catch (Throwable th3) {
                    th2 = th3;
                    w.s(th2);
                    this.f48608g = th2;
                }
            }
        }
        if (th2 != null) {
            dVar.a(this, th2);
            return;
        }
        if (this.f48606e) {
            eVar.cancel();
        }
        eVar.b0(new a(dVar));
    }
}
