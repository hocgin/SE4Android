package in.hocg.app.core.net;

/**
 * Created by hocgin on 16-5-25.
 */
public interface NetChangeObserver {
    /**
     * when network connected callback
     */
    void onNetConnected(NetUtils.NetType type);

    /**
     *  when network disconnected callback
     */
    void onNetDisConnect();
}
