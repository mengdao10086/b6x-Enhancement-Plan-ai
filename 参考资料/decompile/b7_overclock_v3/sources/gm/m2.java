package gm;

/* JADX INFO: loaded from: classes5.dex */
public class m2 extends l0 {
    public m2(String str) {
        super(str);
    }

    public m2(byte[] bArr) {
        this(bArr, true);
    }

    public m2(byte[] bArr, boolean z10) {
        super(bArr, z10);
    }

    public static m2 K(n0 n0Var, boolean z10) {
        c0 c0VarU = n0Var.U();
        return (z10 || (c0VarU instanceof m2)) ? L(c0VarU) : new m2(z.I(c0VarU).J(), true);
    }

    public static m2 L(Object obj) {
        if (obj == null || (obj instanceof m2)) {
            return (m2) obj;
        }
        if (obj instanceof l0) {
            return new m2(((l0) obj).f29736a, false);
        }
        if (!(obj instanceof byte[])) {
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
        try {
            return (m2) c0.D((byte[]) obj);
        } catch (Exception e10) {
            throw new IllegalArgumentException("encoding error in getInstance: " + e10.toString());
        }
    }
}
