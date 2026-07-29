package hg;

import com.qualcomm.qti.libraries.gaia.GaiaException;
import gg.d;

/* JADX INFO: loaded from: classes5.dex */
public class b extends a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f31268e = 16;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f31269f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f31270g = 2;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f31271h = 2;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f31272i = 2;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f31273j = 4;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f31274k = 4;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f31275l = 4;

    public b(byte[] bArr) throws GaiaException {
        int length = bArr.length - 4;
        if (length < 0) {
            throw new GaiaException(3);
        }
        this.f31264a = d.b(bArr, 0, 2, false);
        this.f31265b = d.b(bArr, 2, 2, false);
        if (length > 0) {
            byte[] bArr2 = new byte[length];
            this.f31266c = bArr2;
            System.arraycopy(bArr, 4, bArr2, 0, length);
        }
        this.f31267d = bArr;
    }

    @Override // hg.a
    public byte[] a(int i10, byte[] bArr) throws GaiaException {
        byte[] bArr2 = new byte[bArr.length + 4];
        d.a(this.f31264a, bArr2, 0, 2, false);
        d.a(i10, bArr2, 2, 2, false);
        System.arraycopy(bArr, 0, bArr2, 4, bArr.length);
        return bArr2;
    }

    @Override // hg.a
    public int i() {
        return 16;
    }

    public b(int i10, int i11) {
        this.f31264a = i10;
        this.f31265b = i11;
        this.f31266c = new byte[0];
        this.f31267d = null;
    }

    public b(int i10, int i11, byte[] bArr) {
        this.f31264a = i10;
        this.f31265b = i11;
        this.f31266c = bArr;
        this.f31267d = null;
    }
}
