package ya;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.audio.AudioSink;
import com.google.android.exoplayer2.audio.DefaultAudioSink;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class m implements s1 {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final long f56912l = 5000;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f56913m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f56914n = 1;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f56915o = 2;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f56916p = 50;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String f56917q = "DefaultRenderersFactory";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f56918a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f56919b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f56920c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f56921d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.google.android.exoplayer2.mediacodec.d f56922e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f56923f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f56924g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f56925h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f56926i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f56927j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f56928k;

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface a {
    }

    public m(Context context) {
        this.f56918a = context;
        this.f56919b = 0;
        this.f56920c = 5000L;
        this.f56922e = com.google.android.exoplayer2.mediacodec.d.f17214a;
    }

    @Override // ya.s1
    public o1[] a(Handler handler, id.z zVar, com.google.android.exoplayer2.audio.a aVar, qc.k kVar, ub.e eVar) {
        ArrayList<o1> arrayList = new ArrayList<>();
        h(this.f56918a, this.f56919b, this.f56922e, this.f56921d, handler, zVar, this.f56920c, arrayList);
        AudioSink audioSinkC = c(this.f56918a, this.f56926i, this.f56927j, this.f56928k);
        if (audioSinkC != null) {
            b(this.f56918a, this.f56919b, this.f56922e, this.f56921d, audioSinkC, handler, aVar, arrayList);
        }
        g(this.f56918a, kVar, handler.getLooper(), this.f56919b, arrayList);
        e(this.f56918a, eVar, handler.getLooper(), this.f56919b, arrayList);
        d(this.f56918a, this.f56919b, arrayList);
        f(this.f56918a, handler, this.f56919b, arrayList);
        return (o1[]) arrayList.toArray(new o1[0]);
    }

    public void b(Context context, int i10, com.google.android.exoplayer2.mediacodec.d dVar, boolean z10, AudioSink audioSink, Handler handler, com.google.android.exoplayer2.audio.a aVar, ArrayList<o1> arrayList) {
        int i11;
        int i12;
        com.google.android.exoplayer2.audio.h hVar = new com.google.android.exoplayer2.audio.h(context, dVar, z10, handler, aVar, audioSink);
        hVar.j0(this.f56923f);
        hVar.k0(this.f56924g);
        hVar.l0(this.f56925h);
        arrayList.add(hVar);
        if (i10 == 0) {
            return;
        }
        int size = arrayList.size();
        if (i10 == 2) {
            size--;
        }
        try {
            try {
                i11 = size + 1;
            } catch (Exception e10) {
                throw new RuntimeException("Error instantiating Opus extension", e10);
            }
        } catch (ClassNotFoundException unused) {
        }
        try {
            arrayList.add(size, (o1) Class.forName("com.google.android.exoplayer2.ext.opus.LibopusAudioRenderer").getConstructor(Handler.class, com.google.android.exoplayer2.audio.a.class, AudioSink.class).newInstance(handler, aVar, audioSink));
            hd.t.i(f56917q, "Loaded LibopusAudioRenderer.");
        } catch (ClassNotFoundException unused2) {
            size = i11;
            i11 = size;
        }
        try {
            try {
                i12 = i11 + 1;
                try {
                    arrayList.add(i11, (o1) Class.forName("com.google.android.exoplayer2.ext.flac.LibflacAudioRenderer").getConstructor(Handler.class, com.google.android.exoplayer2.audio.a.class, AudioSink.class).newInstance(handler, aVar, audioSink));
                    hd.t.i(f56917q, "Loaded LibflacAudioRenderer.");
                } catch (ClassNotFoundException unused3) {
                    i11 = i12;
                    i12 = i11;
                }
            } catch (ClassNotFoundException unused4) {
            }
            try {
                arrayList.add(i12, (o1) Class.forName("com.google.android.exoplayer2.ext.ffmpeg.FfmpegAudioRenderer").getConstructor(Handler.class, com.google.android.exoplayer2.audio.a.class, AudioSink.class).newInstance(handler, aVar, audioSink));
                hd.t.i(f56917q, "Loaded FfmpegAudioRenderer.");
            } catch (ClassNotFoundException unused5) {
            } catch (Exception e11) {
                throw new RuntimeException("Error instantiating FFmpeg extension", e11);
            }
        } catch (Exception e12) {
            throw new RuntimeException("Error instantiating FLAC extension", e12);
        }
    }

    @g.p0
    public AudioSink c(Context context, boolean z10, boolean z11, boolean z12) {
        return new DefaultAudioSink(ab.e.b(context), new DefaultAudioSink.d(new AudioProcessor[0]), z10, z11, z12);
    }

    public void d(Context context, int i10, ArrayList<o1> arrayList) {
        arrayList.add(new jd.b());
    }

    public void e(Context context, ub.e eVar, Looper looper, int i10, ArrayList<o1> arrayList) {
        arrayList.add(new com.google.android.exoplayer2.metadata.a(eVar, looper));
    }

    public void f(Context context, Handler handler, int i10, ArrayList<o1> arrayList) {
    }

    public void g(Context context, qc.k kVar, Looper looper, int i10, ArrayList<o1> arrayList) {
        arrayList.add(new qc.l(kVar, looper));
    }

    public void h(Context context, int i10, com.google.android.exoplayer2.mediacodec.d dVar, boolean z10, Handler handler, id.z zVar, long j10, ArrayList<o1> arrayList) {
        int i11;
        id.f fVar = new id.f(context, dVar, j10, z10, handler, zVar, 50);
        fVar.j0(this.f56923f);
        fVar.k0(this.f56924g);
        fVar.l0(this.f56925h);
        arrayList.add(fVar);
        if (i10 == 0) {
            return;
        }
        int size = arrayList.size();
        if (i10 == 2) {
            size--;
        }
        try {
            try {
                i11 = size + 1;
            } catch (Exception e10) {
                throw new RuntimeException("Error instantiating VP9 extension", e10);
            }
        } catch (ClassNotFoundException unused) {
        }
        try {
            arrayList.add(size, (o1) Class.forName("com.google.android.exoplayer2.ext.vp9.LibvpxVideoRenderer").getConstructor(Long.TYPE, Handler.class, id.z.class, Integer.TYPE).newInstance(Long.valueOf(j10), handler, zVar, 50));
            hd.t.i(f56917q, "Loaded LibvpxVideoRenderer.");
        } catch (ClassNotFoundException unused2) {
            size = i11;
            i11 = size;
        }
        try {
            arrayList.add(i11, (o1) Class.forName("com.google.android.exoplayer2.ext.av1.Libgav1VideoRenderer").getConstructor(Long.TYPE, Handler.class, id.z.class, Integer.TYPE).newInstance(Long.valueOf(j10), handler, zVar, 50));
            hd.t.i(f56917q, "Loaded Libgav1VideoRenderer.");
        } catch (ClassNotFoundException unused3) {
        } catch (Exception e11) {
            throw new RuntimeException("Error instantiating AV1 extension", e11);
        }
    }

    public m i(boolean z10) {
        this.f56923f = z10;
        return this;
    }

    public m j(boolean z10) {
        this.f56924g = z10;
        return this;
    }

    public m k(boolean z10) {
        this.f56925h = z10;
        return this;
    }

    public m l(long j10) {
        this.f56920c = j10;
        return this;
    }

    public m m(boolean z10) {
        this.f56926i = z10;
        return this;
    }

    public m n(boolean z10) {
        this.f56928k = z10;
        return this;
    }

    public m o(boolean z10) {
        this.f56927j = z10;
        return this;
    }

    public m p(boolean z10) {
        this.f56921d = z10;
        return this;
    }

    public m q(int i10) {
        this.f56919b = i10;
        return this;
    }

    public m r(com.google.android.exoplayer2.mediacodec.d dVar) {
        this.f56922e = dVar;
        return this;
    }

    @Deprecated
    public m(Context context, int i10) {
        this(context, i10, 5000L);
    }

    @Deprecated
    public m(Context context, int i10, long j10) {
        this.f56918a = context;
        this.f56919b = i10;
        this.f56920c = j10;
        this.f56922e = com.google.android.exoplayer2.mediacodec.d.f17214a;
    }
}
