package a;

import android.content.SharedPreferences;
import android.content.res.Resources;
import com.omarea.Scene;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class yu0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SharedPreferences f8011a = Scene.f4798a.c().getSharedPreferences(hz0.f1282a.l0(), 0);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Resources f3774a = Scene.f4798a.c().getResources();

    public final void a() {
        SharedPreferences.Editor editorEdit = this.f8011a.edit();
        for (String str : this.f3774a.getStringArray(s61.config_powercfg_igoned)) {
            editorEdit.putString(str, wu0.f3480a.j());
        }
        for (String str2 : this.f3774a.getStringArray(s61.config_powercfg_fast)) {
            editorEdit.putString(str2, wu0.f3480a.i());
        }
        for (String str3 : this.f3774a.getStringArray(s61.config_powercfg_performance)) {
            editorEdit.putString(str3, wu0.f3480a.o());
        }
        for (String str4 : this.f3774a.getStringArray(s61.config_powercfg_balance)) {
            editorEdit.putString(str4, wu0.f3480a.c());
        }
        for (String str5 : this.f3774a.getStringArray(s61.config_powercfg_powersave)) {
            editorEdit.putString(str5, wu0.f3480a.p());
        }
        editorEdit.apply();
    }
}
