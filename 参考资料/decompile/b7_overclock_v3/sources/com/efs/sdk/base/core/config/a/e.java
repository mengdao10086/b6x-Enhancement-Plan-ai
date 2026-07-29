package com.efs.sdk.base.core.config.a;

import android.content.SharedPreferences;
import com.efs.sdk.base.core.c.f;
import com.efs.sdk.base.core.config.GlobalEnvStruct;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.newsharedpreferences.SharedPreferencesUtils;
import g.n0;
import java.io.File;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements SharedPreferences.OnSharedPreferenceChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile SharedPreferences f12868a;

    public static void b() {
        File fileA = com.efs.sdk.base.core.util.a.a(ControllerCenter.getGlobalEnvStruct().mAppContext, ControllerCenter.getGlobalEnvStruct().getAppid());
        if (fileA.exists()) {
            fileA.delete();
        }
    }

    private void d() {
        if (this.f12868a == null) {
            synchronized (com.efs.sdk.base.core.c.b.class) {
                if (this.f12868a == null) {
                    this.f12868a = SharedPreferencesUtils.getSharedPreferences(ControllerCenter.getGlobalEnvStruct().mAppContext, com.efs.sdk.base.core.util.b.b.a(("config_" + ControllerCenter.getGlobalEnvStruct().getAppid().toLowerCase()).getBytes()));
                    this.f12868a.registerOnSharedPreferenceChangeListener(this);
                }
            }
        }
    }

    public final boolean a(@n0 b bVar) {
        c();
        if (this.f12868a == null) {
            return false;
        }
        SharedPreferences.Editor editorEdit = this.f12868a.edit();
        editorEdit.clear();
        editorEdit.putInt("cver", bVar.f12850a);
        editorEdit.putLong("last_refresh_time", System.currentTimeMillis());
        for (Map.Entry<String, String> entry : bVar.f12855f.entrySet()) {
            editorEdit.putString(entry.getKey(), entry.getValue());
        }
        editorEdit.apply();
        return true;
    }

    public final void c() {
        try {
            d();
        } catch (Throwable th2) {
            Log.e("efs.config", "init sharedpreferences error", th2);
        }
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if (f.a.f12832a.a()) {
            return;
        }
        c.a().b();
    }

    public static boolean a() {
        GlobalEnvStruct globalEnvStruct = ControllerCenter.getGlobalEnvStruct();
        File fileB = com.efs.sdk.base.core.util.a.b(globalEnvStruct.mAppContext, globalEnvStruct.getAppid());
        if (!fileB.exists()) {
            return false;
        }
        com.efs.sdk.base.core.util.b.b(fileB);
        return true;
    }
}
