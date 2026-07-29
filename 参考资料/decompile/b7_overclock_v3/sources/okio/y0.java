package okio;

import okio.ByteString;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.d0(bv = {}, d1 = {"\u0000\f\n\u0002\u0010\u000e\n\u0002\u0010\u0012\n\u0002\b\r\u001a\u000e\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u0000\u001a\u0016\u0010\u0004\u001a\u00020\u0000*\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0001H\u0000\" \u0010\n\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\b\u0002\u0010\u0005\u0012\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007\" \u0010\r\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u0012\u0004\b\f\u0010\t\u001a\u0004\b\u000b\u0010\u0007¨\u0006\u000e"}, d2 = {"", "", "a", "map", "b", "[B", "d", "()[B", "getBASE64$annotations", "()V", "BASE64", "f", "getBASE64_URL_SAFE$annotations", "BASE64_URL_SAFE", "okio"}, k = 2, mv = {1, 5, 1})
public final class y0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public static final byte[] f44251a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public static final byte[] f44252b;

    static {
        ByteString.a aVar = ByteString.f44029c;
        f44251a = aVar.l("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/").w();
        f44252b = aVar.l("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_").w();
    }

    /* JADX WARN: Removed duplicated region for block: B:63:0x00b8 A[LOOP:1: B:16:0x003e->B:63:0x00b8, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00b4 A[SYNTHETIC] */
    @yt.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final byte[] a(@yt.k java.lang.String r17) {
        /*
            Method dump skipped, instruction units count: 242
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.y0.a(java.lang.String):byte[]");
    }

    @yt.k
    public static final String b(@yt.k byte[] bArr, @yt.k byte[] map) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(map, "map");
        byte[] bArr2 = new byte[((bArr.length + 2) / 3) * 4];
        int length = bArr.length - (bArr.length % 3);
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            int i12 = i10 + 1;
            byte b10 = bArr[i10];
            int i13 = i12 + 1;
            byte b11 = bArr[i12];
            int i14 = i13 + 1;
            byte b12 = bArr[i13];
            int i15 = i11 + 1;
            bArr2[i11] = map[(b10 & 255) >> 2];
            int i16 = i15 + 1;
            bArr2[i15] = map[((b10 & 3) << 4) | ((b11 & 255) >> 4)];
            int i17 = i16 + 1;
            bArr2[i16] = map[((b11 & 15) << 2) | ((b12 & 255) >> 6)];
            i11 = i17 + 1;
            bArr2[i17] = map[b12 & w0.f44229a];
            i10 = i14;
        }
        int length2 = bArr.length - length;
        if (length2 == 1) {
            byte b13 = bArr[i10];
            int i18 = i11 + 1;
            bArr2[i11] = map[(b13 & 255) >> 2];
            int i19 = i18 + 1;
            bArr2[i18] = map[(b13 & 3) << 4];
            byte b14 = (byte) 61;
            bArr2[i19] = b14;
            bArr2[i19 + 1] = b14;
        } else if (length2 == 2) {
            int i20 = i10 + 1;
            byte b15 = bArr[i10];
            byte b16 = bArr[i20];
            int i21 = i11 + 1;
            bArr2[i11] = map[(b15 & 255) >> 2];
            int i22 = i21 + 1;
            bArr2[i21] = map[((b15 & 3) << 4) | ((b16 & 255) >> 4)];
            bArr2[i22] = map[(b16 & 15) << 2];
            bArr2[i22 + 1] = (byte) 61;
        }
        return z0.c(bArr2);
    }

    public static /* synthetic */ String c(byte[] bArr, byte[] bArr2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            bArr2 = f44251a;
        }
        return b(bArr, bArr2);
    }

    @yt.k
    public static final byte[] d() {
        return f44251a;
    }

    public static /* synthetic */ void e() {
    }

    @yt.k
    public static final byte[] f() {
        return f44252b;
    }

    public static /* synthetic */ void g() {
    }
}
