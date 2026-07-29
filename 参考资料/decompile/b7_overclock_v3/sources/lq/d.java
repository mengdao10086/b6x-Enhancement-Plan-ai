package lq;

import java.io.IOException;
import java.io.OutputStream;
import javax.crypto.Mac;

/* JADX INFO: loaded from: classes7.dex */
public final class d extends OutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Mac f40122a;

    public d(Mac mac) {
        this.f40122a = mac;
    }

    public byte[] a() {
        return this.f40122a.doFinal();
    }

    @Override // java.io.OutputStream
    public void write(int i10) throws IOException {
        this.f40122a.update((byte) i10);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i10, int i11) throws IOException {
        this.f40122a.update(bArr, i10, i11);
    }
}
