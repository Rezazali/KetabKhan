package com.book.fidibo.requestBody;

public interface IResponseListener {

    void onSuccess(Object ResponseMessage);

    void onFailure(String errorResponseMessage);

}
