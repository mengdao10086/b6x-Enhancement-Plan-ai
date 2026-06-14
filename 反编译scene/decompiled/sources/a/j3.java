package a;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.view.ViewConfiguration;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class j3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f6467a;

    public j3(Context context) {
        this.f6467a = context;
    }

    public static j3 b(Context context) {
        return new j3(context);
    }

    public boolean a() {
        return this.f6467a.getApplicationInfo().targetSdkVersion < 14;
    }

    public int c() {
        return this.f6467a.getResources().getDisplayMetrics().widthPixels / 2;
    }

    public int d() {
        Configuration configuration = this.f6467a.getResources().getConfiguration();
        int i = configuration.screenWidthDp;
        int i2 = configuration.screenHeightDp;
        if (configuration.smallestScreenWidthDp > 600 || i > 600) {
            return 5;
        }
        if (i > 960 && i2 > 720) {
            return 5;
        }
        if (i > 720 && i2 > 960) {
            return 5;
        }
        if (i >= 500) {
            return 4;
        }
        if (i > 640 && i2 > 480) {
            return 4;
        }
        if (i <= 480 || i2 <= 640) {
            return i >= 360 ? 3 : 2;
        }
        return 4;
    }

    public boolean e() {
        return this.f6467a.getResources().getBoolean(u.abc_action_bar_embed_tabs);
    }

    public boolean f() {
        if (Build.VERSION.SDK_INT >= 19) {
            return true;
        }
        return !ViewConfiguration.get(this.f6467a).hasPermanentMenuKey();
    }
}
