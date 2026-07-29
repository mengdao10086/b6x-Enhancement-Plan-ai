package eb;

import android.media.MediaCodec;
import g.p0;
import g.v0;
import hd.u0;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @p0
    public byte[] f26746a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @p0
    public byte[] f26747b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f26748c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @p0
    public int[] f26749d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @p0
    public int[] f26750e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f26751f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f26752g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f26753h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final MediaCodec.CryptoInfo f26754i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @p0
    public final C0308b f26755j;

    /* JADX INFO: renamed from: eb.b$b, reason: collision with other inner class name */
    @v0(24)
    public static final class C0308b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MediaCodec.CryptoInfo f26756a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final MediaCodec.CryptoInfo.Pattern f26757b;

        public final void b(int i10, int i11) {
            this.f26757b.set(i10, i11);
            this.f26756a.setPattern(this.f26757b);
        }

        public C0308b(MediaCodec.CryptoInfo cryptoInfo) {
            this.f26756a = cryptoInfo;
            this.f26757b = new MediaCodec.CryptoInfo.Pattern(0, 0);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b() {
        MediaCodec.CryptoInfo cryptoInfo = new MediaCodec.CryptoInfo();
        this.f26754i = cryptoInfo;
        this.f26755j = u0.f31154a >= 24 ? new C0308b(cryptoInfo) : null;
    }

    public MediaCodec.CryptoInfo a() {
        return this.f26754i;
    }

    @Deprecated
    public MediaCodec.CryptoInfo b() {
        return a();
    }

    public void c(int i10) {
        if (i10 == 0) {
            return;
        }
        if (this.f26749d == null) {
            int[] iArr = new int[1];
            this.f26749d = iArr;
            this.f26754i.numBytesOfClearData = iArr;
        }
        int[] iArr2 = this.f26749d;
        iArr2[0] = iArr2[0] + i10;
    }

    public void d(int i10, int[] iArr, int[] iArr2, byte[] bArr, byte[] bArr2, int i11, int i12, int i13) {
        this.f26751f = i10;
        this.f26749d = iArr;
        this.f26750e = iArr2;
        this.f26747b = bArr;
        this.f26746a = bArr2;
        this.f26748c = i11;
        this.f26752g = i12;
        this.f26753h = i13;
        MediaCodec.CryptoInfo cryptoInfo = this.f26754i;
        cryptoInfo.numSubSamples = i10;
        cryptoInfo.numBytesOfClearData = iArr;
        cryptoInfo.numBytesOfEncryptedData = iArr2;
        cryptoInfo.key = bArr;
        cryptoInfo.iv = bArr2;
        cryptoInfo.mode = i11;
        if (u0.f31154a >= 24) {
            ((C0308b) hd.a.g(this.f26755j)).b(i12, i13);
        }
    }
}
