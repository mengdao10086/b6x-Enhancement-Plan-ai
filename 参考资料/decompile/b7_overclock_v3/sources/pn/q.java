package pn;

import gm.d2;
import gm.f0;
import gm.f2;
import gm.j2;
import java.math.BigInteger;
import java.util.Enumeration;

/* JADX INFO: loaded from: classes5.dex */
public class q extends gm.w {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final zn.b f46781e = new zn.b(s.f46806g4, d2.f29657b);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final gm.z f46782a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final gm.t f46783b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final gm.t f46784c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final zn.b f46785d;

    public q(f0 f0Var) {
        Enumeration enumerationL = f0Var.L();
        this.f46782a = (gm.z) enumerationL.nextElement();
        this.f46783b = (gm.t) enumerationL.nextElement();
        if (enumerationL.hasMoreElements()) {
            Object objNextElement = enumerationL.nextElement();
            if (objNextElement instanceof gm.t) {
                this.f46784c = gm.t.I(objNextElement);
                objNextElement = enumerationL.hasMoreElements() ? enumerationL.nextElement() : null;
            } else {
                this.f46784c = null;
            }
            if (objNextElement != null) {
                this.f46785d = zn.b.z(objNextElement);
                return;
            }
        } else {
            this.f46784c = null;
        }
        this.f46785d = null;
    }

    public q(byte[] bArr, int i10) {
        this(bArr, i10, 0);
    }

    public q(byte[] bArr, int i10, int i11) {
        this(bArr, i10, i11, null);
    }

    public q(byte[] bArr, int i10, int i11, zn.b bVar) {
        this.f46782a = new f2(org.bouncycastle.util.a.p(bArr));
        this.f46783b = new gm.t(i10);
        this.f46784c = i11 > 0 ? new gm.t(i11) : null;
        this.f46785d = bVar;
    }

    public q(byte[] bArr, int i10, zn.b bVar) {
        this(bArr, i10, 0, bVar);
    }

    public static q x(Object obj) {
        if (obj instanceof q) {
            return (q) obj;
        }
        if (obj != null) {
            return new q(f0.J(obj));
        }
        return null;
    }

    public zn.b A() {
        zn.b bVar = this.f46785d;
        return bVar != null ? bVar : f46781e;
    }

    public byte[] B() {
        return this.f46782a.J();
    }

    public boolean C() {
        zn.b bVar = this.f46785d;
        return bVar == null || bVar.equals(f46781e);
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(4);
        iVar.a(this.f46782a);
        iVar.a(this.f46783b);
        gm.t tVar = this.f46784c;
        if (tVar != null) {
            iVar.a(tVar);
        }
        zn.b bVar = this.f46785d;
        if (bVar != null && !bVar.equals(f46781e)) {
            iVar.a(this.f46785d);
        }
        return new j2(iVar);
    }

    public BigInteger y() {
        return this.f46783b.K();
    }

    public BigInteger z() {
        gm.t tVar = this.f46784c;
        if (tVar != null) {
            return tVar.K();
        }
        return null;
    }
}
