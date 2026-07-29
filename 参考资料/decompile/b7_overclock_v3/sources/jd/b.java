package jd;

import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import g.p0;
import hd.c0;
import hd.u0;
import hd.w;
import java.nio.ByteBuffer;
import ya.p1;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends com.google.android.exoplayer2.a {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String f36313r = "CameraMotionRenderer";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f36314s = 100000;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final DecoderInputBuffer f36315m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final c0 f36316n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f36317o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @p0
    public a f36318p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f36319q;

    public b() {
        super(6);
        this.f36315m = new DecoderInputBuffer(1);
        this.f36316n = new c0();
    }

    @Override // com.google.android.exoplayer2.a
    public void G() {
        Q();
    }

    @Override // com.google.android.exoplayer2.a
    public void I(long j10, boolean z10) {
        this.f36319q = Long.MIN_VALUE;
        Q();
    }

    @Override // com.google.android.exoplayer2.a
    public void M(Format[] formatArr, long j10, long j11) {
        this.f36317o = j11;
    }

    @p0
    public final float[] P(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() != 16) {
            return null;
        }
        this.f36316n.Q(byteBuffer.array(), byteBuffer.limit());
        this.f36316n.S(byteBuffer.arrayOffset() + 4);
        float[] fArr = new float[3];
        for (int i10 = 0; i10 < 3; i10++) {
            fArr[i10] = Float.intBitsToFloat(this.f36316n.r());
        }
        return fArr;
    }

    public final void Q() {
        a aVar = this.f36318p;
        if (aVar != null) {
            aVar.b();
        }
    }

    @Override // ya.q1
    public int a(Format format) {
        return w.f31217w0.equals(format.f16699l) ? p1.a(4) : p1.a(0);
    }

    @Override // ya.o1
    public boolean b() {
        return i();
    }

    @Override // ya.o1
    public boolean d() {
        return true;
    }

    @Override // ya.o1, ya.q1
    public String getName() {
        return f36313r;
    }

    @Override // ya.o1
    public void q(long j10, long j11) {
        while (!i() && this.f36319q < 100000 + j10) {
            this.f36315m.h();
            if (N(B(), this.f36315m, false) != -4 || this.f36315m.m()) {
                return;
            }
            DecoderInputBuffer decoderInputBuffer = this.f36315m;
            this.f36319q = decoderInputBuffer.f16962e;
            if (this.f36318p != null && !decoderInputBuffer.l()) {
                this.f36315m.r();
                float[] fArrP = P((ByteBuffer) u0.k(this.f36315m.f16960c));
                if (fArrP != null) {
                    ((a) u0.k(this.f36318p)).a(this.f36319q - this.f36317o, fArrP);
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.a, ya.l1.b
    public void r(int i10, @p0 Object obj) throws ExoPlaybackException {
        if (i10 == 7) {
            this.f36318p = (a) obj;
        } else {
            super.r(i10, obj);
        }
    }
}
