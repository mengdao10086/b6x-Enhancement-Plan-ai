package m0;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import kotlin.z1;

/* JADX INFO: loaded from: classes2.dex */
public final class e {
    public static final void a(@yt.k Canvas canvas, float f10, float f11, float f12, float f13, @yt.k ik.l<? super Canvas, z1> block) {
        kotlin.jvm.internal.f0.p(canvas, "<this>");
        kotlin.jvm.internal.f0.p(block, "block");
        int iSave = canvas.save();
        canvas.clipRect(f10, f11, f12, f13);
        try {
            block.i(canvas);
        } finally {
            kotlin.jvm.internal.c0.d(1);
            canvas.restoreToCount(iSave);
            kotlin.jvm.internal.c0.c(1);
        }
    }

    public static final void b(@yt.k Canvas canvas, int i10, int i11, int i12, int i13, @yt.k ik.l<? super Canvas, z1> block) {
        kotlin.jvm.internal.f0.p(canvas, "<this>");
        kotlin.jvm.internal.f0.p(block, "block");
        int iSave = canvas.save();
        canvas.clipRect(i10, i11, i12, i13);
        try {
            block.i(canvas);
        } finally {
            kotlin.jvm.internal.c0.d(1);
            canvas.restoreToCount(iSave);
            kotlin.jvm.internal.c0.c(1);
        }
    }

    public static final void c(@yt.k Canvas canvas, @yt.k Path clipPath, @yt.k ik.l<? super Canvas, z1> block) {
        kotlin.jvm.internal.f0.p(canvas, "<this>");
        kotlin.jvm.internal.f0.p(clipPath, "clipPath");
        kotlin.jvm.internal.f0.p(block, "block");
        int iSave = canvas.save();
        canvas.clipPath(clipPath);
        try {
            block.i(canvas);
        } finally {
            kotlin.jvm.internal.c0.d(1);
            canvas.restoreToCount(iSave);
            kotlin.jvm.internal.c0.c(1);
        }
    }

    public static final void d(@yt.k Canvas canvas, @yt.k Rect clipRect, @yt.k ik.l<? super Canvas, z1> block) {
        kotlin.jvm.internal.f0.p(canvas, "<this>");
        kotlin.jvm.internal.f0.p(clipRect, "clipRect");
        kotlin.jvm.internal.f0.p(block, "block");
        int iSave = canvas.save();
        canvas.clipRect(clipRect);
        try {
            block.i(canvas);
        } finally {
            kotlin.jvm.internal.c0.d(1);
            canvas.restoreToCount(iSave);
            kotlin.jvm.internal.c0.c(1);
        }
    }

    public static final void e(@yt.k Canvas canvas, @yt.k RectF clipRect, @yt.k ik.l<? super Canvas, z1> block) {
        kotlin.jvm.internal.f0.p(canvas, "<this>");
        kotlin.jvm.internal.f0.p(clipRect, "clipRect");
        kotlin.jvm.internal.f0.p(block, "block");
        int iSave = canvas.save();
        canvas.clipRect(clipRect);
        try {
            block.i(canvas);
        } finally {
            kotlin.jvm.internal.c0.d(1);
            canvas.restoreToCount(iSave);
            kotlin.jvm.internal.c0.c(1);
        }
    }

    public static final void f(@yt.k Canvas canvas, @yt.k Matrix matrix, @yt.k ik.l<? super Canvas, z1> block) {
        kotlin.jvm.internal.f0.p(canvas, "<this>");
        kotlin.jvm.internal.f0.p(matrix, "matrix");
        kotlin.jvm.internal.f0.p(block, "block");
        int iSave = canvas.save();
        canvas.concat(matrix);
        try {
            block.i(canvas);
        } finally {
            kotlin.jvm.internal.c0.d(1);
            canvas.restoreToCount(iSave);
            kotlin.jvm.internal.c0.c(1);
        }
    }

    public static /* synthetic */ void g(Canvas canvas, Matrix matrix, ik.l block, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            matrix = new Matrix();
        }
        kotlin.jvm.internal.f0.p(canvas, "<this>");
        kotlin.jvm.internal.f0.p(matrix, "matrix");
        kotlin.jvm.internal.f0.p(block, "block");
        int iSave = canvas.save();
        canvas.concat(matrix);
        try {
            block.i(canvas);
        } finally {
            kotlin.jvm.internal.c0.d(1);
            canvas.restoreToCount(iSave);
            kotlin.jvm.internal.c0.c(1);
        }
    }

    public static final void h(@yt.k Canvas canvas, float f10, float f11, float f12, @yt.k ik.l<? super Canvas, z1> block) {
        kotlin.jvm.internal.f0.p(canvas, "<this>");
        kotlin.jvm.internal.f0.p(block, "block");
        int iSave = canvas.save();
        canvas.rotate(f10, f11, f12);
        try {
            block.i(canvas);
        } finally {
            kotlin.jvm.internal.c0.d(1);
            canvas.restoreToCount(iSave);
            kotlin.jvm.internal.c0.c(1);
        }
    }

    public static /* synthetic */ void i(Canvas canvas, float f10, float f11, float f12, ik.l block, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            f10 = 0.0f;
        }
        if ((i10 & 2) != 0) {
            f11 = 0.0f;
        }
        if ((i10 & 4) != 0) {
            f12 = 0.0f;
        }
        kotlin.jvm.internal.f0.p(canvas, "<this>");
        kotlin.jvm.internal.f0.p(block, "block");
        int iSave = canvas.save();
        canvas.rotate(f10, f11, f12);
        try {
            block.i(canvas);
        } finally {
            kotlin.jvm.internal.c0.d(1);
            canvas.restoreToCount(iSave);
            kotlin.jvm.internal.c0.c(1);
        }
    }

    public static final void j(@yt.k Canvas canvas, @yt.k ik.l<? super Canvas, z1> block) {
        kotlin.jvm.internal.f0.p(canvas, "<this>");
        kotlin.jvm.internal.f0.p(block, "block");
        int iSave = canvas.save();
        try {
            block.i(canvas);
        } finally {
            kotlin.jvm.internal.c0.d(1);
            canvas.restoreToCount(iSave);
            kotlin.jvm.internal.c0.c(1);
        }
    }

    public static final void k(@yt.k Canvas canvas, float f10, float f11, float f12, float f13, @yt.k ik.l<? super Canvas, z1> block) {
        kotlin.jvm.internal.f0.p(canvas, "<this>");
        kotlin.jvm.internal.f0.p(block, "block");
        int iSave = canvas.save();
        canvas.scale(f10, f11, f12, f13);
        try {
            block.i(canvas);
        } finally {
            kotlin.jvm.internal.c0.d(1);
            canvas.restoreToCount(iSave);
            kotlin.jvm.internal.c0.c(1);
        }
    }

    public static /* synthetic */ void l(Canvas canvas, float f10, float f11, float f12, float f13, ik.l block, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            f10 = 1.0f;
        }
        if ((i10 & 2) != 0) {
            f11 = 1.0f;
        }
        if ((i10 & 4) != 0) {
            f12 = 0.0f;
        }
        if ((i10 & 8) != 0) {
            f13 = 0.0f;
        }
        kotlin.jvm.internal.f0.p(canvas, "<this>");
        kotlin.jvm.internal.f0.p(block, "block");
        int iSave = canvas.save();
        canvas.scale(f10, f11, f12, f13);
        try {
            block.i(canvas);
        } finally {
            kotlin.jvm.internal.c0.d(1);
            canvas.restoreToCount(iSave);
            kotlin.jvm.internal.c0.c(1);
        }
    }

    public static final void m(@yt.k Canvas canvas, float f10, float f11, @yt.k ik.l<? super Canvas, z1> block) {
        kotlin.jvm.internal.f0.p(canvas, "<this>");
        kotlin.jvm.internal.f0.p(block, "block");
        int iSave = canvas.save();
        canvas.skew(f10, f11);
        try {
            block.i(canvas);
        } finally {
            kotlin.jvm.internal.c0.d(1);
            canvas.restoreToCount(iSave);
            kotlin.jvm.internal.c0.c(1);
        }
    }

    public static /* synthetic */ void n(Canvas canvas, float f10, float f11, ik.l block, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            f10 = 0.0f;
        }
        if ((i10 & 2) != 0) {
            f11 = 0.0f;
        }
        kotlin.jvm.internal.f0.p(canvas, "<this>");
        kotlin.jvm.internal.f0.p(block, "block");
        int iSave = canvas.save();
        canvas.skew(f10, f11);
        try {
            block.i(canvas);
        } finally {
            kotlin.jvm.internal.c0.d(1);
            canvas.restoreToCount(iSave);
            kotlin.jvm.internal.c0.c(1);
        }
    }

    public static final void o(@yt.k Canvas canvas, float f10, float f11, @yt.k ik.l<? super Canvas, z1> block) {
        kotlin.jvm.internal.f0.p(canvas, "<this>");
        kotlin.jvm.internal.f0.p(block, "block");
        int iSave = canvas.save();
        canvas.translate(f10, f11);
        try {
            block.i(canvas);
        } finally {
            kotlin.jvm.internal.c0.d(1);
            canvas.restoreToCount(iSave);
            kotlin.jvm.internal.c0.c(1);
        }
    }

    public static /* synthetic */ void p(Canvas canvas, float f10, float f11, ik.l block, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            f10 = 0.0f;
        }
        if ((i10 & 2) != 0) {
            f11 = 0.0f;
        }
        kotlin.jvm.internal.f0.p(canvas, "<this>");
        kotlin.jvm.internal.f0.p(block, "block");
        int iSave = canvas.save();
        canvas.translate(f10, f11);
        try {
            block.i(canvas);
        } finally {
            kotlin.jvm.internal.c0.d(1);
            canvas.restoreToCount(iSave);
            kotlin.jvm.internal.c0.c(1);
        }
    }
}
