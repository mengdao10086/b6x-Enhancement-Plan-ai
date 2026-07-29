package com.google.android.material.elevation;

import android.content.Context;
import com.google.android.material.R;
import g.l;
import g.n0;
import g.q;
import g.r;
import vd.m;
import zd.a;

/* JADX INFO: loaded from: classes3.dex */
public enum SurfaceColors {
    SURFACE_0(R.dimen.m3_sys_elevation_level0),
    SURFACE_1(R.dimen.m3_sys_elevation_level1),
    SURFACE_2(R.dimen.m3_sys_elevation_level2),
    SURFACE_3(R.dimen.m3_sys_elevation_level3),
    SURFACE_4(R.dimen.m3_sys_elevation_level4),
    SURFACE_5(R.dimen.m3_sys_elevation_level5);

    private final int elevationResId;

    SurfaceColors(@q int i10) {
        this.elevationResId = i10;
    }

    @l
    public static int getColorForElevation(@n0 Context context, @r float f10) {
        return new a(context).c(m.b(context, R.attr.colorSurface, 0), f10);
    }

    @l
    public int getColor(@n0 Context context) {
        return getColorForElevation(context, context.getResources().getDimension(this.elevationResId));
    }
}
