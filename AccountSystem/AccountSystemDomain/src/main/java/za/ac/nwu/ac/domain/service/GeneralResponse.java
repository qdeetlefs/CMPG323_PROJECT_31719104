package za.ac.nwu.ac.domain.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import za.ac.nwu.ac.domain.persistence.AccountType;

import java.io.Serializable;
import java.util.Objects;

public class GeneralResponse<T> implements Serializable {

    private static final Logger LOGGER = LoggerFactory.getLogger(GeneralResponse.class);

    private static final long serialVersionUID = -6511059914485318226L;

    private final boolean successful;
    private final transient T payload;

    public GeneralResponse(boolean successful, T payload)
    {
        this.successful = successful;
        this.payload = payload;
    }

    public boolean IsSuccessful() {return successful;}

    public T getPayload() {return payload;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GeneralResponse<?> that = (GeneralResponse<?>) o;
        return successful == that.successful && Objects.equals(payload, that.payload);
    }

    @Override
    public int hashCode() {
        return Objects.hash(successful, payload);
    }

    @Override
    public String toString() {
        return "GeneralResponse{" +
                " successful= " + successful +
                ", payload=" + payload +
                '}';
    }
}
