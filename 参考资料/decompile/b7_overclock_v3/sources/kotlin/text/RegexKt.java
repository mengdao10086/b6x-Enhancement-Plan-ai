package kotlin.text;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nRegex.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Regex.kt\nkotlin/text/RegexKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,398:1\n1789#2,3:399\n*S KotlinDebug\n*F\n+ 1 Regex.kt\nkotlin/text/RegexKt\n*L\n19#1:399,3\n*E\n"})
public final class RegexKt {
    public static final k f(Matcher matcher, int i10, CharSequence charSequence) {
        if (matcher.find(i10)) {
            return new MatcherMatchResult(matcher, charSequence);
        }
        return null;
    }

    public static final /* synthetic */ <T extends Enum<T> & g> Set<T> g(final int i10) {
        f0.y(4, i1.a.f31577d5);
        EnumSet fromInt$lambda$1 = EnumSet.allOf(Enum.class);
        f0.o(fromInt$lambda$1, "fromInt$lambda$1");
        f0.w();
        kotlin.collections.x.N0(fromInt$lambda$1, new ik.l<T, Boolean>() { // from class: kotlin.text.RegexKt$fromInt$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX WARN: Incorrect types in method signature: (TT;)Ljava/lang/Boolean; */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // ik.l
            @yt.k
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Boolean i(Enum r32) {
                g gVar = (g) r32;
                return Boolean.valueOf((i10 & gVar.getMask()) == gVar.getValue());
            }
        });
        Set<T> setUnmodifiableSet = Collections.unmodifiableSet(fromInt$lambda$1);
        f0.o(setUnmodifiableSet, "unmodifiableSet(EnumSet.…mask == it.value }\n    })");
        return setUnmodifiableSet;
    }

    public static final k h(Matcher matcher, CharSequence charSequence) {
        if (matcher.matches()) {
            return new MatcherMatchResult(matcher, charSequence);
        }
        return null;
    }

    public static final qk.m i(MatchResult matchResult) {
        return qk.v.W1(matchResult.start(), matchResult.end());
    }

    public static final qk.m j(MatchResult matchResult, int i10) {
        return qk.v.W1(matchResult.start(i10), matchResult.end(i10));
    }

    public static final int k(Iterable<? extends g> iterable) {
        Iterator<? extends g> it2 = iterable.iterator();
        int value = 0;
        while (it2.hasNext()) {
            value |= it2.next().getValue();
        }
        return value;
    }
}
