package mm;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1ParsingException;

/* JADX INFO: loaded from: classes5.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.g0 f41302a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public gm.t f41303b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public gm.h f41304c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f41305d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f41306e;

    public e(gm.g0 g0Var) throws IOException {
        this.f41302a = g0Var;
        gm.t tVarI = gm.t.I(g0Var.readObject());
        this.f41303b = tVarI;
        if (!tVarI.L(0)) {
            throw new ASN1ParsingException("AuthEnvelopedData version number must be 0");
        }
    }

    public gm.i0 a() throws IOException {
        if (this.f41304c == null) {
            this.f41304c = this.f41302a.readObject();
        }
        gm.h hVar = this.f41304c;
        if (hVar instanceof gm.o0) {
            this.f41304c = null;
            return (gm.i0) gm.v0.p((gm.o0) hVar, 1, false, 17);
        }
        if (this.f41306e) {
            return null;
        }
        throw new ASN1ParsingException("authAttrs must be present with non-data content");
    }

    public r b() throws IOException {
        if (this.f41304c == null) {
            this.f41304c = this.f41302a.readObject();
        }
        gm.h hVar = this.f41304c;
        if (hVar == null) {
            return null;
        }
        this.f41304c = null;
        r rVar = new r((gm.g0) hVar);
        this.f41306e = k.I2.C(rVar.b());
        return rVar;
    }

    public gm.z c() throws IOException {
        if (this.f41304c == null) {
            this.f41304c = this.f41302a.readObject();
        }
        gm.h hVar = this.f41304c;
        this.f41304c = null;
        return gm.z.I(hVar.b());
    }

    public g0 d() throws IOException {
        this.f41305d = true;
        if (this.f41304c == null) {
            this.f41304c = this.f41302a.readObject();
        }
        gm.h hVar = this.f41304c;
        if (hVar instanceof gm.o0) {
            gm.o0 o0Var = (gm.o0) hVar;
            if (o0Var.s(0)) {
                gm.g0 g0Var = (gm.g0) o0Var.p(false, 16);
                this.f41304c = null;
                return g0.A(g0Var.o());
            }
        }
        return null;
    }

    public gm.i0 e() throws IOException {
        if (!this.f41305d) {
            d();
        }
        if (this.f41304c == null) {
            this.f41304c = this.f41302a.readObject();
        }
        gm.i0 i0Var = (gm.i0) this.f41304c;
        this.f41304c = null;
        return i0Var;
    }

    public gm.i0 f() throws IOException {
        if (this.f41304c == null) {
            this.f41304c = this.f41302a.readObject();
        }
        gm.h hVar = this.f41304c;
        if (hVar == null) {
            return null;
        }
        this.f41304c = null;
        return (gm.i0) gm.v0.p((gm.o0) hVar, 2, false, 17);
    }

    public gm.t g() {
        return this.f41303b;
    }
}
