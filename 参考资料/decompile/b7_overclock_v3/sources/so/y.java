package so;

import gm.l2;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.cms.CMSException;
import so.b0;

/* JADX INFO: loaded from: classes5.dex */
public class y extends r {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public y1 f50347c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public mm.u f50348d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public zn.b f50349e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public mm.b f50350f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f50351g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public n1 f50352h;

    public y(InputStream inputStream) throws CMSException, IOException {
        super(inputStream);
        this.f50351g = true;
        mm.u uVar = new mm.u((gm.g0) this.f50297a.a(16));
        this.f50348d = uVar;
        mm.g0 g0VarB = uVar.b();
        if (g0VarB != null) {
            this.f50352h = new n1(g0VarB);
        }
        gm.h0 h0VarI = gm.h0.I(this.f50348d.c().b());
        mm.r rVarA = this.f50348d.a();
        this.f50349e = rVarA.a();
        this.f50347c = b0.a(h0VarI, this.f50349e, new b0.c(this.f50349e, rVarA.b(), new g0(((gm.a0) rVarA.c(4)).a())));
    }

    public y(byte[] bArr) throws CMSException, IOException {
        this(new ByteArrayInputStream(bArr));
    }

    public final byte[] b(gm.h hVar) throws IOException {
        if (hVar != null) {
            return hVar.b().getEncoded();
        }
        return null;
    }

    public zn.b c() {
        return this.f50349e;
    }

    public String d() {
        return this.f50349e.x().toString();
    }

    public byte[] e() {
        try {
            return b(this.f50349e.A());
        } catch (Exception e10) {
            throw new RuntimeException("exception getting encryption parameters " + e10);
        }
    }

    public n1 f() {
        return this.f50352h;
    }

    public y1 g() {
        return this.f50347c;
    }

    public mm.b h() throws IOException {
        if (this.f50350f == null && this.f50351g) {
            gm.i0 i0VarD = this.f50348d.d();
            this.f50351g = false;
            if (i0VarD != null) {
                gm.i iVar = new gm.i();
                while (true) {
                    gm.h object = i0VarD.readObject();
                    if (object == null) {
                        break;
                    }
                    iVar.a(((gm.g0) object).b());
                }
                this.f50350f = new mm.b(new l2(iVar));
            }
        }
        return this.f50350f;
    }
}
