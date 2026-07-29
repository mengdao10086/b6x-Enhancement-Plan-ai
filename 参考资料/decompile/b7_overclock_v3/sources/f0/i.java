package f0;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import g.n0;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"PrivateConstructorForUtilityClass"})
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f27481a = "android.support.AppLaunchChecker";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f27482b = "startedFromLauncher";

    @Deprecated
    public i() {
    }

    public static boolean a(@n0 Context context) {
        return context.getSharedPreferences(f27481a, 0).getBoolean(f27482b, false);
    }

    public static void b(@n0 Activity activity) {
        Intent intent;
        SharedPreferences sharedPreferences = activity.getSharedPreferences(f27481a, 0);
        if (sharedPreferences.getBoolean(f27482b, false) || (intent = activity.getIntent()) == null || !"android.intent.action.MAIN".equals(intent.getAction())) {
            return;
        }
        if (intent.hasCategory("android.intent.category.LAUNCHER") || intent.hasCategory(h0.f.f30116e)) {
            sharedPreferences.edit().putBoolean(f27482b, true).apply();
        }
    }
}
