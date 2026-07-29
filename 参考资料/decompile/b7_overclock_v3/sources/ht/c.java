package ht;

import cs.o;
import cs.p;
import gm.c2;
import gm.y;
import gt.h;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import mm.a1;
import mm.k;
import org.bouncycastle.cms.CMSException;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.tsp.cms.ImprintDigestInvalidException;
import so.r;

/* JADX INFO: loaded from: classes6.dex */
public class c extends r {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a1 f31441c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public f f31442d;

    public c(InputStream inputStream) throws CMSException {
        super(inputStream);
        k(this.f50297a);
    }

    public c(byte[] bArr) throws CMSException {
        this(new ByteArrayInputStream(bArr));
    }

    public byte[] b(o oVar) throws CMSException {
        return this.f31442d.a(oVar);
    }

    public InputStream c() {
        if (this.f31441c.a() != null) {
            return this.f31441c.a().a();
        }
        return null;
    }

    public URI d() throws URISyntaxException {
        c2 c2VarB = this.f31441c.b();
        if (c2VarB != null) {
            return new URI(c2VarB.d());
        }
        return null;
    }

    public String e() {
        return this.f31442d.c();
    }

    public String f() {
        return this.f31442d.d();
    }

    public o g(p pVar) throws OperatorCreationException {
        try {
            l();
            return this.f31442d.e(pVar);
        } catch (CMSException e10) {
            throw new OperatorCreationException("unable to extract algorithm ID: " + e10.getMessage(), e10);
        }
    }

    public mm.b h() {
        return this.f31442d.f();
    }

    public h[] i() throws CMSException {
        l();
        return this.f31442d.h();
    }

    public void j(o oVar) throws CMSException {
        this.f31442d.j(oVar);
    }

    public final void k(mm.o oVar) throws CMSException {
        try {
            y yVar = k.S2;
            if (yVar.C(oVar.b())) {
                this.f31441c = a1.d(oVar.a(16));
                return;
            }
            throw new IllegalArgumentException("Malformed content - type must be " + yVar.L());
        } catch (IOException e10) {
            throw new CMSException("parsing exception: " + e10.getMessage(), e10);
        }
    }

    public final void l() throws CMSException {
        try {
            if (this.f31442d == null) {
                InputStream inputStreamC = c();
                if (inputStreamC != null) {
                    kt.c.a(inputStreamC);
                }
                this.f31442d = new f(this.f31441c);
            }
        } catch (IOException e10) {
            throw new CMSException("unable to parse evidence block: " + e10.getMessage(), e10);
        }
    }

    public void m(p pVar, byte[] bArr) throws ImprintDigestInvalidException, CMSException {
        l();
        this.f31442d.k(pVar, bArr);
    }

    public void n(p pVar, byte[] bArr, h hVar) throws ImprintDigestInvalidException, CMSException {
        l();
        this.f31442d.l(pVar, bArr, hVar);
    }
}
