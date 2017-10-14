package com.kotlin.in.action.lambda;

public class View {
    private OnClickListener listener;

    interface OnClickListener {

        void onClick(View view);
    }

    protected void setOnclickListener(OnClickListener listener) {
        this.listener = listener;
        listener.onClick(this);
    }

    protected void postDelay(long ms, Runnable r) {
        try {
            Thread.sleep(ms);
            r.run();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
