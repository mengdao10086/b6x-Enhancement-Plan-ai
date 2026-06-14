package a;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class mh0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6808a = mh0.class.getSimpleName();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final List<String> f1929a = new ArrayList();

    public boolean a(Context context, String str) {
        File file = new File(str);
        if (file.canWrite()) {
            return true;
        }
        if (e(file, context)) {
            mk mkVarB = b(file, true, context);
            return mkVarB != null && mkVarB.a();
        }
        String string = PreferenceManager.getDefaultSharedPreferences(context).getString(str, "");
        if (string != null && !string.isEmpty()) {
            return true;
        }
        mk mkVarF = mk.f(context, Uri.parse(string));
        return mkVarF != null && mkVarF.a();
    }

    public mk b(File file, boolean z, Context context) {
        String strSubstring;
        boolean z2;
        String canonicalPath;
        String strC = c(file, context);
        if (strC == null) {
            return null;
        }
        int i = 0;
        try {
            canonicalPath = file.getCanonicalPath();
        } catch (IOException unused) {
            return null;
        } catch (Exception unused2) {
        }
        if (strC.equals(canonicalPath)) {
            strSubstring = null;
            z2 = true;
        } else {
            strSubstring = canonicalPath.substring(strC.length() + 1);
            z2 = false;
        }
        String string = PreferenceManager.getDefaultSharedPreferences(context).getString(strC, null);
        Uri uri = string != null ? Uri.parse(string) : null;
        if (uri == null) {
            return null;
        }
        mk mkVarF = mk.f(context, uri);
        if (z2) {
            return mkVarF;
        }
        String[] strArrSplit = strSubstring.split("/");
        while (i < strArrSplit.length) {
            mk mkVarD = mkVarF.d(strArrSplit[i]);
            mkVarF = mkVarD == null ? (i < strArrSplit.length - 1 || z) ? mkVarF.b(strArrSplit[i]) : mkVarF.c("image", strArrSplit[i]) : mkVarD;
            i++;
        }
        return mkVarF;
    }

    @TargetApi(19)
    public final String c(File file, Context context) {
        String[] strArrD = d(context);
        for (int i = 0; i < strArrD.length; i++) {
            try {
                if (file.getCanonicalPath().startsWith(strArrD[i])) {
                    return strArrD[i];
                }
            } catch (IOException unused) {
            }
            return null;
        }
        return null;
    }

    @TargetApi(19)
    public final String[] d(Context context) {
        Object[] array;
        if (this.f1929a.size() > 0) {
            array = this.f1929a.toArray(new String[0]);
        } else {
            for (File file : context.getExternalFilesDirs("external")) {
                if (file != null && !file.equals(context.getExternalFilesDir("external"))) {
                    int iLastIndexOf = file.getAbsolutePath().lastIndexOf("/Android/data");
                    if (iLastIndexOf < 0) {
                        Log.w(this.f6808a, "Unexpected external file dir: " + file.getAbsolutePath());
                    } else {
                        String strSubstring = file.getAbsolutePath().substring(0, iLastIndexOf);
                        try {
                            strSubstring = new File(strSubstring).getCanonicalPath();
                        } catch (IOException unused) {
                        }
                        this.f1929a.add(strSubstring);
                    }
                }
            }
            if (this.f1929a.isEmpty()) {
                this.f1929a.add("/storage/sdcard1");
            }
            array = this.f1929a.toArray(new String[0]);
        }
        return (String[]) array;
    }

    @TargetApi(19)
    public boolean e(File file, Context context) {
        return c(file, context) != null;
    }

    public boolean f(Context context, String str, Uri uri) {
        mk mkVarF = mk.f(context, uri);
        if (mkVarF != null && mkVarF.a()) {
            PreferenceManager.getDefaultSharedPreferences(context).edit().putString(str, uri.toString()).apply();
            return true;
        }
        Log.e(this.f6808a, "no write permission: " + str);
        return false;
    }
}
