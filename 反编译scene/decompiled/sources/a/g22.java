package a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import de.robv.android.xposed.XC_MethodHook;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class g22 extends XC_MethodHook {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h22 f6162a;

    public g22(h22 h22Var) {
        this.f6162a = h22Var;
    }

    public void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        Object[] objArr = methodHookParam.args;
        if (objArr.length <= 0 || objArr[4] == null) {
            return;
        }
        Intent intent = (Intent) objArr[4];
        String packageName = intent.getPackage();
        ComponentName component = intent.getComponent();
        if (packageName == null && component != null) {
            packageName = component.getPackageName();
        }
        Context context = (Context) methodHookParam.args[0];
        if (packageName == null || packageName.equals(context.getPackageName())) {
            return;
        }
        this.f6162a.c(context, packageName);
    }
}
