package cr;

import cp.z;
import gm.y;
import java.security.spec.AlgorithmParameterSpec;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class k implements AlgorithmParameterSpec {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Map f25824c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f25825a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f25826b;

    static {
        HashMap map = new HashMap();
        f25824c = map;
        map.put(qm.a.f47458h, "E-A");
        f25824c.put(qm.a.f47459i, "E-B");
        f25824c.put(qm.a.f47460j, "E-C");
        f25824c.put(qm.a.f47461k, "E-D");
        f25824c.put(qn.a.f47530t, "Param-Z");
    }

    public k(y yVar, byte[] bArr) {
        this(a(yVar));
        this.f25825a = org.bouncycastle.util.a.p(bArr);
    }

    public k(String str) {
        this.f25825a = null;
        this.f25826b = null;
        this.f25826b = z.j(str);
    }

    public k(String str, byte[] bArr) {
        this(str);
        byte[] bArr2 = new byte[bArr.length];
        this.f25825a = bArr2;
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
    }

    public k(byte[] bArr) {
        this.f25825a = null;
        this.f25826b = null;
        byte[] bArr2 = new byte[bArr.length];
        this.f25826b = bArr2;
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
    }

    public k(byte[] bArr, byte[] bArr2) {
        this(bArr);
        byte[] bArr3 = new byte[bArr2.length];
        this.f25825a = bArr3;
        System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
    }

    public static String a(y yVar) {
        String str = (String) f25824c.get(yVar);
        if (str != null) {
            return str;
        }
        throw new IllegalArgumentException("unknown OID: " + yVar);
    }

    public byte[] b() {
        return org.bouncycastle.util.a.p(this.f25826b);
    }

    public byte[] c() {
        return org.bouncycastle.util.a.p(this.f25825a);
    }
}
