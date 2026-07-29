package mc;

import android.annotation.SuppressLint;
import android.media.DrmInitData;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaParser;
import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.video.ColorInfo;
import com.google.common.collect.ImmutableList;
import com.umeng.analytics.pro.an;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import ed.h;
import g.p0;
import g.v0;
import hb.a0;
import hb.b0;
import hb.d0;
import hb.e;
import hb.i;
import hb.m;
import hd.t;
import hd.u0;
import hd.w;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import ya.g;

/* JADX INFO: loaded from: classes3.dex */
@SuppressLint({"Override"})
@v0(30)
public final class c implements MediaParser.OutputConsumer {
    public static final String A = "chunk-index-long-us-times";
    public static final Pattern B;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final String f41170u = "OutputConsumerAdapterV30";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final Pair<MediaParser.SeekPoint, MediaParser.SeekPoint> f41171v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final String f41172w = "track-type-string";

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final String f41173x = "chunk-index-int-sizes";

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final String f41174y = "chunk-index-long-offsets";

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final String f41175z = "chunk-index-long-us-durations";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<d0> f41176a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<Format> f41177b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<MediaCodec.CryptoInfo> f41178c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList<d0.a> f41179d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b f41180e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f41181f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f41182g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @p0
    public final Format f41183h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public m f41184i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @p0
    public MediaParser.SeekMap f41185j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @p0
    public MediaParser.SeekMap f41186k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @p0
    public String f41187l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @p0
    public e f41188m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @p0
    public hd.p0 f41189n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public List<Format> f41190o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f41191p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f41192q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f41193r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f41194s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f41195t;

    public static final class b implements h {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @p0
        public MediaParser.InputReader f41196b;

        public b() {
        }

        @Override // ed.h
        public int read(byte[] bArr, int i10, int i11) throws IOException {
            return ((MediaParser.InputReader) u0.k(this.f41196b)).read(bArr, i10, i11);
        }
    }

    /* JADX INFO: renamed from: mc.c$c, reason: collision with other inner class name */
    public static final class C0456c implements a0 {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final MediaParser.SeekMap f41197d;

        public C0456c(MediaParser.SeekMap seekMap) {
            this.f41197d = seekMap;
        }

        public static b0 b(MediaParser.SeekPoint seekPoint) {
            return new b0(seekPoint.timeMicros, seekPoint.position);
        }

        @Override // hb.a0
        public boolean e() {
            return this.f41197d.isSeekable();
        }

        @Override // hb.a0
        public a0.a g(long j10) {
            Pair<MediaParser.SeekPoint, MediaParser.SeekPoint> seekPoints = this.f41197d.getSeekPoints(j10);
            Object obj = seekPoints.first;
            return obj == seekPoints.second ? new a0.a(b((MediaParser.SeekPoint) obj)) : new a0.a(b((MediaParser.SeekPoint) obj), b((MediaParser.SeekPoint) seekPoints.second));
        }

        @Override // hb.a0
        public long h() {
            long durationMicros = this.f41197d.getDurationMicros();
            return durationMicros != -2147483648L ? durationMicros : g.f56663b;
        }
    }

    static {
        MediaParser.SeekPoint seekPoint = MediaParser.SeekPoint.START;
        f41171v = Pair.create(seekPoint, seekPoint);
        B = Pattern.compile("pattern \\(encrypt: (\\d+), skip: (\\d+)\\)");
    }

    public c() {
        this(null, 7, false);
    }

    public static byte[] c(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[byteBuffer.remaining()];
        byteBuffer.get(bArr);
        return bArr;
    }

    @p0
    public static ColorInfo e(MediaFormat mediaFormat) {
        ByteBuffer byteBuffer = mediaFormat.getByteBuffer("hdr-static-info");
        byte[] bArrC = byteBuffer != null ? c(byteBuffer) : null;
        int integer = mediaFormat.getInteger("color-transfer", -1);
        int integer2 = mediaFormat.getInteger("color-range", -1);
        int integer3 = mediaFormat.getInteger("color-standard", -1);
        if (bArrC == null && integer == -1 && integer2 == -1 && integer3 == -1) {
            return null;
        }
        return new ColorInfo(integer3, integer2, integer, bArrC);
    }

    public static int g(MediaFormat mediaFormat, String str, int i10) {
        if (mediaFormat.getInteger(str, 0) != 0) {
            return i10;
        }
        return 0;
    }

    public static List<byte[]> h(MediaFormat mediaFormat) {
        ArrayList arrayList = new ArrayList();
        int i10 = 0;
        while (true) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("csd-");
            int i11 = i10 + 1;
            sb2.append(i10);
            ByteBuffer byteBuffer = mediaFormat.getByteBuffer(sb2.toString());
            if (byteBuffer == null) {
                return arrayList;
            }
            arrayList.add(c(byteBuffer));
            i10 = i11;
        }
    }

    public static String i(String str) {
        str.hashCode();
        switch (str) {
            case "android.media.mediaparser.Mp4Parser":
            case "android.media.mediaparser.FragmentedMp4Parser":
                return w.f31182f;
            case "android.media.mediaparser.OggParser":
                return w.Z;
            case "android.media.mediaparser.TsParser":
                return w.f31200o;
            case "android.media.mediaparser.AdtsParser":
                return w.A;
            case "android.media.mediaparser.WavParser":
                return w.G;
            case "android.media.mediaparser.PsParser":
                return w.f31206r;
            case "android.media.mediaparser.Ac3Parser":
                return w.J;
            case "android.media.mediaparser.AmrParser":
                return w.T;
            case "android.media.mediaparser.FlacParser":
                return w.W;
            case "android.media.mediaparser.MatroskaParser":
                return w.f31186h;
            case "android.media.mediaparser.Ac4Parser":
                return w.M;
            case "android.media.mediaparser.Mp3Parser":
                return w.D;
            case "android.media.mediaparser.FlvParser":
                return w.f31214v;
            default:
                throw new IllegalArgumentException("Illegal parser name: " + str);
        }
    }

    public static int l(MediaFormat mediaFormat) {
        return g(mediaFormat, "is-forced-subtitle", 2) | g(mediaFormat, "is-autoselect", 4) | 0 | g(mediaFormat, "is-default", 1);
    }

    @p0
    public static DrmInitData u(@p0 String str, @p0 android.media.DrmInitData drmInitData) {
        if (drmInitData == null) {
            return null;
        }
        int schemeInitDataCount = drmInitData.getSchemeInitDataCount();
        DrmInitData.SchemeData[] schemeDataArr = new DrmInitData.SchemeData[schemeInitDataCount];
        for (int i10 = 0; i10 < schemeInitDataCount; i10++) {
            DrmInitData.SchemeInitData schemeInitDataAt = drmInitData.getSchemeInitDataAt(i10);
            schemeDataArr[i10] = new DrmInitData.SchemeData(schemeInitDataAt.uuid, schemeInitDataAt.mimeType, schemeInitDataAt.data);
        }
        return new com.google.android.exoplayer2.drm.DrmInitData(str, schemeDataArr);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:7:0x000e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int w(@g.p0 java.lang.String r5) {
        /*
            r0 = -1
            if (r5 != 0) goto L4
            return r0
        L4:
            int r1 = r5.hashCode()
            r2 = 3
            r3 = 2
            r4 = 1
            switch(r1) {
                case -450004177: goto L3c;
                case -284840886: goto L31;
                case 3556653: goto L26;
                case 93166550: goto L1b;
                case 112202875: goto L10;
                default: goto Le;
            }
        Le:
            r1 = -1
            goto L46
        L10:
            java.lang.String r1 = "video"
            boolean r1 = r5.equals(r1)
            if (r1 != 0) goto L19
            goto Le
        L19:
            r1 = 4
            goto L46
        L1b:
            java.lang.String r1 = "audio"
            boolean r1 = r5.equals(r1)
            if (r1 != 0) goto L24
            goto Le
        L24:
            r1 = 3
            goto L46
        L26:
            java.lang.String r1 = "text"
            boolean r1 = r5.equals(r1)
            if (r1 != 0) goto L2f
            goto Le
        L2f:
            r1 = 2
            goto L46
        L31:
            java.lang.String r1 = "unknown"
            boolean r1 = r5.equals(r1)
            if (r1 != 0) goto L3a
            goto Le
        L3a:
            r1 = 1
            goto L46
        L3c:
            java.lang.String r1 = "metadata"
            boolean r1 = r5.equals(r1)
            if (r1 != 0) goto L45
            goto Le
        L45:
            r1 = 0
        L46:
            switch(r1) {
                case 0: goto L52;
                case 1: goto L51;
                case 2: goto L50;
                case 3: goto L4f;
                case 4: goto L4e;
                default: goto L49;
            }
        L49:
            int r5 = hd.w.l(r5)
            return r5
        L4e:
            return r3
        L4f:
            return r4
        L50:
            return r2
        L51:
            return r0
        L52:
            r5 = 5
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: mc.c.w(java.lang.String):int");
    }

    public void a() {
        this.f41195t = true;
    }

    public final void b(int i10) {
        for (int size = this.f41176a.size(); size <= i10; size++) {
            this.f41176a.add(null);
            this.f41177b.add(null);
            this.f41178c.add(null);
            this.f41179d.add(null);
        }
    }

    @p0
    public e d() {
        return this.f41188m;
    }

    @p0
    public MediaParser.SeekMap f() {
        return this.f41185j;
    }

    @p0
    public Format[] j() {
        if (!this.f41193r) {
            return null;
        }
        Format[] formatArr = new Format[this.f41177b.size()];
        for (int i10 = 0; i10 < this.f41177b.size(); i10++) {
            formatArr[i10] = (Format) hd.a.g(this.f41177b.get(i10));
        }
        return formatArr;
    }

    public Pair<MediaParser.SeekPoint, MediaParser.SeekPoint> k(long j10) {
        MediaParser.SeekMap seekMap = this.f41186k;
        return seekMap != null ? seekMap.getSeekPoints(j10) : f41171v;
    }

    public final void m() {
        if (!this.f41193r || this.f41194s) {
            return;
        }
        int size = this.f41176a.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (this.f41176a.get(i10) == null) {
                return;
            }
        }
        this.f41184i.k();
        this.f41194s = true;
    }

    public final boolean n(MediaFormat mediaFormat) {
        ByteBuffer byteBuffer = mediaFormat.getByteBuffer(f41173x);
        if (byteBuffer == null) {
            return false;
        }
        IntBuffer intBufferAsIntBuffer = byteBuffer.asIntBuffer();
        LongBuffer longBufferAsLongBuffer = ((ByteBuffer) hd.a.g(mediaFormat.getByteBuffer(f41174y))).asLongBuffer();
        LongBuffer longBufferAsLongBuffer2 = ((ByteBuffer) hd.a.g(mediaFormat.getByteBuffer(f41175z))).asLongBuffer();
        LongBuffer longBufferAsLongBuffer3 = ((ByteBuffer) hd.a.g(mediaFormat.getByteBuffer(A))).asLongBuffer();
        int[] iArr = new int[intBufferAsIntBuffer.remaining()];
        long[] jArr = new long[longBufferAsLongBuffer.remaining()];
        long[] jArr2 = new long[longBufferAsLongBuffer2.remaining()];
        long[] jArr3 = new long[longBufferAsLongBuffer3.remaining()];
        intBufferAsIntBuffer.get(iArr);
        longBufferAsLongBuffer.get(jArr);
        longBufferAsLongBuffer2.get(jArr2);
        longBufferAsLongBuffer3.get(jArr3);
        e eVar = new e(iArr, jArr, jArr2, jArr3);
        this.f41188m = eVar;
        this.f41184i.o(eVar);
        return true;
    }

    public void o(m mVar) {
        this.f41184i = mVar;
    }

    @Override // android.media.MediaParser.OutputConsumer
    public void onSampleCompleted(int i10, long j10, int i11, int i12, int i13, @p0 MediaCodec.CryptoInfo cryptoInfo) {
        long j11 = this.f41192q;
        if (j11 == g.f56663b || j10 < j11) {
            hd.p0 p0Var = this.f41189n;
            if (p0Var != null) {
                j10 = p0Var.a(j10);
            }
            ((d0) hd.a.g(this.f41176a.get(i10))).a(j10, i11, i12, i13, t(i10, cryptoInfo));
        }
    }

    @Override // android.media.MediaParser.OutputConsumer
    public void onSampleDataFound(int i10, MediaParser.InputReader inputReader) throws IOException {
        b(i10);
        this.f41180e.f41196b = inputReader;
        d0 d0VarD = this.f41176a.get(i10);
        if (d0VarD == null) {
            d0VarD = this.f41184i.d(i10, -1);
            this.f41176a.set(i10, d0VarD);
        }
        d0VarD.e(this.f41180e, (int) inputReader.getLength(), true);
    }

    @Override // android.media.MediaParser.OutputConsumer
    public void onSeekMapFound(MediaParser.SeekMap seekMap) {
        a0 c0456c;
        if (this.f41181f && this.f41185j == null) {
            this.f41185j = seekMap;
            return;
        }
        this.f41186k = seekMap;
        long durationMicros = seekMap.getDurationMicros();
        m mVar = this.f41184i;
        if (this.f41195t) {
            if (durationMicros == -2147483648L) {
                durationMicros = g.f56663b;
            }
            c0456c = new a0.b(durationMicros);
        } else {
            c0456c = new C0456c(seekMap);
        }
        mVar.o(c0456c);
    }

    @Override // android.media.MediaParser.OutputConsumer
    public void onTrackCountFound(int i10) {
        this.f41193r = true;
        m();
    }

    @Override // android.media.MediaParser.OutputConsumer
    public void onTrackDataFound(int i10, MediaParser.TrackData trackData) {
        if (n(trackData.mediaFormat)) {
            return;
        }
        b(i10);
        d0 d0Var = this.f41176a.get(i10);
        if (d0Var == null) {
            String string = trackData.mediaFormat.getString(f41172w);
            int iW = w(string != null ? string : trackData.mediaFormat.getString("mime"));
            if (iW == this.f41182g) {
                this.f41191p = i10;
            }
            d0 d0VarD = this.f41184i.d(i10, iW);
            this.f41176a.set(i10, d0VarD);
            if (string != null) {
                return;
            } else {
                d0Var = d0VarD;
            }
        }
        Format formatV = v(trackData);
        Format format = this.f41183h;
        d0Var.f((format == null || i10 != this.f41191p) ? formatV : formatV.m0(format));
        this.f41177b.set(i10, formatV);
        m();
    }

    public void p(List<Format> list) {
        this.f41190o = list;
    }

    public void q(long j10) {
        this.f41192q = j10;
    }

    public void r(String str) {
        this.f41187l = i(str);
    }

    public void s(hd.p0 p0Var) {
        this.f41189n = p0Var;
    }

    @p0
    public final d0.a t(int i10, @p0 MediaCodec.CryptoInfo cryptoInfo) {
        int i11;
        if (cryptoInfo == null) {
            return null;
        }
        if (this.f41178c.get(i10) == cryptoInfo) {
            return (d0.a) hd.a.g(this.f41179d.get(i10));
        }
        int i12 = 0;
        try {
            Matcher matcher = B.matcher(cryptoInfo.toString());
            matcher.find();
            int i13 = Integer.parseInt((String) u0.k(matcher.group(1)));
            i11 = Integer.parseInt((String) u0.k(matcher.group(2)));
            i12 = i13;
        } catch (RuntimeException e10) {
            t.e(f41170u, "Unexpected error while parsing CryptoInfo: " + cryptoInfo, e10);
            i11 = 0;
        }
        d0.a aVar = new d0.a(cryptoInfo.mode, cryptoInfo.key, i12, i11);
        this.f41178c.set(i10, cryptoInfo);
        this.f41179d.set(i10, aVar);
        return aVar;
    }

    public final Format v(MediaParser.TrackData trackData) {
        MediaFormat mediaFormat = trackData.mediaFormat;
        String string = mediaFormat.getString("mime");
        int integer = mediaFormat.getInteger("caption-service-number", -1);
        int i10 = 0;
        Format.b bVarF = new Format.b().L(u(mediaFormat.getString("crypto-mode-fourcc"), trackData.drmInitData)).K(this.f41187l).Z(mediaFormat.getInteger("bitrate", -1)).H(mediaFormat.getInteger("channel-count", -1)).J(e(mediaFormat)).e0(string).I(mediaFormat.getString("codecs-string")).P(mediaFormat.getFloat("frame-rate", -1.0f)).j0(mediaFormat.getInteger(SocializeProtocolConstants.WIDTH, -1)).Q(mediaFormat.getInteger(SocializeProtocolConstants.HEIGHT, -1)).T(h(mediaFormat)).V(mediaFormat.getString(an.N)).W(mediaFormat.getInteger("max-input-size", -1)).Y(mediaFormat.getInteger("exo-pcm-encoding", -1)).d0(mediaFormat.getInteger("rotation-degrees", 0)).f0(mediaFormat.getInteger("sample-rate", -1)).g0(l(mediaFormat)).M(mediaFormat.getInteger("encoder-delay", 0)).N(mediaFormat.getInteger("encoder-padding", 0)).a0(mediaFormat.getFloat("pixel-width-height-ratio-float", 1.0f)).i0(mediaFormat.getLong("subsample-offset-us-long", Long.MAX_VALUE)).F(integer);
        while (true) {
            if (i10 >= this.f41190o.size()) {
                break;
            }
            Format format = this.f41190o.get(i10);
            if (u0.c(format.f16699l, string) && format.D == integer) {
                bVarF.V(format.f16689c).c0(format.f16691e).g0(format.f16690d).U(format.f16688b).X(format.f16696j);
                break;
            }
            i10++;
        }
        return bVarF.E();
    }

    public c(@p0 Format format, int i10, boolean z10) {
        this.f41181f = z10;
        this.f41183h = format;
        this.f41182g = i10;
        this.f41176a = new ArrayList<>();
        this.f41177b = new ArrayList<>();
        this.f41178c = new ArrayList<>();
        this.f41179d = new ArrayList<>();
        this.f41180e = new b();
        this.f41184i = new i();
        this.f41192q = g.f56663b;
        this.f41190o = ImmutableList.of();
    }
}
