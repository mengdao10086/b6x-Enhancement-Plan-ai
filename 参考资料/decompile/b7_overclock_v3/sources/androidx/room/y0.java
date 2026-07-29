package androidx.room;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes2.dex */
@Target({})
@Retention(RetentionPolicy.CLASS)
public @interface y0 {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f7579n = 1;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f7580o = 2;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f7581p = 3;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f7582q = 4;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f7583r = 5;

    @Retention(RetentionPolicy.CLASS)
    public @interface a {
    }

    String[] childColumns();

    boolean deferred() default false;

    Class<?> entity();

    @a
    int onDelete() default 1;

    @a
    int onUpdate() default 1;

    String[] parentColumns();
}
