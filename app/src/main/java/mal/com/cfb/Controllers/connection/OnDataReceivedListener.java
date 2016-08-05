package mal.com.cfb.Controllers.connection;

/**
 * Created by user on 8/5/16.
 */

public interface OnDataReceivedListener<T>{

    void onRequestSuccessWithData (T data);

    void onRequestFailed (String error);
}
