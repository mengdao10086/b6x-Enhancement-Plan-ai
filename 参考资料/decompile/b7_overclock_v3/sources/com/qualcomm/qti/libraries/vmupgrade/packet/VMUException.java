package com.qualcomm.qti.libraries.vmupgrade.packet;

import android.annotation.SuppressLint;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import jg.d;

/* JADX INFO: loaded from: classes5.dex */
public class VMUException extends Exception {
    private final byte[] mBytes;
    private final String mMessage;
    private final int mType;

    @Retention(RetentionPolicy.SOURCE)
    @SuppressLint({"ShiftFlags"})
    public @interface a {

        /* JADX INFO: renamed from: o1, reason: collision with root package name */
        public static final int f22175o1 = 0;

        /* JADX INFO: renamed from: p1, reason: collision with root package name */
        public static final int f22176p1 = 1;

        /* JADX INFO: renamed from: q1, reason: collision with root package name */
        public static final int f22177q1 = 2;

        /* JADX INFO: renamed from: r1, reason: collision with root package name */
        public static final int f22178r1 = 3;
    }

    public VMUException(int i10) {
        this.mType = i10;
        this.mMessage = "";
        this.mBytes = new byte[0];
    }

    public int a() {
        return this.mType;
    }

    @Override // java.lang.Throwable
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        int i10 = this.mType;
        if (i10 == 0) {
            sb2.append("Build of a VMUPacket failed: the byte array does not contain the minimum required information");
            sb2.append("\nReceived bytes: ");
            sb2.append(d.g(this.mBytes));
        } else if (i10 == 2) {
            sb2.append("Get file failed: The given file size is >= 2GB");
        } else if (i10 != 3) {
            sb2.append("VMU Exception occurs");
        } else {
            sb2.append("Get file failed");
            if (this.mMessage.length() > 0) {
                sb2.append(": ");
                sb2.append(this.mMessage);
            }
        }
        return sb2.toString();
    }

    public VMUException(int i10, String str) {
        this.mType = i10;
        this.mMessage = str;
        this.mBytes = new byte[0];
    }

    public VMUException(int i10, byte[] bArr) {
        this.mType = i10;
        this.mMessage = "";
        this.mBytes = bArr;
    }
}
