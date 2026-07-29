package l;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.view.LayoutInflater;
import androidx.appcompat.R;
import g.d1;
import g.u;
import g.v0;

/* JADX INFO: loaded from: classes2.dex */
public class d extends ContextWrapper {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Configuration f39266f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f39267a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Resources.Theme f39268b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LayoutInflater f39269c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Configuration f39270d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Resources f39271e;

    @v0(17)
    public static class a {
        @u
        public static Context a(d dVar, Configuration configuration) {
            return dVar.createConfigurationContext(configuration);
        }
    }

    public d() {
        super(null);
    }

    @v0(26)
    public static boolean e(Configuration configuration) {
        if (configuration == null) {
            return true;
        }
        if (f39266f == null) {
            Configuration configuration2 = new Configuration();
            configuration2.fontScale = 0.0f;
            f39266f = configuration2;
        }
        return configuration.equals(f39266f);
    }

    public void a(Configuration configuration) {
        if (this.f39271e != null) {
            throw new IllegalStateException("getResources() or getAssets() has already been called");
        }
        if (this.f39270d != null) {
            throw new IllegalStateException("Override configuration has already been set");
        }
        this.f39270d = new Configuration(configuration);
    }

    @Override // android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public final Resources b() {
        if (this.f39271e == null) {
            Configuration configuration = this.f39270d;
            if (configuration == null || (Build.VERSION.SDK_INT >= 26 && e(configuration))) {
                this.f39271e = super.getResources();
            } else {
                this.f39271e = a.a(this, this.f39270d).getResources();
            }
        }
        return this.f39271e;
    }

    public int c() {
        return this.f39267a;
    }

    public final void d() {
        boolean z10 = this.f39268b == null;
        if (z10) {
            this.f39268b = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f39268b.setTo(theme);
            }
        }
        f(this.f39268b, this.f39267a, z10);
    }

    public void f(Resources.Theme theme, int i10, boolean z10) {
        theme.applyStyle(i10, true);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return getResources().getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return b();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.f39269c == null) {
            this.f39269c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.f39269c;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f39268b;
        if (theme != null) {
            return theme;
        }
        if (this.f39267a == 0) {
            this.f39267a = R.style.Theme_AppCompat_Light;
        }
        d();
        return this.f39268b;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i10) {
        if (this.f39267a != i10) {
            this.f39267a = i10;
            d();
        }
    }

    public d(Context context, @d1 int i10) {
        super(context);
        this.f39267a = i10;
    }

    public d(Context context, Resources.Theme theme) {
        super(context);
        this.f39268b = theme;
    }
}
