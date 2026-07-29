package wf;

import android.content.Context;

/* JADX INFO: loaded from: classes7.dex */
public class b {
    public static String a(Context context) {
        try {
            return "VersionName : " + context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception e10) {
            e10.printStackTrace();
            return "VersionName : Unknow";
        }
    }
}
