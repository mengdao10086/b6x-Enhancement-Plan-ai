package zo;

import java.io.ByteArrayOutputStream;

/* JADX INFO: loaded from: classes5.dex */
public class w implements org.bouncycastle.crypto.s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f59527a = new b();

    public static class b extends ByteArrayOutputStream {
        public b() {
        }

        public void a(byte[] bArr, int i10) {
            System.arraycopy(((ByteArrayOutputStream) this).buf, 0, bArr, i10, size());
        }

        @Override // java.io.ByteArrayOutputStream
        public void reset() {
            super.reset();
            org.bouncycastle.util.a.n(((ByteArrayOutputStream) this).buf);
        }
    }

    @Override // org.bouncycastle.crypto.s
    public String b() {
        return "NULL";
    }

    @Override // org.bouncycastle.crypto.s
    public int c(byte[] bArr, int i10) {
        int size = this.f59527a.size();
        this.f59527a.a(bArr, i10);
        reset();
        return size;
    }

    @Override // org.bouncycastle.crypto.s
    public int h() {
        return this.f59527a.size();
    }

    @Override // org.bouncycastle.crypto.s
    public void reset() {
        this.f59527a.reset();
    }

    @Override // org.bouncycastle.crypto.s
    public void update(byte b10) {
        this.f59527a.write(b10);
    }

    @Override // org.bouncycastle.crypto.s
    public void update(byte[] bArr, int i10, int i11) {
        this.f59527a.write(bArr, i10, i11);
    }
}
