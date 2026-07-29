package z7;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import com.blankj.utilcode.util.KeyboardUtils;
import com.flydigi.float_view.R;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes7.dex */
public class p extends y7.b {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final c f57870p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final String f57871q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final String f57872r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final String f57873s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final String f57874t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final String f57875u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public View f57876v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public EditText f57877w;

    public class a extends p5.t {
        public a() {
        }

        @Override // p5.t, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            super.afterTextChanged(editable);
            p.this.f57876v.setVisibility(p.this.f57877w.getText().length() > 0 ? 0 : 8);
        }
    }

    public class b implements InputFilter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Pattern f57879a = Pattern.compile("[^a-zA-Z0-9\\u4E00-\\u9FA5_]");

        public b() {
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i10, int i11, Spanned spanned, int i12, int i13) {
            if (!this.f57879a.matcher(charSequence).find()) {
                return null;
            }
            n8.b.m(p.this.f56478a, p.this.f56478a.getString(R.string.floatview_err_input_text_format));
            return "";
        }
    }

    public interface c {
        void a(String str);

        void onCancel();
    }

    public p(Context context, String str, String str2, c cVar) {
        this(context, str, str2, "", "", "", cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J(View view) {
        this.f57877w.setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K(View view) {
        c cVar = this.f57870p;
        if (cVar != null) {
            cVar.onCancel();
        }
        h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L(View view) {
        c cVar = this.f57870p;
        if (cVar != null) {
            cVar.a(this.f57877w.getText().toString());
        }
    }

    public void I() {
        this.f57877w.getText().clear();
    }

    public void N(EditText editText) {
        editText.setFilters(new InputFilter[]{new b()});
    }

    @Override // y7.b
    public int i() {
        return R.layout.floatview_layout_dialog_edit;
    }

    @Override // y7.b
    public void n() {
        TextView textView = (TextView) this.f56479b.findViewById(R.id.tv_title);
        if (com.blankj.utilcode.util.n0.x(this.f57871q)) {
            textView.setText(this.f57871q);
            textView.setVisibility(0);
        } else {
            textView.setVisibility(8);
        }
        TextView textView2 = (TextView) this.f56479b.findViewById(R.id.tv_content);
        if (com.blankj.utilcode.util.n0.x(this.f57872r)) {
            textView2.setText(this.f57872r);
            textView2.setVisibility(0);
        } else {
            textView2.setVisibility(8);
        }
        EditText editText = (EditText) this.f56479b.findViewById(R.id.et_text);
        this.f57877w = editText;
        editText.addTextChangedListener(new a());
        View viewFindViewById = this.f56479b.findViewById(R.id.btn_clear);
        this.f57876v = viewFindViewById;
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: z7.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f57869a.J(view);
            }
        });
        if (com.blankj.utilcode.util.n0.x(this.f57875u)) {
            this.f57877w.setText(this.f57875u);
        }
        TextView textView3 = (TextView) this.f56479b.findViewById(R.id.tv_cancel);
        if (com.blankj.utilcode.util.n0.x(this.f57874t)) {
            textView3.setText(this.f57874t);
        }
        textView3.setOnClickListener(new View.OnClickListener() { // from class: z7.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f57866a.K(view);
            }
        });
        TextView textView4 = (TextView) this.f56479b.findViewById(R.id.tv_ok);
        if (com.blankj.utilcode.util.n0.x(this.f57873s)) {
            textView4.setText(this.f57873s);
        }
        textView4.setOnClickListener(new View.OnClickListener() { // from class: z7.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f57863a.L(view);
            }
        });
        y();
    }

    @Override // y7.b
    public WindowManager.LayoutParams p() {
        WindowManager.LayoutParams layoutParamsH = n8.b.h(1);
        layoutParamsH.gravity = 8388659;
        layoutParamsH.flags &= -9;
        return layoutParamsH;
    }

    @Override // y7.b
    public synchronized void y() {
        super.y();
        KeyboardUtils.s(this.f57877w);
    }

    public p(Context context, String str, String str2, String str3, c cVar) {
        this(context, str, str2, str3, "", "", cVar);
    }

    public p(Context context, String str, String str2, String str3, String str4, String str5, c cVar) {
        super(context);
        this.f57871q = str;
        this.f57872r = str2;
        this.f57873s = str4;
        this.f57874t = str5;
        this.f57875u = str3;
        this.f57870p = cVar;
    }
}
