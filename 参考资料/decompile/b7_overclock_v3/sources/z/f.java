package z;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.constraintlayout.motion.widget.p;
import androidx.constraintlayout.widget.R;

/* JADX INFO: loaded from: classes2.dex */
public class f extends p {
    public static final int A = 3;
    public static final int B = -1;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final String f57627v = "FadeMove";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f57628w = -1;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f57629x = 0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f57630y = 1;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f57631z = 2;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f57632n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f57633o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f57634p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f57635q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f57636r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f57637s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f57638t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f57639u;

    public f(Context context) {
        super(context);
        this.f57632n = 0.1f;
        this.f57633o = 49;
        this.f57634p = 50;
        this.f57635q = 0;
        this.f57636r = 0;
        this.f57637s = true;
        this.f57638t = -1;
        this.f57639u = -1;
    }

    public final void K(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.MotionEffect);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                if (index == R.styleable.MotionEffect_motionEffect_start) {
                    int i11 = typedArrayObtainStyledAttributes.getInt(index, this.f57633o);
                    this.f57633o = i11;
                    this.f57633o = Math.max(Math.min(i11, 99), 0);
                } else if (index == R.styleable.MotionEffect_motionEffect_end) {
                    int i12 = typedArrayObtainStyledAttributes.getInt(index, this.f57634p);
                    this.f57634p = i12;
                    this.f57634p = Math.max(Math.min(i12, 99), 0);
                } else if (index == R.styleable.MotionEffect_motionEffect_translationX) {
                    this.f57635q = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f57635q);
                } else if (index == R.styleable.MotionEffect_motionEffect_translationY) {
                    this.f57636r = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f57636r);
                } else if (index == R.styleable.MotionEffect_motionEffect_alpha) {
                    this.f57632n = typedArrayObtainStyledAttributes.getFloat(index, this.f57632n);
                } else if (index == R.styleable.MotionEffect_motionEffect_move) {
                    this.f57639u = typedArrayObtainStyledAttributes.getInt(index, this.f57639u);
                } else if (index == R.styleable.MotionEffect_motionEffect_strict) {
                    this.f57637s = typedArrayObtainStyledAttributes.getBoolean(index, this.f57637s);
                } else if (index == R.styleable.MotionEffect_motionEffect_viewTransition) {
                    this.f57638t = typedArrayObtainStyledAttributes.getResourceId(index, this.f57638t);
                }
            }
            int i13 = this.f57633o;
            int i14 = this.f57634p;
            if (i13 == i14) {
                if (i13 > 0) {
                    this.f57633o = i13 - 1;
                } else {
                    this.f57634p = i14 + 1;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x0180, code lost:
    
        if (r14 == 0.0f) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0194, code lost:
    
        if (r14 == 0.0f) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x01a4, code lost:
    
        if (r15 == 0.0f) goto L55;
     */
    /* JADX WARN: Removed duplicated region for block: B:46:0x015c  */
    @Override // androidx.constraintlayout.motion.widget.p, androidx.constraintlayout.motion.widget.q
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void g(androidx.constraintlayout.motion.widget.MotionLayout r22, java.util.HashMap<android.view.View, androidx.constraintlayout.motion.widget.o> r23) {
        /*
            Method dump skipped, instruction units count: 494
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: z.f.g(androidx.constraintlayout.motion.widget.MotionLayout, java.util.HashMap):void");
    }

    @Override // androidx.constraintlayout.motion.widget.p, androidx.constraintlayout.motion.widget.q
    public boolean j() {
        return true;
    }

    public f(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f57632n = 0.1f;
        this.f57633o = 49;
        this.f57634p = 50;
        this.f57635q = 0;
        this.f57636r = 0;
        this.f57637s = true;
        this.f57638t = -1;
        this.f57639u = -1;
        K(context, attrs);
    }

    public f(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.f57632n = 0.1f;
        this.f57633o = 49;
        this.f57634p = 50;
        this.f57635q = 0;
        this.f57636r = 0;
        this.f57637s = true;
        this.f57638t = -1;
        this.f57639u = -1;
        K(context, attrs);
    }
}
