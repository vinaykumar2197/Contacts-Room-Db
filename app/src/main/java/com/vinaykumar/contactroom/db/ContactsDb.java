package com.vinaykumar.contactroom.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {Contacts.class},version = 1)
public abstract class ContactsDb extends RoomDatabase {

    public abstract ContactsDAO getContactsDAO();

}
