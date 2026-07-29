package gp;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.g0;
import org.bouncycastle.crypto.io.CipherIOException;
import org.bouncycastle.crypto.io.InvalidCipherTextIOException;
import org.bouncycastle.crypto.k0;

/* JADX INFO: loaded from: classes5.dex */
public class a extends FilterInputStream {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f29895m = 2048;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g0 f29896a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f29897b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public org.bouncycastle.crypto.h f29898c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public k0 f29899d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public jp.a f29900e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public byte[] f29901f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public byte[] f29902g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f29903h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f29904i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f29905j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f29906k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f29907l;

    public a(InputStream inputStream, jp.a aVar) {
        this(inputStream, aVar, 2048);
    }

    public a(InputStream inputStream, jp.a aVar, int i10) {
        super(inputStream);
        this.f29900e = aVar;
        this.f29897b = new byte[i10];
        this.f29896a = aVar instanceof g0 ? (g0) aVar : null;
    }

    public a(InputStream inputStream, org.bouncycastle.crypto.h hVar) {
        this(inputStream, hVar, 2048);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(InputStream inputStream, org.bouncycastle.crypto.h hVar, int i10) {
        super(inputStream);
        this.f29898c = hVar;
        this.f29897b = new byte[i10];
        this.f29896a = hVar instanceof g0 ? (g0) hVar : null;
    }

    public a(InputStream inputStream, k0 k0Var) {
        this(inputStream, k0Var, 2048);
    }

    public a(InputStream inputStream, k0 k0Var, int i10) {
        super(inputStream);
        this.f29899d = k0Var;
        this.f29897b = new byte[i10];
        this.f29896a = k0Var instanceof g0 ? (g0) k0Var : null;
    }

    public final void a(int i10, boolean z10) {
        if (z10) {
            org.bouncycastle.crypto.h hVar = this.f29898c;
            if (hVar != null) {
                i10 = hVar.c(i10);
            } else {
                jp.a aVar = this.f29900e;
                if (aVar != null) {
                    i10 = aVar.h(i10);
                }
            }
        } else {
            org.bouncycastle.crypto.h hVar2 = this.f29898c;
            if (hVar2 != null) {
                i10 = hVar2.e(i10);
            } else {
                jp.a aVar2 = this.f29900e;
                if (aVar2 != null) {
                    i10 = aVar2.g(i10);
                }
            }
        }
        byte[] bArr = this.f29901f;
        if (bArr == null || bArr.length < i10) {
            this.f29901f = new byte[i10];
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        return this.f29904i - this.f29903h;
    }

    public final void c() throws IOException {
        int iC;
        try {
            this.f29905j = true;
            a(0, true);
            org.bouncycastle.crypto.h hVar = this.f29898c;
            if (hVar != null) {
                iC = hVar.a(this.f29901f, 0);
            } else {
                jp.a aVar = this.f29900e;
                if (aVar == null) {
                    this.f29904i = 0;
                    return;
                }
                iC = aVar.c(this.f29901f, 0);
            }
            this.f29904i = iC;
        } catch (InvalidCipherTextException e10) {
            throw new InvalidCipherTextIOException("Error finalising cipher", e10);
        } catch (Exception e11) {
            throw new IOException("Error finalising cipher " + e11);
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            ((FilterInputStream) this).in.close();
            this.f29903h = 0;
            this.f29904i = 0;
            this.f29907l = 0;
            this.f29906k = 0L;
            byte[] bArr = this.f29902g;
            if (bArr != null) {
                org.bouncycastle.util.a.d0(bArr, (byte) 0);
                this.f29902g = null;
            }
            byte[] bArr2 = this.f29901f;
            if (bArr2 != null) {
                org.bouncycastle.util.a.d0(bArr2, (byte) 0);
                this.f29901f = null;
            }
            org.bouncycastle.util.a.d0(this.f29897b, (byte) 0);
        } finally {
            if (!this.f29905j) {
                c();
            }
        }
    }

    public final int d() throws IOException {
        if (this.f29905j) {
            return -1;
        }
        this.f29903h = 0;
        this.f29904i = 0;
        while (true) {
            int i10 = this.f29904i;
            if (i10 != 0) {
                return i10;
            }
            int iE = ((FilterInputStream) this).in.read(this.f29897b);
            if (iE == -1) {
                c();
                int i11 = this.f29904i;
                if (i11 == 0) {
                    return -1;
                }
                return i11;
            }
            try {
                a(iE, false);
                org.bouncycastle.crypto.h hVar = this.f29898c;
                if (hVar != null) {
                    iE = hVar.h(this.f29897b, 0, iE, this.f29901f, 0);
                } else {
                    jp.a aVar = this.f29900e;
                    if (aVar != null) {
                        iE = aVar.e(this.f29897b, 0, iE, this.f29901f, 0);
                    } else {
                        this.f29899d.e(this.f29897b, 0, iE, this.f29901f, 0);
                    }
                }
                this.f29904i = iE;
            } catch (Exception e10) {
                throw new CipherIOException("Error processing stream ", e10);
            }
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int i10) {
        ((FilterInputStream) this).in.mark(i10);
        g0 g0Var = this.f29896a;
        if (g0Var != null) {
            this.f29906k = g0Var.getPosition();
        }
        byte[] bArr = this.f29901f;
        if (bArr != null) {
            byte[] bArr2 = new byte[bArr.length];
            this.f29902g = bArr2;
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        }
        this.f29907l = this.f29903h;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        if (this.f29896a != null) {
            return ((FilterInputStream) this).in.markSupported();
        }
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        if (this.f29903h >= this.f29904i && d() < 0) {
            return -1;
        }
        byte[] bArr = this.f29901f;
        int i10 = this.f29903h;
        this.f29903h = i10 + 1;
        return bArr[i10] & 255;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i10, int i11) throws IOException {
        if (this.f29903h >= this.f29904i && d() < 0) {
            return -1;
        }
        int iMin = Math.min(i11, available());
        System.arraycopy(this.f29901f, this.f29903h, bArr, i10, iMin);
        this.f29903h += iMin;
        return iMin;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
        if (this.f29896a == null) {
            throw new IOException("cipher must implement SkippingCipher to be used with reset()");
        }
        ((FilterInputStream) this).in.reset();
        this.f29896a.g(this.f29906k);
        byte[] bArr = this.f29902g;
        if (bArr != null) {
            this.f29901f = bArr;
        }
        this.f29903h = this.f29907l;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j10) throws IOException {
        if (j10 <= 0) {
            return 0L;
        }
        if (this.f29896a == null) {
            int iMin = (int) Math.min(j10, available());
            this.f29903h += iMin;
            return iMin;
        }
        long jAvailable = available();
        if (j10 <= jAvailable) {
            this.f29903h = (int) (((long) this.f29903h) + j10);
            return j10;
        }
        this.f29903h = this.f29904i;
        long jSkip = ((FilterInputStream) this).in.skip(j10 - jAvailable);
        if (jSkip == this.f29896a.skip(jSkip)) {
            return jSkip + jAvailable;
        }
        throw new IOException("Unable to skip cipher " + jSkip + " bytes.");
    }
}
