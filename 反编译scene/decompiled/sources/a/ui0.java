package a;

import a.p80;
import a.vi0;
import android.app.Activity;
import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.webkit.URLUtil;
import android.widget.Toast;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ui0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f7600a;

    public ui0(Context context, Activity activity) {
        f92.d(context, "context");
        this.f7600a = context;
    }

    public final Long a(String str, String str2, String str3, String str4, boolean z) {
        f92.d(str, "url");
        f92.d(str2, "contentDisposition");
        f92.d(str3, "mimeType");
        f92.d(str4, "fileName");
        try {
            DownloadManager.Request request = new DownloadManager.Request(Uri.parse(str));
            request.allowScanningByMediaScanner();
            boolean z2 = true;
            request.setNotificationVisibility(1);
            request.setAllowedOverMetered(true);
            request.setVisibleInDownloadsUi(true);
            request.setAllowedOverRoaming(true);
            if (str4.length() != 0) {
                z2 = false;
            }
            if (z2) {
                str4 = URLUtil.guessFileName(str, str2, str3);
            }
            request.setDescription(str4);
            request.setTitle(str4);
            Toast.makeText(this.f7600a, this.f7600a.getString(u61.kr_download_create_success), 0).show();
            vi0.a aVar = vi0.f7699a;
            Context applicationContext = this.f7600a.getApplicationContext();
            f92.c(applicationContext, "context.applicationContext");
            aVar.a(applicationContext);
            Object systemService = this.f7600a.getSystemService("download");
            if (systemService == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.app.DownloadManager");
            }
            DownloadManager downloadManager = (DownloadManager) systemService;
            if (!z) {
                request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, str4);
                return Long.valueOf(downloadManager.enqueue(request));
            }
            long jEnqueue = downloadManager.enqueue(request);
            this.f7600a.getSharedPreferences("MagiskReCompress", 0).edit().putString("" + jEnqueue, str4).apply();
            return Long.valueOf(jEnqueue);
        } catch (Exception e) {
            p80.a aVar2 = p80.f2403a;
            Context context = this.f7600a;
            String string = context.getString(u61.kr_download_create_fail);
            f92.c(string, "context.getString(R.stri….kr_download_create_fail)");
            p80.a.B(aVar2, context, string, "" + e.getMessage(), null, 8, null);
            return null;
        }
    }
}
