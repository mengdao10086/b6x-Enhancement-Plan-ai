package okio;

import java.io.IOException;
import javax.crypto.Cipher;
import javax.crypto.ShortBufferException;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.d0(bv = {}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0013\u001a\u00020\u0011\u0012\u0006\u0010\u0019\u001a\u00020\u0014¢\u0006\u0004\b\u001f\u0010 J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0016J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0004H\u0002J\n\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002R\u0014\u0010\u0013\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0012R\u0017\u0010\u0019\u001a\u00020\u00148\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001b\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u001d¨\u0006!"}, d2 = {"Lokio/m;", "Lokio/r0;", "Lokio/j;", "source", "", "byteCount", "Lkotlin/z1;", "V0", "flush", "Lokio/v0;", "U", "close", "remaining", "", "d", "", "a", "Lokio/k;", "Lokio/k;", "sink", "Ljavax/crypto/Cipher;", "b", "Ljavax/crypto/Cipher;", "c", "()Ljavax/crypto/Cipher;", "cipher", "I", "blockSize", "", "Z", "closed", "<init>", "(Lokio/k;Ljavax/crypto/Cipher;)V", "okio"}, k = 1, mv = {1, 5, 1})
public final class m implements r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final k f44138a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public final Cipher f44139b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f44140c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f44141d;

    public m(@yt.k k sink, @yt.k Cipher cipher) {
        kotlin.jvm.internal.f0.p(sink, "sink");
        kotlin.jvm.internal.f0.p(cipher, "cipher");
        this.f44138a = sink;
        this.f44139b = cipher;
        int blockSize = cipher.getBlockSize();
        this.f44140c = blockSize;
        if (!(blockSize > 0)) {
            throw new IllegalArgumentException(kotlin.jvm.internal.f0.C("Block cipher required ", c()).toString());
        }
    }

    @Override // okio.r0
    @yt.k
    public v0 U() {
        return this.f44138a.U();
    }

    @Override // okio.r0
    public void V0(@yt.k j source, long j10) throws IOException {
        kotlin.jvm.internal.f0.p(source, "source");
        a1.e(source.m2(), 0L, j10);
        if (!(!this.f44141d)) {
            throw new IllegalStateException("closed".toString());
        }
        while (j10 > 0) {
            j10 -= (long) d(source, j10);
        }
    }

    public final Throwable a() {
        int outputSize = this.f44139b.getOutputSize(0);
        Throwable th2 = null;
        if (outputSize == 0) {
            return null;
        }
        j jVarG = this.f44138a.g();
        p0 p0VarP2 = jVarG.p2(outputSize);
        try {
            int iDoFinal = this.f44139b.doFinal(p0VarP2.f44174a, p0VarP2.f44176c);
            p0VarP2.f44176c += iDoFinal;
            jVarG.i2(jVarG.m2() + ((long) iDoFinal));
        } catch (Throwable th3) {
            th2 = th3;
        }
        if (p0VarP2.f44175b == p0VarP2.f44176c) {
            jVarG.f44116a = p0VarP2.b();
            q0.d(p0VarP2);
        }
        return th2;
    }

    @yt.k
    public final Cipher c() {
        return this.f44139b;
    }

    @Override // okio.r0, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        if (this.f44141d) {
            return;
        }
        this.f44141d = true;
        Throwable thA = a();
        try {
            this.f44138a.close();
        } catch (Throwable th2) {
            if (thA == null) {
                thA = th2;
            }
        }
        if (thA != null) {
            throw thA;
        }
    }

    public final int d(j jVar, long j10) throws IOException, ShortBufferException {
        p0 p0Var = jVar.f44116a;
        kotlin.jvm.internal.f0.m(p0Var);
        int iMin = (int) Math.min(j10, p0Var.f44176c - p0Var.f44175b);
        j jVarG = this.f44138a.g();
        int outputSize = this.f44139b.getOutputSize(iMin);
        while (outputSize > 8192) {
            int i10 = this.f44140c;
            if (!(iMin > i10)) {
                throw new IllegalStateException(("Unexpected output size " + outputSize + " for input size " + iMin).toString());
            }
            iMin -= i10;
            outputSize = this.f44139b.getOutputSize(iMin);
        }
        p0 p0VarP2 = jVarG.p2(outputSize);
        int iUpdate = this.f44139b.update(p0Var.f44174a, p0Var.f44175b, iMin, p0VarP2.f44174a, p0VarP2.f44176c);
        p0VarP2.f44176c += iUpdate;
        jVarG.i2(jVarG.m2() + ((long) iUpdate));
        if (p0VarP2.f44175b == p0VarP2.f44176c) {
            jVarG.f44116a = p0VarP2.b();
            q0.d(p0VarP2);
        }
        this.f44138a.l0();
        jVar.i2(jVar.m2() - ((long) iMin));
        int i11 = p0Var.f44175b + iMin;
        p0Var.f44175b = i11;
        if (i11 == p0Var.f44176c) {
            jVar.f44116a = p0Var.b();
            q0.d(p0Var);
        }
        return iMin;
    }

    @Override // okio.r0, java.io.Flushable
    public void flush() throws IOException {
        this.f44138a.flush();
    }
}
