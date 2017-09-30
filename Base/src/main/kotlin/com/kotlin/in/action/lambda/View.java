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
}
