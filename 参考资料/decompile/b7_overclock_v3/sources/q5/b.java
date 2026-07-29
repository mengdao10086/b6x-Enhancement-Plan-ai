package q5;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blankj.utilcode.util.o;
import com.blankj.utilcode.util.t;
import com.flydigi.base.R;
import g.i0;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b extends ConstraintLayout {
    public ImageView C1;
    public TextView K1;

    /* JADX INFO: renamed from: v2, reason: collision with root package name */
    public TextView f47119v2;

    public b(Context context) {
        this(context, null);
    }

    public void N(Context context, AttributeSet attributeSet) {
        this.C1 = (ImageView) findViewById(R.id.iv_icon);
        this.K1 = (TextView) findViewById(R.id.tv_title);
        this.f47119v2 = (TextView) findViewById(R.id.tv_desc);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ActionItemView);
        if (typedArrayObtainStyledAttributes != null) {
            int resourceId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.ActionItemView_aiv_icon, -1);
            String string = typedArrayObtainStyledAttributes.getString(R.styleable.ActionItemView_aiv_title);
            String string2 = typedArrayObtainStyledAttributes.getString(R.styleable.ActionItemView_aiv_desc);
            ImageView imageView = this.C1;
            if (imageView != null) {
                if (resourceId != -1) {
                    imageView.setVisibility(0);
                    this.C1.setImageResource(resourceId);
                } else {
                    imageView.setVisibility(8);
                }
            }
            if (!TextUtils.isEmpty(string)) {
                this.K1.setText(string);
            }
            if (this.f47119v2 != null) {
                if (TextUtils.isEmpty(string2)) {
                    this.f47119v2.setVisibility(8);
                } else {
                    this.f47119v2.setVisibility(0);
                    this.f47119v2.setText(string2);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public void O(String str, boolean z10) {
        this.f47119v2.setText(str);
        this.f47119v2.setVisibility(TextUtils.isEmpty(str) ? 8 : 0);
        if (z10) {
            this.f47119v2.setTextColor(t.a(R.color.colorAccentRed));
        } else {
            this.f47119v2.setTextColor(t.a(R.color.color_000000_a50));
        }
    }

    public void P(Drawable drawable, View.OnClickListener onClickListener) {
        ImageView imageView = (ImageView) findViewById(R.id.iv_title);
        imageView.setImageDrawable(drawable);
        imageView.setVisibility(0);
        o.r(imageView, onClickListener);
    }

    @i0
    public abstract int getLayoutId();

    public String getTitle() {
        return this.K1.getText().toString();
    }

    public void setDesc(String str) {
        O(str, false);
    }

    public void setTitle(String str) {
        this.K1.setText(str);
    }

    public b(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public b(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        LayoutInflater.from(context).inflate(getLayoutId(), (ViewGroup) this, true);
        N(context, attributeSet);
    }
}
