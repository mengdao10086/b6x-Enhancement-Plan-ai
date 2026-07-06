package a;

import android.view.InflateException;
import android.view.MenuItem;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class q3 implements MenuItem.OnMenuItemClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Class<?>[] f7172a = {MenuItem.class};

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f2537a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Method f2538a;

    public q3(Object obj, String str) {
        this.f2537a = obj;
        Class<?> cls = obj.getClass();
        try {
            this.f2538a = cls.getMethod(str, f7172a);
        } catch (Exception e) {
            InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
            inflateException.initCause(e);
            throw inflateException;
        }
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) {
        try {
            if (this.f2538a.getReturnType() == Boolean.TYPE) {
                return ((Boolean) this.f2538a.invoke(this.f2537a, menuItem)).booleanValue();
            }
            this.f2538a.invoke(this.f2537a, menuItem);
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
