package rp;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, Integer> f49074a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f49075b = 188;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f49076c = 12748;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f49077d = 13004;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f49078e = 13260;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f49079f = 13516;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f49080g = 13772;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f49081h = 14028;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f49082i = 14284;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f49083j = 14540;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f49084k = 14796;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f49085l = 15052;

    static {
        HashMap map = new HashMap();
        map.put("RIPEMD128", org.bouncycastle.util.j.g(13004));
        map.put("RIPEMD160", org.bouncycastle.util.j.g(12748));
        map.put(et.e.f27137f, org.bouncycastle.util.j.g(13260));
        map.put(et.e.f27138g, org.bouncycastle.util.j.g(14540));
        map.put("SHA-256", org.bouncycastle.util.j.g(13516));
        map.put(et.e.f27140i, org.bouncycastle.util.j.g(14028));
        map.put("SHA-512", org.bouncycastle.util.j.g(13772));
        map.put("SHA-512/224", org.bouncycastle.util.j.g(f49084k));
        map.put(rs.h.f49168c, org.bouncycastle.util.j.g(f49085l));
        map.put("Whirlpool", org.bouncycastle.util.j.g(14284));
        f49074a = Collections.unmodifiableMap(map);
    }

    public static Integer a(org.bouncycastle.crypto.s sVar) {
        return f49074a.get(sVar.b());
    }

    public static boolean b(org.bouncycastle.crypto.s sVar) {
        return !f49074a.containsKey(sVar.b());
    }
}
