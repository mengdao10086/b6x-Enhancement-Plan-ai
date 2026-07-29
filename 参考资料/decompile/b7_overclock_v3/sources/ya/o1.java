package ya;

import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import ya.l1;

/* JADX INFO: loaded from: classes3.dex */
public interface o1 extends l1.b {
    public static final int A6 = 1;
    public static final int B6 = 2;
    public static final int C6 = 3;
    public static final int D6 = 4;
    public static final int E6 = 5;
    public static final int F6 = 6;
    public static final int G6 = 7;
    public static final int H6 = 8;
    public static final int I6 = 101;
    public static final int J6 = 102;
    public static final int K6 = 103;
    public static final int L6 = 10000;

    @Deprecated
    public static final int M6 = 1;

    @Deprecated
    public static final int N6 = 2;

    @Deprecated
    public static final int O6 = 1;
    public static final int P6 = 0;
    public static final int Q6 = 1;
    public static final int R6 = 2;

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface a {
    }

    @Deprecated
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface b {
    }

    public interface c {
        void a();

        void b(long j10);
    }

    boolean b();

    boolean d();

    void f(int i10);

    void g();

    String getName();

    int getState();

    int h();

    boolean i();

    void j();

    void k(r1 r1Var, Format[] formatArr, ec.d0 d0Var, long j10, boolean z10, boolean z11, long j11, long j12) throws ExoPlaybackException;

    void l(Format[] formatArr, ec.d0 d0Var, long j10, long j11) throws ExoPlaybackException;

    q1 m();

    void o(float f10, float f11) throws ExoPlaybackException;

    void q(long j10, long j11) throws ExoPlaybackException;

    void reset();

    @g.p0
    ec.d0 s();

    void start() throws ExoPlaybackException;

    void stop();

    void t() throws IOException;

    long u();

    void v(long j10) throws ExoPlaybackException;

    boolean w();

    @g.p0
    hd.v x();
}
