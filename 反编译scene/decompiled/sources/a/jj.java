package a;

import android.widget.ListView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class jj extends ej {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ListView f6515a;

    public jj(ListView listView) {
        super(listView);
        this.f6515a = listView;
    }

    @Override // a.ej
    public boolean a(int i) {
        return false;
    }

    @Override // a.ej
    public boolean b(int i) {
        ListView listView = this.f6515a;
        int count = listView.getCount();
        if (count == 0) {
            return false;
        }
        int childCount = listView.getChildCount();
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        int i2 = firstVisiblePosition + childCount;
        if (i > 0) {
            if (i2 >= count && listView.getChildAt(childCount - 1).getBottom() <= listView.getHeight()) {
                return false;
            }
        } else {
            if (i >= 0) {
                return false;
            }
            if (firstVisiblePosition <= 0 && listView.getChildAt(0).getTop() >= 0) {
                return false;
            }
        }
        return true;
    }

    @Override // a.ej
    public void j(int i, int i2) {
        kj.a(this.f6515a, i2);
    }
}
