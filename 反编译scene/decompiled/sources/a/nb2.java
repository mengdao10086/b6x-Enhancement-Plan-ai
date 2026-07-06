package a;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class nb2 implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final kb2 f6897a = new kb2(null);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Pattern f2074a;

    /* JADX WARN: Illegal instructions before constructor call */
    public nb2(String str) {
        f92.d(str, "pattern");
        Pattern patternCompile = Pattern.compile(str);
        f92.c(patternCompile, "Pattern.compile(pattern)");
        this(patternCompile);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public nb2(String str, pb2 pb2Var) {
        f92.d(str, "pattern");
        f92.d(pb2Var, "option");
        Pattern patternCompile = Pattern.compile(str, f6897a.b(pb2Var.a()));
        f92.c(patternCompile, "Pattern.compile(pattern,…nicodeCase(option.value))");
        this(patternCompile);
    }

    public nb2(Pattern pattern) {
        f92.d(pattern, "nativePattern");
        this.f2074a = pattern;
    }

    public static /* synthetic */ gb2 c(nb2 nb2Var, CharSequence charSequence, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return nb2Var.b(charSequence, i);
    }

    public static /* synthetic */ pa2 e(nb2 nb2Var, CharSequence charSequence, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return nb2Var.d(charSequence, i);
    }

    public final boolean a(CharSequence charSequence) {
        f92.d(charSequence, "input");
        return this.f2074a.matcher(charSequence).find();
    }

    public final gb2 b(CharSequence charSequence, int i) {
        f92.d(charSequence, "input");
        Matcher matcher = this.f2074a.matcher(charSequence);
        f92.c(matcher, "nativePattern.matcher(input)");
        return ob2.c(matcher, i, charSequence);
    }

    public final pa2<gb2> d(CharSequence charSequence, int i) {
        f92.d(charSequence, "input");
        if (i >= 0 && i <= charSequence.length()) {
            return ta2.c(new lb2(this, charSequence, i), mb2.f6790a);
        }
        throw new IndexOutOfBoundsException("Start index out of bounds: " + i + ", input length: " + charSequence.length());
    }

    public final boolean f(CharSequence charSequence) {
        f92.d(charSequence, "input");
        return this.f2074a.matcher(charSequence).matches();
    }

    public final String g(CharSequence charSequence, String str) {
        f92.d(charSequence, "input");
        f92.d(str, "replacement");
        String strReplaceAll = this.f2074a.matcher(charSequence).replaceAll(str);
        f92.c(strReplaceAll, "nativePattern.matcher(in…).replaceAll(replacement)");
        return strReplaceAll;
    }

    public final List<String> h(CharSequence charSequence, int i) {
        f92.d(charSequence, "input");
        int iEnd = 0;
        if (!(i >= 0)) {
            throw new IllegalArgumentException(("Limit must be non-negative, but was " + i + '.').toString());
        }
        Matcher matcher = this.f2074a.matcher(charSequence);
        if (!matcher.find() || i == 1) {
            return x42.b(charSequence.toString());
        }
        ArrayList arrayList = new ArrayList(i > 0 ? ga2.d(i, 10) : 10);
        int i2 = i - 1;
        do {
            arrayList.add(charSequence.subSequence(iEnd, matcher.start()).toString());
            iEnd = matcher.end();
            if (i2 >= 0 && arrayList.size() == i2) {
                break;
            }
        } while (matcher.find());
        arrayList.add(charSequence.subSequence(iEnd, charSequence.length()).toString());
        return arrayList;
    }

    public String toString() {
        String string = this.f2074a.toString();
        f92.c(string, "nativePattern.toString()");
        return string;
    }
}
