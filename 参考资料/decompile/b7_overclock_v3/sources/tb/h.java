package tb;

import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import g.f0;
import g.i1;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes3.dex */
public final class h extends DecoderInputBuffer {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f51044o = 32;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @i1
    public static final int f51045p = 3072000;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f51046l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f51047m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f51048n;

    public h() {
        super(2);
        this.f51048n = 32;
    }

    public long A() {
        return this.f51046l;
    }

    public int B() {
        return this.f51047m;
    }

    public boolean D() {
        return this.f51047m > 0;
    }

    public void E(@f0(from = 1) int i10) {
        hd.a.a(i10 > 0);
        this.f51048n = i10;
    }

    @Override // com.google.android.exoplayer2.decoder.DecoderInputBuffer, eb.a
    public void h() {
        super.h();
        this.f51047m = 0;
    }

    public boolean w(DecoderInputBuffer decoderInputBuffer) {
        hd.a.a(!decoderInputBuffer.s());
        hd.a.a(!decoderInputBuffer.k());
        hd.a.a(!decoderInputBuffer.m());
        if (!x(decoderInputBuffer)) {
            return false;
        }
        int i10 = this.f51047m;
        this.f51047m = i10 + 1;
        if (i10 == 0) {
            this.f16962e = decoderInputBuffer.f16962e;
            if (decoderInputBuffer.n()) {
                o(1);
            }
        }
        if (decoderInputBuffer.l()) {
            o(Integer.MIN_VALUE);
        }
        ByteBuffer byteBuffer = decoderInputBuffer.f16960c;
        if (byteBuffer != null) {
            q(byteBuffer.remaining());
            this.f16960c.put(byteBuffer);
        }
        this.f51046l = decoderInputBuffer.f16962e;
        return true;
    }

    public final boolean x(DecoderInputBuffer decoderInputBuffer) {
        ByteBuffer byteBuffer;
        if (!D()) {
            return true;
        }
        if (this.f51047m >= this.f51048n || decoderInputBuffer.l() != l()) {
            return false;
        }
        ByteBuffer byteBuffer2 = decoderInputBuffer.f16960c;
        return byteBuffer2 == null || (byteBuffer = this.f16960c) == null || byteBuffer.position() + byteBuffer2.remaining() <= 3072000;
    }

    public long y() {
        return this.f16962e;
    }
}
