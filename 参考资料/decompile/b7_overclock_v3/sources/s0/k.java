package s0;

import android.annotation.SuppressLint;
import android.location.GnssMeasurementsEvent;
import android.location.GnssStatus;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationRequest;
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.core.os.f;
import g.n0;
import g.p0;
import g.v0;
import g.y0;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.WeakHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.function.Consumer;
import s0.a;

/* JADX INFO: loaded from: classes2.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f49340a = 30000;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long f49341b = 10000;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final long f49342c = 5;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Field f49343d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Class<?> f49344e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Method f49345f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static Method f49346g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @g.b0("sLocationListeners")
    public static final WeakHashMap<C0565k, WeakReference<l>> f49347h = new WeakHashMap<>();

    @v0(19)
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static Class<?> f49348a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static Method f49349b;

        @g.u
        public static boolean a(LocationManager locationManager, String str, c0 c0Var, s0.g gVar, Looper looper) {
            try {
                if (f49348a == null) {
                    f49348a = Class.forName("android.location.LocationRequest");
                }
                if (f49349b == null) {
                    Method declaredMethod = LocationManager.class.getDeclaredMethod("requestLocationUpdates", f49348a, LocationListener.class, Looper.class);
                    f49349b = declaredMethod;
                    declaredMethod.setAccessible(true);
                }
                LocationRequest locationRequestI = c0Var.i(str);
                if (locationRequestI != null) {
                    f49349b.invoke(locationManager, locationRequestI, gVar, looper);
                    return true;
                }
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | UnsupportedOperationException | InvocationTargetException unused) {
            }
            return false;
        }

        @g.u
        @y0(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
        public static boolean b(LocationManager locationManager, String str, c0 c0Var, l lVar) {
            try {
                if (f49348a == null) {
                    f49348a = Class.forName("android.location.LocationRequest");
                }
                if (f49349b == null) {
                    Method declaredMethod = LocationManager.class.getDeclaredMethod("requestLocationUpdates", f49348a, LocationListener.class, Looper.class);
                    f49349b = declaredMethod;
                    declaredMethod.setAccessible(true);
                }
                LocationRequest locationRequestI = c0Var.i(str);
                if (locationRequestI != null) {
                    synchronized (k.f49347h) {
                        f49349b.invoke(locationManager, locationRequestI, lVar, Looper.getMainLooper());
                        k.p(locationManager, lVar);
                    }
                    return true;
                }
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | UnsupportedOperationException | InvocationTargetException unused) {
            }
            return false;
        }
    }

    @v0(24)
    public static class b {
        @g.u
        @y0("android.permission.ACCESS_FINE_LOCATION")
        public static boolean a(@n0 LocationManager locationManager, @n0 GnssMeasurementsEvent.Callback callback, @n0 Handler handler) {
            return locationManager.registerGnssMeasurementsCallback(callback, handler);
        }

        @g.u
        @y0(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
        public static boolean b(LocationManager locationManager, Handler handler, Executor executor, a.AbstractC0563a abstractC0563a) {
            androidx.core.util.o.a(handler != null);
            androidx.collection.l<Object, Object> lVar = g.f49358a;
            synchronized (lVar) {
                m mVar = (m) lVar.get(abstractC0563a);
                if (mVar == null) {
                    mVar = new m(abstractC0563a);
                } else {
                    mVar.j();
                }
                mVar.i(executor);
                if (!locationManager.registerGnssStatusCallback(mVar, handler)) {
                    return false;
                }
                lVar.put(abstractC0563a, mVar);
                return true;
            }
        }

        @g.u
        public static void c(@n0 LocationManager locationManager, @n0 GnssMeasurementsEvent.Callback callback) {
            locationManager.unregisterGnssMeasurementsCallback(callback);
        }

        @g.u
        public static void d(LocationManager locationManager, Object obj) {
            if (obj instanceof m) {
                ((m) obj).j();
            }
            locationManager.unregisterGnssStatusCallback((GnssStatus.Callback) obj);
        }
    }

    @v0(28)
    public static class c {
        @g.u
        public static String a(LocationManager locationManager) {
            return locationManager.getGnssHardwareModelName();
        }

        @g.u
        public static int b(LocationManager locationManager) {
            return locationManager.getGnssYearOfHardware();
        }

        @g.u
        public static boolean c(LocationManager locationManager) {
            return locationManager.isLocationEnabled();
        }
    }

    @v0(30)
    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static Class<?> f49350a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static Method f49351b;

        @g.u
        @y0(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
        public static void a(LocationManager locationManager, @n0 String str, @p0 androidx.core.os.f fVar, @n0 Executor executor, @n0 final androidx.core.util.d<Location> dVar) {
            CancellationSignal cancellationSignal = fVar != null ? (CancellationSignal) fVar.b() : null;
            Objects.requireNonNull(dVar);
            locationManager.getCurrentLocation(str, cancellationSignal, executor, new Consumer() { // from class: s0.l
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    dVar.accept((Location) obj);
                }
            });
        }

        @g.u
        @y0(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
        public static boolean b(LocationManager locationManager, Handler handler, Executor executor, a.AbstractC0563a abstractC0563a) {
            androidx.collection.l<Object, Object> lVar = g.f49358a;
            synchronized (lVar) {
                h hVar = (h) lVar.get(abstractC0563a);
                if (hVar == null) {
                    hVar = new h(abstractC0563a);
                }
                if (!locationManager.registerGnssStatusCallback(executor, hVar)) {
                    return false;
                }
                lVar.put(abstractC0563a, hVar);
                return true;
            }
        }

        @g.u
        public static boolean c(LocationManager locationManager, String str, c0 c0Var, Executor executor, s0.g gVar) {
            if (Build.VERSION.SDK_INT >= 30) {
                try {
                    if (f49350a == null) {
                        f49350a = Class.forName("android.location.LocationRequest");
                    }
                    if (f49351b == null) {
                        Method declaredMethod = LocationManager.class.getDeclaredMethod("requestLocationUpdates", f49350a, Executor.class, LocationListener.class);
                        f49351b = declaredMethod;
                        declaredMethod.setAccessible(true);
                    }
                    LocationRequest locationRequestI = c0Var.i(str);
                    if (locationRequestI != null) {
                        f49351b.invoke(locationManager, locationRequestI, executor, gVar);
                        return true;
                    }
                } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | UnsupportedOperationException | InvocationTargetException unused) {
                }
            }
            return false;
        }
    }

    @v0(31)
    public static class e {
        @g.u
        public static boolean a(LocationManager locationManager, @n0 String str) {
            return locationManager.hasProvider(str);
        }

        @g.u
        @y0("android.permission.ACCESS_FINE_LOCATION")
        public static boolean b(@n0 LocationManager locationManager, @n0 Executor executor, @n0 GnssMeasurementsEvent.Callback callback) {
            return locationManager.registerGnssMeasurementsCallback(executor, callback);
        }

        @g.u
        @y0(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
        public static void c(LocationManager locationManager, @n0 String str, @n0 LocationRequest locationRequest, @n0 Executor executor, @n0 LocationListener locationListener) {
            locationManager.requestLocationUpdates(str, locationRequest, executor, locationListener);
        }
    }

    public static final class f implements LocationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final LocationManager f49352a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Executor f49353b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Handler f49354c = new Handler(Looper.getMainLooper());

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public androidx.core.util.d<Location> f49355d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @g.b0("this")
        public boolean f49356e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @p0
        public Runnable f49357f;

        public f(LocationManager locationManager, Executor executor, androidx.core.util.d<Location> dVar) {
            this.f49352a = locationManager;
            this.f49353b = executor;
            this.f49355d = dVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void f() {
            this.f49357f = null;
            onLocationChanged((Location) null);
        }

        @y0(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
        public void c() {
            synchronized (this) {
                if (this.f49356e) {
                    return;
                }
                this.f49356e = true;
                d();
            }
        }

        @y0(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
        public final void d() {
            this.f49355d = null;
            this.f49352a.removeUpdates(this);
            Runnable runnable = this.f49357f;
            if (runnable != null) {
                this.f49354c.removeCallbacks(runnable);
                this.f49357f = null;
            }
        }

        @SuppressLint({"MissingPermission"})
        public void g(long j10) {
            synchronized (this) {
                if (this.f49356e) {
                    return;
                }
                Runnable runnable = new Runnable() { // from class: s0.n
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f49373a.f();
                    }
                };
                this.f49357f = runnable;
                this.f49354c.postDelayed(runnable, j10);
            }
        }

        @Override // android.location.LocationListener
        @y0(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
        public void onLocationChanged(@p0 final Location location) {
            synchronized (this) {
                if (this.f49356e) {
                    return;
                }
                this.f49356e = true;
                final androidx.core.util.d<Location> dVar = this.f49355d;
                this.f49353b.execute(new Runnable() { // from class: s0.m
                    @Override // java.lang.Runnable
                    public final void run() {
                        dVar.accept(location);
                    }
                });
                d();
            }
        }

        @Override // android.location.LocationListener
        @y0(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
        public void onProviderDisabled(@n0 String str) {
            onLocationChanged((Location) null);
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(@n0 String str) {
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i10, Bundle bundle) {
        }
    }

    public static class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @g.b0("sGnssStatusListeners")
        public static final androidx.collection.l<Object, Object> f49358a = new androidx.collection.l<>();
    }

    @v0(30)
    public static class h extends GnssStatus.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a.AbstractC0563a f49359a;

        public h(a.AbstractC0563a abstractC0563a) {
            androidx.core.util.o.b(abstractC0563a != null, "invalid null callback");
            this.f49359a = abstractC0563a;
        }

        @Override // android.location.GnssStatus.Callback
        public void onFirstFix(int i10) {
            this.f49359a.a(i10);
        }

        @Override // android.location.GnssStatus.Callback
        public void onSatelliteStatusChanged(GnssStatus gnssStatus) {
            this.f49359a.b(s0.a.n(gnssStatus));
        }

        @Override // android.location.GnssStatus.Callback
        public void onStarted() {
            this.f49359a.c();
        }

        @Override // android.location.GnssStatus.Callback
        public void onStopped() {
            this.f49359a.d();
        }
    }

    public static class i implements GpsStatus.Listener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final LocationManager f49360a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final a.AbstractC0563a f49361b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @p0
        public volatile Executor f49362c;

        public i(LocationManager locationManager, a.AbstractC0563a abstractC0563a) {
            androidx.core.util.o.b(abstractC0563a != null, "invalid null callback");
            this.f49360a = locationManager;
            this.f49361b = abstractC0563a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e(Executor executor) {
            if (this.f49362c != executor) {
                return;
            }
            this.f49361b.c();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void f(Executor executor) {
            if (this.f49362c != executor) {
                return;
            }
            this.f49361b.d();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void g(Executor executor, int i10) {
            if (this.f49362c != executor) {
                return;
            }
            this.f49361b.a(i10);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void h(Executor executor, s0.a aVar) {
            if (this.f49362c != executor) {
                return;
            }
            this.f49361b.b(aVar);
        }

        public void i(Executor executor) {
            androidx.core.util.o.n(this.f49362c == null);
            this.f49362c = executor;
        }

        public void j() {
            this.f49362c = null;
        }

        @Override // android.location.GpsStatus.Listener
        @y0("android.permission.ACCESS_FINE_LOCATION")
        public void onGpsStatusChanged(int i10) {
            GpsStatus gpsStatus;
            final Executor executor = this.f49362c;
            if (executor == null) {
                return;
            }
            if (i10 == 1) {
                executor.execute(new Runnable() { // from class: s0.o
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f49374a.e(executor);
                    }
                });
                return;
            }
            if (i10 == 2) {
                executor.execute(new Runnable() { // from class: s0.p
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f49376a.f(executor);
                    }
                });
                return;
            }
            if (i10 != 3) {
                if (i10 == 4 && (gpsStatus = this.f49360a.getGpsStatus(null)) != null) {
                    final s0.a aVarO = s0.a.o(gpsStatus);
                    executor.execute(new Runnable() { // from class: s0.r
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f49381a.h(executor, aVarO);
                        }
                    });
                    return;
                }
                return;
            }
            GpsStatus gpsStatus2 = this.f49360a.getGpsStatus(null);
            if (gpsStatus2 != null) {
                final int timeToFirstFix = gpsStatus2.getTimeToFirstFix();
                executor.execute(new Runnable() { // from class: s0.q
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f49378a.g(executor, timeToFirstFix);
                    }
                });
            }
        }
    }

    public static final class j implements Executor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Handler f49363a;

        public j(@n0 Handler handler) {
            this.f49363a = (Handler) androidx.core.util.o.l(handler);
        }

        @Override // java.util.concurrent.Executor
        public void execute(@n0 Runnable runnable) {
            if (Looper.myLooper() == this.f49363a.getLooper()) {
                runnable.run();
            } else {
                if (this.f49363a.post((Runnable) androidx.core.util.o.l(runnable))) {
                    return;
                }
                throw new RejectedExecutionException(this.f49363a + " is shutting down");
            }
        }
    }

    /* JADX INFO: renamed from: s0.k$k, reason: collision with other inner class name */
    public static class C0565k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f49364a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final s0.g f49365b;

        public C0565k(String str, s0.g gVar) {
            this.f49364a = (String) androidx.core.util.j.e(str, "invalid null provider");
            this.f49365b = (s0.g) androidx.core.util.j.e(gVar, "invalid null listener");
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C0565k)) {
                return false;
            }
            C0565k c0565k = (C0565k) obj;
            return this.f49364a.equals(c0565k.f49364a) && this.f49365b.equals(c0565k.f49365b);
        }

        public int hashCode() {
            return androidx.core.util.j.b(this.f49364a, this.f49365b);
        }
    }

    @v0(24)
    public static class m extends GnssStatus.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a.AbstractC0563a f49368a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @p0
        public volatile Executor f49369b;

        public m(a.AbstractC0563a abstractC0563a) {
            androidx.core.util.o.b(abstractC0563a != null, "invalid null callback");
            this.f49368a = abstractC0563a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e(Executor executor, int i10) {
            if (this.f49369b != executor) {
                return;
            }
            this.f49368a.a(i10);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void f(Executor executor, GnssStatus gnssStatus) {
            if (this.f49369b != executor) {
                return;
            }
            this.f49368a.b(s0.a.n(gnssStatus));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void g(Executor executor) {
            if (this.f49369b != executor) {
                return;
            }
            this.f49368a.c();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void h(Executor executor) {
            if (this.f49369b != executor) {
                return;
            }
            this.f49368a.d();
        }

        public void i(Executor executor) {
            androidx.core.util.o.b(executor != null, "invalid null executor");
            androidx.core.util.o.n(this.f49369b == null);
            this.f49369b = executor;
        }

        public void j() {
            this.f49369b = null;
        }

        @Override // android.location.GnssStatus.Callback
        public void onFirstFix(final int i10) {
            final Executor executor = this.f49369b;
            if (executor == null) {
                return;
            }
            executor.execute(new Runnable() { // from class: s0.a0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f49280a.e(executor, i10);
                }
            });
        }

        @Override // android.location.GnssStatus.Callback
        public void onSatelliteStatusChanged(final GnssStatus gnssStatus) {
            final Executor executor = this.f49369b;
            if (executor == null) {
                return;
            }
            executor.execute(new Runnable() { // from class: s0.b0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f49284a.f(executor, gnssStatus);
                }
            });
        }

        @Override // android.location.GnssStatus.Callback
        public void onStarted() {
            final Executor executor = this.f49369b;
            if (executor == null) {
                return;
            }
            executor.execute(new Runnable() { // from class: s0.z
                @Override // java.lang.Runnable
                public final void run() {
                    this.f49400a.g(executor);
                }
            });
        }

        @Override // android.location.GnssStatus.Callback
        public void onStopped() {
            final Executor executor = this.f49369b;
            if (executor == null) {
                return;
            }
            executor.execute(new Runnable() { // from class: s0.y
                @Override // java.lang.Runnable
                public final void run() {
                    this.f49398a.h(executor);
                }
            });
        }
    }

    @y0(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    public static void c(@n0 LocationManager locationManager, @n0 String str, @p0 androidx.core.os.f fVar, @n0 Executor executor, @n0 final androidx.core.util.d<Location> dVar) {
        if (Build.VERSION.SDK_INT >= 30) {
            d.a(locationManager, str, fVar, executor, dVar);
            return;
        }
        if (fVar != null) {
            fVar.e();
        }
        final Location lastKnownLocation = locationManager.getLastKnownLocation(str);
        if (lastKnownLocation != null && SystemClock.elapsedRealtime() - s0.d.c(lastKnownLocation) < 10000) {
            executor.execute(new Runnable() { // from class: s0.i
                @Override // java.lang.Runnable
                public final void run() {
                    dVar.accept(lastKnownLocation);
                }
            });
            return;
        }
        final f fVar2 = new f(locationManager, executor, dVar);
        locationManager.requestLocationUpdates(str, 0L, 0.0f, fVar2, Looper.getMainLooper());
        if (fVar != null) {
            fVar.d(new f.b() { // from class: s0.h
                @Override // androidx.core.os.f.b
                public final void onCancel() {
                    fVar2.c();
                }
            });
        }
        fVar2.g(30000L);
    }

    @p0
    public static String d(@n0 LocationManager locationManager) {
        if (Build.VERSION.SDK_INT >= 28) {
            return c.a(locationManager);
        }
        return null;
    }

    public static int e(@n0 LocationManager locationManager) {
        if (Build.VERSION.SDK_INT >= 28) {
            return c.b(locationManager);
        }
        return 0;
    }

    public static boolean f(@n0 LocationManager locationManager, @n0 String str) {
        if (Build.VERSION.SDK_INT >= 31) {
            return e.a(locationManager, str);
        }
        if (locationManager.getAllProviders().contains(str)) {
            return true;
        }
        try {
            return locationManager.getProvider(str) != null;
        } catch (SecurityException unused) {
            return false;
        }
    }

    public static boolean g(@n0 LocationManager locationManager) {
        return Build.VERSION.SDK_INT >= 28 ? c.c(locationManager) : locationManager.isProviderEnabled("network") || locationManager.isProviderEnabled("gps");
    }

    public static /* synthetic */ Boolean i(LocationManager locationManager, i iVar) throws Exception {
        return Boolean.valueOf(locationManager.addGpsStatusListener(iVar));
    }

    @y0("android.permission.ACCESS_FINE_LOCATION")
    @v0(24)
    public static boolean j(@n0 LocationManager locationManager, @n0 GnssMeasurementsEvent.Callback callback, @n0 Handler handler) {
        return Build.VERSION.SDK_INT != 30 ? b.a(locationManager, callback, handler) : l(locationManager, androidx.core.os.i.a(handler), callback);
    }

    @y0("android.permission.ACCESS_FINE_LOCATION")
    @v0(30)
    public static boolean k(@n0 LocationManager locationManager, @n0 Executor executor, @n0 GnssMeasurementsEvent.Callback callback) {
        return Build.VERSION.SDK_INT > 30 ? e.b(locationManager, executor, callback) : l(locationManager, executor, callback);
    }

    @v0(30)
    public static boolean l(@n0 LocationManager locationManager, @n0 Executor executor, @n0 GnssMeasurementsEvent.Callback callback) {
        if (Build.VERSION.SDK_INT != 30) {
            throw new IllegalStateException();
        }
        try {
            if (f49344e == null) {
                f49344e = Class.forName("android.location.GnssRequest$Builder");
            }
            if (f49345f == null) {
                Method declaredMethod = f49344e.getDeclaredMethod("build", new Class[0]);
                f49345f = declaredMethod;
                declaredMethod.setAccessible(true);
            }
            if (f49346g == null) {
                Method declaredMethod2 = LocationManager.class.getDeclaredMethod("registerGnssMeasurementsCallback", Class.forName("android.location.GnssRequest"), Executor.class, GnssMeasurementsEvent.Callback.class);
                f49346g = declaredMethod2;
                declaredMethod2.setAccessible(true);
            }
            Object objInvoke = f49346g.invoke(locationManager, f49345f.invoke(f49344e.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]), new Object[0]), executor, callback);
            if (objInvoke != null) {
                return ((Boolean) objInvoke).booleanValue();
            }
            return false;
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException unused) {
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x00c5 A[Catch: all -> 0x00e1, TryCatch #0 {all -> 0x00e1, blocks: (B:54:0x00a4, B:55:0x00ba, B:58:0x00bd, B:60:0x00c5, B:62:0x00cd, B:63:0x00d3, B:64:0x00d4, B:65:0x00d9, B:66:0x00da, B:67:0x00e0, B:44:0x0093), top: B:77:0x0053 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00da A[Catch: all -> 0x00e1, TryCatch #0 {all -> 0x00e1, blocks: (B:54:0x00a4, B:55:0x00ba, B:58:0x00bd, B:60:0x00c5, B:62:0x00cd, B:63:0x00d3, B:64:0x00d4, B:65:0x00d9, B:66:0x00da, B:67:0x00e0, B:44:0x0093), top: B:77:0x0053 }] */
    @g.y0("android.permission.ACCESS_FINE_LOCATION")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean m(final android.location.LocationManager r9, android.os.Handler r10, java.util.concurrent.Executor r11, s0.a.AbstractC0563a r12) {
        /*
            Method dump skipped, instruction units count: 262
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: s0.k.m(android.location.LocationManager, android.os.Handler, java.util.concurrent.Executor, s0.a$a):boolean");
    }

    @y0("android.permission.ACCESS_FINE_LOCATION")
    public static boolean n(@n0 LocationManager locationManager, @n0 Executor executor, @n0 a.AbstractC0563a abstractC0563a) {
        if (Build.VERSION.SDK_INT >= 30) {
            return m(locationManager, null, executor, abstractC0563a);
        }
        Looper looperMyLooper = Looper.myLooper();
        if (looperMyLooper == null) {
            looperMyLooper = Looper.getMainLooper();
        }
        return m(locationManager, new Handler(looperMyLooper), executor, abstractC0563a);
    }

    @y0("android.permission.ACCESS_FINE_LOCATION")
    public static boolean o(@n0 LocationManager locationManager, @n0 a.AbstractC0563a abstractC0563a, @n0 Handler handler) {
        return Build.VERSION.SDK_INT >= 30 ? n(locationManager, androidx.core.os.i.a(handler), abstractC0563a) : n(locationManager, new j(handler), abstractC0563a);
    }

    @y0(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    @g.b0("sLocationListeners")
    public static void p(LocationManager locationManager, l lVar) {
        WeakReference<l> weakReferencePut = f49347h.put(lVar.g(), new WeakReference<>(lVar));
        l lVar2 = weakReferencePut != null ? weakReferencePut.get() : null;
        if (lVar2 != null) {
            lVar2.n();
            locationManager.removeUpdates(lVar2);
        }
    }

    @y0(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    public static void q(@n0 LocationManager locationManager, @n0 s0.g gVar) {
        WeakHashMap<C0565k, WeakReference<l>> weakHashMap = f49347h;
        synchronized (weakHashMap) {
            ArrayList arrayList = null;
            Iterator<WeakReference<l>> it2 = weakHashMap.values().iterator();
            while (it2.hasNext()) {
                l lVar = it2.next().get();
                if (lVar != null) {
                    C0565k c0565kG = lVar.g();
                    if (c0565kG.f49365b == gVar) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(c0565kG);
                        lVar.n();
                        locationManager.removeUpdates(lVar);
                    }
                }
            }
            if (arrayList != null) {
                Iterator it3 = arrayList.iterator();
                while (it3.hasNext()) {
                    f49347h.remove((C0565k) it3.next());
                }
            }
        }
        locationManager.removeUpdates(gVar);
    }

    @y0(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    public static void r(@n0 LocationManager locationManager, @n0 String str, @n0 c0 c0Var, @n0 Executor executor, @n0 s0.g gVar) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 31) {
            e.c(locationManager, str, c0Var.h(), executor, gVar);
            return;
        }
        if (i10 < 30 || !d.c(locationManager, str, c0Var, executor, gVar)) {
            l lVar = new l(new C0565k(str, gVar), executor);
            if (a.b(locationManager, str, c0Var, lVar)) {
                return;
            }
            synchronized (f49347h) {
                locationManager.requestLocationUpdates(str, c0Var.b(), c0Var.e(), lVar, Looper.getMainLooper());
                p(locationManager, lVar);
            }
        }
    }

    @y0(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    public static void s(@n0 LocationManager locationManager, @n0 String str, @n0 c0 c0Var, @n0 s0.g gVar, @n0 Looper looper) {
        if (Build.VERSION.SDK_INT >= 31) {
            e.c(locationManager, str, c0Var.h(), androidx.core.os.i.a(new Handler(looper)), gVar);
        } else {
            if (a.a(locationManager, str, c0Var, gVar, looper)) {
                return;
            }
            locationManager.requestLocationUpdates(str, c0Var.b(), c0Var.e(), gVar, looper);
        }
    }

    @v0(24)
    public static void t(@n0 LocationManager locationManager, @n0 GnssMeasurementsEvent.Callback callback) {
        b.c(locationManager, callback);
    }

    public static void u(@n0 LocationManager locationManager, @n0 a.AbstractC0563a abstractC0563a) {
        if (Build.VERSION.SDK_INT >= 24) {
            androidx.collection.l<Object, Object> lVar = g.f49358a;
            synchronized (lVar) {
                Object objRemove = lVar.remove(abstractC0563a);
                if (objRemove != null) {
                    b.d(locationManager, objRemove);
                }
            }
            return;
        }
        androidx.collection.l<Object, Object> lVar2 = g.f49358a;
        synchronized (lVar2) {
            i iVar = (i) lVar2.remove(abstractC0563a);
            if (iVar != null) {
                iVar.j();
                locationManager.removeGpsStatusListener(iVar);
            }
        }
    }

    public static class l implements LocationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @p0
        public volatile C0565k f49366a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Executor f49367b;

        public l(@p0 C0565k c0565k, Executor executor) {
            this.f49366a = c0565k;
            this.f49367b = executor;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void h(int i10) {
            C0565k c0565k = this.f49366a;
            if (c0565k == null) {
                return;
            }
            c0565k.f49365b.onFlushComplete(i10);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void i(Location location) {
            C0565k c0565k = this.f49366a;
            if (c0565k == null) {
                return;
            }
            c0565k.f49365b.onLocationChanged(location);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void j(List list) {
            C0565k c0565k = this.f49366a;
            if (c0565k == null) {
                return;
            }
            c0565k.f49365b.onLocationChanged((List<Location>) list);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void k(String str) {
            C0565k c0565k = this.f49366a;
            if (c0565k == null) {
                return;
            }
            c0565k.f49365b.onProviderDisabled(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void l(String str) {
            C0565k c0565k = this.f49366a;
            if (c0565k == null) {
                return;
            }
            c0565k.f49365b.onProviderEnabled(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void m(String str, int i10, Bundle bundle) {
            C0565k c0565k = this.f49366a;
            if (c0565k == null) {
                return;
            }
            c0565k.f49365b.onStatusChanged(str, i10, bundle);
        }

        public C0565k g() {
            return (C0565k) androidx.core.util.j.d(this.f49366a);
        }

        public void n() {
            this.f49366a = null;
        }

        @Override // android.location.LocationListener
        public void onFlushComplete(final int i10) {
            if (this.f49366a == null) {
                return;
            }
            this.f49367b.execute(new Runnable() { // from class: s0.s
                @Override // java.lang.Runnable
                public final void run() {
                    this.f49384a.h(i10);
                }
            });
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(@n0 final Location location) {
            if (this.f49366a == null) {
                return;
            }
            this.f49367b.execute(new Runnable() { // from class: s0.t
                @Override // java.lang.Runnable
                public final void run() {
                    this.f49386a.i(location);
                }
            });
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(@n0 final String str) {
            if (this.f49366a == null) {
                return;
            }
            this.f49367b.execute(new Runnable() { // from class: s0.v
                @Override // java.lang.Runnable
                public final void run() {
                    this.f49390a.k(str);
                }
            });
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(@n0 final String str) {
            if (this.f49366a == null) {
                return;
            }
            this.f49367b.execute(new Runnable() { // from class: s0.u
                @Override // java.lang.Runnable
                public final void run() {
                    this.f49388a.l(str);
                }
            });
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(final String str, final int i10, final Bundle bundle) {
            if (this.f49366a == null) {
                return;
            }
            this.f49367b.execute(new Runnable() { // from class: s0.w
                @Override // java.lang.Runnable
                public final void run() {
                    this.f49392a.m(str, i10, bundle);
                }
            });
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(@n0 final List<Location> list) {
            if (this.f49366a == null) {
                return;
            }
            this.f49367b.execute(new Runnable() { // from class: s0.x
                @Override // java.lang.Runnable
                public final void run() {
                    this.f49396a.j(list);
                }
            });
        }
    }
}
