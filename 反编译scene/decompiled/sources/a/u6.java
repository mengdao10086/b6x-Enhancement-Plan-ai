package a;

import android.graphics.Typeface;
import android.os.Build;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class u6 extends nc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7568a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ v6 f3142a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ WeakReference f3143a;
    public final /* synthetic */ int b;

    public u6(v6 v6Var, int i, int i2, WeakReference weakReference) {
        this.f3142a = v6Var;
        this.f7568a = i;
        this.b = i2;
        this.f3143a = weakReference;
    }

    @Override // a.nc
    public void d(int i) {
    }

    @Override // a.nc
    public void e(Typeface typeface) {
        int i;
        if (Build.VERSION.SDK_INT >= 28 && (i = this.f7568a) != -1) {
            typeface = Typeface.create(typeface, i, (this.b & 2) != 0);
        }
        this.f3142a.n(this.f3143a, typeface);
    }
}
