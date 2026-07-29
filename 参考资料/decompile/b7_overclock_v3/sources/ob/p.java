package ob;

import g.p0;
import hb.d0;
import hd.t;

/* JADX INFO: loaded from: classes3.dex */
public final class p {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f43286f = "TrackEncryptionBox";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f43287a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @p0
    public final String f43288b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d0.a f43289c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f43290d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @p0
    public final byte[] f43291e;

    public p(boolean z10, @p0 String str, int i10, byte[] bArr, int i11, int i12, @p0 byte[] bArr2) {
        hd.a.a((bArr2 == null) ^ (i10 == 0));
        this.f43287a = z10;
        this.f43288b = str;
        this.f43290d = i10;
        this.f43291e = bArr2;
        this.f43289c = new d0.a(a(str), bArr, i11, i12);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static int a(@p0 String str) {
        if (str == null) {
            return 1;
        }
        byte b10 = -1;
        switch (str.hashCode()) {
            case 3046605:
                if (str.equals(ya.g.E1)) {
                    b10 = 0;
                }
                break;
            case 3046671:
                if (str.equals(ya.g.G1)) {
                    b10 = 1;
                }
                break;
            case 3049879:
                if (str.equals("cenc")) {
                    b10 = 2;
                }
                break;
            case 3049895:
                if (str.equals(ya.g.F1)) {
                    b10 = 3;
                }
                break;
        }
        switch (b10) {
            case 0:
            case 1:
                return 2;
            default:
                t.n(f43286f, "Unsupported protection scheme type '" + str + "'. Assuming AES-CTR crypto mode.");
            case 2:
            case 3:
                return 1;
        }
    }
}
