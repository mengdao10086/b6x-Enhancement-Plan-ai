package org.bouncycastle.pqc.crypto.xmss;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes6.dex */
public final class i implements c0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<String, i> f45900c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f45901a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f45902b;

    static {
        HashMap map = new HashMap();
        map.put(b("SHA-256", 32, 16, 67), new i(16777217, "WOTSP_SHA2-256_W16"));
        map.put(b("SHA-512", 64, 16, 131), new i(33554434, "WOTSP_SHA2-512_W16"));
        map.put(b("SHAKE128", 32, 16, 67), new i(50331651, "WOTSP_SHAKE128_W16"));
        map.put(b("SHAKE256", 64, 16, 131), new i(67108868, "WOTSP_SHAKE256_W16"));
        f45900c = Collections.unmodifiableMap(map);
    }

    public i(int i10, String str) {
        this.f45901a = i10;
        this.f45902b = str;
    }

    public static String b(String str, int i10, int i11, int i12) {
        Objects.requireNonNull(str, "algorithmName == null");
        return str + "-" + i10 + "-" + i11 + "-" + i12;
    }

    public static i c(String str, int i10, int i11, int i12) {
        Objects.requireNonNull(str, "algorithmName == null");
        return f45900c.get(b(str, i10, i11, i12));
    }

    @Override // org.bouncycastle.pqc.crypto.xmss.c0
    public int a() {
        return this.f45901a;
    }

    @Override // org.bouncycastle.pqc.crypto.xmss.c0
    public String toString() {
        return this.f45902b;
    }
}
