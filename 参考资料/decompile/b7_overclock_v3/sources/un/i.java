package un;

import gm.c0;
import gm.f0;
import gm.f2;
import gm.j2;
import gm.w;
import gm.z;
import java.util.Enumeration;

/* JADX INFO: loaded from: classes5.dex */
public class i extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f0 f52308a;

    public i(f0 f0Var) {
        for (int i10 = 0; i10 != f0Var.size(); i10++) {
            if (!(f0Var.K(i10) instanceof f2)) {
                throw new IllegalArgumentException("unknown object in constructor: " + f0Var.K(i10).getClass().getName());
            }
        }
        this.f52308a = f0Var;
    }

    public i(byte[] bArr) {
        this(new byte[][]{bArr});
    }

    public i(byte[][] bArr) {
        gm.i iVar = new gm.i(bArr.length);
        for (int i10 = 0; i10 != bArr.length; i10++) {
            iVar.a(new f2(org.bouncycastle.util.a.p(bArr[i10])));
        }
        this.f52308a = new j2(iVar);
    }

    public static i y(Object obj) {
        if (obj instanceof i) {
            return (i) obj;
        }
        if (obj != null) {
            return new i(f0.J(obj));
        }
        return null;
    }

    public byte[][] A() {
        int size = this.f52308a.size();
        byte[][] bArr = new byte[size][];
        for (int i10 = 0; i10 != size; i10++) {
            bArr[i10] = org.bouncycastle.util.a.p(z.I(this.f52308a.K(i10)).J());
        }
        return bArr;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        return this.f52308a;
    }

    public boolean x(byte[] bArr) {
        Enumeration enumerationL = this.f52308a.L();
        while (enumerationL.hasMoreElements()) {
            if (org.bouncycastle.util.a.I(bArr, z.I(enumerationL.nextElement()).J())) {
                return true;
            }
        }
        return false;
    }

    public int z() {
        return this.f52308a.size();
    }
}
