package gm;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes5.dex */
public class i3 extends l3 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f29709c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f29710d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f29711e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f29712f;

    public i3(InputStream inputStream, int i10) throws IOException {
        super(inputStream, i10);
        this.f29711e = false;
        this.f29712f = true;
        this.f29709c = inputStream.read();
        int i11 = inputStream.read();
        this.f29710d = i11;
        if (i11 < 0) {
            throw new EOFException();
        }
        d();
    }

    public final boolean d() {
        if (!this.f29711e && this.f29712f && this.f29709c == 0 && this.f29710d == 0) {
            this.f29711e = true;
            c(true);
        }
        return this.f29711e;
    }

    public void f(boolean z10) {
        this.f29712f = z10;
        d();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (d()) {
            return -1;
        }
        int i10 = this.f29738a.read();
        if (i10 < 0) {
            throw new EOFException();
        }
        int i11 = this.f29709c;
        this.f29709c = this.f29710d;
        this.f29710d = i10;
        return i11;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i10, int i11) throws IOException {
        if (this.f29712f || i11 < 3) {
            return super.read(bArr, i10, i11);
        }
        if (this.f29711e) {
            return -1;
        }
        int i12 = this.f29738a.read(bArr, i10 + 2, i11 - 2);
        if (i12 < 0) {
            throw new EOFException();
        }
        bArr[i10] = (byte) this.f29709c;
        bArr[i10 + 1] = (byte) this.f29710d;
        this.f29709c = this.f29738a.read();
        int i13 = this.f29738a.read();
        this.f29710d = i13;
        if (i13 >= 0) {
            return i12 + 2;
        }
        throw new EOFException();
    }
}
