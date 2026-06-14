package a;

import android.hardware.Camera;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class j32 extends XC_MethodHook {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n32 f6470a;

    public j32(n32 n32Var) {
        this.f6470a = n32Var;
    }

    public void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        super.beforeHookedMethod(methodHookParam);
        methodHookParam.args[0] = Integer.valueOf(this.f6470a.f6871a.b().f6271a);
        XposedBridge.log("Scene: 微信启动相机 CameraId [" + methodHookParam.args[0] + "] Total: " + Camera.getNumberOfCameras());
    }
}
