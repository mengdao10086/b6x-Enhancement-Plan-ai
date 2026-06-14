package a;

import android.os.Build;
import java.util.Locale;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class rj0 extends g92 implements v72<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final rj0 f7306a = new rj0();

    public rj0() {
        super(0);
    }

    public final boolean a() {
        String str = Build.MANUFACTURER;
        f92.c(str, "Build.MANUFACTURER");
        Locale locale = Locale.ENGLISH;
        f92.c(locale, "Locale.ENGLISH");
        if (str == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String lowerCase = str.toLowerCase(locale);
        f92.c(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        return f92.a(lowerCase, "xiaomi") && Build.VERSION.SDK_INT == 35;
    }

    @Override // a.v72
    public /* bridge */ /* synthetic */ Boolean i() {
        return Boolean.valueOf(a());
    }
}
