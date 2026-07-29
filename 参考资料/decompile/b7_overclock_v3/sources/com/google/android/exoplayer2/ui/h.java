package com.google.android.exoplayer2.ui;

import android.text.Html;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import android.util.SparseArray;
import com.google.android.exoplayer2.ui.h;
import com.google.common.collect.ImmutableMap;
import g.p0;
import hd.u0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f18825a = Pattern.compile("(&#13;)?&#10;");

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f18826a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map<String, String> f18827b;

        public b(String str, Map<String, String> map) {
            this.f18826a = str;
            this.f18827b = map;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final Comparator<c> f18828e = new Comparator() { // from class: cd.l
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return h.c.e((h.c) obj, (h.c) obj2);
            }
        };

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final Comparator<c> f18829f = new Comparator() { // from class: cd.m
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return h.c.f((h.c) obj, (h.c) obj2);
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f18830a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f18831b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f18832c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f18833d;

        public static /* synthetic */ int e(c cVar, c cVar2) {
            int iCompare = Integer.compare(cVar2.f18831b, cVar.f18831b);
            if (iCompare != 0) {
                return iCompare;
            }
            int iCompareTo = cVar.f18832c.compareTo(cVar2.f18832c);
            return iCompareTo != 0 ? iCompareTo : cVar.f18833d.compareTo(cVar2.f18833d);
        }

        public static /* synthetic */ int f(c cVar, c cVar2) {
            int iCompare = Integer.compare(cVar2.f18830a, cVar.f18830a);
            if (iCompare != 0) {
                return iCompare;
            }
            int iCompareTo = cVar2.f18832c.compareTo(cVar.f18832c);
            return iCompareTo != 0 ? iCompareTo : cVar2.f18833d.compareTo(cVar.f18833d);
        }

        public c(int i10, int i11, String str, String str2) {
            this.f18830a = i10;
            this.f18831b = i11;
            this.f18832c = str;
            this.f18833d = str2;
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<c> f18834a = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<c> f18835b = new ArrayList();
    }

    public static b a(@p0 CharSequence charSequence, float f10) {
        if (charSequence == null) {
            return new b("", ImmutableMap.of());
        }
        if (!(charSequence instanceof Spanned)) {
            return new b(b(charSequence), ImmutableMap.of());
        }
        Spanned spanned = (Spanned) charSequence;
        HashSet hashSet = new HashSet();
        int i10 = 0;
        for (BackgroundColorSpan backgroundColorSpan : (BackgroundColorSpan[]) spanned.getSpans(0, spanned.length(), BackgroundColorSpan.class)) {
            hashSet.add(Integer.valueOf(backgroundColorSpan.getBackgroundColor()));
        }
        HashMap map = new HashMap();
        Iterator it2 = hashSet.iterator();
        while (it2.hasNext()) {
            int iIntValue = ((Integer) it2.next()).intValue();
            map.put(cd.f.a("bg_" + iIntValue), u0.I("background-color:%s;", cd.f.b(iIntValue)));
        }
        SparseArray<d> sparseArrayC = c(spanned, f10);
        StringBuilder sb2 = new StringBuilder(spanned.length());
        int i11 = 0;
        while (i10 < sparseArrayC.size()) {
            int iKeyAt = sparseArrayC.keyAt(i10);
            sb2.append(b(spanned.subSequence(i11, iKeyAt)));
            d dVar = sparseArrayC.get(iKeyAt);
            Collections.sort(dVar.f18835b, c.f18829f);
            Iterator it3 = dVar.f18835b.iterator();
            while (it3.hasNext()) {
                sb2.append(((c) it3.next()).f18833d);
            }
            Collections.sort(dVar.f18834a, c.f18828e);
            Iterator it4 = dVar.f18834a.iterator();
            while (it4.hasNext()) {
                sb2.append(((c) it4.next()).f18832c);
            }
            i10++;
            i11 = iKeyAt;
        }
        sb2.append(b(spanned.subSequence(i11, spanned.length())));
        return new b(sb2.toString(), map);
    }

    public static String b(CharSequence charSequence) {
        return f18825a.matcher(Html.escapeHtml(charSequence)).replaceAll("<br>");
    }

    public static SparseArray<d> c(Spanned spanned, float f10) {
        SparseArray<d> sparseArray = new SparseArray<>();
        for (Object obj : spanned.getSpans(0, spanned.length(), Object.class)) {
            String strE = e(obj, f10);
            String strD = d(obj);
            int spanStart = spanned.getSpanStart(obj);
            int spanEnd = spanned.getSpanEnd(obj);
            if (strE != null) {
                hd.a.g(strD);
                c cVar = new c(spanStart, spanEnd, strE, strD);
                f(sparseArray, spanStart).f18834a.add(cVar);
                f(sparseArray, spanEnd).f18835b.add(cVar);
            }
        }
        return sparseArray;
    }

    @p0
    public static String d(Object obj) {
        if ((obj instanceof StrikethroughSpan) || (obj instanceof ForegroundColorSpan) || (obj instanceof BackgroundColorSpan) || (obj instanceof uc.a) || (obj instanceof AbsoluteSizeSpan) || (obj instanceof RelativeSizeSpan) || (obj instanceof uc.e)) {
            return "</span>";
        }
        if (obj instanceof TypefaceSpan) {
            if (((TypefaceSpan) obj).getFamily() != null) {
                return "</span>";
            }
            return null;
        }
        if (obj instanceof StyleSpan) {
            int style = ((StyleSpan) obj).getStyle();
            if (style == 1) {
                return "</b>";
            }
            if (style == 2) {
                return "</i>";
            }
            if (style == 3) {
                return "</i></b>";
            }
        } else {
            if (obj instanceof uc.b) {
                return "<rt>" + b(((uc.b) obj).f51974a) + "</rt></ruby>";
            }
            if (obj instanceof UnderlineSpan) {
                return "</u>";
            }
        }
        return null;
    }

    @p0
    public static String e(Object obj, float f10) {
        if (obj instanceof StrikethroughSpan) {
            return "<span style='text-decoration:line-through;'>";
        }
        if (obj instanceof ForegroundColorSpan) {
            return u0.I("<span style='color:%s;'>", cd.f.b(((ForegroundColorSpan) obj).getForegroundColor()));
        }
        if (obj instanceof BackgroundColorSpan) {
            return u0.I("<span class='bg_%s'>", Integer.valueOf(((BackgroundColorSpan) obj).getBackgroundColor()));
        }
        if (obj instanceof uc.a) {
            return "<span style='text-combine-upright:all;'>";
        }
        if (obj instanceof AbsoluteSizeSpan) {
            return u0.I("<span style='font-size:%.2fpx;'>", Float.valueOf(((AbsoluteSizeSpan) obj).getDip() ? r4.getSize() : r4.getSize() / f10));
        }
        if (obj instanceof RelativeSizeSpan) {
            return u0.I("<span style='font-size:%.2f%%;'>", Float.valueOf(((RelativeSizeSpan) obj).getSizeChange() * 100.0f));
        }
        if (obj instanceof TypefaceSpan) {
            String family = ((TypefaceSpan) obj).getFamily();
            if (family != null) {
                return u0.I("<span style='font-family:\"%s\";'>", family);
            }
            return null;
        }
        if (obj instanceof StyleSpan) {
            int style = ((StyleSpan) obj).getStyle();
            if (style == 1) {
                return "<b>";
            }
            if (style == 2) {
                return "<i>";
            }
            if (style != 3) {
                return null;
            }
            return "<b><i>";
        }
        if (!(obj instanceof uc.b)) {
            if (obj instanceof UnderlineSpan) {
                return "<u>";
            }
            if (!(obj instanceof uc.e)) {
                return null;
            }
            uc.e eVar = (uc.e) obj;
            return u0.I("<span style='-webkit-text-emphasis-style:%1$s;text-emphasis-style:%1$s;-webkit-text-emphasis-position:%2$s;text-emphasis-position:%2$s;display:inline-block;'>", h(eVar.f51986a, eVar.f51987b), g(eVar.f51988c));
        }
        int i10 = ((uc.b) obj).f51975b;
        if (i10 == -1) {
            return "<ruby style='ruby-position:unset;'>";
        }
        if (i10 == 1) {
            return "<ruby style='ruby-position:over;'>";
        }
        if (i10 != 2) {
            return null;
        }
        return "<ruby style='ruby-position:under;'>";
    }

    public static d f(SparseArray<d> sparseArray, int i10) {
        d dVar = sparseArray.get(i10);
        if (dVar != null) {
            return dVar;
        }
        d dVar2 = new d();
        sparseArray.put(i10, dVar2);
        return dVar2;
    }

    public static String g(int i10) {
        return i10 != 2 ? "over right" : "under left";
    }

    public static String h(int i10, int i11) {
        StringBuilder sb2 = new StringBuilder();
        if (i11 == 1) {
            sb2.append("filled ");
        } else if (i11 == 2) {
            sb2.append("open ");
        }
        if (i10 == 0) {
            sb2.append("none");
        } else if (i10 == 1) {
            sb2.append(xc.d.f55106y0);
        } else if (i10 == 2) {
            sb2.append(xc.d.f55102w0);
        } else if (i10 != 3) {
            sb2.append("unset");
        } else {
            sb2.append(xc.d.f55104x0);
        }
        return sb2.toString();
    }
}
