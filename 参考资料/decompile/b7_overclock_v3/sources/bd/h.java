package bd;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.mp4.SlowMotionData;
import com.google.android.exoplayer2.metadata.mp4.SmtaMetadataEntry;
import com.google.common.collect.ImmutableList;
import g.i1;
import g.p0;
import hd.u0;
import hd.w;
import hd.y;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Iterator;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: loaded from: classes3.dex */
public final class h implements g {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @i1
    public static final int f9305j = 30;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f9306k = 30;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f9307l = y.f31231b.length;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f9308m = 14;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f9309a = new byte[f9307l];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @p0
    public final SlowMotionData f9310b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Iterator<SlowMotionData.Segment> f9311c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f9312d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f9313e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f9314f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @p0
    public b f9315g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @p0
    public b f9316h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f9317i;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f9318a = -3.4028235E38f;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f9319b = -1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f9320c = -1;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @p0
        public SlowMotionData f9321d;
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f9322a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f9323b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f9324c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f9325d;

        public b(SlowMotionData.Segment segment, int i10, int i11) {
            this.f9322a = ya.g.c(segment.f17334a);
            this.f9323b = ya.g.c(segment.f17335b);
            int i12 = segment.f17336c;
            this.f9324c = i12;
            this.f9325d = a(i12, i10, i11);
        }

        public static int a(int i10, int i11, int i12) {
            int i13 = i10;
            while (true) {
                if (i13 <= 0) {
                    break;
                }
                if ((i13 & 1) == 1) {
                    hd.a.j((i13 >> 1) == 0, "Invalid speed divisor: " + i10);
                } else {
                    i12++;
                    i13 >>= 1;
                }
            }
            return Math.min(i12, i11);
        }
    }

    public h(Format format) {
        a aVarD = d(format.f16696j);
        SlowMotionData slowMotionData = aVarD.f9321d;
        this.f9310b = slowMotionData;
        Iterator<SlowMotionData.Segment> it2 = (slowMotionData != null ? slowMotionData.f17332a : ImmutableList.of()).iterator();
        this.f9311c = it2;
        this.f9312d = aVarD.f9318a;
        int i10 = aVarD.f9319b;
        this.f9313e = i10;
        int i11 = aVarD.f9320c;
        this.f9314f = i11;
        this.f9316h = it2.hasNext() ? new b(it2.next(), i10, i11) : null;
        if (slowMotionData != null) {
            hd.a.b(w.f31190j.equals(format.f16699l), "Unsupported MIME type for SEF slow motion video track: " + format.f16699l);
        }
    }

    public static a d(@p0 Metadata metadata) {
        a aVar = new a();
        if (metadata == null) {
            return aVar;
        }
        for (int i10 = 0; i10 < metadata.g(); i10++) {
            Metadata.Entry entryE = metadata.e(i10);
            if (entryE instanceof SmtaMetadataEntry) {
                SmtaMetadataEntry smtaMetadataEntry = (SmtaMetadataEntry) entryE;
                aVar.f9318a = smtaMetadataEntry.f17337a;
                aVar.f9319b = smtaMetadataEntry.f17338b - 1;
            } else if (entryE instanceof SlowMotionData) {
                aVar.f9321d = (SlowMotionData) entryE;
            }
        }
        if (aVar.f9321d == null) {
            return aVar;
        }
        hd.a.j(aVar.f9319b != -1, "SVC temporal layer count not found.");
        hd.a.j(aVar.f9318a != -3.4028235E38f, "Capture frame rate not found.");
        float f10 = aVar.f9318a;
        hd.a.j(f10 % 1.0f == 0.0f && f10 % 30.0f == 0.0f, "Invalid capture frame rate: " + aVar.f9318a);
        int i11 = ((int) aVar.f9318a) / 30;
        int i12 = aVar.f9319b;
        while (true) {
            if (i12 < 0) {
                break;
            }
            if ((i11 & 1) == 1) {
                hd.a.j((i11 >> 1) == 0, "Could not compute normal speed max SVC layer for capture frame rate  " + aVar.f9318a);
                aVar.f9320c = i12;
            } else {
                i11 >>= 1;
                i12--;
            }
        }
        return aVar;
    }

    @Override // bd.g
    public void a(DecoderInputBuffer decoderInputBuffer) {
        if (this.f9310b == null) {
            return;
        }
        ByteBuffer byteBuffer = (ByteBuffer) u0.k(decoderInputBuffer.f16960c);
        byteBuffer.position(byteBuffer.position() + f9307l);
        boolean z10 = false;
        byteBuffer.get(this.f9309a, 0, 4);
        byte[] bArr = this.f9309a;
        int i10 = bArr[0] & 31;
        boolean z11 = ((bArr[1] & 255) >> 7) == 1;
        if (i10 == 14 && z11) {
            z10 = true;
        }
        hd.a.j(z10, "Missing SVC extension prefix NAL unit.");
        if (!f((this.f9309a[3] & 255) >> 5, decoderInputBuffer.f16962e)) {
            decoderInputBuffer.f16960c = null;
        } else {
            decoderInputBuffer.f16962e = c(decoderInputBuffer.f16962e);
            h(byteBuffer);
        }
    }

    public final void b() {
        if (this.f9315g != null) {
            e();
        }
        this.f9315g = this.f9316h;
        this.f9316h = this.f9311c.hasNext() ? new b(this.f9311c.next(), this.f9313e, this.f9314f) : null;
    }

    @i1
    public long c(long j10) {
        long j11 = this.f9317i + j10;
        b bVar = this.f9315g;
        if (bVar != null) {
            j11 += (j10 - bVar.f9322a) * ((long) (bVar.f9324c - 1));
        }
        return Math.round((j11 * 30) / this.f9312d);
    }

    @RequiresNonNull({"currentSegmentInfo"})
    public final void e() {
        long j10 = this.f9317i;
        b bVar = this.f9315g;
        this.f9317i = j10 + ((bVar.f9323b - bVar.f9322a) * ((long) (bVar.f9324c - 1)));
        this.f9315g = null;
    }

    @i1
    public boolean f(int i10, long j10) {
        b bVar;
        while (true) {
            bVar = this.f9316h;
            if (bVar == null || j10 < bVar.f9323b) {
                break;
            }
            b();
        }
        if (bVar == null || j10 < bVar.f9322a) {
            b bVar2 = this.f9315g;
            if (bVar2 != null && j10 >= bVar2.f9323b) {
                e();
            }
        } else {
            b();
        }
        b bVar3 = this.f9315g;
        return i10 <= (bVar3 != null ? bVar3.f9325d : this.f9314f) || g(i10, j10);
    }

    public final boolean g(int i10, long j10) {
        int i11;
        b bVar = this.f9316h;
        if (bVar != null && i10 < (i11 = bVar.f9325d)) {
            long j11 = ((bVar.f9322a - j10) * 30) / 1000000;
            float f10 = (-(1 << (this.f9313e - i11))) + 0.45f;
            for (int i12 = 1; i12 < this.f9316h.f9325d && j11 < (1 << (this.f9313e - i12)) + f10; i12++) {
                if (i10 <= i12) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void h(ByteBuffer byteBuffer) {
        int iPosition = byteBuffer.position();
        while (true) {
            int iRemaining = byteBuffer.remaining();
            int i10 = f9307l;
            if (iRemaining < i10) {
                throw new IllegalStateException("Could not find NAL unit start code.");
            }
            byteBuffer.get(this.f9309a, 0, i10);
            if (Arrays.equals(this.f9309a, y.f31231b)) {
                byteBuffer.position(iPosition);
                return;
            } else {
                iPosition++;
                byteBuffer.position(iPosition);
            }
        }
    }
}
