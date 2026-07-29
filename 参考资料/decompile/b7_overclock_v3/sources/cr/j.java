package cr;

import cp.z;
import gm.y;
import java.security.spec.AlgorithmParameterSpec;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class j implements AlgorithmParameterSpec {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Map f25821c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f25822a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f25823b;

    static {
        HashMap map = new HashMap();
        f25821c = map;
        map.put(qm.a.f47458h, "E-A");
        f25821c.put(qm.a.f47459i, "E-B");
        f25821c.put(qm.a.f47460j, "E-C");
        f25821c.put(qm.a.f47461k, "E-D");
        f25821c.put(qn.a.f47530t, "Param-Z");
    }

    public j(y yVar, byte[] bArr) {
        this(b(yVar));
        this.f25822a = org.bouncycastle.util.a.p(bArr);
    }

    public j(String str) {
        this.f25822a = null;
        this.f25823b = null;
        this.f25823b = z.j(str);
    }

    public j(String str, byte[] bArr) {
        this(str);
        byte[] bArr2 = new byte[bArr.length];
        this.f25822a = bArr2;
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
    }

    public j(byte[] bArr) {
        this.f25822a = null;
        this.f25823b = null;
        byte[] bArr2 = new byte[bArr.length];
        this.f25823b = bArr2;
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
    }

    public j(byte[] bArr, byte[] bArr2) {
        this(bArr);
        byte[] bArr3 = new byte[bArr2.length];
        this.f25822a = bArr3;
        System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
    }

    public static String b(y yVar) {
        String str = (String) f25821c.get(yVar);
        if (str != null) {
            return str;
        }
        throw new IllegalArgumentException("unknown OID: " + yVar);
    }

    public byte[] a() {
        return org.bouncycastle.util.a.p(this.f25822a);
    }

    public byte[] c() {
        return org.bouncycastle.util.a.p(this.f25823b);
    }

    public byte[] d() {
        return org.bouncycastle.util.a.p(this.f25823b);
    }
}
