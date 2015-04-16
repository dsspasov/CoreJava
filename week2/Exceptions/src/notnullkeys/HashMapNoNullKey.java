package notnullkeys;

import java.util.HashMap;

@SuppressWarnings("serial")
public class HashMapNoNullKey<K, V> extends HashMap<K, V> {

    private boolean isAllowedNullKey;

    HashMapNoNullKey() {
        super();
        this.setAllowedNullKey(false);
    }

    HashMapNoNullKey(boolean isAllowed) {
        super();
        this.setAllowedNullKey(isAllowed);
    }

    public boolean isAllowedNullKey() {
        return isAllowedNullKey;
    }

    public void setAllowedNullKey(boolean isAllowedNullKey) {
        this.isAllowedNullKey = isAllowedNullKey;
    }

    @Override
    public V put(K key, V value) {
        if (!this.isAllowedNullKey && key.equals(null)) {
            throw new IllegalNullKeyException();
        } else {
            return super.put(key, value);
        }
    }

    @Override
    public V get(Object key) {
        if (!this.isAllowedNullKey && key.equals(null)) {
            throw new IllegalNullKeyException();
        } else {
            return super.get(key);
        }

    }
}
