package ze;

import com.google.zxing.client.result.ParsedResultType;

/* JADX INFO: loaded from: classes7.dex */
public abstract class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ParsedResultType f58538a;

    public q(ParsedResultType parsedResultType) {
        this.f58538a = parsedResultType;
    }

    public static void c(String str, StringBuilder sb2) {
        if (str == null || str.isEmpty()) {
            return;
        }
        if (sb2.length() > 0) {
            sb2.append('\n');
        }
        sb2.append(str);
    }

    public static void d(String[] strArr, StringBuilder sb2) {
        if (strArr != null) {
            for (String str : strArr) {
                c(str, sb2);
            }
        }
    }

    public abstract String a();

    public final ParsedResultType b() {
        return this.f58538a;
    }

    public final String toString() {
        return a();
    }
}
