package a;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.util.Arrays;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class va extends yb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static b f7672a;

    public interface a {
        void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);
    }

    public interface b {
        boolean a(Activity activity, String[] strArr, int i);

        boolean b(Activity activity, int i, int i2, Intent intent);
    }

    public interface c {
        void validateRequestPermissionsRequestCode(int i);
    }

    public static void h(Activity activity) {
        if (Build.VERSION.SDK_INT >= 16) {
            activity.finishAffinity();
        } else {
            activity.finish();
        }
    }

    public static void i(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            activity.finishAfterTransition();
        } else {
            activity.finish();
        }
    }

    public static b j() {
        return f7672a;
    }

    public static void k(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            activity.postponeEnterTransition();
        }
    }

    public static void l(Activity activity) {
        int i = Build.VERSION.SDK_INT;
        if (i < 28) {
            if (i <= 23) {
                new Handler(activity.getMainLooper()).post(new ua(activity));
                return;
            } else if (cb.i(activity)) {
                return;
            }
        }
        activity.recreate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void m(Activity activity, String[] strArr, int i) {
        b bVar = f7672a;
        if (bVar == null || !bVar.a(activity, strArr, i)) {
            for (String str : strArr) {
                if (TextUtils.isEmpty(str)) {
                    throw new IllegalArgumentException("Permission request for permissions " + Arrays.toString(strArr) + " must not contain null or empty values");
                }
            }
            if (Build.VERSION.SDK_INT >= 23) {
                if (activity instanceof c) {
                    ((c) activity).validateRequestPermissionsRequestCode(i);
                }
                activity.requestPermissions(strArr, i);
            } else if (activity instanceof a) {
                new Handler(Looper.getMainLooper()).post(new ta(strArr, activity, i));
            }
        }
    }

    public static void n(Activity activity, wb wbVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            activity.setEnterSharedElementCallback(wbVar != null ? new xa(wbVar) : null);
        }
    }

    public static void o(Activity activity, wb wbVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            activity.setExitSharedElementCallback(wbVar != null ? new xa(wbVar) : null);
        }
    }

    public static void p(Activity activity, Intent intent, int i, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            activity.startActivityForResult(intent, i, bundle);
        } else {
            activity.startActivityForResult(intent, i);
        }
    }

    public static void q(Activity activity, IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) throws IntentSender.SendIntentException {
        if (Build.VERSION.SDK_INT >= 16) {
            activity.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
        } else {
            activity.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4);
        }
    }

    public static void r(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            activity.startPostponedEnterTransition();
        }
    }
}
