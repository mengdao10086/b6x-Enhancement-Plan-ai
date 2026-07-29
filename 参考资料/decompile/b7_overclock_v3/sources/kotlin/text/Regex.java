package kotlin.text;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.c2;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.s0;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.v0;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nRegex.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Regex.kt\nkotlin/text/Regex\n+ 2 Regex.kt\nkotlin/text/RegexKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,398:1\n22#2,3:399\n1#3:402\n*S KotlinDebug\n*F\n+ 1 Regex.kt\nkotlin/text/Regex\n*L\n104#1:399,3\n*E\n"})
public final class Regex implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public static final a f38147a = new a(null);

    @yt.l
    private Set<? extends RegexOption> _options;

    @yt.k
    private final Pattern nativePattern;

    public static final class Serialized implements Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @yt.k
        public static final a f38148a = new a(null);
        private static final long serialVersionUID = 0;
        private final int flags;

        @yt.k
        private final String pattern;

        public static final class a {
            public a() {
            }

            public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
                this();
            }
        }

        public Serialized(@yt.k String pattern, int i10) {
            f0.p(pattern, "pattern");
            this.pattern = pattern;
            this.flags = i10;
        }

        private final Object readResolve() {
            Pattern patternCompile = Pattern.compile(this.pattern, this.flags);
            f0.o(patternCompile, "compile(pattern, flags)");
            return new Regex(patternCompile);
        }

        public final int a() {
            return this.flags;
        }

        @yt.k
        public final String b() {
            return this.pattern;
        }
    }

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }

        public final int b(int i10) {
            return (i10 & 2) != 0 ? i10 | 64 : i10;
        }

        @yt.k
        public final String c(@yt.k String literal) {
            f0.p(literal, "literal");
            String strQuote = Pattern.quote(literal);
            f0.o(strQuote, "quote(literal)");
            return strQuote;
        }

        @yt.k
        public final String d(@yt.k String literal) {
            f0.p(literal, "literal");
            String strQuoteReplacement = Matcher.quoteReplacement(literal);
            f0.o(strQuoteReplacement, "quoteReplacement(literal)");
            return strQuoteReplacement;
        }

        @yt.k
        public final Regex e(@yt.k String literal) {
            f0.p(literal, "literal");
            return new Regex(literal, RegexOption.LITERAL);
        }
    }

    @s0
    public Regex(@yt.k Pattern nativePattern) {
        f0.p(nativePattern, "nativePattern");
        this.nativePattern = nativePattern;
    }

    public static /* synthetic */ k d(Regex regex, CharSequence charSequence, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        return regex.c(charSequence, i10);
    }

    public static /* synthetic */ kotlin.sequences.m h(Regex regex, CharSequence charSequence, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        return regex.f(charSequence, i10);
    }

    public static /* synthetic */ List u(Regex regex, CharSequence charSequence, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        return regex.t(charSequence, i10);
    }

    public static /* synthetic */ kotlin.sequences.m w(Regex regex, CharSequence charSequence, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        return regex.v(charSequence, i10);
    }

    private final Object writeReplace() {
        String strPattern = this.nativePattern.pattern();
        f0.o(strPattern, "nativePattern.pattern()");
        return new Serialized(strPattern, this.nativePattern.flags());
    }

    public final boolean b(@yt.k CharSequence input) {
        f0.p(input, "input");
        return this.nativePattern.matcher(input).find();
    }

    @yt.l
    public final k c(@yt.k CharSequence input, int i10) {
        f0.p(input, "input");
        Matcher matcher = this.nativePattern.matcher(input);
        f0.o(matcher, "nativePattern.matcher(input)");
        return RegexKt.f(matcher, i10, input);
    }

    @yt.k
    public final kotlin.sequences.m<k> f(@yt.k final CharSequence input, final int i10) {
        f0.p(input, "input");
        if (i10 >= 0 && i10 <= input.length()) {
            return SequencesKt__SequencesKt.m(new ik.a<k>() { // from class: kotlin.text.Regex$findAll$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // ik.a
                @yt.l
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public final k o() {
                    return this.this$0.c(input, i10);
                }
            }, Regex$findAll$2.f38149c);
        }
        throw new IndexOutOfBoundsException("Start index out of bounds: " + i10 + ", input length: " + input.length());
    }

    @yt.k
    public final Set<RegexOption> i() {
        Set set = this._options;
        if (set != null) {
            return set;
        }
        final int iFlags = this.nativePattern.flags();
        EnumSet fromInt$lambda$1 = EnumSet.allOf(RegexOption.class);
        f0.o(fromInt$lambda$1, "fromInt$lambda$1");
        kotlin.collections.x.N0(fromInt$lambda$1, new ik.l<RegexOption, Boolean>() { // from class: kotlin.text.Regex$special$$inlined$fromInt$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // ik.l
            @yt.k
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Boolean i(RegexOption regexOption) {
                RegexOption regexOption2 = regexOption;
                return Boolean.valueOf((iFlags & regexOption2.getMask()) == regexOption2.getValue());
            }
        });
        Set<RegexOption> setUnmodifiableSet = Collections.unmodifiableSet(fromInt$lambda$1);
        f0.o(setUnmodifiableSet, "unmodifiableSet(EnumSet.…mask == it.value }\n    })");
        this._options = setUnmodifiableSet;
        return setUnmodifiableSet;
    }

    @yt.k
    public final String k() {
        String strPattern = this.nativePattern.pattern();
        f0.o(strPattern, "nativePattern.pattern()");
        return strPattern;
    }

    @c2(markerClass = {kotlin.q.class})
    @v0(version = "1.7")
    @yt.l
    public final k l(@yt.k CharSequence input, int i10) {
        f0.p(input, "input");
        Matcher matcherRegion = this.nativePattern.matcher(input).useAnchoringBounds(false).useTransparentBounds(true).region(i10, input.length());
        if (!matcherRegion.lookingAt()) {
            return null;
        }
        f0.o(matcherRegion, "this");
        return new MatcherMatchResult(matcherRegion, input);
    }

    @yt.l
    public final k m(@yt.k CharSequence input) {
        f0.p(input, "input");
        Matcher matcher = this.nativePattern.matcher(input);
        f0.o(matcher, "nativePattern.matcher(input)");
        return RegexKt.h(matcher, input);
    }

    public final boolean n(@yt.k CharSequence input) {
        f0.p(input, "input");
        return this.nativePattern.matcher(input).matches();
    }

    @c2(markerClass = {kotlin.q.class})
    @v0(version = "1.7")
    public final boolean o(@yt.k CharSequence input, int i10) {
        f0.p(input, "input");
        return this.nativePattern.matcher(input).useAnchoringBounds(false).useTransparentBounds(true).region(i10, input.length()).lookingAt();
    }

    @yt.k
    public final String p(@yt.k CharSequence input, @yt.k ik.l<? super k, ? extends CharSequence> transform) {
        f0.p(input, "input");
        f0.p(transform, "transform");
        int iIntValue = 0;
        k kVarD = d(this, input, 0, 2, null);
        if (kVarD == null) {
            return input.toString();
        }
        int length = input.length();
        StringBuilder sb2 = new StringBuilder(length);
        do {
            sb2.append(input, iIntValue, kVarD.d().a().intValue());
            sb2.append(transform.i(kVarD));
            iIntValue = kVarD.d().e().intValue() + 1;
            kVarD = kVarD.next();
            if (iIntValue >= length) {
                break;
            }
        } while (kVarD != null);
        if (iIntValue < length) {
            sb2.append(input, iIntValue, length);
        }
        String string = sb2.toString();
        f0.o(string, "sb.toString()");
        return string;
    }

    @yt.k
    public final String q(@yt.k CharSequence input, @yt.k String replacement) {
        f0.p(input, "input");
        f0.p(replacement, "replacement");
        String strReplaceAll = this.nativePattern.matcher(input).replaceAll(replacement);
        f0.o(strReplaceAll, "nativePattern.matcher(in…).replaceAll(replacement)");
        return strReplaceAll;
    }

    @yt.k
    public final String r(@yt.k CharSequence input, @yt.k String replacement) {
        f0.p(input, "input");
        f0.p(replacement, "replacement");
        String strReplaceFirst = this.nativePattern.matcher(input).replaceFirst(replacement);
        f0.o(strReplaceFirst, "nativePattern.matcher(in…replaceFirst(replacement)");
        return strReplaceFirst;
    }

    @yt.k
    public final List<String> t(@yt.k CharSequence input, int i10) {
        f0.p(input, "input");
        StringsKt__StringsKt.N4(i10);
        Matcher matcher = this.nativePattern.matcher(input);
        if (i10 == 1 || !matcher.find()) {
            return kotlin.collections.s.k(input.toString());
        }
        ArrayList arrayList = new ArrayList(i10 > 0 ? qk.v.B(i10, 10) : 10);
        int iEnd = 0;
        int i11 = i10 - 1;
        do {
            arrayList.add(input.subSequence(iEnd, matcher.start()).toString());
            iEnd = matcher.end();
            if (i11 >= 0 && arrayList.size() == i11) {
                break;
            }
        } while (matcher.find());
        arrayList.add(input.subSequence(iEnd, input.length()).toString());
        return arrayList;
    }

    @yt.k
    public String toString() {
        String string = this.nativePattern.toString();
        f0.o(string, "nativePattern.toString()");
        return string;
    }

    @c2(markerClass = {kotlin.q.class})
    @v0(version = "1.6")
    @yt.k
    public final kotlin.sequences.m<String> v(@yt.k CharSequence input, int i10) {
        f0.p(input, "input");
        StringsKt__StringsKt.N4(i10);
        return kotlin.sequences.q.b(new Regex$splitToSequence$1(this, input, i10, null));
    }

    @yt.k
    public final Pattern x() {
        return this.nativePattern;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Regex(@yt.k String pattern) {
        f0.p(pattern, "pattern");
        Pattern patternCompile = Pattern.compile(pattern);
        f0.o(patternCompile, "compile(pattern)");
        this(patternCompile);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Regex(@yt.k String pattern, @yt.k RegexOption option) {
        f0.p(pattern, "pattern");
        f0.p(option, "option");
        Pattern patternCompile = Pattern.compile(pattern, f38147a.b(option.getValue()));
        f0.o(patternCompile, "compile(pattern, ensureUnicodeCase(option.value))");
        this(patternCompile);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Regex(@yt.k String pattern, @yt.k Set<? extends RegexOption> options) {
        f0.p(pattern, "pattern");
        f0.p(options, "options");
        Pattern patternCompile = Pattern.compile(pattern, f38147a.b(RegexKt.k(options)));
        f0.o(patternCompile, "compile(pattern, ensureU…odeCase(options.toInt()))");
        this(patternCompile);
    }
}
