package androidx.core.os;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Message;
import g.n0;
import g.v0;

/* JADX INFO: loaded from: classes2.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f4671a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f4672b = true;

    @v0(22)
    public static class a {
        @g.u
        public static boolean a(Message message) {
            return message.isAsynchronous();
        }

        @g.u
        public static void b(Message message, boolean z10) {
            message.setAsynchronous(z10);
        }
    }

    @SuppressLint({"NewApi"})
    public static boolean a(@n0 Message message) {
        if (Build.VERSION.SDK_INT >= 22) {
            return a.a(message);
        }
        if (f4672b) {
            try {
                return a.a(message);
            } catch (NoSuchMethodError unused) {
                f4672b = false;
            }
        }
        return false;
    }

    @SuppressLint({"NewApi"})
    public static void b(@n0 Message message, boolean z10) {
        if (Build.VERSION.SDK_INT >= 22) {
            a.b(message, z10);
        } else if (f4671a) {
            try {
                a.b(message, z10);
            } catch (NoSuchMethodError unused) {
                f4671a = false;
            }
        }
    }
}
