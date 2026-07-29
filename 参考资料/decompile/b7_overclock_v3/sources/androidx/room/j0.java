package androidx.room;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes2.dex */
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.CLASS)
public @interface j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f7432a = "[field-name]";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f7433b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f7434c = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f7435d = 3;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f7436e = 4;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f7437f = 5;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f7438g = 1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f7439h = 2;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f7440i = 3;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f7441j = 4;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @g.v0(21)
    public static final int f7442k = 5;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @g.v0(21)
    public static final int f7443l = 6;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f7444m = "[value-unspecified]";

    @Retention(RetentionPolicy.CLASS)
    public @interface a {
    }

    @Retention(RetentionPolicy.CLASS)
    public @interface b {
    }

    @a
    int collate() default 1;

    String defaultValue() default "[value-unspecified]";

    boolean index() default false;

    String name() default "[field-name]";

    @b
    int typeAffinity() default 1;
}
