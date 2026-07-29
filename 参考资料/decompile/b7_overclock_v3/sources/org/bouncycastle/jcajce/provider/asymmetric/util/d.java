package org.bouncycastle.jcajce.provider.asymmetric.util;

import java.util.HashSet;
import java.util.Set;
import org.bouncycastle.util.Strings;
import pn.s;

/* JADX INFO: loaded from: classes7.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set<String> f45052a;

    static {
        HashSet hashSet = new HashSet();
        f45052a = hashSet;
        hashSet.add("DES");
        hashSet.add("DESEDE");
        hashSet.add(on.b.f44361e.L());
        hashSet.add(s.Z3.L());
        hashSet.add(s.f46835p6.L());
    }

    public static boolean a(String str) {
        return f45052a.contains(Strings.o(str));
    }

    public static void b(byte[] bArr) {
        for (int i10 = 0; i10 < bArr.length; i10++) {
            byte b10 = bArr[i10];
            bArr[i10] = (byte) (((((b10 >> 7) ^ ((((((b10 >> 1) ^ (b10 >> 2)) ^ (b10 >> 3)) ^ (b10 >> 4)) ^ (b10 >> 5)) ^ (b10 >> 6))) ^ 1) & 1) | (b10 & 254));
        }
    }
}
