package u5;

import android.text.Layout;
import android.text.Spannable;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.TextView;

/* JADX INFO: loaded from: classes2.dex */
public class a implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f51936a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RunnableC0599a f51937b;

    /* JADX INFO: renamed from: u5.a$a, reason: collision with other inner class name */
    public static class RunnableC0599a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f51938a;

        public RunnableC0599a(View view) {
            this.f51938a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            View view = this.f51938a;
            boolean zPerformLongClick = view.performLongClick();
            while (!zPerformLongClick) {
                view = (View) view.getParent();
                if (view == null) {
                    return;
                } else {
                    zPerformLongClick = view.performLongClick();
                }
            }
        }
    }

    public static class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f51939a;

        public b(View view) {
            this.f51939a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            View view = this.f51939a;
            for (boolean zPerformClick = view.performClick(); !zPerformClick; zPerformClick = view.performClick()) {
                if (view.getParent() instanceof View) {
                    view = (View) view.getParent();
                }
                if (view == null) {
                    return;
                }
            }
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.f51937b == null) {
            this.f51937b = new RunnableC0599a(view);
        }
        if (this.f51936a == null) {
            this.f51936a = new b(view);
        }
        TextView textView = (TextView) view;
        textView.setMovementMethod(null);
        Spannable spannableNewSpannable = Spannable.Factory.getInstance().newSpannable(textView.getText());
        int action = motionEvent.getAction();
        if (action != 0 && action != 1) {
            if (action == 3) {
                view.removeCallbacks(this.f51937b);
                view.removeCallbacks(this.f51936a);
            }
            return false;
        }
        int x10 = (int) motionEvent.getX();
        int y10 = (int) motionEvent.getY();
        int totalPaddingLeft = x10 - textView.getTotalPaddingLeft();
        int totalPaddingTop = y10 - textView.getTotalPaddingTop();
        int scrollX = totalPaddingLeft + textView.getScrollX();
        int scrollY = totalPaddingTop + textView.getScrollY();
        Layout layout = textView.getLayout();
        int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(scrollY), scrollX);
        ClickableSpan[] clickableSpanArr = (ClickableSpan[]) spannableNewSpannable.getSpans(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class);
        if (clickableSpanArr.length == 0) {
            view.postDelayed(this.f51936a, ViewConfiguration.getJumpTapTimeout());
        } else if (action == 0) {
            view.postDelayed(this.f51937b, ViewConfiguration.getLongPressTimeout());
            view.postDelayed(this.f51936a, ViewConfiguration.getJumpTapTimeout());
        } else {
            view.removeCallbacks(this.f51936a);
            view.removeCallbacks(this.f51937b);
            clickableSpanArr[0].onClick(textView);
        }
        return true;
    }
}
