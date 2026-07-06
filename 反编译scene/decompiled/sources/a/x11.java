package a;

import com.omarea.model.ProcessInfo;
import java.util.Comparator;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class x11<T> implements Comparator<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a21 f7844a;

    public x11(a21 a21Var) {
        this.f7844a = a21Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        int i;
        int i2;
        int cpu;
        int cpu2;
        ProcessInfo processInfo = (ProcessInfo) t;
        int i3 = this.f7844a.f5562a;
        if (i3 == 1) {
            i = processInfo.pid;
        } else {
            if (i3 == 4) {
                cpu2 = (int) (processInfo.getCpu() * 10);
            } else if (i3 != 8) {
                if (i3 == 16) {
                    cpu2 = processInfo.pid;
                }
                i = processInfo.pid;
            } else {
                cpu2 = (int) (processInfo.res * ((long) 100));
            }
            i = -cpu2;
        }
        Integer numValueOf = Integer.valueOf(i);
        ProcessInfo processInfo2 = (ProcessInfo) t2;
        int i4 = this.f7844a.f5562a;
        if (i4 == 1) {
            i2 = processInfo2.pid;
        } else {
            if (i4 == 4) {
                cpu = (int) (processInfo2.getCpu() * 10);
            } else if (i4 != 8) {
                if (i4 == 16) {
                    cpu = processInfo2.pid;
                }
                i2 = processInfo2.pid;
            } else {
                cpu = (int) (processInfo2.res * ((long) 100));
            }
            i2 = -cpu;
        }
        return w52.a(numValueOf, Integer.valueOf(i2));
    }
}
