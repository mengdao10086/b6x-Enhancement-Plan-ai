package lq;

import java.io.IOException;
import java.io.OutputStream;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes7.dex */
public class c extends OutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MessageDigest f40121a;

    public c(MessageDigest messageDigest) {
        this.f40121a = messageDigest;
    }

    @Override // java.io.OutputStream
    public void write(int i10) throws IOException {
        this.f40121a.update((byte) i10);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        this.f40121a.update(bArr);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i10, int i11) throws IOException {
        this.f40121a.update(bArr, i10, i11);
    }
}
