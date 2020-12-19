package codes.mydna.utils;

import codes.mydna.status.Status;

public class TransferEntity<E> {

    private E entity;
    private Status status;

    public E getEntity() {
        return entity;
    }

    public void setEntity(E entity) {
        this.entity = entity;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getStatusCode() {
        return (status == null)
                ? -1
                : status.getStatusCode();
    }

}
