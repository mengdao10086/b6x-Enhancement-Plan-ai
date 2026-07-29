package s0;

import android.location.GnssStatus;
import android.os.Build;
import androidx.annotation.RestrictTo;
import g.v0;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
@v0(24)
public class b extends s0.a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final GnssStatus f49283i;

    @v0(26)
    public static class a {
        @g.u
        public static float a(GnssStatus gnssStatus, int i10) {
            return gnssStatus.getCarrierFrequencyHz(i10);
        }

        @g.u
        public static boolean b(GnssStatus gnssStatus, int i10) {
            return gnssStatus.hasCarrierFrequencyHz(i10);
        }
    }

    /* JADX INFO: renamed from: s0.b$b, reason: collision with other inner class name */
    @v0(30)
    public static class C0564b {
        @g.u
        public static float a(GnssStatus gnssStatus, int i10) {
            return gnssStatus.getBasebandCn0DbHz(i10);
        }

        @g.u
        public static boolean b(GnssStatus gnssStatus, int i10) {
            return gnssStatus.hasBasebandCn0DbHz(i10);
        }
    }

    public b(Object obj) {
        this.f49283i = (GnssStatus) androidx.core.util.o.l((GnssStatus) obj);
    }

    @Override // s0.a
    public float a(int i10) {
        return this.f49283i.getAzimuthDegrees(i10);
    }

    @Override // s0.a
    public float b(int i10) {
        if (Build.VERSION.SDK_INT >= 30) {
            return C0564b.a(this.f49283i, i10);
        }
        throw new UnsupportedOperationException();
    }

    @Override // s0.a
    public float c(int i10) {
        if (Build.VERSION.SDK_INT >= 26) {
            return a.a(this.f49283i, i10);
        }
        throw new UnsupportedOperationException();
    }

    @Override // s0.a
    public float d(int i10) {
        return this.f49283i.getCn0DbHz(i10);
    }

    @Override // s0.a
    public int e(int i10) {
        return this.f49283i.getConstellationType(i10);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof b) {
            return this.f49283i.equals(((b) obj).f49283i);
        }
        return false;
    }

    @Override // s0.a
    public float f(int i10) {
        return this.f49283i.getElevationDegrees(i10);
    }

    @Override // s0.a
    public int g() {
        return this.f49283i.getSatelliteCount();
    }

    @Override // s0.a
    public int h(int i10) {
        return this.f49283i.getSvid(i10);
    }

    public int hashCode() {
        return this.f49283i.hashCode();
    }

    @Override // s0.a
    public boolean i(int i10) {
        return this.f49283i.hasAlmanacData(i10);
    }

    @Override // s0.a
    public boolean j(int i10) {
        if (Build.VERSION.SDK_INT >= 30) {
            return C0564b.b(this.f49283i, i10);
        }
        return false;
    }

    @Override // s0.a
    public boolean k(int i10) {
        if (Build.VERSION.SDK_INT >= 26) {
            return a.b(this.f49283i, i10);
        }
        return false;
    }

    @Override // s0.a
    public boolean l(int i10) {
        return this.f49283i.hasEphemerisData(i10);
    }

    @Override // s0.a
    public boolean m(int i10) {
        return this.f49283i.usedInFix(i10);
    }
}
