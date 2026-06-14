package a;

import android.os.Build;
import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class wg<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f7785a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Class<T> f3435a;
    public final int b;

    public wg(int i, Class<T> cls, int i2) {
        this(i, cls, 0, i2);
    }

    public wg(int i, Class<T> cls, int i2, int i3) {
        this.f7785a = i;
        this.f3435a = cls;
        this.b = i3;
    }

    public final boolean a() {
        return Build.VERSION.SDK_INT >= 19;
    }

    public final boolean b() {
        return Build.VERSION.SDK_INT >= this.b;
    }

    public abstract T c(View view);

    public T d(View view) {
        if (b()) {
            return c(view);
        }
        if (!a()) {
            return null;
        }
        T t = (T) view.getTag(this.f7785a);
        if (this.f3435a.isInstance(t)) {
            return t;
        }
        return null;
    }
}
