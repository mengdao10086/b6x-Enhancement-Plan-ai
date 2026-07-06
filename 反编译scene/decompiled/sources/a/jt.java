package a;

import android.os.IBinder;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class jt implements lt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IBinder f6543a;

    public jt(IBinder iBinder) {
        this.f6543a = iBinder;
    }

    public boolean equals(Object obj) {
        return (obj instanceof jt) && ((jt) obj).f6543a.equals(this.f6543a);
    }

    public int hashCode() {
        return this.f6543a.hashCode();
    }
}
