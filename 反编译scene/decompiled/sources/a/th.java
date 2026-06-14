package a;

import android.graphics.Rect;
import android.util.Log;
import android.view.WindowInsets;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class th extends wh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Constructor<WindowInsets> f7500a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static Field f3026a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static boolean f3027a = false;
    public static boolean b = false;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public uc f3028a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public WindowInsets f3029a;

    public th() {
        this.f3029a = h();
    }

    public th(sh shVar) {
        this.f3029a = shVar.r();
    }

    public static WindowInsets h() {
        if (!f3027a) {
            try {
                f3026a = WindowInsets.class.getDeclaredField("CONSUMED");
            } catch (ReflectiveOperationException e) {
                Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets.CONSUMED field", e);
            }
            f3027a = true;
        }
        Field field = f3026a;
        if (field != null) {
            try {
                WindowInsets windowInsets = (WindowInsets) field.get(null);
                if (windowInsets != null) {
                    return new WindowInsets(windowInsets);
                }
            } catch (ReflectiveOperationException e2) {
                Log.i("WindowInsetsCompat", "Could not get value from WindowInsets.CONSUMED field", e2);
            }
        }
        if (!b) {
            try {
                f7500a = WindowInsets.class.getConstructor(Rect.class);
            } catch (ReflectiveOperationException e3) {
                Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets(Rect) constructor", e3);
            }
            b = true;
        }
        Constructor<WindowInsets> constructor = f7500a;
        if (constructor != null) {
            try {
                return constructor.newInstance(new Rect());
            } catch (ReflectiveOperationException e4) {
                Log.i("WindowInsetsCompat", "Could not invoke WindowInsets(Rect) constructor", e4);
            }
        }
        return null;
    }

    @Override // a.wh
    public sh b() {
        a();
        sh shVarS = sh.s(this.f3029a);
        shVarS.n(((wh) this).f3438a);
        shVarS.q(this.f3028a);
        return shVarS;
    }

    @Override // a.wh
    public void d(uc ucVar) {
        this.f3028a = ucVar;
    }

    @Override // a.wh
    public void f(uc ucVar) {
        WindowInsets windowInsets = this.f3029a;
        if (windowInsets != null) {
            this.f3029a = windowInsets.replaceSystemWindowInsets(ucVar.f3164a, ucVar.b, ucVar.c, ucVar.d);
        }
    }
}
