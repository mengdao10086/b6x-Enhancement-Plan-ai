package fd;

import com.google.common.base.Charsets;
import g.p0;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class n implements l {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final n f28119f = new n(Collections.emptyMap());

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f28120d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, byte[]> f28121e;

    public n() {
        this(Collections.emptyMap());
    }

    public static void d(HashMap<String, byte[]> map, Map<String, Object> map2) {
        for (Map.Entry<String, Object> entry : map2.entrySet()) {
            map.put(entry.getKey(), h(entry.getValue()));
        }
    }

    public static Map<String, byte[]> e(Map<String, byte[]> map, m mVar) {
        HashMap map2 = new HashMap(map);
        j(map2, mVar.c());
        d(map2, mVar.b());
        return map2;
    }

    public static byte[] h(Object obj) {
        if (obj instanceof Long) {
            return ByteBuffer.allocate(8).putLong(((Long) obj).longValue()).array();
        }
        if (obj instanceof String) {
            return ((String) obj).getBytes(Charsets.UTF_8);
        }
        if (obj instanceof byte[]) {
            return (byte[]) obj;
        }
        throw new IllegalArgumentException();
    }

    public static boolean i(Map<String, byte[]> map, Map<String, byte[]> map2) {
        if (map.size() != map2.size()) {
            return false;
        }
        for (Map.Entry<String, byte[]> entry : map.entrySet()) {
            if (!Arrays.equals(entry.getValue(), map2.get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }

    public static void j(HashMap<String, byte[]> map, List<String> list) {
        for (int i10 = 0; i10 < list.size(); i10++) {
            map.remove(list.get(i10));
        }
    }

    @Override // fd.l
    @p0
    public final String a(String str, @p0 String str2) {
        byte[] bArr = this.f28121e.get(str);
        return bArr != null ? new String(bArr, Charsets.UTF_8) : str2;
    }

    @Override // fd.l
    public final long b(String str, long j10) {
        byte[] bArr = this.f28121e.get(str);
        return bArr != null ? ByteBuffer.wrap(bArr).getLong() : j10;
    }

    @Override // fd.l
    @p0
    public final byte[] c(String str, @p0 byte[] bArr) {
        byte[] bArr2 = this.f28121e.get(str);
        return bArr2 != null ? Arrays.copyOf(bArr2, bArr2.length) : bArr;
    }

    @Override // fd.l
    public final boolean contains(String str) {
        return this.f28121e.containsKey(str);
    }

    public boolean equals(@p0 Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || n.class != obj.getClass()) {
            return false;
        }
        return i(this.f28121e, ((n) obj).f28121e);
    }

    public n f(m mVar) {
        Map<String, byte[]> mapE = e(this.f28121e, mVar);
        return i(this.f28121e, mapE) ? this : new n(mapE);
    }

    public Set<Map.Entry<String, byte[]>> g() {
        return this.f28121e.entrySet();
    }

    public int hashCode() {
        if (this.f28120d == 0) {
            int iHashCode = 0;
            for (Map.Entry<String, byte[]> entry : this.f28121e.entrySet()) {
                iHashCode += Arrays.hashCode(entry.getValue()) ^ entry.getKey().hashCode();
            }
            this.f28120d = iHashCode;
        }
        return this.f28120d;
    }

    public n(Map<String, byte[]> map) {
        this.f28121e = Collections.unmodifiableMap(map);
    }
}
