package a;

import android.content.Context;
import java.io.InputStream;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class h60 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h60 f6280a = new h60();

    public final byte[] a(Context context, int i) {
        f92.d(context, "context");
        InputStream inputStreamOpenRawResource = context.getResources().openRawResource(i);
        f92.c(inputStreamOpenRawResource, "context.resources.openRawResource(id)");
        return j72.c(inputStreamOpenRawResource);
    }

    public final String b(Context context, int i) {
        f92.d(context, "context");
        try {
            byte[] bArrA = a(context, i);
            Charset charsetDefaultCharset = Charset.defaultCharset();
            f92.c(charsetDefaultCharset, "Charset.defaultCharset()");
            return new nb2("\r").g(new nb2("\r\t").g(new nb2("\r\n").g(new String(bArrA, charsetDefaultCharset), "\n"), "\t"), "\n");
        } catch (Exception unused) {
            return "";
        }
    }
}
