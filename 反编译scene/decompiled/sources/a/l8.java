package a;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class l8 extends ContextWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f6682a = new Object();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static ArrayList<WeakReference<l8>> f1767a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Resources.Theme f1768a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Resources f1769a;

    public l8(Context context) {
        super(context);
        if (!y8.b()) {
            this.f1769a = new n8(this, context.getResources());
            this.f1768a = null;
            return;
        }
        y8 y8Var = new y8(this, context.getResources());
        this.f1769a = y8Var;
        Resources.Theme themeNewTheme = y8Var.newTheme();
        this.f1768a = themeNewTheme;
        themeNewTheme.setTo(context.getTheme());
    }

    public static boolean a(Context context) {
        if ((context instanceof l8) || (context.getResources() instanceof n8) || (context.getResources() instanceof y8)) {
            return false;
        }
        return Build.VERSION.SDK_INT < 21 || y8.b();
    }

    public static Context b(Context context) {
        if (!a(context)) {
            return context;
        }
        synchronized (f6682a) {
            if (f1767a == null) {
                f1767a = new ArrayList<>();
            } else {
                for (int size = f1767a.size() - 1; size >= 0; size--) {
                    WeakReference<l8> weakReference = f1767a.get(size);
                    if (weakReference == null || weakReference.get() == null) {
                        f1767a.remove(size);
                    }
                }
                for (int size2 = f1767a.size() - 1; size2 >= 0; size2--) {
                    WeakReference<l8> weakReference2 = f1767a.get(size2);
                    l8 l8Var = weakReference2 != null ? weakReference2.get() : null;
                    if (l8Var != null && l8Var.getBaseContext() == context) {
                        return l8Var;
                    }
                }
            }
            l8 l8Var2 = new l8(context);
            f1767a.add(new WeakReference<>(l8Var2));
            return l8Var2;
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return this.f1769a.getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return this.f1769a;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f1768a;
        return theme == null ? super.getTheme() : theme;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        Resources.Theme theme = this.f1768a;
        if (theme == null) {
            super.setTheme(i);
        } else {
            theme.applyStyle(i, true);
        }
    }
}
