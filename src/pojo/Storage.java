package pojo;



/**
 * @author Xbin
 * @date 2020/7/2
 *
 */
public class Storage {
    private int storageNo;
    private String storageName;
    private String storageAddress;
    private int capacity;
    private int cordon;
    private int currentStorage;

    public Storage() {
        super();
    }

    public Storage(int storageNo, String storageName, String storageAddress, int capacity, int cordon, int currentStorage) {
        this.storageNo = storageNo;
        this.storageName = storageName;
        this.storageAddress = storageAddress;
        this.capacity = capacity;
        this.cordon = cordon;
        this.currentStorage = currentStorage;
    }

    public int getStorageNo() {
        return storageNo;
    }

    public void setStorageNo(int storageNo) {
        this.storageNo = storageNo;
    }

    public String getStorageName() {
        return storageName;
    }

    public void setStorageName(String storageName) {
        this.storageName = storageName;
    }

    public String getStorageAddress() {
        return storageAddress;
    }

    public void setStorageAddress(String storageAddress) {
        this.storageAddress = storageAddress;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCordon() {
        return cordon;
    }

    public void setCordon(int cordon) {
        this.cordon = cordon;
    }

    public int getCurrentStorage() {
        return currentStorage;
    }

    public void setCurrentStorage(int currentStorage) {
        this.currentStorage = currentStorage;
    }
}
