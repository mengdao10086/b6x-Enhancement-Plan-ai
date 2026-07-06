package a;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.omarea.ui.fps.ThreadCPUView;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class b51 extends RecyclerView.g<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f5675a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final fy0 f232a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Context f233a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final StyleSpan f234a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public List<jn0> f235a;
    public final List<jn0> b;

    public final class a extends RecyclerView.d0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public TextView f5676a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public ThreadCPUView f236a;
        public TextView b;
        public TextView c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(b51 b51Var, View view) {
            super(view);
            f92.d(view, "view");
        }

        public final TextView M() {
            TextView textView = this.c;
            if (textView != null) {
                return textView;
            }
            f92.m("threadDuration");
            throw null;
        }

        public final TextView N() {
            TextView textView = this.b;
            if (textView != null) {
                return textView;
            }
            f92.m("threadID");
            throw null;
        }

        public final TextView O() {
            TextView textView = this.f5676a;
            if (textView != null) {
                return textView;
            }
            f92.m("threadName");
            throw null;
        }

        public final ThreadCPUView P() {
            ThreadCPUView threadCPUView = this.f236a;
            if (threadCPUView != null) {
                return threadCPUView;
            }
            f92.m("threadTime");
            throw null;
        }

        public final void Q(TextView textView) {
            f92.d(textView, "<set-?>");
            this.c = textView;
        }

        public final void R(TextView textView) {
            f92.d(textView, "<set-?>");
            this.b = textView;
        }

        public final void S(TextView textView) {
            f92.d(textView, "<set-?>");
            this.f5676a = textView;
        }

        public final void T(ThreadCPUView threadCPUView) {
            f92.d(threadCPUView, "<set-?>");
            this.f236a = threadCPUView;
        }
    }

    public b51(Context context, long j, List<jn0> list, fy0 fy0Var) {
        f92.d(context, "context");
        f92.d(list, "data");
        f92.d(fy0Var, "timeRange");
        this.f233a = context;
        this.f5675a = j;
        this.b = list;
        this.f232a = fy0Var;
        this.f235a = i52.S(list, new a51());
        this.f234a = new StyleSpan(1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int e() {
        return this.f235a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public long f(int i) {
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public void n(a aVar, int i) {
        CharSequence charSequenceA;
        f92.d(aVar, "holder");
        jn0 jn0Var = this.f235a.get(i);
        aVar.N().setText(String.valueOf(jn0Var.f()));
        TextView textViewM = aVar.M();
        q92 q92Var = q92.f7191a;
        String str = String.format("AVG:%.1f%% MAX:%.1f%%", Arrays.copyOf(new Object[]{Double.valueOf(jn0Var.c()), Double.valueOf(jn0Var.d())}, 2));
        f92.c(str, "java.lang.String.format(format, *args)");
        textViewM.setText(str);
        aVar.P().i(this.f5675a, jn0Var, this.f232a);
        TextView textViewO = aVar.O();
        if (jn0Var.b() > (this.f232a.b() - this.f232a.a()) / ((long) 2)) {
            SpannableString spannableString = new SpannableString(jn0Var.a());
            spannableString.setSpan(this.f234a, 0, jn0Var.a().length(), 33);
            m42 m42Var = m42.f6769a;
            charSequenceA = spannableString;
        } else {
            charSequenceA = jn0Var.a();
        }
        textViewO.setText(charSequenceA);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public a p(ViewGroup viewGroup, int i) {
        f92.d(viewGroup, "parent");
        View viewInflate = LayoutInflater.from(this.f233a).inflate(2131558641, (ViewGroup) null);
        f92.c(viewInflate, "convertView");
        a aVar = new a(this, viewInflate);
        View viewFindViewById = viewInflate.findViewById(t61.threadID);
        f92.c(viewFindViewById, "convertView.findViewById(R.id.threadID)");
        aVar.R((TextView) viewFindViewById);
        View viewFindViewById2 = viewInflate.findViewById(t61.threadName);
        f92.c(viewFindViewById2, "convertView.findViewById(R.id.threadName)");
        aVar.S((TextView) viewFindViewById2);
        View viewFindViewById3 = viewInflate.findViewById(t61.threadDuration);
        f92.c(viewFindViewById3, "convertView.findViewById(R.id.threadDuration)");
        aVar.Q((TextView) viewFindViewById3);
        View viewFindViewById4 = viewInflate.findViewById(t61.threadTime);
        f92.c(viewFindViewById4, "convertView.findViewById(R.id.threadTime)");
        aVar.T((ThreadCPUView) viewFindViewById4);
        aVar.O().setOnLongClickListener(new c51(aVar, this, viewInflate));
        return aVar;
    }
}
