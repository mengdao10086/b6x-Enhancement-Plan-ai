package com.google.android.exoplayer2.scheduler;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.PowerManager;
import g.p0;
import hd.u0;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes3.dex */
public final class Requirements implements Parcelable {
    public static final Parcelable.Creator<Requirements> CREATOR = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f17457b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f17458c = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f17459d = 4;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f17460e = 8;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f17461f = 16;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f17462a;

    public class a implements Parcelable.Creator<Requirements> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Requirements createFromParcel(Parcel parcel) {
            return new Requirements(parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Requirements[] newArray(int i10) {
            return new Requirements[i10];
        }
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface b {
    }

    public Requirements(int i10) {
        this.f17462a = (i10 & 2) != 0 ? i10 | 1 : i10;
    }

    public static boolean M(ConnectivityManager connectivityManager) {
        NetworkCapabilities networkCapabilities;
        if (u0.f31154a < 24) {
            return true;
        }
        Network activeNetwork = connectivityManager.getActiveNetwork();
        return (activeNetwork == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null || !networkCapabilities.hasCapability(16)) ? false : true;
    }

    public final boolean C(Context context) {
        PowerManager powerManager = (PowerManager) hd.a.g(context.getSystemService("power"));
        int i10 = u0.f31154a;
        if (i10 >= 23) {
            return powerManager.isDeviceIdleMode();
        }
        if (i10 >= 20) {
            if (!powerManager.isInteractive()) {
                return true;
            }
        } else if (!powerManager.isScreenOn()) {
            return true;
        }
        return false;
    }

    public boolean F() {
        return (this.f17462a & 4) != 0;
    }

    public boolean S() {
        return (this.f17462a & 1) != 0;
    }

    public final boolean T(Context context) {
        return context.registerReceiver(null, new IntentFilter("android.intent.action.DEVICE_STORAGE_LOW")) == null;
    }

    public boolean U() {
        return (this.f17462a & 16) != 0;
    }

    public boolean V() {
        return (this.f17462a & 2) != 0;
    }

    public boolean a(Context context) {
        return g(context) == 0;
    }

    public Requirements b(int i10) {
        int i11 = this.f17462a;
        int i12 = i10 & i11;
        return i12 == i11 ? this : new Requirements(i12);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final int e(Context context) {
        if (!S()) {
            return 0;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) hd.a.g(context.getSystemService("connectivity"));
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return (activeNetworkInfo != null && activeNetworkInfo.isConnected() && M(connectivityManager)) ? (V() && connectivityManager.isActiveNetworkMetered()) ? 2 : 0 : this.f17462a & 3;
    }

    public boolean equals(@p0 Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && Requirements.class == obj.getClass() && this.f17462a == ((Requirements) obj).f17462a;
    }

    public int g(Context context) {
        int iE = e(context);
        if (s() && !z(context)) {
            iE |= 8;
        }
        if (F() && !C(context)) {
            iE |= 4;
        }
        return (!U() || T(context)) ? iE : iE | 16;
    }

    public int hashCode() {
        return this.f17462a;
    }

    public int j() {
        return this.f17462a;
    }

    public boolean s() {
        return (this.f17462a & 8) != 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f17462a);
    }

    public final boolean z(Context context) {
        Intent intentRegisterReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (intentRegisterReceiver == null) {
            return false;
        }
        int intExtra = intentRegisterReceiver.getIntExtra("status", -1);
        return intExtra == 2 || intExtra == 5;
    }
}
