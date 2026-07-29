package gm;

/* JADX INFO: loaded from: classes5.dex */
public class t1 extends c {
    public t1(String str) {
        super(str);
    }

    public t1(byte[] bArr) {
        super(bArr);
    }

    public t1(char[] cArr) {
        super(cArr);
    }

    public static t1 K(n0 n0Var, boolean z10) {
        c0 c0VarU = n0Var.U();
        return (z10 || (c0VarU instanceof t1)) ? L(c0VarU) : new t1(z.I(c0VarU).J());
    }

    public static t1 L(Object obj) {
        if (obj == null || (obj instanceof t1)) {
            return (t1) obj;
        }
        if (obj instanceof c) {
            return new t1(((c) obj).f29645a);
        }
        if (!(obj instanceof byte[])) {
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
        try {
            return (t1) c0.D((byte[]) obj);
        } catch (Exception e10) {
            throw new IllegalArgumentException("encoding error in getInstance: " + e10.toString());
        }
    }
}
