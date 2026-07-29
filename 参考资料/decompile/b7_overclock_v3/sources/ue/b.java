package ue;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.thirdparty.publicsuffix.PublicSuffixType;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
@GwtCompatible
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Joiner f51992a = Joiner.on("");

    public static int a(List<CharSequence> list, CharSequence charSequence, int i10, ImmutableMap.Builder<String, PublicSuffixType> builder) {
        int length = charSequence.length();
        int i11 = i10;
        char cCharAt = 0;
        while (i11 < length && (cCharAt = charSequence.charAt(i11)) != '&' && cCharAt != '?' && cCharAt != '!' && cCharAt != ':' && cCharAt != ',') {
            i11++;
        }
        list.add(0, c(charSequence.subSequence(i10, i11)));
        if (cCharAt == '!' || cCharAt == '?' || cCharAt == ':' || cCharAt == ',') {
            String strJoin = f51992a.join(list);
            if (strJoin.length() > 0) {
                builder.put(strJoin, PublicSuffixType.fromCode(cCharAt));
            }
        }
        int iA = i11 + 1;
        if (cCharAt != '?' && cCharAt != ',') {
            while (iA < length) {
                iA += a(list, charSequence, iA, builder);
                if (charSequence.charAt(iA) == '?' || charSequence.charAt(iA) == ',') {
                    iA++;
                    break;
                }
            }
        }
        list.remove(0);
        return iA - i10;
    }

    public static ImmutableMap<String, PublicSuffixType> b(CharSequence charSequence) {
        ImmutableMap.Builder builder = ImmutableMap.builder();
        int length = charSequence.length();
        int iA = 0;
        while (iA < length) {
            iA += a(Lists.newLinkedList(), charSequence, iA, builder);
        }
        return builder.build();
    }

    public static CharSequence c(CharSequence charSequence) {
        return new StringBuilder(charSequence).reverse();
    }
}
