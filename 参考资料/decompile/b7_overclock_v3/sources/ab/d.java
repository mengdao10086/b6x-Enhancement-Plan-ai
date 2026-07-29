package ab;

import android.media.AudioAttributes;
import g.p0;
import g.v0;
import hd.u0;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final d f417f = new b().a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f418a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f419b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f420c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f421d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @p0
    public AudioAttributes f422e;

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f423a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f424b = 0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f425c = 1;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f426d = 1;

        public d a() {
            return new d(this.f423a, this.f424b, this.f425c, this.f426d);
        }

        public b b(int i10) {
            this.f426d = i10;
            return this;
        }

        public b c(int i10) {
            this.f423a = i10;
            return this;
        }

        public b d(int i10) {
            this.f424b = i10;
            return this;
        }

        public b e(int i10) {
            this.f425c = i10;
            return this;
        }
    }

    @v0(21)
    public AudioAttributes a() {
        if (this.f422e == null) {
            AudioAttributes.Builder usage = new AudioAttributes.Builder().setContentType(this.f418a).setFlags(this.f419b).setUsage(this.f420c);
            if (u0.f31154a >= 29) {
                usage.setAllowedCapturePolicy(this.f421d);
            }
            this.f422e = usage.build();
        }
        return this.f422e;
    }

    public boolean equals(@p0 Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || d.class != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        return this.f418a == dVar.f418a && this.f419b == dVar.f419b && this.f420c == dVar.f420c && this.f421d == dVar.f421d;
    }

    public int hashCode() {
        return ((((((527 + this.f418a) * 31) + this.f419b) * 31) + this.f420c) * 31) + this.f421d;
    }

    public d(int i10, int i11, int i12, int i13) {
        this.f418a = i10;
        this.f419b = i11;
        this.f420c = i12;
        this.f421d = i13;
    }
}
