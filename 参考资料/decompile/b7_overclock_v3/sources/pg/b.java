package pg;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import com.scwang.smartrefresh.layout.R;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import g.l;
import g.n0;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import mg.g;
import mg.i;
import mg.j;
import rg.e;

/* JADX INFO: loaded from: classes5.dex */
public class b extends rg.c<b> implements g {
    public String A;
    public String B;
    public String C;
    public String D;
    public String K0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public String f46638k0;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public String f46639k1;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f46640t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Date f46641u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public TextView f46642v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public SharedPreferences f46643w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public DateFormat f46644x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f46645y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f46646z;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public static final int f46636v1 = R.id.srl_classics_update;
    public static String C1 = null;
    public static String K1 = null;

    /* JADX INFO: renamed from: v2, reason: collision with root package name */
    public static String f46637v2 = null;
    public static String C2 = null;
    public static String K2 = null;
    public static String E7 = null;
    public static String F7 = null;
    public static String G7 = null;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f46647a;

        static {
            int[] iArr = new int[RefreshState.values().length];
            f46647a = iArr;
            try {
                iArr[RefreshState.None.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f46647a[RefreshState.PullDownToRefresh.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f46647a[RefreshState.Refreshing.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f46647a[RefreshState.RefreshReleased.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f46647a[RefreshState.ReleaseToRefresh.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f46647a[RefreshState.ReleaseToTwoLevel.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f46647a[RefreshState.Loading.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public b(Context context) {
        this(context, null);
    }

    @Override // rg.c
    /* JADX INFO: renamed from: H, reason: merged with bridge method [inline-methods] */
    public b o(@l int i10) {
        this.f46642v.setTextColor((16777215 & i10) | (-872415232));
        return (b) super.o(i10);
    }

    public b I(boolean z10) {
        TextView textView = this.f46642v;
        this.f46645y = z10;
        textView.setVisibility(z10 ? 0 : 8);
        i iVar = this.f48763g;
        if (iVar != null) {
            iVar.c(this);
        }
        return this;
    }

    public b J(CharSequence charSequence) {
        this.f46641u = null;
        this.f46642v.setText(charSequence);
        return this;
    }

    public b K(Date date) {
        this.f46641u = date;
        this.f46642v.setText(this.f46644x.format(date));
        if (this.f46643w != null && !isInEditMode()) {
            this.f46643w.edit().putLong(this.f46640t, date.getTime()).apply();
        }
        return this;
    }

    public b L(float f10) {
        this.f46642v.setTextSize(f10);
        i iVar = this.f48763g;
        if (iVar != null) {
            iVar.c(this);
        }
        return this;
    }

    public b M(float f10) {
        TextView textView = this.f46642v;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) textView.getLayoutParams();
        marginLayoutParams.topMargin = tg.b.d(f10);
        textView.setLayoutParams(marginLayoutParams);
        return this;
    }

    public b N(DateFormat dateFormat) {
        this.f46644x = dateFormat;
        Date date = this.f46641u;
        if (date != null) {
            this.f46642v.setText(dateFormat.format(date));
        }
        return this;
    }

    @Override // rg.b, sg.f
    public void h(@n0 j jVar, @n0 RefreshState refreshState, @n0 RefreshState refreshState2) {
        ImageView imageView = this.f48761e;
        TextView textView = this.f46642v;
        switch (a.f46647a[refreshState2.ordinal()]) {
            case 1:
                textView.setVisibility(this.f46645y ? 0 : 8);
                break;
            case 2:
                break;
            case 3:
            case 4:
                this.f48760d.setText(this.A);
                imageView.setVisibility(8);
                return;
            case 5:
                this.f48760d.setText(this.C);
                imageView.animate().rotation(180.0f);
                return;
            case 6:
                this.f48760d.setText(this.f46639k1);
                imageView.animate().rotation(0.0f);
                return;
            case 7:
                imageView.setVisibility(8);
                textView.setVisibility(this.f46645y ? 4 : 8);
                this.f48760d.setText(this.B);
                return;
            default:
                return;
        }
        this.f48760d.setText(this.f46646z);
        imageView.setVisibility(0);
        imageView.animate().rotation(0.0f);
    }

    @Override // rg.c, rg.b, mg.h
    public int l(@n0 j jVar, boolean z10) {
        if (z10) {
            this.f48760d.setText(this.D);
            if (this.f46641u != null) {
                K(new Date());
            }
        } else {
            this.f48760d.setText(this.f46638k0);
        }
        return super.l(jVar, z10);
    }

    public b(Context context, AttributeSet attributeSet) {
        FragmentManager fragmentManagerN3;
        super(context, attributeSet, 0);
        this.f46640t = "LAST_UPDATE_TIME";
        this.f46645y = true;
        View.inflate(context, R.layout.srl_classics_header, this);
        ImageView imageView = (ImageView) findViewById(R.id.srl_classics_arrow);
        this.f48761e = imageView;
        TextView textView = (TextView) findViewById(R.id.srl_classics_update);
        this.f46642v = textView;
        ImageView imageView2 = (ImageView) findViewById(R.id.srl_classics_progress);
        this.f48762f = imageView2;
        this.f48760d = (TextView) findViewById(R.id.srl_classics_title);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ClassicsHeader);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) imageView2.getLayoutParams();
        new LinearLayout.LayoutParams(-2, -2).topMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.ClassicsHeader_srlTextTimeMarginTop, tg.b.d(0.0f));
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.ClassicsFooter_srlDrawableMarginRight, tg.b.d(20.0f));
        layoutParams2.rightMargin = dimensionPixelSize;
        layoutParams.rightMargin = dimensionPixelSize;
        int i10 = R.styleable.ClassicsHeader_srlDrawableArrowSize;
        layoutParams.width = typedArrayObtainStyledAttributes.getLayoutDimension(i10, layoutParams.width);
        layoutParams.height = typedArrayObtainStyledAttributes.getLayoutDimension(i10, layoutParams.height);
        int i11 = R.styleable.ClassicsHeader_srlDrawableProgressSize;
        layoutParams2.width = typedArrayObtainStyledAttributes.getLayoutDimension(i11, layoutParams2.width);
        layoutParams2.height = typedArrayObtainStyledAttributes.getLayoutDimension(i11, layoutParams2.height);
        int i12 = R.styleable.ClassicsHeader_srlDrawableSize;
        layoutParams.width = typedArrayObtainStyledAttributes.getLayoutDimension(i12, layoutParams.width);
        layoutParams.height = typedArrayObtainStyledAttributes.getLayoutDimension(i12, layoutParams.height);
        layoutParams2.width = typedArrayObtainStyledAttributes.getLayoutDimension(i12, layoutParams2.width);
        layoutParams2.height = typedArrayObtainStyledAttributes.getLayoutDimension(i12, layoutParams2.height);
        this.f48769m = typedArrayObtainStyledAttributes.getInt(R.styleable.ClassicsHeader_srlFinishDuration, this.f48769m);
        this.f46645y = typedArrayObtainStyledAttributes.getBoolean(R.styleable.ClassicsHeader_srlEnableLastTime, this.f46645y);
        this.f48755b = ng.b.f42148i[typedArrayObtainStyledAttributes.getInt(R.styleable.ClassicsHeader_srlClassicsSpinnerStyle, this.f48755b.f42149a)];
        int i13 = R.styleable.ClassicsHeader_srlDrawableArrow;
        if (typedArrayObtainStyledAttributes.hasValue(i13)) {
            this.f48761e.setImageDrawable(typedArrayObtainStyledAttributes.getDrawable(i13));
        } else if (this.f48761e.getDrawable() == null) {
            rg.a aVar = new rg.a();
            this.f48764h = aVar;
            aVar.a(-10066330);
            this.f48761e.setImageDrawable(this.f48764h);
        }
        int i14 = R.styleable.ClassicsHeader_srlDrawableProgress;
        if (typedArrayObtainStyledAttributes.hasValue(i14)) {
            this.f48762f.setImageDrawable(typedArrayObtainStyledAttributes.getDrawable(i14));
        } else if (this.f48762f.getDrawable() == null) {
            e eVar = new e();
            this.f48765i = eVar;
            eVar.a(-10066330);
            this.f48762f.setImageDrawable(this.f48765i);
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.ClassicsHeader_srlTextSizeTitle)) {
            this.f48760d.setTextSize(0, typedArrayObtainStyledAttributes.getDimensionPixelSize(r4, tg.b.d(16.0f)));
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.ClassicsHeader_srlTextSizeTime)) {
            this.f46642v.setTextSize(0, typedArrayObtainStyledAttributes.getDimensionPixelSize(r4, tg.b.d(12.0f)));
        }
        int i15 = R.styleable.ClassicsHeader_srlPrimaryColor;
        if (typedArrayObtainStyledAttributes.hasValue(i15)) {
            super.B(typedArrayObtainStyledAttributes.getColor(i15, 0));
        }
        int i16 = R.styleable.ClassicsHeader_srlAccentColor;
        if (typedArrayObtainStyledAttributes.hasValue(i16)) {
            o(typedArrayObtainStyledAttributes.getColor(i16, 0));
        }
        int i17 = R.styleable.ClassicsHeader_srlTextPulling;
        if (typedArrayObtainStyledAttributes.hasValue(i17)) {
            this.f46646z = typedArrayObtainStyledAttributes.getString(i17);
        } else {
            String str = C1;
            if (str != null) {
                this.f46646z = str;
            } else {
                this.f46646z = context.getString(R.string.srl_header_pulling);
            }
        }
        int i18 = R.styleable.ClassicsHeader_srlTextLoading;
        if (typedArrayObtainStyledAttributes.hasValue(i18)) {
            this.B = typedArrayObtainStyledAttributes.getString(i18);
        } else {
            String str2 = f46637v2;
            if (str2 != null) {
                this.B = str2;
            } else {
                this.B = context.getString(R.string.srl_header_loading);
            }
        }
        int i19 = R.styleable.ClassicsHeader_srlTextRelease;
        if (typedArrayObtainStyledAttributes.hasValue(i19)) {
            this.C = typedArrayObtainStyledAttributes.getString(i19);
        } else {
            String str3 = C2;
            if (str3 != null) {
                this.C = str3;
            } else {
                this.C = context.getString(R.string.srl_header_release);
            }
        }
        int i20 = R.styleable.ClassicsHeader_srlTextFinish;
        if (typedArrayObtainStyledAttributes.hasValue(i20)) {
            this.D = typedArrayObtainStyledAttributes.getString(i20);
        } else {
            String str4 = K2;
            if (str4 != null) {
                this.D = str4;
            } else {
                this.D = context.getString(R.string.srl_header_finish);
            }
        }
        int i21 = R.styleable.ClassicsHeader_srlTextFailed;
        if (typedArrayObtainStyledAttributes.hasValue(i21)) {
            this.f46638k0 = typedArrayObtainStyledAttributes.getString(i21);
        } else {
            String str5 = E7;
            if (str5 != null) {
                this.f46638k0 = str5;
            } else {
                this.f46638k0 = context.getString(R.string.srl_header_failed);
            }
        }
        int i22 = R.styleable.ClassicsHeader_srlTextSecondary;
        if (typedArrayObtainStyledAttributes.hasValue(i22)) {
            this.f46639k1 = typedArrayObtainStyledAttributes.getString(i22);
        } else {
            String str6 = G7;
            if (str6 != null) {
                this.f46639k1 = str6;
            } else {
                this.f46639k1 = context.getString(R.string.srl_header_secondary);
            }
        }
        int i23 = R.styleable.ClassicsHeader_srlTextRefreshing;
        if (typedArrayObtainStyledAttributes.hasValue(i23)) {
            this.A = typedArrayObtainStyledAttributes.getString(i23);
        } else {
            String str7 = K1;
            if (str7 != null) {
                this.A = str7;
            } else {
                this.A = context.getString(R.string.srl_header_refreshing);
            }
        }
        int i24 = R.styleable.ClassicsHeader_srlTextUpdate;
        if (typedArrayObtainStyledAttributes.hasValue(i24)) {
            this.K0 = typedArrayObtainStyledAttributes.getString(i24);
        } else {
            String str8 = F7;
            if (str8 != null) {
                this.K0 = str8;
            } else {
                this.K0 = context.getString(R.string.srl_header_update);
            }
        }
        this.f46644x = new SimpleDateFormat(this.K0, Locale.getDefault());
        typedArrayObtainStyledAttributes.recycle();
        imageView2.animate().setInterpolator(null);
        textView.setVisibility(this.f46645y ? 0 : 8);
        this.f48760d.setText(isInEditMode() ? this.A : this.f46646z);
        if (isInEditMode()) {
            imageView.setVisibility(8);
        } else {
            imageView2.setVisibility(8);
        }
        try {
            if ((context instanceof androidx.fragment.app.g) && (fragmentManagerN3 = ((androidx.fragment.app.g) context).n3()) != null && fragmentManagerN3.I0().size() > 0) {
                K(new Date());
                return;
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        this.f46640t += context.getClass().getName();
        this.f46643w = context.getSharedPreferences("ClassicsHeader", 0);
        K(new Date(this.f46643w.getLong(this.f46640t, System.currentTimeMillis())));
    }
}
