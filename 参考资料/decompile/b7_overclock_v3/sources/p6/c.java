package p6;

import com.blankj.utilcode.util.i0;
import jg.d;

/* JADX INFO: loaded from: classes7.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f46492a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f46493b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f46494c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte f46495d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final byte[] f46496e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public byte[] f46497f;

    public c(int i10, int i11, byte[] bArr) {
        this.f46492a = "Segment";
        this.f46493b = i10;
        this.f46494c = i11;
        this.f46496e = bArr;
        this.f46495d = (byte) ((i10 << 6) | i11);
    }

    public static int a(byte b10, int i10, int i11) {
        return (b10 & (((1 << i11) - 1) << i10)) >>> i10;
    }

    public byte[] b() {
        if (this.f46497f == null) {
            byte[] bArr = this.f46496e;
            int length = bArr == null ? 0 : bArr.length;
            byte[] bArr2 = new byte[length + 1];
            this.f46497f = bArr2;
            bArr2[0] = this.f46495d;
            if (length > 0) {
                System.arraycopy(bArr, 0, bArr2, 1, bArr.length);
            }
        }
        return this.f46497f;
    }

    public byte c() {
        return this.f46495d;
    }

    public int d() {
        return this.f46493b;
    }

    public byte[] e() {
        return this.f46496e;
    }

    public int f() {
        return this.f46494c;
    }

    public String g(boolean z10) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[code=");
        sb2.append(this.f46493b);
        sb2.append(", sequence=");
        sb2.append(this.f46494c);
        if (z10) {
            sb2.append(", payload=");
            sb2.append(i6.b.f(this.f46496e));
        }
        sb2.append("]");
        return sb2.toString();
    }

    public String toString() {
        return g(false);
    }

    public c(int i10, int i11) {
        this(i10, i11, new byte[0]);
    }

    public c(byte[] bArr) {
        this.f46492a = "Segment";
        this.f46497f = bArr;
        if (bArr != null && bArr.length >= 1) {
            byte b10 = bArr[0];
            this.f46495d = b10;
            this.f46493b = a(b10, 6, 2);
            this.f46494c = a(b10, 0, 6);
            byte[] bArr2 = new byte[bArr.length - 1];
            this.f46496e = bArr2;
            System.arraycopy(bArr, 1, bArr2, 0, bArr2.length);
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Building of RWCP Segment failed: the byte array does not contain the minimum required information.\nbytes: ");
        sb2.append(bArr != null ? d.g(bArr) : i0.f11859x);
        this.f46493b = -1;
        this.f46494c = -1;
        this.f46495d = (byte) -1;
        this.f46496e = bArr;
    }
}
