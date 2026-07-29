package c4;

import g.n0;
import java.nio.charset.Charset;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes2.dex */
public interface b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f9744a = "UTF-8";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Charset f9745b = Charset.forName("UTF-8");

    void a(@n0 MessageDigest messageDigest);

    boolean equals(Object obj);

    int hashCode();
}
