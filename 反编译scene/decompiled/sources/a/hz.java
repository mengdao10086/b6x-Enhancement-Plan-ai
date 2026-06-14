package a;

import android.content.res.ColorStateList;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class hz extends Drawable.ConstantState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f6356a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f1266a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public nz f1267a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public sw f1268a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ColorStateList f1269a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ColorFilter f1270a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Paint.Style f1271a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public PorterDuff.Mode f1272a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Rect f1273a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f1274a;
    public float b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public int f1275b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public ColorStateList f1276b;
    public float c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public int f1277c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public ColorStateList f1278c;
    public float d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public int f1279d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public ColorStateList f1280d;
    public float e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public int f1281e;
    public float f;

    public hz(hz hzVar) {
        this.f1269a = null;
        this.f1276b = null;
        this.f1278c = null;
        this.f1280d = null;
        this.f1272a = PorterDuff.Mode.SRC_IN;
        this.f1273a = null;
        this.f6356a = 1.0f;
        this.b = 1.0f;
        this.f1266a = 255;
        this.d = 0.0f;
        this.e = 0.0f;
        this.f = 0.0f;
        this.f1275b = 0;
        this.f1277c = 0;
        this.f1279d = 0;
        this.f1281e = 0;
        this.f1274a = false;
        this.f1271a = Paint.Style.FILL_AND_STROKE;
        this.f1267a = hzVar.f1267a;
        this.f1268a = hzVar.f1268a;
        this.c = hzVar.c;
        this.f1270a = hzVar.f1270a;
        this.f1269a = hzVar.f1269a;
        this.f1276b = hzVar.f1276b;
        this.f1272a = hzVar.f1272a;
        this.f1280d = hzVar.f1280d;
        this.f1266a = hzVar.f1266a;
        this.f6356a = hzVar.f6356a;
        this.f1279d = hzVar.f1279d;
        this.f1275b = hzVar.f1275b;
        this.f1274a = hzVar.f1274a;
        this.b = hzVar.b;
        this.d = hzVar.d;
        this.e = hzVar.e;
        this.f = hzVar.f;
        this.f1277c = hzVar.f1277c;
        this.f1281e = hzVar.f1281e;
        this.f1278c = hzVar.f1278c;
        this.f1271a = hzVar.f1271a;
        if (hzVar.f1273a != null) {
            this.f1273a = new Rect(hzVar.f1273a);
        }
    }

    public hz(nz nzVar, sw swVar) {
        this.f1269a = null;
        this.f1276b = null;
        this.f1278c = null;
        this.f1280d = null;
        this.f1272a = PorterDuff.Mode.SRC_IN;
        this.f1273a = null;
        this.f6356a = 1.0f;
        this.b = 1.0f;
        this.f1266a = 255;
        this.d = 0.0f;
        this.e = 0.0f;
        this.f = 0.0f;
        this.f1275b = 0;
        this.f1277c = 0;
        this.f1279d = 0;
        this.f1281e = 0;
        this.f1274a = false;
        this.f1271a = Paint.Style.FILL_AND_STROKE;
        this.f1267a = nzVar;
        this.f1268a = swVar;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public int getChangingConfigurations() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable() {
        iz izVar = new iz(this, null);
        izVar.f1464b = true;
        return izVar;
    }
}
