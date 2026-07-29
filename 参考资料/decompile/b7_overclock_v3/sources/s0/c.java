package s0;

import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.os.Build;
import androidx.annotation.RestrictTo;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class c extends a {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f49287n = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f49288o = 32;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f49289p = 33;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f49290q = 64;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f49291r = -87;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f49292s = 64;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f49293t = 24;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f49294u = 193;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f49295v = 200;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f49296w = 200;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f49297x = 35;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final GpsStatus f49298i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @g.b0("mWrapped")
    public int f49299j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @g.b0("mWrapped")
    public Iterator<GpsSatellite> f49300k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @g.b0("mWrapped")
    public int f49301l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @g.b0("mWrapped")
    public GpsSatellite f49302m;

    public c(GpsStatus gpsStatus) {
        GpsStatus gpsStatus2 = (GpsStatus) androidx.core.util.o.l(gpsStatus);
        this.f49298i = gpsStatus2;
        this.f49299j = -1;
        this.f49300k = gpsStatus2.getSatellites().iterator();
        this.f49301l = -1;
        this.f49302m = null;
    }

    public static int p(int i10) {
        if (i10 > 0 && i10 <= 32) {
            return 1;
        }
        if (i10 >= 33 && i10 <= 64) {
            return 2;
        }
        if (i10 > 64 && i10 <= 88) {
            return 3;
        }
        if (i10 <= 200 || i10 > 235) {
            return (i10 < 193 || i10 > 200) ? 0 : 4;
        }
        return 5;
    }

    public static int r(int i10) {
        int iP = p(i10);
        return iP != 2 ? iP != 3 ? iP != 5 ? i10 : i10 - 200 : i10 - 64 : i10 + 87;
    }

    @Override // s0.a
    public float a(int i10) {
        return q(i10).getAzimuth();
    }

    @Override // s0.a
    public float b(int i10) {
        throw new UnsupportedOperationException();
    }

    @Override // s0.a
    public float c(int i10) {
        throw new UnsupportedOperationException();
    }

    @Override // s0.a
    public float d(int i10) {
        return q(i10).getSnr();
    }

    @Override // s0.a
    public int e(int i10) {
        if (Build.VERSION.SDK_INT < 24) {
            return 1;
        }
        return p(q(i10).getPrn());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof c) {
            return this.f49298i.equals(((c) obj).f49298i);
        }
        return false;
    }

    @Override // s0.a
    public float f(int i10) {
        return q(i10).getElevation();
    }

    @Override // s0.a
    public int g() {
        int i10;
        synchronized (this.f49298i) {
            if (this.f49299j == -1) {
                for (GpsSatellite gpsSatellite : this.f49298i.getSatellites()) {
                    this.f49299j++;
                }
                this.f49299j++;
            }
            i10 = this.f49299j;
        }
        return i10;
    }

    @Override // s0.a
    public int h(int i10) {
        return Build.VERSION.SDK_INT < 24 ? q(i10).getPrn() : r(q(i10).getPrn());
    }

    public int hashCode() {
        return this.f49298i.hashCode();
    }

    @Override // s0.a
    public boolean i(int i10) {
        return q(i10).hasAlmanac();
    }

    @Override // s0.a
    public boolean j(int i10) {
        return false;
    }

    @Override // s0.a
    public boolean k(int i10) {
        return false;
    }

    @Override // s0.a
    public boolean l(int i10) {
        return q(i10).hasEphemeris();
    }

    @Override // s0.a
    public boolean m(int i10) {
        return q(i10).usedInFix();
    }

    public final GpsSatellite q(int i10) {
        GpsSatellite gpsSatellite;
        synchronized (this.f49298i) {
            if (i10 < this.f49301l) {
                this.f49300k = this.f49298i.getSatellites().iterator();
                this.f49301l = -1;
            }
            while (true) {
                int i11 = this.f49301l;
                if (i11 >= i10) {
                    break;
                }
                this.f49301l = i11 + 1;
                if (!this.f49300k.hasNext()) {
                    this.f49302m = null;
                    break;
                }
                this.f49302m = this.f49300k.next();
            }
            gpsSatellite = this.f49302m;
        }
        return (GpsSatellite) androidx.core.util.o.l(gpsSatellite);
    }
}
