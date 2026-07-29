package lq;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import org.bouncycastle.crypto.io.InvalidCipherTextIOException;

/* JADX INFO: loaded from: classes7.dex */
public class b extends FilterOutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Cipher f40119a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f40120b;

    public b(OutputStream outputStream, Cipher cipher) {
        super(outputStream);
        this.f40120b = new byte[1];
        this.f40119a = cipher;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        IOException iOException;
        IOException iOException2;
        try {
            byte[] bArrDoFinal = this.f40119a.doFinal();
            if (bArrDoFinal != null) {
                ((FilterOutputStream) this).out.write(bArrDoFinal);
            }
            iOException2 = null;
        } catch (GeneralSecurityException e10) {
            iOException = new InvalidCipherTextIOException("Error during cipher finalisation", e10);
            iOException2 = iOException;
        } catch (Exception e11) {
            iOException = new IOException("Error closing stream: " + e11);
            iOException2 = iOException;
        }
        try {
            flush();
            ((FilterOutputStream) this).out.close();
        } catch (IOException e12) {
            if (iOException2 == null) {
                iOException2 = e12;
            }
        }
        if (iOException2 != null) {
            throw iOException2;
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        ((FilterOutputStream) this).out.flush();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i10) throws IOException {
        byte[] bArr = this.f40120b;
        bArr[0] = (byte) i10;
        write(bArr, 0, 1);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i10, int i11) throws IOException {
        byte[] bArrUpdate = this.f40119a.update(bArr, i10, i11);
        if (bArrUpdate != null) {
            ((FilterOutputStream) this).out.write(bArrUpdate);
        }
    }
}
