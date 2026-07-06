package a;

import android.text.SpannableStringBuilder;
import java.util.Locale;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class te {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int f3018a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ye f3019a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f3020a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final ye f3016b = ff.c;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final String f3015a = Character.toString(8206);

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final String f3017b = Character.toString(8207);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final te f7492a = new te(false, 2, f3016b);
    public static final te b = new te(true, 2, f3016b);

    public te(boolean z, int i, ye yeVar) {
        this.f3020a = z;
        this.f3018a = i;
        this.f3019a = yeVar;
    }

    public static int a(CharSequence charSequence) {
        return new se(charSequence, false).d();
    }

    public static int b(CharSequence charSequence) {
        return new se(charSequence, false).e();
    }

    public static te c() {
        return new re().a();
    }

    public static boolean e(Locale locale) {
        return gf.b(locale) == 1;
    }

    public boolean d() {
        return (this.f3018a & 2) != 0;
    }

    public final String f(CharSequence charSequence, ye yeVar) {
        boolean zA = yeVar.a(charSequence, 0, charSequence.length());
        return (this.f3020a || !(zA || b(charSequence) == 1)) ? this.f3020a ? (!zA || b(charSequence) == -1) ? f3017b : "" : "" : f3015a;
    }

    public final String g(CharSequence charSequence, ye yeVar) {
        boolean zA = yeVar.a(charSequence, 0, charSequence.length());
        return (this.f3020a || !(zA || a(charSequence) == 1)) ? this.f3020a ? (!zA || a(charSequence) == -1) ? f3017b : "" : "" : f3015a;
    }

    public CharSequence h(CharSequence charSequence) {
        return i(charSequence, this.f3019a, true);
    }

    public CharSequence i(CharSequence charSequence, ye yeVar, boolean z) {
        if (charSequence == null) {
            return null;
        }
        boolean zA = yeVar.a(charSequence, 0, charSequence.length());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (d() && z) {
            spannableStringBuilder.append((CharSequence) g(charSequence, zA ? ff.b : ff.f6099a));
        }
        if (zA != this.f3020a) {
            spannableStringBuilder.append(zA ? (char) 8235 : (char) 8234);
            spannableStringBuilder.append(charSequence);
            spannableStringBuilder.append((char) 8236);
        } else {
            spannableStringBuilder.append(charSequence);
        }
        if (z) {
            spannableStringBuilder.append((CharSequence) f(charSequence, zA ? ff.b : ff.f6099a));
        }
        return spannableStringBuilder;
    }

    public String j(String str) {
        return k(str, this.f3019a, true);
    }

    public String k(String str, ye yeVar, boolean z) {
        if (str == null) {
            return null;
        }
        return i(str, yeVar, z).toString();
    }
}
