package kotlin.jvm;

import yt.l;

/* JADX INFO: loaded from: classes5.dex */
public class KotlinReflectionNotSupportedError extends Error {
    public KotlinReflectionNotSupportedError() {
        super("Kotlin reflection implementation is not found at runtime. Make sure you have kotlin-reflect.jar in the classpath");
    }

    public KotlinReflectionNotSupportedError(@l String str) {
        super(str);
    }

    public KotlinReflectionNotSupportedError(@l String str, @l Throwable th2) {
        super(str, th2);
    }

    public KotlinReflectionNotSupportedError(@l Throwable th2) {
        super(th2);
    }
}
