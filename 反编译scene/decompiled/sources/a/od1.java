package a;

import com.omarea.Scene;
import com.omarea.vtools.activities.ActivityOtherSettings;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class od1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ActivityOtherSettings.c f7009a;

    public od1(ActivityOtherSettings.c cVar) {
        this.f7009a = cVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Scene.c cVar;
        String str;
        if (new vo0(ActivityOtherSettings.this).F()) {
            cVar = Scene.f4798a;
            str = "^_^";
        } else {
            cVar = Scene.f4798a;
            str = ">_<!";
        }
        Scene.c.p(cVar, str, 0, 2, null);
    }
}
