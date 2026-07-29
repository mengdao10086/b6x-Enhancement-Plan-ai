package com.google.android.exoplayer2.source.hls;

import android.annotation.SuppressLint;
import android.media.MediaFormat;
import android.media.MediaParser;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.exoplayer2.Format;
import com.google.common.collect.ImmutableList;
import g.n0;
import g.v0;
import hd.p0;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
@v0(30)
public final class u implements k {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final h f18108h = new h() { // from class: com.google.android.exoplayer2.source.hls.t
        @Override // com.google.android.exoplayer2.source.hls.h
        public final k a(Uri uri, Format format, List list, p0 p0Var, Map map, hb.l lVar) {
            return u.i(uri, format, list, p0Var, map, lVar);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final mc.c f18109a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final mc.a f18110b = new mc.a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MediaParser f18111c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Format f18112d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f18113e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ImmutableList<MediaFormat> f18114f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f18115g;

    public static final class b implements MediaParser.SeekableInputReader {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final hb.l f18116a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f18117b;

        @Override // android.media.MediaParser.InputReader
        public long getLength() {
            return this.f18116a.getLength();
        }

        @Override // android.media.MediaParser.InputReader
        public long getPosition() {
            return this.f18116a.i();
        }

        @Override // android.media.MediaParser.InputReader
        public int read(@n0 byte[] bArr, int i10, int i11) throws IOException {
            int iM = this.f18116a.m(bArr, i10, i11);
            this.f18117b += iM;
            return iM;
        }

        @Override // android.media.MediaParser.SeekableInputReader
        public void seekToPosition(long j10) {
            throw new UnsupportedOperationException();
        }

        public b(hb.l lVar) {
            this.f18116a = lVar;
        }
    }

    public u(MediaParser mediaParser, mc.c cVar, Format format, boolean z10, ImmutableList<MediaFormat> immutableList, int i10) {
        this.f18111c = mediaParser;
        this.f18109a = cVar;
        this.f18113e = z10;
        this.f18114f = immutableList;
        this.f18112d = format;
        this.f18115g = i10;
    }

    @SuppressLint({"WrongConstant"})
    public static MediaParser h(MediaParser.OutputConsumer outputConsumer, Format format, boolean z10, ImmutableList<MediaFormat> immutableList, String... strArr) {
        MediaParser mediaParserCreateByName = strArr.length == 1 ? MediaParser.createByName(strArr[0], outputConsumer) : MediaParser.create(outputConsumer, strArr);
        mediaParserCreateByName.setParameter(mc.b.f41168g, immutableList);
        mediaParserCreateByName.setParameter(mc.b.f41167f, Boolean.valueOf(z10));
        Boolean bool = Boolean.TRUE;
        mediaParserCreateByName.setParameter(mc.b.f41162a, bool);
        mediaParserCreateByName.setParameter(mc.b.f41164c, bool);
        mediaParserCreateByName.setParameter(mc.b.f41169h, bool);
        mediaParserCreateByName.setParameter("android.media.mediaparser.ts.ignoreSpliceInfoStream", bool);
        mediaParserCreateByName.setParameter("android.media.mediaparser.ts.mode", com.google.android.exoplayer2.offline.a.f17427e);
        String str = format.f16695i;
        if (!TextUtils.isEmpty(str)) {
            if (!hd.w.A.equals(hd.w.c(str))) {
                mediaParserCreateByName.setParameter("android.media.mediaparser.ts.ignoreAacStream", bool);
            }
            if (!hd.w.f31190j.equals(hd.w.o(str))) {
                mediaParserCreateByName.setParameter("android.media.mediaparser.ts.ignoreAvcStream", bool);
            }
        }
        return mediaParserCreateByName;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ k i(Uri uri, Format format, List list, p0 p0Var, Map map, hb.l lVar) throws IOException {
        List listOf = list;
        if (hd.k.a(format.f16699l) == 13) {
            return new c(new w(format.f16689c, p0Var), format, p0Var);
        }
        boolean z10 = listOf != null;
        ImmutableList.Builder builder = ImmutableList.builder();
        if (listOf != null) {
            for (int i10 = 0; i10 < list.size(); i10++) {
                builder.add(mc.b.a((Format) list.get(i10)));
            }
        } else {
            builder.add(mc.b.a(new Format.b().e0(hd.w.f31195l0).E()));
        }
        ImmutableList immutableListBuild = builder.build();
        mc.c cVar = new mc.c();
        if (listOf == null) {
            listOf = ImmutableList.of();
        }
        cVar.p(listOf);
        cVar.s(p0Var);
        MediaParser mediaParserH = h(cVar, format, z10, immutableListBuild, "android.media.mediaparser.FragmentedMp4Parser", "android.media.mediaparser.Ac3Parser", "android.media.mediaparser.Ac4Parser", "android.media.mediaparser.AdtsParser", "android.media.mediaparser.Mp3Parser", "android.media.mediaparser.TsParser");
        b bVar = new b(lVar);
        mediaParserH.advance(bVar);
        cVar.r(mediaParserH.getParserName());
        return new u(mediaParserH, cVar, format, z10, immutableListBuild, bVar.f18117b);
    }

    @Override // com.google.android.exoplayer2.source.hls.k
    public boolean a(hb.l lVar) throws IOException {
        lVar.o(this.f18115g);
        this.f18115g = 0;
        this.f18110b.c(lVar, lVar.getLength());
        return this.f18111c.advance(this.f18110b);
    }

    @Override // com.google.android.exoplayer2.source.hls.k
    public void c(hb.m mVar) {
        this.f18109a.o(mVar);
    }

    @Override // com.google.android.exoplayer2.source.hls.k
    public void d() {
        this.f18111c.seek(MediaParser.SeekPoint.START);
    }

    @Override // com.google.android.exoplayer2.source.hls.k
    public boolean e() {
        String parserName = this.f18111c.getParserName();
        return "android.media.mediaparser.Ac3Parser".equals(parserName) || "android.media.mediaparser.Ac4Parser".equals(parserName) || "android.media.mediaparser.AdtsParser".equals(parserName) || "android.media.mediaparser.Mp3Parser".equals(parserName);
    }

    @Override // com.google.android.exoplayer2.source.hls.k
    public boolean f() {
        String parserName = this.f18111c.getParserName();
        return "android.media.mediaparser.FragmentedMp4Parser".equals(parserName) || "android.media.mediaparser.TsParser".equals(parserName);
    }

    @Override // com.google.android.exoplayer2.source.hls.k
    public k g() {
        hd.a.i(!f());
        return new u(h(this.f18109a, this.f18112d, this.f18113e, this.f18114f, this.f18111c.getParserName()), this.f18109a, this.f18112d, this.f18113e, this.f18114f, 0);
    }
}
