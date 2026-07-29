package ur;

import gm.y;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes6.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map f52436a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map f52437b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map f52438c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map f52439d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final byte[] f52440e = {13, 10};

    public static class a extends FilterOutputStream {
        public a(OutputStream outputStream) {
            super(outputStream);
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr, int i10, int i11) throws IOException {
            Objects.requireNonNull(bArr);
            int i12 = i11 + i10;
            if ((i10 | i11 | (bArr.length - i12) | i12) < 0) {
                throw new IndexOutOfBoundsException();
            }
            ((FilterOutputStream) this).out.write(bArr, i10, i11);
        }
    }

    static {
        HashMap map = new HashMap();
        y yVar = so.c.f50092e0;
        map.put(yVar, "md5");
        y yVar2 = so.c.Z;
        map.put(yVar2, "sha-1");
        y yVar3 = so.c.f50084a0;
        map.put(yVar3, "sha-224");
        y yVar4 = so.c.f50086b0;
        map.put(yVar4, "sha-256");
        y yVar5 = so.c.f50088c0;
        map.put(yVar5, "sha-384");
        y yVar6 = so.c.f50090d0;
        map.put(yVar6, "sha-512");
        y yVar7 = so.c.f50094f0;
        map.put(yVar7, "gostr3411-94");
        y yVar8 = so.c.f50096g0;
        map.put(yVar8, "gostr3411-2012-256");
        y yVar9 = so.c.f50098h0;
        map.put(yVar9, "gostr3411-2012-512");
        Map mapUnmodifiableMap = Collections.unmodifiableMap(map);
        f52436a = mapUnmodifiableMap;
        HashMap map2 = new HashMap();
        map2.put(yVar, "md5");
        map2.put(yVar2, "sha1");
        map2.put(yVar3, "sha224");
        map2.put(yVar4, "sha256");
        map2.put(yVar5, "sha384");
        map2.put(yVar6, "sha512");
        map2.put(yVar7, "gostr3411-94");
        map2.put(yVar8, "gostr3411-2012-256");
        map2.put(yVar9, "gostr3411-2012-512");
        f52437b = Collections.unmodifiableMap(map2);
        f52438c = mapUnmodifiableMap;
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (Object obj : mapUnmodifiableMap.keySet()) {
            treeMap.put(f52438c.get(obj).toString(), (y) obj);
        }
        for (Object obj2 : f52437b.keySet()) {
            treeMap.put(f52437b.get(obj2).toString(), (y) obj2);
        }
        f52439d = Collections.unmodifiableMap(treeMap);
    }

    public static InputStream a(InputStream inputStream) {
        return inputStream instanceof FileInputStream ? new BufferedInputStream(inputStream) : inputStream;
    }

    public static OutputStream b(OutputStream outputStream) {
        return outputStream instanceof FileOutputStream ? new BufferedOutputStream(outputStream) : outputStream;
    }

    public static OutputStream c(OutputStream outputStream) {
        return new a(outputStream);
    }

    public static y d(String str) {
        y yVar = (y) f52439d.get(Strings.k(str));
        if (yVar != null) {
            return yVar;
        }
        throw new IllegalArgumentException("unknown micalg passed: " + str);
    }

    public static String e(String str, List<String> list) {
        for (String str2 : list) {
            if (str2.startsWith(str)) {
                return str2;
            }
        }
        return null;
    }

    public static String f(String str) {
        return (str == null || str.length() <= 1 || str.charAt(0) != '\"' || str.charAt(str.length() - 1) != '\"') ? str : str.substring(1, str.length() - 1);
    }
}
