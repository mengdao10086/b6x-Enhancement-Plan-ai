package xc;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.SpannableStringBuilder;
import android.util.Base64;
import android.util.Pair;
import g.p0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import qc.b;

/* JADX INFO: loaded from: classes3.dex */
public final class d {
    public static final String A = "data";
    public static final String A0 = "open";
    public static final String B = "information";
    public static final String C = "";
    public static final String D = "id";
    public static final String E = "origin";
    public static final String F = "extent";
    public static final String G = "displayAlign";
    public static final String H = "backgroundColor";
    public static final String I = "fontStyle";
    public static final String J = "fontSize";
    public static final String K = "fontFamily";
    public static final String L = "fontWeight";
    public static final String M = "color";
    public static final String N = "ruby";
    public static final String O = "rubyPosition";
    public static final String P = "textDecoration";
    public static final String Q = "textAlign";
    public static final String R = "textCombine";
    public static final String S = "textEmphasis";
    public static final String T = "writingMode";
    public static final String U = "shear";
    public static final String V = "container";
    public static final String W = "base";
    public static final String X = "baseContainer";
    public static final String Y = "text";
    public static final String Z = "textContainer";

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public static final String f55070a0 = "delimiter";

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public static final String f55071b0 = "before";

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public static final String f55072c0 = "after";

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public static final String f55073d0 = "outside";

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public static final String f55074e0 = "linethrough";

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public static final String f55075f0 = "nolinethrough";

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public static final String f55076g0 = "underline";

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public static final String f55077h0 = "nounderline";

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public static final String f55078i0 = "italic";

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public static final String f55079j0 = "bold";

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static final String f55080k0 = "left";

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public static final String f55081l0 = "center";

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public static final String f55082m0 = "right";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f55083n = "tt";

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public static final String f55084n0 = "start";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f55085o = "head";

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public static final String f55086o0 = "end";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String f55087p = "body";

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public static final String f55088p0 = "none";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String f55089q = "div";

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public static final String f55090q0 = "all";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String f55091r = "p";

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public static final String f55092r0 = "tb";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final String f55093s = "span";

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public static final String f55094s0 = "tblr";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final String f55095t = "br";

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public static final String f55096t0 = "tbrl";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final String f55097u = "style";

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public static final String f55098u0 = "none";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final String f55099v = "styling";

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public static final String f55100v0 = "auto";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final String f55101w = "layout";

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public static final String f55102w0 = "dot";

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final String f55103x = "region";

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public static final String f55104x0 = "sesame";

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final String f55105y = "metadata";

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public static final String f55106y0 = "circle";

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final String f55107z = "image";

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public static final String f55108z0 = "filled";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @p0
    public final String f55109a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @p0
    public final String f55110b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f55111c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f55112d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f55113e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @p0
    public final g f55114f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @p0
    public final String[] f55115g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f55116h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @p0
    public final String f55117i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @p0
    public final d f55118j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final HashMap<String, Integer> f55119k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final HashMap<String, Integer> f55120l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public List<d> f55121m;

    public d(@p0 String str, @p0 String str2, long j10, long j11, @p0 g gVar, @p0 String[] strArr, String str3, @p0 String str4, @p0 d dVar) {
        this.f55109a = str;
        this.f55110b = str2;
        this.f55117i = str4;
        this.f55114f = gVar;
        this.f55115g = strArr;
        this.f55111c = str2 != null;
        this.f55112d = j10;
        this.f55113e = j11;
        this.f55116h = (String) hd.a.g(str3);
        this.f55118j = dVar;
        this.f55119k = new HashMap<>();
        this.f55120l = new HashMap<>();
    }

    public static d c(@p0 String str, long j10, long j11, @p0 g gVar, @p0 String[] strArr, String str2, @p0 String str3, @p0 d dVar) {
        return new d(str, null, j10, j11, gVar, strArr, str2, str3, dVar);
    }

    public static d d(String str) {
        return new d(null, f.b(str), ya.g.f56663b, ya.g.f56663b, null, null, "", null, null);
    }

    public static void e(SpannableStringBuilder spannableStringBuilder) {
        for (a aVar : (a[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), a.class)) {
            spannableStringBuilder.replace(spannableStringBuilder.getSpanStart(aVar), spannableStringBuilder.getSpanEnd(aVar), "");
        }
        for (int i10 = 0; i10 < spannableStringBuilder.length(); i10++) {
            if (spannableStringBuilder.charAt(i10) == ' ') {
                int i11 = i10 + 1;
                int i12 = i11;
                while (i12 < spannableStringBuilder.length() && spannableStringBuilder.charAt(i12) == ' ') {
                    i12++;
                }
                int i13 = i12 - i11;
                if (i13 > 0) {
                    spannableStringBuilder.delete(i10, i13 + i10);
                }
            }
        }
        if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(0) == ' ') {
            spannableStringBuilder.delete(0, 1);
        }
        for (int i14 = 0; i14 < spannableStringBuilder.length() - 1; i14++) {
            if (spannableStringBuilder.charAt(i14) == '\n') {
                int i15 = i14 + 1;
                if (spannableStringBuilder.charAt(i15) == ' ') {
                    spannableStringBuilder.delete(i15, i14 + 2);
                }
            }
        }
        if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(spannableStringBuilder.length() - 1) == ' ') {
            spannableStringBuilder.delete(spannableStringBuilder.length() - 1, spannableStringBuilder.length());
        }
        for (int i16 = 0; i16 < spannableStringBuilder.length() - 1; i16++) {
            if (spannableStringBuilder.charAt(i16) == ' ') {
                int i17 = i16 + 1;
                if (spannableStringBuilder.charAt(i17) == '\n') {
                    spannableStringBuilder.delete(i16, i17);
                }
            }
        }
        if (spannableStringBuilder.length() <= 0 || spannableStringBuilder.charAt(spannableStringBuilder.length() - 1) != '\n') {
            return;
        }
        spannableStringBuilder.delete(spannableStringBuilder.length() - 1, spannableStringBuilder.length());
    }

    public static SpannableStringBuilder k(String str, Map<String, b.c> map) {
        if (!map.containsKey(str)) {
            b.c cVar = new b.c();
            cVar.z(new SpannableStringBuilder());
            map.put(str, cVar);
        }
        return (SpannableStringBuilder) hd.a.g(map.get(str).k());
    }

    public void a(d dVar) {
        if (this.f55121m == null) {
            this.f55121m = new ArrayList();
        }
        this.f55121m.add(dVar);
    }

    public final void b(Map<String, g> map, b.c cVar, int i10, int i11, int i12) {
        g gVarF = f.f(this.f55114f, this.f55115g, map);
        SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) cVar.k();
        if (spannableStringBuilder == null) {
            spannableStringBuilder = new SpannableStringBuilder();
            cVar.z(spannableStringBuilder);
        }
        SpannableStringBuilder spannableStringBuilder2 = spannableStringBuilder;
        if (gVarF != null) {
            f.a(spannableStringBuilder2, i10, i11, gVarF, this.f55118j, map, i12);
            if (gVarF.j() != Float.MAX_VALUE && "p".equals(this.f55109a)) {
                cVar.x((gVarF.j() * (-90.0f)) / 100.0f);
            }
            cVar.A(gVarF.l());
        }
    }

    public d f(int i10) {
        List<d> list = this.f55121m;
        if (list != null) {
            return list.get(i10);
        }
        throw new IndexOutOfBoundsException();
    }

    public int g() {
        List<d> list = this.f55121m;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public List<qc.b> h(long j10, Map<String, g> map, Map<String, e> map2, Map<String, String> map3) {
        List<Pair<String, String>> arrayList = new ArrayList<>();
        n(j10, this.f55116h, arrayList);
        TreeMap treeMap = new TreeMap();
        p(j10, false, this.f55116h, treeMap);
        o(j10, map, map2, this.f55116h, treeMap);
        ArrayList arrayList2 = new ArrayList();
        for (Pair<String, String> pair : arrayList) {
            String str = map3.get(pair.second);
            if (str != null) {
                byte[] bArrDecode = Base64.decode(str, 0);
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                e eVar = (e) hd.a.g(map2.get(pair.first));
                arrayList2.add(new b.c().r(bitmapDecodeByteArray).v(eVar.f55123b).w(0).t(eVar.f55124c, 0).u(eVar.f55126e).y(eVar.f55127f).s(eVar.f55128g).C(eVar.f55131j).a());
            }
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            e eVar2 = (e) hd.a.g(map2.get(entry.getKey()));
            b.c cVar = (b.c) entry.getValue();
            e((SpannableStringBuilder) hd.a.g(cVar.k()));
            cVar.t(eVar2.f55124c, eVar2.f55125d);
            cVar.u(eVar2.f55126e);
            cVar.v(eVar2.f55123b);
            cVar.y(eVar2.f55127f);
            cVar.B(eVar2.f55130i, eVar2.f55129h);
            cVar.C(eVar2.f55131j);
            arrayList2.add(cVar.a());
        }
        return arrayList2;
    }

    public final void i(TreeSet<Long> treeSet, boolean z10) {
        boolean zEquals = "p".equals(this.f55109a);
        boolean zEquals2 = f55089q.equals(this.f55109a);
        if (z10 || zEquals || (zEquals2 && this.f55117i != null)) {
            long j10 = this.f55112d;
            if (j10 != ya.g.f56663b) {
                treeSet.add(Long.valueOf(j10));
            }
            long j11 = this.f55113e;
            if (j11 != ya.g.f56663b) {
                treeSet.add(Long.valueOf(j11));
            }
        }
        if (this.f55121m == null) {
            return;
        }
        for (int i10 = 0; i10 < this.f55121m.size(); i10++) {
            this.f55121m.get(i10).i(treeSet, z10 || zEquals);
        }
    }

    public long[] j() {
        TreeSet<Long> treeSet = new TreeSet<>();
        int i10 = 0;
        i(treeSet, false);
        long[] jArr = new long[treeSet.size()];
        Iterator<Long> it2 = treeSet.iterator();
        while (it2.hasNext()) {
            jArr[i10] = it2.next().longValue();
            i10++;
        }
        return jArr;
    }

    @p0
    public String[] l() {
        return this.f55115g;
    }

    public boolean m(long j10) {
        long j11 = this.f55112d;
        return (j11 == ya.g.f56663b && this.f55113e == ya.g.f56663b) || (j11 <= j10 && this.f55113e == ya.g.f56663b) || ((j11 == ya.g.f56663b && j10 < this.f55113e) || (j11 <= j10 && j10 < this.f55113e));
    }

    public final void n(long j10, String str, List<Pair<String, String>> list) {
        if (!"".equals(this.f55116h)) {
            str = this.f55116h;
        }
        if (m(j10) && f55089q.equals(this.f55109a) && this.f55117i != null) {
            list.add(new Pair<>(str, this.f55117i));
            return;
        }
        for (int i10 = 0; i10 < g(); i10++) {
            f(i10).n(j10, str, list);
        }
    }

    public final void o(long j10, Map<String, g> map, Map<String, e> map2, String str, Map<String, b.c> map3) {
        int i10;
        if (m(j10)) {
            String str2 = "".equals(this.f55116h) ? str : this.f55116h;
            Iterator<Map.Entry<String, Integer>> it2 = this.f55120l.entrySet().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Map.Entry<String, Integer> next = it2.next();
                String key = next.getKey();
                int iIntValue = this.f55119k.containsKey(key) ? this.f55119k.get(key).intValue() : 0;
                int iIntValue2 = next.getValue().intValue();
                if (iIntValue != iIntValue2) {
                    b(map, (b.c) hd.a.g(map3.get(key)), iIntValue, iIntValue2, ((e) hd.a.g(map2.get(str2))).f55131j);
                }
            }
            for (i10 = 0; i10 < g(); i10++) {
                f(i10).o(j10, map, map2, str2, map3);
            }
        }
    }

    public final void p(long j10, boolean z10, String str, Map<String, b.c> map) {
        this.f55119k.clear();
        this.f55120l.clear();
        if ("metadata".equals(this.f55109a)) {
            return;
        }
        if (!"".equals(this.f55116h)) {
            str = this.f55116h;
        }
        if (this.f55111c && z10) {
            k(str, map).append((CharSequence) hd.a.g(this.f55110b));
            return;
        }
        if (f55095t.equals(this.f55109a) && z10) {
            k(str, map).append('\n');
            return;
        }
        if (m(j10)) {
            for (Map.Entry<String, b.c> entry : map.entrySet()) {
                this.f55119k.put(entry.getKey(), Integer.valueOf(((CharSequence) hd.a.g(entry.getValue().k())).length()));
            }
            boolean zEquals = "p".equals(this.f55109a);
            for (int i10 = 0; i10 < g(); i10++) {
                f(i10).p(j10, z10 || zEquals, str, map);
            }
            if (zEquals) {
                f.c(k(str, map));
            }
            for (Map.Entry<String, b.c> entry2 : map.entrySet()) {
                this.f55120l.put(entry2.getKey(), Integer.valueOf(((CharSequence) hd.a.g(entry2.getValue().k())).length()));
            }
        }
    }
}
