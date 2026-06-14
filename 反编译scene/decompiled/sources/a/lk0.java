package a;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import java.util.Locale;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class lk0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f6716a;

    public lk0(Context context) {
        f92.d(context, "context");
        this.f6716a = context;
    }

    public final String a() {
        String language = b().getLanguage();
        f92.c(language, "locale.language");
        return language;
    }

    public final Locale b() {
        Locale locale;
        String str;
        if (Build.VERSION.SDK_INT >= 24) {
            Resources resources = this.f6716a.getResources();
            f92.c(resources, "context.resources");
            Configuration configuration = resources.getConfiguration();
            f92.c(configuration, "context.resources.configuration");
            locale = configuration.getLocales().get(0);
            str = "context.resources.configuration.locales.get(0)";
        } else {
            Resources resources2 = this.f6716a.getResources();
            f92.c(resources2, "context.resources");
            locale = resources2.getConfiguration().locale;
            str = "context.resources.configuration.locale";
        }
        f92.c(locale, str);
        return locale;
    }

    public final boolean c() {
        return bc2.x(a(), "zh", false, 2, null);
    }
}
