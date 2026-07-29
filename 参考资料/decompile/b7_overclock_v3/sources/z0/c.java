package z0;

import android.os.Build;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.text.util.Linkify;
import android.webkit.WebView;
import android.widget.TextView;
import androidx.annotation.RestrictTo;
import androidx.core.util.m;
import com.just.agentweb.DefaultWebClient;
import g.n0;
import g.p0;
import g.u;
import g.v0;
import java.io.UnsupportedEncodingException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import z0.c;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f57668a = new String[0];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Comparator<b> f57669b = new Comparator() { // from class: z0.b
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return c.o((c.b) obj, (c.b) obj2);
        }
    };

    @v0(24)
    public static class a {
        @u
        public static void a(TextView textView, Pattern pattern, String str, String[] strArr, Linkify.MatchFilter matchFilter, Linkify.TransformFilter transformFilter) {
            Linkify.addLinks(textView, pattern, str, strArr, matchFilter, transformFilter);
        }

        @u
        public static boolean b(Spannable spannable, Pattern pattern, String str, String[] strArr, Linkify.MatchFilter matchFilter, Linkify.TransformFilter transformFilter) {
            return Linkify.addLinks(spannable, pattern, str, strArr, matchFilter, transformFilter);
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public URLSpan f57670a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f57671b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f57672c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f57673d;
    }

    /* JADX INFO: renamed from: z0.c$c, reason: collision with other inner class name */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface InterfaceC0682c {
    }

    public static void b(@n0 TextView textView) {
        if ((textView.getMovementMethod() instanceof LinkMovementMethod) || !textView.getLinksClickable()) {
            return;
        }
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public static void c(@n0 TextView textView, @n0 Pattern pattern, @p0 String str) {
        if (r()) {
            Linkify.addLinks(textView, pattern, str);
        } else {
            e(textView, pattern, str, null, null, null);
        }
    }

    public static void d(@n0 TextView textView, @n0 Pattern pattern, @p0 String str, @p0 Linkify.MatchFilter matchFilter, @p0 Linkify.TransformFilter transformFilter) {
        if (r()) {
            Linkify.addLinks(textView, pattern, str, matchFilter, transformFilter);
        } else {
            e(textView, pattern, str, null, matchFilter, transformFilter);
        }
    }

    public static void e(@n0 TextView textView, @n0 Pattern pattern, @p0 String str, @p0 String[] strArr, @p0 Linkify.MatchFilter matchFilter, @p0 Linkify.TransformFilter transformFilter) {
        if (r()) {
            a.a(textView, pattern, str, strArr, matchFilter, transformFilter);
            return;
        }
        SpannableString spannableStringValueOf = SpannableString.valueOf(textView.getText());
        if (i(spannableStringValueOf, pattern, str, strArr, matchFilter, transformFilter)) {
            textView.setText(spannableStringValueOf);
            b(textView);
        }
    }

    public static boolean f(@n0 Spannable spannable, int i10) {
        if (r()) {
            return Linkify.addLinks(spannable, i10);
        }
        if (i10 == 0) {
            return false;
        }
        URLSpan[] uRLSpanArr = (URLSpan[]) spannable.getSpans(0, spannable.length(), URLSpan.class);
        for (int length = uRLSpanArr.length - 1; length >= 0; length--) {
            spannable.removeSpan(uRLSpanArr[length]);
        }
        if ((i10 & 4) != 0) {
            Linkify.addLinks(spannable, 4);
        }
        ArrayList<b> arrayList = new ArrayList();
        if ((i10 & 1) != 0) {
            m(arrayList, spannable, m.f4765w, new String[]{DefaultWebClient.f21814v, DefaultWebClient.f21815w, "rtsp://"}, Linkify.sUrlMatchFilter, null);
        }
        if ((i10 & 2) != 0) {
            m(arrayList, spannable, m.A, new String[]{u0.c.f51788b}, null, null);
        }
        if ((i10 & 8) != 0) {
            n(arrayList, spannable);
        }
        q(arrayList, spannable);
        if (arrayList.size() == 0) {
            return false;
        }
        for (b bVar : arrayList) {
            if (bVar.f57670a == null) {
                k(bVar.f57671b, bVar.f57672c, bVar.f57673d, spannable);
            }
        }
        return true;
    }

    public static boolean g(@n0 Spannable spannable, @n0 Pattern pattern, @p0 String str) {
        return r() ? Linkify.addLinks(spannable, pattern, str) : i(spannable, pattern, str, null, null, null);
    }

    public static boolean h(@n0 Spannable spannable, @n0 Pattern pattern, @p0 String str, @p0 Linkify.MatchFilter matchFilter, @p0 Linkify.TransformFilter transformFilter) {
        return r() ? Linkify.addLinks(spannable, pattern, str, matchFilter, transformFilter) : i(spannable, pattern, str, null, matchFilter, transformFilter);
    }

    public static boolean i(@n0 Spannable spannable, @n0 Pattern pattern, @p0 String str, @p0 String[] strArr, @p0 Linkify.MatchFilter matchFilter, @p0 Linkify.TransformFilter transformFilter) {
        if (r()) {
            return a.b(spannable, pattern, str, strArr, matchFilter, transformFilter);
        }
        if (str == null) {
            str = "";
        }
        if (strArr == null || strArr.length < 1) {
            strArr = f57668a;
        }
        String[] strArr2 = new String[strArr.length + 1];
        strArr2[0] = str.toLowerCase(Locale.ROOT);
        int i10 = 0;
        while (i10 < strArr.length) {
            String str2 = strArr[i10];
            i10++;
            strArr2[i10] = str2 == null ? "" : str2.toLowerCase(Locale.ROOT);
        }
        Matcher matcher = pattern.matcher(spannable);
        boolean z10 = false;
        while (matcher.find()) {
            int iStart = matcher.start();
            int iEnd = matcher.end();
            String strGroup = matcher.group(0);
            if ((matchFilter != null ? matchFilter.acceptMatch(spannable, iStart, iEnd) : true) && strGroup != null) {
                k(p(strGroup, strArr2, matcher, transformFilter), iStart, iEnd, spannable);
                z10 = true;
            }
        }
        return z10;
    }

    public static boolean j(@n0 TextView textView, int i10) {
        if (r()) {
            return Linkify.addLinks(textView, i10);
        }
        if (i10 == 0) {
            return false;
        }
        CharSequence text = textView.getText();
        if (!(text instanceof Spannable)) {
            SpannableString spannableStringValueOf = SpannableString.valueOf(text);
            if (f(spannableStringValueOf, i10)) {
                b(textView);
                textView.setText(spannableStringValueOf);
                return true;
            }
        } else if (f((Spannable) text, i10)) {
            b(textView);
            return true;
        }
        return false;
    }

    public static void k(String str, int i10, int i11, Spannable spannable) {
        spannable.setSpan(new URLSpan(str), i10, i11, 33);
    }

    public static String l(String str) {
        return Build.VERSION.SDK_INT >= 28 ? WebView.findAddress(str) : z0.a.c(str);
    }

    public static void m(ArrayList<b> arrayList, Spannable spannable, Pattern pattern, String[] strArr, Linkify.MatchFilter matchFilter, Linkify.TransformFilter transformFilter) {
        Matcher matcher = pattern.matcher(spannable);
        while (matcher.find()) {
            int iStart = matcher.start();
            int iEnd = matcher.end();
            String strGroup = matcher.group(0);
            if (matchFilter == null || matchFilter.acceptMatch(spannable, iStart, iEnd)) {
                if (strGroup != null) {
                    b bVar = new b();
                    bVar.f57671b = p(strGroup, strArr, matcher, transformFilter);
                    bVar.f57672c = iStart;
                    bVar.f57673d = iEnd;
                    arrayList.add(bVar);
                }
            }
        }
    }

    public static void n(ArrayList<b> arrayList, Spannable spannable) {
        int iIndexOf;
        String string = spannable.toString();
        int i10 = 0;
        while (true) {
            try {
                String strL = l(string);
                if (strL != null && (iIndexOf = string.indexOf(strL)) >= 0) {
                    b bVar = new b();
                    int length = strL.length() + iIndexOf;
                    bVar.f57672c = iIndexOf + i10;
                    i10 += length;
                    bVar.f57673d = i10;
                    string = string.substring(length);
                    try {
                        bVar.f57671b = "geo:0,0?q=" + URLEncoder.encode(strL, "UTF-8");
                        arrayList.add(bVar);
                    } catch (UnsupportedEncodingException unused) {
                    }
                }
                return;
            } catch (UnsupportedOperationException unused2) {
                return;
            }
        }
    }

    public static /* synthetic */ int o(b bVar, b bVar2) {
        int i10 = bVar.f57672c;
        int i11 = bVar2.f57672c;
        if (i10 < i11) {
            return -1;
        }
        if (i10 > i11) {
            return 1;
        }
        return Integer.compare(bVar2.f57673d, bVar.f57673d);
    }

    public static String p(@n0 String str, @n0 String[] strArr, Matcher matcher, @p0 Linkify.TransformFilter transformFilter) {
        boolean z10;
        if (transformFilter != null) {
            str = transformFilter.transformUrl(matcher, str);
        }
        int length = strArr.length;
        int i10 = 0;
        while (true) {
            z10 = true;
            if (i10 >= length) {
                z10 = false;
                break;
            }
            String str2 = strArr[i10];
            if (str.regionMatches(true, 0, str2, 0, str2.length())) {
                if (!str.regionMatches(false, 0, str2, 0, str2.length())) {
                    str = str2 + str.substring(str2.length());
                }
            } else {
                i10++;
            }
        }
        if (z10 || strArr.length <= 0) {
            return str;
        }
        return strArr[0] + str;
    }

    public static void q(ArrayList<b> arrayList, Spannable spannable) {
        int i10;
        int i11 = 0;
        for (URLSpan uRLSpan : (URLSpan[]) spannable.getSpans(0, spannable.length(), URLSpan.class)) {
            b bVar = new b();
            bVar.f57670a = uRLSpan;
            bVar.f57672c = spannable.getSpanStart(uRLSpan);
            bVar.f57673d = spannable.getSpanEnd(uRLSpan);
            arrayList.add(bVar);
        }
        Collections.sort(arrayList, f57669b);
        int size = arrayList.size();
        while (i11 < size - 1) {
            b bVar2 = arrayList.get(i11);
            int i12 = i11 + 1;
            b bVar3 = arrayList.get(i12);
            int i13 = bVar2.f57672c;
            int i14 = bVar3.f57672c;
            if (i13 <= i14 && (i10 = bVar2.f57673d) > i14) {
                int i15 = bVar3.f57673d;
                int i16 = (i15 > i10 && i10 - i13 <= i15 - i14) ? i10 - i13 < i15 - i14 ? i11 : -1 : i12;
                if (i16 != -1) {
                    Object obj = arrayList.get(i16).f57670a;
                    if (obj != null) {
                        spannable.removeSpan(obj);
                    }
                    arrayList.remove(i16);
                    size--;
                }
            }
            i11 = i12;
        }
    }

    public static boolean r() {
        return Build.VERSION.SDK_INT >= 28;
    }
}
