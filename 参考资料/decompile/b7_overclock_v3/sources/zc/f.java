package zc;

import android.graphics.Color;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import com.blankj.utilcode.util.i0;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import g.p0;
import hd.c0;
import hd.t;
import hd.u0;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import qc.b;
import zc.f;

/* JADX INFO: loaded from: classes3.dex */
public final class f {
    public static final int A = 2;
    public static final float B = 0.5f;
    public static final String C = "WebvttCueParser";
    public static final Map<String, Integer> D;
    public static final Map<String, Integer> E;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f58371a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f58372b = 2;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f58373c = 3;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f58374d = 4;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f58375e = 5;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Pattern f58376f = Pattern.compile("^(\\S+)\\s+-->\\s+(\\S+)(.*)?$");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Pattern f58377g = Pattern.compile("(\\S+?):(\\S+)");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final char f58378h = '<';

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final char f58379i = '>';

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final char f58380j = '/';

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final char f58381k = '&';

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final char f58382l = ';';

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final char f58383m = ' ';

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f58384n = "lt";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f58385o = "gt";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String f58386p = "amp";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String f58387q = "nbsp";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String f58388r = "b";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final String f58389s = "c";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final String f58390t = "i";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final String f58391u = "lang";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final String f58392v = "ruby";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final String f58393w = "rt";

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final String f58394x = "u";

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final String f58395y = "v";

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f58396z = 1;

    public static class b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Comparator<b> f58397c = new Comparator() { // from class: zc.g
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return f.b.e((f.b) obj, (f.b) obj2);
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c f58398a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f58399b;

        public static /* synthetic */ int e(b bVar, b bVar2) {
            return Integer.compare(bVar.f58398a.f58401b, bVar2.f58398a.f58401b);
        }

        public b(c cVar, int i10) {
            this.f58398a = cVar;
            this.f58399b = i10;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f58400a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f58401b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f58402c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Set<String> f58403d;

        public c(String str, int i10, String str2, Set<String> set) {
            this.f58401b = i10;
            this.f58400a = str;
            this.f58402c = str2;
            this.f58403d = set;
        }

        public static c a(String str, int i10) {
            String str2;
            String strTrim = str.trim();
            hd.a.a(!strTrim.isEmpty());
            int iIndexOf = strTrim.indexOf(i0.f11861z);
            if (iIndexOf == -1) {
                str2 = "";
            } else {
                String strTrim2 = strTrim.substring(iIndexOf).trim();
                strTrim = strTrim.substring(0, iIndexOf);
                str2 = strTrim2;
            }
            String[] strArrN1 = u0.n1(strTrim, "\\.");
            String str3 = strArrN1[0];
            HashSet hashSet = new HashSet();
            for (int i11 = 1; i11 < strArrN1.length; i11++) {
                hashSet.add(strArrN1[i11]);
            }
            return new c(str3, i10, str2, hashSet);
        }

        public static c b() {
            return new c("", 0, "", Collections.emptySet());
        }
    }

    public static final class d implements Comparable<d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f58404a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final zc.d f58405b;

        public d(int i10, zc.d dVar) {
            this.f58404a = i10;
            this.f58405b = dVar;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public int compareTo(d dVar) {
            return Integer.compare(this.f58404a, dVar.f58404a);
        }
    }

    public static final class e {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public CharSequence f58408c;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f58406a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f58407b = 0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f58409d = 2;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f58410e = -3.4028235E38f;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f58411f = 1;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f58412g = 0;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public float f58413h = -3.4028235E38f;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f58414i = Integer.MIN_VALUE;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public float f58415j = 1.0f;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f58416k = Integer.MIN_VALUE;

        public static float b(float f10, int i10) {
            if (f10 == -3.4028235E38f || i10 != 0 || (f10 >= 0.0f && f10 <= 1.0f)) {
                return f10 != -3.4028235E38f ? f10 : i10 == 0 ? 1.0f : -3.4028235E38f;
            }
            return 1.0f;
        }

        @p0
        public static Layout.Alignment c(int i10) {
            if (i10 != 1) {
                if (i10 == 2) {
                    return Layout.Alignment.ALIGN_CENTER;
                }
                if (i10 != 3) {
                    if (i10 != 4) {
                        if (i10 != 5) {
                            t.n(f.C, "Unknown textAlignment: " + i10);
                            return null;
                        }
                    }
                }
                return Layout.Alignment.ALIGN_OPPOSITE;
            }
            return Layout.Alignment.ALIGN_NORMAL;
        }

        public static float d(int i10, float f10) {
            if (i10 == 0) {
                return 1.0f - f10;
            }
            if (i10 == 1) {
                return f10 <= 0.5f ? f10 * 2.0f : (1.0f - f10) * 2.0f;
            }
            if (i10 == 2) {
                return f10;
            }
            throw new IllegalStateException(String.valueOf(i10));
        }

        public static float e(int i10) {
            if (i10 != 4) {
                return i10 != 5 ? 0.5f : 1.0f;
            }
            return 0.0f;
        }

        public static int f(int i10) {
            if (i10 == 1) {
                return 0;
            }
            if (i10 == 3) {
                return 2;
            }
            if (i10 != 4) {
                return i10 != 5 ? 1 : 2;
            }
            return 0;
        }

        public zc.e a() {
            return new zc.e(g().a(), this.f58406a, this.f58407b);
        }

        public b.c g() {
            float fE = this.f58413h;
            if (fE == -3.4028235E38f) {
                fE = e(this.f58409d);
            }
            int iF = this.f58414i;
            if (iF == Integer.MIN_VALUE) {
                iF = f(this.f58409d);
            }
            b.c cVarC = new b.c().A(c(this.f58409d)).t(b(this.f58410e, this.f58411f), this.f58411f).u(this.f58412g).v(fE).w(iF).y(Math.min(this.f58415j, d(iF, fE))).C(this.f58416k);
            CharSequence charSequence = this.f58408c;
            if (charSequence != null) {
                cVarC.z(charSequence);
            }
            return cVarC;
        }
    }

    static {
        HashMap map = new HashMap();
        map.put("white", Integer.valueOf(Color.rgb(255, 255, 255)));
        map.put("lime", Integer.valueOf(Color.rgb(0, 255, 0)));
        map.put("cyan", Integer.valueOf(Color.rgb(0, 255, 255)));
        map.put("red", Integer.valueOf(Color.rgb(255, 0, 0)));
        map.put("yellow", Integer.valueOf(Color.rgb(255, 255, 0)));
        map.put("magenta", Integer.valueOf(Color.rgb(255, 0, 255)));
        map.put("blue", Integer.valueOf(Color.rgb(0, 0, 255)));
        map.put("black", Integer.valueOf(Color.rgb(0, 0, 0)));
        D = Collections.unmodifiableMap(map);
        HashMap map2 = new HashMap();
        map2.put("bg_white", Integer.valueOf(Color.rgb(255, 255, 255)));
        map2.put("bg_lime", Integer.valueOf(Color.rgb(0, 255, 0)));
        map2.put("bg_cyan", Integer.valueOf(Color.rgb(0, 255, 255)));
        map2.put("bg_red", Integer.valueOf(Color.rgb(255, 0, 0)));
        map2.put("bg_yellow", Integer.valueOf(Color.rgb(255, 255, 0)));
        map2.put("bg_magenta", Integer.valueOf(Color.rgb(255, 0, 255)));
        map2.put("bg_blue", Integer.valueOf(Color.rgb(0, 0, 255)));
        map2.put("bg_black", Integer.valueOf(Color.rgb(0, 0, 0)));
        E = Collections.unmodifiableMap(map2);
    }

    public static void a(SpannableStringBuilder spannableStringBuilder, Set<String> set, int i10, int i11) {
        for (String str : set) {
            Map<String, Integer> map = D;
            if (map.containsKey(str)) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(map.get(str).intValue()), i10, i11, 33);
            } else {
                Map<String, Integer> map2 = E;
                if (map2.containsKey(str)) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(map2.get(str).intValue()), i10, i11, 33);
                }
            }
        }
    }

    public static void b(String str, SpannableStringBuilder spannableStringBuilder) {
        str.hashCode();
        switch (str) {
            case "gt":
                spannableStringBuilder.append('>');
                break;
            case "lt":
                spannableStringBuilder.append('<');
                break;
            case "amp":
                spannableStringBuilder.append('&');
                break;
            case "nbsp":
                spannableStringBuilder.append(f58383m);
                break;
            default:
                t.n(C, "ignoring unsupported entity: '&" + str + ";'");
                break;
        }
    }

    public static void c(SpannableStringBuilder spannableStringBuilder, @p0 String str, c cVar, List<b> list, List<zc.d> list2) {
        int i10 = i(list2, str, cVar);
        ArrayList arrayList = new ArrayList(list.size());
        arrayList.addAll(list);
        Collections.sort(arrayList, b.f58397c);
        int i11 = cVar.f58401b;
        int length = 0;
        for (int i12 = 0; i12 < arrayList.size(); i12++) {
            if (f58393w.equals(((b) arrayList.get(i12)).f58398a.f58400a)) {
                b bVar = (b) arrayList.get(i12);
                int iG = g(i(list2, str, bVar.f58398a), i10, 1);
                int i13 = bVar.f58398a.f58401b - length;
                int i14 = bVar.f58399b - length;
                CharSequence charSequenceSubSequence = spannableStringBuilder.subSequence(i13, i14);
                spannableStringBuilder.delete(i13, i14);
                spannableStringBuilder.setSpan(new uc.b(charSequenceSubSequence.toString(), iG), i11, i13, 33);
                length += charSequenceSubSequence.length();
                i11 = i13;
            }
        }
    }

    public static void d(@p0 String str, c cVar, List<b> list, SpannableStringBuilder spannableStringBuilder, List<zc.d> list2) {
        int i10;
        int length;
        i10 = cVar.f58401b;
        length = spannableStringBuilder.length();
        String str2 = cVar.f58400a;
        str2.hashCode();
        switch (str2) {
            case "":
            case "v":
            case "lang":
                break;
            case "b":
                spannableStringBuilder.setSpan(new StyleSpan(1), i10, length, 33);
                break;
            case "c":
                a(spannableStringBuilder, cVar.f58403d, i10, length);
                break;
            case "i":
                spannableStringBuilder.setSpan(new StyleSpan(2), i10, length, 33);
                break;
            case "u":
                spannableStringBuilder.setSpan(new UnderlineSpan(), i10, length, 33);
                break;
            case "ruby":
                c(spannableStringBuilder, str, cVar, list, list2);
                break;
            default:
                return;
        }
        List<d> listH = h(list2, str, cVar);
        for (int i11 = 0; i11 < listH.size(); i11++) {
            e(spannableStringBuilder, listH.get(i11).f58405b, i10, length);
        }
    }

    public static void e(SpannableStringBuilder spannableStringBuilder, zc.d dVar, int i10, int i11) {
        if (dVar == null) {
            return;
        }
        if (dVar.i() != -1) {
            uc.c.a(spannableStringBuilder, new StyleSpan(dVar.i()), i10, i11, 33);
        }
        if (dVar.l()) {
            spannableStringBuilder.setSpan(new StrikethroughSpan(), i10, i11, 33);
        }
        if (dVar.m()) {
            spannableStringBuilder.setSpan(new UnderlineSpan(), i10, i11, 33);
        }
        if (dVar.k()) {
            uc.c.a(spannableStringBuilder, new ForegroundColorSpan(dVar.c()), i10, i11, 33);
        }
        if (dVar.j()) {
            uc.c.a(spannableStringBuilder, new BackgroundColorSpan(dVar.a()), i10, i11, 33);
        }
        if (dVar.d() != null) {
            uc.c.a(spannableStringBuilder, new TypefaceSpan(dVar.d()), i10, i11, 33);
        }
        int iF = dVar.f();
        if (iF == 1) {
            uc.c.a(spannableStringBuilder, new AbsoluteSizeSpan((int) dVar.e(), true), i10, i11, 33);
        } else if (iF == 2) {
            uc.c.a(spannableStringBuilder, new RelativeSizeSpan(dVar.e()), i10, i11, 33);
        } else if (iF == 3) {
            uc.c.a(spannableStringBuilder, new RelativeSizeSpan(dVar.e() / 100.0f), i10, i11, 33);
        }
        if (dVar.b()) {
            spannableStringBuilder.setSpan(new uc.a(), i10, i11, 33);
        }
    }

    public static int f(String str, int i10) {
        int iIndexOf = str.indexOf(62, i10);
        return iIndexOf == -1 ? str.length() : iIndexOf + 1;
    }

    public static int g(int i10, int i11, int i12) {
        if (i10 != -1) {
            return i10;
        }
        if (i11 != -1) {
            return i11;
        }
        if (i12 != -1) {
            return i12;
        }
        throw new IllegalArgumentException();
    }

    public static List<d> h(List<zc.d> list, @p0 String str, c cVar) {
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < list.size(); i10++) {
            zc.d dVar = list.get(i10);
            int iH = dVar.h(str, cVar.f58400a, cVar.f58403d, cVar.f58402c);
            if (iH > 0) {
                arrayList.add(new d(iH, dVar));
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    public static int i(List<zc.d> list, @p0 String str, c cVar) {
        List<d> listH = h(list, str, cVar);
        for (int i10 = 0; i10 < listH.size(); i10++) {
            zc.d dVar = listH.get(i10).f58405b;
            if (dVar.g() != -1) {
                return dVar.g();
            }
        }
        return -1;
    }

    public static String j(String str) {
        String strTrim = str.trim();
        hd.a.a(!strTrim.isEmpty());
        return u0.o1(strTrim, "[ \\.]")[0];
    }

    public static boolean k(String str) {
        str.hashCode();
        switch (str) {
            case "b":
            case "c":
            case "i":
            case "u":
            case "v":
            case "rt":
            case "lang":
            case "ruby":
                return true;
            default:
                return false;
        }
    }

    public static qc.b l(CharSequence charSequence) {
        e eVar = new e();
        eVar.f58408c = charSequence;
        return eVar.g().a();
    }

    @p0
    public static zc.e m(c0 c0Var, List<zc.d> list) {
        String strQ = c0Var.q();
        if (strQ == null) {
            return null;
        }
        Pattern pattern = f58376f;
        Matcher matcher = pattern.matcher(strQ);
        if (matcher.matches()) {
            return n(null, matcher, c0Var, list);
        }
        String strQ2 = c0Var.q();
        if (strQ2 == null) {
            return null;
        }
        Matcher matcher2 = pattern.matcher(strQ2);
        if (matcher2.matches()) {
            return n(strQ.trim(), matcher2, c0Var, list);
        }
        return null;
    }

    @p0
    public static zc.e n(@p0 String str, Matcher matcher, c0 c0Var, List<zc.d> list) {
        e eVar = new e();
        try {
            eVar.f58406a = i.d((String) hd.a.g(matcher.group(1)));
            eVar.f58407b = i.d((String) hd.a.g(matcher.group(2)));
            p((String) hd.a.g(matcher.group(3)), eVar);
            StringBuilder sb2 = new StringBuilder();
            String strQ = c0Var.q();
            while (!TextUtils.isEmpty(strQ)) {
                if (sb2.length() > 0) {
                    sb2.append("\n");
                }
                sb2.append(strQ.trim());
                strQ = c0Var.q();
            }
            eVar.f58408c = q(str, sb2.toString(), list);
            return eVar.a();
        } catch (NumberFormatException unused) {
            t.n(C, "Skipping cue with bad header: " + matcher.group());
            return null;
        }
    }

    public static b.c o(String str) {
        e eVar = new e();
        p(str, eVar);
        return eVar.g();
    }

    public static void p(String str, e eVar) {
        Matcher matcher = f58377g.matcher(str);
        while (matcher.find()) {
            String str2 = (String) hd.a.g(matcher.group(1));
            String str3 = (String) hd.a.g(matcher.group(2));
            try {
                if ("line".equals(str2)) {
                    s(str3, eVar);
                } else if ("align".equals(str2)) {
                    eVar.f58409d = v(str3);
                } else if (CommonNetImpl.POSITION.equals(str2)) {
                    u(str3, eVar);
                } else if ("size".equals(str2)) {
                    eVar.f58415j = i.c(str3);
                } else if ("vertical".equals(str2)) {
                    eVar.f58416k = w(str3);
                } else {
                    t.n(C, "Unknown cue setting " + str2 + ":" + str3);
                }
            } catch (NumberFormatException unused) {
                t.n(C, "Skipping bad cue setting: " + matcher.group());
            }
        }
    }

    public static SpannedString q(@p0 String str, String str2, List<zc.d> list) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        ArrayDeque arrayDeque = new ArrayDeque();
        ArrayList arrayList = new ArrayList();
        int i10 = 0;
        while (i10 < str2.length()) {
            char cCharAt = str2.charAt(i10);
            if (cCharAt == '&') {
                i10++;
                int iIndexOf = str2.indexOf(59, i10);
                int iIndexOf2 = str2.indexOf(32, i10);
                if (iIndexOf == -1) {
                    iIndexOf = iIndexOf2;
                } else if (iIndexOf2 != -1) {
                    iIndexOf = Math.min(iIndexOf, iIndexOf2);
                }
                if (iIndexOf != -1) {
                    b(str2.substring(i10, iIndexOf), spannableStringBuilder);
                    if (iIndexOf == iIndexOf2) {
                        spannableStringBuilder.append((CharSequence) i0.f11861z);
                    }
                    i10 = iIndexOf + 1;
                } else {
                    spannableStringBuilder.append(cCharAt);
                }
            } else if (cCharAt != '<') {
                spannableStringBuilder.append(cCharAt);
                i10++;
            } else {
                int iF = i10 + 1;
                if (iF < str2.length()) {
                    boolean z10 = str2.charAt(iF) == '/';
                    iF = f(str2, iF);
                    int i11 = iF - 2;
                    boolean z11 = str2.charAt(i11) == '/';
                    int i12 = i10 + (z10 ? 2 : 1);
                    if (!z11) {
                        i11 = iF - 1;
                    }
                    String strSubstring = str2.substring(i12, i11);
                    if (!strSubstring.trim().isEmpty()) {
                        String strJ = j(strSubstring);
                        if (k(strJ)) {
                            if (z10) {
                                while (!arrayDeque.isEmpty()) {
                                    c cVar = (c) arrayDeque.pop();
                                    d(str, cVar, arrayList, spannableStringBuilder, list);
                                    if (arrayDeque.isEmpty()) {
                                        arrayList.clear();
                                    } else {
                                        arrayList.add(new b(cVar, spannableStringBuilder.length()));
                                    }
                                    if (cVar.f58400a.equals(strJ)) {
                                        break;
                                    }
                                }
                            } else if (!z11) {
                                arrayDeque.push(c.a(strSubstring, spannableStringBuilder.length()));
                            }
                        }
                    }
                }
                i10 = iF;
            }
        }
        while (!arrayDeque.isEmpty()) {
            d(str, (c) arrayDeque.pop(), arrayList, spannableStringBuilder, list);
        }
        d(str, c.b(), Collections.emptyList(), spannableStringBuilder, list);
        return SpannedString.valueOf(spannableStringBuilder);
    }

    public static int r(String str) {
        str.hashCode();
        switch (str) {
            case "center":
            case "middle":
                return 1;
            case "end":
                return 2;
            case "start":
                return 0;
            default:
                t.n(C, "Invalid anchor value: " + str);
                return Integer.MIN_VALUE;
        }
    }

    public static void s(String str, e eVar) {
        int iIndexOf = str.indexOf(44);
        if (iIndexOf != -1) {
            eVar.f58412g = r(str.substring(iIndexOf + 1));
            str = str.substring(0, iIndexOf);
        }
        if (str.endsWith(i6.a.f31863g)) {
            eVar.f58410e = i.c(str);
            eVar.f58411f = 0;
        } else {
            eVar.f58410e = Integer.parseInt(str);
            eVar.f58411f = 1;
        }
    }

    public static int t(String str) {
        str.hashCode();
        switch (str) {
            case "line-left":
            case "start":
                return 0;
            case "center":
            case "middle":
                return 1;
            case "line-right":
            case "end":
                return 2;
            default:
                t.n(C, "Invalid anchor value: " + str);
                return Integer.MIN_VALUE;
        }
    }

    public static void u(String str, e eVar) {
        int iIndexOf = str.indexOf(44);
        if (iIndexOf != -1) {
            eVar.f58414i = t(str.substring(iIndexOf + 1));
            str = str.substring(0, iIndexOf);
        }
        eVar.f58413h = i.c(str);
    }

    public static int v(String str) {
        str.hashCode();
        switch (str) {
            case "center":
            case "middle":
                return 2;
            case "end":
                return 3;
            case "left":
                return 4;
            case "right":
                return 5;
            case "start":
                return 1;
            default:
                t.n(C, "Invalid alignment value: " + str);
                return 2;
        }
    }

    public static int w(String str) {
        str.hashCode();
        if (str.equals("lr")) {
            return 2;
        }
        if (str.equals("rl")) {
            return 1;
        }
        t.n(C, "Invalid 'vertical' value: " + str);
        return Integer.MIN_VALUE;
    }
}
