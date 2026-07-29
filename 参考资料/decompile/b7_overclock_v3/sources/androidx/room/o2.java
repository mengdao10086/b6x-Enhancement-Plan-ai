package androidx.room;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes2.dex */
@Target({ElementType.TYPE})
@Repeatable(a.class)
@Retention(RetentionPolicy.CLASS)
public @interface o2 {

    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.CLASS)
    public @interface a {
        o2[] value();
    }

    String fromColumnName();

    String tableName();

    String toColumnName();
}
