package rt;

import java.io.UnsupportedEncodingException;
import java.util.zip.Checksum;

/* JADX INFO: loaded from: classes6.dex */
public class f implements Checksum {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Checksum f49209a;

    public f(Checksum checksum) {
        this.f49209a = checksum;
    }

    public void f(byte[] bArr) {
        if (bArr != null) {
            update(bArr, 0, bArr.length);
        }
    }

    public void g(double[] dArr) {
        if (dArr != null) {
            for (double d10 : dArr) {
                m(d10);
            }
        }
    }

    @Override // java.util.zip.Checksum
    public long getValue() {
        return this.f49209a.getValue();
    }

    public void h(float[] fArr) {
        if (fArr != null) {
            for (float f10 : fArr) {
                n(f10);
            }
        }
    }

    public void i(int[] iArr) {
        if (iArr != null) {
            for (int i10 : iArr) {
                o(i10);
            }
        }
    }

    public void j(long[] jArr) {
        if (jArr != null) {
            for (long j10 : jArr) {
                p(j10);
            }
        }
    }

    public void k(short[] sArr) {
        if (sArr != null) {
            for (short s10 : sArr) {
                q(s10);
            }
        }
    }

    public void l(boolean z10) {
        update(z10 ? 1 : 0);
    }

    public void m(double d10) {
        p(Double.doubleToLongBits(d10));
    }

    public void n(float f10) {
        o(Float.floatToIntBits(f10));
    }

    public void o(int i10) {
        update((i10 >>> 24) & 255);
        update((i10 >>> 16) & 255);
        update((i10 >>> 8) & 255);
        update(i10 & 255);
    }

    public void p(long j10) {
        update(((int) (j10 >>> 56)) & 255);
        update(((int) (j10 >>> 48)) & 255);
        update(((int) (j10 >>> 40)) & 255);
        update(((int) (j10 >>> 32)) & 255);
        update(((int) (j10 >>> 24)) & 255);
        update(((int) (j10 >>> 16)) & 255);
        update(((int) (j10 >>> 8)) & 255);
        update((int) (j10 & 255));
    }

    public void q(short s10) {
        update((s10 >>> 8) & 255);
        update(s10 & 255);
    }

    public void r(String str) {
        if (str != null) {
            try {
                byte[] bytes = str.getBytes("UTF-8");
                update(bytes, 0, bytes.length);
            } catch (UnsupportedEncodingException e10) {
                throw new RuntimeException(e10);
            }
        }
    }

    @Override // java.util.zip.Checksum
    public void reset() {
        this.f49209a.reset();
    }

    public void s(String[] strArr) {
        if (strArr != null) {
            for (String str : strArr) {
                r(str);
            }
        }
    }

    @Override // java.util.zip.Checksum
    public void update(int i10) {
        this.f49209a.update(i10);
    }

    @Override // java.util.zip.Checksum
    public void update(byte[] bArr, int i10, int i11) {
        this.f49209a.update(bArr, i10, i11);
    }
}
