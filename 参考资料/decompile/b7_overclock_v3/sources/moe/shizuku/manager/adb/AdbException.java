package moe.shizuku.manager.adb;

import kotlin.jvm.internal.f0;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes5.dex */
public class AdbException extends Exception {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdbException(@k String message, @l Throwable th2) {
        super(message, th2);
        f0.p(message, "message");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdbException(@k String message) {
        super(message);
        f0.p(message, "message");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdbException(@k Throwable cause) {
        super(cause);
        f0.p(cause, "cause");
    }

    public AdbException() {
    }
}
