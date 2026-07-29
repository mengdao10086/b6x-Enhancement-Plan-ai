package com.google.android.exoplayer2.audio;

import ab.t;
import android.media.AudioTrack;
import android.os.SystemClock;
import g.p0;
import hd.u0;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public static final int G = 1;
    public static final int H = 2;
    public static final int I = 3;
    public static final long J = 5000000;
    public static final long K = 5000000;
    public static final long L = 1000000;
    public static final long M = 200;
    public static final int N = 10;
    public static final int O = 30000;
    public static final int P = 500000;
    public long A;
    public long B;
    public long C;
    public boolean D;
    public long E;
    public long F;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f16836a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long[] f16837b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @p0
    public AudioTrack f16838c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f16839d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f16840e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @p0
    public t f16841f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f16842g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f16843h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f16844i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f16845j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f16846k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f16847l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f16848m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @p0
    public Method f16849n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f16850o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f16851p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f16852q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f16853r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f16854s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f16855t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public long f16856u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f16857v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f16858w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public long f16859x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public long f16860y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public long f16861z;

    public interface a {
        void a(int i10, long j10);

        void b(long j10);

        void c(long j10);

        void d(long j10, long j11, long j12, long j13);

        void e(long j10, long j11, long j12, long j13);
    }

    public b(a aVar) {
        this.f16836a = (a) hd.a.g(aVar);
        if (u0.f31154a >= 18) {
            try {
                this.f16849n = AudioTrack.class.getMethod("getLatency", null);
            } catch (NoSuchMethodException unused) {
            }
        }
        this.f16837b = new long[10];
    }

    public static boolean p(int i10) {
        return u0.f31154a < 23 && (i10 == 5 || i10 == 6);
    }

    public final boolean a() {
        return this.f16843h && ((AudioTrack) hd.a.g(this.f16838c)).getPlayState() == 2 && f() == 0;
    }

    public final long b(long j10) {
        return (j10 * 1000000) / ((long) this.f16842g);
    }

    public int c(long j10) {
        return this.f16840e - ((int) (j10 - (f() * ((long) this.f16839d))));
    }

    public long d(boolean z10) {
        long jG;
        if (((AudioTrack) hd.a.g(this.f16838c)).getPlayState() == 3) {
            n();
        }
        long jNanoTime = System.nanoTime() / 1000;
        t tVar = (t) hd.a.g(this.f16841f);
        boolean zD = tVar.d();
        if (zD) {
            jG = b(tVar.b()) + u0.g0(jNanoTime - tVar.c(), this.f16845j);
        } else {
            jG = this.f16858w == 0 ? g() : this.f16847l + jNanoTime;
            if (!z10) {
                jG = Math.max(0L, jG - this.f16850o);
            }
        }
        if (this.D != zD) {
            this.F = this.C;
            this.E = this.B;
        }
        long j10 = jNanoTime - this.F;
        if (j10 < 1000000) {
            long jG0 = this.E + u0.g0(j10, this.f16845j);
            long j11 = (j10 * 1000) / 1000000;
            jG = ((jG * j11) + ((1000 - j11) * jG0)) / 1000;
        }
        if (!this.f16846k) {
            long j12 = this.B;
            if (jG > j12) {
                this.f16846k = true;
                this.f16836a.b(System.currentTimeMillis() - ya.g.d(u0.n0(ya.g.d(jG - j12), this.f16845j)));
            }
        }
        this.C = jNanoTime;
        this.B = jG;
        this.D = zD;
        return jG;
    }

    public long e(long j10) {
        return ya.g.d(b(j10 - f()));
    }

    public final long f() {
        AudioTrack audioTrack = (AudioTrack) hd.a.g(this.f16838c);
        if (this.f16859x != ya.g.f56663b) {
            return Math.min(this.A, this.f16861z + ((((SystemClock.elapsedRealtime() * 1000) - this.f16859x) * ((long) this.f16842g)) / 1000000));
        }
        int playState = audioTrack.getPlayState();
        if (playState == 1) {
            return 0L;
        }
        long playbackHeadPosition = 4294967295L & ((long) audioTrack.getPlaybackHeadPosition());
        if (this.f16843h) {
            if (playState == 2 && playbackHeadPosition == 0) {
                this.f16856u = this.f16854s;
            }
            playbackHeadPosition += this.f16856u;
        }
        if (u0.f31154a <= 29) {
            if (playbackHeadPosition == 0 && this.f16854s > 0 && playState == 3) {
                if (this.f16860y == ya.g.f56663b) {
                    this.f16860y = SystemClock.elapsedRealtime();
                }
                return this.f16854s;
            }
            this.f16860y = ya.g.f56663b;
        }
        if (this.f16854s > playbackHeadPosition) {
            this.f16855t++;
        }
        this.f16854s = playbackHeadPosition;
        return playbackHeadPosition + (this.f16855t << 32);
    }

    public final long g() {
        return b(f());
    }

    public void h(long j10) {
        this.f16861z = f();
        this.f16859x = SystemClock.elapsedRealtime() * 1000;
        this.A = j10;
    }

    public boolean i(long j10) {
        return j10 > f() || a();
    }

    public boolean j() {
        return ((AudioTrack) hd.a.g(this.f16838c)).getPlayState() == 3;
    }

    public boolean k(long j10) {
        return this.f16860y != ya.g.f56663b && j10 > 0 && SystemClock.elapsedRealtime() - this.f16860y >= 200;
    }

    public boolean l(long j10) {
        int playState = ((AudioTrack) hd.a.g(this.f16838c)).getPlayState();
        if (this.f16843h) {
            if (playState == 2) {
                this.f16851p = false;
                return false;
            }
            if (playState == 1 && f() == 0) {
                return false;
            }
        }
        boolean z10 = this.f16851p;
        boolean zI = i(j10);
        this.f16851p = zI;
        if (z10 && !zI && playState != 1) {
            this.f16836a.a(this.f16840e, ya.g.d(this.f16844i));
        }
        return true;
    }

    public final void m(long j10, long j11) {
        t tVar = (t) hd.a.g(this.f16841f);
        if (tVar.f(j10)) {
            long jC = tVar.c();
            long jB = tVar.b();
            if (Math.abs(jC - j10) > 5000000) {
                this.f16836a.e(jB, jC, j10, j11);
                tVar.g();
            } else if (Math.abs(b(jB) - j11) <= 5000000) {
                tVar.a();
            } else {
                this.f16836a.d(jB, jC, j10, j11);
                tVar.g();
            }
        }
    }

    public final void n() {
        long jG = g();
        if (jG == 0) {
            return;
        }
        long jNanoTime = System.nanoTime() / 1000;
        if (jNanoTime - this.f16848m >= 30000) {
            long[] jArr = this.f16837b;
            int i10 = this.f16857v;
            jArr[i10] = jG - jNanoTime;
            this.f16857v = (i10 + 1) % 10;
            int i11 = this.f16858w;
            if (i11 < 10) {
                this.f16858w = i11 + 1;
            }
            this.f16848m = jNanoTime;
            this.f16847l = 0L;
            int i12 = 0;
            while (true) {
                int i13 = this.f16858w;
                if (i12 >= i13) {
                    break;
                }
                this.f16847l += this.f16837b[i12] / ((long) i13);
                i12++;
            }
        }
        if (this.f16843h) {
            return;
        }
        m(jNanoTime, jG);
        o(jNanoTime);
    }

    public final void o(long j10) {
        Method method;
        if (!this.f16852q || (method = this.f16849n) == null || j10 - this.f16853r < 500000) {
            return;
        }
        try {
            long jIntValue = (((long) ((Integer) u0.k((Integer) method.invoke(hd.a.g(this.f16838c), new Object[0]))).intValue()) * 1000) - this.f16844i;
            this.f16850o = jIntValue;
            long jMax = Math.max(jIntValue, 0L);
            this.f16850o = jMax;
            if (jMax > 5000000) {
                this.f16836a.c(jMax);
                this.f16850o = 0L;
            }
        } catch (Exception unused) {
            this.f16849n = null;
        }
        this.f16853r = j10;
    }

    public boolean q() {
        s();
        if (this.f16859x != ya.g.f56663b) {
            return false;
        }
        ((t) hd.a.g(this.f16841f)).h();
        return true;
    }

    public void r() {
        s();
        this.f16838c = null;
        this.f16841f = null;
    }

    public final void s() {
        this.f16847l = 0L;
        this.f16858w = 0;
        this.f16857v = 0;
        this.f16848m = 0L;
        this.C = 0L;
        this.F = 0L;
        this.f16846k = false;
    }

    public void t(AudioTrack audioTrack, boolean z10, int i10, int i11, int i12) {
        this.f16838c = audioTrack;
        this.f16839d = i11;
        this.f16840e = i12;
        this.f16841f = new t(audioTrack);
        this.f16842g = audioTrack.getSampleRate();
        this.f16843h = z10 && p(i10);
        boolean zE0 = u0.E0(i10);
        this.f16852q = zE0;
        this.f16844i = zE0 ? b(i12 / i11) : -9223372036854775807L;
        this.f16854s = 0L;
        this.f16855t = 0L;
        this.f16856u = 0L;
        this.f16851p = false;
        this.f16859x = ya.g.f56663b;
        this.f16860y = ya.g.f56663b;
        this.f16853r = 0L;
        this.f16850o = 0L;
        this.f16845j = 1.0f;
    }

    public void u(float f10) {
        this.f16845j = f10;
        t tVar = this.f16841f;
        if (tVar != null) {
            tVar.h();
        }
    }

    public void v() {
        ((t) hd.a.g(this.f16841f)).h();
    }
}
