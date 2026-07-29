package com.bumptech.glide.request;

/* JADX INFO: loaded from: classes2.dex */
public interface RequestCoordinator {

    public enum RequestState {
        RUNNING(false),
        PAUSED(false),
        CLEARED(false),
        SUCCESS(true),
        FAILED(true);

        private final boolean isComplete;

        RequestState(boolean z10) {
            this.isComplete = z10;
        }

        public boolean isComplete() {
            return this.isComplete;
        }
    }

    void a(e eVar);

    boolean b();

    boolean c(e eVar);

    boolean e(e eVar);

    void g(e eVar);

    RequestCoordinator getRoot();

    boolean i(e eVar);
}
