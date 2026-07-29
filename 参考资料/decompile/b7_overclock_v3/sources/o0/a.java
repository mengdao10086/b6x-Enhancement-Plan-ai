package o0;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.view.Display;
import g.n0;
import g.p0;
import g.u;
import g.v0;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final WeakHashMap<Context, a> f42691b = new WeakHashMap<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f42692c = "android.hardware.display.category.PRESENTATION";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f42693a;

    /* JADX INFO: renamed from: o0.a$a, reason: collision with other inner class name */
    @v0(17)
    public static class C0482a {
        @u
        public static Display a(DisplayManager displayManager, int i10) {
            return displayManager.getDisplay(i10);
        }

        @u
        public static Display[] b(DisplayManager displayManager) {
            return displayManager.getDisplays();
        }
    }

    public a(Context context) {
        this.f42693a = context;
    }

    @n0
    public static a d(@n0 Context context) {
        a aVar;
        WeakHashMap<Context, a> weakHashMap = f42691b;
        synchronized (weakHashMap) {
            aVar = weakHashMap.get(context);
            if (aVar == null) {
                aVar = new a(context);
                weakHashMap.put(context, aVar);
            }
        }
        return aVar;
    }

    @p0
    public Display a(int i10) {
        return C0482a.a((DisplayManager) this.f42693a.getSystemService("display"), i10);
    }

    @n0
    public Display[] b() {
        return C0482a.b((DisplayManager) this.f42693a.getSystemService("display"));
    }

    @n0
    public Display[] c(@p0 String str) {
        return C0482a.b((DisplayManager) this.f42693a.getSystemService("display"));
    }
}
