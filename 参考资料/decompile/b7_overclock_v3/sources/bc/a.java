package bc;

import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.scte35.PrivateCommand;
import com.google.android.exoplayer2.metadata.scte35.SpliceInsertCommand;
import com.google.android.exoplayer2.metadata.scte35.SpliceNullCommand;
import com.google.android.exoplayer2.metadata.scte35.SpliceScheduleCommand;
import com.google.android.exoplayer2.metadata.scte35.TimeSignalCommand;
import hd.b0;
import hd.c0;
import hd.p0;
import java.nio.ByteBuffer;
import ub.d;
import ub.f;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends f {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f9269d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f9270e = 4;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f9271f = 5;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f9272g = 6;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f9273h = 255;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c0 f9274a = new c0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b0 f9275b = new b0();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public p0 f9276c;

    @Override // ub.f
    public Metadata b(d dVar, ByteBuffer byteBuffer) {
        p0 p0Var = this.f9276c;
        if (p0Var == null || dVar.f51973l != p0Var.e()) {
            p0 p0Var2 = new p0(dVar.f16962e);
            this.f9276c = p0Var2;
            p0Var2.a(dVar.f16962e - dVar.f51973l);
        }
        byte[] bArrArray = byteBuffer.array();
        int iLimit = byteBuffer.limit();
        this.f9274a.Q(bArrArray, iLimit);
        this.f9275b.p(bArrArray, iLimit);
        this.f9275b.s(39);
        long jH = (((long) this.f9275b.h(1)) << 32) | ((long) this.f9275b.h(32));
        this.f9275b.s(20);
        int iH = this.f9275b.h(12);
        int iH2 = this.f9275b.h(8);
        Metadata.Entry spliceNullCommand = null;
        this.f9274a.T(14);
        if (iH2 == 0) {
            spliceNullCommand = new SpliceNullCommand();
        } else if (iH2 == 255) {
            spliceNullCommand = PrivateCommand.a(this.f9274a, iH, jH);
        } else if (iH2 == 4) {
            spliceNullCommand = SpliceScheduleCommand.a(this.f9274a);
        } else if (iH2 == 5) {
            spliceNullCommand = SpliceInsertCommand.a(this.f9274a, jH, this.f9276c);
        } else if (iH2 == 6) {
            spliceNullCommand = TimeSignalCommand.a(this.f9274a, jH, this.f9276c);
        }
        return spliceNullCommand == null ? new Metadata(new Metadata.Entry[0]) : new Metadata(spliceNullCommand);
    }
}
