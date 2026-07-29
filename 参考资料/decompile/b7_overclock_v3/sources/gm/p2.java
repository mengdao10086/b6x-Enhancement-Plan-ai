package gm;

/* JADX INFO: loaded from: classes5.dex */
public class p2 extends r0 {
    public p2(String str) {
        super(str);
    }

    public p2(byte[] bArr, boolean z10) {
        super(bArr, z10);
    }

    public static p2 J(n0 n0Var, boolean z10) {
        c0 c0VarU = n0Var.U();
        return (z10 || (c0VarU instanceof p2)) ? K(c0VarU) : new p2(z.I(c0VarU).J(), true);
    }

    public static p2 K(Object obj) {
        if (obj == null || (obj instanceof p2)) {
            return (p2) obj;
        }
        if (obj instanceof r0) {
            return new p2(((r0) obj).f29795a, false);
        }
        if (!(obj instanceof byte[])) {
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
        try {
            return (p2) c0.D((byte[]) obj);
        } catch (Exception e10) {
            throw new IllegalArgumentException("encoding error in getInstance: " + e10.toString());
        }
    }
}
