package com.google.android.flexbox;

import android.view.View;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface d {

    /* JADX INFO: renamed from: s1, reason: collision with root package name */
    public static final int f19400s1 = -1;

    void addView(View view);

    void addView(View view, int index);

    void b(View view, int index, int indexInFlexLine, f flexLine);

    void c(f flexLine);

    View d(int index);

    int e(int widthSpec, int padding, int childDimension);

    void f(int position, View view);

    int getAlignContent();

    int getAlignItems();

    int getFlexDirection();

    int getFlexItemCount();

    List<f> getFlexLines();

    List<f> getFlexLinesInternal();

    int getFlexWrap();

    int getJustifyContent();

    int getLargestMainSize();

    int getMaxLine();

    int getPaddingBottom();

    int getPaddingEnd();

    int getPaddingLeft();

    int getPaddingRight();

    int getPaddingStart();

    int getPaddingTop();

    int getSumOfCrossSize();

    View h(int index);

    int i(View view, int index, int indexInFlexLine);

    int j(int heightSpec, int padding, int childDimension);

    boolean k();

    int l(View view);

    void removeAllViews();

    void removeViewAt(int index);

    void setAlignContent(int alignContent);

    void setAlignItems(int alignItems);

    void setFlexDirection(int flexDirection);

    void setFlexLines(List<f> flexLines);

    void setFlexWrap(int flexWrap);

    void setJustifyContent(int justifyContent);

    void setMaxLine(int maxLine);
}
