package hb;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.flac.PictureFrame;
import com.google.android.exoplayer2.metadata.flac.VorbisComment;
import g.p0;
import hd.u0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class u {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f30902m = "FlacStreamMetadata";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f30903n = -1;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f30904o = "=";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f30905a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f30906b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f30907c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f30908d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f30909e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f30910f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f30911g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f30912h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f30913i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f30914j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @p0
    public final a f30915k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @p0
    public final Metadata f30916l;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long[] f30917a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long[] f30918b;

        public a(long[] jArr, long[] jArr2) {
            this.f30917a = jArr;
            this.f30918b = jArr2;
        }
    }

    public u(byte[] bArr, int i10) {
        hd.b0 b0Var = new hd.b0(bArr);
        b0Var.q(i10 * 8);
        this.f30905a = b0Var.h(16);
        this.f30906b = b0Var.h(16);
        this.f30907c = b0Var.h(24);
        this.f30908d = b0Var.h(24);
        int iH = b0Var.h(20);
        this.f30909e = iH;
        this.f30910f = m(iH);
        this.f30911g = b0Var.h(3) + 1;
        int iH2 = b0Var.h(5) + 1;
        this.f30912h = iH2;
        this.f30913i = f(iH2);
        this.f30914j = b0Var.j(36);
        this.f30915k = null;
        this.f30916l = null;
    }

    @p0
    public static Metadata a(List<String> list, List<PictureFrame> list2) {
        if (list.isEmpty() && list2.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < list.size(); i10++) {
            String str = list.get(i10);
            String[] strArrO1 = u0.o1(str, f30904o);
            if (strArrO1.length != 2) {
                hd.t.n(f30902m, "Failed to parse Vorbis comment: " + str);
            } else {
                arrayList.add(new VorbisComment(strArrO1[0], strArrO1[1]));
            }
        }
        arrayList.addAll(list2);
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata(arrayList);
    }

    public static int f(int i10) {
        if (i10 == 8) {
            return 1;
        }
        if (i10 == 12) {
            return 2;
        }
        if (i10 == 16) {
            return 4;
        }
        if (i10 != 20) {
            return i10 != 24 ? -1 : 6;
        }
        return 5;
    }

    public static int m(int i10) {
        switch (i10) {
            case 8000:
                return 4;
            case 16000:
                return 5;
            case 22050:
                return 6;
            case 24000:
                return 7;
            case 32000:
                return 8;
            case com.google.android.exoplayer2.source.u.f18441j /* 44100 */:
                return 9;
            case ab.y.f524a /* 48000 */:
                return 10;
            case 88200:
                return 1;
            case 96000:
                return 11;
            case 176400:
                return 2;
            case ab.w.f491a /* 192000 */:
                return 3;
            default:
                return -1;
        }
    }

    public u b(List<PictureFrame> list) {
        return new u(this.f30905a, this.f30906b, this.f30907c, this.f30908d, this.f30909e, this.f30911g, this.f30912h, this.f30914j, this.f30915k, k(a(Collections.emptyList(), list)));
    }

    public u c(@p0 a aVar) {
        return new u(this.f30905a, this.f30906b, this.f30907c, this.f30908d, this.f30909e, this.f30911g, this.f30912h, this.f30914j, aVar, this.f30916l);
    }

    public u d(List<String> list) {
        return new u(this.f30905a, this.f30906b, this.f30907c, this.f30908d, this.f30909e, this.f30911g, this.f30912h, this.f30914j, this.f30915k, k(a(list, Collections.emptyList())));
    }

    public long e() {
        long j10;
        long j11;
        int i10 = this.f30908d;
        if (i10 > 0) {
            j10 = (((long) i10) + ((long) this.f30907c)) / 2;
            j11 = 1;
        } else {
            int i11 = this.f30905a;
            j10 = ((((i11 != this.f30906b || i11 <= 0) ? 4096L : i11) * ((long) this.f30911g)) * ((long) this.f30912h)) / 8;
            j11 = 64;
        }
        return j10 + j11;
    }

    public int g() {
        return this.f30912h * this.f30909e * this.f30911g;
    }

    public long h() {
        long j10 = this.f30914j;
        return j10 == 0 ? ya.g.f56663b : (j10 * 1000000) / ((long) this.f30909e);
    }

    public Format i(byte[] bArr, @p0 Metadata metadata) {
        bArr[4] = -128;
        int i10 = this.f30908d;
        if (i10 <= 0) {
            i10 = -1;
        }
        return new Format.b().e0(hd.w.W).W(i10).H(this.f30911g).f0(this.f30909e).T(Collections.singletonList(bArr)).X(k(metadata)).E();
    }

    public int j() {
        return this.f30906b * this.f30911g * (this.f30912h / 8);
    }

    @p0
    public Metadata k(@p0 Metadata metadata) {
        Metadata metadata2 = this.f30916l;
        return metadata2 == null ? metadata : metadata2.b(metadata);
    }

    public long l(long j10) {
        return u0.u((j10 * ((long) this.f30909e)) / 1000000, 0L, this.f30914j - 1);
    }

    public u(int i10, int i11, int i12, int i13, int i14, int i15, int i16, long j10, ArrayList<String> arrayList, ArrayList<PictureFrame> arrayList2) {
        this(i10, i11, i12, i13, i14, i15, i16, j10, (a) null, a(arrayList, arrayList2));
    }

    public u(int i10, int i11, int i12, int i13, int i14, int i15, int i16, long j10, @p0 a aVar, @p0 Metadata metadata) {
        this.f30905a = i10;
        this.f30906b = i11;
        this.f30907c = i12;
        this.f30908d = i13;
        this.f30909e = i14;
        this.f30910f = m(i14);
        this.f30911g = i15;
        this.f30912h = i16;
        this.f30913i = f(i16);
        this.f30914j = j10;
        this.f30915k = aVar;
        this.f30916l = metadata;
    }
}
