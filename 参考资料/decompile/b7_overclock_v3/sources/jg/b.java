package jg;

import android.annotation.SuppressLint;
import android.support.v4.media.MediaDescriptionCompat;
import com.qualcomm.qti.libraries.vmupgrade.packet.VMUException;
import g.f0;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes5.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f36392a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f36393b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final VMUException f36394c;

    @Retention(RetentionPolicy.SOURCE)
    @SuppressLint({"ShiftFlags"})
    public @interface a {
        public static final int F2 = 1;
        public static final int G2 = 2;
        public static final int H2 = 3;
        public static final int I2 = 4;
        public static final int J2 = 5;
        public static final int K2 = 6;
    }

    public b(int i10) {
        this.f36392a = i10;
        this.f36393b = 0;
        this.f36394c = null;
    }

    public int a() {
        return this.f36392a;
    }

    public VMUException b() {
        return this.f36394c;
    }

    public int c() {
        return this.f36393b;
    }

    public String d() {
        switch (this.f36392a) {
            case 1:
                return "The board is not ready to process an upgrade.";
            case 2:
                return "The board does not send the expected parameter(s).";
            case 3:
                return "An error occurs on the board during the upgrade process.\n\t- Received error code: " + d.f(this.f36393b) + "\n\t- Received error message: " + kg.c.b(this.f36393b);
            case 4:
                StringBuilder sb2 = new StringBuilder();
                sb2.append("An Exception has occurred");
                if (this.f36394c != null) {
                    sb2.append(": ");
                    sb2.append(this.f36394c.toString());
                }
                return sb2.toString();
            case 5:
                return "Attempt to start an upgrade failed: an upgrade is already processing.";
            case 6:
                return "The provided file is empty or does not exist.";
            default:
                return "An error has occurred during the upgrade process.";
        }
    }

    public b(@f0(from = MediaDescriptionCompat.f932o, to = MediaDescriptionCompat.f932o) int i10, int i11) {
        this.f36392a = i10;
        this.f36393b = i11;
        this.f36394c = null;
    }

    public b(VMUException vMUException) {
        this.f36392a = 4;
        this.f36393b = 0;
        this.f36394c = vMUException;
    }
}
