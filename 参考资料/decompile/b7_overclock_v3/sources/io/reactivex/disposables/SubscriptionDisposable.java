package io.reactivex.disposables;

import bu.e;

/* JADX INFO: loaded from: classes5.dex */
final class SubscriptionDisposable extends ReferenceDisposable<e> {
    private static final long serialVersionUID = -707001650852963139L;

    public SubscriptionDisposable(e eVar) {
        super(eVar);
    }

    @Override // io.reactivex.disposables.ReferenceDisposable
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void a(@bj.e e eVar) {
        eVar.cancel();
    }
}
