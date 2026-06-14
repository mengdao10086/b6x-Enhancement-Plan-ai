package a;

import android.annotation.TargetApi;
import android.app.Activity;
import android.view.Window;
import android.view.WindowManager;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@TargetApi(28)
public class r32 implements p32 {
    @Override // a.p32
    public void a(Activity activity) {
        Window window = activity.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.layoutInDisplayCutoutMode = 1;
        window.setAttributes(attributes);
        window.getDecorView().setSystemUiVisibility(1280);
    }
}
