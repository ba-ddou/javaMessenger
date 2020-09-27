package Observer;

import dp.Message;

public interface Observer {

    public abstract void onUpdate(Message msg);
}