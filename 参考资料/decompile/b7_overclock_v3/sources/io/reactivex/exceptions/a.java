package io.reactivex.exceptions;

import bj.e;
import io.reactivex.internal.util.ExceptionHelper;

/* JADX INFO: loaded from: classes5.dex */
public final class a {
    public a() {
        throw new IllegalStateException("No instances!");
    }

    @e
    public static RuntimeException a(@e Throwable th2) {
        throw ExceptionHelper.f(th2);
    }

    public static void b(@e Throwable th2) {
        if (th2 instanceof VirtualMachineError) {
            throw ((VirtualMachineError) th2);
        }
        if (th2 instanceof ThreadDeath) {
            throw ((ThreadDeath) th2);
        }
        if (th2 instanceof LinkageError) {
            throw ((LinkageError) th2);
        }
    }
}
