package io.objectbox.sync;

/* JADX INFO: loaded from: classes5.dex */
public enum SyncState {
    UNKNOWN(0),
    CREATED(1),
    STARTED(2),
    CONNECTED(3),
    LOGGED_IN(4),
    DISCONNECTED(5),
    STOPPED(6),
    DEAD(7);


    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final int f32953id;

    SyncState(int i10) {
        this.f32953id = i10;
    }

    public static SyncState fromId(int i10) {
        for (SyncState syncState : values()) {
            if (syncState.f32953id == i10) {
                return syncState;
            }
        }
        return UNKNOWN;
    }
}
