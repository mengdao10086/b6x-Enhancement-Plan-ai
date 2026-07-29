package ya;

import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes3.dex */
public interface q1 {
    public static final int S6 = 7;

    @Deprecated
    public static final int T6 = 4;

    @Deprecated
    public static final int U6 = 3;

    @Deprecated
    public static final int V6 = 2;

    @Deprecated
    public static final int W6 = 1;

    @Deprecated
    public static final int X6 = 0;
    public static final int Y6 = 24;
    public static final int Z6 = 16;

    /* JADX INFO: renamed from: a7, reason: collision with root package name */
    public static final int f57048a7 = 8;

    /* JADX INFO: renamed from: b7, reason: collision with root package name */
    public static final int f57049b7 = 0;

    /* JADX INFO: renamed from: c7, reason: collision with root package name */
    public static final int f57050c7 = 32;

    /* JADX INFO: renamed from: d7, reason: collision with root package name */
    public static final int f57051d7 = 32;

    /* JADX INFO: renamed from: e7, reason: collision with root package name */
    public static final int f57052e7 = 0;

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface a {
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface b {
    }

    @Deprecated
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface c {
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface d {
    }

    int a(Format format) throws ExoPlaybackException;

    String getName();

    int h();

    int p() throws ExoPlaybackException;
}
