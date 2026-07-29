package id;

import com.google.android.exoplayer2.Format;
import eb.f;
import g.p0;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes3.dex */
public class j extends eb.f {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f32230o = 0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f32231p = 1;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f32232q = 2;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f32233r = 3;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f32234d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f32235e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @p0
    public ByteBuffer f32236f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f32237g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f32238h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @p0
    public Format f32239i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @p0
    public ByteBuffer[] f32240j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @p0
    public int[] f32241k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f32242l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @p0
    public ByteBuffer f32243m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final f.a<j> f32244n;

    public j(f.a<j> aVar) {
        this.f32244n = aVar;
    }

    public static boolean t(int i10, int i11) {
        return i10 >= 0 && i11 >= 0 && (i11 <= 0 || i10 < Integer.MAX_VALUE / i11);
    }

    @Override // eb.f
    public void p() {
        this.f32244n.a(this);
    }

    public void q(long j10, int i10, @p0 ByteBuffer byteBuffer) {
        this.f26793b = j10;
        this.f32235e = i10;
        if (byteBuffer == null || !byteBuffer.hasRemaining()) {
            this.f32243m = null;
            return;
        }
        g(268435456);
        int iLimit = byteBuffer.limit();
        ByteBuffer byteBuffer2 = this.f32243m;
        if (byteBuffer2 == null || byteBuffer2.capacity() < iLimit) {
            this.f32243m = ByteBuffer.allocate(iLimit);
        } else {
            this.f32243m.clear();
        }
        this.f32243m.put(byteBuffer);
        this.f32243m.flip();
        byteBuffer.position(0);
    }

    public void r(int i10, int i11) {
        this.f32237g = i10;
        this.f32238h = i11;
    }

    public boolean s(int i10, int i11, int i12, int i13, int i14) {
        this.f32237g = i10;
        this.f32238h = i11;
        this.f32242l = i14;
        int i15 = (int) ((((long) i11) + 1) / 2);
        if (t(i12, i11) && t(i13, i15)) {
            int i16 = i11 * i12;
            int i17 = i15 * i13;
            int i18 = (i17 * 2) + i16;
            if (t(i17, 2) && i18 >= i16) {
                ByteBuffer byteBuffer = this.f32236f;
                if (byteBuffer == null || byteBuffer.capacity() < i18) {
                    this.f32236f = ByteBuffer.allocateDirect(i18);
                } else {
                    this.f32236f.position(0);
                    this.f32236f.limit(i18);
                }
                if (this.f32240j == null) {
                    this.f32240j = new ByteBuffer[3];
                }
                ByteBuffer byteBuffer2 = this.f32236f;
                ByteBuffer[] byteBufferArr = this.f32240j;
                byteBufferArr[0] = byteBuffer2.slice();
                byteBufferArr[0].limit(i16);
                byteBuffer2.position(i16);
                byteBufferArr[1] = byteBuffer2.slice();
                byteBufferArr[1].limit(i17);
                byteBuffer2.position(i16 + i17);
                byteBufferArr[2] = byteBuffer2.slice();
                byteBufferArr[2].limit(i17);
                if (this.f32241k == null) {
                    this.f32241k = new int[3];
                }
                int[] iArr = this.f32241k;
                iArr[0] = i12;
                iArr[1] = i13;
                iArr[2] = i13;
                return true;
            }
        }
        return false;
    }
}
