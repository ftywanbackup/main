package seedu.address.model;

import java.util.function.Predicate;

import javafx.collections.ObservableList;
import seedu.address.model.admin.Admin;
import seedu.address.model.admin.Username;
import seedu.address.model.job.Job;
import seedu.address.model.machine.Machine;
import seedu.address.model.person.Person;

/**
 * The API of the Model component.
 */
public interface Model {
    /** {@code Predicate} that always evaluate to true */
    Predicate<Person> PREDICATE_SHOW_ALL_PERSONS = unused -> true;

    /** {@code Predicate} that always eveluate to true for machines */
    Predicate<Machine> PREDICATE_SHOW_ALL_MACHINES = unused -> true;

    /** {@code Predicate} that always eveluate to true for jobs */
    Predicate<Job> PREDICATE_SHOW_ALL_JOBS = unused -> true;

    /** Clears existing backing model and replaces with the provided new data. */
    void resetData(ReadOnlyAddressBook newData);

    /** Returns the AddressBook */


    ReadOnlyAddressBook getAddressBook();

    /**
     * Returns true if a person with the same identity as {@code person} exists in the address book.
     */
    boolean hasPerson(Person person);

    /**
     * Deletes the given person.
     * The person must exist in the address book.
     */
    void deletePerson(Person target);

    /**
     * Adds the given person.
     * {@code person} must not already exist in the address book.
     */
    void addPerson(Person person);

    /**
     * Replaces the given person {@code target} with {@code editedPerson}.
     * {@code target} must exist in the address book.
     * The person identity of {@code editedPerson} must not be the same as another existing person in the address book.
     */
    void updatePerson(Person target, Person editedPerson);

    /**
     * Adds the given machine
     * Machine must not exists
     */
    void addMachine(Machine machine);

    /**
     * Removes the given machine
     * machine must exist in the database
     */
    void removeMachine(Machine machine);

    /**
     * Adds the given job
     * Job must not exists
     */
    void addJob(Job job);

    /**
     * Replaces the given job {@code target} with {@code editedJob}.
     * {@code target} must exist in the address book.
     * The job identity of {@code editedJob} must not be the same as another existing job in the address book.
     */
    void updateJob(Job target, Job editedJob);

    /**
     * Removes the given job
     * Job must exist in the database
     */
    void removeJob(Job job);

    /**
     * Adds the given Admin
     * admin must not exist
     * @param admin
     */
    void addAdmin(Admin admin);

    /**
     * Removes the given Admin
     * admin must exist in the database
     * @param admin
     */
    void removeAdmin(Admin admin);

    /**
     * Updates the admin
     * admin must be present in data
     * updatedAdmin must be different from admin
     * @param admin
     * @param updatedAdmin
     */
    void updateAdmin(Admin admin, Admin updatedAdmin);

    /**
     * sets loginStatus to true
     */
    void setLogin(Username username);

    /**
     * sets loginStatus to false
     */
    void clearLogin();

    /**
     * Returns loginStatus
     */
    boolean isLoggedIn();

    /**
     * Returns the current logged in admin
     */
    Username currentlyLoggedIn();

    /**
     * Returns true if an admin with the same identity as {@code admin} exists in the address book.
     */
    boolean hasAdmin(Admin admin);

    Admin findAdmin(Username username);

    int numAdmins();

    /** Returns an unmodifiable view of the filtered person list */
    ObservableList<Person> getFilteredPersonList();

    /**
     * Updates the filter of the filtered person list to filter by the given {@code predicate}.
     * @throws NullPointerException if {@code predicate} is null.
     */
    void updateFilteredPersonList(Predicate<Person> predicate);

    /** Returns an unmodifiable view of the filtered machine list */
    ObservableList<Machine> getFilteredMachineList();

    /**
     * Updates the filtere of the filtered machine list to filter by the given {@code predicate}.
     * @throws NullPointerException if {@code predicate} is null.
     */
    void updateFilteredMachineList(Predicate<Machine> predicate);

    /** Returns an unmodifiable view of the filtered job list */
    ObservableList<Job> getFilteredJobList();

    /**
     * Updates the filtere of the filtered job list to filter by the given {@code predicate}.
     * @throws NullPointerException if {@code predicate} is null.
     */
    void updateFilteredJobList(Predicate<Job> predicate);

    /**
     * Returns true if the model has previous address book states to restore.
     */
    boolean canUndoAddressBook();

    /**
     * Returns true if the model has undone address book states to restore.
     */
    boolean canRedoAddressBook();

    /**
     * Restores the model's address book to its previous state.
     */
    void undoAddressBook();

    /**
     * Restores the model's address book to its previously undone state.
     */
    void redoAddressBook();

    /**
     * Saves the current address book state for undo/redo.
     */
    void commitAddressBook();
}
