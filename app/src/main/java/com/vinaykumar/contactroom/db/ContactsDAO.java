package com.vinaykumar.contactroom.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface ContactsDAO {


    @Insert
    long addContact(Contacts contacts);

    @Query("SELECT * FROM contacts_table")
    List<Contacts> getAllContacts();

    @Update
    void updateContact(Contacts contacts);

    @Delete
    void deleteContact(Contacts contacts);

    @Query("SELECT * FROM contacts_table where contact_id==:contactId")
     Contacts getContact(long contactId);



}