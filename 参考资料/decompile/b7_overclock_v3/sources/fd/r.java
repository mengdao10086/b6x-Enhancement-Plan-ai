package fd;

import g.p0;
import hd.u0;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public final class r extends g {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f28126g = ".exo";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f28127h = ".v3.exo";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Pattern f28128i = Pattern.compile("^(.+)\\.(\\d+)\\.(\\d+)\\.v1\\.exo$", 32);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Pattern f28129j = Pattern.compile("^(.+)\\.(\\d+)\\.(\\d+)\\.v2\\.exo$", 32);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Pattern f28130k = Pattern.compile("^(\\d+)\\.(\\d+)\\.(\\d+)\\.v3\\.exo$", 32);

    public r(String str, long j10, long j11, long j12, @p0 File file) {
        super(str, j10, j11, j12, file);
    }

    @p0
    public static r g(File file, long j10, long j11, j jVar) {
        File file2;
        String strL;
        String name = file.getName();
        if (name.endsWith(f28127h)) {
            file2 = file;
        } else {
            File fileL = l(file, jVar);
            if (fileL == null) {
                return null;
            }
            file2 = fileL;
            name = fileL.getName();
        }
        Matcher matcher = f28130k.matcher(name);
        if (!matcher.matches() || (strL = jVar.l(Integer.parseInt((String) hd.a.g(matcher.group(1))))) == null) {
            return null;
        }
        long length = j10 == -1 ? file2.length() : j10;
        if (length == 0) {
            return null;
        }
        return new r(strL, Long.parseLong((String) hd.a.g(matcher.group(2))), length, j11 == ya.g.f56663b ? Long.parseLong((String) hd.a.g(matcher.group(3))) : j11, file2);
    }

    @p0
    public static r h(File file, long j10, j jVar) {
        return g(file, j10, ya.g.f56663b, jVar);
    }

    public static r i(String str, long j10, long j11) {
        return new r(str, j10, j11, ya.g.f56663b, null);
    }

    public static r j(String str, long j10) {
        return new r(str, j10, -1L, ya.g.f56663b, null);
    }

    public static File k(File file, int i10, long j10, long j11) {
        return new File(file, i10 + j3.b.f36044h + j10 + j3.b.f36044h + j11 + f28127h);
    }

    @p0
    public static File l(File file, j jVar) {
        String strA1;
        String name = file.getName();
        Matcher matcher = f28129j.matcher(name);
        if (matcher.matches()) {
            strA1 = u0.A1((String) hd.a.g(matcher.group(1)));
        } else {
            matcher = f28128i.matcher(name);
            strA1 = matcher.matches() ? (String) hd.a.g(matcher.group(1)) : null;
        }
        if (strA1 == null) {
            return null;
        }
        File fileK = k((File) hd.a.k(file.getParentFile()), jVar.f(strA1), Long.parseLong((String) hd.a.g(matcher.group(2))), Long.parseLong((String) hd.a.g(matcher.group(3))));
        if (file.renameTo(fileK)) {
            return fileK;
        }
        return null;
    }

    public r f(File file, long j10) {
        hd.a.i(this.f28057d);
        return new r(this.f28054a, this.f28055b, this.f28056c, j10, file);
    }
}
