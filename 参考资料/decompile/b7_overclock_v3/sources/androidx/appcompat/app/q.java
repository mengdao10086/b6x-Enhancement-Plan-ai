package androidx.appcompat.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import com.umeng.socialize.common.SocializeConstants;
import g.i1;
import g.n0;
import g.y0;
import h0.i0;
import java.util.Calendar;

/* JADX INFO: loaded from: classes2.dex */
public class q {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f1707d = "TwilightManager";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f1708e = 6;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f1709f = 22;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static q f1710g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f1711a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LocationManager f1712b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f1713c = new a();

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f1714a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f1715b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f1716c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f1717d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f1718e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f1719f;
    }

    @i1
    public q(@n0 Context context, @n0 LocationManager locationManager) {
        this.f1711a = context;
        this.f1712b = locationManager;
    }

    public static q a(@n0 Context context) {
        if (f1710g == null) {
            Context applicationContext = context.getApplicationContext();
            f1710g = new q(applicationContext, (LocationManager) applicationContext.getSystemService(SocializeConstants.KEY_LOCATION));
        }
        return f1710g;
    }

    @i1
    public static void f(q qVar) {
        f1710g = qVar;
    }

    @SuppressLint({"MissingPermission"})
    public final Location b() {
        Location locationC = i0.d(this.f1711a, "android.permission.ACCESS_COARSE_LOCATION") == 0 ? c("network") : null;
        Location locationC2 = i0.d(this.f1711a, "android.permission.ACCESS_FINE_LOCATION") == 0 ? c("gps") : null;
        return (locationC2 == null || locationC == null) ? locationC2 != null ? locationC2 : locationC : locationC2.getTime() > locationC.getTime() ? locationC2 : locationC;
    }

    @y0(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    public final Location c(String str) {
        try {
            if (this.f1712b.isProviderEnabled(str)) {
                return this.f1712b.getLastKnownLocation(str);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public boolean d() {
        a aVar = this.f1713c;
        if (e()) {
            return aVar.f1714a;
        }
        Location locationB = b();
        if (locationB != null) {
            g(locationB);
            return aVar.f1714a;
        }
        int i10 = Calendar.getInstance().get(11);
        return i10 < 6 || i10 >= 22;
    }

    public final boolean e() {
        return this.f1713c.f1719f > System.currentTimeMillis();
    }

    public final void g(@n0 Location location) {
        long j10;
        a aVar = this.f1713c;
        long jCurrentTimeMillis = System.currentTimeMillis();
        p pVarB = p.b();
        pVarB.a(jCurrentTimeMillis - 86400000, location.getLatitude(), location.getLongitude());
        long j11 = pVarB.f1704a;
        pVarB.a(jCurrentTimeMillis, location.getLatitude(), location.getLongitude());
        boolean z10 = pVarB.f1706c == 1;
        long j12 = pVarB.f1705b;
        long j13 = pVarB.f1704a;
        boolean z11 = z10;
        pVarB.a(86400000 + jCurrentTimeMillis, location.getLatitude(), location.getLongitude());
        long j14 = pVarB.f1705b;
        if (j12 == -1 || j13 == -1) {
            j10 = 43200000 + jCurrentTimeMillis;
        } else {
            j10 = (jCurrentTimeMillis > j13 ? 0 + j14 : jCurrentTimeMillis > j12 ? 0 + j13 : 0 + j12) + 60000;
        }
        aVar.f1714a = z11;
        aVar.f1715b = j11;
        aVar.f1716c = j12;
        aVar.f1717d = j13;
        aVar.f1718e = j14;
        aVar.f1719f = j10;
    }
}
