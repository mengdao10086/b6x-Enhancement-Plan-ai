package org.bouncycastle.pqc.crypto.xmss;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes6.dex */
public final class a implements c0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<String, a> f45814c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f45815a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f45816b;

    static {
        HashMap map = new HashMap();
        map.put(b("SHA-256", 32, 16, 67, 20, 2), new a(1, "XMSSMT_SHA2_20/2_256"));
        map.put(b("SHA-256", 32, 16, 67, 20, 4), new a(2, "XMSSMT_SHA2_20/4_256"));
        map.put(b("SHA-256", 32, 16, 67, 40, 2), new a(3, "XMSSMT_SHA2_40/2_256"));
        map.put(b("SHA-256", 32, 16, 67, 40, 2), new a(4, "XMSSMT_SHA2_40/4_256"));
        map.put(b("SHA-256", 32, 16, 67, 40, 4), new a(5, "XMSSMT_SHA2_40/8_256"));
        map.put(b("SHA-256", 32, 16, 67, 60, 8), new a(6, "XMSSMT_SHA2_60/3_256"));
        map.put(b("SHA-256", 32, 16, 67, 60, 6), new a(7, "XMSSMT_SHA2_60/6_256"));
        map.put(b("SHA-256", 32, 16, 67, 60, 12), new a(8, "XMSSMT_SHA2_60/12_256"));
        map.put(b("SHA-512", 64, 16, 131, 20, 2), new a(9, "XMSSMT_SHA2_20/2_512"));
        map.put(b("SHA-512", 64, 16, 131, 20, 4), new a(10, "XMSSMT_SHA2_20/4_512"));
        map.put(b("SHA-512", 64, 16, 131, 40, 2), new a(11, "XMSSMT_SHA2_40/2_512"));
        map.put(b("SHA-512", 64, 16, 131, 40, 4), new a(12, "XMSSMT_SHA2_40/4_512"));
        map.put(b("SHA-512", 64, 16, 131, 40, 8), new a(13, "XMSSMT_SHA2_40/8_512"));
        map.put(b("SHA-512", 64, 16, 131, 60, 3), new a(14, "XMSSMT_SHA2_60/3_512"));
        map.put(b("SHA-512", 64, 16, 131, 60, 6), new a(15, "XMSSMT_SHA2_60/6_512"));
        map.put(b("SHA-512", 64, 16, 131, 60, 12), new a(16, "XMSSMT_SHA2_60/12_512"));
        map.put(b("SHAKE128", 32, 16, 67, 20, 2), new a(17, "XMSSMT_SHAKE_20/2_256"));
        map.put(b("SHAKE128", 32, 16, 67, 20, 4), new a(18, "XMSSMT_SHAKE_20/4_256"));
        map.put(b("SHAKE128", 32, 16, 67, 40, 2), new a(19, "XMSSMT_SHAKE_40/2_256"));
        map.put(b("SHAKE128", 32, 16, 67, 40, 4), new a(20, "XMSSMT_SHAKE_40/4_256"));
        map.put(b("SHAKE128", 32, 16, 67, 40, 8), new a(21, "XMSSMT_SHAKE_40/8_256"));
        map.put(b("SHAKE128", 32, 16, 67, 60, 3), new a(22, "XMSSMT_SHAKE_60/3_256"));
        map.put(b("SHAKE128", 32, 16, 67, 60, 6), new a(23, "XMSSMT_SHAKE_60/6_256"));
        map.put(b("SHAKE128", 32, 16, 67, 60, 12), new a(24, "XMSSMT_SHAKE_60/12_256"));
        map.put(b("SHAKE256", 64, 16, 131, 20, 2), new a(25, "XMSSMT_SHAKE_20/2_512"));
        map.put(b("SHAKE256", 64, 16, 131, 20, 4), new a(26, "XMSSMT_SHAKE_20/4_512"));
        map.put(b("SHAKE256", 64, 16, 131, 40, 2), new a(27, "XMSSMT_SHAKE_40/2_512"));
        map.put(b("SHAKE256", 64, 16, 131, 40, 4), new a(28, "XMSSMT_SHAKE_40/4_512"));
        map.put(b("SHAKE256", 64, 16, 131, 40, 8), new a(29, "XMSSMT_SHAKE_40/8_512"));
        map.put(b("SHAKE256", 64, 16, 131, 60, 3), new a(30, "XMSSMT_SHAKE_60/3_512"));
        map.put(b("SHAKE256", 64, 16, 131, 60, 6), new a(31, "XMSSMT_SHAKE_60/6_512"));
        map.put(b("SHAKE256", 64, 16, 131, 60, 12), new a(32, "XMSSMT_SHAKE_60/12_512"));
        f45814c = Collections.unmodifiableMap(map);
    }

    public a(int i10, String str) {
        this.f45815a = i10;
        this.f45816b = str;
    }

    public static String b(String str, int i10, int i11, int i12, int i13, int i14) {
        Objects.requireNonNull(str, "algorithmName == null");
        return str + "-" + i10 + "-" + i11 + "-" + i12 + "-" + i13 + "-" + i14;
    }

    public static a c(String str, int i10, int i11, int i12, int i13, int i14) {
        Objects.requireNonNull(str, "algorithmName == null");
        return f45814c.get(b(str, i10, i11, i12, i13, i14));
    }

    @Override // org.bouncycastle.pqc.crypto.xmss.c0
    public int a() {
        return this.f45815a;
    }

    @Override // org.bouncycastle.pqc.crypto.xmss.c0
    public String toString() {
        return this.f45816b;
    }
}
