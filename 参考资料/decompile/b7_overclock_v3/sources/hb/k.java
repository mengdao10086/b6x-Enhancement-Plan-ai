package hb;

import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes3.dex */
public interface k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f30889a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f30890b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f30891c = -1;

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface a {
    }

    void b(long j10, long j11);

    void c(m mVar);

    int f(l lVar, z zVar) throws IOException;

    boolean i(l lVar) throws IOException;

    void release();
}
