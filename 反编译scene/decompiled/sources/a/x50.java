package a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class x50 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f7855a;

    public x50(Context context) {
        f92.d(context, "context");
        this.f7855a = context;
    }

    public final void a(Intent intent) {
        if (intent == null) {
            return;
        }
        ComponentName component = intent.getComponent();
        String className = component != null ? component.getClassName() : null;
        ComponentName component2 = intent.getComponent();
        String packageName = component2 != null ? component2.getPackageName() : null;
        if (f92.a(e50.f677a.y0(), "root") && className != null) {
            qc2.d(xd2.a(qe2.b()), null, null, new w50(packageName, className, null), 3, null);
            return;
        }
        intent.setFlags((intent.getFlags() & (-2097153)) | 268435456 | 65536);
        intent.addFlags(1048576);
        intent.setPackage(null);
        this.f7855a.startActivity(intent);
    }

    public final boolean b(String str) {
        f92.d(str, "packageName");
        try {
            a(this.f7855a.getPackageManager().getLaunchIntentForPackage(str));
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
