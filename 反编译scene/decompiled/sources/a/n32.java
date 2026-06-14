package a;

import android.app.Activity;
import android.hardware.Camera;
import android.os.Build;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class n32 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g32 f6871a = new g32();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final i32 f2000a = new i32();

    public final TextView c(ViewGroup viewGroup) {
        TextView textView = new TextView(viewGroup.getContext());
        textView.setTextColor(-1);
        textView.setPadding(100, 0, 100, 0);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        textView.setTextSize(40.0f);
        layoutParams.addRule(13);
        textView.setText(this.f6871a.b().f1118a);
        viewGroup.addView(textView, layoutParams);
        return textView;
    }

    public void d(XC_LoadPackage.LoadPackageParam loadPackageParam) {
        if (f()) {
            XposedHelpers.findAndHookMethod(Camera.class, "open", new Object[]{Integer.TYPE, new j32(this)});
            XposedHelpers.findAndHookMethod(Activity.class, "onResume", new Object[]{new k32(this)});
            XposedHelpers.findAndHookMethod(Activity.class, "onPause", new Object[]{new l32(this)});
        }
    }

    public final void e(XC_MethodHook.MethodHookParam methodHookParam) {
        Activity activity;
        RelativeLayout relativeLayoutA;
        if (this.f6871a.f964a.length <= 1 || (relativeLayoutA = this.f2000a.a((activity = (Activity) methodHookParam.thisObject))) == null) {
            return;
        }
        c(relativeLayoutA).setOnClickListener(new m32(this, activity));
    }

    public boolean f() {
        return g32.f6166a.contains(Build.MODEL) && Camera.getNumberOfCameras() > 2;
    }
}
