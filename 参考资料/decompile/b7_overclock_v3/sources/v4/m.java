package v4;

import android.text.TextUtils;
import g.n0;
import g.p0;
import java.util.Collection;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class m {
    public static void a(boolean z10, @n0 String str) {
        if (!z10) {
            throw new IllegalArgumentException(str);
        }
    }

    @n0
    public static String b(@p0 String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Must not be null or empty");
        }
        return str;
    }

    @n0
    public static <T extends Collection<Y>, Y> T c(@n0 T t10) {
        if (t10.isEmpty()) {
            throw new IllegalArgumentException("Must not be empty.");
        }
        return t10;
    }

    @n0
    public static <T> T d(@p0 T t10) {
        return (T) e(t10, "Argument must not be null");
    }

    @n0
    public static <T> T e(@p0 T t10, @n0 String str) {
        Objects.requireNonNull(t10, str);
        return t10;
    }
}
