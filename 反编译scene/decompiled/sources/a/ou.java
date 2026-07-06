package a;

import android.view.View;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public interface ou {
    void a(View view, int i, int i2, qu quVar);

    int b(int i, int i2, int i3);

    int c(int i, int i2, int i3);

    void d(int i, View view);

    View e(int i);

    int f(View view, int i, int i2);

    int getAlignContent();

    int getAlignItems();

    int getFlexDirection();

    int getFlexItemCount();

    List<qu> getFlexLinesInternal();

    int getFlexWrap();

    int getLargestMainSize();

    int getMaxLine();

    int getPaddingBottom();

    int getPaddingEnd();

    int getPaddingLeft();

    int getPaddingRight();

    int getPaddingStart();

    int getPaddingTop();

    int getSumOfCrossSize();

    void h(qu quVar);

    boolean i();

    int j(View view);

    View k(int i);

    void setFlexLines(List<qu> list);
}
