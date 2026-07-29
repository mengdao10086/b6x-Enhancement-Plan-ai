package g;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.annotation.AnnotationRetention;

/* JADX INFO: loaded from: classes2.dex */
@sj.c(AnnotationRetention.BINARY)
@Retention(RetentionPolicy.CLASS)
public @interface i1 {

    @yt.k
    public static final a S1 = a.f28845a;
    public static final int T1 = 2;
    public static final int U1 = 3;
    public static final int V1 = 4;
    public static final int W1 = 5;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f28845a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f28846b = 2;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f28847c = 3;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f28848d = 4;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final int f28849e = 5;
    }

    int otherwise() default 2;
}
