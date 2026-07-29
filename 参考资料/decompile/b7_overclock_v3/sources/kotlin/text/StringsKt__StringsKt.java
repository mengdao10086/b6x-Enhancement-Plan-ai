package kotlin.text;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.c2;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.k0;
import kotlin.d1;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.m0;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlin.v0;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nStrings.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Strings.kt\nkotlin/text/StringsKt__StringsKt\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1486:1\n79#1,22:1487\n113#1,5:1509\n130#1,5:1514\n79#1,22:1519\n107#1:1541\n79#1,22:1542\n113#1,5:1564\n124#1:1569\n113#1,5:1570\n130#1,5:1575\n141#1:1580\n130#1,5:1581\n79#1,22:1586\n113#1,5:1608\n130#1,5:1613\n12824#2,2:1618\n12824#2,2:1620\n288#3,2:1622\n288#3,2:1624\n1549#3:1627\n1620#3,3:1628\n1549#3:1631\n1620#3,3:1632\n1#4:1626\n*S KotlinDebug\n*F\n+ 1 Strings.kt\nkotlin/text/StringsKt__StringsKt\n*L\n107#1:1487,22\n124#1:1509,5\n141#1:1514,5\n146#1:1519,22\n151#1:1541\n151#1:1542,22\n156#1:1564,5\n161#1:1569\n161#1:1570,5\n166#1:1575,5\n171#1:1580\n171#1:1581,5\n176#1:1586,22\n187#1:1608,5\n198#1:1613,5\n940#1:1618,2\n964#1:1620,2\n1003#1:1622,2\n1009#1:1624,2\n1309#1:1627\n1309#1:1628,3\n1334#1:1631\n1334#1:1632,3\n*E\n"})
public class StringsKt__StringsKt extends u {

    public static final class a extends kotlin.collections.q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f38151a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CharSequence f38152b;

        public a(CharSequence charSequence) {
            this.f38152b = charSequence;
        }

        @Override // kotlin.collections.q
        public char b() {
            CharSequence charSequence = this.f38152b;
            int i10 = this.f38151a;
            this.f38151a = i10 + 1;
            return charSequence.charAt(i10);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f38151a < this.f38152b.length();
        }
    }

    @bk.f
    public static final boolean A3(CharSequence charSequence) {
        return charSequence == null || u.V1(charSequence);
    }

    public static /* synthetic */ String A4(String str, char c10, String str2, String str3, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            str3 = str;
        }
        return y4(str, c10, str2, str3);
    }

    @yt.k
    public static final String A5(@yt.k String str, @yt.k String delimiter, @yt.k String missingDelimiterValue) {
        f0.p(str, "<this>");
        f0.p(delimiter, "delimiter");
        f0.p(missingDelimiterValue, "missingDelimiterValue");
        int iG3 = G3(str, delimiter, 0, false, 6, null);
        if (iG3 == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = str.substring(0, iG3);
        f0.o(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    @bk.f
    public static final boolean B3(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    public static /* synthetic */ String B4(String str, String str2, String str3, String str4, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            str4 = str;
        }
        return z4(str, str2, str3, str4);
    }

    public static /* synthetic */ String B5(String str, char c10, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = str;
        }
        return z5(str, c10, str2);
    }

    @yt.k
    public static final kotlin.collections.q C3(@yt.k CharSequence charSequence) {
        f0.p(charSequence, "<this>");
        return new a(charSequence);
    }

    @yt.k
    public static final String C4(@yt.k String str, char c10, @yt.k String replacement, @yt.k String missingDelimiterValue) {
        f0.p(str, "<this>");
        f0.p(replacement, "replacement");
        f0.p(missingDelimiterValue, "missingDelimiterValue");
        int iF3 = F3(str, c10, 0, false, 6, null);
        return iF3 == -1 ? missingDelimiterValue : J4(str, 0, iF3, replacement).toString();
    }

    public static /* synthetic */ String C5(String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str3 = str;
        }
        return A5(str, str2, str3);
    }

    public static final int D3(@yt.k CharSequence charSequence, char c10, int i10, boolean z10) {
        f0.p(charSequence, "<this>");
        return (z10 || !(charSequence instanceof String)) ? I3(charSequence, new char[]{c10}, i10, z10) : ((String) charSequence).lastIndexOf(c10, i10);
    }

    @yt.k
    public static final String D4(@yt.k String str, @yt.k String delimiter, @yt.k String replacement, @yt.k String missingDelimiterValue) {
        f0.p(str, "<this>");
        f0.p(delimiter, "delimiter");
        f0.p(replacement, "replacement");
        f0.p(missingDelimiterValue, "missingDelimiterValue");
        int iG3 = G3(str, delimiter, 0, false, 6, null);
        return iG3 == -1 ? missingDelimiterValue : J4(str, 0, iG3, replacement).toString();
    }

    @v0(version = "1.5")
    public static final boolean D5(@yt.k String str) {
        f0.p(str, "<this>");
        if (f0.g(str, "true")) {
            return true;
        }
        if (f0.g(str, "false")) {
            return false;
        }
        throw new IllegalArgumentException("The string doesn't represent a boolean value: " + str);
    }

    public static final int E3(@yt.k CharSequence charSequence, @yt.k String string, int i10, boolean z10) {
        f0.p(charSequence, "<this>");
        f0.p(string, "string");
        return (z10 || !(charSequence instanceof String)) ? p3(charSequence, string, i10, 0, z10, true) : ((String) charSequence).lastIndexOf(string, i10);
    }

    public static /* synthetic */ String E4(String str, char c10, String str2, String str3, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            str3 = str;
        }
        return C4(str, c10, str2, str3);
    }

    @v0(version = "1.5")
    @yt.l
    public static final Boolean E5(@yt.k String str) {
        f0.p(str, "<this>");
        if (f0.g(str, "true")) {
            return Boolean.TRUE;
        }
        if (f0.g(str, "false")) {
            return Boolean.FALSE;
        }
        return null;
    }

    public static /* synthetic */ int F3(CharSequence charSequence, char c10, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = j3(charSequence);
        }
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        return D3(charSequence, c10, i10, z10);
    }

    public static /* synthetic */ String F4(String str, String str2, String str3, String str4, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            str4 = str;
        }
        return D4(str, str2, str3, str4);
    }

    @yt.k
    public static final CharSequence F5(@yt.k CharSequence charSequence) {
        f0.p(charSequence, "<this>");
        int length = charSequence.length() - 1;
        int i10 = 0;
        boolean z10 = false;
        while (i10 <= length) {
            boolean zR = b.r(charSequence.charAt(!z10 ? i10 : length));
            if (z10) {
                if (!zR) {
                    break;
                }
                length--;
            } else if (zR) {
                i10++;
            } else {
                z10 = true;
            }
        }
        return charSequence.subSequence(i10, length + 1);
    }

    public static /* synthetic */ int G3(CharSequence charSequence, String str, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = j3(charSequence);
        }
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        return E3(charSequence, str, i10, z10);
    }

    @bk.f
    public static final String G4(CharSequence charSequence, Regex regex, String replacement) {
        f0.p(charSequence, "<this>");
        f0.p(regex, "regex");
        f0.p(replacement, "replacement");
        return regex.r(charSequence, replacement);
    }

    @yt.k
    public static final CharSequence G5(@yt.k CharSequence charSequence, @yt.k ik.l<? super Character, Boolean> predicate) {
        f0.p(charSequence, "<this>");
        f0.p(predicate, "predicate");
        int length = charSequence.length() - 1;
        int i10 = 0;
        boolean z10 = false;
        while (i10 <= length) {
            boolean zBooleanValue = predicate.i(Character.valueOf(charSequence.charAt(!z10 ? i10 : length))).booleanValue();
            if (z10) {
                if (!zBooleanValue) {
                    break;
                }
                length--;
            } else if (zBooleanValue) {
                i10++;
            } else {
                z10 = true;
            }
        }
        return charSequence.subSequence(i10, length + 1);
    }

    public static final int H3(@yt.k CharSequence charSequence, @yt.k Collection<String> strings, int i10, boolean z10) {
        f0.p(charSequence, "<this>");
        f0.p(strings, "strings");
        Pair<Integer, String> pairE3 = e3(charSequence, strings, i10, z10, true);
        if (pairE3 != null) {
            return pairE3.f().intValue();
        }
        return -1;
    }

    @hk.h(name = "replaceFirstCharWithChar")
    @m0
    @bk.f
    @v0(version = "1.5")
    @c2(markerClass = {kotlin.q.class})
    public static final String H4(String str, ik.l<? super Character, Character> transform) {
        f0.p(str, "<this>");
        f0.p(transform, "transform");
        if (!(str.length() > 0)) {
            return str;
        }
        char cCharValue = transform.i(Character.valueOf(str.charAt(0))).charValue();
        String strSubstring = str.substring(1);
        f0.o(strSubstring, "this as java.lang.String).substring(startIndex)");
        return cCharValue + strSubstring;
    }

    @yt.k
    public static final CharSequence H5(@yt.k CharSequence charSequence, @yt.k char... chars) {
        f0.p(charSequence, "<this>");
        f0.p(chars, "chars");
        int length = charSequence.length() - 1;
        int i10 = 0;
        boolean z10 = false;
        while (i10 <= length) {
            boolean zO8 = ArraysKt___ArraysKt.O8(chars, charSequence.charAt(!z10 ? i10 : length));
            if (z10) {
                if (!zO8) {
                    break;
                }
                length--;
            } else if (zO8) {
                i10++;
            } else {
                z10 = true;
            }
        }
        return charSequence.subSequence(i10, length + 1);
    }

    public static final int I3(@yt.k CharSequence charSequence, @yt.k char[] chars, int i10, boolean z10) {
        f0.p(charSequence, "<this>");
        f0.p(chars, "chars");
        if (!z10 && chars.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(ArraysKt___ArraysKt.wt(chars), i10);
        }
        for (int iB = qk.v.B(i10, j3(charSequence)); -1 < iB; iB--) {
            char cCharAt = charSequence.charAt(iB);
            int length = chars.length;
            boolean z11 = false;
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    break;
                }
                if (c.J(chars[i11], cCharAt, z10)) {
                    z11 = true;
                    break;
                }
                i11++;
            }
            if (z11) {
                return iB;
            }
        }
        return -1;
    }

    @hk.h(name = "replaceFirstCharWithCharSequence")
    @m0
    @bk.f
    @v0(version = "1.5")
    @c2(markerClass = {kotlin.q.class})
    public static final String I4(String str, ik.l<? super Character, ? extends CharSequence> transform) {
        f0.p(str, "<this>");
        f0.p(transform, "transform");
        if (!(str.length() > 0)) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append((Object) transform.i(Character.valueOf(str.charAt(0))));
        String strSubstring = str.substring(1);
        f0.o(strSubstring, "this as java.lang.String).substring(startIndex)");
        sb2.append(strSubstring);
        return sb2.toString();
    }

    @bk.f
    public static final String I5(String str) {
        f0.p(str, "<this>");
        return F5(str).toString();
    }

    public static /* synthetic */ int J3(CharSequence charSequence, Collection collection, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = j3(charSequence);
        }
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        return H3(charSequence, collection, i10, z10);
    }

    @yt.k
    public static final CharSequence J4(@yt.k CharSequence charSequence, int i10, int i11, @yt.k CharSequence replacement) {
        f0.p(charSequence, "<this>");
        f0.p(replacement, "replacement");
        if (i11 >= i10) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(charSequence, 0, i10);
            f0.o(sb2, "this.append(value, startIndex, endIndex)");
            sb2.append(replacement);
            sb2.append(charSequence, i11, charSequence.length());
            f0.o(sb2, "this.append(value, startIndex, endIndex)");
            return sb2;
        }
        throw new IndexOutOfBoundsException("End index (" + i11 + ") is less than start index (" + i10 + ").");
    }

    @yt.k
    public static final String J5(@yt.k String str, @yt.k ik.l<? super Character, Boolean> predicate) {
        f0.p(str, "<this>");
        f0.p(predicate, "predicate");
        int length = str.length() - 1;
        int i10 = 0;
        boolean z10 = false;
        while (i10 <= length) {
            boolean zBooleanValue = predicate.i(Character.valueOf(str.charAt(!z10 ? i10 : length))).booleanValue();
            if (z10) {
                if (!zBooleanValue) {
                    break;
                }
                length--;
            } else if (zBooleanValue) {
                i10++;
            } else {
                z10 = true;
            }
        }
        return str.subSequence(i10, length + 1).toString();
    }

    public static /* synthetic */ int K3(CharSequence charSequence, char[] cArr, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = j3(charSequence);
        }
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        return I3(charSequence, cArr, i10, z10);
    }

    @yt.k
    public static final CharSequence K4(@yt.k CharSequence charSequence, @yt.k qk.m range, @yt.k CharSequence replacement) {
        f0.p(charSequence, "<this>");
        f0.p(range, "range");
        f0.p(replacement, "replacement");
        return J4(charSequence, range.a().intValue(), range.e().intValue() + 1, replacement);
    }

    @yt.k
    public static final String K5(@yt.k String str, @yt.k char... chars) {
        f0.p(str, "<this>");
        f0.p(chars, "chars");
        int length = str.length() - 1;
        int i10 = 0;
        boolean z10 = false;
        while (i10 <= length) {
            boolean zO8 = ArraysKt___ArraysKt.O8(chars, str.charAt(!z10 ? i10 : length));
            if (z10) {
                if (!zO8) {
                    break;
                }
                length--;
            } else if (zO8) {
                i10++;
            } else {
                z10 = true;
            }
        }
        return str.subSequence(i10, length + 1).toString();
    }

    @yt.k
    public static final kotlin.sequences.m<String> L3(@yt.k CharSequence charSequence) {
        f0.p(charSequence, "<this>");
        return a5(charSequence, new String[]{"\r\n", "\n", "\r"}, false, 0, 6, null);
    }

    @bk.f
    public static final String L4(String str, int i10, int i11, CharSequence replacement) {
        f0.p(str, "<this>");
        f0.p(replacement, "replacement");
        return J4(str, i10, i11, replacement).toString();
    }

    @yt.k
    public static final CharSequence L5(@yt.k CharSequence charSequence) {
        f0.p(charSequence, "<this>");
        int length = charSequence.length() - 1;
        if (length >= 0) {
            while (true) {
                int i10 = length - 1;
                if (!b.r(charSequence.charAt(length))) {
                    return charSequence.subSequence(0, length + 1);
                }
                if (i10 < 0) {
                    break;
                }
                length = i10;
            }
        }
        return "";
    }

    @yt.k
    public static final List<String> M3(@yt.k CharSequence charSequence) {
        f0.p(charSequence, "<this>");
        return SequencesKt___SequencesKt.c3(L3(charSequence));
    }

    @bk.f
    public static final String M4(String str, qk.m range, CharSequence replacement) {
        f0.p(str, "<this>");
        f0.p(range, "range");
        f0.p(replacement, "replacement");
        return K4(str, range, replacement).toString();
    }

    @yt.k
    public static final CharSequence M5(@yt.k CharSequence charSequence, @yt.k ik.l<? super Character, Boolean> predicate) {
        f0.p(charSequence, "<this>");
        f0.p(predicate, "predicate");
        int length = charSequence.length() - 1;
        if (length < 0) {
            return "";
        }
        while (true) {
            int i10 = length - 1;
            if (!predicate.i(Character.valueOf(charSequence.charAt(length))).booleanValue()) {
                return charSequence.subSequence(0, length + 1);
            }
            if (i10 < 0) {
                return "";
            }
            length = i10;
        }
    }

    @bk.f
    public static final boolean N3(CharSequence charSequence, Regex regex) {
        f0.p(charSequence, "<this>");
        f0.p(regex, "regex");
        return regex.n(charSequence);
    }

    public static final void N4(int i10) {
        if (i10 >= 0) {
            return;
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i10).toString());
    }

    @yt.k
    public static final CharSequence N5(@yt.k CharSequence charSequence, @yt.k char... chars) {
        f0.p(charSequence, "<this>");
        f0.p(chars, "chars");
        int length = charSequence.length() - 1;
        if (length >= 0) {
            while (true) {
                int i10 = length - 1;
                if (!ArraysKt___ArraysKt.O8(chars, charSequence.charAt(length))) {
                    return charSequence.subSequence(0, length + 1);
                }
                if (i10 < 0) {
                    break;
                }
                length = i10;
            }
        }
        return "";
    }

    @yt.k
    public static final String O2(@yt.k CharSequence charSequence, @yt.k CharSequence other, boolean z10) {
        f0.p(charSequence, "<this>");
        f0.p(other, "other");
        int iMin = Math.min(charSequence.length(), other.length());
        int i10 = 0;
        while (i10 < iMin && c.J(charSequence.charAt(i10), other.charAt(i10), z10)) {
            i10++;
        }
        int i11 = i10 - 1;
        if (k3(charSequence, i11) || k3(other, i11)) {
            i10--;
        }
        return charSequence.subSequence(0, i10).toString();
    }

    @bk.f
    public static final String O3(String str) {
        return str == null ? "" : str;
    }

    @bk.f
    public static final List<String> O4(CharSequence charSequence, Regex regex, int i10) {
        f0.p(charSequence, "<this>");
        f0.p(regex, "regex");
        return regex.t(charSequence, i10);
    }

    @bk.f
    public static final String O5(String str) {
        f0.p(str, "<this>");
        return L5(str).toString();
    }

    public static /* synthetic */ String P2(CharSequence charSequence, CharSequence charSequence2, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return O2(charSequence, charSequence2, z10);
    }

    @yt.k
    public static final CharSequence P3(@yt.k CharSequence charSequence, int i10, char c10) {
        f0.p(charSequence, "<this>");
        if (i10 < 0) {
            throw new IllegalArgumentException("Desired length " + i10 + " is less than zero.");
        }
        if (i10 <= charSequence.length()) {
            return charSequence.subSequence(0, charSequence.length());
        }
        StringBuilder sb2 = new StringBuilder(i10);
        sb2.append(charSequence);
        k0 k0VarM = new qk.m(1, i10 - charSequence.length()).iterator();
        while (k0VarM.hasNext()) {
            k0VarM.b();
            sb2.append(c10);
        }
        return sb2;
    }

    @yt.k
    public static final List<String> P4(@yt.k CharSequence charSequence, @yt.k char[] delimiters, boolean z10, int i10) {
        f0.p(charSequence, "<this>");
        f0.p(delimiters, "delimiters");
        if (delimiters.length == 1) {
            return R4(charSequence, String.valueOf(delimiters[0]), z10, i10);
        }
        Iterable iterableN = SequencesKt___SequencesKt.N(Z3(charSequence, delimiters, 0, z10, i10, 2, null));
        ArrayList arrayList = new ArrayList(kotlin.collections.t.Y(iterableN, 10));
        Iterator it2 = iterableN.iterator();
        while (it2.hasNext()) {
            arrayList.add(k5(charSequence, (qk.m) it2.next()));
        }
        return arrayList;
    }

    @yt.k
    public static final String P5(@yt.k String str, @yt.k ik.l<? super Character, Boolean> predicate) {
        CharSequence charSequenceSubSequence;
        f0.p(str, "<this>");
        f0.p(predicate, "predicate");
        int length = str.length() - 1;
        if (length >= 0) {
            while (true) {
                int i10 = length - 1;
                if (!predicate.i(Character.valueOf(str.charAt(length))).booleanValue()) {
                    charSequenceSubSequence = str.subSequence(0, length + 1);
                    break;
                }
                if (i10 < 0) {
                    break;
                }
                length = i10;
            }
            charSequenceSubSequence = "";
        } else {
            charSequenceSubSequence = "";
        }
        return charSequenceSubSequence.toString();
    }

    @yt.k
    public static final String Q2(@yt.k CharSequence charSequence, @yt.k CharSequence other, boolean z10) {
        f0.p(charSequence, "<this>");
        f0.p(other, "other");
        int length = charSequence.length();
        int iMin = Math.min(length, other.length());
        int i10 = 0;
        while (i10 < iMin && c.J(charSequence.charAt((length - i10) - 1), other.charAt((r1 - i10) - 1), z10)) {
            i10++;
        }
        if (k3(charSequence, (length - i10) - 1) || k3(other, (r1 - i10) - 1)) {
            i10--;
        }
        return charSequence.subSequence(length - i10, length).toString();
    }

    @yt.k
    public static final String Q3(@yt.k String str, int i10, char c10) {
        f0.p(str, "<this>");
        return P3(str, i10, c10).toString();
    }

    @yt.k
    public static final List<String> Q4(@yt.k CharSequence charSequence, @yt.k String[] delimiters, boolean z10, int i10) {
        f0.p(charSequence, "<this>");
        f0.p(delimiters, "delimiters");
        if (delimiters.length == 1) {
            String str = delimiters[0];
            if (!(str.length() == 0)) {
                return R4(charSequence, str, z10, i10);
            }
        }
        Iterable iterableN = SequencesKt___SequencesKt.N(a4(charSequence, delimiters, 0, z10, i10, 2, null));
        ArrayList arrayList = new ArrayList(kotlin.collections.t.Y(iterableN, 10));
        Iterator it2 = iterableN.iterator();
        while (it2.hasNext()) {
            arrayList.add(k5(charSequence, (qk.m) it2.next()));
        }
        return arrayList;
    }

    @yt.k
    public static final String Q5(@yt.k String str, @yt.k char... chars) {
        CharSequence charSequenceSubSequence;
        f0.p(str, "<this>");
        f0.p(chars, "chars");
        int length = str.length() - 1;
        if (length >= 0) {
            while (true) {
                int i10 = length - 1;
                if (!ArraysKt___ArraysKt.O8(chars, str.charAt(length))) {
                    charSequenceSubSequence = str.subSequence(0, length + 1);
                    break;
                }
                if (i10 < 0) {
                    break;
                }
                length = i10;
            }
            charSequenceSubSequence = "";
        } else {
            charSequenceSubSequence = "";
        }
        return charSequenceSubSequence.toString();
    }

    public static /* synthetic */ String R2(CharSequence charSequence, CharSequence charSequence2, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return Q2(charSequence, charSequence2, z10);
    }

    public static /* synthetic */ CharSequence R3(CharSequence charSequence, int i10, char c10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            c10 = zc.f.f58383m;
        }
        return P3(charSequence, i10, c10);
    }

    public static final List<String> R4(CharSequence charSequence, String str, boolean z10, int i10) {
        N4(i10);
        int length = 0;
        int iO3 = o3(charSequence, str, 0, z10);
        if (iO3 == -1 || i10 == 1) {
            return kotlin.collections.s.k(charSequence.toString());
        }
        boolean z11 = i10 > 0;
        ArrayList arrayList = new ArrayList(z11 ? qk.v.B(i10, 10) : 10);
        do {
            arrayList.add(charSequence.subSequence(length, iO3).toString());
            length = str.length() + iO3;
            if (z11 && arrayList.size() == i10 - 1) {
                break;
            }
            iO3 = o3(charSequence, str, length, z10);
        } while (iO3 != -1);
        arrayList.add(charSequence.subSequence(length, charSequence.length()).toString());
        return arrayList;
    }

    @yt.k
    public static final CharSequence R5(@yt.k CharSequence charSequence) {
        f0.p(charSequence, "<this>");
        int length = charSequence.length();
        for (int i10 = 0; i10 < length; i10++) {
            if (!b.r(charSequence.charAt(i10))) {
                return charSequence.subSequence(i10, charSequence.length());
            }
        }
        return "";
    }

    public static final boolean S2(@yt.k CharSequence charSequence, char c10, boolean z10) {
        f0.p(charSequence, "<this>");
        return r3(charSequence, c10, 0, z10, 2, null) >= 0;
    }

    public static /* synthetic */ String S3(String str, int i10, char c10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            c10 = zc.f.f58383m;
        }
        return Q3(str, i10, c10);
    }

    public static /* synthetic */ List S4(CharSequence charSequence, Regex regex, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        f0.p(charSequence, "<this>");
        f0.p(regex, "regex");
        return regex.t(charSequence, i10);
    }

    @yt.k
    public static final CharSequence S5(@yt.k CharSequence charSequence, @yt.k ik.l<? super Character, Boolean> predicate) {
        f0.p(charSequence, "<this>");
        f0.p(predicate, "predicate");
        int length = charSequence.length();
        for (int i10 = 0; i10 < length; i10++) {
            if (!predicate.i(Character.valueOf(charSequence.charAt(i10))).booleanValue()) {
                return charSequence.subSequence(i10, charSequence.length());
            }
        }
        return "";
    }

    public static final boolean T2(@yt.k CharSequence charSequence, @yt.k CharSequence other, boolean z10) {
        f0.p(charSequence, "<this>");
        f0.p(other, "other");
        if (other instanceof String) {
            if (s3(charSequence, (String) other, 0, z10, 2, null) >= 0) {
                return true;
            }
        } else if (q3(charSequence, other, 0, charSequence.length(), z10, false, 16, null) >= 0) {
            return true;
        }
        return false;
    }

    @yt.k
    public static final CharSequence T3(@yt.k CharSequence charSequence, int i10, char c10) {
        f0.p(charSequence, "<this>");
        if (i10 < 0) {
            throw new IllegalArgumentException("Desired length " + i10 + " is less than zero.");
        }
        if (i10 <= charSequence.length()) {
            return charSequence.subSequence(0, charSequence.length());
        }
        StringBuilder sb2 = new StringBuilder(i10);
        k0 k0VarM = new qk.m(1, i10 - charSequence.length()).iterator();
        while (k0VarM.hasNext()) {
            k0VarM.b();
            sb2.append(c10);
        }
        sb2.append(charSequence);
        return sb2;
    }

    public static /* synthetic */ List T4(CharSequence charSequence, char[] cArr, boolean z10, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z10 = false;
        }
        if ((i11 & 4) != 0) {
            i10 = 0;
        }
        return P4(charSequence, cArr, z10, i10);
    }

    @yt.k
    public static final CharSequence T5(@yt.k CharSequence charSequence, @yt.k char... chars) {
        f0.p(charSequence, "<this>");
        f0.p(chars, "chars");
        int length = charSequence.length();
        for (int i10 = 0; i10 < length; i10++) {
            if (!ArraysKt___ArraysKt.O8(chars, charSequence.charAt(i10))) {
                return charSequence.subSequence(i10, charSequence.length());
            }
        }
        return "";
    }

    @bk.f
    public static final boolean U2(CharSequence charSequence, Regex regex) {
        f0.p(charSequence, "<this>");
        f0.p(regex, "regex");
        return regex.b(charSequence);
    }

    @yt.k
    public static final String U3(@yt.k String str, int i10, char c10) {
        f0.p(str, "<this>");
        return T3(str, i10, c10).toString();
    }

    public static /* synthetic */ List U4(CharSequence charSequence, String[] strArr, boolean z10, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z10 = false;
        }
        if ((i11 & 4) != 0) {
            i10 = 0;
        }
        return Q4(charSequence, strArr, z10, i10);
    }

    @bk.f
    public static final String U5(String str) {
        f0.p(str, "<this>");
        return R5(str).toString();
    }

    public static /* synthetic */ boolean V2(CharSequence charSequence, char c10, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return S2(charSequence, c10, z10);
    }

    public static /* synthetic */ CharSequence V3(CharSequence charSequence, int i10, char c10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            c10 = zc.f.f58383m;
        }
        return T3(charSequence, i10, c10);
    }

    @c2(markerClass = {kotlin.q.class})
    @bk.f
    @v0(version = "1.6")
    public static final kotlin.sequences.m<String> V4(CharSequence charSequence, Regex regex, int i10) {
        f0.p(charSequence, "<this>");
        f0.p(regex, "regex");
        return regex.v(charSequence, i10);
    }

    @yt.k
    public static final String V5(@yt.k String str, @yt.k ik.l<? super Character, Boolean> predicate) {
        CharSequence charSequenceSubSequence;
        f0.p(str, "<this>");
        f0.p(predicate, "predicate");
        int length = str.length();
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                charSequenceSubSequence = "";
                break;
            }
            if (!predicate.i(Character.valueOf(str.charAt(i10))).booleanValue()) {
                charSequenceSubSequence = str.subSequence(i10, str.length());
                break;
            }
            i10++;
        }
        return charSequenceSubSequence.toString();
    }

    public static /* synthetic */ boolean W2(CharSequence charSequence, CharSequence charSequence2, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return T2(charSequence, charSequence2, z10);
    }

    public static /* synthetic */ String W3(String str, int i10, char c10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            c10 = zc.f.f58383m;
        }
        return U3(str, i10, c10);
    }

    @yt.k
    public static final kotlin.sequences.m<String> W4(@yt.k final CharSequence charSequence, @yt.k char[] delimiters, boolean z10, int i10) {
        f0.p(charSequence, "<this>");
        f0.p(delimiters, "delimiters");
        return SequencesKt___SequencesKt.k1(Z3(charSequence, delimiters, 0, z10, i10, 2, null), new ik.l<qk.m, String>() { // from class: kotlin.text.StringsKt__StringsKt$splitToSequence$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // ik.l
            @yt.k
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final String i(@yt.k qk.m it2) {
                f0.p(it2, "it");
                return StringsKt__StringsKt.k5(charSequence, it2);
            }
        });
    }

    @yt.k
    public static final String W5(@yt.k String str, @yt.k char... chars) {
        CharSequence charSequenceSubSequence;
        f0.p(str, "<this>");
        f0.p(chars, "chars");
        int length = str.length();
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                charSequenceSubSequence = "";
                break;
            }
            if (!ArraysKt___ArraysKt.O8(chars, str.charAt(i10))) {
                charSequenceSubSequence = str.subSequence(i10, str.length());
                break;
            }
            i10++;
        }
        return charSequenceSubSequence.toString();
    }

    public static final boolean X2(@yt.l CharSequence charSequence, @yt.l CharSequence charSequence2) {
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            return u.L1((String) charSequence, (String) charSequence2, true);
        }
        if (charSequence == charSequence2) {
            return true;
        }
        if (charSequence == null || charSequence2 == null || charSequence.length() != charSequence2.length()) {
            return false;
        }
        int length = charSequence.length();
        for (int i10 = 0; i10 < length; i10++) {
            if (!c.J(charSequence.charAt(i10), charSequence2.charAt(i10), true)) {
                return false;
            }
        }
        return true;
    }

    public static final kotlin.sequences.m<qk.m> X3(CharSequence charSequence, final char[] cArr, int i10, final boolean z10, int i11) {
        N4(i11);
        return new f(charSequence, i10, i11, new ik.p<CharSequence, Integer, Pair<? extends Integer, ? extends Integer>>() { // from class: kotlin.text.StringsKt__StringsKt$rangesDelimitedBy$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @yt.l
            public final Pair<Integer, Integer> b(@yt.k CharSequence $receiver, int i12) {
                f0.p($receiver, "$this$$receiver");
                int iU3 = StringsKt__StringsKt.u3($receiver, cArr, i12, z10);
                if (iU3 < 0) {
                    return null;
                }
                return d1.a(Integer.valueOf(iU3), 1);
            }

            @Override // ik.p
            public /* bridge */ /* synthetic */ Pair<? extends Integer, ? extends Integer> r0(CharSequence charSequence2, Integer num) {
                return b(charSequence2, num.intValue());
            }
        });
    }

    @yt.k
    public static final kotlin.sequences.m<String> X4(@yt.k final CharSequence charSequence, @yt.k String[] delimiters, boolean z10, int i10) {
        f0.p(charSequence, "<this>");
        f0.p(delimiters, "delimiters");
        return SequencesKt___SequencesKt.k1(a4(charSequence, delimiters, 0, z10, i10, 2, null), new ik.l<qk.m, String>() { // from class: kotlin.text.StringsKt__StringsKt$splitToSequence$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // ik.l
            @yt.k
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final String i(@yt.k qk.m it2) {
                f0.p(it2, "it");
                return StringsKt__StringsKt.k5(charSequence, it2);
            }
        });
    }

    public static final boolean Y2(@yt.l CharSequence charSequence, @yt.l CharSequence charSequence2) {
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            return f0.g(charSequence, charSequence2);
        }
        if (charSequence == charSequence2) {
            return true;
        }
        if (charSequence == null || charSequence2 == null || charSequence.length() != charSequence2.length()) {
            return false;
        }
        int length = charSequence.length();
        for (int i10 = 0; i10 < length; i10++) {
            if (charSequence.charAt(i10) != charSequence2.charAt(i10)) {
                return false;
            }
        }
        return true;
    }

    public static final kotlin.sequences.m<qk.m> Y3(CharSequence charSequence, String[] strArr, int i10, final boolean z10, int i11) {
        N4(i11);
        final List listT = kotlin.collections.m.t(strArr);
        return new f(charSequence, i10, i11, new ik.p<CharSequence, Integer, Pair<? extends Integer, ? extends Integer>>() { // from class: kotlin.text.StringsKt__StringsKt$rangesDelimitedBy$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @yt.l
            public final Pair<Integer, Integer> b(@yt.k CharSequence $receiver, int i12) {
                f0.p($receiver, "$this$$receiver");
                Pair pairE3 = StringsKt__StringsKt.e3($receiver, listT, i12, z10, false);
                if (pairE3 != null) {
                    return d1.a(pairE3.f(), Integer.valueOf(((String) pairE3.h()).length()));
                }
                return null;
            }

            @Override // ik.p
            public /* bridge */ /* synthetic */ Pair<? extends Integer, ? extends Integer> r0(CharSequence charSequence2, Integer num) {
                return b(charSequence2, num.intValue());
            }
        });
    }

    public static /* synthetic */ kotlin.sequences.m Y4(CharSequence charSequence, Regex regex, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        f0.p(charSequence, "<this>");
        f0.p(regex, "regex");
        return regex.v(charSequence, i10);
    }

    public static final boolean Z2(@yt.k CharSequence charSequence, char c10, boolean z10) {
        f0.p(charSequence, "<this>");
        return charSequence.length() > 0 && c.J(charSequence.charAt(j3(charSequence)), c10, z10);
    }

    public static /* synthetic */ kotlin.sequences.m Z3(CharSequence charSequence, char[] cArr, int i10, boolean z10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            z10 = false;
        }
        if ((i12 & 8) != 0) {
            i11 = 0;
        }
        return X3(charSequence, cArr, i10, z10, i11);
    }

    public static /* synthetic */ kotlin.sequences.m Z4(CharSequence charSequence, char[] cArr, boolean z10, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z10 = false;
        }
        if ((i11 & 4) != 0) {
            i10 = 0;
        }
        return W4(charSequence, cArr, z10, i10);
    }

    public static final boolean a3(@yt.k CharSequence charSequence, @yt.k CharSequence suffix, boolean z10) {
        f0.p(charSequence, "<this>");
        f0.p(suffix, "suffix");
        return (!z10 && (charSequence instanceof String) && (suffix instanceof String)) ? u.K1((String) charSequence, (String) suffix, false, 2, null) : b4(charSequence, charSequence.length() - suffix.length(), suffix, 0, suffix.length(), z10);
    }

    public static /* synthetic */ kotlin.sequences.m a4(CharSequence charSequence, String[] strArr, int i10, boolean z10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            z10 = false;
        }
        if ((i12 & 8) != 0) {
            i11 = 0;
        }
        return Y3(charSequence, strArr, i10, z10, i11);
    }

    public static /* synthetic */ kotlin.sequences.m a5(CharSequence charSequence, String[] strArr, boolean z10, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z10 = false;
        }
        if ((i11 & 4) != 0) {
            i10 = 0;
        }
        return X4(charSequence, strArr, z10, i10);
    }

    public static /* synthetic */ boolean b3(CharSequence charSequence, char c10, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return Z2(charSequence, c10, z10);
    }

    public static final boolean b4(@yt.k CharSequence charSequence, int i10, @yt.k CharSequence other, int i11, int i12, boolean z10) {
        f0.p(charSequence, "<this>");
        f0.p(other, "other");
        if (i11 < 0 || i10 < 0 || i10 > charSequence.length() - i12 || i11 > other.length() - i12) {
            return false;
        }
        for (int i13 = 0; i13 < i12; i13++) {
            if (!c.J(charSequence.charAt(i10 + i13), other.charAt(i11 + i13), z10)) {
                return false;
            }
        }
        return true;
    }

    public static final boolean b5(@yt.k CharSequence charSequence, char c10, boolean z10) {
        f0.p(charSequence, "<this>");
        return charSequence.length() > 0 && c.J(charSequence.charAt(0), c10, z10);
    }

    public static /* synthetic */ boolean c3(CharSequence charSequence, CharSequence charSequence2, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return a3(charSequence, charSequence2, z10);
    }

    @yt.k
    public static final CharSequence c4(@yt.k CharSequence charSequence, @yt.k CharSequence prefix) {
        f0.p(charSequence, "<this>");
        f0.p(prefix, "prefix");
        return g5(charSequence, prefix, false, 2, null) ? charSequence.subSequence(prefix.length(), charSequence.length()) : charSequence.subSequence(0, charSequence.length());
    }

    public static final boolean c5(@yt.k CharSequence charSequence, @yt.k CharSequence prefix, int i10, boolean z10) {
        f0.p(charSequence, "<this>");
        f0.p(prefix, "prefix");
        return (!z10 && (charSequence instanceof String) && (prefix instanceof String)) ? u.u2((String) charSequence, (String) prefix, i10, false, 4, null) : b4(charSequence, i10, prefix, 0, prefix.length(), z10);
    }

    @yt.l
    public static final Pair<Integer, String> d3(@yt.k CharSequence charSequence, @yt.k Collection<String> strings, int i10, boolean z10) {
        f0.p(charSequence, "<this>");
        f0.p(strings, "strings");
        return e3(charSequence, strings, i10, z10, false);
    }

    @yt.k
    public static final String d4(@yt.k String str, @yt.k CharSequence prefix) {
        f0.p(str, "<this>");
        f0.p(prefix, "prefix");
        if (!g5(str, prefix, false, 2, null)) {
            return str;
        }
        String strSubstring = str.substring(prefix.length());
        f0.o(strSubstring, "this as java.lang.String).substring(startIndex)");
        return strSubstring;
    }

    public static final boolean d5(@yt.k CharSequence charSequence, @yt.k CharSequence prefix, boolean z10) {
        f0.p(charSequence, "<this>");
        f0.p(prefix, "prefix");
        return (!z10 && (charSequence instanceof String) && (prefix instanceof String)) ? u.v2((String) charSequence, (String) prefix, false, 2, null) : b4(charSequence, 0, prefix, 0, prefix.length(), z10);
    }

    public static final Pair<Integer, String> e3(CharSequence charSequence, Collection<String> collection, int i10, boolean z10, boolean z11) {
        Object next;
        Object next2;
        if (!z10 && collection.size() == 1) {
            String str = (String) CollectionsKt___CollectionsKt.a5(collection);
            int iS3 = !z11 ? s3(charSequence, str, i10, false, 4, null) : G3(charSequence, str, i10, false, 4, null);
            if (iS3 < 0) {
                return null;
            }
            return d1.a(Integer.valueOf(iS3), str);
        }
        qk.k mVar = !z11 ? new qk.m(qk.v.u(i10, 0), charSequence.length()) : qk.v.k0(qk.v.B(i10, j3(charSequence)), 0);
        if (charSequence instanceof String) {
            int iG = mVar.g();
            int iJ = mVar.j();
            int iL = mVar.l();
            if ((iL > 0 && iG <= iJ) || (iL < 0 && iJ <= iG)) {
                while (true) {
                    Iterator<T> it2 = collection.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            next2 = null;
                            break;
                        }
                        next2 = it2.next();
                        String str2 = (String) next2;
                        if (u.e2(str2, 0, (String) charSequence, iG, str2.length(), z10)) {
                            break;
                        }
                    }
                    String str3 = (String) next2;
                    if (str3 == null) {
                        if (iG == iJ) {
                            break;
                        }
                        iG += iL;
                    } else {
                        return d1.a(Integer.valueOf(iG), str3);
                    }
                }
            }
        } else {
            int iG2 = mVar.g();
            int iJ2 = mVar.j();
            int iL2 = mVar.l();
            if ((iL2 > 0 && iG2 <= iJ2) || (iL2 < 0 && iJ2 <= iG2)) {
                while (true) {
                    Iterator<T> it3 = collection.iterator();
                    while (true) {
                        if (!it3.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it3.next();
                        String str4 = (String) next;
                        if (b4(str4, 0, charSequence, iG2, str4.length(), z10)) {
                            break;
                        }
                    }
                    String str5 = (String) next;
                    if (str5 == null) {
                        if (iG2 == iJ2) {
                            break;
                        }
                        iG2 += iL2;
                    } else {
                        return d1.a(Integer.valueOf(iG2), str5);
                    }
                }
            }
        }
        return null;
    }

    @yt.k
    public static final CharSequence e4(@yt.k CharSequence charSequence, int i10, int i11) {
        f0.p(charSequence, "<this>");
        if (i11 < i10) {
            throw new IndexOutOfBoundsException("End index (" + i11 + ") is less than start index (" + i10 + ").");
        }
        if (i11 == i10) {
            return charSequence.subSequence(0, charSequence.length());
        }
        StringBuilder sb2 = new StringBuilder(charSequence.length() - (i11 - i10));
        sb2.append(charSequence, 0, i10);
        f0.o(sb2, "this.append(value, startIndex, endIndex)");
        sb2.append(charSequence, i11, charSequence.length());
        f0.o(sb2, "this.append(value, startIndex, endIndex)");
        return sb2;
    }

    public static /* synthetic */ boolean e5(CharSequence charSequence, char c10, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return b5(charSequence, c10, z10);
    }

    public static /* synthetic */ Pair f3(CharSequence charSequence, Collection collection, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        return d3(charSequence, collection, i10, z10);
    }

    @yt.k
    public static final CharSequence f4(@yt.k CharSequence charSequence, @yt.k qk.m range) {
        f0.p(charSequence, "<this>");
        f0.p(range, "range");
        return e4(charSequence, range.a().intValue(), range.e().intValue() + 1);
    }

    public static /* synthetic */ boolean f5(CharSequence charSequence, CharSequence charSequence2, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        return c5(charSequence, charSequence2, i10, z10);
    }

    @yt.l
    public static final Pair<Integer, String> g3(@yt.k CharSequence charSequence, @yt.k Collection<String> strings, int i10, boolean z10) {
        f0.p(charSequence, "<this>");
        f0.p(strings, "strings");
        return e3(charSequence, strings, i10, z10, true);
    }

    @bk.f
    public static final String g4(String str, int i10, int i11) {
        f0.p(str, "<this>");
        return e4(str, i10, i11).toString();
    }

    public static /* synthetic */ boolean g5(CharSequence charSequence, CharSequence charSequence2, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return d5(charSequence, charSequence2, z10);
    }

    public static /* synthetic */ Pair h3(CharSequence charSequence, Collection collection, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = j3(charSequence);
        }
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        return g3(charSequence, collection, i10, z10);
    }

    @bk.f
    public static final String h4(String str, qk.m range) {
        f0.p(str, "<this>");
        f0.p(range, "range");
        return f4(str, range).toString();
    }

    @yt.k
    public static final CharSequence h5(@yt.k CharSequence charSequence, @yt.k qk.m range) {
        f0.p(charSequence, "<this>");
        f0.p(range, "range");
        return charSequence.subSequence(range.a().intValue(), range.e().intValue() + 1);
    }

    @yt.k
    public static final qk.m i3(@yt.k CharSequence charSequence) {
        f0.p(charSequence, "<this>");
        return new qk.m(0, charSequence.length() - 1);
    }

    @yt.k
    public static final CharSequence i4(@yt.k CharSequence charSequence, @yt.k CharSequence suffix) {
        f0.p(charSequence, "<this>");
        f0.p(suffix, "suffix");
        return c3(charSequence, suffix, false, 2, null) ? charSequence.subSequence(0, charSequence.length() - suffix.length()) : charSequence.subSequence(0, charSequence.length());
    }

    @bk.f
    @kotlin.k(message = "Use parameters named startIndex and endIndex.", replaceWith = @kotlin.t0(expression = "subSequence(startIndex = start, endIndex = end)", imports = {}))
    public static final CharSequence i5(String str, int i10, int i11) {
        f0.p(str, "<this>");
        return str.subSequence(i10, i11);
    }

    public static final int j3(@yt.k CharSequence charSequence) {
        f0.p(charSequence, "<this>");
        return charSequence.length() - 1;
    }

    @yt.k
    public static final String j4(@yt.k String str, @yt.k CharSequence suffix) {
        f0.p(str, "<this>");
        f0.p(suffix, "suffix");
        if (!c3(str, suffix, false, 2, null)) {
            return str;
        }
        String strSubstring = str.substring(0, str.length() - suffix.length());
        f0.o(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    @bk.f
    public static final String j5(CharSequence charSequence, int i10, int i11) {
        f0.p(charSequence, "<this>");
        return charSequence.subSequence(i10, i11).toString();
    }

    public static final boolean k3(@yt.k CharSequence charSequence, int i10) {
        f0.p(charSequence, "<this>");
        return new qk.m(0, charSequence.length() + (-2)).p(i10) && Character.isHighSurrogate(charSequence.charAt(i10)) && Character.isLowSurrogate(charSequence.charAt(i10 + 1));
    }

    @yt.k
    public static final CharSequence k4(@yt.k CharSequence charSequence, @yt.k CharSequence delimiter) {
        f0.p(charSequence, "<this>");
        f0.p(delimiter, "delimiter");
        return l4(charSequence, delimiter, delimiter);
    }

    @yt.k
    public static final String k5(@yt.k CharSequence charSequence, @yt.k qk.m range) {
        f0.p(charSequence, "<this>");
        f0.p(range, "range");
        return charSequence.subSequence(range.a().intValue(), range.e().intValue() + 1).toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @bk.f
    @v0(version = "1.3")
    public static final <C extends CharSequence & R, R> R l3(C c10, ik.a<? extends R> defaultValue) {
        f0.p(defaultValue, "defaultValue");
        return u.V1(c10) ? defaultValue.o() : c10;
    }

    @yt.k
    public static final CharSequence l4(@yt.k CharSequence charSequence, @yt.k CharSequence prefix, @yt.k CharSequence suffix) {
        f0.p(charSequence, "<this>");
        f0.p(prefix, "prefix");
        f0.p(suffix, "suffix");
        return (charSequence.length() >= prefix.length() + suffix.length() && g5(charSequence, prefix, false, 2, null) && c3(charSequence, suffix, false, 2, null)) ? charSequence.subSequence(prefix.length(), charSequence.length() - suffix.length()) : charSequence.subSequence(0, charSequence.length());
    }

    @yt.k
    public static final String l5(@yt.k String str, @yt.k qk.m range) {
        f0.p(str, "<this>");
        f0.p(range, "range");
        String strSubstring = str.substring(range.a().intValue(), range.e().intValue() + 1);
        f0.o(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @bk.f
    @v0(version = "1.3")
    public static final <C extends CharSequence & R, R> R m3(C c10, ik.a<? extends R> defaultValue) {
        f0.p(defaultValue, "defaultValue");
        return c10.length() == 0 ? defaultValue.o() : c10;
    }

    @yt.k
    public static final String m4(@yt.k String str, @yt.k CharSequence delimiter) {
        f0.p(str, "<this>");
        f0.p(delimiter, "delimiter");
        return n4(str, delimiter, delimiter);
    }

    public static /* synthetic */ String m5(CharSequence charSequence, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i11 = charSequence.length();
        }
        f0.p(charSequence, "<this>");
        return charSequence.subSequence(i10, i11).toString();
    }

    public static final int n3(@yt.k CharSequence charSequence, char c10, int i10, boolean z10) {
        f0.p(charSequence, "<this>");
        return (z10 || !(charSequence instanceof String)) ? u3(charSequence, new char[]{c10}, i10, z10) : ((String) charSequence).indexOf(c10, i10);
    }

    @yt.k
    public static final String n4(@yt.k String str, @yt.k CharSequence prefix, @yt.k CharSequence suffix) {
        f0.p(str, "<this>");
        f0.p(prefix, "prefix");
        f0.p(suffix, "suffix");
        if (str.length() < prefix.length() + suffix.length() || !g5(str, prefix, false, 2, null) || !c3(str, suffix, false, 2, null)) {
            return str;
        }
        String strSubstring = str.substring(prefix.length(), str.length() - suffix.length());
        f0.o(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    @yt.k
    public static final String n5(@yt.k String str, char c10, @yt.k String missingDelimiterValue) {
        f0.p(str, "<this>");
        f0.p(missingDelimiterValue, "missingDelimiterValue");
        int iR3 = r3(str, c10, 0, false, 6, null);
        if (iR3 == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = str.substring(iR3 + 1, str.length());
        f0.o(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static final int o3(@yt.k CharSequence charSequence, @yt.k String string, int i10, boolean z10) {
        f0.p(charSequence, "<this>");
        f0.p(string, "string");
        return (z10 || !(charSequence instanceof String)) ? q3(charSequence, string, i10, charSequence.length(), z10, false, 16, null) : ((String) charSequence).indexOf(string, i10);
    }

    @bk.f
    public static final String o4(CharSequence charSequence, Regex regex, ik.l<? super k, ? extends CharSequence> transform) {
        f0.p(charSequence, "<this>");
        f0.p(regex, "regex");
        f0.p(transform, "transform");
        return regex.p(charSequence, transform);
    }

    @yt.k
    public static final String o5(@yt.k String str, @yt.k String delimiter, @yt.k String missingDelimiterValue) {
        f0.p(str, "<this>");
        f0.p(delimiter, "delimiter");
        f0.p(missingDelimiterValue, "missingDelimiterValue");
        int iS3 = s3(str, delimiter, 0, false, 6, null);
        if (iS3 == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = str.substring(iS3 + delimiter.length(), str.length());
        f0.o(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static final int p3(CharSequence charSequence, CharSequence charSequence2, int i10, int i11, boolean z10, boolean z11) {
        qk.k mVar = !z11 ? new qk.m(qk.v.u(i10, 0), qk.v.B(i11, charSequence.length())) : qk.v.k0(qk.v.B(i10, j3(charSequence)), qk.v.u(i11, 0));
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            int iG = mVar.g();
            int iJ = mVar.j();
            int iL = mVar.l();
            if ((iL <= 0 || iG > iJ) && (iL >= 0 || iJ > iG)) {
                return -1;
            }
            while (!u.e2((String) charSequence2, 0, (String) charSequence, iG, charSequence2.length(), z10)) {
                if (iG == iJ) {
                    return -1;
                }
                iG += iL;
            }
            return iG;
        }
        int iG2 = mVar.g();
        int iJ2 = mVar.j();
        int iL2 = mVar.l();
        if ((iL2 <= 0 || iG2 > iJ2) && (iL2 >= 0 || iJ2 > iG2)) {
            return -1;
        }
        while (!b4(charSequence2, 0, charSequence, iG2, charSequence2.length(), z10)) {
            if (iG2 == iJ2) {
                return -1;
            }
            iG2 += iL2;
        }
        return iG2;
    }

    @bk.f
    public static final String p4(CharSequence charSequence, Regex regex, String replacement) {
        f0.p(charSequence, "<this>");
        f0.p(regex, "regex");
        f0.p(replacement, "replacement");
        return regex.q(charSequence, replacement);
    }

    public static /* synthetic */ String p5(String str, char c10, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = str;
        }
        return n5(str, c10, str2);
    }

    public static /* synthetic */ int q3(CharSequence charSequence, CharSequence charSequence2, int i10, int i11, boolean z10, boolean z11, int i12, Object obj) {
        return p3(charSequence, charSequence2, i10, i11, z10, (i12 & 16) != 0 ? false : z11);
    }

    @yt.k
    public static final String q4(@yt.k String str, char c10, @yt.k String replacement, @yt.k String missingDelimiterValue) {
        f0.p(str, "<this>");
        f0.p(replacement, "replacement");
        f0.p(missingDelimiterValue, "missingDelimiterValue");
        int iR3 = r3(str, c10, 0, false, 6, null);
        return iR3 == -1 ? missingDelimiterValue : J4(str, iR3 + 1, str.length(), replacement).toString();
    }

    public static /* synthetic */ String q5(String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str3 = str;
        }
        return o5(str, str2, str3);
    }

    public static /* synthetic */ int r3(CharSequence charSequence, char c10, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        return n3(charSequence, c10, i10, z10);
    }

    @yt.k
    public static final String r4(@yt.k String str, @yt.k String delimiter, @yt.k String replacement, @yt.k String missingDelimiterValue) {
        f0.p(str, "<this>");
        f0.p(delimiter, "delimiter");
        f0.p(replacement, "replacement");
        f0.p(missingDelimiterValue, "missingDelimiterValue");
        int iS3 = s3(str, delimiter, 0, false, 6, null);
        return iS3 == -1 ? missingDelimiterValue : J4(str, iS3 + delimiter.length(), str.length(), replacement).toString();
    }

    @yt.k
    public static final String r5(@yt.k String str, char c10, @yt.k String missingDelimiterValue) {
        f0.p(str, "<this>");
        f0.p(missingDelimiterValue, "missingDelimiterValue");
        int iF3 = F3(str, c10, 0, false, 6, null);
        if (iF3 == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = str.substring(iF3 + 1, str.length());
        f0.o(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static /* synthetic */ int s3(CharSequence charSequence, String str, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        return o3(charSequence, str, i10, z10);
    }

    public static /* synthetic */ String s4(String str, char c10, String str2, String str3, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            str3 = str;
        }
        return q4(str, c10, str2, str3);
    }

    @yt.k
    public static final String s5(@yt.k String str, @yt.k String delimiter, @yt.k String missingDelimiterValue) {
        f0.p(str, "<this>");
        f0.p(delimiter, "delimiter");
        f0.p(missingDelimiterValue, "missingDelimiterValue");
        int iG3 = G3(str, delimiter, 0, false, 6, null);
        if (iG3 == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = str.substring(iG3 + delimiter.length(), str.length());
        f0.o(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static final int t3(@yt.k CharSequence charSequence, @yt.k Collection<String> strings, int i10, boolean z10) {
        f0.p(charSequence, "<this>");
        f0.p(strings, "strings");
        Pair<Integer, String> pairE3 = e3(charSequence, strings, i10, z10, false);
        if (pairE3 != null) {
            return pairE3.f().intValue();
        }
        return -1;
    }

    public static /* synthetic */ String t4(String str, String str2, String str3, String str4, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            str4 = str;
        }
        return r4(str, str2, str3, str4);
    }

    public static /* synthetic */ String t5(String str, char c10, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = str;
        }
        return r5(str, c10, str2);
    }

    public static final int u3(@yt.k CharSequence charSequence, @yt.k char[] chars, int i10, boolean z10) {
        boolean z11;
        f0.p(charSequence, "<this>");
        f0.p(chars, "chars");
        if (!z10 && chars.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(ArraysKt___ArraysKt.wt(chars), i10);
        }
        k0 k0VarM = new qk.m(qk.v.u(i10, 0), j3(charSequence)).iterator();
        while (k0VarM.hasNext()) {
            int iB = k0VarM.b();
            char cCharAt = charSequence.charAt(iB);
            int length = chars.length;
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    z11 = false;
                    break;
                }
                if (c.J(chars[i11], cCharAt, z10)) {
                    z11 = true;
                    break;
                }
                i11++;
            }
            if (z11) {
                return iB;
            }
        }
        return -1;
    }

    @yt.k
    public static final String u4(@yt.k String str, char c10, @yt.k String replacement, @yt.k String missingDelimiterValue) {
        f0.p(str, "<this>");
        f0.p(replacement, "replacement");
        f0.p(missingDelimiterValue, "missingDelimiterValue");
        int iF3 = F3(str, c10, 0, false, 6, null);
        return iF3 == -1 ? missingDelimiterValue : J4(str, iF3 + 1, str.length(), replacement).toString();
    }

    public static /* synthetic */ String u5(String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str3 = str;
        }
        return s5(str, str2, str3);
    }

    public static /* synthetic */ int v3(CharSequence charSequence, Collection collection, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        return t3(charSequence, collection, i10, z10);
    }

    @yt.k
    public static final String v4(@yt.k String str, @yt.k String delimiter, @yt.k String replacement, @yt.k String missingDelimiterValue) {
        f0.p(str, "<this>");
        f0.p(delimiter, "delimiter");
        f0.p(replacement, "replacement");
        f0.p(missingDelimiterValue, "missingDelimiterValue");
        int iG3 = G3(str, delimiter, 0, false, 6, null);
        return iG3 == -1 ? missingDelimiterValue : J4(str, iG3 + delimiter.length(), str.length(), replacement).toString();
    }

    @yt.k
    public static final String v5(@yt.k String str, char c10, @yt.k String missingDelimiterValue) {
        f0.p(str, "<this>");
        f0.p(missingDelimiterValue, "missingDelimiterValue");
        int iR3 = r3(str, c10, 0, false, 6, null);
        if (iR3 == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = str.substring(0, iR3);
        f0.o(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static /* synthetic */ int w3(CharSequence charSequence, char[] cArr, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        return u3(charSequence, cArr, i10, z10);
    }

    public static /* synthetic */ String w4(String str, char c10, String str2, String str3, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            str3 = str;
        }
        return u4(str, c10, str2, str3);
    }

    @yt.k
    public static final String w5(@yt.k String str, @yt.k String delimiter, @yt.k String missingDelimiterValue) {
        f0.p(str, "<this>");
        f0.p(delimiter, "delimiter");
        f0.p(missingDelimiterValue, "missingDelimiterValue");
        int iS3 = s3(str, delimiter, 0, false, 6, null);
        if (iS3 == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = str.substring(0, iS3);
        f0.o(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    @bk.f
    public static final boolean x3(CharSequence charSequence) {
        f0.p(charSequence, "<this>");
        return charSequence.length() == 0;
    }

    public static /* synthetic */ String x4(String str, String str2, String str3, String str4, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            str4 = str;
        }
        return v4(str, str2, str3, str4);
    }

    public static /* synthetic */ String x5(String str, char c10, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = str;
        }
        return v5(str, c10, str2);
    }

    @bk.f
    public static final boolean y3(CharSequence charSequence) {
        f0.p(charSequence, "<this>");
        return !u.V1(charSequence);
    }

    @yt.k
    public static final String y4(@yt.k String str, char c10, @yt.k String replacement, @yt.k String missingDelimiterValue) {
        f0.p(str, "<this>");
        f0.p(replacement, "replacement");
        f0.p(missingDelimiterValue, "missingDelimiterValue");
        int iR3 = r3(str, c10, 0, false, 6, null);
        return iR3 == -1 ? missingDelimiterValue : J4(str, 0, iR3, replacement).toString();
    }

    public static /* synthetic */ String y5(String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str3 = str;
        }
        return w5(str, str2, str3);
    }

    @bk.f
    public static final boolean z3(CharSequence charSequence) {
        f0.p(charSequence, "<this>");
        return charSequence.length() > 0;
    }

    @yt.k
    public static final String z4(@yt.k String str, @yt.k String delimiter, @yt.k String replacement, @yt.k String missingDelimiterValue) {
        f0.p(str, "<this>");
        f0.p(delimiter, "delimiter");
        f0.p(replacement, "replacement");
        f0.p(missingDelimiterValue, "missingDelimiterValue");
        int iS3 = s3(str, delimiter, 0, false, 6, null);
        return iS3 == -1 ? missingDelimiterValue : J4(str, 0, iS3, replacement).toString();
    }

    @yt.k
    public static final String z5(@yt.k String str, char c10, @yt.k String missingDelimiterValue) {
        f0.p(str, "<this>");
        f0.p(missingDelimiterValue, "missingDelimiterValue");
        int iF3 = F3(str, c10, 0, false, 6, null);
        if (iF3 == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = str.substring(0, iF3);
        f0.o(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }
}
