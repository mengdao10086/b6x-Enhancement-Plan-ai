package com.flydigi.cyberfox.h1.services;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothDevice;
import android.os.Handler;
import g.f0;
import java.io.File;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes7.dex */
public interface b {

    @Retention(RetentionPolicy.SOURCE)
    @SuppressLint({"ShiftFlags"})
    public @interface a {
        public static final int P = 0;
        public static final int Q = 1;
        public static final int R = 2;
        public static final int S = 3;
        public static final int T = 4;
        public static final int U = 5;
        public static final int V = 6;
        public static final int W = 7;
        public static final int X = -1;
    }

    /* JADX INFO: renamed from: com.flydigi.cyberfox.h1.services.b$b, reason: collision with other inner class name */
    @Retention(RetentionPolicy.SOURCE)
    public @interface InterfaceC0151b {
        public static final int Y = 0;
        public static final int Z = 1;

        /* JADX INFO: renamed from: a0, reason: collision with root package name */
        public static final int f14188a0 = 2;

        /* JADX INFO: renamed from: b0, reason: collision with root package name */
        public static final int f14189b0 = 3;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface c {

        /* JADX INFO: renamed from: c0, reason: collision with root package name */
        public static final int f14190c0 = -1;

        /* JADX INFO: renamed from: d0, reason: collision with root package name */
        public static final int f14191d0 = 0;

        /* JADX INFO: renamed from: e0, reason: collision with root package name */
        public static final int f14192e0 = 1;
    }

    @Retention(RetentionPolicy.SOURCE)
    @SuppressLint({"ShiftFlags"})
    public @interface d {

        /* JADX INFO: renamed from: f0, reason: collision with root package name */
        public static final int f14193f0 = 0;

        /* JADX INFO: renamed from: g0, reason: collision with root package name */
        public static final int f14194g0 = 1;

        /* JADX INFO: renamed from: h0, reason: collision with root package name */
        public static final int f14195h0 = 2;

        /* JADX INFO: renamed from: i0, reason: collision with root package name */
        public static final int f14196i0 = 3;

        /* JADX INFO: renamed from: j0, reason: collision with root package name */
        public static final int f14197j0 = 4;
    }

    boolean A();

    int B();

    int C();

    void D();

    n6.b G();

    boolean H();

    void I();

    void K(boolean z10);

    boolean L();

    boolean N();

    boolean O(boolean z10);

    boolean a(byte[] bArr);

    void d(int i10, boolean z10);

    int f();

    boolean g();

    boolean i();

    boolean j(@f0(from = 0, to = 2) int i10);

    boolean k(boolean z10);

    boolean l();

    void m(boolean z10);

    boolean n(byte b10);

    boolean o();

    boolean p(@f0(from = 0, to = 2) int i10);

    void r(Handler handler);

    void t(Handler handler);

    BluetoothDevice u();

    boolean w(String str);

    int x();

    void z(File file);
}
