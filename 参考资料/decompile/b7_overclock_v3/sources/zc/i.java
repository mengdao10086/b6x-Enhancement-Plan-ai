package zc;

import com.google.android.exoplayer2.ParserException;
import g.p0;
import hd.c0;
import hd.u0;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f58427a = Pattern.compile("^NOTE([ \t].*)?$");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f58428b = "WEBVTT";

    @p0
    public static Matcher a(c0 c0Var) {
        String strQ;
        while (true) {
            String strQ2 = c0Var.q();
            if (strQ2 == null) {
                return null;
            }
            if (f58427a.matcher(strQ2).matches()) {
                do {
                    strQ = c0Var.q();
                    if (strQ != null) {
                    }
                } while (!strQ.isEmpty());
            } else {
                Matcher matcher = f.f58376f.matcher(strQ2);
                if (matcher.matches()) {
                    return matcher;
                }
            }
        }
    }

    public static boolean b(c0 c0Var) {
        String strQ = c0Var.q();
        return strQ != null && strQ.startsWith(f58428b);
    }

    public static float c(String str) throws NumberFormatException {
        if (str.endsWith(i6.a.f31863g)) {
            return Float.parseFloat(str.substring(0, str.length() - 1)) / 100.0f;
        }
        throw new NumberFormatException("Percentages must end with %");
    }

    public static long d(String str) throws NumberFormatException {
        String[] strArrO1 = u0.o1(str, "\\.");
        long j10 = 0;
        for (String str2 : u0.n1(strArrO1[0], ":")) {
            j10 = (j10 * 60) + Long.parseLong(str2);
        }
        long j11 = j10 * 1000;
        if (strArrO1.length == 2) {
            j11 += Long.parseLong(strArrO1[1]);
        }
        return j11 * 1000;
    }

    public static void e(c0 c0Var) throws ParserException {
        int iE = c0Var.e();
        if (b(c0Var)) {
            return;
        }
        c0Var.S(iE);
        throw new ParserException("Expected WEBVTT. Got " + c0Var.q());
    }
}
