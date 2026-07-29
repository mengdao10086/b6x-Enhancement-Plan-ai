package okio;

import java.io.IOException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.ShortBufferException;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.d0(bv = {}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0010\u001a\u00020\u000e\u0012\u0006\u0010\u0016\u001a\u00020\u0011¢\u0006\u0004\b!\u0010\"J\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\tH\u0002J\b\u0010\r\u001a\u00020\tH\u0002R\u0014\u0010\u0010\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000fR\u0017\u0010\u0016\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0018R\u0014\u0010\u001b\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010 \u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u001e¨\u0006#"}, d2 = {"Lokio/n;", "Lokio/t0;", "Lokio/j;", "sink", "", "byteCount", "F1", "Lokio/v0;", "U", "Lkotlin/z1;", "close", "d", "f", "a", "Lokio/l;", "Lokio/l;", "source", "Ljavax/crypto/Cipher;", "b", "Ljavax/crypto/Cipher;", "c", "()Ljavax/crypto/Cipher;", "cipher", "", "I", "blockSize", "Lokio/j;", "buffer", "", "e", "Z", "final", "closed", "<init>", "(Lokio/l;Ljavax/crypto/Cipher;)V", "okio"}, k = 1, mv = {1, 5, 1})
public final class n implements t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final l f44154a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public final Cipher f44155b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f44156c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.k
    public final j f44157d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f44158e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f44159f;

    public n(@yt.k l source, @yt.k Cipher cipher) {
        kotlin.jvm.internal.f0.p(source, "source");
        kotlin.jvm.internal.f0.p(cipher, "cipher");
        this.f44154a = source;
        this.f44155b = cipher;
        int blockSize = cipher.getBlockSize();
        this.f44156c = blockSize;
        this.f44157d = new j();
        if (!(blockSize > 0)) {
            throw new IllegalArgumentException(kotlin.jvm.internal.f0.C("Block cipher required ", c()).toString());
        }
    }

    @Override // okio.t0
    public long F1(@yt.k j sink, long j10) throws BadPaddingException, IllegalBlockSizeException, IOException, ShortBufferException {
        kotlin.jvm.internal.f0.p(sink, "sink");
        if (!(j10 >= 0)) {
            throw new IllegalArgumentException(kotlin.jvm.internal.f0.C("byteCount < 0: ", Long.valueOf(j10)).toString());
        }
        if (!(true ^ this.f44159f)) {
            throw new IllegalStateException("closed".toString());
        }
        if (j10 == 0) {
            return 0L;
        }
        if (this.f44158e) {
            return this.f44157d.F1(sink, j10);
        }
        d();
        return this.f44157d.F1(sink, j10);
    }

    @Override // okio.t0
    @yt.k
    public v0 U() {
        return this.f44154a.U();
    }

    public final void a() throws BadPaddingException, IllegalBlockSizeException, ShortBufferException {
        int outputSize = this.f44155b.getOutputSize(0);
        if (outputSize == 0) {
            return;
        }
        p0 p0VarP2 = this.f44157d.p2(outputSize);
        int iDoFinal = this.f44155b.doFinal(p0VarP2.f44174a, p0VarP2.f44175b);
        p0VarP2.f44176c += iDoFinal;
        j jVar = this.f44157d;
        jVar.i2(jVar.m2() + ((long) iDoFinal));
        if (p0VarP2.f44175b == p0VarP2.f44176c) {
            this.f44157d.f44116a = p0VarP2.b();
            q0.d(p0VarP2);
        }
    }

    @yt.k
    public final Cipher c() {
        return this.f44155b;
    }

    @Override // okio.t0, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f44159f = true;
        this.f44154a.close();
    }

    public final void d() throws BadPaddingException, IllegalBlockSizeException, IOException, ShortBufferException {
        while (this.f44157d.m2() == 0) {
            if (this.f44154a.d0()) {
                this.f44158e = true;
                a();
                return;
            }
            f();
        }
    }

    public final void f() throws IOException, ShortBufferException {
        p0 p0Var = this.f44154a.g().f44116a;
        kotlin.jvm.internal.f0.m(p0Var);
        int i10 = p0Var.f44176c - p0Var.f44175b;
        int outputSize = this.f44155b.getOutputSize(i10);
        while (outputSize > 8192) {
            int i11 = this.f44156c;
            if (!(i10 > i11)) {
                throw new IllegalStateException(("Unexpected output size " + outputSize + " for input size " + i10).toString());
            }
            i10 -= i11;
            outputSize = this.f44155b.getOutputSize(i10);
        }
        p0 p0VarP2 = this.f44157d.p2(outputSize);
        int iUpdate = this.f44155b.update(p0Var.f44174a, p0Var.f44175b, i10, p0VarP2.f44174a, p0VarP2.f44175b);
        this.f44154a.skip(i10);
        p0VarP2.f44176c += iUpdate;
        j jVar = this.f44157d;
        jVar.i2(jVar.m2() + ((long) iUpdate));
        if (p0VarP2.f44175b == p0VarP2.f44176c) {
            this.f44157d.f44116a = p0VarP2.b();
            q0.d(p0VarP2);
        }
    }
}
