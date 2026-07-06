package a;

import java.util.HashMap;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public interface ha0 {
    boolean eventFilter(aa0 aa0Var);

    boolean isAsync();

    void onReceive(aa0 aa0Var, HashMap<String, Object> map);

    void onSubscribe();

    void onUnsubscribe();
}
