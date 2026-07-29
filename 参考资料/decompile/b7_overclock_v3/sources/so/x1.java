package so;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.bouncycastle.cms.CMSException;
import so.b0;

/* JADX INFO: loaded from: classes5.dex */
public abstract class x1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public v1 f50340a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public zn.b f50341b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public zn.b f50342c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public i0 f50343d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public a f50344e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public byte[] f50345f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public z1 f50346g;

    public x1(zn.b bVar, zn.b bVar2, i0 i0Var, a aVar) {
        this.f50341b = bVar;
        this.f50342c = bVar2;
        this.f50343d = i0Var;
        this.f50344e = aVar;
    }

    public final byte[] a(gm.h hVar) throws IOException {
        if (hVar != null) {
            return hVar.b().getEncoded();
        }
        return null;
    }

    public byte[] b(u1 u1Var) throws CMSException {
        try {
            return t0.w(d(u1Var).b());
        } catch (IOException e10) {
            throw new CMSException("unable to parse internal stream: " + e10.getMessage(), e10);
        }
    }

    public byte[] c() {
        i0 i0Var = this.f50343d;
        if (i0Var instanceof b0.b) {
            return ((b0.b) i0Var).d();
        }
        return null;
    }

    public s0 d(u1 u1Var) throws CMSException, IOException {
        this.f50346g = k(u1Var);
        a aVar = this.f50344e;
        if (aVar == null) {
            return new s0(this.f50343d.a(), this.f50346g.b(this.f50343d.c()));
        }
        if (!aVar.a()) {
            return new s0(this.f50343d.a(), this.f50343d.c());
        }
        this.f50346g.a().write(this.f50344e.b().v(gm.j.f29713a));
        return new s0(this.f50343d.a(), this.f50346g.b(this.f50343d.c()));
    }

    public gm.y e() {
        return this.f50343d.a();
    }

    public String f() {
        return this.f50341b.x().L();
    }

    public byte[] g() {
        try {
            return a(this.f50341b.A());
        } catch (Exception e10) {
            throw new RuntimeException("exception getting encryption parameters " + e10);
        }
    }

    public zn.b h() {
        return this.f50341b;
    }

    public byte[] i() {
        if (this.f50345f == null && this.f50346g.e()) {
            if (this.f50344e != null) {
                try {
                    kt.c.a(this.f50346g.b(new ByteArrayInputStream(this.f50344e.b().v(gm.j.f29713a))));
                } catch (IOException e10) {
                    throw new IllegalStateException("unable to drain input: " + e10.getMessage());
                }
            }
            this.f50345f = this.f50346g.c();
        }
        return this.f50345f;
    }

    public v1 j() {
        return this.f50340a;
    }

    public abstract z1 k(u1 u1Var) throws CMSException, IOException;
}
