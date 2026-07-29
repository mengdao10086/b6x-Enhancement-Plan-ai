package le;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.google.android.material.internal.b0;
import g.n0;

/* JADX INFO: loaded from: classes3.dex */
public class k {
    @n0
    public static e a(int i10) {
        return i10 != 0 ? i10 != 1 ? b() : new f() : new n();
    }

    @n0
    public static e b() {
        return new n();
    }

    @n0
    public static g c() {
        return new g();
    }

    public static void d(@n0 View view, float f10) {
        Drawable background = view.getBackground();
        if (background instanceof j) {
            ((j) background).n0(f10);
        }
    }

    public static void e(@n0 View view) {
        Drawable background = view.getBackground();
        if (background instanceof j) {
            f(view, (j) background);
        }
    }

    public static void f(@n0 View view, @n0 j jVar) {
        if (jVar.b0()) {
            jVar.s0(b0.j(view));
        }
    }
}
