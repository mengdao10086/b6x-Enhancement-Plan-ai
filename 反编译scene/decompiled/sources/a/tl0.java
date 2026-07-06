package a;

import android.os.Build;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class tl0 {
    public final void a() {
        s60 s60Var;
        String str;
        int i = Build.VERSION.SDK_INT;
        if (i > 28) {
            s60Var = s60.f7366a;
            str = "settings put secure location_mode 0";
        } else if (i >= 23) {
            s60Var = s60.f7366a;
            str = "settings put secure location_providers_allowed -gps";
        } else {
            s60Var = s60.f7366a;
            str = "settings put secure location_providers_allowed network";
        }
        s60Var.c(str);
    }

    public final void b() {
        s60 s60Var;
        String str;
        int i = Build.VERSION.SDK_INT;
        if (i > 28) {
            s60Var = s60.f7366a;
            str = "settings put secure location_mode 0";
        } else if (i >= 23) {
            s60Var = s60.f7366a;
            str = "settings put secure location_providers_allowed -gps,-network";
        } else {
            s60Var = s60.f7366a;
            str = "settings delete secure location_providers_allowed";
        }
        s60Var.c(str);
    }

    public final void c() {
        s60 s60Var;
        String str;
        int i = Build.VERSION.SDK_INT;
        if (i > 28) {
            s60Var = s60.f7366a;
            str = "settings put secure location_mode 3";
        } else if (i >= 23) {
            s60Var = s60.f7366a;
            str = "settings put secure location_providers_allowed +gps";
        } else {
            s60Var = s60.f7366a;
            str = "settings put secure location_providers_allowed gps,network";
        }
        s60Var.c(str);
    }
}
