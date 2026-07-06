package a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;
import java.util.Calendar;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class k2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static k2 f6565a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final j2 f1597a = new j2();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f1598a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final LocationManager f1599a;

    public k2(Context context, LocationManager locationManager) {
        this.f1598a = context;
        this.f1599a = locationManager;
    }

    public static k2 a(Context context) {
        if (f6565a == null) {
            Context applicationContext = context.getApplicationContext();
            f6565a = new k2(applicationContext, (LocationManager) applicationContext.getSystemService("location"));
        }
        return f6565a;
    }

    @SuppressLint({"MissingPermission"})
    public final Location b() {
        Location locationC = ac.b(this.f1598a, "android.permission.ACCESS_COARSE_LOCATION") == 0 ? c("network") : null;
        Location locationC2 = ac.b(this.f1598a, "android.permission.ACCESS_FINE_LOCATION") == 0 ? c("gps") : null;
        return (locationC2 == null || locationC == null) ? locationC2 != null ? locationC2 : locationC : locationC2.getTime() > locationC.getTime() ? locationC2 : locationC;
    }

    public final Location c(String str) {
        try {
            if (this.f1599a.isProviderEnabled(str)) {
                return this.f1599a.getLastKnownLocation(str);
            }
            return null;
        } catch (Exception e) {
            Log.d("TwilightManager", "Failed to get last known location", e);
            return null;
        }
    }

    public boolean d() {
        j2 j2Var = this.f1597a;
        if (e()) {
            return j2Var.f1493a;
        }
        Location locationB = b();
        if (locationB != null) {
            f(locationB);
            return j2Var.f1493a;
        }
        Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
        int i = Calendar.getInstance().get(11);
        return i < 6 || i >= 22;
    }

    public final boolean e() {
        return this.f1597a.e > System.currentTimeMillis();
    }

    public final void f(Location location) {
        long j;
        j2 j2Var = this.f1597a;
        long jCurrentTimeMillis = System.currentTimeMillis();
        i2 i2VarB = i2.b();
        i2VarB.a(jCurrentTimeMillis - 86400000, location.getLatitude(), location.getLongitude());
        long j2 = i2VarB.f1304a;
        i2VarB.a(jCurrentTimeMillis, location.getLatitude(), location.getLongitude());
        boolean z = i2VarB.f1303a == 1;
        long j3 = i2VarB.b;
        long j4 = i2VarB.f1304a;
        i2VarB.a(86400000 + jCurrentTimeMillis, location.getLatitude(), location.getLongitude());
        long j5 = i2VarB.b;
        if (j3 == -1 || j4 == -1) {
            j = 43200000 + jCurrentTimeMillis;
        } else {
            j = (jCurrentTimeMillis > j4 ? 0 + j5 : jCurrentTimeMillis > j3 ? 0 + j4 : 0 + j3) + 60000;
        }
        j2Var.f1493a = z;
        j2Var.f6464a = j2;
        j2Var.b = j3;
        j2Var.c = j4;
        j2Var.d = j5;
        j2Var.e = j;
    }
}
