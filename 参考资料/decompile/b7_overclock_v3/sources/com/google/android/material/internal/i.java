package com.google.android.material.internal;

import android.os.Build;
import androidx.annotation.RestrictTo;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f20421a = "lge";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f20422b = "samsung";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f20423c = "meizu";

    public static boolean a() {
        return b() || d();
    }

    public static boolean b() {
        return Build.MANUFACTURER.toLowerCase(Locale.ENGLISH).equals(f20421a);
    }

    public static boolean c() {
        return Build.MANUFACTURER.toLowerCase(Locale.ENGLISH).equals(f20423c);
    }

    public static boolean d() {
        return Build.MANUFACTURER.toLowerCase(Locale.ENGLISH).equals(f20422b);
    }
}
