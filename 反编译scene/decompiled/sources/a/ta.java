package a;

import a.va;
import android.app.Activity;
import android.content.pm.PackageManager;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class ta implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7481a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ Activity f3006a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ String[] f3007a;

    public ta(String[] strArr, Activity activity, int i) {
        this.f3007a = strArr;
        this.f3006a = activity;
        this.f7481a = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        int[] iArr = new int[this.f3007a.length];
        PackageManager packageManager = this.f3006a.getPackageManager();
        String packageName = this.f3006a.getPackageName();
        int length = this.f3007a.length;
        for (int i = 0; i < length; i++) {
            iArr[i] = packageManager.checkPermission(this.f3007a[i], packageName);
        }
        ((va.a) this.f3006a).onRequestPermissionsResult(this.f7481a, this.f3007a, iArr);
    }
}
