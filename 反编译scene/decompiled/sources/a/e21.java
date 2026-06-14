package a;

import com.omarea.model.ProcessInfo;
import java.util.Comparator;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class e21<T> implements Comparator<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f21 f5960a;

    public e21(f21 f21Var) {
        this.f5960a = f21Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        int i;
        int i2;
        int i3;
        int i4;
        ProcessInfo processInfo = (ProcessInfo) t;
        int i5 = this.f5960a.f6067a;
        if (i5 == 1) {
            i = processInfo.pid;
        } else {
            if (i5 == 4) {
                i4 = (int) (processInfo.cpu * 10);
            } else if (i5 != 8) {
                if (i5 == 16) {
                    i4 = processInfo.pid;
                }
                i = processInfo.pid;
            } else {
                i4 = (int) (processInfo.rss * ((long) 100));
            }
            i = -i4;
        }
        Integer numValueOf = Integer.valueOf(i);
        ProcessInfo processInfo2 = (ProcessInfo) t2;
        int i6 = this.f5960a.f6067a;
        if (i6 == 1) {
            i2 = processInfo2.pid;
        } else {
            if (i6 == 4) {
                i3 = (int) (processInfo2.cpu * 10);
            } else if (i6 != 8) {
                if (i6 == 16) {
                    i3 = processInfo2.pid;
                }
                i2 = processInfo2.pid;
            } else {
                i3 = (int) (processInfo2.rss * ((long) 100));
            }
            i2 = -i3;
        }
        return w52.a(numValueOf, Integer.valueOf(i2));
    }
}
