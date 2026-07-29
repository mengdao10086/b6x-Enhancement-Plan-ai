package yt;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes6.dex */
public final class b {

    @Target({ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.PARAMETER})
    @Retention(RetentionPolicy.CLASS)
    public @interface a {
    }

    /* JADX INFO: renamed from: yt.b$b, reason: collision with other inner class name */
    @Target({ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.PARAMETER})
    @Retention(RetentionPolicy.CLASS)
    public @interface InterfaceC0678b {
    }

    public b() {
        throw new AssertionError("Async should not be instantiated");
    }
}
