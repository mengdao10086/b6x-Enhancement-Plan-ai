package com.omarea.krscript.model;

import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class ShellHandlerBase extends Handler {
    public static final int EVENT_EXIT = -2;
    public static final int EVENT_READ_ERROR = 4;
    public static final int EVENT_REDE = 2;
    public static final int EVENT_START = 0;
    public static final int EVENT_WRITE = 6;

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        int i = message.what;
        if (i == -2) {
            onExit(message.obj);
            return;
        }
        if (i == 0) {
            onStart(message.obj);
            return;
        }
        if (i == 2) {
            onReaderMsg(message.obj);
        } else if (i == 4) {
            onError(message.obj);
        } else {
            if (i != 6) {
                return;
            }
            onWrite(message.obj);
        }
    }

    public void onError(Object obj) {
        updateLog(obj, "#ff0000");
    }

    public abstract void onExit(Object obj);

    public abstract void onProgress(int i, int i2);

    public void onReader(Object obj) {
        updateLog(obj, "#00cc55");
    }

    public void onReaderMsg(Object obj) {
        if (obj != null) {
            String strTrim = obj.toString().trim();
            if (!Pattern.matches("^progress:\\[[\\-0-9\\\\]{1,}/[0-9\\\\]{1,}]$", strTrim)) {
                onReader(obj);
            } else {
                String[] strArrSplit = strTrim.substring(10, strTrim.indexOf("]")).split("/");
                onProgress(Integer.parseInt(strArrSplit[0]), Integer.parseInt(strArrSplit[1]));
            }
        }
    }

    public abstract void onStart(Object obj);

    public abstract void onStart(Runnable runnable);

    public void onWrite(Object obj) {
        updateLog(obj, "#808080");
    }

    public abstract void updateLog(SpannableString spannableString);

    public void updateLog(Object obj, int i) {
        if (obj != null) {
            String string = obj.toString();
            SpannableString spannableString = new SpannableString(string);
            spannableString.setSpan(new ForegroundColorSpan(i), 0, string.length(), 33);
            updateLog(spannableString);
        }
    }

    public void updateLog(Object obj, String str) {
        if (obj != null) {
            String string = obj.toString();
            SpannableString spannableString = new SpannableString(string);
            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor(str)), 0, string.length(), 33);
            updateLog(spannableString);
        }
    }
}
