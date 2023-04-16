package case_study_Enjoy_Galaxy.model.entity.seat.abstraction;

import case_study_Enjoy_Galaxy.model.general_abstraction.ICapacity;
import case_study_Enjoy_Galaxy.model.general_abstraction.IPrice;

public abstract class Seat implements ISeat, IPrice, ICapacity {
    private long id;
    private String type;
    private long idShowtime;
    private String code;
    private boolean isEmpty = true;

    public Seat(String code) {
        this.code = code;
    }

    public Seat(long id, String type, String code, boolean isEmpty, long idShowtime) {
        this.id = id;
        this.type = type;
        this.idShowtime = idShowtime;
        this.code = code;
        this.isEmpty = isEmpty;
    }

    public Seat(String type, long idShowtime, String code, boolean isEmpty) {
        this.type = type;
        this.idShowtime = idShowtime;
        this.code = code;
        this.isEmpty = isEmpty;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdShowtime() {
        return idShowtime;
    }

    public void setIdShowtime(long idShowtime) {
        this.idShowtime = idShowtime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setEmpty(boolean empty) {
        this.isEmpty = empty;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return getCode();
    }
}
