package wi;

import java.util.Objects;

/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class a {
    public static /* synthetic */ String a(CharSequence charSequence, CharSequence[] charSequenceArr) {
        Objects.requireNonNull(charSequence, xc.d.f55070a0);
        StringBuilder sb2 = new StringBuilder();
        if (charSequenceArr.length > 0) {
            sb2.append(charSequenceArr[0]);
            for (int i10 = 1; i10 < charSequenceArr.length; i10++) {
                sb2.append(charSequence);
                sb2.append(charSequenceArr[i10]);
            }
        }
        return sb2.toString();
    }
}
