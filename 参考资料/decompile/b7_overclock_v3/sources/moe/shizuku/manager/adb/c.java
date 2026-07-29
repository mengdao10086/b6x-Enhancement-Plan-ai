package moe.shizuku.manager.adb;

import kotlin.jvm.internal.f0;
import yt.k;

/* JADX INFO: loaded from: classes5.dex */
public final class c {
    @k
    public static final Void a(@k Object message) throws AdbException {
        f0.p(message, "message");
        throw new AdbException(message.toString());
    }
}
