package y0;

import android.annotation.SuppressLint;
import android.text.Spannable;
import android.text.SpannableString;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;

/* JADX INFO: loaded from: classes2.dex */
@t0({"SMAP\nSpannableString.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpannableString.kt\nandroidx/core/text/SpannableStringKt\n+ 2 SpannedString.kt\nandroidx/core/text/SpannedStringKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,68:1\n31#2,4:69\n13579#3,2:73\n*S KotlinDebug\n*F\n+ 1 SpannableString.kt\nandroidx/core/text/SpannableStringKt\n*L\n34#1:69,4\n34#1:73,2\n*E\n"})
public final class i {
    @SuppressLint({"SyntheticAccessor"})
    public static final void a(@yt.k Spannable spannable) {
        f0.p(spannable, "<this>");
        Object[] spans = spannable.getSpans(0, spannable.length(), Object.class);
        f0.o(spans, "getSpans(start, end, T::class.java)");
        for (Object obj : spans) {
            spannable.removeSpan(obj);
        }
    }

    public static final void b(@yt.k Spannable spannable, int i10, int i11, @yt.k Object span) {
        f0.p(spannable, "<this>");
        f0.p(span, "span");
        spannable.setSpan(span, i10, i11, 17);
    }

    public static final void c(@yt.k Spannable spannable, @yt.k qk.m range, @yt.k Object span) {
        f0.p(spannable, "<this>");
        f0.p(range, "range");
        f0.p(span, "span");
        spannable.setSpan(span, range.a().intValue(), range.e().intValue(), 17);
    }

    @yt.k
    public static final Spannable d(@yt.k CharSequence charSequence) {
        f0.p(charSequence, "<this>");
        SpannableString spannableStringValueOf = SpannableString.valueOf(charSequence);
        f0.o(spannableStringValueOf, "valueOf(this)");
        return spannableStringValueOf;
    }
}
