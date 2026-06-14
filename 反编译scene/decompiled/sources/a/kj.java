package a;

import android.os.Build;
import android.view.View;
import android.widget.ListView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class kj {
    public static void a(ListView listView, int i) {
        View childAt;
        if (Build.VERSION.SDK_INT >= 19) {
            listView.scrollListBy(i);
            return;
        }
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        if (firstVisiblePosition == -1 || (childAt = listView.getChildAt(0)) == null) {
            return;
        }
        listView.setSelectionFromTop(firstVisiblePosition, childAt.getTop() - i);
    }
}
