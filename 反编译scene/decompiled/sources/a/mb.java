package a;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.PendingIntent;
import android.os.Build;
import androidx.core.graphics.drawable.IconCompat;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class mb {
    public static Notification.BubbleMetadata i(mb mbVar) {
        if (mbVar == null) {
            return null;
        }
        int i = Build.VERSION.SDK_INT;
        if (i >= 30) {
            return lb.a(mbVar);
        }
        if (i == 29) {
            return kb.a(mbVar);
        }
        return null;
    }

    public abstract boolean a();

    public abstract PendingIntent b();

    public abstract int c();

    public abstract int d();

    @SuppressLint({"InvalidNullConversion"})
    public abstract IconCompat e();

    @SuppressLint({"InvalidNullConversion"})
    public abstract PendingIntent f();

    public abstract String g();

    public abstract boolean h();
}
