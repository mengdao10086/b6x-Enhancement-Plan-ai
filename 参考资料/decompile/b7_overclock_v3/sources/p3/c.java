package p3;

import android.content.Context;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.app.hubert.guide.model.HighLight;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class c extends FrameLayout {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f46349h = -1308622848;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public p3.b f46350a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Paint f46351b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.app.hubert.guide.model.a f46352c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public e f46353d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f46354e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f46355f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f46356g;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.f46352c.C()) {
                c.this.h();
            }
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.h();
        }
    }

    /* JADX INFO: renamed from: p3.c$c, reason: collision with other inner class name */
    public class C0522c extends r3.a {
        public C0522c() {
        }

        @Override // r3.a, android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            c.this.c();
        }
    }

    public static /* synthetic */ class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f46360a;

        static {
            int[] iArr = new int[HighLight.Shape.values().length];
            f46360a = iArr;
            try {
                iArr[HighLight.Shape.CIRCLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f46360a[HighLight.Shape.OVAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f46360a[HighLight.Shape.ROUND_RECTANGLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f46360a[HighLight.Shape.RECTANGLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public interface e {
        void a(c cVar);
    }

    public c(Context context, com.app.hubert.guide.model.a aVar, p3.b bVar) {
        super(context);
        e();
        setGuidePage(aVar);
        this.f46350a = bVar;
    }

    private void setGuidePage(com.app.hubert.guide.model.a aVar) {
        this.f46352c = aVar;
        setOnClickListener(new a());
    }

    public final void b(com.app.hubert.guide.model.a aVar) {
        removeAllViews();
        int iY = aVar.y();
        if (iY != 0) {
            View viewInflate = LayoutInflater.from(getContext()).inflate(iY, (ViewGroup) this, false);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            int[] iArrU = aVar.u();
            if (iArrU != null && iArrU.length > 0) {
                for (int i10 : iArrU) {
                    View viewFindViewById = viewInflate.findViewById(i10);
                    if (viewFindViewById != null) {
                        viewFindViewById.setOnClickListener(new b());
                    } else {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("can't find the view by id : ");
                        sb2.append(i10);
                        sb2.append(" which used to remove guide page");
                    }
                }
            }
            r3.d dVarZ = aVar.z();
            if (dVarZ != null) {
                dVarZ.a(viewInflate, this.f46350a);
            }
            addView(viewInflate, layoutParams);
        }
        List<s3.a> listA = aVar.A();
        if (listA.size() > 0) {
            Iterator<s3.a> it2 = listA.iterator();
            while (it2.hasNext()) {
                addView(it2.next().a((ViewGroup) getParent(), this.f46350a));
            }
        }
    }

    public final void c() {
        if (getParent() != null) {
            ((ViewGroup) getParent()).removeView(this);
            e eVar = this.f46353d;
            if (eVar != null) {
                eVar.a(this);
            }
        }
    }

    public final void d(Canvas canvas) {
        List<HighLight> listX = this.f46352c.x();
        if (listX != null) {
            for (HighLight highLight : listX) {
                RectF rectFC = highLight.c((ViewGroup) getParent());
                int i10 = d.f46360a[highLight.e().ordinal()];
                if (i10 == 1) {
                    canvas.drawCircle(rectFC.centerX(), rectFC.centerY(), highLight.b(), this.f46351b);
                } else if (i10 == 2) {
                    canvas.drawOval(rectFC, this.f46351b);
                } else if (i10 != 3) {
                    canvas.drawRect(rectFC, this.f46351b);
                } else {
                    canvas.drawRoundRect(rectFC, highLight.f(), highLight.f(), this.f46351b);
                }
                g(canvas, highLight, rectFC);
            }
        }
    }

    public final void e() {
        Paint paint = new Paint();
        this.f46351b = paint;
        paint.setAntiAlias(true);
        this.f46351b.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.f46351b.setMaskFilter(new BlurMaskFilter(10.0f, BlurMaskFilter.Blur.INNER));
        setLayerType(1, null);
        setWillNotDraw(false);
        this.f46356g = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    public final void f(HighLight highLight) {
        View.OnClickListener onClickListener;
        com.app.hubert.guide.model.b bVarD = highLight.d();
        if (bVarD == null || (onClickListener = bVarD.f11419a) == null) {
            return;
        }
        onClickListener.onClick(this);
    }

    public final void g(Canvas canvas, HighLight highLight, RectF rectF) {
        r3.c cVar;
        com.app.hubert.guide.model.b bVarD = highLight.d();
        if (bVarD == null || (cVar = bVarD.f11421c) == null) {
            return;
        }
        cVar.a(canvas, rectF);
    }

    public void h() {
        Animation animationW = this.f46352c.w();
        if (animationW == null) {
            c();
        } else {
            animationW.setAnimationListener(new C0522c());
            startAnimation(animationW);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        b(this.f46352c);
        Animation animationV = this.f46352c.v();
        if (animationV != null) {
            startAnimation(animationV);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int iT = this.f46352c.t();
        if (iT == 0) {
            iT = f46349h;
        }
        canvas.drawColor(iT);
        d(canvas);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f46354e = motionEvent.getX();
            this.f46355f = motionEvent.getY();
        } else if (action == 1 || action == 3) {
            float x10 = motionEvent.getX();
            float y10 = motionEvent.getY();
            if (Math.abs(x10 - this.f46354e) < this.f46356g && Math.abs(y10 - this.f46355f) < this.f46356g) {
                for (HighLight highLight : this.f46352c.x()) {
                    if (highLight.c((ViewGroup) getParent()).contains(x10, y10)) {
                        f(highLight);
                        return true;
                    }
                }
                performClick();
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean performClick() {
        return super.performClick();
    }

    public void setOnGuideLayoutDismissListener(e eVar) {
        this.f46353d = eVar;
    }

    public c(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public c(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }
}
