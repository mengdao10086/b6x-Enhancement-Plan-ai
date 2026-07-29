package as;

import fp.g0;
import fp.j0;
import gm.y;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import kn.d;
import np.n1;
import org.bouncycastle.openssl.PEMException;
import org.bouncycastle.util.j;
import pn.s;
import zo.c0;

/* JADX INFO: loaded from: classes6.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map f8876a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set f8877b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Set f8878c;

    static {
        HashMap map = new HashMap();
        f8876a = map;
        HashSet hashSet = new HashSet();
        f8877b = hashSet;
        HashSet hashSet2 = new HashSet();
        f8878c = hashSet2;
        hashSet.add(s.Q3);
        hashSet.add(s.R3);
        hashSet.add(s.S3);
        hashSet.add(s.T3);
        hashSet.add(s.U3);
        hashSet.add(s.V3);
        hashSet2.add(s.W3);
        y yVar = s.Z3;
        hashSet2.add(yVar);
        y yVar2 = d.f37625y;
        hashSet2.add(yVar2);
        y yVar3 = d.G;
        hashSet2.add(yVar3);
        y yVar4 = d.O;
        hashSet2.add(yVar4);
        map.put(yVar.L(), j.g(192));
        map.put(yVar2.L(), j.g(128));
        map.put(yVar3.L(), j.g(192));
        map.put(yVar4.L(), j.g(256));
        map.put(s.f46814i6.L(), j.g(128));
        map.put(s.f46817j6, j.g(40));
        map.put(s.f46823l6, j.g(128));
        map.put(s.f46820k6, j.g(192));
        map.put(s.f46826m6, j.g(128));
        map.put(s.f46829n6, j.g(40));
    }

    /* JADX WARN: Removed duplicated region for block: B:63:0x0132 A[Catch: Exception -> 0x016c, TRY_ENTER, TryCatch #0 {Exception -> 0x016c, blocks: (B:63:0x0132, B:67:0x0140, B:69:0x014c, B:72:0x0166, B:68:0x0144, B:64:0x0138), top: B:81:0x0130 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0138 A[Catch: Exception -> 0x016c, TryCatch #0 {Exception -> 0x016c, blocks: (B:63:0x0132, B:67:0x0140, B:69:0x014c, B:72:0x0166, B:68:0x0144, B:64:0x0138), top: B:81:0x0130 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0140 A[Catch: Exception -> 0x016c, TryCatch #0 {Exception -> 0x016c, blocks: (B:63:0x0132, B:67:0x0140, B:69:0x014c, B:72:0x0166, B:68:0x0144, B:64:0x0138), top: B:81:0x0130 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0144 A[Catch: Exception -> 0x016c, TryCatch #0 {Exception -> 0x016c, blocks: (B:63:0x0132, B:67:0x0140, B:69:0x014c, B:72:0x0166, B:68:0x0144, B:64:0x0138), top: B:81:0x0130 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0165 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0166 A[Catch: Exception -> 0x016c, TRY_LEAVE, TryCatch #0 {Exception -> 0x016c, blocks: (B:63:0x0132, B:67:0x0140, B:69:0x014c, B:72:0x0166, B:68:0x0144, B:64:0x0138), top: B:81:0x0130 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static byte[] a(boolean r16, byte[] r17, char[] r18, java.lang.String r19, byte[] r20) throws org.bouncycastle.openssl.PEMException {
        /*
            Method dump skipped, instruction units count: 419
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: as.b.a(boolean, byte[], char[], java.lang.String, byte[]):byte[]");
    }

    public static n1 b(String str, char[] cArr, byte[] bArr, int i10) {
        j0 j0Var = new j0(new c0());
        j0Var.j(org.bouncycastle.crypto.c0.b(cArr), bArr, i10);
        return (n1) j0Var.e(e(str));
    }

    public static n1 c(char[] cArr, int i10, byte[] bArr) throws PEMException {
        return d(cArr, i10, bArr, false);
    }

    public static n1 d(char[] cArr, int i10, byte[] bArr, boolean z10) throws PEMException {
        g0 g0Var = new g0();
        g0Var.j(org.bouncycastle.crypto.c0.b(cArr), bArr, 1);
        n1 n1Var = (n1) g0Var.e(i10 * 8);
        if (!z10 || n1Var.a().length != 24) {
            return n1Var;
        }
        byte[] bArrA = n1Var.a();
        System.arraycopy(bArrA, 0, bArrA, 16, 8);
        return new n1(bArrA);
    }

    public static int e(String str) {
        Map map = f8876a;
        if (map.containsKey(str)) {
            return ((Integer) map.get(str)).intValue();
        }
        throw new IllegalStateException("no key size for algorithm: " + str);
    }

    public static boolean f(y yVar) {
        return yVar.L().startsWith(s.f46811h6.L());
    }

    public static boolean g(y yVar) {
        return f8877b.contains(yVar);
    }

    public static boolean h(y yVar) {
        return f8878c.contains(yVar);
    }
}
