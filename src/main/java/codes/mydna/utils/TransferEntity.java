package codes.mydna.utils;

import codes.mydna.status.EntityStatus;

public class TransferEntity<E> {
    private E entity;
    private EntityStatus entityStatus;

    public E getEntity() {
        return entity;
    }

    public void setEntity(E entity) {
        this.entity = entity;
    }

    public EntityStatus getEntityStatus() {
        return entityStatus;
    }

    public void setEntityStatus(EntityStatus entityStatus) {
        this.entityStatus = entityStatus;
    }
}
