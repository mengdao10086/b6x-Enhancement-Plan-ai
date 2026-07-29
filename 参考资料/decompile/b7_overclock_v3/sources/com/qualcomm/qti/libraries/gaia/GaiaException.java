package com.qualcomm.qti.libraries.gaia;

import android.annotation.SuppressLint;
import gg.d;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes5.dex */
public class GaiaException extends Exception {
    private final int mCommand;
    private final int mType;

    @Retention(RetentionPolicy.SOURCE)
    @SuppressLint({"ShiftFlags"})
    public @interface a {

        /* JADX INFO: renamed from: j1, reason: collision with root package name */
        public static final int f22166j1 = 0;

        /* JADX INFO: renamed from: k1, reason: collision with root package name */
        public static final int f22167k1 = 1;

        /* JADX INFO: renamed from: l1, reason: collision with root package name */
        public static final int f22168l1 = 2;

        /* JADX INFO: renamed from: m1, reason: collision with root package name */
        public static final int f22169m1 = 3;

        /* JADX INFO: renamed from: n1, reason: collision with root package name */
        public static final int f22170n1 = 4;
    }

    public GaiaException(int i10) {
        this.mType = i10;
        this.mCommand = -1;
    }

    public int a() {
        return this.mType;
    }

    @Override // java.lang.Throwable
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        int i10 = this.mType;
        if (i10 == 0) {
            sb2.append("Build of a packet failed: the payload length is bigger than the authorized packet length.");
        } else if (i10 == 1) {
            sb2.append("Build of a packet failed: the packet is already an acknowledgement packet: not possible to create an acknowledgement packet from it.");
        } else if (i10 == 2) {
            sb2.append("Packet is not a COMMAND NOTIFICATION");
            if (this.mCommand >= 0) {
                sb2.append(", received command: ");
                sb2.append(d.c(this.mCommand));
            }
        } else if (i10 == 3) {
            sb2.append("Payload is missing argument");
            if (this.mCommand >= 0) {
                sb2.append(" for command: ");
                sb2.append(d.c(this.mCommand));
            }
        } else if (i10 != 4) {
            sb2.append("Gaia Exception occurred.");
        } else {
            sb2.append("The packet is not an acknowledgement, ");
            if (this.mCommand >= 0) {
                sb2.append(" received command: ");
                sb2.append(d.c(this.mCommand));
            }
        }
        return sb2.toString();
    }

    public GaiaException(int i10, int i11) {
        this.mType = i10;
        this.mCommand = i11;
    }
}
