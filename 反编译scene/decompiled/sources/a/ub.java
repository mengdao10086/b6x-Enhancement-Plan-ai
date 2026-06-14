package a;

import android.app.RemoteInput;
import android.os.Build;
import android.os.Bundle;
import java.util.Set;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class ub {
    public static RemoteInput a(ub ubVar) {
        RemoteInput.Builder builderAddExtras = new RemoteInput.Builder(ubVar.i()).setLabel(ubVar.h()).setChoices(ubVar.e()).setAllowFreeFormInput(ubVar.c()).addExtras(ubVar.g());
        if (Build.VERSION.SDK_INT >= 29) {
            builderAddExtras.setEditChoicesBeforeSending(ubVar.f());
        }
        return builderAddExtras.build();
    }

    public static RemoteInput[] b(ub[] ubVarArr) {
        if (ubVarArr == null) {
            return null;
        }
        RemoteInput[] remoteInputArr = new RemoteInput[ubVarArr.length];
        for (int i = 0; i < ubVarArr.length; i++) {
            remoteInputArr[i] = a(ubVarArr[i]);
        }
        return remoteInputArr;
    }

    public abstract boolean c();

    public abstract Set<String> d();

    public abstract CharSequence[] e();

    public abstract int f();

    public abstract Bundle g();

    public abstract CharSequence h();

    public abstract String i();
}
