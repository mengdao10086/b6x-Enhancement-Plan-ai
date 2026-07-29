package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;

/* JADX INFO: loaded from: classes7.dex */
@GwtCompatible
public enum BoundType {
    OPEN(false),
    CLOSED(true);

    public final boolean inclusive;

    BoundType(boolean z10) {
        this.inclusive = z10;
    }

    public static BoundType forBoolean(boolean z10) {
        return z10 ? CLOSED : OPEN;
    }

    public BoundType flip() {
        return forBoolean(!this.inclusive);
    }
}
