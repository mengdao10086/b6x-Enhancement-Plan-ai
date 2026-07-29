package kotlin.text;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.sequences.SequencesKt___SequencesKt;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nIndent.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Indent.kt\nkotlin/text/StringsKt__IndentKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n*L\n1#1,123:1\n113#1,2:125\n115#1,4:140\n120#1,2:153\n113#1,2:162\n115#1,4:177\n120#1,2:184\n1#2:124\n1#2:150\n1#2:181\n1#2:205\n1569#3,11:127\n1864#3,2:138\n1866#3:151\n1580#3:152\n766#3:155\n857#3,2:156\n1549#3:158\n1620#3,3:159\n1569#3,11:164\n1864#3,2:175\n1866#3:182\n1580#3:183\n1569#3,11:192\n1864#3,2:203\n1866#3:206\n1580#3:207\n151#4,6:144\n151#4,6:186\n*S KotlinDebug\n*F\n+ 1 Indent.kt\nkotlin/text/StringsKt__IndentKt\n*L\n38#1:125,2\n38#1:140,4\n38#1:153,2\n78#1:162,2\n78#1:177,4\n78#1:184,2\n38#1:150\n78#1:181\n114#1:205\n38#1:127,11\n38#1:138,2\n38#1:151\n38#1:152\n74#1:155\n74#1:156,2\n75#1:158\n75#1:159,3\n78#1:164,11\n78#1:175,2\n78#1:182\n78#1:183\n114#1:192,11\n114#1:203,2\n114#1:206\n114#1:207\n39#1:144,6\n101#1:186,6\n*E\n"})
public class StringsKt__IndentKt extends n {
    public static final ik.l<String, String> g(final String str) {
        return str.length() == 0 ? new ik.l<String, String>() { // from class: kotlin.text.StringsKt__IndentKt$getIndentFunction$1
            @Override // ik.l
            @yt.k
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final String i(@yt.k String line) {
                f0.p(line, "line");
                return line;
            }
        } : new ik.l<String, String>() { // from class: kotlin.text.StringsKt__IndentKt$getIndentFunction$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // ik.l
            @yt.k
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final String i(@yt.k String line) {
                f0.p(line, "line");
                return str + line;
            }
        };
    }

    public static final int h(String str) {
        int length = str.length();
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                i10 = -1;
                break;
            }
            if (!b.r(str.charAt(i10))) {
                break;
            }
            i10++;
        }
        return i10 == -1 ? str.length() : i10;
    }

    @yt.k
    public static final String i(@yt.k String str, @yt.k final String indent) {
        f0.p(str, "<this>");
        f0.p(indent, "indent");
        return SequencesKt___SequencesKt.e1(SequencesKt___SequencesKt.k1(StringsKt__StringsKt.L3(str), new ik.l<String, String>() { // from class: kotlin.text.StringsKt__IndentKt$prependIndent$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // ik.l
            @yt.k
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final String i(@yt.k String it2) {
                f0.p(it2, "it");
                if (u.V1(it2)) {
                    return it2.length() < indent.length() ? indent : it2;
                }
                return indent + it2;
            }
        }), "\n", null, null, 0, null, null, 62, null);
    }

    public static /* synthetic */ String j(String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str2 = wn.a.f54751a;
        }
        return i(str, str2);
    }

    public static final String k(List<String> list, int i10, ik.l<? super String, String> lVar, ik.l<? super String, String> lVar2) {
        String strI;
        int iG = CollectionsKt__CollectionsKt.G(list);
        ArrayList arrayList = new ArrayList();
        int i11 = 0;
        for (Object obj : list) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                CollectionsKt__CollectionsKt.W();
            }
            String str = (String) obj;
            if ((i11 == 0 || i11 == iG) && u.V1(str)) {
                str = null;
            } else {
                String strI2 = lVar2.i(str);
                if (strI2 != null && (strI = lVar.i(strI2)) != null) {
                    str = strI;
                }
            }
            if (str != null) {
                arrayList.add(str);
            }
            i11 = i12;
        }
        String string = ((StringBuilder) CollectionsKt___CollectionsKt.e3(arrayList, new StringBuilder(i10), (124 & 2) != 0 ? ", " : "\n", (124 & 4) != 0 ? "" : null, (124 & 8) == 0 ? null : "", (124 & 16) != 0 ? -1 : 0, (124 & 32) != 0 ? "..." : null, (124 & 64) != 0 ? null : null)).toString();
        f0.o(string, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
        return string;
    }

    @yt.k
    public static final String l(@yt.k String str, @yt.k String newIndent) {
        String strI;
        f0.p(str, "<this>");
        f0.p(newIndent, "newIndent");
        List<String> listM3 = StringsKt__StringsKt.M3(str);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listM3) {
            if (!u.V1((String) obj)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(kotlin.collections.t.Y(arrayList, 10));
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            arrayList2.add(Integer.valueOf(h((String) it2.next())));
        }
        Integer num = (Integer) CollectionsKt___CollectionsKt.c4(arrayList2);
        int i10 = 0;
        int iIntValue = num != null ? num.intValue() : 0;
        int length = str.length() + (newIndent.length() * listM3.size());
        ik.l<String, String> lVarG = g(newIndent);
        int iG = CollectionsKt__CollectionsKt.G(listM3);
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : listM3) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                CollectionsKt__CollectionsKt.W();
            }
            String str2 = (String) obj2;
            if ((i10 == 0 || i10 == iG) && u.V1(str2)) {
                str2 = null;
            } else {
                String strB6 = StringsKt___StringsKt.B6(str2, iIntValue);
                if (strB6 != null && (strI = lVarG.i(strB6)) != null) {
                    str2 = strI;
                }
            }
            if (str2 != null) {
                arrayList3.add(str2);
            }
            i10 = i11;
        }
        String string = ((StringBuilder) CollectionsKt___CollectionsKt.e3(arrayList3, new StringBuilder(length), (124 & 2) != 0 ? ", " : "\n", (124 & 4) != 0 ? "" : null, (124 & 8) == 0 ? null : "", (124 & 16) != 0 ? -1 : 0, (124 & 32) != 0 ? "..." : null, (124 & 64) != 0 ? null : null)).toString();
        f0.o(string, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
        return string;
    }

    public static /* synthetic */ String m(String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str2 = "";
        }
        return l(str, str2);
    }

    @yt.k
    public static final String n(@yt.k String str, @yt.k String newIndent, @yt.k String marginPrefix) {
        int i10;
        String strI;
        f0.p(str, "<this>");
        f0.p(newIndent, "newIndent");
        f0.p(marginPrefix, "marginPrefix");
        if (!(!u.V1(marginPrefix))) {
            throw new IllegalArgumentException("marginPrefix must be non-blank string.".toString());
        }
        List<String> listM3 = StringsKt__StringsKt.M3(str);
        int length = str.length() + (newIndent.length() * listM3.size());
        ik.l<String, String> lVarG = g(newIndent);
        int iG = CollectionsKt__CollectionsKt.G(listM3);
        ArrayList arrayList = new ArrayList();
        int i11 = 0;
        for (Object obj : listM3) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                CollectionsKt__CollectionsKt.W();
            }
            String str2 = (String) obj;
            String strSubstring = null;
            if ((i11 == 0 || i11 == iG) && u.V1(str2)) {
                str2 = null;
            } else {
                int length2 = str2.length();
                int i13 = 0;
                while (true) {
                    if (i13 >= length2) {
                        i10 = -1;
                        break;
                    }
                    if (!b.r(str2.charAt(i13))) {
                        i10 = i13;
                        break;
                    }
                    i13++;
                }
                if (i10 != -1) {
                    int i14 = i10;
                    if (u.u2(str2, marginPrefix, i10, false, 4, null)) {
                        int length3 = i14 + marginPrefix.length();
                        f0.n(str2, "null cannot be cast to non-null type java.lang.String");
                        strSubstring = str2.substring(length3);
                        f0.o(strSubstring, "this as java.lang.String).substring(startIndex)");
                    }
                }
                if (strSubstring != null && (strI = lVarG.i(strSubstring)) != null) {
                    str2 = strI;
                }
            }
            if (str2 != null) {
                arrayList.add(str2);
            }
            i11 = i12;
        }
        String string = ((StringBuilder) CollectionsKt___CollectionsKt.e3(arrayList, new StringBuilder(length), (124 & 2) != 0 ? ", " : "\n", (124 & 4) != 0 ? "" : null, (124 & 8) == 0 ? null : "", (124 & 16) != 0 ? -1 : 0, (124 & 32) != 0 ? "..." : null, (124 & 64) != 0 ? null : null)).toString();
        f0.o(string, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
        return string;
    }

    public static /* synthetic */ String o(String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str2 = "";
        }
        if ((i10 & 2) != 0) {
            str3 = "|";
        }
        return n(str, str2, str3);
    }

    @bk.g
    @yt.k
    public static final String p(@yt.k String str) {
        f0.p(str, "<this>");
        return l(str, "");
    }

    @bk.g
    @yt.k
    public static final String q(@yt.k String str, @yt.k String marginPrefix) {
        f0.p(str, "<this>");
        f0.p(marginPrefix, "marginPrefix");
        return n(str, "", marginPrefix);
    }

    public static /* synthetic */ String r(String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str2 = "|";
        }
        return q(str, str2);
    }
}
