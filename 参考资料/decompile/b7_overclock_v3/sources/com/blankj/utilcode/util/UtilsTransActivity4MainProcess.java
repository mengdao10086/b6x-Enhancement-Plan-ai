package com.blankj.utilcode.util;

import android.app.Activity;
import android.content.Intent;
import com.blankj.utilcode.util.UtilsTransActivity;
import com.blankj.utilcode.util.j1;

/* JADX INFO: loaded from: classes2.dex */
public class UtilsTransActivity4MainProcess extends UtilsTransActivity {
    public static void Z3(Activity activity, j1.b<Intent> bVar, UtilsTransActivity.TransActivityDelegate transActivityDelegate) {
        UtilsTransActivity.a4(activity, bVar, transActivityDelegate, UtilsTransActivity4MainProcess.class);
    }

    public static void b4(Activity activity, UtilsTransActivity.TransActivityDelegate transActivityDelegate) {
        UtilsTransActivity.a4(activity, null, transActivityDelegate, UtilsTransActivity4MainProcess.class);
    }

    public static void c4(j1.b<Intent> bVar, UtilsTransActivity.TransActivityDelegate transActivityDelegate) {
        UtilsTransActivity.a4(null, bVar, transActivityDelegate, UtilsTransActivity4MainProcess.class);
    }

    public static void d4(UtilsTransActivity.TransActivityDelegate transActivityDelegate) {
        UtilsTransActivity.a4(null, null, transActivityDelegate, UtilsTransActivity4MainProcess.class);
    }
}
