package androidx.appcompat.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import androidx.annotation.RestrictTo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class v0 extends ContextWrapper {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f2716c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static ArrayList<WeakReference<v0>> f2717d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Resources f2718a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Resources.Theme f2719b;

    public v0(@g.n0 Context context) {
        super(context);
        if (!g1.d()) {
            this.f2718a = new x0(this, context.getResources());
            this.f2719b = null;
            return;
        }
        g1 g1Var = new g1(this, context.getResources());
        this.f2718a = g1Var;
        Resources.Theme themeNewTheme = g1Var.newTheme();
        this.f2719b = themeNewTheme;
        themeNewTheme.setTo(context.getTheme());
    }

    public static boolean a(@g.n0 Context context) {
        return ((context instanceof v0) || (context.getResources() instanceof x0) || (context.getResources() instanceof g1) || !g1.d()) ? false : true;
    }

    public static Context b(@g.n0 Context context) {
        if (!a(context)) {
            return context;
        }
        synchronized (f2716c) {
            ArrayList<WeakReference<v0>> arrayList = f2717d;
            if (arrayList == null) {
                f2717d = new ArrayList<>();
            } else {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    WeakReference<v0> weakReference = f2717d.get(size);
                    if (weakReference == null || weakReference.get() == null) {
                        f2717d.remove(size);
                    }
                }
                for (int size2 = f2717d.size() - 1; size2 >= 0; size2--) {
                    WeakReference<v0> weakReference2 = f2717d.get(size2);
                    v0 v0Var = weakReference2 != null ? weakReference2.get() : null;
                    if (v0Var != null && v0Var.getBaseContext() == context) {
                        return v0Var;
                    }
                }
            }
            v0 v0Var2 = new v0(context);
            f2717d.add(new WeakReference<>(v0Var2));
            return v0Var2;
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return this.f2718a.getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return this.f2718a;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f2719b;
        return theme == null ? super.getTheme() : theme;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i10) {
        Resources.Theme theme = this.f2719b;
        if (theme == null) {
            super.setTheme(i10);
        } else {
            theme.applyStyle(i10, true);
        }
    }
}
