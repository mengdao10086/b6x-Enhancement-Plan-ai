package a;

import android.content.Context;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class y50 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final y50 f7950a = new y50();

    public final String a(Context context, String str) {
        f92.d(context, "context");
        f92.d(str, "fileName");
        try {
            byte[] bArrB = b(context, str);
            Charset charsetDefaultCharset = Charset.defaultCharset();
            f92.c(charsetDefaultCharset, "Charset.defaultCharset()");
            return new nb2("\r").g(new nb2("\r\t").g(new nb2("\r\n").g(new String(bArrB, charsetDefaultCharset), "\n"), "\t"), "\n");
        } catch (Exception unused) {
            return "";
        }
    }

    public final byte[] b(Context context, String str) throws IOException {
        f92.d(context, "context");
        f92.d(str, "fileName");
        InputStream inputStreamOpen = context.getAssets().open(str);
        f92.c(inputStreamOpen, "context.assets.open(fileName)");
        return j72.c(inputStreamOpen);
    }

    public final boolean c(Context context, String str) {
        f92.d(context, "context");
        f92.d(str, "fileName");
        try {
            context.getAssets().open(str).close();
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
