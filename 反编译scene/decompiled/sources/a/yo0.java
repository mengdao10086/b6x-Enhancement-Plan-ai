package a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class yo0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g30 f7998a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ Context f3766a;

    public yo0(g30 g30Var, Context context) {
        this.f7998a = g30Var;
        this.f3766a = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String strI = "http://vtools.oss-cn-beijing.aliyuncs.com/app-release" + this.f7998a.e("versionCode") + ".apk";
        if (this.f7998a.j("downloadUrl")) {
            strI = this.f7998a.i("downloadUrl");
            f92.c(strI, "jsonObject.getString(\"downloadUrl\")");
        }
        try {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(Uri.parse(strI));
            this.f3766a.startActivity(intent);
        } catch (Exception unused) {
            Toast.makeText(this.f3766a, "启动下载失败！", 0).show();
        }
    }
}
