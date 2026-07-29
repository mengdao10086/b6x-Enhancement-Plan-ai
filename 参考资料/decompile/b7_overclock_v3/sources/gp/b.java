package gp;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.io.CipherIOException;
import org.bouncycastle.crypto.io.InvalidCipherTextIOException;
import org.bouncycastle.crypto.k0;

/* JADX INFO: loaded from: classes5.dex */
public class b extends FilterOutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public org.bouncycastle.crypto.h f29908a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public k0 f29909b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public jp.a f29910c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[] f29911d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public byte[] f29912e;

    public b(OutputStream outputStream, jp.a aVar) {
        super(outputStream);
        this.f29911d = new byte[1];
        this.f29910c = aVar;
    }

    public b(OutputStream outputStream, org.bouncycastle.crypto.h hVar) {
        super(outputStream);
        this.f29911d = new byte[1];
        this.f29908a = hVar;
    }

    public b(OutputStream outputStream, k0 k0Var) {
        super(outputStream);
        this.f29911d = new byte[1];
        this.f29909b = k0Var;
    }

    public final void a(int i10, boolean z10) {
        if (z10) {
            org.bouncycastle.crypto.h hVar = this.f29908a;
            if (hVar != null) {
                i10 = hVar.c(i10);
            } else {
                jp.a aVar = this.f29910c;
                if (aVar != null) {
                    i10 = aVar.h(i10);
                }
            }
        } else {
            org.bouncycastle.crypto.h hVar2 = this.f29908a;
            if (hVar2 != null) {
                i10 = hVar2.e(i10);
            } else {
                jp.a aVar2 = this.f29910c;
                if (aVar2 != null) {
                    i10 = aVar2.g(i10);
                }
            }
        }
        byte[] bArr = this.f29912e;
        if (bArr == null || bArr.length < i10) {
            this.f29912e = new byte[i10];
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        IOException cipherIOException;
        IOException iOException;
        a(0, true);
        try {
            org.bouncycastle.crypto.h hVar = this.f29908a;
            if (hVar != null) {
                int iA = hVar.a(this.f29912e, 0);
                if (iA != 0) {
                    ((FilterOutputStream) this).out.write(this.f29912e, 0, iA);
                }
            } else {
                jp.a aVar = this.f29910c;
                if (aVar != null) {
                    int iC = aVar.c(this.f29912e, 0);
                    if (iC != 0) {
                        ((FilterOutputStream) this).out.write(this.f29912e, 0, iC);
                    }
                } else {
                    k0 k0Var = this.f29909b;
                    if (k0Var != null) {
                        k0Var.reset();
                    }
                }
            }
            iOException = null;
        } catch (InvalidCipherTextException e10) {
            cipherIOException = new InvalidCipherTextIOException("Error finalising cipher data", e10);
            iOException = cipherIOException;
        } catch (Exception e11) {
            cipherIOException = new CipherIOException("Error closing stream: ", e11);
            iOException = cipherIOException;
        }
        try {
            flush();
            ((FilterOutputStream) this).out.close();
        } catch (IOException e12) {
            if (iOException == null) {
                iOException = e12;
            }
        }
        if (iOException != null) {
            throw iOException;
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        ((FilterOutputStream) this).out.flush();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i10) throws IOException {
        byte[] bArr = this.f29911d;
        byte b10 = (byte) i10;
        bArr[0] = b10;
        k0 k0Var = this.f29909b;
        if (k0Var != null) {
            ((FilterOutputStream) this).out.write(k0Var.f(b10));
        } else {
            write(bArr, 0, 1);
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i10, int i11) throws IOException {
        a(i11, false);
        org.bouncycastle.crypto.h hVar = this.f29908a;
        if (hVar != null) {
            int iH = hVar.h(bArr, i10, i11, this.f29912e, 0);
            if (iH != 0) {
                ((FilterOutputStream) this).out.write(this.f29912e, 0, iH);
                return;
            }
            return;
        }
        jp.a aVar = this.f29910c;
        if (aVar == null) {
            this.f29909b.e(bArr, i10, i11, this.f29912e, 0);
            ((FilterOutputStream) this).out.write(this.f29912e, 0, i11);
        } else {
            int iE = aVar.e(bArr, i10, i11, this.f29912e, 0);
            if (iE != 0) {
                ((FilterOutputStream) this).out.write(this.f29912e, 0, iE);
            }
        }
    }
}
