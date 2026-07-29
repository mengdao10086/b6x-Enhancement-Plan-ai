package no.nordicsemi.android.error;

import ee.a;
import gg.b;

/* JADX INFO: loaded from: classes5.dex */
public final class LegacyDfuError {
    public static final int CRC_ERROR = 5;
    public static final int DATA_SIZE_EXCEEDS_LIMIT = 4;
    public static final int INVALID_STATE = 2;
    public static final int NOT_SUPPORTED = 3;
    public static final int OPERATION_FAILED = 6;

    public static String parse(final int error) {
        switch (error) {
            case b.f29449j /* 258 */:
                return "INVALID STATE";
            case b.f29457l /* 259 */:
                return "NOT SUPPORTED";
            case b.f29465n /* 260 */:
                return "DATA SIZE EXCEEDS LIMIT";
            case b.f29473p /* 261 */:
                return "INVALID CRC ERROR";
            case b.f29481r /* 262 */:
                return "OPERATION FAILED";
            default:
                return "UNKNOWN (" + error + a.f26979d;
        }
    }
}
