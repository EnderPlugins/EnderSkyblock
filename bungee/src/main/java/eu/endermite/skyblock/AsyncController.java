package eu.endermite.skyblock;

import codes.dashiell.standard.Callback;

import java.util.Set;

public interface AsyncController<T> {

    void getAll(Callback<Set<T>> callback);

}
