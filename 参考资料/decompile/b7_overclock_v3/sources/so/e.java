package so;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.cms.CMSException;

/* JADX INFO: loaded from: classes5.dex */
public class e implements org.bouncycastle.util.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public y1 f50147a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public mm.n f50148b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public n1 f50149c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public zn.b f50150d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public gm.h0 f50151e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public byte[] f50152f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public gm.h0 f50153g;

    public class a implements i0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ mm.q f50154a;

        public a(mm.q qVar) {
            this.f50154a = qVar;
        }

        @Override // so.i0
        public gm.y a() {
            return this.f50154a.y();
        }

        @Override // so.i0
        public InputStream c() throws CMSException, IOException {
            return new ByteArrayInputStream(org.bouncycastle.util.a.B(this.f50154a.z().J(), e.this.f50152f));
        }
    }

    public class b implements so.a {
        public b() {
        }

        @Override // so.a
        public boolean a() {
            return true;
        }

        @Override // so.a
        public gm.h0 b() {
            return e.this.f50151e;
        }
    }

    public e(InputStream inputStream) throws CMSException {
        this(t0.u(inputStream));
    }

    public e(mm.n nVar) throws CMSException {
        this.f50148b = nVar;
        mm.d dVarA = mm.d.A(nVar.x());
        if (dVarA.C() != null) {
            this.f50149c = new n1(dVarA.C());
        }
        gm.h0 h0VarD = dVarA.D();
        mm.q qVarY = dVarA.y();
        this.f50150d = qVarY.x();
        this.f50152f = dVarA.B().J();
        a aVar = new a(qVarY);
        this.f50151e = dVarA.x();
        this.f50153g = dVarA.E();
        this.f50147a = this.f50151e != null ? b0.b(h0VarD, this.f50150d, aVar, new b()) : b0.a(h0VarD, this.f50150d, aVar);
    }

    public e(byte[] bArr) throws CMSException {
        this(t0.v(bArr));
    }

    public mm.b c() {
        gm.h0 h0Var = this.f50151e;
        if (h0Var == null) {
            return null;
        }
        return new mm.b(h0Var);
    }

    public byte[] d() {
        return org.bouncycastle.util.a.p(this.f50152f);
    }

    public n1 e() {
        return this.f50149c;
    }

    public y1 f() {
        return this.f50147a;
    }

    public mm.b g() {
        gm.h0 h0Var = this.f50153g;
        if (h0Var == null) {
            return null;
        }
        return new mm.b(h0Var);
    }

    @Override // org.bouncycastle.util.g
    public byte[] getEncoded() throws IOException {
        return this.f50148b.getEncoded();
    }

    public mm.n h() {
        return this.f50148b;
    }
}
