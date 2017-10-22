package next_book_web_scrapper.entity;

import java.io.Serializable;

public abstract class BaseEntity{

    public abstract int getId();


    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }

        if(!(obj instanceof BaseEntity)) {
            return false;
        }

        if (getId() != ((BaseEntity) obj).getId()) {
            return false;
        }

        return true;
    }

    @Override
    public abstract String toString();
}
