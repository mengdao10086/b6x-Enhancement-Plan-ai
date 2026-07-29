package mb;

import com.google.android.exoplayer2.ParserException;
import hb.l;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes3.dex */
public interface b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f40994a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f40995b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f40996c = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f40997d = 3;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f40998e = 4;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f40999f = 5;

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface a {
    }

    void a(int i10) throws ParserException;

    int b(int i10);

    boolean c(int i10);

    void d(int i10, String str) throws ParserException;

    void e(int i10, double d10) throws ParserException;

    void f(int i10, int i11, l lVar) throws IOException;

    void g(int i10, long j10, long j11) throws ParserException;

    void h(int i10, long j10) throws ParserException;
}
