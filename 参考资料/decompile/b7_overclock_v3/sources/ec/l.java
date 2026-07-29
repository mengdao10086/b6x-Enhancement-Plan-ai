package ec;

import android.annotation.SuppressLint;
import android.media.MediaParser;
import android.net.Uri;
import android.util.Pair;
import g.v0;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
@v0(30)
public final class l implements y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final mc.c f26852a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final mc.a f26853b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MediaParser f26854c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f26855d;

    @SuppressLint({"WrongConstant"})
    public l() {
        mc.c cVar = new mc.c();
        this.f26852a = cVar;
        this.f26853b = new mc.a();
        MediaParser mediaParserCreate = MediaParser.create(cVar, new String[0]);
        this.f26854c = mediaParserCreate;
        Boolean bool = Boolean.TRUE;
        mediaParserCreate.setParameter(mc.b.f41164c, bool);
        mediaParserCreate.setParameter(mc.b.f41162a, bool);
        mediaParserCreate.setParameter(mc.b.f41163b, bool);
        this.f26855d = "android.media.mediaparser.UNKNOWN";
    }

    @Override // ec.y
    public void b(long j10, long j11) {
        this.f26853b.b(j10);
        Pair<MediaParser.SeekPoint, MediaParser.SeekPoint> pairK = this.f26852a.k(j11);
        MediaParser mediaParser = this.f26854c;
        Object obj = pairK.second;
        mediaParser.seek(((MediaParser.SeekPoint) obj).position == j10 ? (MediaParser.SeekPoint) obj : (MediaParser.SeekPoint) pairK.first);
    }

    @Override // ec.y
    public void c(ed.h hVar, Uri uri, Map<String, List<String>> map, long j10, long j11, hb.m mVar) throws IOException {
        this.f26852a.o(mVar);
        this.f26853b.c(hVar, j11);
        this.f26853b.b(j10);
        String parserName = this.f26854c.getParserName();
        if ("android.media.mediaparser.UNKNOWN".equals(parserName)) {
            this.f26854c.advance(this.f26853b);
            String parserName2 = this.f26854c.getParserName();
            this.f26855d = parserName2;
            this.f26852a.r(parserName2);
            return;
        }
        if (parserName.equals(this.f26855d)) {
            return;
        }
        String parserName3 = this.f26854c.getParserName();
        this.f26855d = parserName3;
        this.f26852a.r(parserName3);
    }

    @Override // ec.y
    public long d() {
        return this.f26853b.getPosition();
    }

    @Override // ec.y
    public void e() {
        if ("android.media.mediaparser.Mp3Parser".equals(this.f26855d)) {
            this.f26852a.a();
        }
    }

    @Override // ec.y
    public int f(hb.z zVar) throws IOException {
        boolean zAdvance = this.f26854c.advance(this.f26853b);
        long jA = this.f26853b.a();
        zVar.f30930a = jA;
        if (zAdvance) {
            return jA != -1 ? 1 : 0;
        }
        return -1;
    }

    @Override // ec.y
    public void release() {
        this.f26854c.release();
    }
}
