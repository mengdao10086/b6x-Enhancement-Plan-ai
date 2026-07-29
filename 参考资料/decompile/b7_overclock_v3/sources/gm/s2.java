package gm;

/* JADX INFO: loaded from: classes5.dex */
public class s2 extends x0 {
    public s2(String str) {
        super(str);
    }

    public s2(byte[] bArr, boolean z10) {
        super(bArr, z10);
    }

    public static s2 K(n0 n0Var, boolean z10) {
        c0 c0VarU = n0Var.U();
        return (z10 || (c0VarU instanceof s2)) ? L(c0VarU) : new s2(z.I(c0VarU).J(), true);
    }

    public static s2 L(Object obj) {
        if (obj == null || (obj instanceof s2)) {
            return (s2) obj;
        }
        if (obj instanceof x0) {
            return new s2(((x0) obj).f29822a, false);
        }
        if (!(obj instanceof byte[])) {
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
        try {
            return (s2) c0.D((byte[]) obj);
        } catch (Exception e10) {
            throw new IllegalArgumentException("encoding error in getInstance: " + e10.toString());
        }
    }
}
