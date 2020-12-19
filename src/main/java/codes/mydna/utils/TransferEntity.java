package codes.mydna.utils;

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

    enum Status {

        OK (200),
        BAD_REQUEST(400),
        NOT_FOUND(404),
        INTERNAL_SERVER_ERROR(500);

        private int statusCode;

        Status(int statusCode){
            this.statusCode = statusCode;
        }

        public int getStatusCode() {
            return statusCode;
        }

        public void setStatusCode(int statusCode) {
            this.statusCode = statusCode;
        }
    }

}
