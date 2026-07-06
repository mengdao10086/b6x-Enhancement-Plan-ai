package a;

import android.R;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Shader;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.util.AttributeSet;
import android.widget.ProgressBar;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class c6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f5763a = {R.attr.indeterminateDrawable, R.attr.progressDrawable};

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Bitmap f354a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ProgressBar f355a;

    public c6(ProgressBar progressBar) {
        this.f355a = progressBar;
    }

    public final Shape a() {
        return new RoundRectShape(new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f}, null, null);
    }

    public Bitmap b() {
        return this.f354a;
    }

    public void c(AttributeSet attributeSet, int i) {
        o8 o8VarV = o8.v(this.f355a.getContext(), attributeSet, f5763a, i, 0);
        Drawable drawableH = o8VarV.h(0);
        if (drawableH != null) {
            this.f355a.setIndeterminateDrawable(e(drawableH));
        }
        Drawable drawableH2 = o8VarV.h(1);
        if (drawableH2 != null) {
            this.f355a.setProgressDrawable(d(drawableH2, false));
        }
        o8VarV.w();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Drawable d(Drawable drawable, boolean z) {
        if (drawable instanceof md) {
            md mdVar = (md) drawable;
            Drawable drawableA = mdVar.a();
            if (drawableA != null) {
                mdVar.b(d(drawableA, z));
            }
        } else {
            if (drawable instanceof LayerDrawable) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                int numberOfLayers = layerDrawable.getNumberOfLayers();
                Drawable[] drawableArr = new Drawable[numberOfLayers];
                for (int i = 0; i < numberOfLayers; i++) {
                    int id = layerDrawable.getId(i);
                    drawableArr[i] = d(layerDrawable.getDrawable(i), id == 16908301 || id == 16908303);
                }
                LayerDrawable layerDrawable2 = new LayerDrawable(drawableArr);
                for (int i2 = 0; i2 < numberOfLayers; i2++) {
                    layerDrawable2.setId(i2, layerDrawable.getId(i2));
                }
                return layerDrawable2;
            }
            if (drawable instanceof BitmapDrawable) {
                BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
                Bitmap bitmap = bitmapDrawable.getBitmap();
                if (this.f354a == null) {
                    this.f354a = bitmap;
                }
                ShapeDrawable shapeDrawable = new ShapeDrawable(a());
                shapeDrawable.getPaint().setShader(new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP));
                shapeDrawable.getPaint().setColorFilter(bitmapDrawable.getPaint().getColorFilter());
                return z ? new ClipDrawable(shapeDrawable, 3, 1) : shapeDrawable;
            }
        }
        return drawable;
    }

    public final Drawable e(Drawable drawable) {
        if (!(drawable instanceof AnimationDrawable)) {
            return drawable;
        }
        AnimationDrawable animationDrawable = (AnimationDrawable) drawable;
        int numberOfFrames = animationDrawable.getNumberOfFrames();
        AnimationDrawable animationDrawable2 = new AnimationDrawable();
        animationDrawable2.setOneShot(animationDrawable.isOneShot());
        for (int i = 0; i < numberOfFrames; i++) {
            Drawable drawableD = d(animationDrawable.getFrame(i), true);
            drawableD.setLevel(10000);
            animationDrawable2.addFrame(drawableD, animationDrawable.getDuration(i));
        }
        animationDrawable2.setLevel(10000);
        return animationDrawable2;
    }
}
