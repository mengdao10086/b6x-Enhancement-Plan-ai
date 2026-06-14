package a;

import a.p80;
import android.app.Activity;
import android.app.DownloadManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Environment;
import android.webkit.URLUtil;
import android.widget.Toast;
import java.io.File;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class sc0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f7383a = "kr_downloader";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Context f2873a;

    public sc0(Context context, Activity activity) {
        f92.d(context, "context");
        this.f2873a = context;
    }

    public /* synthetic */ sc0(Context context, Activity activity, int i, b92 b92Var) {
        this(context, (i & 2) != 0 ? null : activity);
    }

    public static /* synthetic */ Long c(sc0 sc0Var, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 16) != 0) {
            str5 = null;
        }
        return sc0Var.b(str, str2, str3, str4, str5);
    }

    public final void a(long j, String str, String str2) {
        SharedPreferences sharedPreferences = this.f2873a.getSharedPreferences(f7383a, 0);
        g30 g30Var = new g30();
        g30Var.x("url", str2);
        g30Var.x("taskAliasId", str);
        sharedPreferences.edit().putString(String.valueOf(j), g30Var.A(2)).apply();
    }

    public final Long b(String str, String str2, String str3, String str4, String str5) {
        f92.d(str, "url");
        f92.d(str4, "taskAliasId");
        try {
            DownloadManager.Request request = new DownloadManager.Request(Uri.parse(str));
            request.allowScanningByMediaScanner();
            boolean z = true;
            request.setNotificationVisibility(1);
            request.setAllowedOverMetered(true);
            request.setVisibleInDownloadsUi(true);
            request.setAllowedOverRoaming(true);
            if (str5 == null || str5.length() == 0) {
                str5 = URLUtil.guessFileName(str, str2, str3);
            }
            request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, str5);
            Object systemService = this.f2873a.getSystemService("download");
            if (systemService == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.app.DownloadManager");
            }
            long jEnqueue = ((DownloadManager) systemService).enqueue(request);
            if (str4.length() <= 0) {
                z = false;
            }
            if (z) {
                a(jEnqueue, str4, str);
            }
            Toast.makeText(this.f2873a, this.f2873a.getString(ob0.kr_download_create_success), 0).show();
            tc0.a(this.f2873a.getApplicationContext());
            return Long.valueOf(jEnqueue);
        } catch (Exception e) {
            p80.a aVar = p80.f2403a;
            Context context = this.f2873a;
            String string = context.getString(ob0.kr_download_create_fail);
            f92.c(string, "context.getString(R.stri….kr_download_create_fail)");
            p80.a.B(aVar, context, string, "" + e.getMessage(), null, 8, null);
            return null;
        }
    }

    public final void d(long j, String str) {
        String strI;
        f92.d(str, "absPath");
        SharedPreferences sharedPreferences = this.f2873a.getSharedPreferences(f7383a, 0);
        String string = sharedPreferences.getString(String.valueOf(j), null);
        if (string != null) {
            g30 g30Var = new g30(string);
            g30Var.x("absPath", str);
            sharedPreferences.edit().putString(String.valueOf(j), g30Var.A(2)).apply();
            strI = g30Var.i("taskAliasId");
        } else {
            strI = "";
        }
        try {
            File file = new File(str);
            if (file.exists() && file.canRead()) {
                String strB = new uc0().b(file);
                f92.c(strB, "FileMD5().getFileMD5(file)");
                if (strB == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                String lowerCase = strB.toLowerCase();
                f92.c(lowerCase, "(this as java.lang.String).toLowerCase()");
                c60 c60Var = c60.f5764a;
                Charset charsetDefaultCharset = Charset.defaultCharset();
                f92.c(charsetDefaultCharset, "Charset.defaultCharset()");
                byte[] bytes = str.getBytes(charsetDefaultCharset);
                f92.c(bytes, "(this as java.lang.String).getBytes(charset)");
                c60Var.l(bytes, "downloader/path/" + lowerCase, this.f2873a);
                if (strI != null) {
                    c60 c60Var2 = c60.f5764a;
                    Charset charsetDefaultCharset2 = Charset.defaultCharset();
                    f92.c(charsetDefaultCharset2, "Charset.defaultCharset()");
                    byte[] bytes2 = str.getBytes(charsetDefaultCharset2);
                    f92.c(bytes2, "(this as java.lang.String).getBytes(charset)");
                    c60Var2.l(bytes2, "downloader/result/" + strI, this.f2873a);
                }
            }
        } catch (Exception unused) {
        }
    }

    public final void e(String str, int i) {
        f92.d(str, "taskAliasId");
        c60 c60Var = c60.f5764a;
        String strValueOf = String.valueOf(i);
        Charset charsetDefaultCharset = Charset.defaultCharset();
        f92.c(charsetDefaultCharset, "Charset.defaultCharset()");
        if (strValueOf == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        byte[] bytes = strValueOf.getBytes(charsetDefaultCharset);
        f92.c(bytes, "(this as java.lang.String).getBytes(charset)");
        c60Var.l(bytes, "downloader/status/" + str, this.f2873a);
    }
}
