package a;

import android.view.ViewGroup;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class tr {
    public static tr b(ViewGroup viewGroup) {
        return (tr) viewGroup.getTag(rr.transition_current_scene);
    }

    public static void c(ViewGroup viewGroup, tr trVar) {
        viewGroup.setTag(rr.transition_current_scene, trVar);
    }

    public abstract void a();
}
