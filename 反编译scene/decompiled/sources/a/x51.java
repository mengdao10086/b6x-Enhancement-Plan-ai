package a;

import com.omarea.model.PowerStatAVG;
import java.util.Comparator;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class x51<T> implements Comparator<T> {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        return w52.a(Double.valueOf(((PowerStatAVG) t).power), Double.valueOf(((PowerStatAVG) t2).power));
    }
}
