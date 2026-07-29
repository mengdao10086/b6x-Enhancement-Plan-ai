package t7;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.flydigi.device_manager.R;
import g.n0;

/* JADX INFO: loaded from: classes7.dex */
public class c extends androidx.appcompat.app.e {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public EditText f50897i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f50898j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f50899k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f50900l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public a f50901m;

    public interface a {
        void a(String str, androidx.appcompat.app.j jVar);
    }

    public c(@n0 Context context, String str, String str2) {
        this(context, str, str2, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D(View view) {
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E(View view) {
        a aVar = this.f50901m;
        if (aVar != null) {
            aVar.a(this.f50897i.getText().toString(), C());
        }
    }

    public final androidx.appcompat.app.j C() {
        return this;
    }

    public void F(a aVar) {
        this.f50901m = aVar;
    }

    @Override // androidx.appcompat.app.e, androidx.appcompat.app.j, androidx.activity.j, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.device_dialog_edittext);
        if (getWindow() != null) {
            getWindow().setBackgroundDrawable(new ColorDrawable(getContext().getResources().getColor(R.color.color_black_trans)));
        }
        TextView textView = (TextView) findViewById(R.id.tv_title);
        this.f50897i = (EditText) findViewById(R.id.et_rename);
        TextView textView2 = (TextView) findViewById(R.id.tv_cancel);
        TextView textView3 = (TextView) findViewById(R.id.tv_confirm);
        textView2.setOnClickListener(new View.OnClickListener() { // from class: t7.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f50895a.D(view);
            }
        });
        textView3.setOnClickListener(new View.OnClickListener() { // from class: t7.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f50896a.E(view);
            }
        });
        this.f50897i.setHint(this.f50900l);
        textView.setText(this.f50898j);
        this.f50897i.setText(this.f50899k);
        getWindow().clearFlags(131072);
        getWindow().setSoftInputMode(5);
    }

    public c(@n0 Context context, String str, String str2, String str3) {
        super(context);
        this.f50898j = str;
        this.f50899k = str2;
        this.f50900l = str3;
    }
}
