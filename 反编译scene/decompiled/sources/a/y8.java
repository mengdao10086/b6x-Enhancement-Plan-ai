package a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class y8 extends Resources {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f7956a = false;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final WeakReference<Context> f3667a;

    public y8(Context context, Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.f3667a = new WeakReference<>(context);
    }

    public static boolean a() {
        return f7956a;
    }

    public static boolean b() {
        return a() && Build.VERSION.SDK_INT <= 20;
    }

    public final Drawable c(int i) {
        return super.getDrawable(i);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i) {
        Context context = this.f3667a.get();
        return context != null ? d8.h().t(context, this, i) : super.getDrawable(i);
    }
}
