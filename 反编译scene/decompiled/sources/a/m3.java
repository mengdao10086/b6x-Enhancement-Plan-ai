package a;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.view.LayoutInflater;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class m3 extends ContextWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6763a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Configuration f1882a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Resources.Theme f1883a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Resources f1884a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public LayoutInflater f1885a;

    public m3(Context context, int i) {
        super(context);
        this.f6763a = i;
    }

    public m3(Context context, Resources.Theme theme) {
        super(context);
        this.f1883a = theme;
    }

    public void a(Configuration configuration) {
        if (this.f1884a != null) {
            throw new IllegalStateException("getResources() or getAssets() has already been called");
        }
        if (this.f1882a != null) {
            throw new IllegalStateException("Override configuration has already been set");
        }
        this.f1882a = new Configuration(configuration);
    }

    @Override // android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public final Resources b() {
        Resources resources;
        if (this.f1884a == null) {
            Configuration configuration = this.f1882a;
            if (configuration == null) {
                resources = super.getResources();
            } else if (Build.VERSION.SDK_INT >= 17) {
                resources = createConfigurationContext(configuration).getResources();
            } else {
                Resources resources2 = super.getResources();
                Configuration configuration2 = new Configuration(resources2.getConfiguration());
                configuration2.updateFrom(this.f1882a);
                this.f1884a = new Resources(resources2.getAssets(), resources2.getDisplayMetrics(), configuration2);
            }
            this.f1884a = resources;
        }
        return this.f1884a;
    }

    public int c() {
        return this.f6763a;
    }

    public final void d() {
        boolean z = this.f1883a == null;
        if (z) {
            this.f1883a = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f1883a.setTo(theme);
            }
        }
        e(this.f1883a, this.f6763a, z);
    }

    public void e(Resources.Theme theme, int i, boolean z) {
        theme.applyStyle(i, true);
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
        if (this.f1885a == null) {
            this.f1885a = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.f1885a;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f1883a;
        if (theme != null) {
            return theme;
        }
        if (this.f6763a == 0) {
            this.f6763a = b0.Theme_AppCompat_Light;
        }
        d();
        return this.f1883a;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        if (this.f6763a != i) {
            this.f6763a = i;
            d();
        }
    }
}
