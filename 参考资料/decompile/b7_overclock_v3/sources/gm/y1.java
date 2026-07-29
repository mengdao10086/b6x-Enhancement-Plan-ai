package gm;

/* JADX INFO: loaded from: classes5.dex */
public class y1 extends n {
    public y1(String str) {
        super(str);
    }

    public y1(byte[] bArr, boolean z10) {
        super(bArr, z10);
    }

    public static y1 K(n0 n0Var, boolean z10) {
        c0 c0VarU = n0Var.U();
        return (z10 || (c0VarU instanceof y1)) ? L(c0VarU) : new y1(z.I(c0VarU).J(), true);
    }

    public static y1 L(Object obj) {
        if (obj == null || (obj instanceof y1)) {
            return (y1) obj;
        }
        if (obj instanceof n) {
            return new y1(((n) obj).f29746a, false);
        }
        if (!(obj instanceof byte[])) {
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
        try {
            return (y1) c0.D((byte[]) obj);
        } catch (Exception e10) {
            throw new IllegalArgumentException("encoding error in getInstance: " + e10.toString());
        }
    }
}
