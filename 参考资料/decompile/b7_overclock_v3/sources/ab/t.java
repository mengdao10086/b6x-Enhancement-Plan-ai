package ab;

import android.annotation.TargetApi;
import android.media.AudioTimestamp;
import android.media.AudioTrack;
import g.p0;
import g.v0;
import hd.u0;

/* JADX INFO: loaded from: classes3.dex */
public final class t {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f467g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f468h = 1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f469i = 2;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f470j = 3;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f471k = 4;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f472l = 10000;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f473m = 10000000;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f474n = 500000;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f475o = 500000;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @p0
    public final a f476a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f477b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f478c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f479d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f480e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f481f;

    @v0(19)
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AudioTrack f482a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AudioTimestamp f483b = new AudioTimestamp();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f484c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f485d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f486e;

        public a(AudioTrack audioTrack) {
            this.f482a = audioTrack;
        }

        public long a() {
            return this.f486e;
        }

        public long b() {
            return this.f483b.nanoTime / 1000;
        }

        public boolean c() {
            boolean timestamp = this.f482a.getTimestamp(this.f483b);
            if (timestamp) {
                long j10 = this.f483b.framePosition;
                if (this.f485d > j10) {
                    this.f484c++;
                }
                this.f485d = j10;
                this.f486e = j10 + (this.f484c << 32);
            }
            return timestamp;
        }
    }

    public t(AudioTrack audioTrack) {
        if (u0.f31154a >= 19) {
            this.f476a = new a(audioTrack);
            h();
        } else {
            this.f476a = null;
            i(3);
        }
    }

    public void a() {
        if (this.f477b == 4) {
            h();
        }
    }

    @TargetApi(19)
    public long b() {
        a aVar = this.f476a;
        if (aVar != null) {
            return aVar.a();
        }
        return -1L;
    }

    @TargetApi(19)
    public long c() {
        a aVar = this.f476a;
        return aVar != null ? aVar.b() : ya.g.f56663b;
    }

    public boolean d() {
        return this.f477b == 2;
    }

    public boolean e() {
        int i10 = this.f477b;
        return i10 == 1 || i10 == 2;
    }

    @TargetApi(19)
    public boolean f(long j10) {
        a aVar = this.f476a;
        if (aVar == null || j10 - this.f480e < this.f479d) {
            return false;
        }
        this.f480e = j10;
        boolean zC = aVar.c();
        int i10 = this.f477b;
        if (i10 != 0) {
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 != 3) {
                        if (i10 != 4) {
                            throw new IllegalStateException();
                        }
                    } else if (zC) {
                        h();
                    }
                } else if (!zC) {
                    h();
                }
            } else if (!zC) {
                h();
            } else if (this.f476a.a() > this.f481f) {
                i(2);
            }
        } else if (zC) {
            if (this.f476a.b() < this.f478c) {
                return false;
            }
            this.f481f = this.f476a.a();
            i(1);
        } else if (j10 - this.f478c > 500000) {
            i(3);
        }
        return zC;
    }

    public void g() {
        i(4);
    }

    public void h() {
        if (this.f476a != null) {
            i(0);
        }
    }

    public final void i(int i10) {
        this.f477b = i10;
        if (i10 == 0) {
            this.f480e = 0L;
            this.f481f = -1L;
            this.f478c = System.nanoTime() / 1000;
            this.f479d = 10000L;
            return;
        }
        if (i10 == 1) {
            this.f479d = 10000L;
            return;
        }
        if (i10 == 2 || i10 == 3) {
            this.f479d = 10000000L;
        } else {
            if (i10 != 4) {
                throw new IllegalStateException();
            }
            this.f479d = 500000L;
        }
    }
}
