package hd;

import android.os.SystemClock;
import android.text.TextUtils;
import android.view.Surface;
import com.bumptech.glide.load.engine.GlideException;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
import com.google.android.exoplayer2.trackselection.c;
import com.tencent.connect.share.QzonePublish;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import ya.j1;
import ya.x1;
import za.g1;
import za.h1;

/* JADX INFO: loaded from: classes3.dex */
public class j implements h1 {

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public static final String f31000e0 = "EventLogger";

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public static final int f31001f0 = 3;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public static final NumberFormat f31002g0;

    @g.p0
    public final com.google.android.exoplayer2.trackselection.c Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public final String f31003a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public final x1.c f31004b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public final x1.b f31005c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public final long f31006d0;

    static {
        NumberFormat numberFormat = NumberFormat.getInstance(Locale.US);
        f31002g0 = numberFormat;
        numberFormat.setMinimumFractionDigits(2);
        numberFormat.setMaximumFractionDigits(2);
        numberFormat.setGroupingUsed(false);
    }

    public j(@g.p0 com.google.android.exoplayer2.trackselection.c cVar) {
        this(cVar, f31000e0);
    }

    public static String k(int i10, int i11) {
        if (i10 < 2) {
            return "N/A";
        }
        if (i11 == 0) {
            return HlsPlaylistParser.W;
        }
        if (i11 == 8) {
            return "YES_NOT_SEAMLESS";
        }
        if (i11 == 16) {
            return HlsPlaylistParser.V;
        }
        throw new IllegalStateException();
    }

    public static String o0(int i10) {
        return i10 != 0 ? i10 != 1 ? i10 != 2 ? i10 != 3 ? "?" : "PLAYLIST_CHANGED" : "SEEK" : "AUTO" : "REPEAT";
    }

    public static String p0(int i10) {
        return i10 != 1 ? i10 != 2 ? i10 != 3 ? i10 != 4 ? i10 != 5 ? "?" : "END_OF_MEDIA_ITEM" : "REMOTE" : "AUDIO_BECOMING_NOISY" : "AUDIO_FOCUS_LOSS" : "USER_REQUEST";
    }

    public static String q(int i10) {
        return i10 != 0 ? i10 != 1 ? i10 != 2 ? i10 != 3 ? i10 != 4 ? "?" : "INTERNAL" : "AD_INSERTION" : "SEEK_ADJUSTMENT" : "SEEK" : "PERIOD_TRANSITION";
    }

    public static String q0(int i10) {
        return i10 != 0 ? i10 != 1 ? "?" : "TRANSIENT_AUDIO_FOCUS_LOSS" : HlsPlaylistParser.M;
    }

    public static String r0(int i10) {
        return i10 != 0 ? i10 != 1 ? i10 != 2 ? "?" : "ALL" : "ONE" : "OFF";
    }

    public static String s0(int i10) {
        return i10 != 1 ? i10 != 2 ? i10 != 3 ? i10 != 4 ? "?" : "ENDED" : "READY" : "BUFFERING" : "IDLE";
    }

    public static String t0(long j10) {
        return j10 == ya.g.f56663b ? "?" : f31002g0.format(j10 / 1000.0f);
    }

    public static String u0(int i10) {
        return i10 != 0 ? i10 != 1 ? "?" : "SOURCE_UPDATE" : "PLAYLIST_CHANGED";
    }

    public static String v0(@g.p0 ad.h hVar, TrackGroup trackGroup, int i10) {
        return w0((hVar == null || hVar.a() != trackGroup || hVar.e(i10) == -1) ? false : true);
    }

    public static String w0(boolean z10) {
        return z10 ? "[X]" : "[ ]";
    }

    @Override // za.h1
    public /* synthetic */ void A(h1.b bVar, boolean z10) {
        g1.F(this, bVar, z10);
    }

    public void A0(String str) {
        t.d(this.f31003a0, str);
    }

    @Override // za.h1
    public void B(h1.b bVar, int i10) {
        z0(bVar, "playbackSuppressionReason", q0(i10));
    }

    public final void B0(h1.b bVar, String str, String str2, @g.p0 Throwable th2) {
        A0(W(bVar, str, str2, th2));
    }

    @Override // za.h1
    public void C(h1.b bVar, ec.k kVar) {
        z0(bVar, "downstreamFormat", Format.l0(kVar.f26847c));
    }

    public final void C0(h1.b bVar, String str, @g.p0 Throwable th2) {
        A0(W(bVar, str, null, th2));
    }

    @Override // za.h1
    public void D(h1.b bVar, String str) {
        z0(bVar, "videoDecoderReleased", str);
    }

    public final void D0(h1.b bVar, String str, Exception exc) {
        B0(bVar, "internalError", str, exc);
    }

    @Override // za.h1
    public void E(h1.b bVar) {
        y0(bVar, "drmKeysRestored");
    }

    public final void E0(Metadata metadata, String str) {
        for (int i10 = 0; i10 < metadata.g(); i10++) {
            x0(str + metadata.e(i10));
        }
    }

    @Override // za.h1
    public void F(h1.b bVar, String str, long j10) {
        z0(bVar, "videoDecoderInitialized", str);
    }

    @Override // za.h1
    public /* synthetic */ void G(h1.b bVar, int i10, eb.d dVar) {
        g1.m(this, bVar, i10, dVar);
    }

    @Override // za.h1
    public void H(h1.b bVar, @g.p0 Surface surface) {
        z0(bVar, "renderedFirstFrame", String.valueOf(surface));
    }

    @Override // za.h1
    public /* synthetic */ void I(h1.b bVar, int i10, String str, long j10) {
        g1.o(this, bVar, i10, str, j10);
    }

    @Override // za.h1
    public /* synthetic */ void J(h1.b bVar) {
        g1.S(this, bVar);
    }

    @Override // za.h1
    public void K(h1.b bVar) {
        y0(bVar, "drmSessionReleased");
    }

    @Override // za.h1
    public void L(h1.b bVar, eb.d dVar) {
        y0(bVar, "audioDisabled");
    }

    @Override // za.h1
    public void M(h1.b bVar, ec.j jVar, ec.k kVar) {
    }

    @Override // za.h1
    public void N(h1.b bVar, ExoPlaybackException exoPlaybackException) {
        C0(bVar, "playerFailed", exoPlaybackException);
    }

    @Override // za.h1
    public void O(h1.b bVar, eb.d dVar) {
        y0(bVar, "audioEnabled");
    }

    @Override // za.h1
    public /* synthetic */ void P(h1.b bVar, int i10, eb.d dVar) {
        g1.n(this, bVar, i10, dVar);
    }

    @Override // za.h1
    public void Q(h1.b bVar, TrackGroupArray trackGroupArray, ad.i iVar) {
        com.google.android.exoplayer2.trackselection.c cVar = this.Z;
        c.a aVarG = cVar != null ? cVar.g() : null;
        if (aVarG == null) {
            z0(bVar, "tracks", okhttp3.u.f43953p);
            return;
        }
        x0("tracks [" + d0(bVar));
        int iC = aVarG.c();
        int i10 = 0;
        while (true) {
            String str = "  ]";
            String str2 = " [";
            if (i10 >= iC) {
                break;
            }
            TrackGroupArray trackGroupArrayG = aVarG.g(i10);
            ad.h hVarA = iVar.a(i10);
            int i11 = iC;
            if (trackGroupArrayG.f17502a == 0) {
                x0(GlideException.a.f12263d + aVarG.d(i10) + " []");
            } else {
                x0(GlideException.a.f12263d + aVarG.d(i10) + " [");
                int i12 = 0;
                while (i12 < trackGroupArrayG.f17502a) {
                    TrackGroup trackGroupA = trackGroupArrayG.a(i12);
                    TrackGroupArray trackGroupArray2 = trackGroupArrayG;
                    String str3 = str;
                    x0("    Group:" + i12 + ", adaptive_supported=" + k(trackGroupA.f17498a, aVarG.a(i10, i12, false)) + str2);
                    int i13 = 0;
                    while (i13 < trackGroupA.f17498a) {
                        x0("      " + v0(hVarA, trackGroupA, i13) + " Track:" + i13 + ", " + Format.l0(trackGroupA.a(i13)) + ", supported=" + ya.g.b(aVarG.h(i10, i12, i13)));
                        i13++;
                        str2 = str2;
                    }
                    x0("    ]");
                    i12++;
                    trackGroupArrayG = trackGroupArray2;
                    str = str3;
                }
                String str4 = str;
                if (hVarA != null) {
                    int i14 = 0;
                    while (true) {
                        if (i14 >= hVarA.length()) {
                            break;
                        }
                        Metadata metadata = hVarA.b(i14).f16696j;
                        if (metadata != null) {
                            x0("    Metadata [");
                            E0(metadata, "      ");
                            x0("    ]");
                            break;
                        }
                        i14++;
                    }
                }
                x0(str4);
            }
            i10++;
            iC = i11;
        }
        String str5 = " [";
        TrackGroupArray trackGroupArrayJ = aVarG.j();
        if (trackGroupArrayJ.f17502a > 0) {
            x0("  Unmapped [");
            int i15 = 0;
            while (i15 < trackGroupArrayJ.f17502a) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("    Group:");
                sb2.append(i15);
                String str6 = str5;
                sb2.append(str6);
                x0(sb2.toString());
                TrackGroup trackGroupA2 = trackGroupArrayJ.a(i15);
                for (int i16 = 0; i16 < trackGroupA2.f17498a; i16++) {
                    x0("      " + w0(false) + " Track:" + i16 + ", " + Format.l0(trackGroupA2.a(i16)) + ", supported=" + ya.g.b(0));
                }
                x0("    ]");
                i15++;
                str5 = str6;
            }
            x0("  ]");
        }
        x0("]");
    }

    @Override // za.h1
    public /* synthetic */ void R(h1.b bVar, int i10, Format format) {
        g1.p(this, bVar, i10, format);
    }

    @Override // za.h1
    public void S(h1.b bVar, int i10, long j10, long j11) {
        B0(bVar, "audioTrackUnderrun", i10 + ", " + j10 + ", " + j11, null);
    }

    @Override // za.h1
    public /* synthetic */ void T(h1.b bVar, long j10, int i10) {
        g1.f0(this, bVar, j10, i10);
    }

    @Override // za.h1
    public void U(h1.b bVar) {
        y0(bVar, "seekStarted");
    }

    @Override // za.h1
    public void V(h1.b bVar, ec.j jVar, ec.k kVar) {
    }

    public final String W(h1.b bVar, String str, @g.p0 String str2, @g.p0 Throwable th2) {
        String str3 = str + " [" + d0(bVar);
        if (str2 != null) {
            str3 = str3 + ", " + str2;
        }
        String strH = t.h(th2);
        if (!TextUtils.isEmpty(strH)) {
            str3 = str3 + "\n  " + strH.replace("\n", "\n  ") + '\n';
        }
        return str3 + "]";
    }

    @Override // za.h1
    public void X(h1.b bVar, int i10) {
        z0(bVar, "audioSessionId", Integer.toString(i10));
    }

    @Override // za.h1
    public void Y(h1.b bVar, eb.d dVar) {
        y0(bVar, "videoDisabled");
    }

    @Override // za.h1
    public void Z(h1.b bVar) {
        y0(bVar, "drmSessionAcquired");
    }

    @Override // za.h1
    public void a(h1.b bVar, boolean z10) {
        z0(bVar, "isPlaying", Boolean.toString(z10));
    }

    @Override // za.h1
    public /* synthetic */ void a0(h1.b bVar) {
        g1.N(this, bVar);
    }

    @Override // za.h1
    public void b(h1.b bVar, boolean z10) {
        z0(bVar, "shuffleModeEnabled", Boolean.toString(z10));
    }

    @Override // za.h1
    public void b0(h1.b bVar, float f10) {
        z0(bVar, "volume", Float.toString(f10));
    }

    @Override // za.h1
    public /* synthetic */ void c(h1.b bVar, Format format) {
        g1.g0(this, bVar, format);
    }

    @Override // za.h1
    public void c0(h1.b bVar, ec.j jVar, ec.k kVar) {
    }

    @Override // za.h1
    public void d(h1.b bVar, boolean z10) {
        z0(bVar, "skipSilenceEnabled", Boolean.toString(z10));
    }

    public final String d0(h1.b bVar) {
        String str = "window=" + bVar.f58101c;
        if (bVar.f58102d != null) {
            str = str + ", period=" + bVar.f58100b.b(bVar.f58102d.f26856a);
            if (bVar.f58102d.b()) {
                str = (str + ", adGroup=" + bVar.f58102d.f26857b) + ", ad=" + bVar.f58102d.f26858c;
            }
        }
        return "eventTime=" + t0(bVar.f58099a - this.f31006d0) + ", mediaPos=" + t0(bVar.f58103e) + ", " + str;
    }

    @Override // za.h1
    public void e(h1.b bVar, ec.j jVar, ec.k kVar, IOException iOException, boolean z10) {
        D0(bVar, "loadError", iOException);
    }

    @Override // za.h1
    public void e0(h1.b bVar, List<Metadata> list) {
        x0("staticMetadata [" + d0(bVar));
        for (int i10 = 0; i10 < list.size(); i10++) {
            Metadata metadata = list.get(i10);
            if (metadata.g() != 0) {
                x0("  Metadata:" + i10 + " [");
                E0(metadata, wn.a.f54751a);
                x0("  ]");
            }
        }
        x0("]");
    }

    @Override // za.h1
    public /* synthetic */ void f(h1.b bVar, Exception exc) {
        g1.j(this, bVar, exc);
    }

    @Override // za.h1
    public void f0(h1.b bVar, eb.d dVar) {
        y0(bVar, "videoEnabled");
    }

    @Override // za.h1
    public void g(h1.b bVar, @g.p0 ya.v0 v0Var, int i10) {
        x0("mediaItem [" + d0(bVar) + ", reason=" + o0(i10) + "]");
    }

    @Override // za.h1
    public void g0(h1.b bVar, int i10) {
        z0(bVar, "repeatMode", r0(i10));
    }

    @Override // za.h1
    public void h(h1.b bVar, int i10, int i11, int i12, float f10) {
        z0(bVar, QzonePublish.PUBLISH_TO_QZONE_VIDEO_SIZE, i10 + ", " + i11);
    }

    @Override // za.h1
    public void h0(h1.b bVar) {
        y0(bVar, "drmKeysRemoved");
    }

    @Override // za.h1
    public void i(h1.b bVar, String str) {
        z0(bVar, "audioDecoderReleased", str);
    }

    @Override // za.h1
    public /* synthetic */ void i0(j1 j1Var, h1.c cVar) {
        g1.y(this, j1Var, cVar);
    }

    @Override // za.h1
    public /* synthetic */ void j(h1.b bVar, boolean z10, int i10) {
        g1.O(this, bVar, z10, i10);
    }

    @Override // za.h1
    public void j0(h1.b bVar, Format format, @g.p0 eb.e eVar) {
        z0(bVar, "videoInputFormat", Format.l0(format));
    }

    @Override // za.h1
    public void k0(h1.b bVar, int i10) {
        int i11 = bVar.f58100b.i();
        int iQ = bVar.f58100b.q();
        x0("timeline [" + d0(bVar) + ", periodCount=" + i11 + ", windowCount=" + iQ + ", reason=" + u0(i10));
        for (int i12 = 0; i12 < Math.min(i11, 3); i12++) {
            bVar.f58100b.f(i12, this.f31005c0);
            x0("  period [" + t0(this.f31005c0.i()) + "]");
        }
        if (i11 > 3) {
            x0("  ...");
        }
        for (int i13 = 0; i13 < Math.min(iQ, 3); i13++) {
            bVar.f58100b.n(i13, this.f31004b0);
            x0("  window [" + t0(this.f31004b0.d()) + ", seekable=" + this.f31004b0.f57247h + ", dynamic=" + this.f31004b0.f57248i + "]");
        }
        if (iQ > 3) {
            x0("  ...");
        }
        x0("]");
    }

    @Override // za.h1
    public void l(h1.b bVar, int i10) {
        z0(bVar, "state", s0(i10));
    }

    @Override // za.h1
    public void l0(h1.b bVar, Format format, @g.p0 eb.e eVar) {
        z0(bVar, "audioInputFormat", Format.l0(format));
    }

    @Override // za.h1
    public void m(h1.b bVar, ab.d dVar) {
        z0(bVar, "audioAttributes", dVar.f418a + ag.c.f654g + dVar.f419b + ag.c.f654g + dVar.f420c + ag.c.f654g + dVar.f421d);
    }

    @Override // za.h1
    public void m0(h1.b bVar, int i10, int i11) {
        z0(bVar, "surfaceSize", i10 + ", " + i11);
    }

    @Override // za.h1
    public void n(h1.b bVar, ya.h1 h1Var) {
        z0(bVar, "playbackParameters", h1Var.toString());
    }

    @Override // za.h1
    public void n0(h1.b bVar, ec.k kVar) {
        z0(bVar, "upstreamDiscarded", Format.l0(kVar.f26847c));
    }

    @Override // za.h1
    public /* synthetic */ void o(h1.b bVar, long j10) {
        g1.h(this, bVar, j10);
    }

    @Override // za.h1
    public /* synthetic */ void p(h1.b bVar, Format format) {
        g1.f(this, bVar, format);
    }

    @Override // za.h1
    public void r(h1.b bVar, boolean z10) {
        z0(bVar, "loading", Boolean.toString(z10));
    }

    @Override // za.h1
    public void s(h1.b bVar, int i10, long j10) {
        z0(bVar, "droppedFrames", Integer.toString(i10));
    }

    @Override // za.h1
    public void t(h1.b bVar, int i10, long j10, long j11) {
    }

    @Override // za.h1
    public void u(h1.b bVar) {
        y0(bVar, "drmKeysLoaded");
    }

    @Override // za.h1
    public void v(h1.b bVar, Metadata metadata) {
        x0("metadata [" + d0(bVar));
        E0(metadata, GlideException.a.f12263d);
        x0("]");
    }

    @Override // za.h1
    public void w(h1.b bVar, int i10) {
        z0(bVar, "positionDiscontinuity", q(i10));
    }

    @Override // za.h1
    public void x(h1.b bVar, boolean z10, int i10) {
        z0(bVar, "playWhenReady", z10 + ", " + p0(i10));
    }

    public void x0(String str) {
        t.b(this.f31003a0, str);
    }

    @Override // za.h1
    public void y(h1.b bVar, String str, long j10) {
        z0(bVar, "audioDecoderInitialized", str);
    }

    public final void y0(h1.b bVar, String str) {
        x0(W(bVar, str, null, null));
    }

    @Override // za.h1
    public void z(h1.b bVar, Exception exc) {
        D0(bVar, "drmSessionManagerError", exc);
    }

    public final void z0(h1.b bVar, String str, String str2) {
        x0(W(bVar, str, str2, null));
    }

    public j(@g.p0 com.google.android.exoplayer2.trackselection.c cVar, String str) {
        this.Z = cVar;
        this.f31003a0 = str;
        this.f31004b0 = new x1.c();
        this.f31005c0 = new x1.b();
        this.f31006d0 = SystemClock.elapsedRealtime();
    }
}
