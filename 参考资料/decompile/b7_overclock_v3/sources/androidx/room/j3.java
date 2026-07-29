package androidx.room;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes2.dex */
@Retention(RetentionPolicy.CLASS)
public @interface j3 {
    Class<?> entity() default Object.class;

    @l1
    int onConflict() default 3;
}
