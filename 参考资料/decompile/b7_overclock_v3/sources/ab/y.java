package ab;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f524a = 48000;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f525b = 3840;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f526c = 3;

    public static List<byte[]> a(byte[] bArr) {
        long jH = h(e(bArr));
        long jH2 = h(3840L);
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(bArr);
        arrayList.add(b(jH));
        arrayList.add(b(jH2));
        return arrayList;
    }

    public static byte[] b(long j10) {
        return ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(j10).array();
    }

    public static int c(byte[] bArr) {
        return bArr[9] & 255;
    }

    public static int d(List<byte[]> list) {
        return list.size() == 3 ? (int) g(ByteBuffer.wrap(list.get(1)).order(ByteOrder.nativeOrder()).getLong()) : e(list.get(0));
    }

    public static int e(byte[] bArr) {
        return (bArr[10] & 255) | ((bArr[11] & 255) << 8);
    }

    public static int f(List<byte[]> list) {
        if (list.size() == 3) {
            return (int) g(ByteBuffer.wrap(list.get(2)).order(ByteOrder.nativeOrder()).getLong());
        }
        return 3840;
    }

    public static long g(long j10) {
        return (j10 * 48000) / ya.g.f56695j;
    }

    public static long h(long j10) {
        return (j10 * ya.g.f56695j) / 48000;
    }
}
