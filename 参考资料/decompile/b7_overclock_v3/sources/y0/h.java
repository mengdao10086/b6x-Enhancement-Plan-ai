package y0;

import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.UnderlineSpan;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.z1;

/* JADX INFO: loaded from: classes2.dex */
@t0({"SMAP\nSpannableStringBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpannableStringBuilder.kt\nandroidx/core/text/SpannableStringBuilderKt\n*L\n1#1,163:1\n74#1,4:164\n74#1,4:168\n74#1,4:172\n74#1,4:176\n74#1,4:180\n74#1,4:184\n74#1,4:188\n74#1,4:192\n74#1,4:196\n*S KotlinDebug\n*F\n+ 1 SpannableStringBuilder.kt\nandroidx/core/text/SpannableStringBuilderKt\n*L\n87#1:164,4\n96#1:168,4\n105#1:172,4\n115#1:176,4\n125#1:180,4\n134#1:184,4\n144#1:188,4\n153#1:192,4\n162#1:196,4\n*E\n"})
public final class h {
    @yt.k
    public static final SpannableStringBuilder a(@yt.k SpannableStringBuilder spannableStringBuilder, @g.l int i10, @yt.k ik.l<? super SpannableStringBuilder, z1> builderAction) {
        f0.p(spannableStringBuilder, "<this>");
        f0.p(builderAction, "builderAction");
        BackgroundColorSpan backgroundColorSpan = new BackgroundColorSpan(i10);
        int length = spannableStringBuilder.length();
        builderAction.i(spannableStringBuilder);
        spannableStringBuilder.setSpan(backgroundColorSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    @yt.k
    public static final SpannableStringBuilder b(@yt.k SpannableStringBuilder spannableStringBuilder, @yt.k ik.l<? super SpannableStringBuilder, z1> builderAction) {
        f0.p(spannableStringBuilder, "<this>");
        f0.p(builderAction, "builderAction");
        StyleSpan styleSpan = new StyleSpan(1);
        int length = spannableStringBuilder.length();
        builderAction.i(spannableStringBuilder);
        spannableStringBuilder.setSpan(styleSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    @yt.k
    public static final SpannedString c(@yt.k ik.l<? super SpannableStringBuilder, z1> builderAction) {
        f0.p(builderAction, "builderAction");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        builderAction.i(spannableStringBuilder);
        return new SpannedString(spannableStringBuilder);
    }

    @yt.k
    public static final SpannableStringBuilder d(@yt.k SpannableStringBuilder spannableStringBuilder, @g.l int i10, @yt.k ik.l<? super SpannableStringBuilder, z1> builderAction) {
        f0.p(spannableStringBuilder, "<this>");
        f0.p(builderAction, "builderAction");
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(i10);
        int length = spannableStringBuilder.length();
        builderAction.i(spannableStringBuilder);
        spannableStringBuilder.setSpan(foregroundColorSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    @yt.k
    public static final SpannableStringBuilder e(@yt.k SpannableStringBuilder spannableStringBuilder, @yt.k Object span, @yt.k ik.l<? super SpannableStringBuilder, z1> builderAction) {
        f0.p(spannableStringBuilder, "<this>");
        f0.p(span, "span");
        f0.p(builderAction, "builderAction");
        int length = spannableStringBuilder.length();
        builderAction.i(spannableStringBuilder);
        spannableStringBuilder.setSpan(span, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    @yt.k
    public static final SpannableStringBuilder f(@yt.k SpannableStringBuilder spannableStringBuilder, @yt.k Object[] spans, @yt.k ik.l<? super SpannableStringBuilder, z1> builderAction) {
        f0.p(spannableStringBuilder, "<this>");
        f0.p(spans, "spans");
        f0.p(builderAction, "builderAction");
        int length = spannableStringBuilder.length();
        builderAction.i(spannableStringBuilder);
        for (Object obj : spans) {
            spannableStringBuilder.setSpan(obj, length, spannableStringBuilder.length(), 17);
        }
        return spannableStringBuilder;
    }

    @yt.k
    public static final SpannableStringBuilder g(@yt.k SpannableStringBuilder spannableStringBuilder, @yt.k ik.l<? super SpannableStringBuilder, z1> builderAction) {
        f0.p(spannableStringBuilder, "<this>");
        f0.p(builderAction, "builderAction");
        StyleSpan styleSpan = new StyleSpan(2);
        int length = spannableStringBuilder.length();
        builderAction.i(spannableStringBuilder);
        spannableStringBuilder.setSpan(styleSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    @yt.k
    public static final SpannableStringBuilder h(@yt.k SpannableStringBuilder spannableStringBuilder, float f10, @yt.k ik.l<? super SpannableStringBuilder, z1> builderAction) {
        f0.p(spannableStringBuilder, "<this>");
        f0.p(builderAction, "builderAction");
        RelativeSizeSpan relativeSizeSpan = new RelativeSizeSpan(f10);
        int length = spannableStringBuilder.length();
        builderAction.i(spannableStringBuilder);
        spannableStringBuilder.setSpan(relativeSizeSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    @yt.k
    public static final SpannableStringBuilder i(@yt.k SpannableStringBuilder spannableStringBuilder, @yt.k ik.l<? super SpannableStringBuilder, z1> builderAction) {
        f0.p(spannableStringBuilder, "<this>");
        f0.p(builderAction, "builderAction");
        StrikethroughSpan strikethroughSpan = new StrikethroughSpan();
        int length = spannableStringBuilder.length();
        builderAction.i(spannableStringBuilder);
        spannableStringBuilder.setSpan(strikethroughSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    @yt.k
    public static final SpannableStringBuilder j(@yt.k SpannableStringBuilder spannableStringBuilder, @yt.k ik.l<? super SpannableStringBuilder, z1> builderAction) {
        f0.p(spannableStringBuilder, "<this>");
        f0.p(builderAction, "builderAction");
        SubscriptSpan subscriptSpan = new SubscriptSpan();
        int length = spannableStringBuilder.length();
        builderAction.i(spannableStringBuilder);
        spannableStringBuilder.setSpan(subscriptSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    @yt.k
    public static final SpannableStringBuilder k(@yt.k SpannableStringBuilder spannableStringBuilder, @yt.k ik.l<? super SpannableStringBuilder, z1> builderAction) {
        f0.p(spannableStringBuilder, "<this>");
        f0.p(builderAction, "builderAction");
        SuperscriptSpan superscriptSpan = new SuperscriptSpan();
        int length = spannableStringBuilder.length();
        builderAction.i(spannableStringBuilder);
        spannableStringBuilder.setSpan(superscriptSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    @yt.k
    public static final SpannableStringBuilder l(@yt.k SpannableStringBuilder spannableStringBuilder, @yt.k ik.l<? super SpannableStringBuilder, z1> builderAction) {
        f0.p(spannableStringBuilder, "<this>");
        f0.p(builderAction, "builderAction");
        UnderlineSpan underlineSpan = new UnderlineSpan();
        int length = spannableStringBuilder.length();
        builderAction.i(spannableStringBuilder);
        spannableStringBuilder.setSpan(underlineSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }
}
