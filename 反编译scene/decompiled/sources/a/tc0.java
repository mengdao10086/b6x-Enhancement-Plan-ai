package a;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.widget.Toast;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class tc0 extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static tc0 f7487a;

    public static void a(Context context) {
        if (f7487a == null) {
            f7487a = new tc0();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.DOWNLOAD_COMPLETE");
            context.registerReceiver(f7487a, intentFilter);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) throws Throwable {
        if (intent == null || !"android.intent.action.DOWNLOAD_COMPLETE".equals(intent.getAction())) {
            return;
        }
        try {
            long longExtra = intent.getLongExtra("extra_download_id", -1L);
            DownloadManager downloadManager = (DownloadManager) context.getSystemService("download");
            TextUtils.isEmpty(downloadManager.getMimeTypeForDownloadedFile(longExtra));
            String strF = new b60().f(context, downloadManager.getUriForDownloadedFile(longExtra));
            if (strF == null || strF.isEmpty()) {
                return;
            }
            new sc0(context, null).d(longExtra, strF);
            try {
                p80.f2403a.y(context, context.getString(ob0.kr_download_completed), strF, null);
            } catch (Exception unused) {
                Toast.makeText(context, context.getString(ob0.kr_download_completed) + "\n" + strF, 1).show();
            }
        } catch (Exception unused2) {
        }
    }
}
