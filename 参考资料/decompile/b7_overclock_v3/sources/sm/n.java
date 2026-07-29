package sm;

import gm.c0;
import gm.f2;
import gm.n0;
import gm.n2;
import gm.w;
import gm.z;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes5.dex */
public class n extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f50007a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BigInteger f50008b;

    public n(int i10, BigInteger bigInteger) {
        this.f50007a = i10;
        this.f50008b = bigInteger;
    }

    public n(n0 n0Var) {
        this.f50007a = n0Var.q();
        this.f50008b = new BigInteger(1, z.H(n0Var, false).J());
    }

    public static n y(Object obj) {
        if (obj instanceof n) {
            return (n) obj;
        }
        if (obj != null) {
            return new n(n0.T(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        return new n2(false, this.f50007a, (gm.h) new f2(x()));
    }

    public int q() {
        return this.f50007a;
    }

    public final byte[] x() {
        byte[] byteArray = this.f50008b.toByteArray();
        if (byteArray[0] != 0) {
            return byteArray;
        }
        int length = byteArray.length - 1;
        byte[] bArr = new byte[length];
        System.arraycopy(byteArray, 1, bArr, 0, length);
        return bArr;
    }

    public BigInteger z() {
        return this.f50008b;
    }
}
