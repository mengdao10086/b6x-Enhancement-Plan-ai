package a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ti0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f7504a;

    public ti0(Context context) {
        f92.d(context, "context");
        this.f7504a = context;
    }

    public final String a() {
        try {
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.HOME");
            ResolveInfo resolveInfoResolveActivity = this.f7504a.getPackageManager().resolveActivity(intent, 0);
            f92.b(resolveInfoResolveActivity);
            f92.c(resolveInfoResolveActivity, "context.packageManager.r…olveActivity(intent, 0)!!");
            if (resolveInfoResolveActivity.activityInfo != null && !f92.a(resolveInfoResolveActivity.activityInfo.packageName, "android")) {
                return resolveInfoResolveActivity.activityInfo.packageName;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public final ArrayList<String> b() {
        Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
        intent.addCategory("android.intent.category.HOME");
        List<ResolveInfo> listQueryIntentActivities = this.f7504a.getPackageManager().queryIntentActivities(intent, 0);
        f92.c(listQueryIntentActivities, "context.packageManager.q…ivities(resolveIntent, 0)");
        ArrayList<String> arrayList = new ArrayList<>();
        Iterator<ResolveInfo> it = listQueryIntentActivities.iterator();
        while (it.hasNext()) {
            String str = it.next().activityInfo.packageName;
            if (!f92.a("com.android.settings", str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }
}
