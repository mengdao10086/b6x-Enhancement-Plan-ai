package a;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Build;
import android.webkit.DownloadListener;
import android.widget.Toast;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class tb0 implements DownloadListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ic0 f7484a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ Activity f3010a;

    public tb0(ic0 ic0Var, Activity activity) {
        this.f7484a = ic0Var;
        this.f3010a = activity;
    }

    @Override // android.webkit.DownloadListener
    public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        if (Build.VERSION.SDK_INT >= 23 && this.f7484a.f1351a.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") != 0) {
            this.f3010a.requestPermissions(new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, 2);
            Toast.makeText(this.f7484a.f1351a, ob0.kr_write_external_storage, 1).show();
            return;
        }
        p80.f2403a.c(new AlertDialog.Builder(this.f7484a.f1351a).setTitle(ob0.kr_download_confirm).setMessage(str + "\n\n" + str4 + "\n" + j + "Bytes").setPositiveButton(ob0.btn_confirm, new sb0(this, str, str3, str4)).setNegativeButton(ob0.btn_cancel, new rb0(this))).i(false);
    }
}
