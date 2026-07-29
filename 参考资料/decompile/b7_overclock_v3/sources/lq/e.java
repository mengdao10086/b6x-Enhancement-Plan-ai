package lq;

import java.io.IOException;
import java.io.OutputStream;
import javax.crypto.Mac;

/* JADX INFO: loaded from: classes7.dex */
public class e extends OutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Mac f40123a;

    public e(Mac mac) {
        this.f40123a = mac;
    }

    @Override // java.io.OutputStream
    public void write(int i10) throws IOException {
        this.f40123a.update((byte) i10);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        this.f40123a.update(bArr);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i10, int i11) throws IOException {
        this.f40123a.update(bArr, i10, i11);
    }
}
