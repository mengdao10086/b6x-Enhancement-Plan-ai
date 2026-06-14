package a;

import com.omarea.model.DeviceBindInfo;
import java.util.Comparator;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class sv1<T> implements Comparator<T> {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        return w52.a(Boolean.valueOf(!((DeviceBindInfo) t).getCurrent()), Boolean.valueOf(!((DeviceBindInfo) t2).getCurrent()));
    }
}
