package a;

import android.view.View;
import android.view.WindowId;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class kt implements lt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WindowId f6638a;

    public kt(View view) {
        this.f6638a = view.getWindowId();
    }

    public boolean equals(Object obj) {
        return (obj instanceof kt) && ((kt) obj).f6638a.equals(this.f6638a);
    }

    public int hashCode() {
        return this.f6638a.hashCode();
    }
}
