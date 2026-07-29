package z9;

import android.annotation.TargetApi;
import android.view.View;

/* JADX INFO: loaded from: classes3.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f57958a = 16;

    public static void a(View view, Runnable runnable) {
        b(view, runnable);
    }

    @TargetApi(16)
    public static void b(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }
}
