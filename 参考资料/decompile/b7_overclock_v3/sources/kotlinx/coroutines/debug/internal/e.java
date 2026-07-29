package kotlinx.coroutines.debug.internal;

import kotlin.jvm.internal.f0;
import kotlin.text.y;

/* JADX INFO: loaded from: classes5.dex */
public final class e {
    public static final String b(String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(y.f38188b);
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            char cCharAt = str.charAt(i10);
            if (cCharAt == '\"') {
                sb2.append("\\\"");
            } else if (cCharAt == '\\') {
                sb2.append("\\\\");
            } else if (cCharAt == '\b') {
                sb2.append("\\b");
            } else if (cCharAt == '\n') {
                sb2.append("\\n");
            } else if (cCharAt == '\r') {
                sb2.append("\\r");
            } else if (cCharAt == '\t') {
                sb2.append("\\t");
            } else {
                sb2.append(cCharAt);
            }
        }
        sb2.append(y.f38188b);
        String string = sb2.toString();
        f0.o(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}
