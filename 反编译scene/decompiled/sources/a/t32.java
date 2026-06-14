package a;

import android.annotation.TargetApi;
import android.app.Activity;
import android.view.Window;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@TargetApi(26)
public class t32 implements p32 {
    @Override // a.p32
    public void a(Activity activity) {
        try {
            Window.class.getMethod("addExtraFlags", Integer.TYPE).invoke(activity.getWindow(), 1792);
        } catch (Exception unused) {
        }
    }
}
