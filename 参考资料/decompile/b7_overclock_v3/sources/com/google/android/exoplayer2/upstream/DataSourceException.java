package com.google.android.exoplayer2.upstream;

import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public final class DataSourceException extends IOException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f19022a = 0;
    public final int reason;

    public DataSourceException(int i10) {
        this.reason = i10;
    }

    public static boolean a(IOException iOException) {
        for (Throwable cause = iOException; cause != null; cause = cause.getCause()) {
            if ((cause instanceof DataSourceException) && ((DataSourceException) cause).reason == 0) {
                return true;
            }
        }
        return false;
    }
}
