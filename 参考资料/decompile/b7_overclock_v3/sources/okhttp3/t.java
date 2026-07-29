package okhttp3;

import com.arialyy.aria.core.inf.IOptionConstant;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser;
import com.umeng.analytics.pro.an;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import kotlin.DeprecationLevel;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.d1;
import kotlin.jvm.internal.v0;
import kotlin.t0;
import kotlin.text.StringsKt__StringsKt;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.d0(bv = {}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\"\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0006\u0018\u0000 \u00152\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u0002\u000b\u0015B\u0017\b\u0002\u0012\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00030\"¢\u0006\u0004\b&\u0010'J\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0086\u0002J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0004\u001a\u00020\u0003J\u0012\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0004\u001a\u00020\u0003H\u0007J\u000f\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\nJ\u000e\u0010\u000f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\nJ\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010J\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u00122\u0006\u0010\u0004\u001a\u00020\u0003J\u0006\u0010\u0015\u001a\u00020\u0014J\u001b\u0010\u0017\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u0016H\u0096\u0002J\u0006\u0010\u0019\u001a\u00020\u0018J\u0013\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0096\u0002J\b\u0010\u001e\u001a\u00020\nH\u0016J\b\u0010\u001f\u001a\u00020\u0003H\u0016J\u0018\u0010!\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00120 R\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00030\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010#R\u0011\u0010%\u001a\u00020\n8G¢\u0006\u0006\u001a\u0004\b%\u0010\f¨\u0006("}, d2 = {"Lokhttp3/t;", "", "Lkotlin/Pair;", "", "name", "d", "Ljava/util/Date;", "e", "Ljava/time/Instant;", "g", "", "a", "()I", "index", xf.j.f55230b, SsManifestParser.e.J, "", com.flydigi.sdk.bluetooth.l.f16298a, "", an.aB, "", "b", "", "iterator", "Lokhttp3/t$a;", m0.k.f40564b, "", "other", "", "equals", "hashCode", "toString", "", "q", "", "[Ljava/lang/String;", "namesAndValues", "size", "<init>", "([Ljava/lang/String;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class t implements Iterable<Pair<? extends String, ? extends String>>, jk.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public static final b f43945b = new b(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final String[] f43946a;

    @kotlin.d0(bv = {}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010!\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\t\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002J\u0016\u0010\n\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002J\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000bJ\u0016\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u000eJ\u0018\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0010H\u0007J\u0019\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u000eH\u0086\u0002J\u0019\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0010H\u0087\u0002J\u001f\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0002J\u0019\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0086\u0002J\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0086\u0002J\u0006\u0010\u0019\u001a\u00020\u000bR \u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00020\u001a8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006!"}, d2 = {"Lokhttp3/t$a;", "", "", "line", "f", "(Ljava/lang/String;)Lokhttp3/t$a;", "a", "name", "value", "b", "h", "Lokhttp3/t;", IOptionConstant.headers, "e", "Ljava/util/Date;", "d", "Ljava/time/Instant;", "c", "o", "n", "g", "(Ljava/lang/String;Ljava/lang/String;)Lokhttp3/t$a;", com.flydigi.sdk.bluetooth.l.f16298a, m0.k.f40564b, xf.j.f55230b, "i", "", "Ljava/util/List;", "k", "()Ljava/util/List;", "namesAndValues", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @yt.k
        public final List<String> f43947a = new ArrayList(20);

        @yt.k
        public final a a(@yt.k String line) {
            kotlin.jvm.internal.f0.p(line, "line");
            int iR3 = StringsKt__StringsKt.r3(line, ':', 0, false, 6, null);
            if (!(iR3 != -1)) {
                throw new IllegalArgumentException(kotlin.jvm.internal.f0.C("Unexpected header: ", line).toString());
            }
            String strSubstring = line.substring(0, iR3);
            kotlin.jvm.internal.f0.o(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            String string = StringsKt__StringsKt.F5(strSubstring).toString();
            String strSubstring2 = line.substring(iR3 + 1);
            kotlin.jvm.internal.f0.o(strSubstring2, "this as java.lang.String).substring(startIndex)");
            b(string, strSubstring2);
            return this;
        }

        @yt.k
        public final a b(@yt.k String name, @yt.k String value) {
            kotlin.jvm.internal.f0.p(name, "name");
            kotlin.jvm.internal.f0.p(value, "value");
            b bVar = t.f43945b;
            bVar.f(name);
            bVar.g(value, name);
            g(name, value);
            return this;
        }

        @yt.k
        @IgnoreJRERequirement
        public final a c(@yt.k String name, @yt.k Instant value) {
            kotlin.jvm.internal.f0.p(name, "name");
            kotlin.jvm.internal.f0.p(value, "value");
            d(name, new Date(value.toEpochMilli()));
            return this;
        }

        @yt.k
        public final a d(@yt.k String name, @yt.k Date value) {
            kotlin.jvm.internal.f0.p(name, "name");
            kotlin.jvm.internal.f0.p(value, "value");
            b(name, vl.c.b(value));
            return this;
        }

        @yt.k
        public final a e(@yt.k t headers) {
            kotlin.jvm.internal.f0.p(headers, "headers");
            int size = headers.size();
            for (int i10 = 0; i10 < size; i10++) {
                g(headers.j(i10), headers.r(i10));
            }
            return this;
        }

        @yt.k
        public final a f(@yt.k String line) {
            kotlin.jvm.internal.f0.p(line, "line");
            int iR3 = StringsKt__StringsKt.r3(line, ':', 1, false, 4, null);
            if (iR3 != -1) {
                String strSubstring = line.substring(0, iR3);
                kotlin.jvm.internal.f0.o(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                String strSubstring2 = line.substring(iR3 + 1);
                kotlin.jvm.internal.f0.o(strSubstring2, "this as java.lang.String).substring(startIndex)");
                g(strSubstring, strSubstring2);
            } else if (line.charAt(0) == ':') {
                String strSubstring3 = line.substring(1);
                kotlin.jvm.internal.f0.o(strSubstring3, "this as java.lang.String).substring(startIndex)");
                g("", strSubstring3);
            } else {
                g("", line);
            }
            return this;
        }

        @yt.k
        public final a g(@yt.k String name, @yt.k String value) {
            kotlin.jvm.internal.f0.p(name, "name");
            kotlin.jvm.internal.f0.p(value, "value");
            k().add(name);
            k().add(StringsKt__StringsKt.F5(value).toString());
            return this;
        }

        @yt.k
        public final a h(@yt.k String name, @yt.k String value) {
            kotlin.jvm.internal.f0.p(name, "name");
            kotlin.jvm.internal.f0.p(value, "value");
            t.f43945b.f(name);
            g(name, value);
            return this;
        }

        @yt.k
        public final t i() {
            Object[] array = this.f43947a.toArray(new String[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            return new t((String[]) array, null);
        }

        @yt.l
        public final String j(@yt.k String name) {
            kotlin.jvm.internal.f0.p(name, "name");
            int size = this.f43947a.size() - 2;
            int iC = bk.n.c(size, 0, -2);
            if (iC > size) {
                return null;
            }
            while (true) {
                int i10 = size - 2;
                if (kotlin.text.u.L1(name, this.f43947a.get(size), true)) {
                    return this.f43947a.get(size + 1);
                }
                if (size == iC) {
                    return null;
                }
                size = i10;
            }
        }

        @yt.k
        public final List<String> k() {
            return this.f43947a;
        }

        @yt.k
        public final a l(@yt.k String name) {
            kotlin.jvm.internal.f0.p(name, "name");
            int i10 = 0;
            while (i10 < k().size()) {
                if (kotlin.text.u.L1(name, k().get(i10), true)) {
                    k().remove(i10);
                    k().remove(i10);
                    i10 -= 2;
                }
                i10 += 2;
            }
            return this;
        }

        @yt.k
        public final a m(@yt.k String name, @yt.k String value) {
            kotlin.jvm.internal.f0.p(name, "name");
            kotlin.jvm.internal.f0.p(value, "value");
            b bVar = t.f43945b;
            bVar.f(name);
            bVar.g(value, name);
            l(name);
            g(name, value);
            return this;
        }

        @yt.k
        @IgnoreJRERequirement
        public final a n(@yt.k String name, @yt.k Instant value) {
            kotlin.jvm.internal.f0.p(name, "name");
            kotlin.jvm.internal.f0.p(value, "value");
            return o(name, new Date(value.toEpochMilli()));
        }

        @yt.k
        public final a o(@yt.k String name, @yt.k Date value) {
            kotlin.jvm.internal.f0.p(name, "name");
            kotlin.jvm.internal.f0.p(value, "value");
            m(name, vl.c.b(value));
            return this;
        }
    }

    @kotlin.d0(bv = {}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0015\u0010\u0016J#\u0010\u0006\u001a\u00020\u00052\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002\"\u00020\u0003H\u0007¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\b\u001a\u00020\u00052\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002\"\u00020\u0003H\u0007¢\u0006\u0004\b\b\u0010\u0007J\u001f\u0010\n\u001a\u00020\u0005*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\tH\u0007¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\r\u001a\u00020\u00052\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\tH\u0007¢\u0006\u0004\b\r\u0010\u000bJ'\u0010\u000f\u001a\u0004\u0018\u00010\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u000e\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u0003H\u0002J\u0018\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003H\u0002¨\u0006\u0017"}, d2 = {"Lokhttp3/t$b;", "", "", "", "namesAndValues", "Lokhttp3/t;", xf.j.f55230b, "([Ljava/lang/String;)Lokhttp3/t;", "b", "", "i", "(Ljava/util/Map;)Lokhttp3/t;", IOptionConstant.headers, "a", "name", "h", "([Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "Lkotlin/z1;", "f", "value", "g", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class b {
        public b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.u uVar) {
            this();
        }

        @hk.h(name = "-deprecated_of")
        @kotlin.k(level = DeprecationLevel.ERROR, message = "function moved to extension", replaceWith = @t0(expression = "headers.toHeaders()", imports = {}))
        @yt.k
        public final t a(@yt.k Map<String, String> headers) {
            kotlin.jvm.internal.f0.p(headers, "headers");
            return i(headers);
        }

        @hk.h(name = "-deprecated_of")
        @kotlin.k(level = DeprecationLevel.ERROR, message = "function name changed", replaceWith = @t0(expression = "headersOf(*namesAndValues)", imports = {}))
        @yt.k
        public final t b(@yt.k String... namesAndValues) {
            kotlin.jvm.internal.f0.p(namesAndValues, "namesAndValues");
            return j((String[]) Arrays.copyOf(namesAndValues, namesAndValues.length));
        }

        public final void f(String str) {
            if (!(str.length() > 0)) {
                throw new IllegalArgumentException("name is empty".toString());
            }
            int length = str.length();
            int i10 = 0;
            while (i10 < length) {
                int i11 = i10 + 1;
                char cCharAt = str.charAt(i10);
                if (!('!' <= cCharAt && cCharAt < 127)) {
                    throw new IllegalArgumentException(rl.f.y("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(cCharAt), Integer.valueOf(i10), str).toString());
                }
                i10 = i11;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0023  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void g(java.lang.String r8, java.lang.String r9) {
            /*
                r7 = this;
                int r0 = r8.length()
                r1 = 0
                r2 = 0
            L6:
                if (r2 >= r0) goto L5d
                int r3 = r2 + 1
                char r4 = r8.charAt(r2)
                r5 = 9
                r6 = 1
                if (r4 == r5) goto L23
                r5 = 32
                if (r5 > r4) goto L1d
                r5 = 127(0x7f, float:1.78E-43)
                if (r4 >= r5) goto L1d
                r5 = 1
                goto L1e
            L1d:
                r5 = 0
            L1e:
                if (r5 == 0) goto L21
                goto L23
            L21:
                r5 = 0
                goto L24
            L23:
                r5 = 1
            L24:
                if (r5 != 0) goto L5b
                r0 = 3
                java.lang.Object[] r0 = new java.lang.Object[r0]
                java.lang.Integer r3 = java.lang.Integer.valueOf(r4)
                r0[r1] = r3
                java.lang.Integer r1 = java.lang.Integer.valueOf(r2)
                r0[r6] = r1
                r1 = 2
                r0[r1] = r9
                java.lang.String r1 = "Unexpected char %#04x at %d in %s value"
                java.lang.String r0 = rl.f.y(r1, r0)
                boolean r9 = rl.f.O(r9)
                if (r9 == 0) goto L47
                java.lang.String r8 = ""
                goto L4d
            L47:
                java.lang.String r9 = ": "
                java.lang.String r8 = kotlin.jvm.internal.f0.C(r9, r8)
            L4d:
                java.lang.String r8 = kotlin.jvm.internal.f0.C(r0, r8)
                java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
                java.lang.String r8 = r8.toString()
                r9.<init>(r8)
                throw r9
            L5b:
                r2 = r3
                goto L6
            L5d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.t.b.g(java.lang.String, java.lang.String):void");
        }

        public final String h(String[] strArr, String str) {
            int length = strArr.length - 2;
            int iC = bk.n.c(length, 0, -2);
            if (iC > length) {
                return null;
            }
            while (true) {
                int i10 = length - 2;
                if (kotlin.text.u.L1(str, strArr[length], true)) {
                    return strArr[length + 1];
                }
                if (length == iC) {
                    return null;
                }
                length = i10;
            }
        }

        @hk.h(name = "of")
        @hk.m
        @yt.k
        public final t i(@yt.k Map<String, String> map) {
            kotlin.jvm.internal.f0.p(map, "<this>");
            String[] strArr = new String[map.size() * 2];
            int i10 = 0;
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                String string = StringsKt__StringsKt.F5(key).toString();
                String string2 = StringsKt__StringsKt.F5(value).toString();
                f(string);
                g(string2, string);
                strArr[i10] = string;
                strArr[i10 + 1] = string2;
                i10 += 2;
            }
            return new t(strArr, null);
        }

        @hk.h(name = "of")
        @hk.m
        @yt.k
        public final t j(@yt.k String... namesAndValues) {
            kotlin.jvm.internal.f0.p(namesAndValues, "namesAndValues");
            int i10 = 0;
            if (!(namesAndValues.length % 2 == 0)) {
                throw new IllegalArgumentException("Expected alternating header names and values".toString());
            }
            String[] strArr = (String[]) namesAndValues.clone();
            int length = strArr.length;
            int i11 = 0;
            while (i11 < length) {
                int i12 = i11 + 1;
                if (!(strArr[i11] != null)) {
                    throw new IllegalArgumentException("Headers cannot be null".toString());
                }
                strArr[i11] = StringsKt__StringsKt.F5(strArr[i11]).toString();
                i11 = i12;
            }
            int iC = bk.n.c(0, strArr.length - 1, 2);
            if (iC >= 0) {
                while (true) {
                    int i13 = i10 + 2;
                    String str = strArr[i10];
                    String str2 = strArr[i10 + 1];
                    f(str);
                    g(str2, str);
                    if (i10 == iC) {
                        break;
                    }
                    i10 = i13;
                }
            }
            return new t(strArr, null);
        }
    }

    public t(String[] strArr) {
        this.f43946a = strArr;
    }

    public /* synthetic */ t(String[] strArr, kotlin.jvm.internal.u uVar) {
        this(strArr);
    }

    @hk.h(name = "of")
    @hk.m
    @yt.k
    public static final t o(@yt.k Map<String, String> map) {
        return f43945b.i(map);
    }

    @hk.h(name = "of")
    @hk.m
    @yt.k
    public static final t p(@yt.k String... strArr) {
        return f43945b.j(strArr);
    }

    @hk.h(name = "-deprecated_size")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @t0(expression = "size", imports = {}))
    public final int a() {
        return size();
    }

    public final long b() {
        String[] strArr = this.f43946a;
        long length = strArr.length * 2;
        int length2 = strArr.length;
        for (int i10 = 0; i10 < length2; i10++) {
            length += (long) this.f43946a[i10].length();
        }
        return length;
    }

    @yt.l
    public final String d(@yt.k String name) {
        kotlin.jvm.internal.f0.p(name, "name");
        return f43945b.h(this.f43946a, name);
    }

    @yt.l
    public final Date e(@yt.k String name) {
        kotlin.jvm.internal.f0.p(name, "name");
        String strD = d(name);
        if (strD == null) {
            return null;
        }
        return vl.c.a(strD);
    }

    public boolean equals(@yt.l Object obj) {
        return (obj instanceof t) && Arrays.equals(this.f43946a, ((t) obj).f43946a);
    }

    @yt.l
    @IgnoreJRERequirement
    public final Instant g(@yt.k String name) {
        kotlin.jvm.internal.f0.p(name, "name");
        Date dateE = e(name);
        if (dateE == null) {
            return null;
        }
        return dateE.toInstant();
    }

    public int hashCode() {
        return Arrays.hashCode(this.f43946a);
    }

    @Override // java.lang.Iterable
    @yt.k
    public Iterator<Pair<? extends String, ? extends String>> iterator() {
        int size = size();
        Pair[] pairArr = new Pair[size];
        for (int i10 = 0; i10 < size; i10++) {
            pairArr[i10] = d1.a(j(i10), r(i10));
        }
        return kotlin.jvm.internal.h.a(pairArr);
    }

    @yt.k
    public final String j(int i10) {
        return this.f43946a[i10 * 2];
    }

    @yt.k
    public final Set<String> l() {
        TreeSet treeSet = new TreeSet(kotlin.text.u.T1(v0.f37964a));
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            treeSet.add(j(i10));
        }
        Set<String> setUnmodifiableSet = Collections.unmodifiableSet(treeSet);
        kotlin.jvm.internal.f0.o(setUnmodifiableSet, "unmodifiableSet(result)");
        return setUnmodifiableSet;
    }

    @yt.k
    public final a m() {
        a aVar = new a();
        kotlin.collections.x.p0(aVar.k(), this.f43946a);
        return aVar;
    }

    @yt.k
    public final Map<String, List<String>> q() {
        TreeMap treeMap = new TreeMap(kotlin.text.u.T1(v0.f37964a));
        int size = size();
        int i10 = 0;
        while (i10 < size) {
            int i11 = i10 + 1;
            String strJ = j(i10);
            Locale US = Locale.US;
            kotlin.jvm.internal.f0.o(US, "US");
            String lowerCase = strJ.toLowerCase(US);
            kotlin.jvm.internal.f0.o(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            List arrayList = (List) treeMap.get(lowerCase);
            if (arrayList == null) {
                arrayList = new ArrayList(2);
                treeMap.put(lowerCase, arrayList);
            }
            arrayList.add(r(i10));
            i10 = i11;
        }
        return treeMap;
    }

    @yt.k
    public final String r(int i10) {
        return this.f43946a[(i10 * 2) + 1];
    }

    @yt.k
    public final List<String> s(@yt.k String name) {
        kotlin.jvm.internal.f0.p(name, "name");
        int size = size();
        ArrayList arrayList = null;
        int i10 = 0;
        while (i10 < size) {
            int i11 = i10 + 1;
            if (kotlin.text.u.L1(name, j(i10), true)) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(r(i10));
            }
            i10 = i11;
        }
        if (arrayList == null) {
            return CollectionsKt__CollectionsKt.E();
        }
        List<String> listUnmodifiableList = Collections.unmodifiableList(arrayList);
        kotlin.jvm.internal.f0.o(listUnmodifiableList, "{\n      Collections.unmodifiableList(result)\n    }");
        return listUnmodifiableList;
    }

    @hk.h(name = "size")
    public final int size() {
        return this.f43946a.length / 2;
    }

    @yt.k
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        int size = size();
        int i10 = 0;
        while (i10 < size) {
            int i11 = i10 + 1;
            String strJ = j(i10);
            String strR = r(i10);
            sb2.append(strJ);
            sb2.append(": ");
            if (rl.f.O(strJ)) {
                strR = "██";
            }
            sb2.append(strR);
            sb2.append("\n");
            i10 = i11;
        }
        String string = sb2.toString();
        kotlin.jvm.internal.f0.o(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}
