package xc;

import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import com.blankj.utilcode.util.i0;
import g.p0;
import hd.t;
import hd.u0;
import java.util.ArrayDeque;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f55132a = "TtmlRenderUtil";

    public static void a(Spannable spannable, int i10, int i11, g gVar, @p0 d dVar, Map<String, g> map, int i12) {
        d dVarE;
        int i13;
        if (gVar.k() != -1) {
            spannable.setSpan(new StyleSpan(gVar.k()), i10, i11, 33);
        }
        if (gVar.s()) {
            spannable.setSpan(new StrikethroughSpan(), i10, i11, 33);
        }
        if (gVar.t()) {
            spannable.setSpan(new UnderlineSpan(), i10, i11, 33);
        }
        if (gVar.p()) {
            uc.c.a(spannable, new ForegroundColorSpan(gVar.c()), i10, i11, 33);
        }
        if (gVar.o()) {
            uc.c.a(spannable, new BackgroundColorSpan(gVar.b()), i10, i11, 33);
        }
        if (gVar.d() != null) {
            uc.c.a(spannable, new TypefaceSpan(gVar.d()), i10, i11, 33);
        }
        if (gVar.n() != null) {
            b bVar = (b) hd.a.g(gVar.n());
            int i14 = bVar.f55048a;
            if (i14 == -1) {
                i14 = (i12 == 2 || i12 == 1) ? 3 : 1;
                i13 = 1;
            } else {
                i13 = bVar.f55049b;
            }
            int i15 = bVar.f55050c;
            if (i15 == -2) {
                i15 = 1;
            }
            uc.c.a(spannable, new uc.e(i14, i13, i15), i10, i11, 33);
        }
        int i16 = gVar.i();
        if (i16 == 2) {
            d dVarD = d(dVar, map);
            if (dVarD != null && (dVarE = e(dVarD, map)) != null) {
                if (dVarE.g() != 1 || dVarE.f(0).f55110b == null) {
                    t.i(f55132a, "Skipping rubyText node without exactly one text child.");
                } else {
                    String str = (String) u0.k(dVarE.f(0).f55110b);
                    g gVar2 = dVarD.f55114f;
                    spannable.setSpan(new uc.b(str, gVar2 != null ? gVar2.h() : -1), i10, i11, 33);
                }
            }
        } else if (i16 == 3 || i16 == 4) {
            spannable.setSpan(new a(), i10, i11, 33);
        }
        if (gVar.m()) {
            uc.c.a(spannable, new uc.a(), i10, i11, 33);
        }
        int iF = gVar.f();
        if (iF == 1) {
            uc.c.a(spannable, new AbsoluteSizeSpan((int) gVar.e(), true), i10, i11, 33);
        } else if (iF == 2) {
            uc.c.a(spannable, new RelativeSizeSpan(gVar.e()), i10, i11, 33);
        } else {
            if (iF != 3) {
                return;
            }
            uc.c.a(spannable, new RelativeSizeSpan(gVar.e() / 100.0f), i10, i11, 33);
        }
    }

    public static String b(String str) {
        return str.replaceAll("\r\n", "\n").replaceAll(" *\n *", "\n").replaceAll("\n", i0.f11861z).replaceAll("[ \t\\x0B\f\r]+", i0.f11861z);
    }

    public static void c(SpannableStringBuilder spannableStringBuilder) {
        int length = spannableStringBuilder.length() - 1;
        while (length >= 0 && spannableStringBuilder.charAt(length) == ' ') {
            length--;
        }
        if (length < 0 || spannableStringBuilder.charAt(length) == '\n') {
            return;
        }
        spannableStringBuilder.append('\n');
    }

    @p0
    public static d d(@p0 d dVar, Map<String, g> map) {
        while (dVar != null) {
            g gVarF = f(dVar.f55114f, dVar.l(), map);
            if (gVarF != null && gVarF.i() == 1) {
                return dVar;
            }
            dVar = dVar.f55118j;
        }
        return null;
    }

    @p0
    public static d e(d dVar, Map<String, g> map) {
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.push(dVar);
        while (!arrayDeque.isEmpty()) {
            d dVar2 = (d) arrayDeque.pop();
            g gVarF = f(dVar2.f55114f, dVar2.l(), map);
            if (gVarF != null && gVarF.i() == 3) {
                return dVar2;
            }
            for (int iG = dVar2.g() - 1; iG >= 0; iG--) {
                arrayDeque.push(dVar2.f(iG));
            }
        }
        return null;
    }

    @p0
    public static g f(@p0 g gVar, @p0 String[] strArr, Map<String, g> map) {
        int i10 = 0;
        if (gVar == null) {
            if (strArr == null) {
                return null;
            }
            if (strArr.length == 1) {
                return map.get(strArr[0]);
            }
            if (strArr.length > 1) {
                g gVar2 = new g();
                int length = strArr.length;
                while (i10 < length) {
                    gVar2.a(map.get(strArr[i10]));
                    i10++;
                }
                return gVar2;
            }
        } else {
            if (strArr != null && strArr.length == 1) {
                return gVar.a(map.get(strArr[0]));
            }
            if (strArr != null && strArr.length > 1) {
                int length2 = strArr.length;
                while (i10 < length2) {
                    gVar.a(map.get(strArr[i10]));
                    i10++;
                }
            }
        }
        return gVar;
    }
}
