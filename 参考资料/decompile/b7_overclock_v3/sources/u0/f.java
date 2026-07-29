package u0;

import android.net.Uri;
import java.io.File;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import yt.k;

/* JADX INFO: loaded from: classes2.dex */
@t0({"SMAP\nUri.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Uri.kt\nandroidx/core/net/UriKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,46:1\n1#2:47\n*E\n"})
public final class f {
    @k
    public static final File a(@k Uri uri) {
        f0.p(uri, "<this>");
        if (!f0.g(uri.getScheme(), m7.a.f40702b)) {
            throw new IllegalArgumentException(("Uri lacks 'file' scheme: " + uri).toString());
        }
        String path = uri.getPath();
        if (path != null) {
            return new File(path);
        }
        throw new IllegalArgumentException(("Uri path is null: " + uri).toString());
    }

    @k
    public static final Uri b(@k File file) {
        f0.p(file, "<this>");
        Uri uriFromFile = Uri.fromFile(file);
        f0.o(uriFromFile, "fromFile(this)");
        return uriFromFile;
    }

    @k
    public static final Uri c(@k String str) {
        f0.p(str, "<this>");
        Uri uri = Uri.parse(str);
        f0.o(uri, "parse(this)");
        return uri;
    }
}
