package og;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.scwang.smartrefresh.layout.R;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import g.l;
import g.n0;
import mg.f;
import mg.j;
import rg.e;

/* JADX INFO: loaded from: classes5.dex */
public class b extends rg.c<b> implements f {
    public static String B;
    public static String C;
    public static String D;
    public static String K0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static String f43332k0;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public static String f43333k1;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public static String f43334v1;
    public boolean A;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f43335t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f43336u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f43337v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public String f43338w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f43339x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f43340y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f43341z;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f43342a;

        static {
            int[] iArr = new int[RefreshState.values().length];
            f43342a = iArr;
            try {
                iArr[RefreshState.None.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f43342a[RefreshState.PullUpToLoad.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f43342a[RefreshState.Loading.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f43342a[RefreshState.LoadReleased.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f43342a[RefreshState.ReleaseToLoad.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f43342a[RefreshState.Refreshing.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public b(Context context) {
        this(context, null);
    }

    @Override // rg.b, mg.f
    public boolean a(boolean z10) {
        if (this.A == z10) {
            return true;
        }
        this.A = z10;
        ImageView imageView = this.f48761e;
        if (z10) {
            this.f48760d.setText(this.f43341z);
            imageView.setVisibility(8);
            return true;
        }
        this.f48760d.setText(this.f43335t);
        imageView.setVisibility(0);
        return true;
    }

    @Override // rg.b, sg.f
    public void h(@n0 j jVar, @n0 RefreshState refreshState, @n0 RefreshState refreshState2) {
        ImageView imageView = this.f48761e;
        if (this.A) {
            return;
        }
        switch (a.f43342a[refreshState2.ordinal()]) {
            case 1:
                imageView.setVisibility(0);
                break;
            case 2:
                break;
            case 3:
            case 4:
                imageView.setVisibility(8);
                this.f48760d.setText(this.f43337v);
                return;
            case 5:
                this.f48760d.setText(this.f43336u);
                imageView.animate().rotation(0.0f);
                return;
            case 6:
                this.f48760d.setText(this.f43338w);
                imageView.setVisibility(8);
                return;
            default:
                return;
        }
        this.f48760d.setText(this.f43335t);
        imageView.animate().rotation(180.0f);
    }

    @Override // rg.c, rg.b, mg.h
    public int l(@n0 j jVar, boolean z10) {
        super.l(jVar, z10);
        if (this.A) {
            return 0;
        }
        this.f48760d.setText(z10 ? this.f43339x : this.f43340y);
        return this.f48769m;
    }

    @Override // rg.c, rg.b, mg.h
    @Deprecated
    public void setPrimaryColors(@l int... iArr) {
        if (this.f48755b == ng.b.f42145f) {
            super.setPrimaryColors(iArr);
        }
    }

    public b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.A = false;
        View.inflate(context, R.layout.srl_classics_footer, this);
        ImageView imageView = (ImageView) findViewById(R.id.srl_classics_arrow);
        this.f48761e = imageView;
        ImageView imageView2 = (ImageView) findViewById(R.id.srl_classics_progress);
        this.f48762f = imageView2;
        this.f48760d = (TextView) findViewById(R.id.srl_classics_title);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ClassicsFooter);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) imageView2.getLayoutParams();
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.ClassicsFooter_srlDrawableMarginRight, tg.b.d(20.0f));
        layoutParams2.rightMargin = dimensionPixelSize;
        layoutParams.rightMargin = dimensionPixelSize;
        int i10 = R.styleable.ClassicsFooter_srlDrawableArrowSize;
        layoutParams.width = typedArrayObtainStyledAttributes.getLayoutDimension(i10, layoutParams.width);
        layoutParams.height = typedArrayObtainStyledAttributes.getLayoutDimension(i10, layoutParams.height);
        int i11 = R.styleable.ClassicsFooter_srlDrawableProgressSize;
        layoutParams2.width = typedArrayObtainStyledAttributes.getLayoutDimension(i11, layoutParams2.width);
        layoutParams2.height = typedArrayObtainStyledAttributes.getLayoutDimension(i11, layoutParams2.height);
        int i12 = R.styleable.ClassicsFooter_srlDrawableSize;
        layoutParams.width = typedArrayObtainStyledAttributes.getLayoutDimension(i12, layoutParams.width);
        layoutParams.height = typedArrayObtainStyledAttributes.getLayoutDimension(i12, layoutParams.height);
        layoutParams2.width = typedArrayObtainStyledAttributes.getLayoutDimension(i12, layoutParams2.width);
        layoutParams2.height = typedArrayObtainStyledAttributes.getLayoutDimension(i12, layoutParams2.height);
        this.f48769m = typedArrayObtainStyledAttributes.getInt(R.styleable.ClassicsFooter_srlFinishDuration, this.f48769m);
        this.f48755b = ng.b.f42148i[typedArrayObtainStyledAttributes.getInt(R.styleable.ClassicsFooter_srlClassicsSpinnerStyle, this.f48755b.f42149a)];
        int i13 = R.styleable.ClassicsFooter_srlDrawableArrow;
        if (typedArrayObtainStyledAttributes.hasValue(i13)) {
            this.f48761e.setImageDrawable(typedArrayObtainStyledAttributes.getDrawable(i13));
        } else if (this.f48761e.getDrawable() == null) {
            rg.a aVar = new rg.a();
            this.f48764h = aVar;
            aVar.a(-10066330);
            this.f48761e.setImageDrawable(this.f48764h);
        }
        int i14 = R.styleable.ClassicsFooter_srlDrawableProgress;
        if (typedArrayObtainStyledAttributes.hasValue(i14)) {
            this.f48762f.setImageDrawable(typedArrayObtainStyledAttributes.getDrawable(i14));
        } else if (this.f48762f.getDrawable() == null) {
            e eVar = new e();
            this.f48765i = eVar;
            eVar.a(-10066330);
            this.f48762f.setImageDrawable(this.f48765i);
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.ClassicsFooter_srlTextSizeTitle)) {
            this.f48760d.setTextSize(0, typedArrayObtainStyledAttributes.getDimensionPixelSize(r3, tg.b.d(16.0f)));
        }
        int i15 = R.styleable.ClassicsFooter_srlPrimaryColor;
        if (typedArrayObtainStyledAttributes.hasValue(i15)) {
            super.B(typedArrayObtainStyledAttributes.getColor(i15, 0));
        }
        int i16 = R.styleable.ClassicsFooter_srlAccentColor;
        if (typedArrayObtainStyledAttributes.hasValue(i16)) {
            super.o(typedArrayObtainStyledAttributes.getColor(i16, 0));
        }
        int i17 = R.styleable.ClassicsFooter_srlTextPulling;
        if (typedArrayObtainStyledAttributes.hasValue(i17)) {
            this.f43335t = typedArrayObtainStyledAttributes.getString(i17);
        } else {
            String str = B;
            if (str != null) {
                this.f43335t = str;
            } else {
                this.f43335t = context.getString(R.string.srl_footer_pulling);
            }
        }
        int i18 = R.styleable.ClassicsFooter_srlTextRelease;
        if (typedArrayObtainStyledAttributes.hasValue(i18)) {
            this.f43336u = typedArrayObtainStyledAttributes.getString(i18);
        } else {
            String str2 = C;
            if (str2 != null) {
                this.f43336u = str2;
            } else {
                this.f43336u = context.getString(R.string.srl_footer_release);
            }
        }
        int i19 = R.styleable.ClassicsFooter_srlTextLoading;
        if (typedArrayObtainStyledAttributes.hasValue(i19)) {
            this.f43337v = typedArrayObtainStyledAttributes.getString(i19);
        } else {
            String str3 = D;
            if (str3 != null) {
                this.f43337v = str3;
            } else {
                this.f43337v = context.getString(R.string.srl_footer_loading);
            }
        }
        int i20 = R.styleable.ClassicsFooter_srlTextRefreshing;
        if (typedArrayObtainStyledAttributes.hasValue(i20)) {
            this.f43338w = typedArrayObtainStyledAttributes.getString(i20);
        } else {
            String str4 = f43332k0;
            if (str4 != null) {
                this.f43338w = str4;
            } else {
                this.f43338w = context.getString(R.string.srl_footer_refreshing);
            }
        }
        int i21 = R.styleable.ClassicsFooter_srlTextFinish;
        if (typedArrayObtainStyledAttributes.hasValue(i21)) {
            this.f43339x = typedArrayObtainStyledAttributes.getString(i21);
        } else {
            String str5 = K0;
            if (str5 != null) {
                this.f43339x = str5;
            } else {
                this.f43339x = context.getString(R.string.srl_footer_finish);
            }
        }
        int i22 = R.styleable.ClassicsFooter_srlTextFailed;
        if (typedArrayObtainStyledAttributes.hasValue(i22)) {
            this.f43340y = typedArrayObtainStyledAttributes.getString(i22);
        } else {
            String str6 = f43333k1;
            if (str6 != null) {
                this.f43340y = str6;
            } else {
                this.f43340y = context.getString(R.string.srl_footer_failed);
            }
        }
        int i23 = R.styleable.ClassicsFooter_srlTextNothing;
        if (typedArrayObtainStyledAttributes.hasValue(i23)) {
            this.f43341z = typedArrayObtainStyledAttributes.getString(i23);
        } else {
            String str7 = f43334v1;
            if (str7 != null) {
                this.f43341z = str7;
            } else {
                this.f43341z = context.getString(R.string.srl_footer_nothing);
            }
        }
        typedArrayObtainStyledAttributes.recycle();
        imageView2.animate().setInterpolator(null);
        this.f48760d.setText(isInEditMode() ? this.f43337v : this.f43335t);
        if (isInEditMode()) {
            imageView.setVisibility(8);
        } else {
            imageView2.setVisibility(8);
        }
    }
}
