package o3;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f42703a = "NewbieGuide";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f42704b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f42705c = -1;

    public static void a(Context context, String str) {
        context.getSharedPreferences("NewbieGuide", 0).edit().putInt(str, 0).apply();
    }

    public static p3.a b(Activity activity) {
        return new p3.a(activity);
    }

    public static p3.a c(Fragment fragment) {
        return new p3.a(fragment);
    }

    public static p3.a d(androidx.fragment.app.Fragment fragment) {
        return new p3.a(fragment);
    }
}
