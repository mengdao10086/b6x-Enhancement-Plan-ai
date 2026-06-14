package a;

import android.os.Build;
import android.os.Bundle;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class ri {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f7302a;

    public ri() {
        int i = Build.VERSION.SDK_INT;
        this.f7302a = i >= 26 ? new qi(this) : i >= 19 ? new pi(this) : i >= 16 ? new oi(this) : null;
    }

    public ri(Object obj) {
        this.f7302a = obj;
    }

    public void a(int i, ni niVar, String str, Bundle bundle) {
    }

    public ni b(int i) {
        return null;
    }

    public List<ni> c(String str, int i) {
        return null;
    }

    public ni d(int i) {
        return null;
    }

    public Object e() {
        return this.f7302a;
    }

    public boolean f(int i, int i2, Bundle bundle) {
        return false;
    }
}
