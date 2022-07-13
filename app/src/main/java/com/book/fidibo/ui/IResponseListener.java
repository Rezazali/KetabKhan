package com.book.fidibo.ui;

public interface IResponseListener {

    void onSuccess(Object ResponseMessage);

    void onFailure(String errorResponseMessage);

}
