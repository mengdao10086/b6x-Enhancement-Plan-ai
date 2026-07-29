package org.bouncycastle.pqc.crypto.xmss;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes6.dex */
public final class b implements c0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<String, b> f45824c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f45825a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f45826b;

    static {
        HashMap map = new HashMap();
        map.put(b("SHA-256", 32, 16, 67, 10), new b(1, "XMSS_SHA2_10_256"));
        map.put(b("SHA-256", 32, 16, 67, 16), new b(2, "XMSS_SHA2_16_256"));
        map.put(b("SHA-256", 32, 16, 67, 20), new b(3, "XMSS_SHA2_20_256"));
        map.put(b("SHA-512", 64, 16, 131, 10), new b(4, "XMSS_SHA2_10_512"));
        map.put(b("SHA-512", 64, 16, 131, 16), new b(5, "XMSS_SHA2_16_512"));
        map.put(b("SHA-512", 64, 16, 131, 20), new b(6, "XMSS_SHA2_20_512"));
        map.put(b("SHAKE128", 32, 16, 67, 10), new b(7, "XMSS_SHAKE_10_256"));
        map.put(b("SHAKE128", 32, 16, 67, 16), new b(8, "XMSS_SHAKE_16_256"));
        map.put(b("SHAKE128", 32, 16, 67, 20), new b(9, "XMSS_SHAKE_20_256"));
        map.put(b("SHAKE256", 64, 16, 131, 10), new b(10, "XMSS_SHAKE_10_512"));
        map.put(b("SHAKE256", 64, 16, 131, 16), new b(11, "XMSS_SHAKE_16_512"));
        map.put(b("SHAKE256", 64, 16, 131, 20), new b(12, "XMSS_SHAKE_20_512"));
        f45824c = Collections.unmodifiableMap(map);
    }

    public b(int i10, String str) {
        this.f45825a = i10;
        this.f45826b = str;
    }

    public static String b(String str, int i10, int i11, int i12, int i13) {
        Objects.requireNonNull(str, "algorithmName == null");
        return str + "-" + i10 + "-" + i11 + "-" + i12 + "-" + i13;
    }

    public static b c(String str, int i10, int i11, int i12, int i13) {
        Objects.requireNonNull(str, "algorithmName == null");
        return f45824c.get(b(str, i10, i11, i12, i13));
    }

    @Override // org.bouncycastle.pqc.crypto.xmss.c0
    public int a() {
        return this.f45825a;
    }

    @Override // org.bouncycastle.pqc.crypto.xmss.c0
    public String toString() {
        return this.f45826b;
    }
}
