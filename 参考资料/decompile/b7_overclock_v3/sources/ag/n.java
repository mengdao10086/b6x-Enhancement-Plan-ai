package ag;

import com.blankj.utilcode.util.i0;
import g.n0;
import g.p0;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: loaded from: classes7.dex */
public final class n {
    @n0
    public static <T> T a(@p0 T t10) {
        Objects.requireNonNull(t10);
        return t10;
    }

    public static boolean b(CharSequence charSequence, CharSequence charSequence2) {
        int length;
        if (charSequence == charSequence2) {
            return true;
        }
        if (charSequence == null || charSequence2 == null || (length = charSequence.length()) != charSequence2.length()) {
            return false;
        }
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            return charSequence.equals(charSequence2);
        }
        for (int i10 = 0; i10 < length; i10++) {
            if (charSequence.charAt(i10) != charSequence2.charAt(i10)) {
                return false;
            }
        }
        return true;
    }

    public static String c(Throwable th2) {
        if (th2 == null) {
            return "";
        }
        for (Throwable cause = th2; cause != null; cause = cause.getCause()) {
            if (cause instanceof UnknownHostException) {
                return "";
            }
        }
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th2.printStackTrace(printWriter);
        printWriter.flush();
        return stringWriter.toString();
    }

    public static boolean d(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    public static String e(int i10) {
        switch (i10) {
            case 2:
                return "VERBOSE";
            case 3:
                return "DEBUG";
            case 4:
                return "INFO";
            case 5:
                return "WARN";
            case 6:
                return "ERROR";
            case 7:
                return "ASSERT";
            default:
                return o5.h.f42757n;
        }
    }

    public static String f(Object obj) {
        return obj == null ? i0.f11859x : !obj.getClass().isArray() ? obj.toString() : obj instanceof boolean[] ? Arrays.toString((boolean[]) obj) : obj instanceof byte[] ? Arrays.toString((byte[]) obj) : obj instanceof char[] ? Arrays.toString((char[]) obj) : obj instanceof short[] ? Arrays.toString((short[]) obj) : obj instanceof int[] ? Arrays.toString((int[]) obj) : obj instanceof long[] ? Arrays.toString((long[]) obj) : obj instanceof float[] ? Arrays.toString((float[]) obj) : obj instanceof double[] ? Arrays.toString((double[]) obj) : obj instanceof Object[] ? Arrays.deepToString((Object[]) obj) : "Couldn't find a correct type for the object";
    }
}
