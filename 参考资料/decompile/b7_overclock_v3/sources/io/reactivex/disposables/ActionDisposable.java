package io.reactivex.disposables;

import bj.e;
import io.reactivex.internal.util.ExceptionHelper;

/* JADX INFO: loaded from: classes5.dex */
final class ActionDisposable extends ReferenceDisposable<dj.a> {
    private static final long serialVersionUID = -8219729196779211169L;

    public ActionDisposable(dj.a aVar) {
        super(aVar);
    }

    @Override // io.reactivex.disposables.ReferenceDisposable
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void a(@e dj.a aVar) {
        try {
            aVar.run();
        } catch (Throwable th2) {
            throw ExceptionHelper.f(th2);
        }
    }
}
