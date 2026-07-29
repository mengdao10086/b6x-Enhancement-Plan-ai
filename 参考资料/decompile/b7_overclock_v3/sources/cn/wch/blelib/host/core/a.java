package cn.wch.blelib.host.core;

import android.bluetooth.BluetoothManager;
import android.content.Context;
import cn.wch.blelib.exception.BLELibException;
import com.flydigi.action.FirmwareUpgradeStatisticsLog;
import g.n0;
import java.util.HashMap;
import m9.s;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static a f11047c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static BluetoothManager f11048d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f11049a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f11050b;

    public a(Context context) {
        this.f11050b = b.k(context);
    }

    public static a g(Context context) {
        if (f11047c == null) {
            synchronized (a.class) {
                f11047c = new a(context);
            }
        }
        return f11047c;
    }

    public synchronized void a(@n0 c cVar, @n0 z2.a aVar) throws BLELibException {
        this.f11050b.d(cVar, aVar);
    }

    public synchronized void b(@n0 String str) throws BLELibException {
        this.f11050b.f(str);
    }

    public synchronized void c() {
        this.f11050b.g();
    }

    public synchronized void d(@n0 String str) throws BLELibException {
        this.f11050b.h(str);
    }

    public HashMap<String, d> e() {
        return this.f11050b.i();
    }

    public synchronized d f(String str) {
        return this.f11050b.j(str);
    }

    public synchronized void h(Context context) throws BLELibException {
        if (context == null) {
            throw new BLELibException("Application is null");
        }
        this.f11049a = context;
        if (!s.t()) {
            throw new BLELibException("This device doesn't support BLE");
        }
        f11048d = (BluetoothManager) this.f11049a.getSystemService(FirmwareUpgradeStatisticsLog.f13300c);
    }

    public synchronized boolean i(@n0 String str) {
        return this.f11050b.m(str);
    }
}
