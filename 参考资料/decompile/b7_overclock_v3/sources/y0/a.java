package y0;

import android.text.SpannableStringBuilder;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final l f56143d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final char f56144e = 8234;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final char f56145f = 8235;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final char f56146g = 8236;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final char f56147h = 8206;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final char f56148i = 8207;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f56149j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f56150k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f56151l = "";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f56152m = 2;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f56153n = 2;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final a f56154o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final a f56155p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f56156q = -1;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f56157r = 0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f56158s = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f56159a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f56160b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final l f56161c;

    public static class b {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final int f56165f = 1792;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final byte[] f56166g = new byte[1792];

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CharSequence f56167a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f56168b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f56169c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f56170d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public char f56171e;

        static {
            for (int i10 = 0; i10 < 1792; i10++) {
                f56166g[i10] = Character.getDirectionality(i10);
            }
        }

        public b(CharSequence charSequence, boolean z10) {
            this.f56167a = charSequence;
            this.f56168b = z10;
            this.f56169c = charSequence.length();
        }

        public static byte c(char c10) {
            return c10 < 1792 ? f56166g[c10] : Character.getDirectionality(c10);
        }

        public byte a() {
            char cCharAt = this.f56167a.charAt(this.f56170d - 1);
            this.f56171e = cCharAt;
            if (Character.isLowSurrogate(cCharAt)) {
                int iCodePointBefore = Character.codePointBefore(this.f56167a, this.f56170d);
                this.f56170d -= Character.charCount(iCodePointBefore);
                return Character.getDirectionality(iCodePointBefore);
            }
            this.f56170d--;
            byte bC = c(this.f56171e);
            if (!this.f56168b) {
                return bC;
            }
            char c10 = this.f56171e;
            return c10 == '>' ? h() : c10 == ';' ? f() : bC;
        }

        public byte b() {
            char cCharAt = this.f56167a.charAt(this.f56170d);
            this.f56171e = cCharAt;
            if (Character.isHighSurrogate(cCharAt)) {
                int iCodePointAt = Character.codePointAt(this.f56167a, this.f56170d);
                this.f56170d += Character.charCount(iCodePointAt);
                return Character.getDirectionality(iCodePointAt);
            }
            this.f56170d++;
            byte bC = c(this.f56171e);
            if (!this.f56168b) {
                return bC;
            }
            char c10 = this.f56171e;
            return c10 == '<' ? i() : c10 == '&' ? g() : bC;
        }

        public int d() {
            this.f56170d = 0;
            int i10 = 0;
            int i11 = 0;
            int i12 = 0;
            while (this.f56170d < this.f56169c && i10 == 0) {
                byte b10 = b();
                if (b10 != 0) {
                    if (b10 == 1 || b10 == 2) {
                        if (i12 == 0) {
                            return 1;
                        }
                    } else if (b10 != 9) {
                        switch (b10) {
                            case 14:
                            case 15:
                                i12++;
                                i11 = -1;
                                continue;
                            case 16:
                            case 17:
                                i12++;
                                i11 = 1;
                                continue;
                            case 18:
                                i12--;
                                i11 = 0;
                                continue;
                        }
                    }
                } else if (i12 == 0) {
                    return -1;
                }
                i10 = i12;
            }
            if (i10 == 0) {
                return 0;
            }
            if (i11 != 0) {
                return i11;
            }
            while (this.f56170d > 0) {
                switch (a()) {
                    case 14:
                    case 15:
                        if (i10 == i12) {
                            return -1;
                        }
                        break;
                    case 16:
                    case 17:
                        if (i10 == i12) {
                            return 1;
                        }
                        break;
                    case 18:
                        i12++;
                        continue;
                }
                i12--;
            }
            return 0;
        }

        public int e() {
            this.f56170d = this.f56169c;
            int i10 = 0;
            int i11 = 0;
            while (this.f56170d > 0) {
                byte bA = a();
                if (bA == 0) {
                    if (i10 == 0) {
                        return -1;
                    }
                    if (i11 == 0) {
                        i11 = i10;
                    }
                } else if (bA == 1 || bA == 2) {
                    if (i10 == 0) {
                        return 1;
                    }
                    if (i11 == 0) {
                        i11 = i10;
                    }
                } else if (bA != 9) {
                    switch (bA) {
                        case 14:
                        case 15:
                            if (i11 == i10) {
                                return -1;
                            }
                            i10--;
                            break;
                        case 16:
                        case 17:
                            if (i11 == i10) {
                                return 1;
                            }
                            i10--;
                            break;
                        case 18:
                            i10++;
                            break;
                        default:
                            if (i11 == 0) {
                                i11 = i10;
                            }
                            break;
                    }
                } else {
                    continue;
                }
            }
            return 0;
        }

        public final byte f() {
            char cCharAt;
            int i10 = this.f56170d;
            do {
                int i11 = this.f56170d;
                if (i11 <= 0) {
                    break;
                }
                CharSequence charSequence = this.f56167a;
                int i12 = i11 - 1;
                this.f56170d = i12;
                cCharAt = charSequence.charAt(i12);
                this.f56171e = cCharAt;
                if (cCharAt == '&') {
                    return (byte) 12;
                }
            } while (cCharAt != ';');
            this.f56170d = i10;
            this.f56171e = zc.f.f58382l;
            return (byte) 13;
        }

        public final byte g() {
            char cCharAt;
            do {
                int i10 = this.f56170d;
                if (i10 >= this.f56169c) {
                    return (byte) 12;
                }
                CharSequence charSequence = this.f56167a;
                this.f56170d = i10 + 1;
                cCharAt = charSequence.charAt(i10);
                this.f56171e = cCharAt;
            } while (cCharAt != ';');
            return (byte) 12;
        }

        public final byte h() {
            char cCharAt;
            int i10 = this.f56170d;
            while (true) {
                int i11 = this.f56170d;
                if (i11 <= 0) {
                    break;
                }
                CharSequence charSequence = this.f56167a;
                int i12 = i11 - 1;
                this.f56170d = i12;
                char cCharAt2 = charSequence.charAt(i12);
                this.f56171e = cCharAt2;
                if (cCharAt2 == '<') {
                    return (byte) 12;
                }
                if (cCharAt2 == '>') {
                    break;
                }
                if (cCharAt2 == '\"' || cCharAt2 == '\'') {
                    do {
                        int i13 = this.f56170d;
                        if (i13 > 0) {
                            CharSequence charSequence2 = this.f56167a;
                            int i14 = i13 - 1;
                            this.f56170d = i14;
                            cCharAt = charSequence2.charAt(i14);
                            this.f56171e = cCharAt;
                        }
                    } while (cCharAt != cCharAt2);
                }
            }
            this.f56170d = i10;
            this.f56171e = '>';
            return (byte) 13;
        }

        public final byte i() {
            char cCharAt;
            int i10 = this.f56170d;
            while (true) {
                int i11 = this.f56170d;
                if (i11 >= this.f56169c) {
                    this.f56170d = i10;
                    this.f56171e = '<';
                    return (byte) 13;
                }
                CharSequence charSequence = this.f56167a;
                this.f56170d = i11 + 1;
                char cCharAt2 = charSequence.charAt(i11);
                this.f56171e = cCharAt2;
                if (cCharAt2 == '>') {
                    return (byte) 12;
                }
                if (cCharAt2 == '\"' || cCharAt2 == '\'') {
                    do {
                        int i12 = this.f56170d;
                        if (i12 < this.f56169c) {
                            CharSequence charSequence2 = this.f56167a;
                            this.f56170d = i12 + 1;
                            cCharAt = charSequence2.charAt(i12);
                            this.f56171e = cCharAt;
                        }
                    } while (cCharAt != cCharAt2);
                }
            }
        }
    }

    static {
        l lVar = m.f56206c;
        f56143d = lVar;
        f56149j = Character.toString(f56147h);
        f56150k = Character.toString(f56148i);
        f56154o = new a(false, 2, lVar);
        f56155p = new a(true, 2, lVar);
    }

    public a(boolean z10, int i10, l lVar) {
        this.f56159a = z10;
        this.f56160b = i10;
        this.f56161c = lVar;
    }

    public static int a(CharSequence charSequence) {
        return new b(charSequence, false).d();
    }

    public static int b(CharSequence charSequence) {
        return new b(charSequence, false).e();
    }

    public static a c() {
        return new C0661a().a();
    }

    public static a d(Locale locale) {
        return new C0661a(locale).a();
    }

    public static a e(boolean z10) {
        return new C0661a(z10).a();
    }

    public static boolean j(Locale locale) {
        return n.b(locale) == 1;
    }

    public boolean f() {
        return (this.f56160b & 2) != 0;
    }

    public boolean g(CharSequence charSequence) {
        return this.f56161c.b(charSequence, 0, charSequence.length());
    }

    public boolean h(String str) {
        return g(str);
    }

    public boolean i() {
        return this.f56159a;
    }

    public final String k(CharSequence charSequence, l lVar) {
        boolean zB = lVar.b(charSequence, 0, charSequence.length());
        return (this.f56159a || !(zB || b(charSequence) == 1)) ? this.f56159a ? (!zB || b(charSequence) == -1) ? f56150k : "" : "" : f56149j;
    }

    public final String l(CharSequence charSequence, l lVar) {
        boolean zB = lVar.b(charSequence, 0, charSequence.length());
        return (this.f56159a || !(zB || a(charSequence) == 1)) ? this.f56159a ? (!zB || a(charSequence) == -1) ? f56150k : "" : "" : f56149j;
    }

    public CharSequence m(CharSequence charSequence) {
        return o(charSequence, this.f56161c, true);
    }

    public CharSequence n(CharSequence charSequence, l lVar) {
        return o(charSequence, lVar, true);
    }

    public CharSequence o(CharSequence charSequence, l lVar, boolean z10) {
        if (charSequence == null) {
            return null;
        }
        boolean zB = lVar.b(charSequence, 0, charSequence.length());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (f() && z10) {
            spannableStringBuilder.append((CharSequence) l(charSequence, zB ? m.f56205b : m.f56204a));
        }
        if (zB != this.f56159a) {
            spannableStringBuilder.append(zB ? f56145f : f56144e);
            spannableStringBuilder.append(charSequence);
            spannableStringBuilder.append(f56146g);
        } else {
            spannableStringBuilder.append(charSequence);
        }
        if (z10) {
            spannableStringBuilder.append((CharSequence) k(charSequence, zB ? m.f56205b : m.f56204a));
        }
        return spannableStringBuilder;
    }

    public CharSequence p(CharSequence charSequence, boolean z10) {
        return o(charSequence, this.f56161c, z10);
    }

    public String q(String str) {
        return s(str, this.f56161c, true);
    }

    public String r(String str, l lVar) {
        return s(str, lVar, true);
    }

    public String s(String str, l lVar, boolean z10) {
        if (str == null) {
            return null;
        }
        return o(str, lVar, z10).toString();
    }

    public String t(String str, boolean z10) {
        return s(str, this.f56161c, z10);
    }

    /* JADX INFO: renamed from: y0.a$a, reason: collision with other inner class name */
    public static final class C0661a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f56162a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f56163b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public l f56164c;

        public C0661a() {
            c(a.j(Locale.getDefault()));
        }

        public static a b(boolean z10) {
            return z10 ? a.f56155p : a.f56154o;
        }

        public a a() {
            return (this.f56163b == 2 && this.f56164c == a.f56143d) ? b(this.f56162a) : new a(this.f56162a, this.f56163b, this.f56164c);
        }

        public final void c(boolean z10) {
            this.f56162a = z10;
            this.f56164c = a.f56143d;
            this.f56163b = 2;
        }

        public C0661a d(l lVar) {
            this.f56164c = lVar;
            return this;
        }

        public C0661a e(boolean z10) {
            if (z10) {
                this.f56163b |= 2;
            } else {
                this.f56163b &= -3;
            }
            return this;
        }

        public C0661a(boolean z10) {
            c(z10);
        }

        public C0661a(Locale locale) {
            c(a.j(locale));
        }
    }
}
