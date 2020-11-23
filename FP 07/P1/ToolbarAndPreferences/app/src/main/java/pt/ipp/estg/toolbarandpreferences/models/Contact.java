package pt.ipp.estg.toolbarandpreferences.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Contact {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name="name")
    public String Name;

    @ColumnInfo(name="phone_number")
    public String PhoneNumber;

    public Contact(String Name, String PhoneNumber) {
        this.Name = Name;
        this.PhoneNumber = PhoneNumber;
    }
}
