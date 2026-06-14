package a;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class bl0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final al0 f5714a = new al0(null);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final String[] f283a = {"/dev/block/bootdevice/by-name", "/dev/block/by-name", "/dev/block/platform/bootdevice/by-name"};

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Activity f284a;

    public bl0(Activity activity) {
        f92.d(activity, "context");
        this.f284a = activity;
        new u90(this.f284a, null, 2, null);
        new Handler(Looper.getMainLooper());
    }

    public final ArrayList<n50> a() {
        String str;
        String[] strArr = f283a;
        int length = strArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                str = null;
                break;
            }
            str = strArr[i];
            if (y60.f7952a.c(str)) {
                break;
            }
            i++;
        }
        if (str != null) {
            return y60.f7952a.h(str);
        }
        return null;
    }
}
