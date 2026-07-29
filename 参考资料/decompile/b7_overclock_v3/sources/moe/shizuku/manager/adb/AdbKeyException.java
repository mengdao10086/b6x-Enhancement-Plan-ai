package moe.shizuku.manager.adb;

import kotlin.jvm.internal.f0;
import yt.k;

/* JADX INFO: loaded from: classes5.dex */
public final class AdbKeyException extends AdbException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdbKeyException(@k Throwable cause) {
        super(cause);
        f0.p(cause, "cause");
    }
}
