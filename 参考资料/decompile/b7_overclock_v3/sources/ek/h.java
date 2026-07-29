package ek;

import java.io.InputStream;
import java.io.OutputStream;
import kotlin.jvm.internal.f0;
import kotlin.v0;
import yt.k;

/* JADX INFO: loaded from: classes5.dex */
public class h {
    @v0(version = "1.8")
    @f
    @k
    public static final InputStream a(@k InputStream inputStream, @k a base64) {
        f0.p(inputStream, "<this>");
        f0.p(base64, "base64");
        return new d(inputStream, base64);
    }

    @v0(version = "1.8")
    @f
    @k
    public static final OutputStream b(@k OutputStream outputStream, @k a base64) {
        f0.p(outputStream, "<this>");
        f0.p(base64, "base64");
        return new e(outputStream, base64);
    }
}
