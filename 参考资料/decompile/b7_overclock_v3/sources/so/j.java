package so;

import gm.l2;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.cms.CMSException;
import org.bouncycastle.operator.OperatorCreationException;
import so.b0;

/* JADX INFO: loaded from: classes5.dex */
public class j extends r {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public y1 f50193c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public mm.g f50194d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public zn.b f50195e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public byte[] f50196f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public mm.b f50197g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public gm.h0 f50198h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public mm.b f50199i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f50200j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f50201k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public n1 f50202l;

    public class a implements so.a {
        public a() {
        }

        @Override // so.a
        public boolean a() {
            return false;
        }

        @Override // so.a
        public gm.h0 b() {
            try {
                return j.this.d();
            } catch (IOException unused) {
                throw new IllegalStateException("can't parse authenticated attributes!");
            }
        }
    }

    public j(InputStream inputStream) throws CMSException, IOException {
        this(inputStream, (cs.p) null);
    }

    public j(InputStream inputStream, cs.p pVar) throws CMSException, IOException {
        super(inputStream);
        this.f50200j = true;
        mm.g gVar = new mm.g((gm.g0) this.f50297a.a(16));
        this.f50194d = gVar;
        mm.g0 g0VarF = gVar.f();
        if (g0VarF != null) {
            this.f50202l = new n1(g0VarF);
        }
        gm.h0 h0VarI = gm.h0.I(this.f50194d.g().b());
        this.f50195e = this.f50194d.e();
        zn.b bVarB = this.f50194d.b();
        if (bVarB == null) {
            mm.o oVarC = this.f50194d.c();
            this.f50193c = b0.a(h0VarI, this.f50195e, new b0.a(this.f50195e, oVarC.b(), new g0(((gm.a0) oVarC.a(4)).a())));
            return;
        }
        if (pVar == null) {
            throw new CMSException("a digest calculator provider is required if authenticated attributes are present");
        }
        mm.o oVarC2 = this.f50194d.c();
        try {
            this.f50193c = b0.b(h0VarI, this.f50195e, new b0.b(pVar.a(bVarB), oVarC2.b(), new g0(((gm.a0) oVarC2.a(4)).a())), new a());
        } catch (OperatorCreationException e10) {
            throw new CMSException("unable to create digest calculator: " + e10.getMessage(), e10);
        }
    }

    public j(byte[] bArr) throws CMSException, IOException {
        this(new ByteArrayInputStream(bArr));
    }

    public j(byte[] bArr, cs.p pVar) throws CMSException, IOException {
        this(new ByteArrayInputStream(bArr), pVar);
    }

    public final byte[] c(gm.h hVar) throws IOException {
        if (hVar != null) {
            return hVar.b().getEncoded();
        }
        return null;
    }

    public final gm.h0 d() throws IOException {
        if (this.f50197g == null && this.f50200j) {
            gm.i0 i0VarA = this.f50194d.a();
            if (i0VarA != null) {
                this.f50198h = (gm.h0) i0VarA.b();
            }
            this.f50200j = false;
        }
        return this.f50198h;
    }

    public mm.b e() throws IOException {
        gm.h0 h0VarD;
        if (this.f50197g == null && this.f50200j && (h0VarD = d()) != null) {
            this.f50197g = new mm.b(h0VarD);
        }
        return this.f50197g;
    }

    public byte[] f() {
        mm.b bVar = this.f50197g;
        if (bVar != null) {
            return gm.z.I(bVar.d(mm.j.f41339b).y().J(0)).J();
        }
        return null;
    }

    public byte[] g() throws IOException {
        if (this.f50196f == null) {
            e();
            this.f50196f = this.f50194d.d().J();
        }
        return org.bouncycastle.util.a.p(this.f50196f);
    }

    public String h() {
        return this.f50195e.x().toString();
    }

    public byte[] i() {
        try {
            return c(this.f50195e.A());
        } catch (Exception e10) {
            throw new RuntimeException("exception getting encryption parameters " + e10);
        }
    }

    public zn.b j() {
        return this.f50195e;
    }

    public n1 k() {
        return this.f50202l;
    }

    public y1 l() {
        return this.f50193c;
    }

    public mm.b m() throws IOException {
        if (this.f50199i == null && this.f50201k) {
            gm.i0 i0VarH = this.f50194d.h();
            this.f50201k = false;
            if (i0VarH != null) {
                gm.i iVar = new gm.i();
                while (true) {
                    gm.h object = i0VarH.readObject();
                    if (object == null) {
                        break;
                    }
                    iVar.a(((gm.g0) object).b());
                }
                this.f50199i = new mm.b(new l2(iVar));
            }
        }
        return this.f50199i;
    }
}
